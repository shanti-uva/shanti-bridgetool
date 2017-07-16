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
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.googlecode.ehcache.annotations.Cacheable;
import com.googlecode.ehcache.annotations.KeyGenerator;
import com.googlecode.ehcache.annotations.PartialCacheKey;

import edu.virginia.shanti.om.bridge.domain.PermissionMap;
import edu.virginia.shanti.om.bridge.domain.PermissionSet;
import edu.virginia.shanti.om.bridge.domain.RemoteContext;
import edu.virginia.shanti.om.bridge.domain.RemoteServer;
import edu.virginia.shanti.om.bridge.form.ConfigBean;
import edu.virginia.shanti.om.bridge.form.RemoteContextChoice;
import edu.virginia.shanti.om.bridge.remote.RemoteConnector;
import edu.virginia.shanti.om.bridge.remote.RemotePermissions;
import edu.virginia.shanti.om.bridge.service.SiteAliasService;
import edu.virginia.shanti.om.bridge.soap.confluence.AuthenticationFailedException;
import edu.virginia.shanti.om.bridge.soap.confluence.ConfluenceSoapService;
import edu.virginia.shanti.om.bridge.soap.confluence.ConfluenceSoapServiceServiceLocator;
import edu.virginia.shanti.om.bridge.soap.confluence.InvalidSessionException;
import edu.virginia.shanti.om.bridge.soap.confluence.NotPermittedException;
import edu.virginia.shanti.om.bridge.soap.confluence.RemoteException;
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

	private static final String[] ALL_PERMISSIONS = { "EDITSPACE", "EXPORTSPACE", "SETSPACEPERMISSIONS",
			"SETPAGEPERMISSIONS", "REMOVEMAIL", "REMOVEBLOG", "EXPORTPAGE", "REMOVEATTACHMENT", "CREATEATTACHMENT",
			"VIEWSPACE", "EDITBLOG", "REMOVECOMMENT", "REMOVEPAGE", "COMMENT" };

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

	@Autowired
	private ConfluencePermissionsProxy permissionsProxy;

	private ConfluenceSessionCache sessionCache;

	public ConfluenceConnector() {
		super();
		confLocator = new ConfluenceSoapServiceServiceLocator();
		sudoLocator = new SudoSoapServiceLocator();
	}

	public ConfluenceConnector(String baseUrl) {
		this();
		getConfLocator().setConfluenceserviceV1EndpointAddress(baseUrl + "/rpc/soap-axis/confluenceservice-v1");
		getSudoLocator().setsudoEndpointAddress(baseUrl + "/rpc/soap-axis/sudo");
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
	@Cacheable(cacheName = "remoteContextChoices", keyGenerator = @KeyGenerator(name = "StringCacheKeyGenerator"))
	public List<RemoteContextChoice> getContexts(@PartialCacheKey Principal principal,
			@PartialCacheKey RemoteServer remoteServer, ConfigBean bean) {

		if (log.isDebugEnabled()) {
			log.debug("Someone called getContexts with " + principal + " and " + remoteServer, new Exception());
		}

		try {
			ConfluenceSoapService conf = getConfLocator().getConfluenceserviceV1();

			// if (!assureUser(principal)) {
			// throw new RuntimeException("User " + principal.getName() +
			// " is not a confluence user, and could not be created.");
			// }

			String sess = login(principal);

			RemoteSpaceSummary[] spaces = conf.getSpaces(sess);

			spaces = filterSpaces(conf, sess, principal.getName(), spaces);

			List<RemoteContextChoice> list = new LinkedList<RemoteContextChoice>();

			for (RemoteSpaceSummary summary : spaces) {

				log.debug(summary.getKey());

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
			log.warn(e);
		} catch (AuthenticationFailedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log.warn(e);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log.warn(e);
		} catch (java.rmi.RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			log.warn(e);
		}
		return null;
	}

	// filter spaces according to permissions
	private RemoteSpaceSummary[] filterSpaces(ConfluenceSoapService conf, String sess, String user,
			RemoteSpaceSummary[] spaces) {

		List<RemoteSpaceSummary> newList = new LinkedList<RemoteSpaceSummary>();
		for (RemoteSpaceSummary sum : spaces) {
			if ("global".equals(sum.getType())) {

				try {

					log.debug("Space summary: " + sum.getKey());
					String[] permissions = getPermissions(conf, sess, user, sum.getKey());
					log.debug("Permissions: " + Arrays.toString(permissions));

					if (Arrays.asList(permissions).contains("admin")) {
						log.debug("=========> found admin");
						newList.add(sum);
					}

				} catch (InvalidSessionException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (RemoteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (java.rmi.RemoteException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

		RemoteSpaceSummary[] newArray = newList.toArray(new RemoteSpaceSummary[newList.size()]);

		log.debug("Returning:  " + newArray);
		return newArray;
	}

	public String[] getPermissions(ConfluenceSoapService conf, String sess, String user, String key)
			throws java.rmi.RemoteException, InvalidSessionException, RemoteException {
		return permissionsProxy.getPermissions(conf, sess, user, key);
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
	public RemoteContext createRemoteContext(Principal principal, RemoteContext newContext, ConfigBean config) {
		try {

			// TODO: use remote server attribute of new context to
			// determine/verify
			// which server to contact

			ConfluenceSoapService conf = getConfLocator().getConfluenceserviceV1();
			String sess = loginAdmin(); // login(principal);
			RemoteSpace rs = new RemoteSpace();
			rs.setKey(newContext.getContextId());
			rs.setName(newContext.getContextLabel());
			rs.setDescription("Auto-generated space which needs more of a description.");

			RemoteSpace newSpace = conf.addSpace(sess, rs);
			newContext.setUrl(newSpace.getUrl());
			newContext.persist();

			assurePermissions(principal, conf, sess, newSpace);

			try {
				conf.logout(sess);
			} catch (RemoteException e) {
				// ignore
				e.printStackTrace();
			} catch (java.rmi.RemoteException e) {
				// ignore
				e.printStackTrace();
			}

		} catch (Exception e) {
			throw new RuntimeException(e);
		}

		return newContext;
	}

	private void assurePermissions(Principal principal, ConfluenceSoapService conf, String sess, RemoteSpace newSpace)
			throws java.rmi.RemoteException, RemoteException {

		boolean userExists = assureUser(principal);

		if (userExists) {
			String user = principal.getName();
			String[] permissions = ALL_PERMISSIONS;
			boolean success = conf.addPermissionsToSpace(sess, permissions, user, newSpace.getKey());

			if (success) {
				log.info("Gave user " + user + " all permissions in " + newSpace.getKey());
			} else {
				log.warn("Failed to give user " + user + " all permissions in " + newSpace.getKey());
				// throw new RuntimeException("Failed to give user " + user
				// + " all permissions in " + newSpace.getKey());
			}
		} else {

			throw new RuntimeException("User " + principal.getName() + " does not exist and could not be created!");

		}
	}

	protected boolean assureUser(Principal principal) {
		// TODO Auto-generated method stub
		String user = principal.getName().toLowerCase();

		try {
			String adminSess = loginAdmin();

			ConfluenceSoapService conf = getConfLocator().getConfluenceserviceV1();

			if (!conf.hasUser(adminSess, user)) {
				createUser(conf, adminSess, user);
			}

			return true;

		} catch (ServiceException e) {
			log.warn(e);
		} catch (InvalidSessionException e) {
			log.warn(e);
		} catch (RemoteException e) {
			log.warn(e);
		} catch (java.rmi.RemoteException e) {
			log.warn(e);
		}

		// fall through only if there was a problem.
		return false;

	}

	private void createUser(ConfluenceSoapService conf, String adminSess, String user)
			throws java.rmi.RemoteException, InvalidSessionException, NotPermittedException, RemoteException {

		RemoteUser ruser = new RemoteUser();
		String email = determineEmail(user);

		ruser.setName(user);
		ruser.setEmail(email);
		ruser.setFullname(user);

		conf.addUser(adminSess, ruser, user);

	}

	private String determineEmail(String user) {
		String email;
		if (user.contains("@")) {
			email = user;
		} else {
			email = user + "@virginia.edu";
		}
		return email;
	}

	private String login(Principal principal)
			throws java.rmi.RemoteException, AuthenticationFailedException, RemoteException, ServiceException {

		String sess = null;

		if (sessionCache != null) {
			sess = sessionCache.getConfluenceUserSession();
		}

		if (sess == null) {
			System.err.println("Authorities during login(): "
					+ SecurityContextHolder.getContext().getAuthentication().getAuthorities());

			SudoSoap sudo = getSudoLocator().getsudo();
			sess = loginAdmin();

			if (!assureUser(principal)) {
				throw new RuntimeException("Could not find or create user " + principal.getName());
			}

			if (principal == null) {
				throw new RuntimeException("Principal cannot be null");
			}

			// sudo.sudo(sess, sess, principal.getName());
			log.info("Sudo to " + principal.getName() + "successful for sess=" + sess);

			if (sessionCache != null) {
				sessionCache.setConfluenceUserSession(sess);
			}
		}

		return sess;
	}

	private String loginAdmin()
			throws java.rmi.RemoteException, AuthenticationFailedException, RemoteException, ServiceException {

		String sess = null;

		SudoSoap sudo = getSudoLocator().getsudo();
		sess = sudo.login(adminUser, adminPassword);
		log.debug("Got admin session = " + sess);

		return sess;
	}

	@Override
	public String getSummaryMarkup(Principal principal, RemoteContext remoteContext) {
		ConfluenceSoapService conf;
		try {

			// Let's do this as admin, so that if the current user hasn't yet
			// logged into Confluence it won't bomb.

			// TODO: handle the case where the current user can't read the
			// summary
			conf = getConfLocator().getConfluenceserviceV1();
			String sess = loginAdmin();

			String spacekey = remoteContext.getContextId();
			RemoteSpace space = conf.getSpace(sess, spacekey);

			long pageid = space.getHomePage();

			HashMap<String, String> params = new HashMap<String, String>();
			// params.put("style", "clean");

			String theme = ""; // "|theme=concise";

			return conf.renderContent(sess, spacekey, pageid,
					"{recently-updated-dashboard:spaces=" + spacekey + theme + "}", params);

		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public RemotePermissions getRemotePermissions(Principal principal, String localContext,
			RemoteContext remoteContext) {

		// unimplementable for confluence as there is no remote procedure call
		// to retrieve this information (!)
		return null;

	}

	public void removeRemoteContext(Principal principal, RemoteContext remoteContext) {
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
	public void setRemotePermissions(Principal principal, String localContext, RemoteContext remoteContext,
			PermissionMap permissionMap) {

		if (permissionMap == null || permissionMap.getPermissionSets().isEmpty()) {
			throw new IllegalArgumentException("PermissionMap cannot be null or empty. localContext=" + localContext
					+ " remoteContext = " + remoteContext + " permissionMap = " + permissionMap);
		}

		try {
			ConfluenceSoapService conf = getConfLocator().getConfluenceserviceV1();
			String adminSess = loginAdmin();
			String userSess = login(principal);

			for (PermissionSet remotePermissions : permissionMap.getPermissionSets()) {

				String roleName = remotePermissions.getGroupName();
				String spaceId = remoteContext.getContextId();
				String spaceAlias = siteAliasService.getAliasForSiteId(localContext);

				String groupName = (spaceAlias + "/" + roleName).toLowerCase();
				String[] permissions = remotePermissions.getPermissions();

				log.debug("remotePerms: " + Arrays.toString(remotePermissions.getPermissions()));
				log.debug("groupName: " + groupName);
				log.debug("contextId: " + spaceId);

				// creating the group can only be done by admin
				if (!conf.hasGroup(adminSess, groupName)) {
					conf.addGroup(adminSess, groupName);
				}

				// adding the permissions should be done as the user
				// so that permissions on the space are respected.

				long start = System.currentTimeMillis();
				boolean success = conf.addPermissionsToSpace(userSess, permissions, groupName, spaceId);
				long finish = System.currentTimeMillis();
				System.err.println("addPermssions() took: " + (finish - start));

				log.info("Call addPermissionsToSpace for " + groupName + " in space " + spaceId + " returned "
						+ success);

				if (!success) {
					throw new RuntimeException("addPermissionToSpace was unsuccessful!");
				}
			}

		} catch (Exception e) {
			throw new RuntimeException(e);
		}

	}

}
