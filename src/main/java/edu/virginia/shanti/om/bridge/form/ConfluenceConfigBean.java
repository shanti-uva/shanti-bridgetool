package edu.virginia.shanti.om.bridge.form;

import org.springframework.context.annotation.Scope;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.serializable.RooSerializable;
import org.springframework.roo.addon.tostring.RooToString;
import org.springframework.stereotype.Component;


@RooJavaBean
@RooToString
@RooSerializable
@Component
@Scope("prototype")
public class ConfluenceConfigBean extends BasicConfigBean {
	
 	private static final long serialVersionUID = -7570502788732631620L;
 	
 	public ConfluenceConfigBean() {
 		super();
 	}

	public ConfluenceConfigBean(String user, String siteId, String toolPlacementId,
			String remoteService, Long timestamp) {
		super(user, siteId,toolPlacementId,remoteService, timestamp);
	}
	
	public String getSiteId() {
		return getLocalContext();
	}

	public void setSiteId(String siteId) {
		setLocalContext(siteId);
	}

	public String getToolPlacementId() {
		return getLocalSubContext();
	}

	public void setToolPlacementId(String toolPlacementId) {
		setLocalSubContext(toolPlacementId);
	}
	
}
