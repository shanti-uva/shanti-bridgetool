package edu.virginia.shanti.om.bridge.service;

import static org.junit.Assert.assertNotNull;

import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import edu.virginia.shanti.om.bridge.domain.ConfluencePermissionSet;
import edu.virginia.shanti.om.bridge.domain.LocalContextType;
import edu.virginia.shanti.om.bridge.domain.LocalGroupType;
import edu.virginia.shanti.om.bridge.domain.PermissionMap;
import edu.virginia.shanti.om.bridge.domain.PermissionSet;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/META-INF/spring/applicationContext*.xml" })
public class PermissionMapServiceTest {

	@Autowired
	PermissionMapService permissionMapService;

	@Before
	public void setUp() throws Exception {
	}

	@Transactional
	@Test
	public void testSaveAndGetPermissionMap() {
		PermissionMap permissionMap = new PermissionMap();
		permissionMap.setLocalContextType(LocalContextType.COLLABORATION);
		ConfluencePermissionSet pset = new ConfluencePermissionSet();
		pset.setComment(true);
		pset.setGroupName("Instructor");
		pset.setLocalGroupType(LocalGroupType.SAKAIROLE);
		permissionMap.addPermissionSet(pset);
		permissionMapService.savePermissionMap(permissionMap);

		PermissionMap pm = permissionMapService
				.getPermissionMap(LocalContextType.COLLABORATION);

		assertNotNull(pm);
		Set<PermissionSet> set = pm.getPermissionSets();
		PermissionSet perms = set.iterator().next();
		
		assertNotNull(perms);
		
		System.err.println(perms);
		

	}

}
