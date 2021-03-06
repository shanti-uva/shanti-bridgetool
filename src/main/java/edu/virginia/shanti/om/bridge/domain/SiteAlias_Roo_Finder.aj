// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package edu.virginia.shanti.om.bridge.domain;

import edu.virginia.shanti.om.bridge.domain.SiteAlias;
import java.lang.String;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

privileged aspect SiteAlias_Roo_Finder {
    
    public static TypedQuery<SiteAlias> SiteAlias.findSiteAliasesByAlias(String alias) {
        if (alias == null || alias.length() == 0) throw new IllegalArgumentException("The alias argument is required");
        EntityManager em = SiteAlias.entityManager();
        TypedQuery<SiteAlias> q = em.createQuery("SELECT o FROM SiteAlias AS o WHERE o.alias = :alias", SiteAlias.class);
        q.setParameter("alias", alias);
        return q;
    }
    
    public static TypedQuery<SiteAlias> SiteAlias.findSiteAliasesBySiteId(String siteId) {
        if (siteId == null || siteId.length() == 0) throw new IllegalArgumentException("The siteId argument is required");
        EntityManager em = SiteAlias.entityManager();
        TypedQuery<SiteAlias> q = em.createQuery("SELECT o FROM SiteAlias AS o WHERE o.siteId = :siteId", SiteAlias.class);
        q.setParameter("siteId", siteId);
        return q;
    }
    
}
