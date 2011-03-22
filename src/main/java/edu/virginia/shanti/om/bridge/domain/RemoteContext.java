package edu.virginia.shanti.om.bridge.domain;

import org.springframework.roo.addon.entity.RooEntity;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.serializable.RooSerializable;
import org.springframework.roo.addon.tostring.RooToString;

import edu.virginia.shanti.om.bridge.form.RemoteContextChoice;

@RooJavaBean
@RooToString
@RooSerializable
@RooEntity
public class RemoteContext extends RemoteContextChoice {

	private static final long serialVersionUID = -6188634159320400849L;

	public void populate(RemoteContextChoice choice) {
		setRemoteName(choice.getRemoteName());
		setContextId(choice.getContextId());
		setContextLabel(choice.getContextLabel());
		setUrl(choice.getUrl());
	}

	public RemoteContextChoice getRemoteContextChoice() {
		RemoteContextChoice rcc = new RemoteContextChoice();
		rcc.setContextId(getContextId());
		rcc.setContextLabel(getContextLabel());
		rcc.setRemoteName(getRemoteName());
		rcc.setUrl(getUrl());
		return rcc;
	}
}