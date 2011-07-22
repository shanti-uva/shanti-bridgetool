package edu.virginia.shanti.om.bridge.auth;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

import edu.virginia.shanti.om.bridge.domain.Bridge;

public class BridgeToolPermissionEvaluator implements PermissionEvaluator {
	
	Log log = LogFactory.getLog(BridgeToolPermissionEvaluator.class);

	@Override
	public boolean hasPermission(Authentication authentication,
			Object targetDomainObject, Object permission) {
		// TODO Auto-generated method stub
		log.warn("hasPermission called by " + authentication + " on " + targetDomainObject + " for permission " + permission);
		
		log.warn("Authorities: " + authentication.getAuthorities());
		
		Collection<GrantedAuthority> auths = (Collection<GrantedAuthority>) authentication.getAuthorities();

		boolean authorized = false;
		
		if (!auths.isEmpty() && targetDomainObject instanceof Bridge) {
			Bridge bridge = (Bridge)targetDomainObject;
			for (GrantedAuthority grant : auths) {
				if (isAdmin(grant.getAuthority(),bridge.getLocalContext())) {
					authorized = true;
					break;
				}
			}
		}
		return authorized;
	}
	
	private boolean isAdmin(String authority, String localContext) {
		List<String> adminRoles = Arrays.asList(new String[] {"Instructor", "Secondary Instructor", "Owner", "maintain", "Administrator"});

		String[] parts = authority.split("@");
		
		if (parts.length != 2) {
			throw new IllegalArgumentException("authority must include at \'@\' symbol");
		}
		
		String role = parts[0];
		String glc = parts[1];
		
		return glc.equals(localContext) && adminRoles.contains(role);

	}

	@Override
	public boolean hasPermission(Authentication authentication,
			Serializable targetId, String targetType, Object permission) {
		// TODO Auto-generated method stub
		log.warn("hasPermission called by " + authentication + " on " + targetId + " of type " + targetType + " for permission " + permission);
		return false;
	}

}
