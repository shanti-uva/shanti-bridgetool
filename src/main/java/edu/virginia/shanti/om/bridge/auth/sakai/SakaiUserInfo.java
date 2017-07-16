package edu.virginia.shanti.om.bridge.auth.sakai;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import edu.virginia.shanti.om.bridge.auth.BridgeToolAuthenticationFilter;

/**
 * @author ys2n
 * 
 */
public class SakaiUserInfo extends HashMap<String, String> implements
		Map<String, String> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3109820944322381208L;
	
	private Log log = LogFactory.getLog(SakaiUserInfo.class);

	/**
	 * @param userId
	 * @param firstName
	 * @param lastName
	 * @param sakaiSessionId
	 * @param email
	 * @param type
	 * @param sakaiSiteId
	 * @param serverUrl
	 * @param serverId
	 */
	public SakaiUserInfo(String userId, String firstName, String lastName,
			String sakaiSessionId, String email, String type,
			String sakaiSiteId, String serverUrl, String serverId) {

			log.debug("---SakaiUserInfo.ctor():");
			log.debug("      userId: " + userId);
			log.debug("      firstName: " + firstName);
			log.debug("      lastName: " + lastName);
			log.debug("      sakaiSessionId: " + sakaiSessionId);
			log.debug("      email: " + email);
			log.debug("      type: " + type);
			log.debug("	  sakaiSiteId: " + sakaiSiteId);
			log.debug("      serverId: " + serverId);
			log.debug("      serverUrl: " + serverUrl);
		setUserId(userId);
		setFirstName(firstName);
		setLastName(lastName);
		setSakaiSessionId(sakaiSessionId);
		setEmail(email);
		setType(type);
		setServerId(serverId);
		setSakaiSiteId(sakaiSiteId);
		setServerUrl(serverUrl);
	}

	public SakaiUserInfo() {
		super();
	}

	public void setServerUrl(String serverUrl) {
		put("serverUrl", serverUrl);
	}

	public String getServerUrl() {
		return get("serverUrl");
	}

	public String getUserId() {
		return get("userId");
	}

	public void setUserId(String userId) {
		put("userId", userId);
	}

	public String getFirstName() {
		return get("firstName");
	}

	public void setFirstName(String firstName) {
		put("firstName", firstName);
	}

	public String getLastName() {
		return get("lastName");
	}

	public void setLastName(String lastName) {
		put("lastName", lastName);
	}

	public String getSakaiSessionId() {
		return get("sakaiSessionId");
	}

	public void setSakaiSessionId(String sakaiSessionId) {
		put("sakaiSessionId", sakaiSessionId);
	}

	public String getEmail() {
		return get("email");
	}

	public void setEmail(String email) {
		put("email", email);
	}

	public String getType() {
		return get("type");
	}

	public void setType(String type) {
		put("type", type);
	}

	public String getServerId() {
		return get("serverId");
	}

	public void setServerId(String serverId) {
		put("serverId", serverId);
	}

	public String getSakaiSiteId() {
		return get("sakaiSiteId");
	}

	public void setSakaiSiteId(String sakaiSiteId) {
		log.debug("   SakaiUserInfo.setSakaiSiteId(): "
					+ sakaiSiteId);
		put("sakaiSiteId", sakaiSiteId);
	}

	public String getServiceBaseUrl() {

		String sakaiServerUrl;
		try {
			sakaiServerUrl = URLDecoder.decode(getServerUrl(), "UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}

		StringBuffer tempServerUrl = new StringBuffer(sakaiServerUrl);
		// Determine the start and end index in the string to be replaced
		int start = tempServerUrl.indexOf("//") + 2;
		int end = tempServerUrl.indexOf(".");

		String serverId = getServerId();
		tempServerUrl = tempServerUrl.replace(start, end, serverId);

		String realServerUrl = tempServerUrl.toString();

		if (!realServerUrl.startsWith("http")) {
			realServerUrl = "https://" + realServerUrl;
		}
		log.debug("   SakaiUserInfo.setServiceBaseUrl() https: "
					+ realServerUrl);

		return realServerUrl;
	}

}
