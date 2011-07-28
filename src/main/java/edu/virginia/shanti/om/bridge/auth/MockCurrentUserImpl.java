package edu.virginia.shanti.om.bridge.auth;

import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.security.core.Authentication;

import edu.virginia.shanti.om.bridge.service.CurrentUser;

@RooJavaBean
public class MockCurrentUserImpl implements CurrentUser {

	Authentication authentication;

	public MockCurrentUserImpl() {
		super();
	}

	public MockCurrentUserImpl(Authentication authentication) {
		this();
		this.authentication = authentication;
	}

}
