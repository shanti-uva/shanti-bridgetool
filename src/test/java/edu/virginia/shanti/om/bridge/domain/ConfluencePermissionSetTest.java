package edu.virginia.shanti.om.bridge.domain;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class ConfluencePermissionSetTest {

	private static final int NUMPERMS = 14;

	@Test
	public void testHasPermission() {

		ConfluencePermissionSet permSet = new ConfluencePermissionSet();
		permSet.setEditSpace(true);
		permSet.setSetPagePermissions(false);

		assertFalse(permSet.hasPermission("OINKER"));
		assertTrue(permSet.hasPermission("EDITSPACE"));
		assertFalse(permSet.hasPermission("setPagePermissions"));
		assertTrue(permSet.hasPermission("editSpace"));
		assertFalse(permSet.hasPermission("propMap"));
		assertFalse(permSet.hasPermission("setPagePermissions"));
		
		permSet.setSetPagePermissions(true);
				
		assertTrue(permSet.getSetPagePermissions());
		assertTrue(permSet.hasPermission("SETPAGEPERMISSIONS"));
	}

	@Test
	public void testGetPermissions() {
		ConfluencePermissionSet permSet = new ConfluencePermissionSet();

		// Let's set three perms
		permSet.setEditSpace(true);
		permSet.setCreateAttachment(true);
		permSet.setPermission("EDITBLOG", true);
		String[] permissions = permSet.getPermissions();

		assertEquals("Wrong number of permissions!", 3, permissions.length);
		assertTrue(permSet.getEditSpace());
		assertFalse(permSet.getComment());
		assertTrue(permSet.hasPermission("CREATEATTACHMENT"));
	
		System.err.println(Arrays.toString(permissions));
	}

	@Test
	public void testPossiblePermissions() {
		ConfluencePermissionSet permSet = new ConfluencePermissionSet();
		String[] possiblePerms = permSet.possiblePermissions();
		
		assertEquals(NUMPERMS,possiblePerms.length);
		
		
	}

}
