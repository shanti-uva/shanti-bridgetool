package edu.virginia.shanti.om.bridge.auth;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.Collection;
import java.util.HashSet;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import edu.virginia.shanti.om.bridge.domain.Bridge;
import edu.virginia.shanti.om.bridge.service.CurrentUserImpl;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/META-INF/spring/applicationContext.xml", "/META-INF/spring/applicationContext-security.xml" })
public class BridgeToolPermissionEvaluatorTest {
	
	private static final Object USER = null;
	private static final Object CREDS = null;
	
	@Autowired
	private BridgeToolPermissionEvaluator btpe;
	
	@Autowired
	private CurrentUserImpl currentUser;

	@Before
	public void setUp() throws Exception {
		
		Collection<GrantedAuthority> grants = new HashSet<GrantedAuthority>();
		
		grants.add(new GrantedAuthorityImpl("Student@blahblahblah"));
		grants.add(new GrantedAuthorityImpl("Instructor@yeahyeahyeah"));
		grants.add(new GrantedAuthorityImpl("Administrator@whoawhoawhoa"));
		grants.add(new GrantedAuthorityImpl("Member@sososo"));
		
		Authentication auth = new UsernamePasswordAuthenticationToken(USER, CREDS, grants);
				
		SecurityContextHolder.getContext().setAuthentication(auth);
		
	}
	
	@Test
	public void injected() {
		
		assertNotNull("BridgeToolPermissionEvaluator was not injected",btpe);
		
	}
	
	

	@Test
	public void testHasPermissionAuthenticationObjectObject() {
		
		Bridge bridge = new Bridge();
		bridge.setLocalContext("yeahyeahyeah");
		bridge.setCurrentUser(currentUser);
		bridge.setBridgeToolPermissionEvaluator(btpe);

		assertTrue(btpe.hasPermission(currentUser.getAuthentication(), bridge, "admin"));
	
	}
	
	@Test
	public void testBridgeIsAdmin() {
		
		Bridge bridge = new Bridge();
		bridge.setLocalContext("blahblahblah");
		bridge.setCurrentUser(currentUser);
		assertFalse(bridge.isAdmin());
		
		bridge.setLocalContext("whoawhoawhoa");
		assertTrue(bridge.isAdmin());
		
	}

	@Test
	public void testHasPermissionAuthenticationSerializableStringObject() {
		fail("Not yet implemented");
	}

}
