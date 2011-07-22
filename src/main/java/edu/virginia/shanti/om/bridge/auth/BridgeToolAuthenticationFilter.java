package edu.virginia.shanti.om.bridge.auth;

import java.io.IOException;
import java.util.Arrays;
import java.util.Enumeration;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import junit.framework.Assert;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.preauth.RequestHeaderAuthenticationFilter;

import edu.virginia.shanti.om.bridge.service.CurrentUser;

public class BridgeToolAuthenticationFilter extends
		RequestHeaderAuthenticationFilter {
	
	@Autowired 
	private CurrentUser currentUser;

	@Autowired
	private UserDetailsService userDetailsService;
	
	private Log log = LogFactory.getLog(BridgeToolAuthenticationFilter.class);

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		
		// TODO: need to verify signature!
		
		// when running on localhost, use mockuser httpRequestWrapper

		Assert.assertTrue("This class only applies to HttpServletRequests!",
				request instanceof HttpServletRequest);

		String username = overrideUserName(request);

		// wrap the request if the user name has been overridden
		if (username != null) {
			request = new MockRequestWrapper((HttpServletRequest) request,
					username);
			if (log.isDebugEnabled()) {
				log.debug("doFilter(): USING MOCKUSER: " + request);
			}
		}
		
		Enumeration attributeNames = request.getAttributeNames();
		while (attributeNames.hasMoreElements()) {
			String attribute = (String) attributeNames.nextElement();
			System.err.println(" ==> attribute " + attribute + " = " + request.getAttribute(attribute));
		}
		
		Enumeration parameterNames = request.getParameterNames();
		while (parameterNames.hasMoreElements()) {
			String parameter = (String) parameterNames.nextElement();
			System.err.println(" ==> parameter " + parameter + " = " + request.getParameter(parameter));
		}
		
		if( request.getParameter("role") != null) {
			GrantedAuthority grant = createGrant(request.getParameter("role") + "@" + request.getParameter("site"));
			userDetailsService.saveGrant(((HttpServletRequest)request).getRemoteUser(),grant);

			SecurityContextHolder.getContext().setAuthentication(
				new UsernamePasswordAuthenticationToken(
					currentUser.getAuthentication().getPrincipal(),
					currentUser.getAuthentication().getCredentials(),
					Arrays.asList(new GrantedAuthority[]{grant}))
				);
			
		}
		
		// resume normal operation
		super.doFilter(request, response, chain);
	}

	private GrantedAuthority createGrant(String role) {
		GrantedAuthorityImpl grant = new GrantedAuthorityImpl(role);
		return grant;
	}

	private String overrideUserName(ServletRequest request) {

		// override the username if host is localhost.

		String username = null;

		String localname = ((HttpServletRequest) request).getLocalName();
		if (log.isDebugEnabled()) {
			log.debug("localname = " + localname);
		}
		if ("localhost".equals(localname)) {
			username = "ys2n"; // default for testing

			// you can also pass mockuser parameter when running on localhost
			String mockuser = request.getParameter("mockuser");

			if (mockuser != null) {
				username = mockuser;
			}
		}

		if (log.isDebugEnabled()) {
			log.debug("overrideUserName(): RETURNING: " + username);
		}
		return username;
	}

	@Override
	protected Object getPreAuthenticatedPrincipal(HttpServletRequest request) {

		String user = overrideUserName(request);

		if (user != null) {
			if (log.isDebugEnabled()) {
				log.debug("XXXXX getPreAuthenticatedPrincipal() returning "
						+ user);
			}
			return user;
		}

		return super.getPreAuthenticatedPrincipal(request);
	}
}
