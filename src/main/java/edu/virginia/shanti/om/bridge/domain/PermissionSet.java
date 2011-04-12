package edu.virginia.shanti.om.bridge.domain;

import javax.persistence.Enumerated;

import org.springframework.roo.addon.entity.RooEntity;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.tostring.RooToString;

@RooJavaBean
@RooToString
@RooEntity
public abstract class PermissionSet {
	
	private String groupName;

	@Enumerated
    private LocalGroupType localGroupType;
	
}
