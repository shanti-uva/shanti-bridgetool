package edu.virginia.shanti.om.bridge.auth.sakai;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;

/**
 * LinktoolFormValues class represents the values sent to the application from
 * the Sakai Linktool utility. The values are delivered as key-value pairs
 * appended to the launching URL of the web applicaiton.
 * 
 * @author cindy
 * 
 */
public class LinktoolFormValues extends HashMap<String, String> {

	private static final long serialVersionUID = 7882555067193702016L;

	/**
	 * Empty constructor. All member values are null and must be filled using
	 * the appropriate set methods.
	 */
	public LinktoolFormValues() {
		super();
	}

	/**
	 * Constructor accepts a query String and parses out the key-value pairs to
	 * populate the object.
	 */
	public LinktoolFormValues(String urlKeyValue) {
		super();
		put("keyValueString", urlKeyValue);
		initValuesFromString();
	}

	/**
	 * Assign the user value to this object's user data.
	 * 
	 * @param u
	 *            String representing the user
	 */
	public void setUser(String u) {
		put("user",u);
	}

	/**
	 * Returns the String representing the user data. May be null.
	 * 
	 * @return String representing the user data
	 */
	public String getUser() {
		return get("user");
	}

	/**
	 * Assign the internal user value to this object's user data.
	 * 
	 * @param u
	 *            String representing the internal user
	 */
	public void setInternaluser(String i) {
		put("internaluser",i);
	}

	/**
	 * Returns the String representing the internal user data. May be null.
	 * 
	 * @return String representing the internaluser data
	 */
	public String getInternaluser() {
		return get("internaluser");
	}

	/**
	 * Assign the site value to this object's user data.
	 * 
	 * @param u
	 *            String representing the site
	 */
	public void setSite(String s) {
		put("site",s);
	}

	/**
	 * Returns the String representing the site data. May be null.
	 * 
	 * @return String representing the site data
	 */
	public String getSite() {
		return get("site");
	}

	/**
	 * Assign the role value to this object's user data.
	 * 
	 * @param u
	 *            String representing the role
	 */
	public void setRole(String r) {
		put("role",r);
	}

	/**
	 * Returns the String representing the role data. May be null.
	 * 
	 * @return String representing the role data
	 */
	public String getRole() {
		return get("role");
	}

	/**
	 * Assign the Sakai session value to this object's user data.
	 * 
	 * @param u
	 *            String representing the Sakai session
	 */
	public void setSession(String s) {
		put("session",s);
	}

	/**
	 * Returns the String representing the Sakai session data. May be null.
	 * 
	 * @return String representing the Sakai session data
	 */
	public String getSession() {
		return get("session");
	}

	/**
	 * Assign the serverurl value to this object's server URL data.
	 * 
	 * @param u
	 *            String representing the serverurl
	 */
	public void setServerurl(String u) {
		try {
			put("serverurl",URLDecoder.decode(u, "UTF-8"));
		} catch (UnsupportedEncodingException e) {
			throw new RuntimeException(e);
		}
	}

	/**
	 * Returns the String representing the serverurl data. May be null.
	 * 
	 * @return String representing the serverurl data
	 */
	public String getServerurl() {
		return get("serverurl");
	}

	/**
	 * Assign the time value to this object's time data.
	 * 
	 * @param t
	 *            String representing the time
	 */
	public void setTime(String t) {
		put("time",t);
	}

	/**
	 * Returns the String representing the time data. May be null.
	 * 
	 * @return String representing the time data
	 */
	public String getTime() {
		return get("time");
	}

	/**
	 * Assign the placement value to this object's placement data.
	 * 
	 * @param p
	 *            String representing the placement
	 */
	public void setPlacement(String p) {
		put("placement",p);
	}

	/**
	 * Returns the String representing the placement data. May be null.
	 * 
	 * @return String representing the placement data
	 */
	public String getPlacement() {
		return get("placement");
	}

	/**
	 * Assign the serverId value to this object's serverId data.
	 * 
	 * @param s
	 *            String representing the serverId
	 */
	public void setServerId(String s) {
		put("serverId",s);
	}

	/**
	 * Returns the String representing the serverId data. May be null.
	 * 
	 * @return String representing the serverId data
	 */
	public String getServerId() {
		return get("serverId");
	}

	public String getKeyValueString() {
		return get("keyValueString");
	}

	public void setKeyValueString(String keyValueString) {
		put ("keyValueString",keyValueString);
	}

	/**
	 * Helper method to initialize the individual member data from the
//	 * keyValueString query String.
	 */
	private void initValuesFromString() {
		String newString = get("keyValueString");
		String[] allPairs = null;
		String[] aPair = null;

		if (newString != null && newString.length() > 0) {

			allPairs = newString.split("&");

			// Process each pair and get the value
			for (int i = 0; i < allPairs.length; i++) {

				aPair = allPairs[i].split("=");
				saveValueForKey(aPair);
			}
		}
	}

	/**
	 * Helper method to parse individual query string values and initialize the
	 * appropriate member of this object. The following keys are currently
	 * recognized: user internaluser site role session serverurl time placement
	 * serverId
	 * 
	 * @param keyValuePair
	 *            String[] consists of query key, query key's value
	 */
	private void saveValueForKey(String[] keyValuePair) {

		if (keyValuePair == null || keyValuePair.length != 2) {
			return;
		}

		if (keyValuePair[0].compareToIgnoreCase("user") == 0) {
			setUser(keyValuePair[1]);
		}
		if (keyValuePair[0].compareToIgnoreCase("internaluser") == 0) {
			setInternaluser(keyValuePair[1]);
		}
		if (keyValuePair[0].compareToIgnoreCase("site") == 0) {
			setSite(keyValuePair[1]);
		}
		if (keyValuePair[0].compareToIgnoreCase("role") == 0) {
			setRole(keyValuePair[1]);
		}
		if (keyValuePair[0].compareToIgnoreCase("session") == 0) {
			setSession(keyValuePair[1]);
		}
		if (keyValuePair[0].compareToIgnoreCase("serverurl") == 0) {
			setServerurl(keyValuePair[1]);
		}
		if (keyValuePair[0].compareToIgnoreCase("time") == 0) {
			setTime(keyValuePair[1]);
		}
		if (keyValuePair[0].compareToIgnoreCase("placement") == 0) {
			setPlacement(keyValuePair[1]);
		}
		if (keyValuePair[0].compareToIgnoreCase("serverId") == 0) {
			setServerId(keyValuePair[1]);
		}
	}
}
