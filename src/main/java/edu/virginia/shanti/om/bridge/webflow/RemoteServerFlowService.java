package edu.virginia.shanti.om.bridge.webflow;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.stereotype.Service;
import org.springframework.webflow.engine.RequestControlContext;

import edu.virginia.shanti.om.bridge.domain.RemoteContext;
import edu.virginia.shanti.om.bridge.domain.RemoteServer;
import edu.virginia.shanti.om.bridge.form.ConfigBean;
import edu.virginia.shanti.om.bridge.form.ConfluenceSpaceForm;
import edu.virginia.shanti.om.bridge.form.RemoteContextChoice;
import edu.virginia.shanti.om.bridge.service.CurrentUser;
import edu.virginia.shanti.om.bridge.service.RemoteServerService;

@Service
@RooJavaBean
public class RemoteServerFlowService {
	
	private Log log = LogFactory.getLog(RemoteServerFlowService.class);
	
	@Autowired
	RemoteServerService remoteServerService;
	
	@Autowired
	CurrentUser currentUser;

	public RemoteServer getRemoteServer(String serviceName) {
		return remoteServerService.getRemoteServer(serviceName);
	}

//	public List<RemoteContextChoice> getRemoteContexts(RemoteServer remoteServer) {
//		log.warn("DEBUG:" + currentUser.getAuthentication().getName());
//		return remoteServerService.getRemoteContexts(config);
//	}

	public List<RemoteContextChoice> getRemoteContexts(ConfigBean config) {
		log.warn("DEBUG:" + currentUser.getAuthentication().getName());
		return remoteServerService.getRemoteContexts(config);
	}

	public RemoteContext createRemoteContext(RemoteContext newConfig, RequestControlContext context) {
		RemoteContext remoteContext;
		try {
			ConfigBean config = (ConfigBean)context.getAttributes().get("config");	
			remoteContext = remoteServerService.createRemoteContext(newConfig, config);
		} catch (Exception e) {
//			System.err.println ("XXX: " + e.getMessage());
			throw new RuntimeException(e);
		}
		return remoteContext;
	}

	public RemoteContext createRemoteContext(ConfluenceSpaceForm spaceForm, ConfigBean config) {
		return remoteServerService.createRemoteContext(spaceForm, config);
	}

	public void addRemoteServer(String configName, String configImplementation,
			String configInstance) {
		remoteServerService.addRemoteServer(configName, configImplementation,
				configInstance);
	}

	public List<RemoteServer> getAllRemoteServers() {
		return remoteServerService.getAllRemoteServers();
	}
	
	
	
}
