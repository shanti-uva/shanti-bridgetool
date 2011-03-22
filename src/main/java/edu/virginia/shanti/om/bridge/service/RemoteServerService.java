package edu.virginia.shanti.om.bridge.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.ApplicationContext;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.serializable.RooSerializable;
import org.springframework.roo.addon.tostring.RooToString;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import edu.virginia.shanti.om.bridge.domain.RemoteContext;
import edu.virginia.shanti.om.bridge.domain.RemoteServer;
import edu.virginia.shanti.om.bridge.form.ConfluenceSpaceForm;
import edu.virginia.shanti.om.bridge.form.RemoteContextChoice;
import edu.virginia.shanti.om.bridge.remote.RemoteConnector;

@RooJavaBean
@RooToString
@RooSerializable
@Service
@Configurable
public class RemoteServerService {

	@Autowired
	private ApplicationContext applicationContext;
	
	@Autowired
	private CurrentUser currentUser;  // this is request scoped

	private static final long serialVersionUID = -2683260374906842765L;

	/**
	 * Return the remote configuration for this service name
	 * 
	 * @param serviceName
	 * @return RemoteServer the RemoteServer object for this
	 *         service name.
	 */
	public RemoteServer getRemoteServer(String serviceName) {
		// TODO: needs test
		// looks up RemoteServer entity by serviceName
		return RemoteServer.findRemoteServersByRemoteName(
				serviceName).getSingleResult();
	}

	/**
	 * Get list of remote contexts for this configuration
	 * 
	 * @param remoteServer
	 * @return List<RemoteContext> list of remote contexts
	 */
	public List<RemoteContextChoice> getRemoteContexts(
			RemoteServer remoteServer) {

		System.err.println("getRemoteContexts(): remoteServer = "
				+ remoteServer);
		System.err.println("getRemoteContexts(): applicationContext = "
				+ applicationContext);

		RemoteConnector remote = (RemoteConnector) applicationContext
				.getBean(remoteServer.getImplementationName());
		
		return remote.getContexts(remoteServer);
	}

	/**
	 * Convenience method to get RemoteContexts by configuration name directly
	 * 
	 * @param configurationName
	 * @return List<RemoteContext> list of remote contexts
	 */
	public List<RemoteContextChoice> getRemoteContexts(String configurationName) {
		System.err.println("getRemoteContexts( " + configurationName +" )"); 
		return getRemoteContexts(getRemoteServer(configurationName));
	}
	
	
	public RemoteContext createRemoteContext(RemoteContext newContext) {
		
		System.err.println("Trying this config:  " + newContext);
		
		RemoteServer remoteServer = RemoteServer.findRemoteServersByRemoteName(newContext.getRemoteName()).getSingleResult();
		
		RemoteConnector connector = (RemoteConnector)applicationContext.getBean(remoteServer.getImplementationName());
		RemoteContext newRemoteContext = connector.createRemoteContext(newContext);
		return newRemoteContext;
		
	}
	
	public RemoteContext createRemoteContext(ConfluenceSpaceForm spaceForm) {
		RemoteContext rc = new RemoteContext();
		rc.populate(spaceForm);
		return createRemoteContext(rc);
	}
	
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public void addRemoteServer(String configName,
			String configImplementation, String configUrl) {

		RemoteServer config = new RemoteServer();
		config.setRemoteName(configName);
		config.setImplementationName(configImplementation);
		config.setRemoteUrl(configUrl);
		config.persist();

	}
	
	
	public List<RemoteServer> getAllRemoteServers() {
		return RemoteServer.findAllRemoteServers();
	}
}
