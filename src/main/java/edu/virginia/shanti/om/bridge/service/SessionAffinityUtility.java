package edu.virginia.shanti.om.bridge.service;

import java.net.MalformedURLException;
import java.net.URL;

import org.apache.axis.client.Stub;
import org.apache.axis.transport.http.HTTPConstants;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import edu.virginia.shanti.om.bridge.domain.Bridge;

public class SessionAffinityUtility {

	private static Log log = LogFactory.getLog(SessionAffinityUtility.class);

	public static 
	SessionAffinity constructSessionAffinity(Bridge bridge, CurrentUser currentUser) {
		String server = "collab-dev.its.virginia.edu";
		try {
			server = new URL(bridge.getRemoteContext().getUrl()).getHost();
		} catch (MalformedURLException murle) {
			log.error(murle.getStackTrace());
		}
		return SessionAffinityUtility.constructSessionAffinity(server, currentUser);
	}
	
	public static 
	SessionAffinity constructSessionAffinity(String server, CurrentUser currentUser) {
		String sakaisession = (String) currentUser
				.getAuthentication().getCredentials();
		
		log.info("Authentication: " + (String) currentUser
		.getAuthentication().toString());
		
		log.info("Authorities: " + currentUser.getAuthentication().getAuthorities().toString());

		if (sakaisession == null || sakaisession.length()==0) {
			throw new RuntimeException ("No sakaisession present!");
		}

		log.info("sakaisession = " + sakaisession);

		String[] split = sakaisession.split("\\.",2);

		if (split.length < 2) {
			throw new RuntimeException ("sakaisession format exception!  Expected server extension. " + sakaisession );
		}
		String session = split[0];
		String lbCookieValue = split[1];
		log.info("server = " + server);
		log.info("sakaisession = " + session);
		log.info("affinityid = " + lbCookieValue);

		SessionAffinity aff = new SessionAffinityImpl(server,session,lbCookieValue);
		return aff;
	}

	public static void setConnectionAffinity(SessionAffinity aff, Object stub) {
			if (!(stub instanceof Stub)) {
				throw new RuntimeException("Could not cast Object to Stub: " + stub.toString());
			}
		
			log.info("using AFFINITYID: " + aff.getAffinityId());
			log.info("using JSESSIONID: " + aff.getSession());
			((Stub)stub)._setProperty(HTTPConstants.HEADER_COOKIE, "AFFINITYID=" + aff.getAffinityId() + ";" + "JSESSIONID=" + aff.getSession());
	}
	
	public static void setConnectionAffinity(Bridge bridge, CurrentUser currentUser, Object stub) {
		SessionAffinity aff = constructSessionAffinity(bridge, currentUser);
		setConnectionAffinity(aff, stub);
	}
	
	public static void setConnectionAffinity(String host, CurrentUser currentUser, Object stub) {
		SessionAffinity aff = constructSessionAffinity(host, currentUser);
		setConnectionAffinity(aff, stub);
	}

}
