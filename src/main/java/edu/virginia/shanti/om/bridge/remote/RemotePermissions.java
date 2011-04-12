package edu.virginia.shanti.om.bridge.remote;

import org.springframework.roo.addon.javabean.RooJavaBean;

@RooJavaBean
public interface RemotePermissions {

	boolean hasPermission(String perm);
	String[] getPermissions();
	String[] possiblePermissions();

}
