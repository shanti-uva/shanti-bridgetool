package edu.virginia.shanti.om.bridge.soap.confluence;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;

import java.rmi.RemoteException;
import java.util.Arrays;
import java.util.HashMap;

import javax.xml.rpc.ServiceException;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/META-INF/spring/applicationContext*.xml" })
public class ConfluenceSoapServiceIntegrationTest {

	private ConfluenceSoapServiceServiceLocator locator;
	private String server = "https://wiki-test.shanti.virginia.edu";
	private ConfluenceSoapService confluence;
	private String session;
	private SudoSoapServiceLocator sudolocator;
	private SudoSoap sudo;
	
	@Value(value="${adminUser}")
	private String adminUser;
	
	@Value(value="${adminPassword}")
	private String adminPassword;

	@Before
	public void setUp() throws Exception {
		sudolocator = new SudoSoapServiceLocator();
		sudolocator.setsudoEndpointAddress(server + "/rpc/soap-axis/sudo");

		locator = new ConfluenceSoapServiceServiceLocator();
		locator.setConfluenceserviceV1EndpointAddress(server
				+ "/rpc/soap-axis/confluenceservice-v1");

		confluence = (ConfluenceSoapService) locator.getConfluenceserviceV1();
		((ConfluenceserviceV1SoapBindingStub) confluence).setTimeout(60000);

		sudo = sudolocator.getsudo();
		((SudoSoapBindingStub) sudo).setTimeout(60000);

		
		
		if (adminUser != null && adminPassword != null) {
			System.err.println("adminUser = " + adminUser + " adminPassword is " + adminPassword.length() + " chars long");
		session = confluence.login(adminUser, adminPassword);
		assertNotNull(session);
		} else {
			throw new RuntimeException("admin user and password not set!");
		}
		
		
		
	}

	@Test
	public void connectToTest() throws AuthenticationFailedException,
			RemoteException, RemoteException, ServiceException {

		RemoteServerInfo serverInfo = confluence.getServerInfo(session);
		assertEquals(server, serverInfo.getBaseUrl());
		System.err.println(serverInfo.getBaseUrl());
		RemoteUserInformation user = confluence.getUserInformation(session,
				"admin");
		System.err.println(user);
		assertEquals("admin", user.getUsername());
		assertEquals("admin", sudo.whoami(session));
	}

	@Test
	public void sudoToUser() throws EntityException, RemoteException {

		sudo.sudo(session, session, "tms");

		assertEquals("tms", sudo.whoami(session));

	}

	@Test
	public void getPages() throws InvalidSessionException,
			edu.virginia.shanti.om.bridge.soap.confluence.RemoteException,
			RemoteException {
		RemotePageSummary[] pages = confluence.getPages(session, "OM");

		HashMap<String, String> params = new HashMap<String, String>();
		// params.put("style", "clean");

		for (RemotePageSummary remotePageSummary : pages) {
			long id = remotePageSummary.getId();

			System.err.println("============");
			System.err.println(confluence.renderContent(session, "OM", id,
					"{recently-updated:spaces=OM|theme=concise}", params));
			System.err.println("============");

		}
		
	}

	
	@Test
	public void getGroups() throws NotPermittedException, edu.virginia.shanti.om.bridge.soap.confluence.RemoteException, RemoteException{
		String[] groups = confluence.getGroups(session);
		
		for (int i = 0; i < groups.length; i++) {
			String string = groups[i];
			
			if (string.startsWith("roster-")) {
				System.err.println(string);
				confluence.removeGroup(session,	string, null);
			}
			
		}	
	}
	
	@Test
	public void addRemoveGroup() throws InvalidSessionException, NotPermittedException, edu.virginia.shanti.om.bridge.soap.confluence.RemoteException, RemoteException {
		String testGroup = "yuji_test_group";
		
		confluence.addGroup(session, testGroup);
		
		String[] groups = confluence.getGroups(session);
		
		assertThat(Arrays.asList(groups), hasItem(testGroup));
		
		confluence.removeGroup(session,testGroup, null);
		
		groups = confluence.getGroups(session);

		assertThat(Arrays.asList(groups), not(hasItem(testGroup)));
		
	}
	
	@Test
	public void getSpacesWithPermissions() throws EntityException,
			RemoteException {

		sudo.sudo(session, session, "ybf2u");

		RemoteSpaceSummary[] spaces = confluence.getSpaces(session);

		for (int i = 0; i < spaces.length; i++) {
			RemoteSpaceSummary remoteSpaceSummary = spaces[i];
			System.err.println(remoteSpaceSummary.getName());

			String key = remoteSpaceSummary.getKey();

			String[] permissions = confluence.getPermissions(session, key);

			for (int j = 0; j < permissions.length; j++) {
				String perm = permissions[j];
				System.err.println("\t" + perm);
			}
		}

	}
	
	
}


