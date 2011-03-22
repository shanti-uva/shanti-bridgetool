package edu.virginia.shanti.om.bridge.webflow;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.stereotype.Service;
import org.springframework.webflow.engine.RequestControlContext;

import edu.virginia.shanti.om.bridge.domain.RemoteContext;
import edu.virginia.shanti.om.bridge.domain.RemoteServer;
import edu.virginia.shanti.om.bridge.form.ConfluenceSpaceForm;
import edu.virginia.shanti.om.bridge.form.RemoteContextChoice;
import edu.virginia.shanti.om.bridge.service.RemoteServerService;

@Service
@RooJavaBean
public class RemoteServerFlowService {
	
	@Autowired
	RemoteServerService remoteServerService;

	public RemoteServer getRemoteServer(String serviceName) {
		return remoteServerService.getRemoteServer(serviceName);
	}

	public List<RemoteContextChoice> getRemoteContexts(RemoteServer remoteServer) {
		return remoteServerService.getRemoteContexts(remoteServer);
	}

	public List<RemoteContextChoice> getRemoteContexts(String configurationName) {
		return remoteServerService.getRemoteContexts(configurationName);
	}

	public RemoteContext createRemoteContext(RemoteContext newConfig, RequestControlContext context) {
		RemoteContext remoteContext;
		try {
			remoteContext = remoteServerService.createRemoteContext(newConfig);
		} catch (Exception e) {
			System.err.println ("XXX: " + e.getMessage());
			throw new RuntimeException(e);
		}
		return remoteContext;
	}

	public RemoteContext createRemoteContext(ConfluenceSpaceForm spaceForm) {
		return remoteServerService.createRemoteContext(spaceForm);
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