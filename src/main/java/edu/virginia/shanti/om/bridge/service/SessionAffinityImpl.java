package edu.virginia.shanti.om.bridge.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.roo.addon.javabean.RooJavaBean;

@RooJavaBean
public class SessionAffinityImpl implements SessionAffinity {

	@Autowired
	private String server;
	@Autowired
	private String affinityId;
	@Autowired
	private String session;
	
	public SessionAffinityImpl(String server, String sakaisession, String lbCookieValue) {
		this.setServer(server) ; this.setAffinityId(lbCookieValue) ; this.setSession(sakaisession);
	}
	/* (non-Javadoc)
	 * @see edu.virginia.shanti.om.bridge.service.SessionAffinitys#getAffinityId()
	 */
	@Override
	public String getAffinityId() {
		return affinityId;
	}
	public void setAffinityId(String affinityId) {
		this.affinityId = affinityId;
	}
	/* (non-Javadoc)
	 * @see edu.virginia.shanti.om.bridge.service.SessionAffinitys#getSession()
	 */
	@Override
	public String getSession() {
		return session;
	}
	public void setSession(String session) {
		this.session = session;
	}
	/* (non-Javadoc)
	 * @see edu.virginia.shanti.om.bridge.service.SessionAffinitys#getServer()
	 */
	@Override
	public String getServer() {
		return server;
	}
	public void setServer(String server) {
		this.server = server;
	}

	public String toString() {
		return "[ SessionAffinity\nsession = " + this.session + "\naffinityId = " + this.affinityId + "\nserver = " + this.server + "\n]";
	}

}
