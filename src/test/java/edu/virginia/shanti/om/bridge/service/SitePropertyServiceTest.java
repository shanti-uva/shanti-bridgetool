package edu.virginia.shanti.om.bridge.service;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.RemoteException;

import javax.xml.rpc.ServiceException;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import edu.virginia.shanti.om.bridge.soap.sakai.SakaiLoginServiceLocator;
import edu.virginia.shanti.om.bridge.soap.sakai.SakaiLogin_PortType;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/META-INF/spring/applicationContext*.xml" })
public class SitePropertyServiceTest {

	private static final String PROPERTY_VALUE = "bloopy";

	private static final String PROPERTY_NAME = "blabbytest";

	private static final String USER = "~ys2n";

	@Value("${test.user}")
	private String MOCKUSER;

	@Value("${test.pass}")
	private String MOCKPASSWORD;

	private static final String SERVERID = "sakai11";

	@Autowired
	private SitePropertyService sps;

	@Before
	public void setUp() throws RemoteException, ServiceException,
			MalformedURLException {

		SakaiLogin_PortType sakaiLogin = new SakaiLoginServiceLocator()
				.getSakaiLogin(new URL("https://" + "sakai11"
						+ ".itc.virginia.edu/sakai-axis/SakaiLogin.jws"));

		System.err.println("MOCKUSER = " + MOCKUSER);
		
		Assert.assertNotNull("Didn't get a MOCKUSER!", MOCKUSER);
		
		String session = sakaiLogin.login(MOCKUSER, MOCKPASSWORD) + "."
				+ SERVERID;

		SecurityContextHolder.getContext().setAuthentication(
				new UsernamePasswordAuthenticationToken(MOCKUSER, session));
		
		
	}

	@Test
	@Transactional
	public void testSetSiteProperty() {
		sps.setSiteProperty(USER, PROPERTY_NAME, PROPERTY_VALUE);
	}

	@Test
	@Transactional
	public void testGetSiteProperty() {
		String value = sps.getSiteProperty(USER, PROPERTY_NAME);
		assertThat(value, equalTo(PROPERTY_VALUE));

	}

}
