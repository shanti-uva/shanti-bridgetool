package edu.virginia.shanti.om.bridge.service;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

import org.apache.axis.client.Stub;
import org.apache.axis.transport.http.HTTPConstants;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.core.GrantedAuthority;

public class SessionAffinityUtility {

	private static Log log = LogFactory.getLog(SessionAffinityUtility.class);
	
	public static 
	SessionAffinity constructSessionAffinity(CurrentUser currentUser) {
		String sakaisession = (String) currentUser
				.getAuthentication().getCredentials();
		String[] ret = extractSessionAffinity(currentUser);
		String sessionFromUser = ret[0];
		String sakaiBaseUrl = ret[1];
		String affinityFromUser = ret[2];
		String server = null;
		try {
			server = new URL(sakaiBaseUrl).getHost();
		} catch (MalformedURLException e) {
			throw new RuntimeException(e);
		}		
		if (sakaisession == null || sakaisession.length()==0) {
			// Fall back to sessionFromUser?
			if (sessionFromUser != null && sessionFromUser.length() != 0) {
				sakaisession = sessionFromUser;
			} else {
				throw new RuntimeException ("No sakaisession found!");
			}
		}

		log.info("sakaisession = " + sakaisession);

		String[] split = sakaisession.split("\\.",2);

		if (split.length < 2) {
			throw new RuntimeException ("sakaisession format exception!  Expected server extension. " + sakaisession );
		}
		String session = split[0];
		String lbCookieValue = (split.length==2)?split[1]:affinityFromUser ;
		log.info("constructSessionAffinity server = " + server);
		log.info("constructSessionAffinity sakaisession = " + sakaisession);
		log.info("constructSessionAffinity affinityid = " + lbCookieValue);

		SessionAffinity aff = new SessionAffinityImpl(server,sakaisession,lbCookieValue);
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
		String affinityid = sessionstring.split("\\.")[1];
		String hostUrl = parts[2];
		
		String[] ret = new String[] { sessionstring, hostUrl, affinityid };		
		log.info("extractSessionAffinity Returning: " + Arrays.toString(ret));		
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
