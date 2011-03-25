package edu.virginia.shanti.om.bridge.remote.impl;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import edu.virginia.shanti.om.bridge.domain.RemoteContext;
import edu.virginia.shanti.om.bridge.domain.RemoteServer;
import edu.virginia.shanti.om.bridge.form.RemoteContextChoice;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/META-INF/spring/applicationContext*.xml" })
public class ConfluenceConnectorTest {

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

		List<RemoteContextChoice> contexts = conf.getContexts(remoteServer);

		assertNotNull("getContexts() returned null!", contexts);

		for (RemoteContextChoice remoteContextChoice : contexts) {
			System.err.println("=======>" + remoteContextChoice);
		}

		// fail("Need to implement checks");

	}

	@Test
	public void testCreateRemoteContext() {

		RemoteContext newContext = new RemoteContext();
		newContext.setContextId("TESTTEST2");
		newContext.setContextLabel("Yuji Test Space");
		RemoteContext newRemoteContext = null;
		try {
			newRemoteContext = conf.createRemoteContext(newContext);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.err.println(newRemoteContext);

		conf.removeRemoteContext(newContext);

		// fail("Need to implement checks");

	}

	@Test
	public void testGetSummaryMarkup() {

		RemoteContext remoteContext = pickContext();

		String summaryMarkup = conf.getSummaryMarkup(remoteContext);

		System.out.println(summaryMarkup);

		assertNotNull("Summary Markup was null!", summaryMarkup);

		// fail("Need to implement checks");
	}

	private RemoteContext pickContext() {

		List<RemoteContextChoice> contexts = conf.getContexts(remoteServer);
		RemoteContextChoice choice = contexts.get(0);
		RemoteContext rc = new RemoteContext(choice);
		return rc;
	}

	@Test
	public void testGetRemotePermissions() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testSetRemotePermissions() {
		fail("Not yet implemented");
	}

}
