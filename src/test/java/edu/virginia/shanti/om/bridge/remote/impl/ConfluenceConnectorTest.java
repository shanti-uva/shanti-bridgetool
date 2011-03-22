package edu.virginia.shanti.om.bridge.remote.impl;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.List;

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

	@Test
	public void testConfluenceConnector() {
		
//		String[] beans = applicationContext.getBeanDefinitionNames();
//		
//		for (String bean : beans) {
//			System.err.println(bean);
//		}
//		
		ConfluenceConnector conf = (ConfluenceConnector) applicationContext.getBean("confluenceConnector");
		
		assertNotNull(conf);
		assertTrue(conf instanceof ConfluenceConnector);
		
	}

	@Test
	public void testGetContexts() {
		
		ConfluenceConnector conf = (ConfluenceConnector) applicationContext.getBean("confluenceConnector");
		
		RemoteServer remoteServer = new RemoteServer();
		remoteServer.setImplementationName("confluenceConnector");
		remoteServer.setRemoteUrl("https://wiki.shanti.virginia.edu");
		remoteServer.setRemoteName("shanti-wiki");
		List<RemoteContextChoice> contexts = conf.getContexts(remoteServer);
		
		assertNotNull("getContexts() returned null!",contexts);
		
		for (RemoteContextChoice remoteContextChoice : contexts) {
			System.err.println("=======>" + remoteContextChoice);
		}
		
	}

	@Test
	public void testCreateRemoteContext() {
		
		ConfluenceConnector conf = (ConfluenceConnector) applicationContext.getBean("confluenceConnector");
		RemoteContext newContext = new RemoteContext();
		newContext.setContextId("TESTTEST2");
		newContext.setContextLabel("Yuji Test Space");
		RemoteContext newRemoteContext = conf.createRemoteContext(newContext);
		System.err.println(newRemoteContext);
		
	}

	@Test
	public void testGetSummaryMarkup() {
		fail("Not yet implemented"); // TODO
	}

	@Test
	public void testGetRemotePermissions() {
		fail("Not yet implemented"); // TODO
	}

}
