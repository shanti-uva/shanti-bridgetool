/**
 * 
 */
package edu.virginia.shanti.om.bridge.service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.converter.json.MappingJacksonHttpMessageConverter;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.stereotype.Component;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;


/**
 * @author ys2n
 * 
 */
@RooJavaBean
@Component
// @Scope(value = "request", proxyMode = ScopedProxyMode.INTERFACES)
public class AdminUserImpl implements AdminUser {
	
	Logger log = LoggerFactory.getLogger(AdminUserImpl.class);

	@JsonIgnoreProperties(ignoreUnknown = true)
	public class SakaiSession {

		@JsonProperty
		private String id, eid;

		public String getEid() {
			return eid;
		}

		public String getId() {
			return id;
		}

		public void setEid(String eid) {
			this.eid = eid;
		}

		public void setId(String id) {
			this.id = id;
		}
		
	}

	@JsonIgnoreProperties(ignoreUnknown = true)
	public class SessionJson {
		
		@JsonProperty
		SakaiSession[] session_collection;

		public SakaiSession[] getSession_collection() {
			return session_collection;
		}

		public void setSession_collection(SakaiSession[] session_collection) {
			this.session_collection = session_collection;
		}
		
		public String getId() {
			return session_collection[0].getId();
		}
		
		public String getEid() {
			return session_collection[0].getEid();
		}

	}

	private Authentication authentication;
	
	@Autowired
	private CurrentUser currentUser;
	
	private RestTemplate restTemplate = new RestTemplate();
	
	@Value("${sakaiAdminPassword}")
	private String sakaiAdminPassword;
	
	@Value("${sakaiAdminUser}")
	private String sakaiAdminUser;
	
	public AdminUserImpl() {
				
		restTemplate.getMessageConverters().add(new MappingJacksonHttpMessageConverter());
		
		log.warn("HELLO");
		
	}
	
	private Authentication authenticate() {
		
		System.err.println(currentUser);
		
		String usersession = (String)currentUser.getAuthentication().getCredentials();
		
		String[] parts = usersession.split("\\.");
		
		if (parts.length != 2) {
			throw new RuntimeException("can't authenticate without a current user session.");
		}
		String serverId = parts[1];
		
		String server = serverId + ".itc.virginia.edu";
		
		Map<String, String> vars = new HashMap<String, String>();
		vars.put("server", server);		
		vars.put("username", sakaiAdminUser);
		vars.put("password", sakaiAdminPassword);
		
		String session = restTemplate.postForObject("https://{server}/direct/session/new.json?_username={username}&_password={password}", null, String.class, vars);
		
		String sessionString = session + "." + serverId;
		
		Authentication auth = new UsernamePasswordAuthenticationToken(sakaiAdminUser,sessionString, Arrays.asList(new GrantedAuthority[] { new GrantedAuthorityImpl("sakaiAdmin") }));

		return auth;
	}

	public synchronized Authentication getAuthentication() {
		
		if (authentication == null || !verifyAuthentication(authentication)) {
			authentication = authenticate();
		}	
		
		return authentication;
	}

	private boolean verifyAuthentication(Authentication auth) {
		
		String sessionString = (String)auth.getCredentials();
		String[] parts = sessionString.split("\\.");
		
		if (parts.length != 2) {
			throw new IllegalArgumentException(" session string must contain a \'.\':  sessionString was " + sessionString);
		}
		
		String session = parts[0];
		String server = parts[1] + ".itc.virginia.edu";
		Map<String, String> vars = new HashMap<String,String>();
		vars.put("server", server);
		
		try {
			restTemplate.getForObject("https://{server}/direct/session", SessionJson.class , vars);
		} catch (Exception e) {
			log.warn ("Session verification rest call failed: " + e);
		}
		return false;
	}
	
	
	

}
