package edu.virginia.shanti.om.bridge.auth;

import java.util.HashSet;
import java.util.Set;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.AuthenticationUserDetailsService;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class UserDetailsService implements AuthenticationUserDetailsService{

	@Override
	public UserDetails loadUserDetails(Authentication auth)
			throws UsernameNotFoundException {
		
		Set<GrantedAuthority> grants = new HashSet<GrantedAuthority>();
		
		boolean enabled = true;
		boolean notExpired = true;
		boolean passwordNotExpired = true;
		boolean acctNotLocked = true;
		UserDetails userDetails = new User(auth.getName(),(String) auth.getCredentials(), enabled, notExpired, passwordNotExpired, acctNotLocked, grants);
		
		return userDetails;
	}

}
