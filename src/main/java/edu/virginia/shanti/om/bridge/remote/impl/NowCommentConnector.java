package edu.virginia.shanti.om.bridge.remote.impl;

import java.security.Principal;
import java.util.LinkedList;
import java.util.List;

import org.springframework.roo.addon.serializable.RooSerializable;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import edu.virginia.shanti.om.bridge.domain.PermissionMap;
import edu.virginia.shanti.om.bridge.domain.RemoteContext;
import edu.virginia.shanti.om.bridge.domain.RemoteServer;
import edu.virginia.shanti.om.bridge.form.RemoteContextChoice;
import edu.virginia.shanti.om.bridge.remote.RemoteConnector;
import edu.virginia.shanti.om.bridge.remote.RemotePermissions;

@Service
@Component
@RooSerializable
public class NowCommentConnector implements RemoteConnector {

	@Override
	public List<RemoteContextChoice> getContexts(Principal principal,
			RemoteServer remoteServer) {
		// TODO Auto-generated method stub
		List<RemoteContextChoice> choices = new LinkedList<RemoteContextChoice>();

		RemoteContextChoice choice = new RemoteContextChoice();		
		choice.setContextId("bogus");
		choice.setContextLabel("bogus entry");
		choice.setRemoteName("nowCommentStaging");
		choice.setUrl("http://staging.nowcomment.com");
		
		choices.add(choice);
		return choices;
	}

	@Override
	public RemoteContext createRemoteContext(Principal principal,
			RemoteContext remoteContext) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getSummaryMarkup(Principal principal,
			RemoteContext remoteContext) {
		// TODO Auto-generated method stub
		return "no summary yet";
	}

	@Override
	public RemotePermissions getRemotePermissions(Principal principal,
			String localContext, RemoteContext remoteContext) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setRemotePermissions(Principal principal, String localContext,
			RemoteContext remoteContext, PermissionMap permissionMap) {
		// TODO Auto-generated method stub

	}

}
