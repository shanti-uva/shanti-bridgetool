package edu.virginia.shanti.om.bridge.service;

import java.util.Arrays;

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

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/META-INF/spring/applicationContext.xml",
		"/META-INF/spring/applicationContext-security.xml" })
public class AdminUserImplTest {

	@Autowired
	AdminUserImpl adminUserImpl;
	
	@Before
	public void setUp() throws Exception {

		Authentication auth = new UsernamePasswordAuthenticationToken("ys2n","figglywigglysession.sakai8",Arrays.asList(new GrantedAuthority[] { new GrantedAuthorityImpl("test") }));
		SecurityContextHolder.getContext().setAuthentication(auth);

	}

	@Test
	public void testGetAuthentication() {

		Authentication auth = adminUserImpl.getAuthentication();

	}

}
