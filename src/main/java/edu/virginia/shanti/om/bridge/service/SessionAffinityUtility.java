package edu.virginia.shanti.om.bridge.service;

import java.net.MalformedURLException;
import java.net.URL;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import edu.virginia.shanti.om.bridge.domain.Bridge;

public class SessionAffinityUtility {

	private static Log log = LogFactory.getLog(SessionAffinityUtility.class);

	public static 
	SessionAffinity constructSessionAffinity(Bridge bridge, CurrentUser currentUser) {
		String sakaisession = (String) currentUser
				.getAuthentication().getCredentials();

		if (sakaisession == null || sakaisession.length()==0) {
			throw new RuntimeException ("No sakaisession present!");
		}

		log.info("sakaisession = " + sakaisession);

		String[] split = sakaisession.split("\\.",2);

		if (split.length < 2) {
			throw new RuntimeException ("sakaisession format exception!  Expected server extension. " + sakaisession );
		}
		String session = split[0];
		String server = "collab-dev.its.virginia.edu";   //  DEFAULT FALLBACK VALUE
		try {
			server = new URL(bridge.getRemoteContext().getUrl()).getHost();
		} catch (MalformedURLException murle) {
			log.error(murle.getStackTrace());
		}
		String lbCookieValue = split[1];

		log.info(bridge);
		log.info("server = " + server);
		log.info("sakaisession = " + session);
		log.info("affinityid = " + lbCookieValue);

		SessionAffinity aff = new SessionAffinityImpl(server,session,lbCookieValue);
		return aff;
	}

}
