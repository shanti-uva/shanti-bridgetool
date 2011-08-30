package edu.virginia.shanti.om.bridge.remote.impl;

import java.security.Principal;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.serializable.RooSerializable;
import org.springframework.roo.addon.tostring.RooToString;
import org.springframework.stereotype.Service;

import edu.virginia.shanti.om.bridge.domain.PermissionMap;
import edu.virginia.shanti.om.bridge.domain.RemoteContext;
import edu.virginia.shanti.om.bridge.domain.RemoteServer;
import edu.virginia.shanti.om.bridge.form.ConfigBean;
import edu.virginia.shanti.om.bridge.form.RemoteContextChoice;
import edu.virginia.shanti.om.bridge.remote.RemoteConnector;
import edu.virginia.shanti.om.bridge.remote.RemotePermissions;

@RooJavaBean
@RooToString
@RooSerializable
@Service
public class MockConfluenceConnector implements RemoteConnector {

	private static String MOCKUSER = "ys2n";
	
	public class MockPrincipal implements Principal {

		@Override
		public String getName() {
			return MOCKUSER;
		}

	}

	private static final long serialVersionUID = 6670877131155240894L;
	private Map<String, LinkedList<RemoteContextChoice>> contextStore = new HashMap<String, LinkedList<RemoteContextChoice>>();

	public MockConfluenceConnector() {

		Principal principal = new MockPrincipal();

		RemoteServer remoteServer = new RemoteServer();
		remoteServer.setImplementationName("mockConfluenceConnector");
		remoteServer.setRemoteName("MockConfluence");
		remoteServer.setRemoteUrl("https://wiki.shanti.virginia.edu");
		contextStore.put(MOCKUSER + ":" + remoteServer.getRemoteName(),
				createMockContextList(principal, remoteServer));
		remoteServer.setRemoteName("shanti-wiki");
		contextStore.put(MOCKUSER + ":" + remoteServer.getRemoteName(),
				createMockContextList(principal, remoteServer));
	}

	private LinkedList<RemoteContextChoice> createMockContextList(
			Principal principal, RemoteServer config) {
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
			// System.err.println("adding " + rc);
		}

		return contextList;
	}

	private RemoteContextChoice newRemoteContextChoice(String serverBaseUrl,
			String remoteName, String slug) {
		RemoteContextChoice rc = new RemoteContextChoice();
		rc.setContextId(slug);
		rc.setContextLabel(slug + " wiki space");
		rc.setUrl(serverBaseUrl + "/display/" + slug);
		rc.setRemoteName(remoteName);
		return rc;
	}

	@Override
	public List<RemoteContextChoice> getContexts(Principal principal, RemoteServer remote, ConfigBean config) {
		return contextStore.get(principal.getName() + ":" + remote.getRemoteName());
	}

	@Override
	public RemoteContext createRemoteContext(Principal principal, RemoteContext newctx, ConfigBean config) {

		RemoteContextChoice rcc = new RemoteContextChoice();
		rcc.setContextId(newctx.getContextId());
		rcc.setContextLabel(newctx.getContextLabel());
		rcc.setUrl(newctx.getUrl());
		contextStore.get(principal + ":" + newctx.getRemoteName()).add(rcc);

		RemoteContext rc = new RemoteContext();
		rc.populate(rcc);
		return rc;
	}

	@Override
	public String getSummaryMarkup(Principal principal, RemoteContext remoteContext) {
		return "<html><body><html>crap</html></body></html>";
	}

	@Override
	public RemotePermissions getRemotePermissions(Principal principal, String localContext, RemoteContext remoteContext) {
		return null;
	}	

	@Override
	public void setRemotePermissions(Principal principal, String localContext, 
			RemoteContext remoteContext, PermissionMap permissionMap) {
		// TODO Auto-generated method stub
		throw new RuntimeException("not yet implemented");
		
	}

}
