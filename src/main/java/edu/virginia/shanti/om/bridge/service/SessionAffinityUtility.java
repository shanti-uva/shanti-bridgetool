package edu.virginia.shanti.om.bridge.service;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Collection;
import java.util.Iterator;

import org.apache.axis.client.Stub;
import org.apache.axis.transport.http.HTTPConstants;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.core.GrantedAuthority;

import edu.virginia.shanti.om.bridge.domain.Bridge;

public class SessionAffinityUtility {

	private static Log log = LogFactory.getLog(SessionAffinityUtility.class);
	
	public static 
	SessionAffinity constructSessionAffinity(CurrentUser currentUser) {
		String sakaisession = (String) currentUser
				.getAuthentication().getCredentials();
		
		
		// TODO:  REFACTOR THIS SHIT!
		String[] ret = extractSessionAffinity(currentUser);
		String sakaiBaseUrl = ret[1];
		
		log.info("Return: " +  ret);
		
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
		log.info("server = " + sakaiBaseUrl);
		log.info("sakaisession = " + session);
		log.info("affinityid = " + lbCookieValue);

		SessionAffinity aff = new SessionAffinityImpl(sakaiBaseUrl,session,lbCookieValue);
		return aff;
	}

	/**
	 * @param currentUser
	 * @return String[]: [ sessionString, sakaiHostUrl ]
	 */
	private static String[] extractSessionAffinity(CurrentUser currentUser) {
		log.info("Authentication: " + (String) currentUser
		.getAuthentication().toString());
		
		log.info("Authorities: " + currentUser.getAuthentication().getAuthorities().toString());
		
		Collection<GrantedAuthority> authorities = currentUser.getAuthentication().getAuthorities();
		
		Iterator<GrantedAuthority> iterator = authorities.iterator();
		
		String grants = null;
		while(iterator.hasNext()) {
			GrantedAuthority grant = iterator.next();
			String authority = grant.getAuthority();
			if (authority.startsWith("sakaisession#")) {
				grants = authority;
				break;
			}
		}
		
		String[] parts = grants.split("#");
		String sessionstring = parts[1];
		String hostUrl = parts[2];
		
		String[] ret = new String[] { sessionstring, hostUrl };
		return ret;
	}

	public static void setConnectionAffinity(SessionAffinity aff, Object stub) {
			if (!(stub instanceof Stub)) {
				throw new RuntimeException("Could not cast Object to Stub: " + stub.toString());
			}
		
			log.info("using AFFINITYID: " + aff.getAffinityId());
			log.info("using JSESSIONID: " + aff.getSession());
			((Stub)stub)._setProperty(HTTPConstants.HEADER_COOKIE, "AFFINITYID=" + aff.getAffinityId());
			((Stub)stub)._setProperty(HTTPConstants.HEADER_COOKIE2, "AFFINITYID=" + aff.getAffinityId() + ";" + "JSESSIONID=" + aff.getSession());
	}
	
	public static void setConnectionAffinity(CurrentUser currentUser, Object stub) {
		SessionAffinity aff = constructSessionAffinity(currentUser);
		setConnectionAffinity(aff, stub);
	}
	
}
