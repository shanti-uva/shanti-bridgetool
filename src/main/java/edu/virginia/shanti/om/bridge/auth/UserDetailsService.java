package edu.virginia.shanti.om.bridge.auth;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.AuthenticationUserDetailsService;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserDetailsService implements AuthenticationUserDetailsService {

	private Log log = LogFactory.getLog(AuthenticationUserDetailsService.class);
	private static final boolean ENABLED = true;
	private static final boolean NOT_EXPIRED = true;
	private static final boolean PASSWORD_NOT_EXPIRED = true;
	private static final boolean ACCT_NOT_LOCKED = true;
	Map<String, Set<GrantedAuthority>> storedGrants = Collections
			.synchronizedMap(new HashMap<String, Set<GrantedAuthority>>());

	@Override
	public UserDetails loadUserDetails(Authentication auth)
			throws UsernameNotFoundException {

		Set<GrantedAuthority> grants = getGrants(auth.getName());
		UserDetails userDetails = new User(auth.getName(),
				(String) auth.getCredentials(), ENABLED, NOT_EXPIRED,
				PASSWORD_NOT_EXPIRED, ACCT_NOT_LOCKED, grants);

		return userDetails;
	}

	public void saveGrant(String user, GrantedAuthority grant) {

		// should be careful to do this in a thread-safe manner
		if (!storedGrants.containsKey(user)) {
			storedGrants.put(user, new HashSet<GrantedAuthority>());
		}
		
		log.info ("Grant " + grant + " stored for " + user);
		// check the returned boolean?
		storedGrants.get(user).add(grant);

	}

	public Set<GrantedAuthority> getGrants(String user) {

		// should be careful to do this in a thread-safe manner
		if (!storedGrants.containsKey(user)) {
			storedGrants.put(user, new HashSet<GrantedAuthority>());
		}
		
		Set<GrantedAuthority> grants = storedGrants.get(user);
		log.info("Return Grants  " + grants + " for " + user);
		return grants;
	}

}
