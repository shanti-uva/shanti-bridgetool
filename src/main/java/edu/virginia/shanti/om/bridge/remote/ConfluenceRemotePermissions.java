package edu.virginia.shanti.om.bridge.remote;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class ConfluenceRemotePermissions implements RemotePermissions {

	private Map<String, Boolean> perms = new HashMap<String, Boolean>();

	private String[] possiblePermissions = {			
			"EDITSPACE",
			"EXPORTSPACE",
			"SETSPACEPERMISSIONS",
			"SETPAGEPERMISSIONS",
			"REMOVEMAIL",
			"REMOVEBLOG",
			"EXPORTPAGE", 
			"REMOVEATTACHMENT",
			"CREATEATTACHMENT",
			"VIEWSPACE",
			"EDITBLOG",
			"REMOVECOMMENT",
			"REMOVEPAGE",
			"COMMENT" 
	};

	public ConfluenceRemotePermissions(String[] permissions) {
		for (String perm : permissions) {
			perms.put(perm, true);
		}
	}

	@Override
	public boolean hasPermission(String perm) {
		return perms.get(perm);
	}

	@Override
	public String[] getPermissions() {
		// TODO Auto-generated method stub
		return perms.keySet().toArray(new String[perms.size()]);
	}

	@Override
	public String toString() {
		return Arrays.toString(getPermissions());
	}

	@Override
	public String[] possiblePermissions() {
		return possiblePermissions;
	}

	@Override
	public void setPermission(String perm, boolean bool) {
		throw new UnsupportedOperationException("RemotePermissions.setRemotePermission() is not supported by this implementation.");
	}

}
