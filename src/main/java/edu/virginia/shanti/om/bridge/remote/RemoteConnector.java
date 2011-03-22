package edu.virginia.shanti.om.bridge.remote;

import java.util.List;

import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.serializable.RooSerializable;
import org.springframework.roo.addon.tostring.RooToString;

import edu.virginia.shanti.om.bridge.domain.RemoteContext;
import edu.virginia.shanti.om.bridge.domain.RemoteServer;
import edu.virginia.shanti.om.bridge.form.RemoteContextChoice;

@RooJavaBean
@RooToString
@RooSerializable
public interface RemoteConnector {

	/**
	 * Returns a list of remoteContextChoices (will use authentication context)?
	 * @param remoteServer 
	 * @return List<RemoteContext>
	 */
	public List<RemoteContextChoice> getContexts(RemoteServer remoteServer);
	
	public RemoteContext createRemoteContext(RemoteContext remoteContext);
	
	public String getSummaryMarkup(RemoteContext remoteContext);
	
	public RemotePermissions getRemotePermissions(RemoteContext remoteContext);
	
}
