package edu.virginia.shanti.om.bridge.form;

import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.serializable.RooSerializable;

import flexjson.JSONSerializer;

@RooJavaBean
@RooSerializable
public class RemoteContextChoice {

	private static final long serialVersionUID = 8437507898624362606L;

	private String contextLabel;

	private String contextId;

	private String url;
	
	private String remoteName;

	@Override
	public String toString() {
		return new JSONSerializer().serialize(this);
	}

}
