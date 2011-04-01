package edu.virginia.shanti.om.bridge.service;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import edu.virginia.shanti.om.bridge.domain.Bridge;
import edu.virginia.shanti.om.bridge.domain.RemoteContext;
import edu.virginia.shanti.om.bridge.form.BasicConfigBean;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/META-INF/spring/applicationContext*.xml" })
public class BridgeServiceTest {

	@Autowired
	private ApplicationContext applicationContext;

	private BridgeService bridgeService;

	@Before
	public void pullConfigurationService() {
		bridgeService = (BridgeService) applicationContext
				.getBean("bridgeService");
	}

	@Test
	public void pullConfigurationServiceFromApplicationContext() {
		assertNotNull(applicationContext.getBean("bridgeService"));
	}

	@Test
	public void testCheckConfig() {

		// these should not be configured yet.
		assertEquals("unconfigured",
				bridgeService.checkConfig(BasicConfigBean.getInstance("ys2n","firstLocalContext", null, "serviceName",System.currentTimeMillis())));
		assertEquals("unconfigured", bridgeService.checkConfig(BasicConfigBean.getInstance(
				"ys2n","secondLocalContext", "secondLocalSubContext", "serviceName",System.currentTimeMillis())));
	}

	@Test
	public void testSaveBridge() {
		Bridge bridge = createMockBridge();
		bridge.setLocalContext("firstLocalContext");
		bridge.setLocalSubContext("firstLocalSubContext");
		bridge.setRemoteName("shanti-wiki");
		RemoteContext remoteContext = new RemoteContext();
		remoteContext.setRemoteName("serviceName");
		remoteContext.setContextId("remotecontext");
		remoteContext.setContextLabel("Remote Context");
		remoteContext.setUrl("http://blah.blah.blah");
		remoteContext.persist();
		bridge.setRemoteContext(remoteContext);
		bridge.persist();
	}

	@Test
	public void testCheckConfigAgain() {

		// these should not be configured yet.
		assertThat(bridgeService.checkConfig(BasicConfigBean.getInstance("ys2n","firstLocalContext", null, "serviceName", System.currentTimeMillis())),
				equalTo("configured"));
		assertThat(bridgeService.checkConfig(BasicConfigBean.getInstance("ys2n","secondLocalContext",
				"secondLocalSubContext", "serviceName", System.currentTimeMillis())), equalTo("unconfigured"));
	}

	@Test
	public void getBridge() {
		Bridge bridge = bridgeService.getBridge(BasicConfigBean.getInstance("ys2n","firstLocalContext",
				"firstLocalSubContext", "serviceName", System.currentTimeMillis()));
		assertNotNull("Bridge was null.", bridge);
		assertNotNull(bridge.getRemoteContext());
	}

	@Test
	public void getBridges() {
		List<Bridge> bridges = bridgeService.getBridges(BasicConfigBean.getInstance("ys2n","firstLocalContext",
				null, "serviceName", System.currentTimeMillis()));
		assertNotNull("Bridge list was null.", bridges);
		assertFalse("Bridge list was empty", bridges.isEmpty());
	}

	// UTILITY
	protected Bridge createMockBridge() {
		Bridge mock = new Bridge();
		mock.setRemoteName("remoteName");
		mock.setLocalContext("localContext");
		mock.setLocalSubContext("localSubContext");
		RemoteContext rc = new RemoteContext();
		rc.setContextId("contextId");
		rc.setContextLabel("Context Label");
		rc.setUrl("http://some.url.some.place");	
		mock.setRemoteContext(rc);
		return mock;
	}

	// UTILITY
	protected Bridge copyBridge(Bridge theBridge) {
		Bridge bridge = new Bridge();
		bridge.setRemoteName(theBridge.getRemoteName());
		bridge.setLocalContext(theBridge.getLocalContext());
		bridge.setLocalSubContext(theBridge.getLocalSubContext());
		bridge.setRemoteContext(theBridge.getRemoteContext());
		return bridge;
	}

}
