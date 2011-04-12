package edu.virginia.shanti.om.bridge.service;

import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.RemoteException;
import java.util.List;

import javax.xml.rpc.ServiceException;

import org.junit.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.roo.addon.serializable.RooSerializable;
import org.springframework.roo.addon.tostring.RooToString;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.virginia.shanti.om.bridge.domain.SiteAlias;
import edu.virginia.shanti.om.bridge.soap.sakai.SakaiScriptServiceLocator;
import edu.virginia.shanti.om.bridge.soap.sakai.SakaiScript_PortType;

@RooToString
@RooSerializable
@Service
public class SitePropertyService {
	
	transient private SakaiScriptServiceLocator sakaiScriptServiceLocator = new SakaiScriptServiceLocator();
	
	public String getSiteProperty(String siteId, String propertyName) {

		String sakaisession = (String) SecurityContextHolder.getContext()
				.getAuthentication().getCredentials();

		String[] split = sakaisession.split("\\.");
		String session = split[0];
		String server = split[1] + ".itc.virginia.edu";

		try {
			SakaiScript_PortType sakaiScript = sakaiScriptServiceLocator
					.getSakaiScript(new URL("https://" + server
							+ "/sakai-axis/SakaiScript.jws"));
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

		String sakaisession = (String) SecurityContextHolder.getContext()
				.getAuthentication().getCredentials();

		String[] split = sakaisession.split("\\.");
		String session = split[0];
		String server = split[1] + ".itc.virginia.edu";

		try {
			SakaiScript_PortType sakaiScript = sakaiScriptServiceLocator
					.getSakaiScript(new URL("https://" + server
							+ "/sakai-axis/SakaiScript.jws"));
			sakaiScript.setSiteProperty(session, siteId, propertyName, value);

		} catch (ServiceException e) {
			throw new RuntimeException(e);
		} catch (RemoteException e) {
			throw new RuntimeException(e);
		} catch (MalformedURLException e) {
			throw new RuntimeException(e);
		}

	}

}
