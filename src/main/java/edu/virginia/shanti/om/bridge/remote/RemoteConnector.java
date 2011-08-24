package edu.virginia.shanti.om.bridge.remote;

import java.security.Principal;
import java.util.List;

import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.serializable.RooSerializable;
import org.springframework.roo.addon.tostring.RooToString;
import org.springframework.security.core.Authentication;

import com.googlecode.ehcache.annotations.Cacheable;

import edu.virginia.shanti.om.bridge.domain.PermissionMap;
import edu.virginia.shanti.om.bridge.domain.RemoteContext;
import edu.virginia.shanti.om.bridge.domain.RemoteServer;
import edu.virginia.shanti.om.bridge.form.RemoteContextChoice;

@RooJavaBean
@RooToString
@RooSerializable
public interface RemoteConnector {

	/**
	 * Returns a list of remoteContextChoices (will use authentication context)?
	 * 
	 * @param remoteServer
	 * @return List<RemoteContext>
	 */
	
	public List<RemoteContextChoice> getContexts(Principal principal,
			RemoteServer remoteServer);

	public RemoteContext createRemoteContext(Principal principal,
			RemoteContext remoteContext);

	public String getSummaryMarkup(Principal principal,
			RemoteContext remoteContext);

	public RemotePermissions getRemotePermissions(Principal principal, String localContext,
			RemoteContext remoteContext);

	// public void setRemotePermissions(Principal principal, RemoteContext
	// remoteContext, RemotePermissions remotePermissions);

	public void setRemotePermissions(Principal principal, String localContext,
			RemoteContext remoteContext, PermissionMap permissionMap);

}
