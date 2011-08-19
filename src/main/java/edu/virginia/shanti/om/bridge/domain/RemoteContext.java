package edu.virginia.shanti.om.bridge.domain;

import org.springframework.beans.BeanUtils;
import org.springframework.roo.addon.entity.RooEntity;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.serializable.RooSerializable;
import org.springframework.roo.addon.tostring.RooToString;
import edu.virginia.shanti.om.bridge.form.RemoteContextChoice;
import flexjson.JSON;

@RooJavaBean
@RooToString
@RooSerializable
@RooEntity(finders = { "findRemoteContextsByRemoteNameAndContextId" })
public class RemoteContext {

    private static final long serialVersionUID = -6188634159320400849L;

    private String contextLabel;

    private String contextId;

    private String url;

    private String remoteName;

    public RemoteContext(RemoteContextChoice choice) {
        this();
        populate(choice);
    }

    public RemoteContext() {
        super();
    }

    public void populate(RemoteContextChoice choice) {
        BeanUtils.copyProperties(choice, this, new String[] { "id" });
    }

    @JSON(include=false)
    public RemoteContextChoice getRemoteContextChoice() {
        RemoteContextChoice rcc = new RemoteContextChoice();
        BeanUtils.copyProperties(this, rcc, new String[] { "id" });
        return rcc;
    }
}
