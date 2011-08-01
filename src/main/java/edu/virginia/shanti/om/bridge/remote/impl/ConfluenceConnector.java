package edu.virginia.shanti.om.bridge.remote.impl;

import java.security.Principal;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import javax.xml.rpc.ServiceException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.roo.addon.serializable.RooSerializable;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import edu.virginia.shanti.om.bridge.domain.PermissionMap;
import edu.virginia.shanti.om.bridge.domain.PermissionSet;
import edu.virginia.shanti.om.bridge.domain.RemoteContext;
import edu.virginia.shanti.om.bridge.domain.RemoteServer;
import edu.virginia.shanti.om.bridge.form.RemoteContextChoice;
import edu.virginia.shanti.om.bridge.remote.ConfluenceRemotePermissions;
import edu.virginia.shanti.om.bridge.remote.RemoteConnector;
import edu.virginia.shanti.om.bridge.remote.RemotePermissions;
import edu.virginia.shanti.om.bridge.service.SiteAliasService;
import edu.virginia.shanti.om.bridge.soap.confluence.AuthenticationFailedException;
import edu.virginia.shanti.om.bridge.soap.confluence.ConfluenceSoapService;
import edu.virginia.shanti.om.bridge.soap.confluence.ConfluenceSoapServiceServiceLocator;
import edu.virginia.shanti.om.bridge.soap.confluence.InvalidSessionException;
import edu.virginia.shanti.om.bridge.soap.confluence.RemoteException;
import edu.virginia.shanti.om.bridge.soap.confluence.RemotePermission;
import edu.virginia.shanti.om.bridge.soap.confluence.RemoteSpace;
import edu.virginia.shanti.om.bridge.soap.confluence.RemoteSpaceSummary;
import edu.virginia.shanti.om.bridge.soap.confluence.RemoteUser;
import edu.virginia.shanti.om.bridge.soap.confluence.SudoSoap;
import edu.virginia.shanti.om.bridge.soap.confluence.SudoSoapServiceLocator;

@Service
@Component
@RooSerializable
public class ConfluenceConnector implements RemoteConnector {

	private static final long serialVersionUID = 7461979436195181130L;

	private Log log = LogFactory.getLog(ConfluenceConnector.class);

	// @Value("#{appConfiguration.adminUser}")
	@Value("${adminUser}")
	public String adminUser;

	// @Value("#{appConfiguration.adminPassword}")

	@Value("${adminPassword}")
	public String adminPassword;

	transient private ConfluenceSoapServiceServiceLocator confLocator;

	transient private SudoSoapServiceLocator sudoLocator;

	@Autowired
	private SiteAliasService siteAliasService;

	public ConfluenceConnector() {
		super();
		confLocator = new ConfluenceSoapServiceServiceLocator();
		sudoLocator = new SudoSoapServiceLocator();
	}

	public ConfluenceConnector(String baseUrl) {
		this();
		getConfLocator().setConfluenceserviceV1EndpointAddress(
				baseUrl + "/rpc/soap-axis/confluenceservice-v1");
		getSudoLocator()
				.setsudoEndpointAddress(baseUrl + "/rpc/soap-axis/sudo");
	}

	private ConfluenceSoapServiceServiceLocator getConfLocator() {
		if (confLocator == null) {
			confLocator = new ConfluenceSoapServiceServiceLocator();
		}
		return confLocator;
	}

	private SudoSoapServiceLocator getSudoLocator() {
		if (sudoLocator == null) {
			sudoLocator = new SudoSoapServiceLocator();
		}
		return sudoLocator;
	}

	@Override
	public List<RemoteContextChoice> getContexts(Principal principal,
			RemoteServer remoteServer) {
		try {
			ConfluenceSoapService conf = getConfLocator()
					.getConfluenceserviceV1();

			String sess = login(principal);

			RemoteSpaceSummary[] spaces = conf.getSpaces(sess);

			List<RemoteContextChoice> list = new LinkedList<RemoteContextChoice>();

			for (RemoteSpaceSummary summary : spaces) {

				System.err.print(summary);

				RemoteContextChoice choice = new RemoteContextChoice();
				choice.setContextId(summary.getKey());
				choice.setContextLabel(summary.getName());
				choice.setRemoteName(remoteServer.getRemoteName());
				choice.setUrl(summary.getUrl());

				list.add(choice);

			}
			return list;

		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (AuthenticationFailedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (java.rmi.RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.virginia.shanti.om.bridge.remote.RemoteConnector#createRemoteContext
	 * (edu.virginia.shanti.om.bridge.domain.RemoteContext)
	 */
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	@Override
	public RemoteContext createRemoteContext(Principal principal,
			RemoteContext newContext) {
		try {

			// TODO: use remote server attribute of new context to
			// determine/verify
			// which server to contact

			ConfluenceSoapService conf = getConfLocator()
					.getConfluenceserviceV1();
			String sess = loginAdmin();  // login(principal);
			RemoteSpace rs = new RemoteSpace();
			rs.setKey(newContext.getContextId());
			rs.setName(newContext.getContextLabel());
			rs.setDescription("Auto-generated space which needs more of a description.");
			RemoteSpace newSpace = conf.addSpace(sess, rs);
			try {
				conf.logout(sess);
			} catch (RemoteException e) {
				// ignore
				e.printStackTrace();
			} catch (java.rmi.RemoteException e) {
				// ignore
				e.printStackTrace();
			}
			newContext.setUrl(newSpace.getUrl());
			newContext.persist();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

		return newContext;
	}

	private String login(Principal principal) throws java.rmi.RemoteException,
			AuthenticationFailedException, RemoteException, ServiceException {

		SudoSoap sudo = getSudoLocator().getsudo();
		// ConfluenceSoapService conf =
		// getConfLocator().getConfluenceserviceV1();
		String sess = loginAdmin();

		if (principal != null) {
			log.info("Got admin session = " + sess + " trying to sudo to "
					+ principal.getName());

			sudo.sudo(sess, sess, principal.getName());
			log.info("Sudo to " + principal.getName() + "successful for sess="
					+ sess);
		}
		return sess;
	}

	private String loginAdmin() throws java.rmi.RemoteException,
			AuthenticationFailedException, RemoteException, ServiceException {
		log.info("Logging in using admin user = " + adminUser);
		SudoSoap sudo = getSudoLocator().getsudo();
		String sess = sudo.login(adminUser, adminPassword);
		log.info("Got admin session = " + sess);
		return sess;
	}

	@Override
	public String getSummaryMarkup(Principal principal,
			RemoteContext remoteContext) {
		ConfluenceSoapService conf;
		try {

			// Let's do this as admin, so that if the current user hasn't yet
			// logged into Confluence it won't bomb.
			conf = getConfLocator().getConfluenceserviceV1();
			String sess = loginAdmin();

			String spacekey = remoteContext.getContextId();

			RemoteSpace space = conf.getSpace(sess, spacekey);

			long pageid = space.getHomePage();

			HashMap<String, String> params = new HashMap<String, String>();
			// params.put("style", "clean");

			String theme = ""; // "|theme=concise";

			return conf.renderContent(sess, spacekey, pageid,
					"{recently-updated-dashboard:spaces=" + spacekey + theme
							+ "}", params);

		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public RemotePermissions getRemotePermissions(Principal principal,
			String localContext, RemoteContext remoteContext) {

		// unimplementable for confluence as there is no remote procedure call
		// to retrieve this information (!)
		return null;

	}

	public void removeRemoteContext(Principal principal,
			RemoteContext remoteContext) {
		ConfluenceSoapService conf;
		try {
			conf = getConfLocator().getConfluenceserviceV1();
			String sess = login(principal);
			conf.removeSpace(sess, remoteContext.getContextId());
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

	}

	@Override
	public void setRemotePermissions(Principal principal, String localContext,
			RemoteContext remoteContext, PermissionMap permissionMap) {

		if (permissionMap == null
				|| permissionMap.getPermissionSets().isEmpty()) {
			throw new IllegalArgumentException(
					"PermissionMap cannot be null or empty. localContext="
							+ localContext + " remoteContext = "
							+ remoteContext + " permissionMap = "
							+ permissionMap);
		}

		try {
			ConfluenceSoapService conf = getConfLocator()
					.getConfluenceserviceV1();
			String adminSess = loginAdmin();
			String userSess = login(principal);

			for (PermissionSet remotePermissions : permissionMap
					.getPermissionSets()) {

				String roleName = remotePermissions.getGroupName();
				String spaceId = remoteContext.getContextId();
				String spaceAlias = siteAliasService
						.getAliasForSiteId(localContext);

				String groupName = (spaceAlias + "/" + roleName).toLowerCase();
				String[] permissions = remotePermissions.getPermissions();

				System.err.println("remotePerms: "
						+ Arrays.toString(remotePermissions.getPermissions()));
				System.err.println("groupName: " + groupName);
				System.err.println("contextId: " + spaceId);

				// creating the group can only be done by admin
				if (!conf.hasGroup(adminSess, groupName)) {
					conf.addGroup(adminSess, groupName);
				}

				// adding the permissions should be done as the user
				// so that permissions on the space are respected.
				boolean success = conf.addPermissionsToSpace(userSess,
						permissions, groupName, spaceId);

				System.err.println("Call returned " + success);

				if (!success) {
					throw new RuntimeException(
							"addPermissionToSpace was unsuccessful!");
				}
			}

		} catch (Exception e) {
			throw new RuntimeException(e);
		}

	}

}
