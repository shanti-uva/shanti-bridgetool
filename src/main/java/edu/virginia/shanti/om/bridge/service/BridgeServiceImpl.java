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
import org.springframework.transaction.annotation.Transactional;
import org.springframework.webflow.execution.RequestContext;

import edu.virginia.shanti.om.bridge.domain.Bridge;
import edu.virginia.shanti.om.bridge.domain.PermissionMap;
import edu.virginia.shanti.om.bridge.domain.RemoteContext;
import edu.virginia.shanti.om.bridge.domain.SiteAlias;
import edu.virginia.shanti.om.bridge.form.ConfigBean;
import edu.virginia.shanti.om.bridge.form.ConfluenceConfigBean;

@RooJavaBean
@RooToString
@RooSerializable
@Service("bridgeService")
public class BridgeServiceImpl implements BridgeService {

	private static final long serialVersionUID = 3808409343349062908L;

	@Autowired
	private RemoteServerService remoteServerService;

	@Autowired
	private SiteAliasService siteAliasService;

	@Autowired
	private PermissionMapService permissionMapService;

	private Log log = LogFactory.getLog(BridgeServiceImpl.class);

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.virginia.shanti.om.bridge.service.BridgeService#checkConfig(edu.virginia
	 * .shanti.om.bridge.form.ConfigBean)
	 */
	@Override
	public boolean checkConfig(ConfigBean config) {
		List<Bridge> bridgeList = getBridges(config);
		return !bridgeList.isEmpty();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.virginia.shanti.om.bridge.service.BridgeService#getBridges(edu.virginia
	 * .shanti.om.bridge.form.ConfigBean)
	 */
	@Override
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.virginia.shanti.om.bridge.service.BridgeService#getBridges(java.lang
	 * .String, java.lang.String)
	 */
	@Override
	public List<Bridge> getBridges(String user, String localContext) {
		// TODO: needs test

		ConfigBean config = new ConfluenceConfigBean(user, localContext, null,
				null);
		return getBridges(config);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.virginia.shanti.om.bridge.service.BridgeService#getBridge(edu.virginia
	 * .shanti.om.bridge.form.ConfigBean)
	 */
	@Override
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.virginia.shanti.om.bridge.service.BridgeService#newBridge(edu.virginia
	 * .shanti.om.bridge.form.ConfigBean)
	 */
	@Override
	public Bridge newBridge(ConfigBean config) {
		return newBridge(config, null);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.virginia.shanti.om.bridge.service.BridgeService#newBridge(edu.virginia
	 * .shanti.om.bridge.form.ConfigBean,
	 * edu.virginia.shanti.om.bridge.domain.RemoteContext)
	 */
	@Override
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

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.virginia.shanti.om.bridge.service.BridgeService#createNewBridge(edu
	 * .virginia.shanti.om.bridge.form.ConfigBean,
	 * edu.virginia.shanti.om.bridge.domain.RemoteContext)
	 */
	@Override
	public Bridge createNewBridge(ConfigBean config, RemoteContext remoteContext) {
		Bridge newBridge = newBridge(config, remoteContext);
		save(newBridge);
		return newBridge;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.virginia.shanti.om.bridge.service.BridgeService#save(edu.virginia
	 * .shanti.om.bridge.domain.Bridge)
	 */
	@Override
	@Transactional
	public void save(Bridge bridge) {

		log.info("Bridge before persisting or merging: " + bridge);

		log.info("Bridge getId(): " + bridge.getId());

		// if (bridge.getId() != null && bridge.getId() != 0) {
		//
		// RemoteContext remoteContext = bridge.getRemoteContext();
		// if (remoteContext.getId() != null && remoteContext.getId() != 0) {
		// List<RemoteContext> list = RemoteContext
		// .findRemoteContextsByRemoteNameAndContextId(
		// remoteContext.getRemoteName(),
		// remoteContext.getContextId()).getResultList();
		//
		// if (list.size() > 0) {
		// bridge.setRemoteContext(list.get(0));
		// } else {
		// remoteContext.persist();
		// }
		//
		// } else {
		// bridge.setRemoteContext(remoteContext.merge());
		// }
		// bridge = bridge.merge();
		// }

		RemoteContext rc = bridge.getRemoteContext();

		// Update RemoteContext if it already exists, create if it doesn't
		List<RemoteContext> list = RemoteContext
				.findRemoteContextsByRemoteNameAndContextId(rc.getRemoteName(),
						rc.getContextId()).getResultList();

		if (list.size() == 1) {
			// let's replace it with the saved one
			log.info("using existing RemoteContext " + rc);
			rc = list.get(0).merge();
			bridge.setRemoteContext(rc);
		} else if (list.size() == 0) {
			log.info("persisting new RemoteContext " + rc);
			rc.persist();
		} else {
			throw new RuntimeException(
					"Too many RemoteContexts returned for remoteName="
							+ rc.getRemoteName() + " contextId="
							+ rc.getContextId());
		}

		// find and/or establish site alias
		SiteAlias siteAlias = siteAliasService.findSiteAliasBySiteId(bridge
				.getLocalContext());

		System.err.println("found sitealias " + siteAlias + " for siteId "
				+ bridge.getLocalContext());

		bridge.setSiteAlias(siteAlias);

		System.err.println("using alias: " + siteAlias);
		siteAliasService.registerAlias(siteAlias, bridge);

		// Update Bridge if it already exists, create if it doesn't
		List<Bridge> blist = Bridge.findBridgesByLocalSubContext(
				bridge.getLocalSubContext()).getResultList();
		if (blist.size() == 1) {
			// let's replace it with the saved one
			log.info("using existing Bridge " + bridge);
			bridge = blist.get(0);
			bridge.setRemoteContext(rc);
			fixPermissionMap(bridge);
			bridge.persist();
		} else if (blist.size() == 0) {
			log.info("persisting new Bridge " + bridge);
			fixPermissionMap(bridge);
			bridge.persist();
		} else {
			throw new RuntimeException(
					"Too many Bridges returned for localSubContext="
							+ bridge.getLocalSubContext());
		}

		//
		remoteServerService.writePermissionMap(bridge.getLocalContext(),
				bridge.getRemoteContext(), bridge.getPermissionMap());

	}

	private void fixPermissionMap(Bridge bridge) {
		if (bridge.getPermissionMap() == null) {
			PermissionMap pm = permissionMapService.getPermissionMap(bridge);
			bridge.setPermissionMap(pm);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.virginia.shanti.om.bridge.service.BridgeService#populateConfigFromContext
	 * (org.springframework.webflow.execution.RequestContext)
	 */
	@Override
	public ConfigBean populateConfigFromContext(RequestContext request) {
		return populateConfigFromContext(request, new ConfluenceConfigBean());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.virginia.shanti.om.bridge.service.BridgeService#populateConfigFromContext
	 * (org.springframework.webflow.execution.RequestContext,
	 * edu.virginia.shanti.om.bridge.form.ConfigBean)
	 */
	@Override
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
			String service = request.getExternalContext().getRequestMap()
					.getString("service");

			if (service == null) {
				service = "shanti-wiki"; // default for now
			}
			
			String serviceLabel = "";
			if (service.equals("shanti-wiki")) {
				serviceLabel="Confluence";
			} else if (service.equals("")) {
				serviceLabel="NowComment";
			}
			config.setRemoteService(service);
			config.setServiceLabel(serviceLabel);

		}

		return config;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.virginia.shanti.om.bridge.service.BridgeService#getSummaryMarkup(
	 * edu.virginia.shanti.om.bridge.domain.Bridge)
	 */
	@Override
	public String getSummaryMarkup(Bridge bridge) {
		return remoteServerService.getSummaryMarkup(bridge.getRemoteContext());
	}

	@Override
	public boolean isAdmin(Bridge bridge) {
		// this is an adapter method to return true or false
		try {
			return adminCheck(bridge);
		} catch (Exception e) {
			log.info(e.getMessage());
		}
		return false;
	}

	@Override
	public boolean adminCheck(Bridge bridge) {
		// this is an advised method that should throw an exception if false
		return true;
	}

	@Override
	public void remove(Bridge bridge) {
		bridge.remove();
	}
}
