package edu.virginia.shanti.om.bridge.service;

import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.RemoteException;
import java.util.List;

import javax.xml.rpc.ServiceException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.roo.addon.serializable.RooSerializable;
import org.springframework.roo.addon.tostring.RooToString;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.virginia.shanti.om.bridge.domain.Bridge;
import edu.virginia.shanti.om.bridge.domain.SiteAlias;
import edu.virginia.shanti.om.bridge.soap.sakai.SakaiScriptServiceLocator;
import edu.virginia.shanti.om.bridge.soap.sakai.SakaiScript_PortType;

@RooToString
@RooSerializable
@Service
public class SiteAliasService {

	private static final long serialVersionUID = 1304429105643786376L;

	transient private SakaiScriptServiceLocator sakaiScriptServiceLocator = new SakaiScriptServiceLocator();

	@Autowired
	private SitePropertyService sitePropertyService;
	
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

	public SiteAlias findSiteAliasBySiteId(String siteId) {
		List<SiteAlias> list = SiteAlias.findSiteAliasesBySiteId(siteId)
				.getResultList();
		try {
			SiteAlias siteAlias = checkSiteAliasReturn(list);
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
		StringBuilder sb = new StringBuilder("~collab:" + title.replaceAll("\\W+","-")
				.replaceAll("&", "and").toLowerCase());
		sb.append("-");
		sb.append(siteId.substring(0, 4));
		return sb.toString();

	}

	public SiteAlias suggestSiteAlias(String siteId) {
		// TODO: Refactor
		// push this into a different service (new one named SitePropertyService?)

		String sakaisession = (String) SecurityContextHolder.getContext()
				.getAuthentication().getCredentials();

		String[] split = sakaisession.split("\\.");
		String session = split[0];
		String server = split[1] + ".itc.virginia.edu";

		try {
			SakaiScript_PortType sakaiScript = sakaiScriptServiceLocator
					.getSakaiScript(new URL("https://" + server
							+ "/sakai-axis/SakaiScript.jws"));
			String title = sakaiScript.getSiteTitle(session, siteId);
			String suggestion = suggestSiteAliasString(title, siteId);
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

	public void registerAlias(SiteAlias siteAlias, String service) {
		// TODO Refactor this out of this service class
		sitePropertyService.setSiteProperty(siteAlias.getSiteId(), "shib-" + service, siteAlias.getAlias());
	}

	public void registerAlias(SiteAlias siteAlias, Bridge bridge) {
		System.err.println("Registering alias " + siteAlias + " for bridge remoteName: " + bridge.getRemoteName());
		registerAlias(siteAlias, bridge.getRemoteName());
	}

}
