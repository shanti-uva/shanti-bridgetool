package edu.virginia.shanti.om.bridge.service;

import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.RemoteException;

import javax.xml.rpc.ServiceException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.roo.addon.serializable.RooSerializable;
import org.springframework.roo.addon.tostring.RooToString;
import org.springframework.stereotype.Service;

import edu.virginia.shanti.om.bridge.soap.sakai.SakaiScriptServiceLocator;
import edu.virginia.shanti.om.bridge.soap.sakai.SakaiScript_PortType;

@RooToString
@RooSerializable
@Service
public class SitePropertyService {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8747725393377833067L;

	transient private SakaiScriptServiceLocator sakaiScriptServiceLocator = new SakaiScriptServiceLocator();

	 @Autowired
	 private AdminUser sakaiAdminUser;
	
	@Autowired
	private CurrentUser currentUser;
	
	private Log log = LogFactory.getLog(SitePropertyService.class);

	public String getSiteProperty(String siteId, String propertyName) {

		String sakaisession = (String) currentUser.getAuthentication()
				.getCredentials();
		
		String[] split = sakaisession.split("\\.");
		String session = split[0];
		SessionAffinity aff = SessionAffinityUtility.constructSessionAffinity(currentUser);
		String server = aff.getServer();

		try {
			SakaiScript_PortType sakaiScript = sakaiScriptServiceLocator
					.getSakaiScript(new URL("https://" + server
							+ "/sakai-axis/SakaiScript.jws"));
			SessionAffinityUtility.setConnectionAffinity(aff, sakaiScript);			
			return sakaiScript.getSiteProperty(session, siteId, propertyName);

		} catch (ServiceException e) {
			throw new RuntimeException(e);
		} catch (RemoteException e) {
			throw new RuntimeException(e);
		} catch (MalformedURLException e) {
			throw new RuntimeException(e);
		}

	}

	public void setSiteProperty(String siteId, String propertyName, String value) {

		String adminsecret = (String) sakaiAdminUser
				.getAuthentication().getCredentials();
		
		String sakaisession = (String) currentUser
		.getAuthentication().getCredentials();

		String[] split = sakaisession.split("\\.");
		String session = split[0];
//		String session = sakaisession;
		SessionAffinity aff = SessionAffinityUtility.constructSessionAffinity(currentUser);
		String server = aff.getServer(); 
		String paramDebug = "DEBUG INFO: "
				+ "\n\taffinity = " + aff
				+ "\n\tsession = " + session
				+ "\n\tserver = " + server
//				+ "\n\tadminsecret = (" + adminsecret.length() + " chars) "
				+ "\n\tadminsecret = " + adminsecret
				+ "\n\tsiteId = " + siteId
				+ "\n\tvalue = " + value
				+ "\n\tsakaisession = " + sakaisession;
		log.info(paramDebug);
		try {
			SakaiScript_PortType sakaiScript = sakaiScriptServiceLocator
					.getSakaiScript(new URL("https://" + server
							+ "/sakai-ws/soap/sakai"));
			SessionAffinityUtility.setConnectionAffinity(aff, sakaiScript);
			
			// sakaiScript.setSiteProperty(session, siteId, propertyName, value);
			sakaiScript.setSitePropertyAlt(session, adminsecret, siteId, propertyName, value);

		} catch (ServiceException e) {
			throw new RuntimeException("service failure: " + paramDebug, e);
		} catch (RemoteException e) {
			
			
			throw new RuntimeException("remote failure: " + e.getMessage() + " "+ paramDebug, e);
		} catch (MalformedURLException e) {
			throw new RuntimeException("url problem: " + paramDebug, e);
		}

	}

}
