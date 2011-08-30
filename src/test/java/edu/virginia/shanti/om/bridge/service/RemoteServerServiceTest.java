package edu.virginia.shanti.om.bridge.service;

import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import edu.virginia.shanti.om.bridge.domain.RemoteContext;
import edu.virginia.shanti.om.bridge.domain.RemoteServer;
import edu.virginia.shanti.om.bridge.form.ConfigBean;
import edu.virginia.shanti.om.bridge.form.ConfluenceConfigBean;
import edu.virginia.shanti.om.bridge.form.RemoteContextChoice;
import edu.virginia.shanti.om.bridge.remote.RemoteConnector;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/META-INF/spring/applicationContext*.xml" })
public class RemoteServerServiceTest {

	@Autowired
	private ApplicationContext applicationContext;

	private static final String CONFIG_NAME = "MockConfluence";
	private static final String CONFIG_IMPLEMENTATION = "mockConfluenceConnector";
	private static final String CONFIG_INSTANCE = "https://wiki-test.shanti.virginia.edu";

	private static final String MOCKUSER = "ys2n";
	private static final String MOCKPASSWORD = "mockpassword";
	private RemoteServerService remoteServerService = new RemoteServerService();

	@Transactional
	public void testGetRemoteServer() {
		Assert.fail("Test not implemented.");
	}

	@Before
	public void setUp() {
		SecurityContextHolder.getContext()
				.setAuthentication(
						new UsernamePasswordAuthenticationToken(MOCKUSER,
								MOCKPASSWORD));
	}

	@Test
	public void checkApplicationContextForConnectorImplementation() {
		Object bean = applicationContext.getBean(CONFIG_IMPLEMENTATION);
		assertNotNull(bean);
		assertTrue(bean instanceof RemoteConnector);

		String[] beans = applicationContext.getBeanDefinitionNames();

		for (String bean2 : beans) {
			System.err.println(bean2);
		}

	}

	@Transactional
	@Test
	public void addRemoteServer() {
		remoteServerService.addRemoteServer(CONFIG_NAME, CONFIG_IMPLEMENTATION,
				CONFIG_INSTANCE);

		RemoteServer server = remoteServerService.getRemoteServer(CONFIG_NAME);

		assertThat(server.getImplementationName(),
				is(equalTo(CONFIG_IMPLEMENTATION)));

	}

	@Transactional
	@Test
	public void getRemoteConfiguration() {
		RemoteServer configuration = remoteServerService
				.getRemoteServer(CONFIG_NAME);
		assertThat(configuration.getImplementationName(),
				is(equalTo(CONFIG_IMPLEMENTATION)));

	}

	@Transactional
	@Test
	public void getRemoteContexts() {
		ConfigBean config = new ConfluenceConfigBean();
		config.setRemoteService(CONFIG_NAME);
		
		RemoteServer remoteConfiguration = remoteServerService
				.getRemoteServer(CONFIG_NAME);
		assertNotNull(remoteConfiguration);
		List<RemoteContextChoice> remoteContexts = remoteServerService
				.getRemoteContexts(remoteConfiguration, config);
		assertNotNull("Remote Contexts were null!", remoteContexts);
		assertTrue("No Remote Contexts found!", remoteContexts.size() > 0);

	}

	@Transactional
	@Test
	public void getRemoteContextsByConfigName() {
		
		ConfigBean config = new ConfluenceConfigBean();
		config.setRemoteService(CONFIG_NAME);
		
		List<RemoteContextChoice> remoteContexts = remoteServerService
				.getRemoteContexts(config);
		assertNotNull(remoteContexts);
		assertTrue(remoteContexts.size() > 0);
	}

	@Transactional
	@Test
	public void getAllRemoteServers() {
		remoteServerService.addRemoteServer(CONFIG_NAME + "2",
				CONFIG_IMPLEMENTATION, CONFIG_INSTANCE + "2");
		List<RemoteServer> allRemoteServers = remoteServerService
				.getAllRemoteServers();
		assertNotNull(allRemoteServers);

		System.err.println("Size of list = " + allRemoteServers.size());
		assertTrue("list of servers is empty!", allRemoteServers.size() > 0);

	}

	@Transactional
	@Test
	public void testAddRemoteServer() {
		throw new RuntimeException("Test not implemented.");
	}

	@Transactional
	@Test
	public void testGetSummaryMarkup() {

		ConfigBean config = new ConfluenceConfigBean();
		config.setRemoteService(CONFIG_NAME);
		
		RemoteServer remoteServer = remoteServerService
				.getRemoteServer(config);
		assertNotNull(remoteServer);
		List<RemoteContextChoice> remoteContexts = remoteServerService
				.getRemoteContexts(remoteServer, config);

		System.err.println("Remote Contexts = " + remoteContexts);

		String summaryMarkup = remoteServerService
				.getSummaryMarkup(new RemoteContext(remoteContexts.get(0)));

		System.err.println(summaryMarkup);
		assertNotNull(summaryMarkup);

	}

	@Transactional
	@Test
	public void testGetAllRemoteServers() {
		throw new RuntimeException("Test not implemented.");
	}

	@Transactional
	@Test
	public void testSetRemotePermissions() {
		throw new RuntimeException("Test not implemented.");
	}

}
