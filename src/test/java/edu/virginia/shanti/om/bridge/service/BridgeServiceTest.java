package edu.virginia.shanti.om.bridge.service;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.RemoteException;
import java.util.List;

import javax.xml.rpc.ServiceException;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import edu.virginia.shanti.om.bridge.domain.Bridge;
import edu.virginia.shanti.om.bridge.domain.ConfluencePermissionSet;
import edu.virginia.shanti.om.bridge.domain.LocalContextType;
import edu.virginia.shanti.om.bridge.domain.LocalGroupType;
import edu.virginia.shanti.om.bridge.domain.PermissionMap;
import edu.virginia.shanti.om.bridge.domain.RemoteContext;
import edu.virginia.shanti.om.bridge.form.BasicConfigBean;
import edu.virginia.shanti.om.bridge.soap.sakai.SakaiLoginServiceLocator;
import edu.virginia.shanti.om.bridge.soap.sakai.SakaiLogin_PortType;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/META-INF/spring/applicationContext*.xml" })
// @Transactional
public class BridgeServiceTest {

	private static final String TEST_REAL_USER = "ys2n";

	private static final String TEST_REAL_SITEID = "23e3d2d3-cad7-4dc5-89c2-666e2b1f1b18";

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
				bridgeService.checkConfig(BasicConfigBean.getInstance(TEST_REAL_USER,"firstLocalContext", null, "serviceName",System.currentTimeMillis())));
		assertEquals("unconfigured", bridgeService.checkConfig(BasicConfigBean.getInstance(
				TEST_REAL_USER,"secondLocalContext", "secondLocalSubContext", "serviceName",System.currentTimeMillis())));
	}

	@Transactional(propagation=Propagation.REQUIRED)
	@Test
	public void testSaveBridge() throws MalformedURLException, ServiceException, RemoteException {

		setupMockPermissionMap();
		
		String serverId = "sakai11";
		
		// login and get session
		SakaiLogin_PortType sakaiLogin = new SakaiLoginServiceLocator().getSakaiLogin(new URL("https://"+ serverId + ".itc.virginia.edu/sakai-axis/SakaiLogin.jws"));
		String session = sakaiLogin.login(TEST_REAL_USER,"XXXXXX").concat("." + serverId);
		System.err.println(session);
		
		SecurityContextHolder.getContext()
				.setAuthentication(
						new UsernamePasswordAuthenticationToken(TEST_REAL_USER,
								session));
		
		Bridge bridge = createMockBridge();
		bridge.setLocalContext(TEST_REAL_SITEID);
		bridge.setLocalSubContext("firstLocalSubContext");
		RemoteContext remoteContext = createMockRemoteContext();
		bridge.setRemoteName("shanti-wiki");
		remoteContext.setRemoteName("shanti-wiki");
		remoteContext.setContextId("TTT");
		// remoteContext.persist();
		bridge.setRemoteContext(remoteContext);
		// bridge.persist();
		
		bridgeService.save(bridge);
		
		
		assertThat(bridgeService.checkConfig(BasicConfigBean.getInstance(TEST_REAL_USER,TEST_REAL_SITEID, null, "shanti-wiki", System.currentTimeMillis())),
				equalTo("configured"));
		assertThat(bridgeService.checkConfig(BasicConfigBean.getInstance(TEST_REAL_USER,"secondLocalContext",
				"secondLocalSubContext", "shanti-wiki", System.currentTimeMillis())), equalTo("unconfigured"));
	}

	private void setupMockPermissionMap() {
		// Setup a permission map for collaborations
		PermissionMap pm = new PermissionMap();
		pm.setLocalContextMask("");
		pm.setLocalContextType(LocalContextType.COLLABORATION);
		pm.setName("oinko");
		
		ConfluencePermissionSet pset1 = new ConfluencePermissionSet();
		pset1.setGroupName("member");
		pset1.setLocalGroupType(LocalGroupType.SAKAIROLE);
		pset1.setViewSpace(true);
		pset1.setComment(true);
		pset1.persist();
		
		pm.addPermissionSet(pset1);
		
		ConfluencePermissionSet pset2 = new ConfluencePermissionSet();
		pset2.setGroupName("administrator");
		pset2.setLocalGroupType(LocalGroupType.SAKAIROLE);
		pset2.setViewSpace(true);
		pset2.setComment(true);
		pset2.persist();
	
		pm.addPermissionSet(pset2);
		
		ConfluencePermissionSet pset3 = new ConfluencePermissionSet();
		pset3.setGroupName("observer");
		pset3.setLocalGroupType(LocalGroupType.SAKAIROLE);
		pset3.setViewSpace(true);
		pset3.setComment(true);
		pset3.persist();
		
		pm.addPermissionSet(pset3);
		
		pm.persist();
	}

	private RemoteContext createMockRemoteContext() {
		RemoteContext remoteContext = new RemoteContext();
		remoteContext.setRemoteName("serviceName");
		remoteContext.setContextId("remotecontext");
		remoteContext.setContextLabel("Remote Context");
		remoteContext.setUrl("http://blah.blah.blah");
		return remoteContext;
	}

	@Transactional
	@Test
	public void getBridge() {
		
		Bridge mockBridge = createMockBridge();
		mockBridge.getRemoteContext().persist();
		mockBridge.persist();
		String mockLocalContext = mockBridge.getLocalContext();
		String mockLocalSubContext = mockBridge.getLocalSubContext();
		String mockService = mockBridge.getRemoteContext().getRemoteName();
		
		Bridge bridge = bridgeService.getBridge(BasicConfigBean.getInstance(TEST_REAL_USER,mockLocalContext, mockLocalSubContext, mockService, System.currentTimeMillis()));
		assertNotNull("Bridge was null.", bridge);
		assertNotNull(bridge.getRemoteContext());
	}

	@Transactional
	@Test
	public void getBridges() {
		
		Bridge mockBridge = createMockBridge();
		mockBridge.getRemoteContext().persist();
		mockBridge.persist();
		
		String mockLocalContext = mockBridge.getLocalContext();
		// String mockLocalSubContext = mockBridge.getLocalSubContext();
		String mockService = mockBridge.getRemoteContext().getRemoteName();
		
		List<Bridge> bridges = bridgeService.getBridges(BasicConfigBean.getInstance(TEST_REAL_USER,mockLocalContext,
				null, mockService, System.currentTimeMillis()));
		assertNotNull("Bridge list was null.", bridges);
		assertFalse("Bridge list was empty", bridges.isEmpty());
	}

	// UTILITY
	protected Bridge createMockBridge() {
		String stamp = Long.toHexString(System.currentTimeMillis());
		Bridge mock = new Bridge();
		mock.setRemoteName("remoteName" + stamp);
		mock.setLocalContext("yourLocalContext" + stamp);
		mock.setLocalSubContext("yourLocalSubContext" + stamp);
		RemoteContext rc = new RemoteContext();
		rc.setContextId("contextId" + stamp);
		rc.setContextLabel("Context Label" + stamp);
		rc.setUrl("http://some.url.some.place" + stamp);	
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
