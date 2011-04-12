package edu.virginia.shanti.om.bridge.domain;

import org.springframework.roo.addon.entity.RooEntity;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.tostring.RooToString;
import javax.validation.constraints.NotNull;
import javax.persistence.Column;

@RooJavaBean
@RooToString
@RooEntity(finders = { "findSiteAliasesBySiteId", "findSiteAliasesByAlias" })
public class SiteAlias {

    @NotNull
    @Column(unique = true)
    private String alias;

    @NotNull
    @Column(unique = true)
    private String siteId;
}
