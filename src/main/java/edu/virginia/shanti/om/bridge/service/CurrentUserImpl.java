/**
 * 
 */
package edu.virginia.shanti.om.bridge.service;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

/**
 * @author ys2n
 * 
 */
@RooJavaBean
@Component
// @Scope(value = "request", proxyMode = ScopedProxyMode.INTERFACES)
public class CurrentUserImpl implements CurrentUser {

	Authentication authentication;
	
	public Authentication getAuthentication() {
		return SecurityContextHolder.getContext().getAuthentication();
	}

}
