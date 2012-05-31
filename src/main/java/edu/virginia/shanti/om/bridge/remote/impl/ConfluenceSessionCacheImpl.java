package edu.virginia.shanti.om.bridge.remote.impl;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.stereotype.Component;

@RooJavaBean
@Component
@Scope(value = "request", proxyMode = ScopedProxyMode.INTERFACES)

public class ConfluenceSessionCacheImpl implements ConfluenceSessionCache {
	
	private String confluenceUserSession;

}
