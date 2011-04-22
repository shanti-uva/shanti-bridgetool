package edu.virginia.shanti.om.bridge.remote;

import org.springframework.roo.addon.javabean.RooJavaBean;

@RooJavaBean
public interface RemotePermissions {

	boolean hasPermission(String perm);
	void setPermission(String perm, boolean bool);
	String[] getPermissions();
	String[] possiblePermissions();

}
