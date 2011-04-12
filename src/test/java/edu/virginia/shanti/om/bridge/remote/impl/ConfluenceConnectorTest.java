package edu.virginia.shanti.om.bridge.remote.impl;

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

import edu.virginia.shanti.om.bridge.domain.RemoteContext;
import edu.virginia.shanti.om.bridge.domain.RemoteServer;
import edu.virginia.shanti.om.bridge.form.RemoteContextChoice;
import edu.virginia.shanti.om.bridge.remote.RemotePermissions;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/META-INF/spring/applicationContext*.xml" })
public class ConfluenceConnectorTest {

	private static final String MOCKUSER = "ys2n";

	private static final String MOCKPASSWORD = "mockpassword";

	@Autowired
	private ApplicationContext applicationContext;

	private ConfluenceConnector conf;

	private RemoteServer remoteServer;

	@Before
	public void setUp() {

		conf = (ConfluenceConnector) applicationContext
				.getBean("confluenceConnector");

		remoteServer = new RemoteServer();
		remoteServer.setImplementationName("confluenceConnector");
		remoteServer.setRemoteUrl("https://wiki.shanti.virginia.edu");
		remoteServer.setRemoteName("shanti-wiki");

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
		ConfluenceConnector conf = (ConfluenceConnector) applicationContext
				.getBean("confluenceConnector");

		assertNotNull(conf);
		assertTrue(conf instanceof ConfluenceConnector);

	}

	@Test
	public void testGetContexts() {

		Principal principal = SecurityContextHolder.getContext()
				.getAuthentication();
		List<RemoteContextChoice> contexts = conf.getContexts(principal,
				remoteServer);

		assertNotNull("getContexts() returned null!", contexts);

		for (RemoteContextChoice remoteContextChoice : contexts) {
			System.err.println("=======>" + remoteContextChoice);
		}

		// fail("Need to implement checks");

	}

	@Test
	public void testCreateAndRemoveRemoteContext() {

		Principal principal = SecurityContextHolder.getContext()
				.getAuthentication();

		RemoteContext newContext = new RemoteContext();
		newContext.setContextId("TESTTEST2");
		newContext.setContextLabel("Yuji Test Space");
		RemoteContext newRemoteContext = null;
		try {
			newRemoteContext = conf.createRemoteContext(principal, newContext);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.err.println(newRemoteContext);

		conf.removeRemoteContext(principal, newContext);

		// fail("Need to implement checks");

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
		List<RemoteContextChoice> contexts = conf.getContexts(principal,
				remoteServer);
		RemoteContextChoice choice = contexts.get(0);
		RemoteContext rc = new RemoteContext(choice);

		System.err.println("Picking: " + rc);
		return rc;
	}

	@Test
	public void testGetRemotePermissions() {
		Authentication auth = SecurityContextHolder.getContext()
				.getAuthentication();
		RemotePermissions perms = conf
				.getRemotePermissions(auth, pickContext());
		assertNotNull(perms);

		System.err.println(perms);

	}

	@Test
	public void testSetRemotePermissions() {
		// Unfortunately since we have no way to really check these permissions,
		// there is no way to tell if this works!
	}

}
