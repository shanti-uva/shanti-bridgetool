package edu.virginia.shanti.om.bridge.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.roo.addon.tostring.RooToString;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.virginia.shanti.om.bridge.domain.ConfluencePermissionSet;
import edu.virginia.shanti.om.bridge.domain.LocalContextType;
import edu.virginia.shanti.om.bridge.domain.LocalGroupType;
import edu.virginia.shanti.om.bridge.domain.PermissionMap;
import edu.virginia.shanti.om.bridge.domain.RemoteServer;

/**
 * Utility class to load default RemoteServer entities at startup if they don't
 * exist. The entities are currently hardcoded and that'll probably suffice for
 * development.
 * 
 * @author ys2n
 * 
 */
@Service
@RooToString
public class DbLoaderListener implements
		ApplicationListener<ContextRefreshedEvent> {

	Log log = LogFactory.getLog(DbLoaderListener.class);

	@Override
	@Transactional
	public void onApplicationEvent(ContextRefreshedEvent event) {

		// Whenever the Context is Refreshed, check to see if the data needs to
		// be initialized.

		// it would be nice develop a file-based serialization of the data (xml
		// or json), so that its a bit more flexible. Using a spring bean xml
		// file
		// might work.

		RemoteServer remoteServer = new RemoteServer();
		remoteServer.setImplementationName("confluenceConnector");
		remoteServer.setRemoteName("shanti-wiki");
		remoteServer.setRemoteUrl("https://wiki.shanti.virginia.edu");

		if (RemoteServer
				.findRemoteServersByRemoteName(remoteServer.getRemoteName())
				.getResultList().size() == 0) {
			log.info("Loading " + remoteServer.getRemoteName() + ": "
					+ remoteServer);
			remoteServer.persist();
			remoteServer.flush();
			log.info("Loaded " + remoteServer);
		}

		if (PermissionMap
				.findPermissionMapsByLocalContextType(
						LocalContextType.COLLABORATION).getResultList().size() == 0) {
			ConfluencePermissionSet p1 = new ConfluencePermissionSet();
			p1.setGroupName("Administrator");
			p1.setLocalGroupType(LocalGroupType.SAKAIROLE);
			p1.setViewSpace(true);
			p1.setEditSpace(true);
			p1.setEditBlog(true);
			p1.persist();

			ConfluencePermissionSet p2 = new ConfluencePermissionSet();
			p2.setGroupName("Member");
			p2.setLocalGroupType(LocalGroupType.SAKAIROLE);
			p2.setViewSpace(true);
			p2.setEditBlog(true);
			p2.persist();

			ConfluencePermissionSet p3 = new ConfluencePermissionSet();
			p3.setGroupName("Observer");
			p3.setLocalGroupType(LocalGroupType.SAKAIROLE);
			p3.setViewSpace(true);
			p3.persist();

			PermissionMap pm = new PermissionMap();
			pm.setLocalContextMask("*");
			pm.setLocalContextType(LocalContextType.COLLABORATION);
			pm.setName("generic collaboration");
			pm.setService("shanti-wiki");
			pm.addPermissionSet(p1);
			pm.addPermissionSet(p2);
			pm.addPermissionSet(p3);
			pm.persist();
		}
	}
}
