package edu.virginia.shanti.om.bridge.domain;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

import java.util.Iterator;
import java.util.List;

import javax.validation.ConstraintViolationException;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.jpa.JpaSystemException;
import org.springframework.roo.addon.test.RooIntegrationTest;

@RooIntegrationTest(entity = Bridge.class)
public class BridgeTest {

	@Autowired
	private BridgeDataOnDemand dod;

	@Test (expected = JpaSystemException.class)
	public void shouldOnlyAllowOneConfigPerFullContext() {

		assertNotNull("Data On Demand not injected", dod);
		dod.getRandomBridge();

		List<Bridge> all = Bridge.findAllBridges();

		for (Iterator<Bridge> iterator = all.iterator(); iterator.hasNext();) {
			Bridge bridge = (Bridge) iterator.next();
			System.err.println(bridge);
		}

		Bridge oldBridge = dod.getRandomBridge();
		copyBridge(oldBridge).persist(); // should throw exception

	}

	@Test
	public void shouldSaveConfigsForFullContext() {
		
		Bridge mb = createMock();
		mb.persist();

		Bridge singleResult = Bridge.findBridgesByLocalContext(
				mb.getLocalContext()).getSingleResult();

		System.err.println(singleResult.toString());
		assertThat(singleResult.toString(), equalTo(mb.toString()));
	}

	@Test(expected = ConstraintViolationException.class)
	public void shouldNotAllowSavingConfigsWithoutLocalSubContext() {
		Bridge bridge = createMock();
		bridge.setLocalSubContext(null);
		bridge.persist(); // should throw ConstraintViolationException
	}

	@Test
	public void shouldReturnAllConfigsForLocalContext() {
		
		int NUM = 8;
		
		assertNotNull("Data On Demand not injected", dod);
		dod.getRandomBridge();

		// Adding 8 subcontexts
		for (int i = 0; i < NUM; i++) {
			Bridge mock = createMock();
			mock.setLocalSubContext("subcontext" + i);
			mock.persist();
		}
		
		List<Bridge> resultList = Bridge.findBridgesByLocalContext(createMock().getLocalContext()).getResultList();
		
		assertEquals("Wrong number of bridges returned.", NUM, resultList.size());
		
		for (Iterator<Bridge> iterator = resultList.iterator(); iterator.hasNext();) {
			Bridge bridge = (Bridge) iterator.next();
			System.err.println(bridge);
		}
		
	}

	// UTILITY
	protected Bridge createMock() {
		Bridge mock = new Bridge();
		mock.setRemoteName("remoteName");
		mock.setLocalContext("localContext");
		mock.setLocalSubContext("localSubContext");
		mock.setRemoteContext(new RemoteContext());
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
