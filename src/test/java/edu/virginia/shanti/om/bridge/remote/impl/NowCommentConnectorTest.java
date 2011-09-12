package edu.virginia.shanti.om.bridge.remote.impl;

import static org.junit.Assert.*;

import java.security.Principal;

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
	
	private static final String MOCKUSER = "ys2n";
	private static final String MOCKSESSION = "b62fff77-4fc7-4ad8-b310-4b62c6ecd4f8.sakai10";
	private static final String JAVABASICS_SITEID = "fde0d977-9906-42df-00a5-26c0d0bbdab1";
	private static final String ONEMOON_SITEID = "f668e345-d590-469d-aebe-e3bbba034a54";
	
	@Autowired
	private ApplicationContext applicationContext;
	private RemoteConnector connector;
	private RemoteServer remoteServer;

	@Before
	public void setUp() throws Exception {
		connector = (RemoteConnector) applicationContext
				.getBean("nowCommentConnector");

		remoteServer = new RemoteServer();
		remoteServer.setImplementationName("nowCommentConnector");
		remoteServer.setRemoteUrl("http://staging.nowcomment.com");
		remoteServer.setRemoteName("nowCommentStaging");

		SecurityContextHolder.getContext()
				.setAuthentication(
						new UsernamePasswordAuthenticationToken(MOCKUSER,
								MOCKSESSION));
	}

	@Test
	public void testGetContexts() {
		fail("Not yet implemented");
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
		config.setRemoteService("nowCommentStaging");
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
