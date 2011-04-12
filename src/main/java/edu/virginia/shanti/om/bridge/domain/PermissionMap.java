package edu.virginia.shanti.om.bridge.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToMany;

import org.springframework.roo.addon.entity.RooEntity;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.serializable.RooSerializable;
import org.springframework.roo.addon.tostring.RooToString;

@RooJavaBean
@RooToString
@RooEntity
@RooSerializable
public class PermissionMap {

    private static final long serialVersionUID = -7512207795576727622L;

    private String name;
    
    private String mask;
        
	@Enumerated
    private LocalContextType localContextType;

    @ManyToMany(cascade = CascadeType.ALL)
    private Set<PermissionSet> permissionSets = new HashSet<PermissionSet>();
    
}
