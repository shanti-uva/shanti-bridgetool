package edu.virginia.shanti.om.bridge.service;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.roo.addon.tostring.RooToString;
import org.springframework.stereotype.Service;

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
	public void onApplicationEvent(ContextRefreshedEvent event) {

		// it would be nice develop a file-based serialization of the data (xml
		// or json), so that its a bit more flexible. Using a spring bean xml file
		// might work.

		RemoteServer remoteServer = new RemoteServer();
		remoteServer.setImplementationName("confluenceConnector");
		remoteServer.setRemoteName("shanti-wiki");
		remoteServer.setRemoteUrl("https://wiki-test.shanti.virginia.edu");

		if (RemoteServer
				.findRemoteServersByRemoteName(remoteServer.getRemoteName())
				.getResultList().size() == 0) {
			log.info("Loading " + remoteServer.getRemoteName() + ": "
					+ remoteServer);
			remoteServer.persist();
			remoteServer.flush();
			log.info("Loaded " + remoteServer);
		}
	}
}
