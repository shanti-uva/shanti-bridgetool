package edu.virginia.shanti.om.bridge.domain;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;

import org.springframework.roo.addon.entity.RooEntity;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.json.RooJson;
import org.springframework.roo.addon.serializable.RooSerializable;
import org.springframework.roo.addon.tostring.RooToString;

@RooJavaBean
@RooToString
@RooEntity(finders = { "findSiteAliasesBySiteId", "findSiteAliasesByAlias" })
@RooJson
@RooSerializable
public class SiteAlias {

    @NotNull
    @Column(unique = true)
    private String alias;

    @NotNull
    @Column(unique = true)
    private String siteId;
}
