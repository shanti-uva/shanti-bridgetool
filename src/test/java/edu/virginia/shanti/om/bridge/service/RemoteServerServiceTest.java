package edu.virginia.shanti.om.bridge.service;

import static org.hamcrest.Matchers.*;
import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import edu.virginia.shanti.om.bridge.domain.RemoteServer;
import edu.virginia.shanti.om.bridge.form.RemoteContextChoice;
import edu.virginia.shanti.om.bridge.remote.RemoteConnector;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "/META-INF/spring/applicationContext*.xml" })
public class RemoteServerServiceTest {
	
	@Autowired
	private ApplicationContext applicationContext;

    private static final String CONFIG_NAME = "MockConfluence";
	private static final String CONFIG_IMPLEMENTATION = "mockConfluenceConnector";
	private static final String CONFIG_INSTANCE = "https://wiki-test.shanti.virginia.edu";
	private RemoteServerService remoteServerService = new RemoteServerService();

	@Test
	public void checkApplicationContextForConnectorImplementation() {
		Object bean = applicationContext.getBean(CONFIG_IMPLEMENTATION);
		assertNotNull(bean);
		assertTrue(bean instanceof RemoteConnector);
		
		String[] beans = applicationContext.getBeanDefinitionNames();
		
		for (String bean2 : beans) {
			System.err.println(bean2);
		}
		
		
	}
	
	
	@Test
	public void addRemoteServer() {
		remoteServerService.addRemoteServer(CONFIG_NAME,CONFIG_IMPLEMENTATION ,CONFIG_INSTANCE);		
		RemoteServer server = remoteServerService.getRemoteServer(CONFIG_NAME);
		
		assertThat(server.getImplementationName(), is(equalTo(CONFIG_IMPLEMENTATION)));
		
	}
	
	
	
    @Test
    public void getRemoteConfiguration() {
    	RemoteServer configuration = remoteServerService.getRemoteServer(CONFIG_NAME);
		assertThat(configuration.getImplementationName(), is(equalTo(CONFIG_IMPLEMENTATION)));    	
    	
    }

    @Test
    public void getRemoteContexts() {
        
        RemoteServer remoteConfiguration = remoteServerService.getRemoteServer(CONFIG_NAME);
        assertNotNull(remoteConfiguration);
        List<RemoteContextChoice> remoteContexts = remoteServerService.getRemoteContexts(remoteConfiguration);
        assertNotNull(remoteContexts);
        assertTrue(remoteContexts.size() > 0);
        
    }
    
    @Test
    public void getRemoteContextsByConfigName() {
        List<RemoteContextChoice> remoteContexts = remoteServerService.getRemoteContexts(CONFIG_NAME);
        assertNotNull(remoteContexts);
        assertTrue(remoteContexts.size() > 0);
    }
    
    @Test
    public void getAllRemoteServers() {
		remoteServerService.addRemoteServer(CONFIG_NAME+"2",CONFIG_IMPLEMENTATION ,CONFIG_INSTANCE + "2");		
    	List<RemoteServer> allRemoteServers = remoteServerService.getAllRemoteServers(); 
    	assertNotNull(allRemoteServers);
    	
    	System.err.println("Size of list = " + allRemoteServers.size());
    	assertTrue("list of servers is empty!",allRemoteServers.size() > 0);
    	
    }
    

}
