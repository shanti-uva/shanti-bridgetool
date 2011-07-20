package edu.virginia.shanti.om.bridge.auth;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.TestingAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/META-INF/spring/applicationContext.xml",
		"/META-INF/spring/applicationContext-security.xml" })
public class UserDetailsServiceTest {
		
	private Authentication USER = new TestingAuthenticationToken("imauser", "creds", new LinkedList<GrantedAuthority>());
	
	@Autowired
	UserDetailsService userDetailsService;

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testLoadUserDetails() {
		
		GrantedAuthority grant = new GrantedAuthorityImpl("chicken");
		GrantedAuthority grant2 = new GrantedAuthorityImpl("piglet");
		userDetailsService.saveGrant(USER.getName(), grant);
		userDetailsService.saveGrant(USER.getName(), grant2);

		
		UserDetails details = userDetailsService.loadUserDetails(USER);
		
		System.err.println(details);
		
		Collection<GrantedAuthority> authorities = details.getAuthorities();
		
		System.err.println("Granted Authorities: ");
		for (Iterator iterator = authorities.iterator(); iterator.hasNext();) {
			GrantedAuthority grantedAuthority = (GrantedAuthority) iterator
					.next();
			
			System.err.println(" => " + grantedAuthority);
				
		}
		
		
		assertThat(authorities, hasItem(grant));
		assertThat(authorities, hasItem(grant2));		
		
	}
	
}
