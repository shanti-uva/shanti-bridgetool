package edu.virginia.shanti.om.bridge.form;

import org.springframework.context.annotation.Scope;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.serializable.RooSerializable;
import org.springframework.stereotype.Component;

import flexjson.JSONSerializer;

@RooJavaBean
@RooSerializable
@Component
@Scope("prototype")
public class ConfluenceSpaceForm extends RemoteContextChoice {

	private static final long serialVersionUID = 4253304166346160737L;

	private String localContext;

	private String localSubContext;
	
	
	public String getTitle() {
		return this.getContextLabel();
	}

	public void setTitle(String title) {
		this.setContextLabel(title);
	}

	public String getKey() {
		return getContextId();
	}

	public void setKey(String key) {
		setContextId(key);
	}

	@Override
	public String toString() {
		return new JSONSerializer().serialize(this);
	}

	public void populate(ConfigBean config) {
		setLocalContext(config.getLocalContext());
		setLocalSubContext(config.getLocalSubContext());
		setRemoteName(config.getRemoteService());
	}

}
