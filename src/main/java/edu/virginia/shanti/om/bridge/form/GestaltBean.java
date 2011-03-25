/**
 * 
 */
package edu.virginia.shanti.om.bridge.form;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.tostring.RooToString;
import org.springframework.stereotype.Component;

/**
 * 
 * Session scoped bean to hold the current state
 * 
 * @author ys2n
 *
 */
@RooJavaBean
@RooToString
@Component
@Scope(value="session",proxyMode=ScopedProxyMode.TARGET_CLASS)
public class GestaltBean extends BasicConfigBean {

	/**
	 * 
	 */	
	public GestaltBean() {

	}

	/**
	 * @param user
	 * @param siteId
	 * @param toolPlacementId
	 * @param remoteService
	 * @param timestamp
	 */
	public GestaltBean(String user, String siteId, String toolPlacementId,
			String remoteService, Long timestamp) {
		super(user, siteId, toolPlacementId, remoteService, timestamp);
	}

}
