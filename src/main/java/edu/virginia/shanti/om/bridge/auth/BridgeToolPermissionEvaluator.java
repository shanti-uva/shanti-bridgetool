package edu.virginia.shanti.om.bridge.auth;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

import edu.virginia.shanti.om.bridge.domain.Bridge;

public class BridgeToolPermissionEvaluator implements PermissionEvaluator {

	Logger log = LoggerFactory.getLogger(BridgeToolPermissionEvaluator.class);

	// Log log = LogFactory.getLog(BridgeToolPermissionEvaluator.class);

	@Override
	public boolean hasPermission(Authentication authentication,
			Object targetDomainObject, Object permission) {
		// TODO Auto-generated method stub
//		log.warn("hasPermission called by " + authentication + " on "
//				+ targetDomainObject + " for permission " + permission);

		log.warn("Authorities: " + authentication.getAuthorities());

		Collection<GrantedAuthority> auths = (Collection<GrantedAuthority>) authentication
				.getAuthorities();

		boolean authorized = false;

		if (!auths.isEmpty()) {
			String localContext;
			if (targetDomainObject instanceof Bridge) {
				Bridge bridge = (Bridge) targetDomainObject;
				localContext = bridge.getLocalContext();
			} else if (targetDomainObject instanceof String) {
				localContext = (String)targetDomainObject;
			}
			else {
				log.warn("Object was an unrecognized class: " + targetDomainObject.getClass().toString());
				return false;
			}
			for (GrantedAuthority grant : auths) {
				if (isAdmin(grant.getAuthority(), localContext)) {
					authorized = true;
					break;
				}
			}
			
		}

		return authorized;
	}

	private boolean isAdmin(String authority, String localContext) {
		List<String> adminRoles = Arrays.asList(new String[] { "Instructor",
				"Secondary Instructor", "Owner", "maintain", "Administrator" });

		String[] parts = authority.split("@");

		if (parts.length != 2) {
			throw new IllegalArgumentException(
					"authority must include at \'@\' symbol");
		}

		String role = parts[0];
		String glc = parts[1];

		boolean isAdminRole = adminRoles.contains(role);
		boolean isMatchingContext = glc.equals(localContext);

		log.error("Checking localContext " + localContext
				+ " is the same as granted local context " + glc + ": "
				+ isMatchingContext);
		log.error("Checking role " + role + " is contained in " + adminRoles
				+ ": " + isAdminRole);

		boolean check = isMatchingContext && isAdminRole;

		System.err.println("===> Therefore check is: " + check);

		return check;

	}

	@Override
	public boolean hasPermission(Authentication authentication,
			Serializable targetId, String targetType, Object permission) {
		// TODO Auto-generated method stub
		log.warn("hasPermission called by " + authentication + " on "
				+ targetId + " of type " + targetType + " for permission "
				+ permission);
		return false;
	}

}
