package edu.virginia.shanti.om.bridge.auth;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import junit.framework.Assert;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.web.authentication.preauth.RequestHeaderAuthenticationFilter;

public class BridgeToolAuthenticationFilter extends
		RequestHeaderAuthenticationFilter {

	private Log log = LogFactory.getLog(BridgeToolAuthenticationFilter.class);

	@Override
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {

		// when running on localhost, use mockuser httprequestwrapper

		Assert.assertTrue("This class only applies to HttpServletRequests!",
				request instanceof HttpServletRequest);

		String username = overrideUserName(request);

		// wrap the request if the username has been overriden
		if (username != null) {
			request = new MockRequestWrapper((HttpServletRequest) request,
					username);
			if (log.isDebugEnabled()) {
				log.debug("doFilter(): USING MOCKUSER: " + request);
			}
		}

		// resume normal operation
		super.doFilter(request, response, chain);
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
