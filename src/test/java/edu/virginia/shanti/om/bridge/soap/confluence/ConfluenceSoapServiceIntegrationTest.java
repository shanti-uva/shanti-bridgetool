package edu.virginia.shanti.om.bridge.soap.confluence;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.rmi.RemoteException;
import java.util.HashMap;

import javax.xml.rpc.ServiceException;

import org.junit.Before;
import org.junit.Test;

public class ConfluenceSoapServiceIntegrationTest {

	private ConfluenceSoapServiceServiceLocator locator;
	private String server = "https://wiki-test.shanti.virginia.edu";
	private ConfluenceSoapService confluence;
	private String session;
	private SudoSoapServiceLocator sudolocator;
	private SudoSoap sudo;

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

		session = confluence.login("admin", "XXXXXX");
		assertNotNull(session);
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
	public void getSpacesWithPermissions() throws EntityException,
			RemoteException {

		sudo.sudo(session, session, "ybf2u");

		RemoteSpaceSummary[] spaces = confluence.getSpaces(session);

		for (int i = 0; i < spaces.length; i++) {
			RemoteSpaceSummary remoteSpaceSummary = spaces[i];
			System.err.println(remoteSpaceSummary);

			String key = remoteSpaceSummary.getKey();

			String[] permissions = confluence.getPermissions(session, key);

			for (int j = 0; j < permissions.length; j++) {
				String perm = permissions[j];
				System.err.println("\t" + perm);
			}
		}

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

}
