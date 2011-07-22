package edu.virginia.shanti.om.bridge.auth;

import java.io.Serializable;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.core.Authentication;

public class BridgeToolPermissionEvaluator implements PermissionEvaluator {
	
	Log log = LogFactory.getLog(BridgeToolPermissionEvaluator.class);

	@Override
	public boolean hasPermission(Authentication authentication,
			Object targetDomainObject, Object permission) {
		// TODO Auto-generated method stub
		log.warn("hasPermission called by " + authentication.getName() + " on " + targetDomainObject + " for permission " + permission);
		return true;
	}

	@Override
	public boolean hasPermission(Authentication authentication,
			Serializable targetId, String targetType, Object permission) {
		// TODO Auto-generated method stub
		log.warn("hasPermission called by " + authentication.getName() + " on " + targetId + " of type " + targetType + " for permission " + permission);
		return true;
	}

}
