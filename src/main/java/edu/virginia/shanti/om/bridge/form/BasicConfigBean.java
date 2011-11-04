package edu.virginia.shanti.om.bridge.form;

import org.springframework.context.annotation.Scope;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.serializable.RooSerializable;
import org.springframework.stereotype.Component;


@RooJavaBean
@RooSerializable
@Component
@Scope("prototype")
public class BasicConfigBean implements ConfigBean {
	
	private static final long serialVersionUID = 7034676199472189866L;
	
	private String user;

	private String localContext;
	
	private String localSubContext;
	
	private String remoteService;
	
	private String serviceLabel;
		
	public BasicConfigBean() {
		
	}
	
	public BasicConfigBean(String user, String siteId, String toolPlacementId,
			String remoteService) {
		this();
		setLocalContext(siteId);
		setLocalSubContext(toolPlacementId);
		setRemoteService(remoteService);
		setUser(user);
	}

	public static ConfigBean getInstance(String user, String localContext, String localSubContext,
			String remoteService) {
		return new BasicConfigBean(user, localContext, localSubContext, remoteService);
	}

}
