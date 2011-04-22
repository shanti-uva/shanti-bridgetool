package edu.virginia.shanti.om.bridge.service;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;

import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.RemoteException;
import java.util.Random;

import javax.xml.rpc.ServiceException;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import edu.virginia.shanti.om.bridge.domain.SiteAlias;
import edu.virginia.shanti.om.bridge.soap.sakai.SakaiLoginServiceLocator;
import edu.virginia.shanti.om.bridge.soap.sakai.SakaiLogin_PortType;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/META-INF/spring/applicationContext*.xml" })
public class SiteAliasServiceTest {

	private static final String TESTUSER = "ys2n";
	@Autowired
	SiteAliasService sas;
	private Random random = new Random(System.currentTimeMillis());
		
	@Before
	public void setUp() throws ServiceException, RemoteException {
		
	}

	@Test
	@Transactional
	public void testGetAliasForSiteId() {
		String siteId = "siteid" + randomTag();
		String alias = "alias" + randomTag();

		String aliasForSiteId = sas.getAliasForSiteId(siteId);
		assertNull(aliasForSiteId);
		
		sas.setAlias(siteId, alias);
		
		aliasForSiteId = sas.getAliasForSiteId(siteId);
		assertNotNull(aliasForSiteId);
		assertThat(aliasForSiteId,equalTo(alias));
		System.err.println("ALIAS: " + aliasForSiteId);
	}

	@Test
	@Transactional
	public void testGetSiteIdForSiteAlias() {
		String alias = "bloopy" + randomTag();
		String siteId = "blargy" + randomTag();
		
		String siteIdForSiteAlias = sas.getSiteIdForSiteAlias(alias);
		assertNull(siteIdForSiteAlias);

		sas.setAlias(siteId, alias);
		
		siteIdForSiteAlias = sas.getSiteIdForSiteAlias(alias);
		
		assertThat(siteIdForSiteAlias,equalTo(siteId));
		
	}

	@Test
	@Transactional
	public void testSetAlias() {
		
		String tag = randomTag();
		
		// precondition
		String siteid = "siteId" + tag;
		String alias = "alias" + tag;		
		
		assertNull(sas.getAliasForSiteId(siteid));
		assertNull(sas.getSiteIdForSiteAlias(alias));
		
		sas.setAlias(siteid, alias);
		
		assertThat(sas.getSiteIdForSiteAlias(alias),equalTo(siteid));
		assertThat(sas.getAliasForSiteId(siteid), equalTo(alias));
	}

	@Test
	@Transactional
	public void testSuggestSiteAliasString() {
		String[] testTitles = {
				"My Test Site",
				"Yuji's Test Site",
				"Test Site No. 2",
				"Wh@t Fre$h H3ll !s Th!s!",
				"Between You & Me",
				"1+1-2=0",
				"who; what; where and when"
		};
		
		for (String title: testTitles) {
			// TODO: What checks should be here?
			String suggestion = sas.suggestSiteAliasString(title, randomTag());
			System.err.println(suggestion);
			// TODO: What checks should be here?
		}
	}

	@Test
	@Transactional
	public void testSuggestSiteAlias() throws RemoteException, ServiceException, MalformedURLException {
		String serverId = "sakai11";
		
		// login and get session
		SakaiLogin_PortType sakaiLogin = new SakaiLoginServiceLocator().getSakaiLogin(new URL("https://"+ serverId + ".itc.virginia.edu/sakai-axis/SakaiLogin.jws"));
		String session = sakaiLogin.login("ys2n","XXXXXX").concat("." + serverId);
		System.err.println(session);
		
		SecurityContextHolder.getContext()
				.setAuthentication(
						new UsernamePasswordAuthenticationToken(TESTUSER,
								session));
	
		
		SiteAlias siteAlias = sas.suggestSiteAlias("23e3d2d3-cad7-4dc5-89c2-666e2b1f1b18");
		System.err.println("THE SITE ALIAS SUGGESTION: " + siteAlias);
	}
	
	
	
	
	
	
	
	
	
	private String randomTag() {
		String tag = Long.toString(Math.abs(random.nextLong()),36).substring(0,8);
		return tag;
	}

}
