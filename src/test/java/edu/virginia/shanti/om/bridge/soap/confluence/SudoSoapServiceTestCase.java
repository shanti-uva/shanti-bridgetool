/**
 * SudoSoapServiceTestCase.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package edu.virginia.shanti.om.bridge.soap.confluence;

import java.rmi.RemoteException;

public class SudoSoapServiceTestCase extends junit.framework.TestCase {
    private String session;

	public SudoSoapServiceTestCase(java.lang.String name) {
        super(name);
    }
    
    public void setUp() {
        edu.virginia.shanti.om.bridge.soap.confluence.ConfluenceserviceV1SoapBindingStub binding;
        try {
            binding = (edu.virginia.shanti.om.bridge.soap.confluence.ConfluenceserviceV1SoapBindingStub)
                          new edu.virginia.shanti.om.bridge.soap.confluence.ConfluenceSoapServiceServiceLocator().getConfluenceserviceV1();
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
            value = binding.login("admin", "XXXXXX");
            this.session = value;
        }
        catch (edu.virginia.shanti.om.bridge.soap.confluence.AuthenticationFailedException e1) {
            throw new junit.framework.AssertionFailedError("AuthenticationFailedException Exception caught: " + e1);
        }
        catch (edu.virginia.shanti.om.bridge.soap.confluence.RemoteException e2) {
            throw new junit.framework.AssertionFailedError("RemoteException Exception caught: " + e2);
        } catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }
    

    public void testsudoWSDL() throws Exception {
        javax.xml.rpc.ServiceFactory serviceFactory = javax.xml.rpc.ServiceFactory.newInstance();
        java.net.URL url = new java.net.URL(new edu.virginia.shanti.om.bridge.soap.confluence.SudoSoapServiceLocator().getsudoAddress() + "?WSDL");
        javax.xml.rpc.Service service = serviceFactory.createService(url, new edu.virginia.shanti.om.bridge.soap.confluence.SudoSoapServiceLocator().getServiceName());
        assertTrue(service != null);
    }

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
            value = binding.canUseConfluence(session, "ys2n");
            assertTrue(value);
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
            binding.sudo(session, "ys2n", "ys2n");
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
        value = binding.whoami(session);
        // TBD - validate results
        
        System.err.println(value);
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
            value = binding.login("admin", "XXXXX");
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

}
