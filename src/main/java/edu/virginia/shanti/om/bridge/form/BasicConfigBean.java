package edu.virginia.shanti.om.bridge.form;

import org.springframework.context.annotation.Scope;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.stereotype.Component;


@RooJavaBean
@Component
@Scope("prototype")
public class BasicConfigBean implements ConfigBean {

	private String localContext;
	
	private String localSubContext;
	
	private String remoteService;
	
	public BasicConfigBean() {
		
	}
	
	public BasicConfigBean(String siteId, String toolPlacementId,
			String remoteService) {
		this();
		setLocalContext(siteId);
		setLocalSubContext(toolPlacementId);
		setRemoteService(remoteService);
	}

	public static ConfigBean getInstance(String localContext, String localSubContext,
			String remoteService) {
		return new BasicConfigBean(localContext, localSubContext, remoteService);
	}

}
