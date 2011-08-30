package edu.virginia.shanti.om.bridge.remote.impl;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.security.Principal;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import edu.virginia.shanti.om.bridge.domain.ConfluencePermissionSet;
import edu.virginia.shanti.om.bridge.domain.LocalContextType;
import edu.virginia.shanti.om.bridge.domain.LocalGroupType;
import edu.virginia.shanti.om.bridge.domain.PermissionMap;
import edu.virginia.shanti.om.bridge.domain.RemoteContext;
import edu.virginia.shanti.om.bridge.domain.RemoteServer;
import edu.virginia.shanti.om.bridge.form.ConfigBean;
import edu.virginia.shanti.om.bridge.form.ConfluenceConfigBean;
import edu.virginia.shanti.om.bridge.form.RemoteContextChoice;
import edu.virginia.shanti.om.bridge.remote.RemoteConnector;
import edu.virginia.shanti.om.bridge.remote.RemotePermissions;
import edu.virginia.shanti.om.bridge.service.PermissionMapService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/META-INF/spring/applicationContext*.xml" })
public class ConfluenceConnectorTest {

	private static final String TESTSLUG = "TESTTEST2";

	private static final String MOCKUSER = "tms";

	private static final String MOCKPASSWORD = "mockpassword";

	@Autowired
	private ApplicationContext applicationContext;

	private RemoteConnector conf;

	private RemoteServer remoteServer;

	private PermissionMapService permissionMapService;

	@Before
	public void setUp() {

		conf = (RemoteConnector) applicationContext
				.getBean("confluenceConnector");

		remoteServer = new RemoteServer();
		remoteServer.setImplementationName("confluenceConnector");
		remoteServer.setRemoteUrl("https://wiki.shanti.virginia.edu");
		remoteServer.setRemoteName("shanti-wiki");
		permissionMapService = applicationContext
				.getBean(PermissionMapService.class);

		SecurityContextHolder.getContext()
				.setAuthentication(
						new UsernamePasswordAuthenticationToken(MOCKUSER,
								MOCKPASSWORD));

	}

	@Test
	public void testConfluenceConnector() {

		// String[] beans = applicationContext.getBeanDefinitionNames();
		//
		// for (String bean : beans) {
		// System.err.println(bean);
		// }
		//
		RemoteConnector conf = (RemoteConnector) applicationContext
				.getBean("confluenceConnector");

		assertNotNull(conf);
		assertTrue(conf instanceof ConfluenceConnector);

	}

	@Test
	public void testGetContexts() {
		int LAPS = 5;

		Principal principal = SecurityContextHolder.getContext()
				.getAuthentication();
		
		ConfigBean config = new ConfluenceConfigBean();
		
		long[] laptimes = new long[LAPS];
		for (int i = 0; i < LAPS; i++) {
			long start = System.currentTimeMillis();

			List<RemoteContextChoice> contexts = conf.getContexts(principal,
					remoteServer, config);
			assertNotNull("getContexts() returned null!", contexts);
			
			
			System.err.println("Remote Context Choices: ");
			for (RemoteContextChoice remoteContextChoice : contexts) {
				System.err.println("=======>" + remoteContextChoice);
			}
			assertTrue("getContexts() returned empty list!",
					!contexts.isEmpty());
			laptimes[i] = System.currentTimeMillis() - start;
		}
		
		
		
		for (int i = 0; i < laptimes.length; i++) {
			long l = laptimes[i];
			
			System.err.println("lap " + i + ": " + l);
		}


		// fail("Need to implement checks");

	}

	@Test
	public void testCreateAndRemoveRemoteContext() {

		Principal principal = SecurityContextHolder.getContext()
				.getAuthentication();

		RemoteContext newContext = new RemoteContext();
		ConfigBean config = new ConfluenceConfigBean();
		newContext.setContextId(TESTSLUG);
		newContext.setContextLabel("Yuji Test Space");
		RemoteContext newRemoteContext = conf.createRemoteContext(principal,
				newContext, config);

		assertNotNull(newContext);
		
		assertThat(newContext.getUrl(), is(equalTo("https://wiki.shanti.virginia.edu/display/" +
				TESTSLUG)));
		
		System.err.println(newRemoteContext);

		// conf.removeRemoteContext(principal, newContext);
		
	}

	@Test
	public void testGetSummaryMarkup() {

		Principal principal = SecurityContextHolder.getContext()
				.getAuthentication();

		RemoteContext remoteContext = pickContext();

		String summaryMarkup = conf.getSummaryMarkup(principal, remoteContext);

		System.out.println(summaryMarkup);

		assertNotNull("Summary Markup was null!", summaryMarkup);

		// fail("Need to implement checks");
	}

	private RemoteContext pickContext() {

		// picks the first context.... ?
		Principal principal = SecurityContextHolder.getContext()
				.getAuthentication();
		
		ConfigBean config = new ConfluenceConfigBean();
		
		
		List<RemoteContextChoice> contexts = conf.getContexts(principal,
				remoteServer, config);
		RemoteContextChoice choice = contexts.get(0);
		RemoteContext rc = new RemoteContext(choice);

		System.err.println("Picking: " + rc);
		return rc;
	}

	@Test
	public void testGetRemotePermissions() {
		Authentication auth = SecurityContextHolder.getContext()
				.getAuthentication();

		RemotePermissions perms = conf.getRemotePermissions(auth,
				"mockLocalContext", pickContext());

		// assertNotNull(perms);

		fail("So what is the right way to (not) implement this?");

		System.err.println(perms);

	}

	@Transactional
	@Test
	public void testSetRemotePermissions() {
		// Unfortunately since we have no way to check these permissions
		// programmatically
		// you must login to confluence via the web and check the permissions...

		Authentication auth = SecurityContextHolder.getContext()
				.getAuthentication();

		// create the permissions we want to write
		PermissionMap permMap = new PermissionMap();
		permMap.setLocalContextType(LocalContextType.COLLABORATION);

		String[] roles = new String[] { "Instructor", "Student",
				"Secondary Instructor" };
		for (int i = 0; i < roles.length; i++) {
			ConfluencePermissionSet pset1 = new ConfluencePermissionSet();
			pset1.setComment(true);
			pset1.setGroupName(roles[i]);
			pset1.setLocalGroupType(LocalGroupType.SAKAIROLE);
			pset1.setCreateAttachment(true);
			pset1.setViewSpace(true);
			pset1.persist();
			permMap.addPermissionSet(pset1);
		}
		permMap.persist();

		// pick a space
		RemoteContext remoteContext = pickContext();

		String localContext = "mockLocalContext";

		// lookup the permissionMap we created earlier
		PermissionMap permissionMap = permissionMapService
				.getPermissionMap(LocalContextType.COLLABORATION);

		assertNotNull("Couldn't retrieve permissionMap!", permissionMap);

		// remotely set the permissions
		conf.setRemotePermissions(auth, localContext, remoteContext,
				permissionMap);

		System.err.println("Auth=" + auth + "\n=" + remoteContext
				+ "\npermissionMap=" + permissionMap);

	}
	
	
	@Test
	public void testAssureUser() {
		
//		Set<GrantedAuthority> grants = new HashSet<GrantedAuthority>();
//		
//		Principal principal = new UsernamePasswordAuthenticationToken("TestUser","TestPass", grants);
//	
//		boolean assureUser = conf.assureUser(principal);
//		
//		assertTrue("Assure User returned false", assureUser);
//		
		// should now REMOVE the test user we created.
	
	}

}
