package edu.virginia.shanti.om.bridge.service;

import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.RemoteException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import javax.xml.rpc.ServiceException;

import org.apache.axis.client.Stub;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import edu.virginia.shanti.om.bridge.domain.Bridge;
import edu.virginia.shanti.om.bridge.domain.LocalContextType;
import edu.virginia.shanti.om.bridge.domain.PermissionMap;
import edu.virginia.shanti.om.bridge.soap.sakai.SakaiScriptServiceLocator;
import edu.virginia.shanti.om.bridge.soap.sakai.SakaiScript_PortType;

//** eventually this needs to be an interface to generalize it */
@Service
public class PermissionMapService {
	
	Log log = LogFactory.getLog(PermissionMapService.class);

	transient private SakaiScriptServiceLocator sakaiScriptServiceLocator = new SakaiScriptServiceLocator();
	
	@Autowired
	private CurrentUser currentUser;

	@Transactional(propagation = Propagation.REQUIRED)
	public PermissionMap getPermissionMap(LocalContextType type) {
		List<PermissionMap> results;
		try {  results = PermissionMap
				.findPermissionMapsByLocalContextType(type).getResultList();
		} catch (Exception e) {
			log.warn("Exception thrown from getPermissionMap:  " + e + " treating at empty result!");
			results = new LinkedList<PermissionMap>();
		}
		if (!results.isEmpty()) {
			return results.get(0);
		} else {
			return null;
		}
	}

	// TODO: May not need this if we use the MVC controller
	// This is used during unit testing
	@Transactional(propagation = Propagation.REQUIRED)
	public void savePermissionMap(PermissionMap permissionMap) {
		// let's require a few things to be set:
		if (permissionMap.getLocalContextType() == null
				|| permissionMap.getPermissionSets() == null) {
			throw new IllegalArgumentException(
					"name, localContextType and permissionSets must be set on "
							+ "PermissionMap before it can be saved.");
		}
		if (permissionMap.getId() != null) {
			permissionMap.merge();
		} else {
			permissionMap.persist();
		}
	}

	public PermissionMap getPermissionMap(Bridge bridge) {
		PermissionMap permissionMap = null;

		// See if we have an explicit PermissionMap saved for this local
		// context.
		List<PermissionMap> results = PermissionMap
				.findPermissionMapsByLocalContextMaskAndService(
						bridge.getLocalContext(), bridge.getRemoteName())
				.getResultList();
		if (!results.isEmpty()) {
			permissionMap = results.get(0);
			log.error("Found permissionMap " + permissionMap);
		} else {

			SessionAffinity aff = SessionAffinityUtility.constructSessionAffinity(currentUser);	 
			try {
				SakaiScript_PortType sakaiScript = sakaiScriptServiceLocator
						.getSakaiScript(new URL("https://" + aff.getServer()
								+ "/sakai-ws/soap/sakai"));	
		
				SessionAffinityUtility.setConnectionAffinity(aff, ((Stub)sakaiScript));
		
				LocalContextType siteType;
				
				log.error("session = " + aff.getSession() + " localContext = " + bridge.getLocalContext());
				
				String termEid = null;
				try {
					termEid = sakaiScript.getSiteProperty(aff.getSession(), bridge.getLocalContext(), "term_eid");
				} catch (Exception e) {
					log.warn(e + "  Ignoring and returning null");
				}
				
				log.error("Site type check: termEid = " + termEid);
				
				// if (sakaiScript.checkForRoleInAuthzGroup(session,
				//		bridge.getLocalContext(), "Instructor")) {
				
				if (termEid != null) {
					siteType = LocalContextType.COURSE;
				} else {
					siteType = LocalContextType.COLLABORATION;
				}

				log.error("SiteType determined to be " + siteType);
				
				results = PermissionMap.findPermissionMapsByLocalContextType(
						siteType).getResultList();
				if (!results.isEmpty()) {
					permissionMap = results.get(0);
				} else {
					throw new RuntimeException("Could not retrieve PermissionMap for LocalContextType: "  + siteType);
				}
			} catch (MalformedURLException e) {
				throw new RuntimeException(e.getMessage(), e);
			} catch (ServiceException e) {
				throw new RuntimeException(e.getMessage(), e);
//			} catch (RemoteException e) {
//				throw new RuntimeException(e.getMessage(), e);
			}

		}
		if (permissionMap == null) {
			throw new RuntimeException("No Permission Map found!");
		}

		return permissionMap;
	}




}
