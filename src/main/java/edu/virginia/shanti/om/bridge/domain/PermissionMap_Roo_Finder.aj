// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package edu.virginia.shanti.om.bridge.domain;

import edu.virginia.shanti.om.bridge.domain.LocalContextType;
import edu.virginia.shanti.om.bridge.domain.PermissionMap;
import java.lang.String;
import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

privileged aspect PermissionMap_Roo_Finder {
    
    public static TypedQuery<PermissionMap> PermissionMap.findPermissionMapsByLocalContextMask(String localContextMask) {
        if (localContextMask == null || localContextMask.length() == 0) throw new IllegalArgumentException("The localContextMask argument is required");
        EntityManager em = PermissionMap.entityManager();
        TypedQuery<PermissionMap> q = em.createQuery("SELECT o FROM PermissionMap AS o WHERE o.localContextMask = :localContextMask", PermissionMap.class);
        q.setParameter("localContextMask", localContextMask);
        return q;
    }
    
    public static TypedQuery<PermissionMap> PermissionMap.findPermissionMapsByLocalContextMaskAndService(String localContextMask, String service) {
        if (localContextMask == null || localContextMask.length() == 0) throw new IllegalArgumentException("The localContextMask argument is required");
        if (service == null || service.length() == 0) throw new IllegalArgumentException("The service argument is required");
        EntityManager em = PermissionMap.entityManager();
        TypedQuery<PermissionMap> q = em.createQuery("SELECT o FROM PermissionMap AS o WHERE o.localContextMask = :localContextMask AND o.service = :service", PermissionMap.class);
        q.setParameter("localContextMask", localContextMask);
        q.setParameter("service", service);
        return q;
    }
    
    public static TypedQuery<PermissionMap> PermissionMap.findPermissionMapsByLocalContextType(LocalContextType localContextType) {
        if (localContextType == null) throw new IllegalArgumentException("The localContextType argument is required");
        EntityManager em = PermissionMap.entityManager();
        TypedQuery<PermissionMap> q = em.createQuery("SELECT o FROM PermissionMap AS o WHERE o.localContextType = :localContextType", PermissionMap.class);
        q.setParameter("localContextType", localContextType);
        return q;
    }
    
    public static TypedQuery<PermissionMap> PermissionMap.findPermissionMapsByName(String name) {
        if (name == null || name.length() == 0) throw new IllegalArgumentException("The name argument is required");
        EntityManager em = PermissionMap.entityManager();
        TypedQuery<PermissionMap> q = em.createQuery("SELECT o FROM PermissionMap AS o WHERE o.name = :name", PermissionMap.class);
        q.setParameter("name", name);
        return q;
    }
    
}
