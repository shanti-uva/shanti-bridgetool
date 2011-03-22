package edu.virginia.shanti.om.bridge.domain;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import org.springframework.roo.addon.entity.RooEntity;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.serializable.RooSerializable;
import org.springframework.roo.addon.tostring.RooToString;

@RooJavaBean
@RooToString
@RooSerializable
@RooEntity(finders = { "findRemoteServersByRemoteName" })
public class RemoteServer {

	private static final long serialVersionUID = 8465623453429087992L;

	private String implementationName;

    private String remoteUrl;

    @NotNull
    @Column(unique = true)
    private String remoteName;
    
}
