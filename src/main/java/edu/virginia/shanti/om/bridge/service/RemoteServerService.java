package edu.virginia.shanti.om.bridge.service;

import java.security.Principal;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.ApplicationContext;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.serializable.RooSerializable;
import org.springframework.roo.addon.tostring.RooToString;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import edu.virginia.shanti.om.bridge.domain.PermissionMap;
import edu.virginia.shanti.om.bridge.domain.RemoteContext;
import edu.virginia.shanti.om.bridge.domain.RemoteServer;
import edu.virginia.shanti.om.bridge.form.ConfigBean;
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

	private Log log = LogFactory.getLog(RemoteServerService.class);

	@Autowired
	private CurrentUser currentUser;

	private static final long serialVersionUID = -2683260374906842765L;

	/**
	 * Return the remote configuration for this service name
	 * 
	 * @param serviceName
	 * @return RemoteServer the RemoteServer object for this service name.
	 */
	public RemoteServer getRemoteServer(String serviceName) {
		// TODO: needs test
		// looks up RemoteServer entity by serviceName
		RemoteServer remoteServer = null;
		try {
			remoteServer = RemoteServer.findRemoteServersByRemoteName(
					serviceName).getSingleResult();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			log.error("Error retrieving RemoteServer named \'" + serviceName
					+ "\' : " + e.getMessage() + " Returning null.");
		}
		return remoteServer;
	}

	/**
	 * Get list of remote contexts for this configuration
	 * 
	 * @param remoteServer
	 * @return List<RemoteContext> list of remote contexts
	 */
	public List<RemoteContextChoice> getRemoteContexts(RemoteServer remoteServer, ConfigBean config) {
		RemoteConnector remote = (RemoteConnector) applicationContext
				.getBean(remoteServer.getImplementationName());
		
		if (remote == null) {
			throw new RuntimeException("The RemoteConnector " + remoteServer.getImplementationName() + " could not be found in the application context.");
		}

		Principal principal = currentUser.getAuthentication();
		return remote.getContexts(principal, remoteServer, config);
	}

	/**
	 * Convenience method to get RemoteContexts by configuration name directly
	 * 
	 * @param configurationName
	 * @return List<RemoteContext> list of remote contexts
	 */
	public List<RemoteContextChoice> getRemoteContexts(ConfigBean config) {
		
		String configurationName = config.getRemoteService();
		
		log.debug("getRemoteContexts( " + config +" ) called.");
		RemoteServer remoteServer = getRemoteServer(configurationName);
		if (remoteServer == null) {
			throw new RuntimeException("Remote server \'" + configurationName
					+ "\' is unknown.");
		}

		// DEBUG

		log.debug("DEBUG:"
				+ currentUser.getAuthentication()
						.getName());

		return getRemoteContexts(remoteServer, config);
	}

	public RemoteContext createRemoteContext(RemoteContext newContext, ConfigBean config) {

		log.debug("Trying this config:  " + newContext);
		RemoteConnector connector = findRemoteConnector(newContext);
		RemoteContext newRemoteContext = connector.createRemoteContext(
				currentUser.getAuthentication(), newContext, config);
		return newRemoteContext;

	}

	private RemoteConnector findRemoteConnector(RemoteContext newContext) {
		RemoteServer remoteServer = RemoteServer.findRemoteServersByRemoteName(
				newContext.getRemoteName()).getSingleResult();
		RemoteConnector connector = (RemoteConnector) applicationContext
				.getBean(remoteServer.getImplementationName());
		return connector;
	}

	public RemoteContext createRemoteContext(ConfluenceSpaceForm spaceForm, ConfigBean config) {
		RemoteContext rc = new RemoteContext();
		log.debug("populating remote context from spaceForm: " + spaceForm);
		rc.populate(spaceForm);
		log.debug("Trying to create remote context: " + rc); 
		return createRemoteContext(rc, config);
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public void addRemoteServer(String configName, String configImplementation,
			String configUrl) {

		RemoteServer config = new RemoteServer();
		config.setRemoteName(configName);
		config.setImplementationName(configImplementation);
		config.setRemoteUrl(configUrl);
		config.persist();

	}

	public String getSummaryMarkup(RemoteContext remoteContext) {
		RemoteConnector connector = findRemoteConnector(remoteContext);
		Principal principal = currentUser.getAuthentication();
		return connector.getSummaryMarkup(principal, remoteContext);
	}

	public List<RemoteServer> getAllRemoteServers() {
		return RemoteServer.findAllRemoteServers();
	}

	public void writePermissionMap(String localContext, RemoteContext remoteContext,
			PermissionMap permissionMap) {
		
		log.debug("===> " + remoteContext);
		
		RemoteConnector connector = findRemoteConnector(remoteContext);
		Authentication principal = currentUser.getAuthentication();

		connector.setRemotePermissions(principal, localContext, remoteContext, permissionMap);

	}

	public RemoteServer getRemoteServer(ConfigBean config) {
		return getRemoteServer(config.getRemoteService());
	}

}
