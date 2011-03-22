package edu.virginia.shanti.om.bridge.remote.impl;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.serializable.RooSerializable;
import org.springframework.roo.addon.tostring.RooToString;
import org.springframework.stereotype.Service;

import edu.virginia.shanti.om.bridge.domain.RemoteContext;
import edu.virginia.shanti.om.bridge.domain.RemoteServer;
import edu.virginia.shanti.om.bridge.form.RemoteContextChoice;
import edu.virginia.shanti.om.bridge.remote.RemoteConnector;
import edu.virginia.shanti.om.bridge.remote.RemotePermissions;

@RooJavaBean
@RooToString
@RooSerializable
@Service
public class MockConfluenceConnector implements RemoteConnector {
	
	private static final long serialVersionUID = 6670877131155240894L;
	private Map<String,LinkedList<RemoteContextChoice>> contextStore = new HashMap<String,LinkedList<RemoteContextChoice>>();
	
	public MockConfluenceConnector() {
		
		RemoteServer remoteServer = new RemoteServer();
		remoteServer.setImplementationName("mockConfluenceConnector");
		remoteServer.setRemoteName("MockConfluence");
		remoteServer.setRemoteUrl("https://wiki.shanti.virginia.edu");
		contextStore.put(remoteServer.getRemoteName(), createMockContextList(remoteServer));
		remoteServer.setRemoteName("shanti-wiki");
		contextStore.put(remoteServer.getRemoteName(), createMockContextList(remoteServer));
	}

	private LinkedList<RemoteContextChoice> createMockContextList(RemoteServer config) {
		String[] wikiSlugs = { "OM", "SHANTI", "KB", "DML", "LINK", "SHTECH" };
		
		String serverBaseUrl = config.getRemoteUrl();
		String remoteName = config.getRemoteName();

		// need to pass authentication information
		
		// Mocked data
		LinkedList<RemoteContextChoice> contextList = new LinkedList<RemoteContextChoice>();
		for (int i = 0; i < wikiSlugs.length; i++) {
			String slug = wikiSlugs[i];
			RemoteContextChoice rc = newRemoteContextChoice(serverBaseUrl,
					remoteName, slug);
			contextList.add(rc);
			System.err.println("adding " + rc);
		}
		
		return contextList;
	}

	private RemoteContextChoice newRemoteContextChoice(String serverBaseUrl,
			String remoteName, String slug) {
		RemoteContextChoice rc  = new RemoteContextChoice();
		rc.setContextId(slug);
		rc.setContextLabel(slug + " wiki space");
		rc.setUrl(serverBaseUrl+ "/display/" + slug);
		rc.setRemoteName(remoteName);
		return rc;
	}
	
	

	@Override
	public List<RemoteContextChoice> getContexts(RemoteServer config) {
		return contextStore.get(config.getRemoteName());
	}

	@Override
	public RemoteContext createRemoteContext(RemoteContext newctx) {
		
		RemoteContextChoice rcc = new RemoteContextChoice();
		rcc.setContextId(newctx.getContextId());
		rcc.setContextLabel(newctx.getContextLabel());
		rcc.setUrl(newctx.getUrl());
		contextStore.get(newctx.getRemoteName()).add(rcc);
		
		RemoteContext rc = new RemoteContext();
		rc.populate(rcc);
		return rc;
	}

	@Override
	public String getSummaryMarkup(RemoteContext remoteContext) {
		return null;
	}
	
	@Override
	public RemotePermissions getRemotePermissions(RemoteContext remoteContext) {
		return null;	
	}

}
