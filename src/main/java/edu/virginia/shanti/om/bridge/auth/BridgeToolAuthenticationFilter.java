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
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.preauth.RequestHeaderAuthenticationFilter;

import edu.virginia.shanti.om.bridge.auth.sakai.ExtensionClient;
import edu.virginia.shanti.om.bridge.auth.sakai.LinktoolFormValues;
import edu.virginia.shanti.om.bridge.auth.sakai.SakaiUserInfo;
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

		// TODO: REFACTOR override username under certain circumstances
		// (development)
		// request = overrideUserName((HttpServletRequest) request);

		if (request.getParameter("role") != null
				&& request.getParameter("site") != null) {

			// this is assumed to be a linktool login.
			String queryString = ((HttpServletRequest) request)
					.getQueryString();
			
			log.error("queryString = " + queryString);
			
			String grantString = request
					.getParameter("role")
					+ "@"
					+ request.getParameter("site");
			
			authenticateSecurityContextHolder(queryString, grantString);

		}

		// resume normal operation
		super.doFilter(request, response, chain);
	}

	public void authenticateSecurityContextHolder(String queryString, String grantString) {
		LinktoolFormValues values = new LinktoolFormValues(queryString);
		ExtensionClient extensionClient = new ExtensionClient(values);

		try {
			if (extensionClient.authenticate()) {
				SakaiUserInfo sakaiUserInfo = extensionClient
						.getSakaiUserInfo();

				String user = sakaiUserInfo.getUserId();
				String sessionId = sakaiUserInfo.getSakaiSessionId();
				String serverId = sakaiUserInfo.getServerId();
				String serverUrl = sakaiUserInfo.getServerUrl();
				String serviceBaseUrl = sakaiUserInfo.getServiceBaseUrl();
				String sessionString = sessionId + "." + serverId;

				populateSecurityContext(grantString, user, serverUrl, sessionString);

			} else {
				log.warn("failed authentication!");
				SecurityContextHolder.clearContext();
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			// throw new ServletException(e);
			log.warn("authentication error: " + e);
			SecurityContextHolder.clearContext();
		}
	}

	public void populateSecurityContext(String grantString, String user, String serverUrl, String sessionString) {
		GrantedAuthority grant = createGrant(grantString);
		userDetailsService.saveGrant(user, grant);

		log.info("Saving grant " + grant + " for " + user);

		GrantedAuthority serverGrant = createGrant("sakaisession#" + sessionString + "#" + serverUrl);
		// userDetailsService.saveGrant(user, serverGrant);
		
		log.info("Saving grant " + serverGrant + " for " + user);
		
		if (currentUser != null
				&& currentUser.getAuthentication() != null) {

			Authentication existingAuth = SecurityContextHolder
					.getContext().getAuthentication();
			if (existingAuth.getName() != null
					&& !existingAuth.getName().equals(user)) {
				log.warn("WARNING! authenticated user from linktool " + user + " is not the same as remote user " + existingAuth.getName());
			}

		}

		// substitute authentication to add GrantedAuthorities
		SecurityContextHolder
				.getContext()
				.setAuthentication(
						new UsernamePasswordAuthenticationToken(
								user,
								sessionString,
								Arrays.asList(new GrantedAuthority[] { grant,serverGrant })));
	}

	private GrantedAuthority createGrant(String role) {
		GrantedAuthorityImpl grant = new GrantedAuthorityImpl(role);
		return grant;
	}

	private HttpServletRequest overrideUserName(HttpServletRequest request) {

		// override the username if host is localhost.

		String username = null;

		String localname = (request).getLocalName();
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

		// wrap the request if the user name has been overridden
		if (username != null) {
			request = new MockRequestWrapper(request, username);
			if (log.isDebugEnabled()) {
				log.debug("doFilter(): USING MOCKUSER: " + request);
			}
		}

		return request;
	}

	@Override
	protected Object getPreAuthenticatedPrincipal(HttpServletRequest request) {

		String user = overrideUserName(request).getRemoteUser();

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
