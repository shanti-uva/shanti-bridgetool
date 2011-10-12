package edu.virginia.shanti.om.bridge.remote.impl;

import static org.junit.Assert.*;

import java.security.Principal;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import edu.virginia.shanti.om.bridge.domain.RemoteContext;
import edu.virginia.shanti.om.bridge.domain.RemoteServer;
import edu.virginia.shanti.om.bridge.form.ConfigBean;
import edu.virginia.shanti.om.bridge.form.ConfluenceConfigBean;
import edu.virginia.shanti.om.bridge.form.RemoteContextChoice;
import edu.virginia.shanti.om.bridge.remote.RemoteConnector;
import edu.virginia.shanti.om.bridge.service.PermissionMapService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/META-INF/spring/applicationContext*.xml" })
public class NowCommentConnectorTest {
	
	// arbitrary test values
	private static final String NC_REMOTE_NAME = "testRemoteName" + System.currentTimeMillis();
	private static final String NC_REMOTE_URL = "http://the.correctplace.yeah" + System.currentTimeMillis();
	
	// fixed values
	private static final String JAVABASICS_SITEID = "fde0d977-9906-42df-00a5-26c0d0bbdab1";
	private static final String NC_CONNECTOR_NAME = "nowCommentConnector";
	private static final String COLLAB_SITE_ALIAS = "~collab:java-basics-fde0:summer2008";
	private static final String NC_CORRECT_GROUP_NAME = "NowComment Group: Java Basics";
	// private static final String ONEMOON_SITEID = "f668e345-d590-469d-aebe-e3bbba034a54";
	
	// session values
	private static final String MOCKUSER = "ys2n";
	private static final String MOCKSESSION = "860d27aa-c3e7-406b-b750-f0d6837ba1e8.sakai9";
	
	@Autowired
	private ApplicationContext applicationContext;
	private RemoteConnector connector;
	private RemoteServer remoteServer;

	@Before
	public void setUp() throws Exception {
		connector = (RemoteConnector) applicationContext
				.getBean(NC_CONNECTOR_NAME);

		remoteServer = new RemoteServer();
		remoteServer.setImplementationName(NC_CONNECTOR_NAME);
		remoteServer.setRemoteUrl(NC_REMOTE_URL);
		remoteServer.setRemoteName(NC_REMOTE_NAME);

		SecurityContextHolder.getContext()
				.setAuthentication(
						new UsernamePasswordAuthenticationToken(MOCKUSER,
								MOCKSESSION));
	}

	@Test
	public void testGetContexts() {
	
		Principal principal = SecurityContextHolder.getContext()
				.getAuthentication();

		ConfigBean config = new ConfluenceConfigBean();
		
		config.setLocalContext(JAVABASICS_SITEID); // Java Basics
		// config.setLocalContext();  // 1 Moon Test
		config.setLocalSubContext("localSubContext");
		config.setRemoteService(NC_REMOTE_NAME);
		config.setUser("ys2n");
			
		List<RemoteContextChoice> choices = connector.getContexts(principal, remoteServer, config);
		
		assertTrue( "There should be exactly one choice, but there was actually  " + choices.size(), choices.size() == 1);
		
		RemoteContextChoice remoteContextChoice = choices.get(0);
		
		System.err.println(remoteContextChoice);
		
		assertEquals(COLLAB_SITE_ALIAS,remoteContextChoice.getContextId());
		assertEquals(NC_CORRECT_GROUP_NAME,remoteContextChoice.getContextLabel());
		assertEquals(NC_REMOTE_NAME,remoteContextChoice.getRemoteName());
		assertEquals(NC_REMOTE_URL + "/uva?redirect_to_group=" + COLLAB_SITE_ALIAS,remoteContextChoice.getUrl());
		
		
	}

	@Test
	public void testCreateRemoteContext() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetSummaryMarkup() {
		
		Principal principal = SecurityContextHolder.getContext()
				.getAuthentication();

		ConfigBean config = new ConfluenceConfigBean();
		
		config.setLocalContext(JAVABASICS_SITEID); // Java Basics
		// config.setLocalContext();  // 1 Moon Test
		config.setLocalSubContext("localSubContext");
		config.setRemoteService(NC_REMOTE_NAME);
		config.setUser("ys2n");
		
		RemoteContextChoice rcc = connector.getContexts(principal, remoteServer, config).get(0);
		RemoteContext remoteContext = new RemoteContext(rcc);

		String summaryMarkup = connector.getSummaryMarkup(principal, remoteContext);

		System.err.println("Summary Markup:\n" + summaryMarkup);

		assertNotNull("Summary Markup was null!", summaryMarkup);
	
	}

	@Test
	public void testGetRemotePermissions() {
		fail("Not yet implemented");
	}

	@Test
	public void testSetRemotePermissions() {
		fail("Not yet implemented");
	}

}
