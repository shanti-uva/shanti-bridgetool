package edu.virginia.shanti.om.bridge.service;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.serializable.RooSerializable;
import org.springframework.roo.addon.tostring.RooToString;
import org.springframework.stereotype.Service;
import org.springframework.webflow.execution.RequestContext;

import edu.virginia.shanti.om.bridge.domain.Bridge;
import edu.virginia.shanti.om.bridge.domain.RemoteContext;
import edu.virginia.shanti.om.bridge.form.ConfigBean;
import edu.virginia.shanti.om.bridge.form.ConfluenceConfigBean;

@RooJavaBean
@RooToString
@RooSerializable
@Service
public class BridgeService {

	private static final long serialVersionUID = 3808409343349062908L;

	@Autowired
	private RemoteServerService remoteServerService;

	private Log log = LogFactory.getLog(BridgeService.class);

	/**
	 * Tells whether the localContext and localSubContext are configured
	 * 
	 * @param localContext
	 * @param localSubContext
	 * @return String, either"configured" or "unconfigured"
	 */
	public String checkConfig(ConfigBean config) {
		log.info("XXX config = " + config);
		List<Bridge> bridgeList = getBridges(config);
		String conf = (bridgeList.isEmpty()) ? "unconfigured" : "configured";
		return conf;
	}

	/**
	 * Returns List of Bridges configured for the localContext and
	 * localSubContext (can be empty).
	 * 
	 * @param localContext
	 * @param localSubContext
	 *            (can be null)
	 * @return List<Bridge> all Bridges that match localContext (and
	 *         localSubContext if not null)
	 */
	public List<Bridge> getBridges(ConfigBean config) {
		List<Bridge> candidateList = Bridge.findBridgesByLocalContext(
				config.getLocalContext()).getResultList();
		List<Bridge> bridgeList = new LinkedList<Bridge>();
		for (Iterator<Bridge> iterator = candidateList.iterator(); iterator
				.hasNext();) {
			Bridge bridge = (Bridge) iterator.next();
			// if localSubContext is null then return all bridges for this
			// context otherwise only return subcontexts that match
			if (config.getLocalSubContext() == null
					|| config.getLocalSubContext().equals(
							bridge.getLocalSubContext())) {

				// if the remote service is null return all the services
				// otherwise return only those that match the config
				if (config.getRemoteService() == null
						|| bridge.getRemoteContext().getRemoteName()
								.equals(config.getRemoteService())) {
					bridgeList.add(bridge);
				}
			}
		}
		return bridgeList;
	}

	/**
	 * Convenience method to return List of Bridges for localContext.
	 * 
	 * @param localContext
	 * @return List of Bridges (can be empty).
	 */
	public List<Bridge> getBridges(String user, String localContext) {
		// TODO: needs test

		ConfigBean config = new ConfluenceConfigBean(user, localContext, null,
				null, System.currentTimeMillis());
		return getBridges(config);
	}

	/**
	 * Convenience method for getting single Bridge for localContext and
	 * localSubContext
	 * 
	 * @param localContext
	 * @param localSubContext
	 * @return Bridge for localContext and localSubContext. Will return null, if
	 *         not found
	 * @throws RuntimeException
	 *             if more than one Bridge is found.
	 */
	public Bridge getBridge(ConfigBean config) {
		List<Bridge> bridges = getBridges(config);
		Bridge bridge = null;
		if (bridges.size() > 1) {
			throw new RuntimeException(
					"Multiple Bridges configured for context:\n"
							+ "localContext: " + config.getLocalContext()
							+ "\n" + "localSubContext: "
							+ config.getLocalSubContext() + "\n"
							+ "This shouldn't happen.");
		}
		if (!bridges.isEmpty()) {
			bridge = bridges.get(0);
		}
		return bridge;
	}

	public Bridge newBridge(ConfigBean config) {
		return newBridge(config, null);
	}

	public Bridge newBridge(ConfigBean config, RemoteContext remoteContext) {
		Bridge bridge = new Bridge();
		bridge.setLocalContext(config.getLocalContext());
		bridge.setLocalSubContext(config.getLocalSubContext());
		bridge.setRemoteName(config.getRemoteService());
		if (remoteContext != null) {
			bridge.setRemoteContext(remoteContext);
		}
		return bridge;
	}

	public Bridge createNewBridge(ConfigBean config, RemoteContext remoteContext) {
		Bridge newBridge = newBridge(config, remoteContext);
		newBridge.persist();
		return newBridge;
	}

	public void save(Bridge bridge) {

		log.info("Bridge before persisting or merging: " + bridge);

		RemoteContext rc = bridge.getRemoteContext();
		// find and replace if necessary

		List<RemoteContext> list = RemoteContext
				.findRemoteContextsByRemoteNameAndContextId(rc.getRemoteName(),
						rc.getContextId()).getResultList();

		if (list.size() == 1) {
			// let's replace it with the saved one
			log.info("using existing RemoteContext " + rc);
			rc = list.get(0);
			bridge.setRemoteContext(rc.merge());
		} else if (list.size() == 0) {
			log.info("persisting new RemoteContext " + rc);
			rc.persist();
		} else {
			throw new RuntimeException(
					"Too many RemoteContexts returned for remoteName="
							+ rc.getRemoteName() + " contextId="
							+ rc.getContextId());
		}

		if (bridge.getId() != null) {
			log.info("merging bridge: " + bridge);
			bridge = bridge.merge();
		} else {
			log.info("persisting new Bridge: " + bridge);
			bridge.persist();
		}
	}

	public ConfigBean populateConfigFromContext(RequestContext request) {
		return populateConfigFromContext(request, new ConfluenceConfigBean());
	}

	public ConfigBean populateConfigFromContext(RequestContext request,
			ConfigBean config) {
		// TODO: should sanitize!
		//
		// log.warn("populateConfigFromContext()");
		//
		// log.warn("Attributes: " + request.getAttributes());
		//
		// String user = null;
		//
		// GestaltBean gestalt = (GestaltBean) request.getExternalContext()
		// .getGlobalSessionMap().get("gestalt");
		//
		// if (user == null && request.getAttributes() != null) {
		// user = request.getAttributes().getString("user");
		// }
		//
		// if (user == null && gestalt != null) {
		// user = gestalt.getUser();
		// }
		//
		// if (user == null && request.getExternalContext() != null) {
		// user = (String) request.getExternalContext().getRequestMap()
		// .get("user");
		// }
		//
		// if (user != null) {
		// config.setUser(user);
		// }
		//
		// System.err.println("user = " + user);

		if (config.getTimestamp() == null) {
			config.setTimestamp(System.currentTimeMillis());
		}

		if (config.getUser() == null) {
			config.setUser((String) request.getExternalContext()
					.getRequestMap().get("user"));
		}

		if (config.getLocalContext() == null) {
			config.setLocalContext((String) request.getExternalContext()
					.getRequestMap().get("localContext"));
		}

		if (config.getLocalSubContext() == null) {
			config.setLocalSubContext((String) request.getExternalContext()
					.getRequestMap().get("localSubContext"));
		}

		if (config.getRemoteService() == null) {
			// TODO: need to populate remote service intelligently
			config.setRemoteService("shanti-wiki");
		}

		return config;
	}

	public String getSummaryMarkup(Bridge bridge) {
		return remoteServerService.getSummaryMarkup(bridge.getRemoteContext());
	}
}
