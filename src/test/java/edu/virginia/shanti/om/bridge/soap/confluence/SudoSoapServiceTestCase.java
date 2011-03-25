/**
 * SudoSoapServiceTestCase.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package edu.virginia.shanti.om.bridge.soap.confluence;

public class SudoSoapServiceTestCase extends junit.framework.TestCase {
    public SudoSoapServiceTestCase(java.lang.String name) {
        super(name);
    }

    public void testsudoWSDL() throws Exception {
        javax.xml.rpc.ServiceFactory serviceFactory = javax.xml.rpc.ServiceFactory.newInstance();
        java.net.URL url = new java.net.URL(new edu.virginia.shanti.om.bridge.soap.confluence.SudoSoapServiceLocator().getsudoAddress() + "?WSDL");
        javax.xml.rpc.Service service = serviceFactory.createService(url, new edu.virginia.shanti.om.bridge.soap.confluence.SudoSoapServiceLocator().getServiceName());
        assertTrue(service != null);
    }
    
    /*

    public void test1sudoCanUseConfluence() throws Exception {
        edu.virginia.shanti.om.bridge.soap.confluence.SudoSoapBindingStub binding;
        try {
            binding = (edu.virginia.shanti.om.bridge.soap.confluence.SudoSoapBindingStub)
                          new edu.virginia.shanti.om.bridge.soap.confluence.SudoSoapServiceLocator().getsudo();
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
        try {
            boolean value = false;
            value = binding.canUseConfluence(new java.lang.String(), new java.lang.String());
        }
        catch (edu.virginia.shanti.om.bridge.soap.confluence.EntityException e1) {
            throw new junit.framework.AssertionFailedError("EntityException Exception caught: " + e1);
        }
            // TBD - validate results
    }

    public void test2sudoSudo() throws Exception {
        edu.virginia.shanti.om.bridge.soap.confluence.SudoSoapBindingStub binding;
        try {
            binding = (edu.virginia.shanti.om.bridge.soap.confluence.SudoSoapBindingStub)
                          new edu.virginia.shanti.om.bridge.soap.confluence.SudoSoapServiceLocator().getsudo();
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
        try {
            binding.sudo(new java.lang.String(), new java.lang.String(), new java.lang.String());
        }
        catch (edu.virginia.shanti.om.bridge.soap.confluence.EntityException e1) {
            throw new junit.framework.AssertionFailedError("EntityException Exception caught: " + e1);
        }
            // TBD - validate results
    }

    public void test3sudoWhoami() throws Exception {
        edu.virginia.shanti.om.bridge.soap.confluence.SudoSoapBindingStub binding;
        try {
            binding = (edu.virginia.shanti.om.bridge.soap.confluence.SudoSoapBindingStub)
                          new edu.virginia.shanti.om.bridge.soap.confluence.SudoSoapServiceLocator().getsudo();
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
        value = binding.whoami(new java.lang.String());
        // TBD - validate results
    }

    public void test4sudoLogin() throws Exception {
        edu.virginia.shanti.om.bridge.soap.confluence.SudoSoapBindingStub binding;
        try {
            binding = (edu.virginia.shanti.om.bridge.soap.confluence.SudoSoapBindingStub)
                          new edu.virginia.shanti.om.bridge.soap.confluence.SudoSoapServiceLocator().getsudo();
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
        try {
            java.lang.String value = null;
            value = binding.login(new java.lang.String(), new java.lang.String());
        }
        catch (edu.virginia.shanti.om.bridge.soap.confluence.AuthenticationFailedException e1) {
            throw new junit.framework.AssertionFailedError("AuthenticationFailedException Exception caught: " + e1);
        }
        catch (edu.virginia.shanti.om.bridge.soap.confluence.RemoteException e2) {
            throw new junit.framework.AssertionFailedError("RemoteException Exception caught: " + e2);
        }
            // TBD - validate results
    }

    public void test5sudoLogout() throws Exception {
        edu.virginia.shanti.om.bridge.soap.confluence.SudoSoapBindingStub binding;
        try {
            binding = (edu.virginia.shanti.om.bridge.soap.confluence.SudoSoapBindingStub)
                          new edu.virginia.shanti.om.bridge.soap.confluence.SudoSoapServiceLocator().getsudo();
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
        try {
            boolean value = false;
            value = binding.logout(new java.lang.String());
        }
        catch (edu.virginia.shanti.om.bridge.soap.confluence.RemoteException e1) {
            throw new junit.framework.AssertionFailedError("RemoteException Exception caught: " + e1);
        }
            // TBD - validate results
    }
	*/
}
