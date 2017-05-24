package edu.virginia.shanti.om.bridge.auth;

import static org.junit.Assert.*;

import java.net.URL;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import edu.virginia.shanti.om.bridge.domain.Bridge;
import edu.virginia.shanti.om.bridge.service.CurrentUserImpl;
import edu.virginia.shanti.om.bridge.service.SessionAffinity;
import edu.virginia.shanti.om.bridge.service.SessionAffinityUtility;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/META-INF/spring/applicationContext.xml", "/META-INF/spring/applicationContext-security.xml" })
public class BridgeToolAuthenticationFilterTest {
	
	private static final Object USER = null;
	private static final Object CREDS = null;
	private static final String fakeQuery = 
"user=ys2n&internaluser=ys2n&site=7a4fca0e-a128-4146-9524-25d2ce3480b9&role=Owner&session=90f42761ae3b9ae235649b021cc9ef7d230b26b88afba438694accd68aeab28ec496e55a7d6c0bac&serverurl=https%3A%2F%2Fcollab-dev.its.virginia.edu&time=1495650423605&serverId=service-collab-dev-orange.1.m89p2fo919w28g21yfc9grsoh&siteTitle=0+Day&toolId=shanti.confluenceprod.linktool&placement=cec93d1a-f525-45e4-89ca-f679c8d39ee0&sign=f90f34f2a983181be771273d7f91ee60fb392eb6";		
	private static final String fakeGrant = "Faker@FaketyFake";
	private static final String user = "ys2n";
	private static final String serverUrl = "https://collab-dev.its.virginia.edu";
	private static final String sessionString = "72494456-6a2c-4e17-98ca-2efbf5dd2c52.service-collab-dev-orange.4.y9z68l2y5o9mumjmx5q9tvr1h";
	
	@Autowired
	private BridgeToolPermissionEvaluator btpe;
	
	@Autowired 
	private BridgeToolAuthenticationFilter filter;
	
	@Autowired
	private CurrentUserImpl currentUser;

	@Before
	public void setUp() throws Exception {

		
		
		System.err.println("setUp for a better tomorrow!");

		System.err.println("FILTER: " + filter);
		// filter.authenticateSecurityContextHolder(fakeQuery, fakeGrant);
		
		
	
	     filter.populateSecurityContext(fakeGrant, user, serverUrl, sessionString);	
	     		
	}
	
	@Test
	public void test1_is_SecurityContext_there() {
		
		SecurityContext context = SecurityContextHolder.getContext();
		assertNotNull("context from SecurityContextHolder shouldn't be null",context);
		Authentication authentication = context.getAuthentication();
		assertNotNull("authentication from context shouldn't be null", authentication);
		Collection<GrantedAuthority> authorities = authentication.getAuthorities();
		
		
		System.err.println("GURLFE");
		for (GrantedAuthority grant: authorities) {
			System.err.println("HOHOHOHOHOHOHOHOHOH: " + grant);
		}
		
	}
	
	@Test
	public void injected() {
		
		assertNotNull("BridgeToolPermissionEvaluator was not injected",btpe);
		
	}
	
	

	@Test
	public void testHasPermissionAuthenticationObjectObject() {
		
		Bridge bridge = new Bridge();
		bridge.setLocalContext("yeahyeahyeah");
		bridge.setCurrentUser(currentUser);
		bridge.setBridgeToolPermissionEvaluator(btpe);

		assertTrue(btpe.hasPermission(currentUser.getAuthentication(), bridge, "admin"));
	}
	
	@Test
	public void testBridgeIsAdmin() {
		
		Bridge bridge = new Bridge();
		bridge.setLocalContext("blahblahblah");
		bridge.setCurrentUser(currentUser);
		assertFalse(bridge.isAdmin());
		
		bridge.setLocalContext("whoawhoawhoa");
		assertTrue(bridge.isAdmin());
		
	}

	@Test
	public void testHasPermissionAuthenticationSerializableStringObject() {
		fail("Not yet implemented");
	}

	
    @Test
    public void test17SakaiScriptGetSiteProperty() throws Exception {
        edu.virginia.shanti.om.bridge.soap.sakai.SakaiScriptSoapBindingStub binding;
        try {
            binding = (edu.virginia.shanti.om.bridge.soap.sakai.SakaiScriptSoapBindingStub)
                          new edu.virginia.shanti.om.bridge.soap.sakai.SakaiScriptServiceLocator().getSakaiScript();
        }
        catch (javax.xml.rpc.ServiceException jre) {
            if(jre.getLinkedCause()!=null)
                jre.getLinkedCause().printStackTrace();
            throw new junit.framework.AssertionFailedError("JAX-RPC ServiceException caught: " + jre);
        }
        assertNotNull("binding is null", binding);
        
        
        SessionAffinity aff = SessionAffinityUtility.constructSessionAffinity(currentUser);
        SessionAffinityUtility.setConnectionAffinity(aff, binding);

        // Time out after a minute
        binding.setTimeout(60000);

        // Test operation
        java.lang.String value = null;
        value = binding.getSiteProperty(new java.lang.String(), new java.lang.String(), new java.lang.String());
        // TBD - validate results
    }
    
    @Test
    public void test19SakaiScriptCheckSession() throws Exception {
        edu.virginia.shanti.om.bridge.soap.sakai.SakaiScriptSoapBindingStub binding;
        try {
            binding = (edu.virginia.shanti.om.bridge.soap.sakai.SakaiScriptSoapBindingStub)
                          new edu.virginia.shanti.om.bridge.soap.sakai.SakaiScriptServiceLocator().getSakaiScript();
        }
        catch (javax.xml.rpc.ServiceException jre) {
            if(jre.getLinkedCause()!=null)
                jre.getLinkedCause().printStackTrace();
            throw new junit.framework.AssertionFailedError("JAX-RPC ServiceException caught: " + jre);
        }
        assertNotNull("binding is null", binding);
        
        SessionAffinity aff = SessionAffinityUtility.constructSessionAffinity(currentUser);
        SessionAffinityUtility.setConnectionAffinity(aff, binding);

        // Time out after a minute
        binding.setTimeout(60000);

        // Test operation
        java.lang.String value = null;
        value = binding.checkSession(new java.lang.String());
        // TBD - validate results
    }
    
    @Test
    public void test55SakaiScriptSetSitePropertyAlt() throws Exception {
        edu.virginia.shanti.om.bridge.soap.sakai.SakaiScriptSoapBindingStub binding;
        try {
            binding = (edu.virginia.shanti.om.bridge.soap.sakai.SakaiScriptSoapBindingStub)
                          new edu.virginia.shanti.om.bridge.soap.sakai.SakaiScriptServiceLocator().getSakaiScript(new URL("https://collab-dev.its.virginia.edu/sakai-ws/soap/sakai"));
        }
        catch (javax.xml.rpc.ServiceException jre) {
            if(jre.getLinkedCause()!=null)
                jre.getLinkedCause().printStackTrace();
            throw new junit.framework.AssertionFailedError("JAX-RPC ServiceException caught: " + jre);
        }
        assertNotNull("binding is null", binding);

        SessionAffinity aff = SessionAffinityUtility.constructSessionAffinity(currentUser);
        SessionAffinityUtility.setConnectionAffinity(aff, binding);
        
        // Time out after a minute
        binding.setTimeout(60000);

        Collection<GrantedAuthority> grants = SecurityContextHolder.getContext().getAuthentication().getAuthorities();
  
        String info = null;
        for (GrantedAuthority grant: grants) {
        		System.err.println("Grant: " + grant.getAuthority());
        		if (grant.getAuthority().startsWith("sakaisession#")) {
        			
        			info = grant.getAuthority();
        			
        		}
        	
        	
        }
        // Test operation
        
        String[] parts = info.split("#");
        System.err.println(Arrays.toString(parts));
        
        java.lang.String value = null;
        String userSession=parts[1].split("\\.")[0];
        String host = parts[2];
		String adminSecret="6gM3hC5QYeGgSqvvdEVPFPafbJy5ahcD";
		String siteId="7a4fca0e-a128-4146-9524-25d2ce3480b9";
		String propertyName="scripttest-"+RandomStringUtils.randomAlphanumeric(3);
		String propertyValue=RandomStringUtils.randomAlphanumeric(10);

		String paramDebug = "session = " + userSession
				+ " adminSecret = (" + adminSecret.length() + " chars) "
				+ " siteId = " + siteId
				+ " propertyname = " + propertyName;
		System.err.println(paramDebug);
		value = binding.setSitePropertyAlt(userSession, adminSecret, siteId, propertyName, propertyValue);
     
		System.out.println("return from SitePropertyAlt():" + value);
		value = binding.getSiteProperty(userSession, siteId, propertyName);
		System.out.println("return from getSiteProperty:" + value);
				assertEquals(" Not expected  return value!",propertyValue,value);
				binding.setSitePropertyAlt(userSession, adminSecret, siteId, propertyName, null);
//				value = binding.getSiteProperty(userSession, siteId, propertyName);
//				assertNull("property is not null!",value);


    }

	
}
