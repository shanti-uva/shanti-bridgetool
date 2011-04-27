package edu.virginia.shanti.om.bridge.auth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.Principal;
import java.util.Enumeration;
import java.util.Locale;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletInputStream;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * This is a wrapper for mock user purposes.
 * 
 * @author ys2n
 * 
 */
public class MockRequestWrapper implements HttpServletRequest {

	private Log log = LogFactory.getLog(MockRequestWrapper.class);

	private String mockUser;

	private HttpServletRequest wrappedRequest;

	public MockRequestWrapper(HttpServletRequest request, String username) {
		mockUser = username;
		wrappedRequest = request;
	}

	@Override
	public Object getAttribute(String name) {
		if ("REMOTE_USER".equals(name)) {
			return mockUser;
		}
		return wrappedRequest.getAttribute(name);
	}

	@Override
	public Enumeration getAttributeNames() {
		return wrappedRequest.getAttributeNames();
	}

	public String getAuthType() {
		return wrappedRequest.getAuthType();
	}

	@Override
	public String getCharacterEncoding() {
		return wrappedRequest.getCharacterEncoding();
	}

	@Override
	public int getContentLength() {
		return wrappedRequest.getContentLength();
	}

	@Override
	public String getContentType() {
		return wrappedRequest.getContentType();
	}

	public String getContextPath() {
		return wrappedRequest.getContextPath();
	}

	public Cookie[] getCookies() {
		return wrappedRequest.getCookies();
	}

	public long getDateHeader(String name) {
		return wrappedRequest.getDateHeader(name);
	}

	public String getHeader(String name) {

		log.warn("getHeader(" + name + ") called.");

		if ("REMOTE_USER".equals(name)) {
			return mockUser;
		} else if ("sakaisessionid".equals(name)) {
			if (wrappedRequest.getHeader("sakaisessionid") == null) {
				return "97e64b7e-f97c-41d7-9691-a80fcf3ef967.sakai13";
			}
		}
		return wrappedRequest.getHeader(name);
	}

	@Override
	public Enumeration getHeaderNames() {
		return wrappedRequest.getHeaderNames();
	}

	@Override
	public Enumeration getHeaders(String name) {
		return wrappedRequest.getHeaders(name);
	}

	@Override
	public ServletInputStream getInputStream() throws IOException {
		return wrappedRequest.getInputStream();
	}

	public int getIntHeader(String name) {
		return wrappedRequest.getIntHeader(name);
	}

	@Override
	public String getLocalAddr() {
		return wrappedRequest.getLocalAddr();
	}

	@Override
	public Locale getLocale() {
		return wrappedRequest.getLocale();
	}

	@Override
	public Enumeration getLocales() {
		return wrappedRequest.getLocales();
	}

	@Override
	public String getLocalName() {
		return wrappedRequest.getLocalName();
	}

	@Override
	public int getLocalPort() {
		return wrappedRequest.getLocalPort();
	}

	public String getMethod() {
		return wrappedRequest.getMethod();
	}

	@Override
	public String getParameter(String name) {
		return wrappedRequest.getParameter(name);
	}

	@Override
	public Map getParameterMap() {
		return wrappedRequest.getParameterMap();
	}

	@Override
	public Enumeration getParameterNames() {
		return wrappedRequest.getParameterNames();
	}

	@Override
	public String[] getParameterValues(String name) {
		return wrappedRequest.getParameterValues(name);
	}

	public String getPathInfo() {
		return wrappedRequest.getPathInfo();
	}

	public String getPathTranslated() {
		return wrappedRequest.getPathTranslated();
	}

	@Override
	public String getProtocol() {
		return wrappedRequest.getProtocol();
	}

	public String getQueryString() {
		return wrappedRequest.getQueryString();
	}

	@Override
	public BufferedReader getReader() throws IOException {
		return wrappedRequest.getReader();
	}

	@SuppressWarnings({ "deprecation" })
	@Override
	public String getRealPath(String path) {
		return wrappedRequest.getRealPath(path);
	}

	@Override
	public String getRemoteAddr() {
		return wrappedRequest.getRemoteAddr();
	}

	@Override
	public String getRemoteHost() {
		return wrappedRequest.getRemoteHost();
	}

	@Override
	public int getRemotePort() {
		return wrappedRequest.getRemotePort();
	}

	@Override
	public String getRemoteUser() {
		return mockUser;
	}

	@Override
	public RequestDispatcher getRequestDispatcher(String path) {
		return wrappedRequest.getRequestDispatcher(path);
	}

	public String getRequestedSessionId() {
		return wrappedRequest.getRequestedSessionId();
	}

	public String getRequestURI() {
		return wrappedRequest.getRequestURI();
	}

	public StringBuffer getRequestURL() {
		return wrappedRequest.getRequestURL();
	}

	@Override
	public String getScheme() {
		return wrappedRequest.getScheme();
	}

	@Override
	public String getServerName() {
		return wrappedRequest.getServerName();
	}

	@Override
	public int getServerPort() {
		return wrappedRequest.getServerPort();
	}

	public String getServletPath() {
		return wrappedRequest.getServletPath();
	}

	public HttpSession getSession() {
		return wrappedRequest.getSession();
	}

	public HttpSession getSession(boolean create) {
		return wrappedRequest.getSession(create);
	}

	public Principal getUserPrincipal() {
		return wrappedRequest.getUserPrincipal();
	}

	public boolean isRequestedSessionIdFromCookie() {
		return wrappedRequest.isRequestedSessionIdFromCookie();
	}

	@SuppressWarnings("deprecation")
	public boolean isRequestedSessionIdFromUrl() {
		return wrappedRequest.isRequestedSessionIdFromUrl();
	}

	public boolean isRequestedSessionIdFromURL() {
		return wrappedRequest.isRequestedSessionIdFromURL();
	}

	public boolean isRequestedSessionIdValid() {
		return wrappedRequest.isRequestedSessionIdValid();
	}

	@Override
	public boolean isSecure() {
		return wrappedRequest.isSecure();
	}

	public boolean isUserInRole(String role) {
		return wrappedRequest.isUserInRole(role);
	}

	@Override
	public void removeAttribute(String name) {
		wrappedRequest.removeAttribute(name);
	}

	@Override
	public void setAttribute(String name, Object o) {
		wrappedRequest.setAttribute(name, o);
	}

	@Override
	public void setCharacterEncoding(String env)
			throws UnsupportedEncodingException {
		wrappedRequest.setCharacterEncoding(env);
	}

	@Override
	public String toString() {
		return "[MockRequestWrapper mockUser=" + mockUser + "]";
	}

}
