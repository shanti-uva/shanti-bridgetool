
package edu.virginia.shanti.om.bridge.auth.sakai;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


/**
 * Class to maintain a mapping of Sakai users to an object that
 * represents that user's Sakai information, i.e., SakaiUserInfo.
 * 
 * @author cindy
 */

public class SakaiUsers {

	/**
	 * Create a synchronized Map to avoid conflicts if multiple threads
	 * access to change the Map structurallly. Map contains an entry for
	 * each logged in Sakai user, 
	 *     key = CXDirectoryPerson user uniqueId
	 *     value = SakaiUserInfo
	 */
	private static Map<String,SakaiUserInfo> sakaiUsers = null;
	
	private static int numberOfUsers = 0;
	
	/** 
	 * Construct a single object to represent the current
	 * SakaiUserInfo for the current query.  We are makeing this
	 * kludgy attempt to have access to a Sakai user's Sakai sessionID
	 * from where we get it in DirectAction at login time, to when we
	 * later need it in the OSID, at query repository search time.
	 */ 
	// private static SakaiUserInfo currentSakaiUserInfo = null;
	
	// add flag for print debugging
	private static boolean debug = false;
	
	// cindy
	static {
		if (debug) {
			System.out.println("SakaiUsers Class Loaded\n");
			System.err.println("SakaiUsers Class Loaded\n");			
		}
	}
	

//	/**
//	 * Constructor.
//	 *
//	 */
//	public SakaiUsers() {
//		if (debug) System.out.println("---SakaiUsers.ctor(), create it!");
//	}
	                   
	public static Map<String,SakaiUserInfo> getSakaiUsers() {
		if (sakaiUsers == null) {
			if (debug) System.out.println("---SakaiUsers.getSakaiUsers(), create the Map");
	
			// Create the Map if it does not yet exist.
			sakaiUsers = (Map<String,SakaiUserInfo>)Collections.synchronizedMap(new HashMap<String,SakaiUserInfo>());
		}
		if (debug) System.out.println("---SakaiUsers.getSakaiUsers(), return the existing Map");
		return sakaiUsers;
	}
	
	public static boolean addSakaiUser(String userId, SakaiUserInfo sakaiInfo) {
		// String key = userId +"@" +sakaiInfo.getSakaiSessionId();
		String key = userId;
		
		try {
			// if (getSakaiUsers().containsValue(sakaiInfo)) {
			if (getSakaiUsers().containsKey(key)) {
				// if user is already in map, update user info - may have new 
				// sakai session id or worksite id.
				if (debug) System.out.println("---SakaiUsers.addSakaiUser(), this user exists in map: " 
						+key +", sessionId: " +sakaiInfo.getSakaiSessionId());
				// replace with latest info from Linktool for user (i.e., sakai sessionId)
				getSakaiUsers().remove(key);
				getSakaiUsers().put(key, sakaiInfo);
				if (debug) System.out.println("---SakaiUsers.addSakaiUser(), updated this user: " 
						+key +", sessionId: " +sakaiInfo.getSakaiSessionId());
				return true;
				
			} else {
				// add the user
				if (debug) System.out.println("---SakaiUsers.addSakaiUser(), add this user to map: " 
						+key +", sessionId: " +sakaiInfo.getSakaiSessionId());
				getSakaiUsers().put(key, sakaiInfo);
				return true;
			}
			
		} catch (Exception ex) {
			System.err.println("---Exception: SakaiUsers.addSakaiUser(), add this user to map: " 
					+key +", sessionId: " +sakaiInfo.getSakaiSessionId());
			return false;
		}
	}
	
	/**
	 * Return the SakaiUserInfo object for the user requested.  First parameter
	 * may be the actual key value (the uniqueId for a CXDirectoryPerson in 
	 * Pachyderm), or may be the user login name.  The second parameter 
	 * indicates what the first represents, the key or not.
	 * @param user   String representing either the key (CXDirectoryPerson
	 *               uniqueId), or String representing the user login name.
	 * @param isKey  boolean value is true if first parameter is the Map
	 *               key value; false if not.
	 * @return       the SakaiUserInfo object for the requested user.
	 */
	public static SakaiUserInfo getSakaiUser(String user, boolean isKey) {
		if (debug) {
			System.out.println("---SakaiUsers.getSakaiUser(), user is: "
					+user +", isKey? " +isKey);
		}
		SakaiUserInfo keyInfo = null;
		if (isKey) {
			keyInfo = (SakaiUserInfo)getSakaiUsers().get(user);
			
		} else {
			// Need to look up the requested userId in the Map
			Collection<SakaiUserInfo> users = SakaiUsers.getSakaiUsers().values();
			Iterator<SakaiUserInfo> iter = users.iterator();
			while (iter.hasNext()) {
				keyInfo = (SakaiUserInfo)iter.next();
				if (debug) {
					System.out.println("   Map iter, user/sessionId: " 
							+keyInfo.getUserId() +"/" 
							+keyInfo.getSakaiSessionId());
				}
				if (user.equals(keyInfo.getUserId())) {
					break;
				}
			}
		}
		return keyInfo;
	}
	
	public static int getNumberOfUsers() {
		if (getSakaiUsers() != null && !getSakaiUsers().isEmpty()) {
			numberOfUsers = getSakaiUsers().size();
		} 
		if (debug) System.out.println("---SakaiUsers.getNumberOfUsers(): " +numberOfUsers);
		return numberOfUsers;
	}
	
	/**
	 * If we have any Sakai users here, Pachyderm was launched from Sakai.
	 * 
	 * @return boolean true, if users > 0, false otherwise
	 */
	public static boolean launchedFromSakai() {
		if (getNumberOfUsers() > 0) {
			if (debug) System.out.println("---SakaiUsers.launchedFromSakai(): true");
			return true;
		}
		if (debug) System.out.println("---SakaiUsers.launchedFromSakai(): false");
		return false;
	}
	
//	public static SakaiUserInfo getCurrentSakaiUserInfo() {
//		if (debug) {
//			String key = null;
//			if (currentSakaiUserInfo != null) {
//				// key = currentSakaiUserInfo.getUserId() +"@" +currentSakaiUserInfo.getSakaiSessionId();
//				key = currentSakaiUserInfo.getUserId();
//			}
//			System.out.println("---SakaiUsers.getCurrentSakaiUserInfo() ");
//			System.out.println("   key is:  "+key);
//		}
//		return currentSakaiUserInfo;
//	}
//	
//	public static void setCurrentSakaiUserInfo(SakaiUserInfo newSakaiUser) {
//		if (debug) {
//			String key = null;
//			if (newSakaiUser != null) {
//				// key = newSakaiUser.getUserId() +"@" +newSakaiUser.getSakaiSessionId();
//				key = newSakaiUser.getUserId() ;
//			}
//			System.out.println("---SakaiUsers.setCurrentSakaiUserInfo() ");
//			System.out.println("   key:  "+key);
//		}
//		currentSakaiUserInfo = newSakaiUser;
//	}
}
