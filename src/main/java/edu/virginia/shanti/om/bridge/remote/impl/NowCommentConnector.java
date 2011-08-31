package edu.virginia.shanti.om.bridge.remote.impl;

import java.security.Principal;
import java.util.LinkedList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.roo.addon.serializable.RooSerializable;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import edu.virginia.shanti.om.bridge.domain.PermissionMap;
import edu.virginia.shanti.om.bridge.domain.RemoteContext;
import edu.virginia.shanti.om.bridge.domain.RemoteServer;
import edu.virginia.shanti.om.bridge.form.ConfigBean;
import edu.virginia.shanti.om.bridge.form.RemoteContextChoice;
import edu.virginia.shanti.om.bridge.remote.RemoteConnector;
import edu.virginia.shanti.om.bridge.remote.RemotePermissions;
import edu.virginia.shanti.om.bridge.service.SiteAliasService;

@Service
@Component
@RooSerializable
public class NowCommentConnector implements RemoteConnector {

	private static final long serialVersionUID = -360593800242514401L;

	@Autowired
	private SiteAliasService siteAliasService;

	private Log log = LogFactory.getLog(NowCommentConnector.class);

	@Override
	public List<RemoteContextChoice> getContexts(Principal principal,
			RemoteServer remoteServer, ConfigBean config) {

		List<RemoteContextChoice> choices = new LinkedList<RemoteContextChoice>();

		RemoteContextChoice choice = new RemoteContextChoice();

		String siteAlias = siteAliasService.getAliasForSiteId(config
				.getLocalContext());
		
		log.info("Got siteAlias " + siteAlias + " for " + config.getLocalContext());
		choice.setContextId(siteAlias);
		choice.setContextLabel(siteAlias);
		choice.setRemoteName("nowCommentStaging");
		log.info("remoteServer = " + remoteServer);
		// https://staging.nowcomment.com/uva?redirect_to_group=~collab:java-basics-fde0:summer2008
		choice.setUrl(remoteServer.getRemoteUrl() + "/uva?redirect_to_group="
				+ siteAlias);
		log.info("adding choice = " + choice);
		choices.add(choice);
		return choices;
	}

	@Override
	public RemoteContext createRemoteContext(Principal principal,
			RemoteContext remoteContext, ConfigBean config) {
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
