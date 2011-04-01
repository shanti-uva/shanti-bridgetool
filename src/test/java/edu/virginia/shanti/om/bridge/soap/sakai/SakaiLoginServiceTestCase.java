/**
 * SakaiLoginServiceTestCase.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package edu.virginia.shanti.om.bridge.soap.sakai;

public class SakaiLoginServiceTestCase extends junit.framework.TestCase {
    public SakaiLoginServiceTestCase(java.lang.String name) {
        super(name);
    }

    public void testSakaiLoginWSDL() throws Exception {
        javax.xml.rpc.ServiceFactory serviceFactory = javax.xml.rpc.ServiceFactory.newInstance();
        java.net.URL url = new java.net.URL(new edu.virginia.shanti.om.bridge.soap.sakai.SakaiLoginServiceLocator().getSakaiLoginAddress() + "?WSDL");
        javax.xml.rpc.Service service = serviceFactory.createService(url, new edu.virginia.shanti.om.bridge.soap.sakai.SakaiLoginServiceLocator().getServiceName());
        assertTrue(service != null);
    }

    public void test1SakaiLoginLogin() throws Exception {
        edu.virginia.shanti.om.bridge.soap.sakai.SakaiLoginSoapBindingStub binding;
        try {
            binding = (edu.virginia.shanti.om.bridge.soap.sakai.SakaiLoginSoapBindingStub)
                          new edu.virginia.shanti.om.bridge.soap.sakai.SakaiLoginServiceLocator().getSakaiLogin();
        }
        catch (javax.xml.rpc.ServiceException jre) {
            if(jre.getLinkedCause()!=null)
                jre.getLinkedCause().printStackTrace();
            throw new junit.framework.AssertionFailedError("JAX-RPC ServiceException caught: " + jre);
        }
        assertNotNull("binding is null", binding);

        // Time out after a minute
        binding.setTimeout(60000);

        // Test operation
        java.lang.String value = null;
        value = binding.login(new java.lang.String(), new java.lang.String());
        // TBD - validate results
    }

    public void test2SakaiLoginLogout() throws Exception {
        edu.virginia.shanti.om.bridge.soap.sakai.SakaiLoginSoapBindingStub binding;
        try {
            binding = (edu.virginia.shanti.om.bridge.soap.sakai.SakaiLoginSoapBindingStub)
                          new edu.virginia.shanti.om.bridge.soap.sakai.SakaiLoginServiceLocator().getSakaiLogin();
        }
        catch (javax.xml.rpc.ServiceException jre) {
            if(jre.getLinkedCause()!=null)
                jre.getLinkedCause().printStackTrace();
            throw new junit.framework.AssertionFailedError("JAX-RPC ServiceException caught: " + jre);
        }
        assertNotNull("binding is null", binding);

        // Time out after a minute
        binding.setTimeout(60000);

        // Test operation
        boolean value = false;
        value = binding.logout(new java.lang.String());
        // TBD - validate results
    }

    public void test3SakaiLoginLoginToServer() throws Exception {
        edu.virginia.shanti.om.bridge.soap.sakai.SakaiLoginSoapBindingStub binding;
        try {
            binding = (edu.virginia.shanti.om.bridge.soap.sakai.SakaiLoginSoapBindingStub)
                          new edu.virginia.shanti.om.bridge.soap.sakai.SakaiLoginServiceLocator().getSakaiLogin();
        }
        catch (javax.xml.rpc.ServiceException jre) {
            if(jre.getLinkedCause()!=null)
                jre.getLinkedCause().printStackTrace();
            throw new junit.framework.AssertionFailedError("JAX-RPC ServiceException caught: " + jre);
        }
        assertNotNull("binding is null", binding);

        // Time out after a minute
        binding.setTimeout(60000);

        // Test operation
        java.lang.String value = null;
        value = binding.loginToServer(new java.lang.String(), new java.lang.String());
        // TBD - validate results
    }

}
