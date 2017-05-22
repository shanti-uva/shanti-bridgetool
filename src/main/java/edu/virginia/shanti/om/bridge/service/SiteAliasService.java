package edu.virginia.shanti.om.bridge.service;

import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.RemoteException;
import java.util.List;

import javax.xml.rpc.ServiceException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.roo.addon.serializable.RooSerializable;
import org.springframework.roo.addon.tostring.RooToString;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.virginia.shanti.om.bridge.domain.Bridge;
import edu.virginia.shanti.om.bridge.domain.SiteAlias;
import edu.virginia.shanti.om.bridge.soap.sakai.SakaiScriptServiceLocator;
import edu.virginia.shanti.om.bridge.soap.sakai.SakaiScript_PortType;

@RooToString
@Service
public class SiteAliasService {

	private static final long serialVersionUID = 1304429105643786376L;

	static final String[] newterms = new String[] { "term0", "january", "spring",
			"term3", "term4", "term5", "summer", "term7", "fall" };
	
	static final String[] oldterms = new String[] { "oldterm0", "spring", "summer",
		"fall", "oldterm4", "oldterm5", "oldterm6", "oldterm7", "oldterm8" };

	transient private SakaiScriptServiceLocator sakaiScriptServiceLocator = new SakaiScriptServiceLocator();

	@Autowired
	private SitePropertyService sitePropertyService;

	@Autowired
	private CurrentUser currentUser;

	public String getAliasForSiteId(String siteId) {
		SiteAlias siteAlias = findSiteAliasBySiteId(siteId);
		if (siteAlias == null) {
			return null;
		}
		return siteAlias.getAlias();
	}

	public String getSiteIdForSiteAlias(String alias) {
		SiteAlias siteAlias = findSiteAliasBySiteAlias(alias);
		if (siteAlias == null) {
			return null;
		}
		return siteAlias.getSiteId();
	}

	// @Transactional
	public SiteAlias findSiteAliasBySiteId(String siteId) {
		List<SiteAlias> list = SiteAlias.findSiteAliasesBySiteId(siteId)
				.getResultList();
		try {
			SiteAlias siteAlias = checkSiteAliasReturn(list);
			if (siteAlias == null) {
				siteAlias = suggestSiteAlias(siteId);
				siteAlias.persist();
				System.err.println("generated alias: " + siteAlias);
			}
			return siteAlias;
		} catch (Exception e) {
			throw new RuntimeException("Problem getting SiteAlias for siteId="
					+ siteId + ": " + e.getMessage(), e);
		}
	}

	public SiteAlias findSiteAliasBySiteAlias(String alias) {
		List<SiteAlias> list = SiteAlias.findSiteAliasesByAlias(alias)
				.getResultList();
		try {
			SiteAlias siteAlias = checkSiteAliasReturn(list);
			return siteAlias;
		} catch (Exception e) {
			throw new RuntimeException("Problem getting SiteAlias for alias="
					+ alias + ": " + e.getMessage(), e);
		}
	}

	private SiteAlias checkSiteAliasReturn(List<SiteAlias> list) {
		SiteAlias siteAlias;
		if (list.isEmpty()) {
			siteAlias = null;
		} else if (list.size() > 1) {
			throw new RuntimeException("Too many SiteAliases returned.");
		} else {
			siteAlias = list.get(0);
		}
		return siteAlias;
	}

	@Transactional
	public void setAlias(String siteId, String alias) {
		SiteAlias siteAlias = findSiteAliasBySiteId(siteId);
		if (siteAlias == null) {
			siteAlias = new SiteAlias();
			siteAlias.setSiteId(siteId);
			siteAlias.setAlias(alias);
			siteAlias.persist();
		} else {
			siteAlias.setAlias(alias);
		}
	}

	public String suggestSiteAliasString(String title, String siteId) {

		// TODO: refactor this into an implementation class
		StringBuilder sb = new StringBuilder("~collab:"
				+ title.replaceAll("\\W+", "-").replaceAll("&", "and").replaceAll("\\-$", "")
						.toLowerCase());
		sb.append("-");
		sb.append(siteId.substring(0, 4));
		return sb.toString();

	}

	public SiteAlias suggestSiteAlias(String siteId) {
		// TODO: Refactor
		// push this into a different service (new one named
		// SitePropertyService?)

//		System.err.println("SakaiSession = " + sakaisession);
		
		String sakaisession = (String) currentUser.getAuthentication()
				.getCredentials();

		String[] split = sakaisession.split("\\.");
		String session = split[0];
		String server = "collab-dev.its.virginia.edu";  // TODO:  FIX THIS!

		try {
			SakaiScript_PortType sakaiScript = sakaiScriptServiceLocator
					.getSakaiScript(new URL("https://" + server
							+ "/sakai-ws/soap/sakai"));
			SessionAffinityUtility.setConnectionAffinity(currentUser, sakaiScript);
			
			String title = sakaiScript.getSiteTitle(session, siteId);
			String termEid = sakaiScript.getSiteProperty(session, siteId,
					"term_eid");

			String suggestion = suggestSiteAliasString(title, siteId);
			suggestion = addTerm(suggestion, termEid);

			SiteAlias siteAlias = new SiteAlias();
			siteAlias.setAlias(suggestion);
			siteAlias.setSiteId(siteId);
			return siteAlias;
		} catch (ServiceException e) {
			throw new RuntimeException(e);
		} catch (RemoteException e) {
			throw new RuntimeException(e);
		} catch (MalformedURLException e) {
			throw new RuntimeException(e);
		}

	}

	private String addTerm(String suggestion, String termEid) {
				
		if (termEid != null && !termEid.isEmpty()) {
			String term = parseTerm(termEid);
			suggestion = suggestion + ":" + term;
		}
		return suggestion;
	}

	private String parseTerm(String termEid) {
		
		String term = null;
		if (termEid.startsWith("1")) {
			// e.g. 1088
			// 1=January, 2=Spring, 6=Summer, 8=Fall
			int termint = Integer.parseInt(termEid);
			int year = 1900 + termint / 10;
			int tnum = termint % 10;
			term = newterms[tnum] + Integer.toString(year);
		} else if (termEid.startsWith("2") && termEid.contains("_")) {
			// example 2008_3
			// 1=Spring, 2=Summer, 3=Fall
			String[] parts = termEid.split("_");
			String year =parts[0];
			int tnum = Integer.parseInt(parts[1]);
			term = oldterms[tnum] + year;
		}

		return term;
	}

	public void registerAlias(SiteAlias siteAlias, String service) {
		// TODO Refactor this out of this service class
		sitePropertyService.setSiteProperty(siteAlias.getSiteId(), "shib-"
				+ service, siteAlias.getAlias());
	}

	public void registerAlias(SiteAlias siteAlias, Bridge bridge) {
		System.err.println("Registering alias " + siteAlias
				+ " for bridge remoteName: " + bridge.getRemoteName());
		registerAlias(siteAlias, bridge.getRemoteName());
	}

}
