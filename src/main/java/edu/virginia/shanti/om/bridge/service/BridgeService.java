package edu.virginia.shanti.om.bridge.service;

import java.util.List;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.webflow.execution.RequestContext;

import edu.virginia.shanti.om.bridge.domain.Bridge;
import edu.virginia.shanti.om.bridge.domain.RemoteContext;
import edu.virginia.shanti.om.bridge.form.ConfigBean;

public interface BridgeService {

	String checkConfig(ConfigBean config);

	List<Bridge> getBridges(ConfigBean config);

	List<Bridge> getBridges(String user, String localContext);

	Bridge getBridge(ConfigBean config);

	Bridge newBridge(ConfigBean config);

	Bridge newBridge(ConfigBean config, RemoteContext remoteContext);

	Bridge createNewBridge(ConfigBean config, RemoteContext remoteContext);

	@PreAuthorize("hasPermission(#bridge, 'admin')") 
	void save(Bridge bridge);
	
	boolean isAdmin(Bridge bridge);
	
	@PreAuthorize("hasPermission(#bridge, 'admin')")
	boolean adminCheck(Bridge bridge);

	ConfigBean populateConfigFromContext(RequestContext request);

	ConfigBean populateConfigFromContext(RequestContext request,
			ConfigBean config);

	String getSummaryMarkup(Bridge bridge);

}
