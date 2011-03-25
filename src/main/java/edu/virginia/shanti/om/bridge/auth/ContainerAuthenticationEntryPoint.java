package edu.virginia.shanti.om.bridge.auth;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

@Service
public class ContainerAuthenticationEntryPoint implements
		AuthenticationEntryPoint, InitializingBean {

	private String domainLogin;

	public String getDomainLogin() {
		return domainLogin;
	}

	public void setDomainLogin(String domainLogin) {
		this.domainLogin = domainLogin;
	}

	@Override
	public void afterPropertiesSet() throws Exception {
			// Assert.hasLength(domainLogin, "DomainLogin must be specified.");
	}

	@Override
	public void commence(HttpServletRequest request,
			HttpServletResponse response, AuthenticationException authException)
			throws IOException, ServletException {

			String redirectUrl = domainLogin;
			response.sendRedirect(response.encodeRedirectURL(redirectUrl));
			// redirect to shibboleth endpoint
	}

}
