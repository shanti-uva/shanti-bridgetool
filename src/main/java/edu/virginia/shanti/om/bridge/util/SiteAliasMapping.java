package edu.virginia.shanti.om.bridge.util;

import org.springframework.roo.addon.javabean.RooJavaBean;

@RooJavaBean
public class SiteAliasMapping {
	
	
	public SiteAliasMapping(String remoteName, String localContext, String alias) {
		this.remoteName = remoteName;
		this.localContext = localContext;
		this.alias = alias;		
	}
	
	String remoteName;
	String localContext;
	String alias;
	@Override
	public boolean equals(Object obj) {
		return this.hashCode() == obj.hashCode();
	}
	@Override
	public int hashCode() {
		return toString().hashCode();
	}

}
