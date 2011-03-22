/**
 * ConfluenceSoapServiceServiceTestCase.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package edu.virginia.shanti.om.bridge.soap.confluence;

public class ConfluenceSoapServiceServiceTestCase extends junit.framework.TestCase {
    public ConfluenceSoapServiceServiceTestCase(java.lang.String name) {
        super(name);
    }

    public void testConfluenceserviceV1WSDL() throws Exception {
        javax.xml.rpc.ServiceFactory serviceFactory = javax.xml.rpc.ServiceFactory.newInstance();
        java.net.URL url = new java.net.URL(new edu.virginia.shanti.om.bridge.soap.confluence.ConfluenceSoapServiceServiceLocator().getConfluenceserviceV1Address() + "?WSDL");
        javax.xml.rpc.Service service = serviceFactory.createService(url, new edu.virginia.shanti.om.bridge.soap.confluence.ConfluenceSoapServiceServiceLocator().getServiceName());
        assertTrue(service != null);
    }

    public void test1ConfluenceserviceV1GetPermissions() throws Exception {
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
            java.lang.String[] value = null;
            value = binding.getPermissions(new java.lang.String(), new java.lang.String());
        }
        catch (edu.virginia.shanti.om.bridge.soap.confluence.InvalidSessionException e1) {
            throw new junit.framework.AssertionFailedError("InvalidSessionException Exception caught: " + e1);
        }
        catch (edu.virginia.shanti.om.bridge.soap.confluence.RemoteException e2) {
            throw new junit.framework.AssertionFailedError("RemoteException Exception caught: " + e2);
        }
            // TBD - validate results
    }

    public void test2ConfluenceserviceV1Search() throws Exception {
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
            edu.virginia.shanti.om.bridge.soap.confluence.RemoteSearchResult[] value = null;
            value = binding.search(new java.lang.String(), new java.lang.String(), 0);
        }
        catch (edu.virginia.shanti.om.bridge.soap.confluence.InvalidSessionException e1) {
            throw new junit.framework.AssertionFailedError("InvalidSessionException Exception caught: " + e1);
        }
        catch (edu.virginia.shanti.om.bridge.soap.confluence.RemoteException e2) {
            throw new junit.framework.AssertionFailedError("RemoteException Exception caught: " + e2);
        }
            // TBD - validate results
    }

    public void test3ConfluenceserviceV1Search() throws Exception {
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
            edu.virginia.shanti.om.bridge.soap.confluence.RemoteSearchResult[] value = null;
            value = binding.search(new java.lang.String(), new java.lang.String(), new java.util.HashMap(), 0);
        }
        catch (edu.virginia.shanti.om.bridge.soap.confluence.RemoteException e1) {
            throw new junit.framework.AssertionFailedError("RemoteException Exception caught: " + e1);
        }
            // TBD - validate results
    }

    public void test4ConfluenceserviceV1GetSpace() throws Exception {
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
            edu.virginia.shanti.om.bridge.soap.confluence.RemoteSpace value = null;
            value = binding.getSpace(new java.lang.String(), new java.lang.String());
        }
        catch (edu.virginia.shanti.om.bridge.soap.confluence.InvalidSessionException e1) {
            throw new junit.framework.AssertionFailedError("InvalidSessionException Exception caught: " + e1);
        }
        catch (edu.virginia.shanti.om.bridge.soap.confluence.RemoteException e2) {
            throw new junit.framework.AssertionFailedError("RemoteException Exception caught: " + e2);
        }
            // TBD - validate results
    }

    public void test5ConfluenceserviceV1GetComment() throws Exception {
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
            edu.virginia.shanti.om.bridge.soap.confluence.RemoteComment value = null;
            value = binding.getComment(new java.lang.String(), 0);
        }
        catch (edu.virginia.shanti.om.bridge.soap.confluence.InvalidSessionException e1) {
            throw new junit.framework.AssertionFailedError("InvalidSessionException Exception caught: " + e1);
        }
        catch (edu.virginia.shanti.om.bridge.soap.confluence.RemoteException e2) {
            throw new junit.framework.AssertionFailedError("RemoteException Exception caught: " + e2);
        }
            // TBD - validate results
    }

    public void test6ConfluenceserviceV1GetServerInfo() throws Exception {
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
            edu.virginia.shanti.om.bridge.soap.confluence.RemoteServerInfo value = null;
            value = binding.getServerInfo(new java.lang.String());
        }
        catch (edu.virginia.shanti.om.bridge.soap.confluence.InvalidSessionException e1) {
            throw new junit.framework.AssertionFailedError("InvalidSessionException Exception caught: " + e1);
        }
        catch (edu.virginia.shanti.om.bridge.soap.confluence.RemoteException e2) {
            throw new junit.framework.AssertionFailedError("RemoteException Exception caught: " + e2);
        }
            // TBD - validate results
    }

    public void test7ConfluenceserviceV1GetGroups() throws Exception {
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
            java.lang.String[] value = null;
            value = binding.getGroups(new java.lang.String());
        }
        catch (edu.virginia.shanti.om.bridge.soap.confluence.NotPermittedException e1) {
            throw new junit.framework.AssertionFailedError("NotPermittedException Exception caught: " + e1);
        }
        catch (edu.virginia.shanti.om.bridge.soap.confluence.RemoteException e2) {
            throw new junit.framework.AssertionFailedError("RemoteException Exception caught: " + e2);
        }
            // TBD - validate results
    }

    public void test8ConfluenceserviceV1GetChildren() throws Exception {
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
            edu.virginia.shanti.om.bridge.soap.confluence.RemotePageSummary[] value = null;
            value = binding.getChildren(new java.lang.String(), 0);
        }
        catch (edu.virginia.shanti.om.bridge.soap.confluence.InvalidSessionException e1) {
            throw new junit.framework.AssertionFailedError("InvalidSessionException Exception caught: " + e1);
        }
        catch (edu.virginia.shanti.om.bridge.soap.confluence.RemoteException e2) {
            throw new junit.framework.AssertionFailedError("RemoteException Exception caught: " + e2);
        }
            // TBD - validate results
    }

    public void test9ConfluenceserviceV1RemoveGroup() throws Exception {
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
            boolean value = false;
            value = binding.removeGroup(new java.lang.String(), new java.lang.String(), new java.lang.String());
        }
        catch (edu.virginia.shanti.om.bridge.soap.confluence.InvalidSessionException e1) {
            throw new junit.framework.AssertionFailedError("InvalidSessionException Exception caught: " + e1);
        }
        catch (edu.virginia.shanti.om.bridge.soap.confluence.NotPermittedException e2) {
            throw new junit.framework.AssertionFailedError("NotPermittedException Exception caught: " + e2);
        }
        catch (edu.virginia.shanti.om.bridge.soap.confluence.RemoteException e3) {
            throw new junit.framework.AssertionFailedError("RemoteException Exception caught: " + e3);
        }
            // TBD - validate results
    }

    public void test10ConfluenceserviceV1RemoveUser() throws Exception {
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
            boolean value = false;
            value = binding.removeUser(new java.lang.String(), new java.lang.String());
        }
        catch (edu.virginia.shanti.om.bridge.soap.confluence.InvalidSessionException e1) {
            throw new junit.framework.AssertionFailedError("InvalidSessionException Exception caught: " + e1);
        }
        catch (edu.virginia.shanti.om.bridge.soap.confluence.NotPermittedException e2) {
            throw new junit.framework.AssertionFailedError("NotPermittedException Exception caught: " + e2);
        }
        catch (edu.virginia.shanti.om.bridge.soap.confluence.RemoteException e3) {
            throw new junit.framework.AssertionFailedError("RemoteException Exception caught: " + e3);
        }
            // TBD - validate results
    }

    public void test11ConfluenceserviceV1AddGroup() throws Exception {
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
            boolean value = false;
            value = binding.addGroup(new java.lang.String(), new java.lang.String());
        }
        catch (edu.virginia.shanti.om.bridge.soap.confluence.InvalidSessionException e1) {
            throw new junit.framework.AssertionFailedError("InvalidSessionException Exception caught: " + e1);
        }
        catch (edu.virginia.shanti.om.bridge.soap.confluence.NotPermittedException e2) {
            throw new junit.framework.AssertionFailedError("NotPermittedException Exception caught: " + e2);
        }
        catch (edu.virginia.shanti.om.bridge.soap.confluence.RemoteException e3) {
            throw new junit.framework.AssertionFailedError("RemoteException Exception caught: " + e3);
        }
            // TBD - validate results
    }

    public void test12ConfluenceserviceV1GetUser() throws Exception {
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
            edu.virginia.shanti.om.bridge.soap.confluence.RemoteUser value = null;
            value = binding.getUser(new java.lang.String(), new java.lang.String());
        }
        catch (edu.virginia.shanti.om.bridge.soap.confluence.InvalidSessionException e1) {
            throw new junit.framework.AssertionFailedError("InvalidSessionException Exception caught: " + e1);
        }
        catch (edu.virginia.shanti.om.bridge.soap.confluence.RemoteException e2) {
            throw new junit.framework.AssertionFailedError("RemoteException Exception caught: " + e2);
        }
            // TBD - validate results
    }

    public void test13ConfluenceserviceV1GetPage() throws Exception {
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
            edu.virginia.shanti.om.bridge.soap.confluence.RemotePage value = null;
            value = binding.getPage(new java.lang.String(), new java.lang.String(), new java.lang.String());
        }
        catch (edu.virginia.shanti.om.bridge.soap.confluence.InvalidSessionException e1) {
            throw new junit.framework.AssertionFailedError("InvalidSessionException Exception caught: " + e1);
        }
        catch (edu.virginia.shanti.om.bridge.soap.confluence.RemoteException e2) {
            throw new junit.framework.AssertionFailedError("RemoteException Exception caught: " + e2);
        }
            // TBD - validate results
    }

    public void test14ConfluenceserviceV1GetPage() throws Exception {
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
            edu.virginia.shanti.om.bridge.soap.confluence.RemotePage value = null;
            value = binding.getPage(new java.lang.String(), 0);
        }
        catch (edu.virginia.shanti.om.bridge.soap.confluence.InvalidSessionException e1) {
            throw new junit.framework.AssertionFailedError("InvalidSessionException Exception caught: " + e1);
        }
        catch (edu.virginia.shanti.om.bridge.soap.confluence.RemoteException e2) {
            throw new junit.framework.AssertionFailedError("RemoteException Exception caught: " + e2);
        }
            // TBD - validate results
    }

    public void test15ConfluenceserviceV1IsPluginEnabled() throws Exception {
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
        boolean value = false;
        value = binding.isPluginEnabled(new java.lang.String(), new java.lang.String());
        // TBD - validate results
    }

    public void test16ConfluenceserviceV1Login() throws Exception {
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

    public void test17ConfluenceserviceV1InstallPlugin() throws Exception {
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
            boolean value = false;
            value = binding.installPlugin(new java.lang.String(), new java.lang.String(), new byte[0]);
        }
        catch (edu.virginia.shanti.om.bridge.soap.confluence.RemoteException e1) {
            throw new junit.framework.AssertionFailedError("RemoteException Exception caught: " + e1);
        }
            // TBD - validate results
    }

    public void test18ConfluenceserviceV1GetClusterInformation() throws Exception {
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
            edu.virginia.shanti.om.bridge.soap.confluence.RemoteClusterInformation value = null;
            value = binding.getClusterInformation(new java.lang.String());
        }
        catch (edu.virginia.shanti.om.bridge.soap.confluence.RemoteException e1) {
            throw new junit.framework.AssertionFailedError("RemoteException Exception caught: " + e1);
        }
            // TBD - validate results
    }

    public void test19ConfluenceserviceV1AddComment() throws Exception {
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
            edu.virginia.shanti.om.bridge.soap.confluence.RemoteComment value = null;
            value = binding.addComment(new java.lang.String(), new edu.virginia.shanti.om.bridge.soap.confluence.RemoteComment());
        }
        catch (edu.virginia.shanti.om.bridge.soap.confluence.InvalidSessionException e1) {
            throw new junit.framework.AssertionFailedError("InvalidSessionException Exception caught: " + e1);
        }
        catch (edu.virginia.shanti.om.bridge.soap.confluence.NotPermittedException e2) {
            throw new junit.framework.AssertionFailedError("NotPermittedException Exception caught: " + e2);
        }
        catch (edu.virginia.shanti.om.bridge.soap.confluence.RemoteException e3) {
            throw new junit.framework.AssertionFailedError("RemoteException Exception caught: " + e3);
        }
            // TBD - validate results
    }

    public void test20ConfluenceserviceV1GetComments() throws Exception {
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
            edu.virginia.shanti.om.bridge.soap.confluence.RemoteComment[] value = null;
            value = binding.getComments(new java.lang.String(), 0);
        }
        catch (edu.virginia.shanti.om.bridge.soap.confluence.InvalidSessionException e1) {
            throw new junit.framework.AssertionFailedError("InvalidSessionException Exception caught: " + e1);
        }
        catch (edu.virginia.shanti.om.bridge.soap.confluence.RemoteException e2) {
            throw new junit.framework.AssertionFailedError("RemoteException Exception caught: " + e2);
        }
            // TBD - validate results
    }

    public void test21ConfluenceserviceV1GetAttachments() throws Exception {
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
            edu.virginia.shanti.om.bridge.soap.confluence.RemoteAttachment[] value = null;
            value = binding.getAttachments(new java.lang.String(), 0);
        }
        catch (edu.virginia.shanti.om.bridge.soap.confluence.InvalidSessionException e1) {
            throw new junit.framework.AssertionFailedError("InvalidSessionException Exception caught: " + e1);
        }
        catch (edu.virginia.shanti.om.bridge.soap.confluence.RemoteException e2) {
            throw new junit.framework.AssertionFailedError("RemoteException Exception caught: " + e2);
        }
            // TBD - validate results
    }

    public void test22ConfluenceserviceV1AddAttachment() throws Exception {
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
            edu.virginia.shanti.om.bridge.soap.confluence.RemoteAttachment value = null;
            value = binding.addAttachment(new java.lang.String(), 0, new edu.virginia.shanti.om.bridge.soap.confluence.RemoteAttachment(), new byte[0]);
        }
        catch (edu.virginia.shanti.om.bridge.soap.confluence.RemoteException e1) {
            throw new junit.framework.AssertionFailedError("RemoteException Exception caught: " + e1);
        }
            // TBD - validate results
    }

    public void test23ConfluenceserviceV1AddAttachment() throws Exception {
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
            edu.virginia.shanti.om.bridge.soap.confluence.RemoteAttachment value = null;
            value = binding.addAttachment(new java.lang.String(), new edu.virginia.shanti.om.bridge.soap.confluence.RemoteAttachment(), new byte[0]);
        }
        catch (edu.virginia.shanti.om.bridge.soap.confluence.RemoteException e1) {
            throw new junit.framework.AssertionFailedError("RemoteException Exception caught: " + e1);
        }
            // TBD - validate results
    }

    public void test24ConfluenceserviceV1RemoveAttachment() throws Exception {
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
            boolean value = false;
            value = binding.removeAttachment(new java.lang.String(), 0, new java.lang.String());
        }
        catch (edu.virginia.shanti.om.bridge.soap.confluence.RemoteException e1) {
            throw new junit.framework.AssertionFailedError("RemoteException Exception caught: " + e1);
        }
            // TBD - validate results
    }

    public void test25ConfluenceserviceV1GetContentPermissionSet() throws Exception {
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
            edu.virginia.shanti.om.bridge.soap.confluence.RemoteContentPermissionSet value = null;
            value = binding.getContentPermissionSet(new java.lang.String(), 0, new java.lang.String());
        }
        catch (edu.virginia.shanti.om.bridge.soap.confluence.InvalidSessionException e1) {
            throw new junit.framework.AssertionFailedError("InvalidSessionException Exception caught: " + e1);
        }
        catch (edu.virginia.shanti.om.bridge.soap.confluence.NotPermittedException e2) {
            throw new junit.framework.AssertionFailedError("NotPermittedException Exception caught: " + e2);
        }
        catch (edu.virginia.shanti.om.bridge.soap.confluence.RemoteException e3) {
            throw new junit.framework.AssertionFailedError("RemoteException Exception caught: " + e3);
        }
            // TBD - validate results
    }

    public void test26ConfluenceserviceV1GetContentPermissionSets() throws Exception {
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
            edu.virginia.shanti.om.bridge.soap.confluence.RemoteContentPermissionSet[] value = null;
            value = binding.getContentPermissionSets(new java.lang.String(), 0);
        }
        catch (edu.virginia.shanti.om.bridge.soap.confluence.InvalidSessionException e1) {
            throw new junit.framework.AssertionFailedError("InvalidSessionException Exception caught: " + e1);
        }
        catch (edu.virginia.shanti.om.bridge.soap.confluence.NotPermittedException e2) {
            throw new junit.framework.AssertionFailedError("NotPermittedException Exception caught: " + e2);
        }
        catch (edu.virginia.shanti.om.bridge.soap.confluence.RemoteException e3) {
            throw new junit.framework.AssertionFailedError("RemoteException Exception caught: " + e3);
        }
            // TBD - validate results
    }

    public void test27ConfluenceserviceV1RemoveComment() throws Exception {
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
            boolean value = false;
            value = binding.removeComment(new java.lang.String(), 0);
        }
        catch (edu.virginia.shanti.om.bridge.soap.confluence.InvalidSessionException e1) {
            throw new junit.framework.AssertionFailedError("InvalidSessionException Exception caught: " + e1);
        }
        catch (edu.virginia.shanti.om.bridge.soap.confluence.NotPermittedException e2) {
            throw new junit.framework.AssertionFailedError("NotPermittedException Exception caught: " + e2);
        }
        catch (edu.virginia.shanti.om.bridge.soap.confluence.RemoteException e3) {
            throw new junit.framework.AssertionFailedError("RemoteException Exception caught: " + e3);
        }
            // TBD - validate results
    }

    public void test28ConfluenceserviceV1GetDescendents() throws Exception {
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
            edu.virginia.shanti.om.bridge.soap.confluence.RemotePageSummary[] value = null;
            value = binding.getDescendents(new java.lang.String(), 0);
        }
        catch (edu.virginia.shanti.om.bridge.soap.confluence.InvalidSessionException e1) {
            throw new junit.framework.AssertionFailedError("InvalidSessionException Exception caught: " + e1);
        }
        catch (edu.virginia.shanti.om.bridge.soap.confluence.RemoteException e2) {
            throw new junit.framework.AssertionFailedError("RemoteException Exception caught: " + e2);
        }
            // TBD - validate results
    }

    public void test29ConfluenceserviceV1GetAncestors() throws Exception {
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
            edu.virginia.shanti.om.bridge.soap.confluence.RemotePageSummary[] value = null;
            value = binding.getAncestors(new java.lang.String(), 0);
        }
        catch (edu.virginia.shanti.om.bridge.soap.confluence.InvalidSessionException e1) {
            throw new junit.framework.AssertionFailedError("InvalidSessionException Exception caught: " + e1);
        }
        catch (edu.virginia.shanti.om.bridge.soap.confluence.RemoteException e2) {
            throw new junit.framework.AssertionFailedError("RemoteException Exception caught: " + e2);
        }
            // TBD - validate results
    }

    public void test30ConfluenceserviceV1Logout() throws Exception {
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
            boolean value = false;
            value = binding.logout(new java.lang.String());
        }
        catch (edu.virginia.shanti.om.bridge.soap.confluence.RemoteException e1) {
            throw new junit.framework.AssertionFailedError("RemoteException Exception caught: " + e1);
        }
            // TBD - validate results
    }

    public void test31ConfluenceserviceV1GetAttachment() throws Exception {
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
            edu.virginia.shanti.om.bridge.soap.confluence.RemoteAttachment value = null;
            value = binding.getAttachment(new java.lang.String(), 0, new java.lang.String(), 0);
        }
        catch (edu.virginia.shanti.om.bridge.soap.confluence.RemoteException e1) {
            throw new junit.framework.AssertionFailedError("RemoteException Exception caught: " + e1);
        }
            // TBD - validate results
    }

    public void test32ConfluenceserviceV1AddUser() throws Exception {
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
            binding.addUser(new java.lang.String(), new edu.virginia.shanti.om.bridge.soap.confluence.RemoteUser(), new java.lang.String());
        }
        catch (edu.virginia.shanti.om.bridge.soap.confluence.InvalidSessionException e1) {
            throw new junit.framework.AssertionFailedError("InvalidSessionException Exception caught: " + e1);
        }
        catch (edu.virginia.shanti.om.bridge.soap.confluence.NotPermittedException e2) {
            throw new junit.framework.AssertionFailedError("NotPermittedException Exception caught: " + e2);
        }
        catch (edu.virginia.shanti.om.bridge.soap.confluence.RemoteException e3) {
            throw new junit.framework.AssertionFailedError("RemoteException Exception caught: " + e3);
        }
            // TBD - validate results
    }

    public void test33ConfluenceserviceV1GetRelatedLabels() throws Exception {
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
            edu.virginia.shanti.om.bridge.soap.confluence.RemoteLabel[] value = null;
            value = binding.getRelatedLabels(new java.lang.String(), new java.lang.String(), 0);
        }
        catch (edu.virginia.shanti.om.bridge.soap.confluence.InvalidSessionException e1) {
            throw new junit.framework.AssertionFailedError("InvalidSessionException Exception caught: " + e1);
        }
        catch (edu.virginia.shanti.om.bridge.soap.confluence.RemoteException e2) {
            throw new junit.framework.AssertionFailedError("RemoteException Exception caught: " + e2);
        }
            // TBD - validate results
    }

    public void test34ConfluenceserviceV1GetSpaces() throws Exception {
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
            edu.virginia.shanti.om.bridge.soap.confluence.RemoteSpaceSummary[] value = null;
            value = binding.getSpaces(new java.lang.String());
        }
        catch (edu.virginia.shanti.om.bridge.soap.confluence.InvalidSessionException e1) {
            throw new junit.framework.AssertionFailedError("InvalidSessionException Exception caught: " + e1);
        }
        catch (edu.virginia.shanti.om.bridge.soap.confluence.RemoteException e2) {
            throw new junit.framework.AssertionFailedError("RemoteException Exception caught: " + e2);
        }
            // TBD - validate results
    }

    public void test35ConfluenceserviceV1GetSpaceGroup() throws Exception {
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
            edu.virginia.shanti.om.bridge.soap.confluence.RemoteSpaceGroup value = null;
            value = binding.getSpaceGroup(new java.lang.String(), new java.lang.String());
        }
        catch (edu.virginia.shanti.om.bridge.soap.confluence.InvalidSessionException e1) {
            throw new junit.framework.AssertionFailedError("InvalidSessionException Exception caught: " + e1);
        }
        catch (edu.virginia.shanti.om.bridge.soap.confluence.AlreadyExistsException e2) {
            throw new junit.framework.AssertionFailedError("AlreadyExistsException Exception caught: " + e2);
        }
        catch (edu.virginia.shanti.om.bridge.soap.confluence.NotPermittedException e3) {
            throw new junit.framework.AssertionFailedError("NotPermittedException Exception caught: " + e3);
        }
        catch (edu.virginia.shanti.om.bridge.soap.confluence.RemoteException e4) {
            throw new junit.framework.AssertionFailedError("RemoteException Exception caught: " + e4);
        }
            // TBD - validate results
    }

    public void test36ConfluenceserviceV1GetSpaceGroups() throws Exception {
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
            edu.virginia.shanti.om.bridge.soap.confluence.RemoteSpaceGroup[] value = null;
            value = binding.getSpaceGroups(new java.lang.String());
        }
        catch (edu.virginia.shanti.om.bridge.soap.confluence.InvalidSessionException e1) {
            throw new junit.framework.AssertionFailedError("InvalidSessionException Exception caught: " + e1);
        }
        catch (edu.virginia.shanti.om.bridge.soap.confluence.RemoteException e2) {
            throw new junit.framework.AssertionFailedError("RemoteException Exception caught: " + e2);
        }
            // TBD - validate results
    }

    public void test37ConfluenceserviceV1RemoveSpace() throws Exception {
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
            boolean value = false;
            value = binding.removeSpace(new java.lang.String(), new java.lang.String());
        }
        catch (edu.virginia.shanti.om.bridge.soap.confluence.InvalidSessionException e1) {
            throw new junit.framework.AssertionFailedError("InvalidSessionException Exception caught: " + e1);
        }
        catch (edu.virginia.shanti.om.bridge.soap.confluence.NotPermittedException e2) {
            throw new junit.framework.AssertionFailedError("NotPermittedException Exception caught: " + e2);
        }
        catch (edu.virginia.shanti.om.bridge.soap.confluence.RemoteException e3) {
            throw new junit.framework.AssertionFailedError("RemoteException Exception caught: " + e3);
        }
            // TBD - validate results
    }

    public void test38ConfluenceserviceV1ConvertToPersonalSpace() throws Exception {
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
            boolean value = false;
            value = binding.convertToPersonalSpace(new java.lang.String(), new java.lang.String(), new java.lang.String(), new java.lang.String(), true);
        }
        catch (edu.virginia.shanti.om.bridge.soap.confluence.RemoteException e1) {
            throw new junit.framework.AssertionFailedError("RemoteException Exception caught: " + e1);
        }
            // TBD - validate results
    }

    public void test39ConfluenceserviceV1GetPages() throws Exception {
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
            edu.virginia.shanti.om.bridge.soap.confluence.RemotePageSummary[] value = null;
            value = binding.getPages(new java.lang.String(), new java.lang.String());
        }
        catch (edu.virginia.shanti.om.bridge.soap.confluence.InvalidSessionException e1) {
            throw new junit.framework.AssertionFailedError("InvalidSessionException Exception caught: " + e1);
        }
        catch (edu.virginia.shanti.om.bridge.soap.confluence.RemoteException e2) {
            throw new junit.framework.AssertionFailedError("RemoteException Exception caught: " + e2);
        }
            // TBD - validate results
    }

    public void test40ConfluenceserviceV1SetContentPermissions() throws Exception {
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
            boolean value = false;
            value = binding.setContentPermissions(new java.lang.String(), 0, new java.lang.String(), new edu.virginia.shanti.om.bridge.soap.confluence.RemoteContentPermission[0]);
        }
        catch (edu.virginia.shanti.om.bridge.soap.confluence.InvalidSessionException e1) {
            throw new junit.framework.AssertionFailedError("InvalidSessionException Exception caught: " + e1);
        }
        catch (edu.virginia.shanti.om.bridge.soap.confluence.NotPermittedException e2) {
            throw new junit.framework.AssertionFailedError("NotPermittedException Exception caught: " + e2);
        }
        catch (edu.virginia.shanti.om.bridge.soap.confluence.RemoteException e3) {
            throw new junit.framework.AssertionFailedError("RemoteException Exception caught: " + e3);
        }
            // TBD - validate results
    }

    public void test41ConfluenceserviceV1MoveAttachment() throws Exception {
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
            boolean value = false;
            value = binding.moveAttachment(new java.lang.String(), 0, new java.lang.String(), 0, new java.lang.String());
        }
        catch (edu.virginia.shanti.om.bridge.soap.confluence.RemoteException e1) {
            throw new junit.framework.AssertionFailedError("RemoteException Exception caught: " + e1);
        }
            // TBD - validate results
    }

    public void test42ConfluenceserviceV1EditComment() throws Exception {
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
            edu.virginia.shanti.om.bridge.soap.confluence.RemoteComment value = null;
            value = binding.editComment(new java.lang.String(), new edu.virginia.shanti.om.bridge.soap.confluence.RemoteComment());
        }
        catch (edu.virginia.shanti.om.bridge.soap.confluence.InvalidSessionException e1) {
            throw new junit.framework.AssertionFailedError("InvalidSessionException Exception caught: " + e1);
        }
        catch (edu.virginia.shanti.om.bridge.soap.confluence.NotPermittedException e2) {
            throw new junit.framework.AssertionFailedError("NotPermittedException Exception caught: " + e2);
        }
        catch (edu.virginia.shanti.om.bridge.soap.confluence.RemoteException e3) {
            throw new junit.framework.AssertionFailedError("RemoteException Exception caught: " + e3);
        }
            // TBD - validate results
    }

    public void test43ConfluenceserviceV1GetTopLevelPages() throws Exception {
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
            edu.virginia.shanti.om.bridge.soap.confluence.RemotePageSummary[] value = null;
            value = binding.getTopLevelPages(new java.lang.String(), new java.lang.String());
        }
        catch (edu.virginia.shanti.om.bridge.soap.confluence.RemoteException e1) {
            throw new junit.framework.AssertionFailedError("RemoteException Exception caught: " + e1);
        }
            // TBD - validate results
    }

    public void test44ConfluenceserviceV1GetAttachmentData() throws Exception {
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
            byte[] value = null;
            value = binding.getAttachmentData(new java.lang.String(), 0, new java.lang.String(), 0);
        }
        catch (edu.virginia.shanti.om.bridge.soap.confluence.RemoteException e1) {
            throw new junit.framework.AssertionFailedError("RemoteException Exception caught: " + e1);
        }
            // TBD - validate results
    }

    public void test45ConfluenceserviceV1DeactivateUser() throws Exception {
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
            boolean value = false;
            value = binding.deactivateUser(new java.lang.String(), new java.lang.String());
        }
        catch (edu.virginia.shanti.om.bridge.soap.confluence.InvalidSessionException e1) {
            throw new junit.framework.AssertionFailedError("InvalidSessionException Exception caught: " + e1);
        }
        catch (edu.virginia.shanti.om.bridge.soap.confluence.NotPermittedException e2) {
            throw new junit.framework.AssertionFailedError("NotPermittedException Exception caught: " + e2);
        }
        catch (edu.virginia.shanti.om.bridge.soap.confluence.RemoteException e3) {
            throw new junit.framework.AssertionFailedError("RemoteException Exception caught: " + e3);
        }
            // TBD - validate results
    }

    public void test46ConfluenceserviceV1ReactivateUser() throws Exception {
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
            boolean value = false;
            value = binding.reactivateUser(new java.lang.String(), new java.lang.String());
        }
        catch (edu.virginia.shanti.om.bridge.soap.confluence.InvalidSessionException e1) {
            throw new junit.framework.AssertionFailedError("InvalidSessionException Exception caught: " + e1);
        }
        catch (edu.virginia.shanti.om.bridge.soap.confluence.NotPermittedException e2) {
            throw new junit.framework.AssertionFailedError("NotPermittedException Exception caught: " + e2);
        }
        catch (edu.virginia.shanti.om.bridge.soap.confluence.RemoteException e3) {
            throw new junit.framework.AssertionFailedError("RemoteException Exception caught: " + e3);
        }
            // TBD - validate results
    }

    public void test47ConfluenceserviceV1AddSpace() throws Exception {
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
            edu.virginia.shanti.om.bridge.soap.confluence.RemoteSpace value = null;
            value = binding.addSpace(new java.lang.String(), new edu.virginia.shanti.om.bridge.soap.confluence.RemoteSpace());
        }
        catch (edu.virginia.shanti.om.bridge.soap.confluence.InvalidSessionException e1) {
            throw new junit.framework.AssertionFailedError("InvalidSessionException Exception caught: " + e1);
        }
        catch (edu.virginia.shanti.om.bridge.soap.confluence.AlreadyExistsException e2) {
            throw new junit.framework.AssertionFailedError("AlreadyExistsException Exception caught: " + e2);
        }
        catch (edu.virginia.shanti.om.bridge.soap.confluence.NotPermittedException e3) {
            throw new junit.framework.AssertionFailedError("NotPermittedException Exception caught: " + e3);
        }
        catch (edu.virginia.shanti.om.bridge.soap.confluence.RemoteException e4) {
            throw new junit.framework.AssertionFailedError("RemoteException Exception caught: " + e4);
        }
            // TBD - validate results
    }

    public void test48ConfluenceserviceV1GetRecentlyUsedLabels() throws Exception {
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
            edu.virginia.shanti.om.bridge.soap.confluence.RemoteLabel[] value = null;
            value = binding.getRecentlyUsedLabels(new java.lang.String(), 0);
        }
        catch (edu.virginia.shanti.om.bridge.soap.confluence.InvalidSessionException e1) {
            throw new junit.framework.AssertionFailedError("InvalidSessionException Exception caught: " + e1);
        }
        catch (edu.virginia.shanti.om.bridge.soap.confluence.RemoteException e2) {
            throw new junit.framework.AssertionFailedError("RemoteException Exception caught: " + e2);
        }
            // TBD - validate results
    }

    public void test49ConfluenceserviceV1GetRecentlyUsedLabelsInSpace() throws Exception {
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
            edu.virginia.shanti.om.bridge.soap.confluence.RemoteLabel[] value = null;
            value = binding.getRecentlyUsedLabelsInSpace(new java.lang.String(), new java.lang.String(), 0);
        }
        catch (edu.virginia.shanti.om.bridge.soap.confluence.InvalidSessionException e1) {
            throw new junit.framework.AssertionFailedError("InvalidSessionException Exception caught: " + e1);
        }
        catch (edu.virginia.shanti.om.bridge.soap.confluence.RemoteException e2) {
            throw new junit.framework.AssertionFailedError("RemoteException Exception caught: " + e2);
        }
            // TBD - validate results
    }

    public void test50ConfluenceserviceV1GetMostPopularLabels() throws Exception {
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
            edu.virginia.shanti.om.bridge.soap.confluence.RemoteLabel[] value = null;
            value = binding.getMostPopularLabels(new java.lang.String(), 0);
        }
        catch (edu.virginia.shanti.om.bridge.soap.confluence.InvalidSessionException e1) {
            throw new junit.framework.AssertionFailedError("InvalidSessionException Exception caught: " + e1);
        }
        catch (edu.virginia.shanti.om.bridge.soap.confluence.RemoteException e2) {
            throw new junit.framework.AssertionFailedError("RemoteException Exception caught: " + e2);
        }
            // TBD - validate results
    }

    public void test51ConfluenceserviceV1GetMostPopularLabelsInSpace() throws Exception {
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
            edu.virginia.shanti.om.bridge.soap.confluence.RemoteLabel[] value = null;
            value = binding.getMostPopularLabelsInSpace(new java.lang.String(), new java.lang.String(), 0);
        }
        catch (edu.virginia.shanti.om.bridge.soap.confluence.InvalidSessionException e1) {
            throw new junit.framework.AssertionFailedError("InvalidSessionException Exception caught: " + e1);
        }
        catch (edu.virginia.shanti.om.bridge.soap.confluence.RemoteException e2) {
            throw new junit.framework.AssertionFailedError("RemoteException Exception caught: " + e2);
        }
            // TBD - validate results
    }

    public void test52ConfluenceserviceV1SetEnableWysiwyg() throws Exception {
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
            boolean value = false;
            value = binding.setEnableWysiwyg(new java.lang.String(), true);
        }
        catch (edu.virginia.shanti.om.bridge.soap.confluence.RemoteException e1) {
            throw new junit.framework.AssertionFailedError("RemoteException Exception caught: " + e1);
        }
            // TBD - validate results
    }

    public void test53ConfluenceserviceV1GetPermissionsForUser() throws Exception {
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
            java.lang.String[] value = null;
            value = binding.getPermissionsForUser(new java.lang.String(), new java.lang.String(), new java.lang.String());
        }
        catch (edu.virginia.shanti.om.bridge.soap.confluence.InvalidSessionException e1) {
            throw new junit.framework.AssertionFailedError("InvalidSessionException Exception caught: " + e1);
        }
        catch (edu.virginia.shanti.om.bridge.soap.confluence.NotPermittedException e2) {
            throw new junit.framework.AssertionFailedError("NotPermittedException Exception caught: " + e2);
        }
        catch (edu.virginia.shanti.om.bridge.soap.confluence.RemoteException e3) {
            throw new junit.framework.AssertionFailedError("RemoteException Exception caught: " + e3);
        }
            // TBD - validate results
    }

    public void test54ConfluenceserviceV1RemoveAllPermissionsForGroup() throws Exception {
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
            boolean value = false;
            value = binding.removeAllPermissionsForGroup(new java.lang.String(), new java.lang.String());
        }
        catch (edu.virginia.shanti.om.bridge.soap.confluence.RemoteException e1) {
            throw new junit.framework.AssertionFailedError("RemoteException Exception caught: " + e1);
        }
            // TBD - validate results
    }

    public void test55ConfluenceserviceV1RemoveSpaceGroup() throws Exception {
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
            boolean value = false;
            value = binding.removeSpaceGroup(new java.lang.String(), new java.lang.String());
        }
        catch (edu.virginia.shanti.om.bridge.soap.confluence.RemoteException e1) {
            throw new junit.framework.AssertionFailedError("RemoteException Exception caught: " + e1);
        }
            // TBD - validate results
    }

    public void test56ConfluenceserviceV1GetRelatedLabelsInSpace() throws Exception {
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
            edu.virginia.shanti.om.bridge.soap.confluence.RemoteLabel[] value = null;
            value = binding.getRelatedLabelsInSpace(new java.lang.String(), new java.lang.String(), new java.lang.String(), 0);
        }
        catch (edu.virginia.shanti.om.bridge.soap.confluence.InvalidSessionException e1) {
            throw new junit.framework.AssertionFailedError("InvalidSessionException Exception caught: " + e1);
        }
        catch (edu.virginia.shanti.om.bridge.soap.confluence.RemoteException e2) {
            throw new junit.framework.AssertionFailedError("RemoteException Exception caught: " + e2);
        }
            // TBD - validate results
    }

    public void test57ConfluenceserviceV1GetSpacesContainingContentWithLabel() throws Exception {
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
            edu.virginia.shanti.om.bridge.soap.confluence.RemoteSpace[] value = null;
            value = binding.getSpacesContainingContentWithLabel(new java.lang.String(), new java.lang.String());
        }
        catch (edu.virginia.shanti.om.bridge.soap.confluence.InvalidSessionException e1) {
            throw new junit.framework.AssertionFailedError("InvalidSessionException Exception caught: " + e1);
        }
        catch (edu.virginia.shanti.om.bridge.soap.confluence.RemoteException e2) {
            throw new junit.framework.AssertionFailedError("RemoteException Exception caught: " + e2);
        }
            // TBD - validate results
    }

    public void test58ConfluenceserviceV1GetSpacesWithLabel() throws Exception {
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
            edu.virginia.shanti.om.bridge.soap.confluence.RemoteSpace[] value = null;
            value = binding.getSpacesWithLabel(new java.lang.String(), new java.lang.String());
        }
        catch (edu.virginia.shanti.om.bridge.soap.confluence.InvalidSessionException e1) {
            throw new junit.framework.AssertionFailedError("InvalidSessionException Exception caught: " + e1);
        }
        catch (edu.virginia.shanti.om.bridge.soap.confluence.RemoteException e2) {
            throw new junit.framework.AssertionFailedError("RemoteException Exception caught: " + e2);
        }
            // TBD - validate results
    }

    public void test59ConfluenceserviceV1GetLabelsByDetail() throws Exception {
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
            edu.virginia.shanti.om.bridge.soap.confluence.RemoteLabel[] value = null;
            value = binding.getLabelsByDetail(new java.lang.String(), new java.lang.String(), new java.lang.String(), new java.lang.String(), new java.lang.String());
        }
        catch (edu.virginia.shanti.om.bridge.soap.confluence.InvalidSessionException e1) {
            throw new junit.framework.AssertionFailedError("InvalidSessionException Exception caught: " + e1);
        }
        catch (edu.virginia.shanti.om.bridge.soap.confluence.RemoteException e2) {
            throw new junit.framework.AssertionFailedError("RemoteException Exception caught: " + e2);
        }
            // TBD - validate results
    }

    public void test60ConfluenceserviceV1MovePageToTopLevel() throws Exception {
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
            boolean value = false;
            value = binding.movePageToTopLevel(new java.lang.String(), 0, new java.lang.String());
        }
        catch (edu.virginia.shanti.om.bridge.soap.confluence.RemoteException e1) {
            throw new junit.framework.AssertionFailedError("RemoteException Exception caught: " + e1);
        }
            // TBD - validate results
    }

    public void test61ConfluenceserviceV1MovePage() throws Exception {
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
            boolean value = false;
            value = binding.movePage(new java.lang.String(), 0, 0, new java.lang.String());
        }
        catch (edu.virginia.shanti.om.bridge.soap.confluence.RemoteException e1) {
            throw new junit.framework.AssertionFailedError("RemoteException Exception caught: " + e1);
        }
            // TBD - validate results
    }

    public void test62ConfluenceserviceV1RenderContent() throws Exception {
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
            value = binding.renderContent(new java.lang.String(), new java.lang.String(), 0, new java.lang.String());
        }
        catch (edu.virginia.shanti.om.bridge.soap.confluence.InvalidSessionException e1) {
            throw new junit.framework.AssertionFailedError("InvalidSessionException Exception caught: " + e1);
        }
        catch (edu.virginia.shanti.om.bridge.soap.confluence.RemoteException e2) {
            throw new junit.framework.AssertionFailedError("RemoteException Exception caught: " + e2);
        }
            // TBD - validate results
    }

    public void test63ConfluenceserviceV1RenderContent() throws Exception {
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
            value = binding.renderContent(new java.lang.String(), new java.lang.String(), 0, new java.lang.String(), new java.util.HashMap());
        }
        catch (edu.virginia.shanti.om.bridge.soap.confluence.RemoteException e1) {
            throw new junit.framework.AssertionFailedError("RemoteException Exception caught: " + e1);
        }
            // TBD - validate results
    }

    public void test64ConfluenceserviceV1ExportSpace() throws Exception {
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
            value = binding.exportSpace(new java.lang.String(), new java.lang.String(), new java.lang.String());
        }
        catch (edu.virginia.shanti.om.bridge.soap.confluence.RemoteException e1) {
            throw new junit.framework.AssertionFailedError("RemoteException Exception caught: " + e1);
        }
            // TBD - validate results
    }

    public void test65ConfluenceserviceV1ExportSpace() throws Exception {
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
            value = binding.exportSpace(new java.lang.String(), new java.lang.String(), new java.lang.String(), true);
        }
        catch (edu.virginia.shanti.om.bridge.soap.confluence.RemoteException e1) {
            throw new junit.framework.AssertionFailedError("RemoteException Exception caught: " + e1);
        }
            // TBD - validate results
    }

    public void test66ConfluenceserviceV1GetUserGroups() throws Exception {
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
            java.lang.String[] value = null;
            value = binding.getUserGroups(new java.lang.String(), new java.lang.String());
        }
        catch (edu.virginia.shanti.om.bridge.soap.confluence.InvalidSessionException e1) {
            throw new junit.framework.AssertionFailedError("InvalidSessionException Exception caught: " + e1);
        }
        catch (edu.virginia.shanti.om.bridge.soap.confluence.NotPermittedException e2) {
            throw new junit.framework.AssertionFailedError("NotPermittedException Exception caught: " + e2);
        }
        catch (edu.virginia.shanti.om.bridge.soap.confluence.RemoteException e3) {
            throw new junit.framework.AssertionFailedError("RemoteException Exception caught: " + e3);
        }
            // TBD - validate results
    }

    public void test67ConfluenceserviceV1GetPageHistory() throws Exception {
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
            edu.virginia.shanti.om.bridge.soap.confluence.RemotePageHistory[] value = null;
            value = binding.getPageHistory(new java.lang.String(), 0);
        }
        catch (edu.virginia.shanti.om.bridge.soap.confluence.InvalidSessionException e1) {
            throw new junit.framework.AssertionFailedError("InvalidSessionException Exception caught: " + e1);
        }
        catch (edu.virginia.shanti.om.bridge.soap.confluence.RemoteException e2) {
            throw new junit.framework.AssertionFailedError("RemoteException Exception caught: " + e2);
        }
            // TBD - validate results
    }

    public void test68ConfluenceserviceV1RemovePage() throws Exception {
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
            boolean value = false;
            value = binding.removePage(new java.lang.String(), 0);
        }
        catch (edu.virginia.shanti.om.bridge.soap.confluence.InvalidSessionException e1) {
            throw new junit.framework.AssertionFailedError("InvalidSessionException Exception caught: " + e1);
        }
        catch (edu.virginia.shanti.om.bridge.soap.confluence.NotPermittedException e2) {
            throw new junit.framework.AssertionFailedError("NotPermittedException Exception caught: " + e2);
        }
        catch (edu.virginia.shanti.om.bridge.soap.confluence.RemoteException e3) {
            throw new junit.framework.AssertionFailedError("RemoteException Exception caught: " + e3);
        }
            // TBD - validate results
    }

    public void test69ConfluenceserviceV1StorePage() throws Exception {
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
            edu.virginia.shanti.om.bridge.soap.confluence.RemotePage value = null;
            value = binding.storePage(new java.lang.String(), new edu.virginia.shanti.om.bridge.soap.confluence.RemotePage());
        }
        catch (edu.virginia.shanti.om.bridge.soap.confluence.InvalidSessionException e1) {
            throw new junit.framework.AssertionFailedError("InvalidSessionException Exception caught: " + e1);
        }
        catch (edu.virginia.shanti.om.bridge.soap.confluence.NotPermittedException e2) {
            throw new junit.framework.AssertionFailedError("NotPermittedException Exception caught: " + e2);
        }
        catch (edu.virginia.shanti.om.bridge.soap.confluence.VersionMismatchException e3) {
            throw new junit.framework.AssertionFailedError("VersionMismatchException Exception caught: " + e3);
        }
        catch (edu.virginia.shanti.om.bridge.soap.confluence.RemoteException e4) {
            throw new junit.framework.AssertionFailedError("RemoteException Exception caught: " + e4);
        }
            // TBD - validate results
    }

    public void test70ConfluenceserviceV1UpdatePage() throws Exception {
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
            edu.virginia.shanti.om.bridge.soap.confluence.RemotePage value = null;
            value = binding.updatePage(new java.lang.String(), new edu.virginia.shanti.om.bridge.soap.confluence.RemotePage(), new edu.virginia.shanti.om.bridge.soap.confluence.RemotePageUpdateOptions());
        }
        catch (edu.virginia.shanti.om.bridge.soap.confluence.InvalidSessionException e1) {
            throw new junit.framework.AssertionFailedError("InvalidSessionException Exception caught: " + e1);
        }
        catch (edu.virginia.shanti.om.bridge.soap.confluence.NotPermittedException e2) {
            throw new junit.framework.AssertionFailedError("NotPermittedException Exception caught: " + e2);
        }
        catch (edu.virginia.shanti.om.bridge.soap.confluence.VersionMismatchException e3) {
            throw new junit.framework.AssertionFailedError("VersionMismatchException Exception caught: " + e3);
        }
        catch (edu.virginia.shanti.om.bridge.soap.confluence.RemoteException e4) {
            throw new junit.framework.AssertionFailedError("RemoteException Exception caught: " + e4);
        }
            // TBD - validate results
    }

    public void test71ConfluenceserviceV1GetSpacesInGroup() throws Exception {
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
            edu.virginia.shanti.om.bridge.soap.confluence.RemoteSpaceSummary[] value = null;
            value = binding.getSpacesInGroup(new java.lang.String(), new java.lang.String());
        }
        catch (edu.virginia.shanti.om.bridge.soap.confluence.RemoteException e1) {
            throw new junit.framework.AssertionFailedError("RemoteException Exception caught: " + e1);
        }
            // TBD - validate results
    }

    public void test72ConfluenceserviceV1StoreSpace() throws Exception {
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
            edu.virginia.shanti.om.bridge.soap.confluence.RemoteSpace value = null;
            value = binding.storeSpace(new java.lang.String(), new edu.virginia.shanti.om.bridge.soap.confluence.RemoteSpace());
        }
        catch (edu.virginia.shanti.om.bridge.soap.confluence.RemoteException e1) {
            throw new junit.framework.AssertionFailedError("RemoteException Exception caught: " + e1);
        }
            // TBD - validate results
    }

    public void test73ConfluenceserviceV1AddSpaceGroup() throws Exception {
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
            edu.virginia.shanti.om.bridge.soap.confluence.RemoteSpaceGroup value = null;
            value = binding.addSpaceGroup(new java.lang.String(), new edu.virginia.shanti.om.bridge.soap.confluence.RemoteSpaceGroup());
        }
        catch (edu.virginia.shanti.om.bridge.soap.confluence.InvalidSessionException e1) {
            throw new junit.framework.AssertionFailedError("InvalidSessionException Exception caught: " + e1);
        }
        catch (edu.virginia.shanti.om.bridge.soap.confluence.AlreadyExistsException e2) {
            throw new junit.framework.AssertionFailedError("AlreadyExistsException Exception caught: " + e2);
        }
        catch (edu.virginia.shanti.om.bridge.soap.confluence.NotPermittedException e3) {
            throw new junit.framework.AssertionFailedError("NotPermittedException Exception caught: " + e3);
        }
        catch (edu.virginia.shanti.om.bridge.soap.confluence.RemoteException e4) {
            throw new junit.framework.AssertionFailedError("RemoteException Exception caught: " + e4);
        }
            // TBD - validate results
    }

    public void test74ConfluenceserviceV1AddPersonalSpace() throws Exception {
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
            edu.virginia.shanti.om.bridge.soap.confluence.RemoteSpace value = null;
            value = binding.addPersonalSpace(new java.lang.String(), new edu.virginia.shanti.om.bridge.soap.confluence.RemoteSpace(), new java.lang.String());
        }
        catch (edu.virginia.shanti.om.bridge.soap.confluence.InvalidSessionException e1) {
            throw new junit.framework.AssertionFailedError("InvalidSessionException Exception caught: " + e1);
        }
        catch (edu.virginia.shanti.om.bridge.soap.confluence.AlreadyExistsException e2) {
            throw new junit.framework.AssertionFailedError("AlreadyExistsException Exception caught: " + e2);
        }
        catch (edu.virginia.shanti.om.bridge.soap.confluence.NotPermittedException e3) {
            throw new junit.framework.AssertionFailedError("NotPermittedException Exception caught: " + e3);
        }
        catch (edu.virginia.shanti.om.bridge.soap.confluence.RemoteException e4) {
            throw new junit.framework.AssertionFailedError("RemoteException Exception caught: " + e4);
        }
            // TBD - validate results
    }

    public void test75ConfluenceserviceV1GetSpaceLevelPermissions() throws Exception {
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
            java.lang.String[] value = null;
            value = binding.getSpaceLevelPermissions(new java.lang.String());
        }
        catch (edu.virginia.shanti.om.bridge.soap.confluence.RemoteException e1) {
            throw new junit.framework.AssertionFailedError("RemoteException Exception caught: " + e1);
        }
            // TBD - validate results
    }

    public void test76ConfluenceserviceV1AddPermissionToSpace() throws Exception {
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
            boolean value = false;
            value = binding.addPermissionToSpace(new java.lang.String(), new java.lang.String(), new java.lang.String(), new java.lang.String());
        }
        catch (edu.virginia.shanti.om.bridge.soap.confluence.RemoteException e1) {
            throw new junit.framework.AssertionFailedError("RemoteException Exception caught: " + e1);
        }
            // TBD - validate results
    }

    public void test77ConfluenceserviceV1AddGlobalPermissions() throws Exception {
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
            boolean value = false;
            value = binding.addGlobalPermissions(new java.lang.String(), new java.lang.String[0], new java.lang.String());
        }
        catch (edu.virginia.shanti.om.bridge.soap.confluence.NotPermittedException e1) {
            throw new junit.framework.AssertionFailedError("NotPermittedException Exception caught: " + e1);
        }
        catch (edu.virginia.shanti.om.bridge.soap.confluence.RemoteException e2) {
            throw new junit.framework.AssertionFailedError("RemoteException Exception caught: " + e2);
        }
            // TBD - validate results
    }

    public void test78ConfluenceserviceV1AddGlobalPermission() throws Exception {
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
            boolean value = false;
            value = binding.addGlobalPermission(new java.lang.String(), new java.lang.String(), new java.lang.String());
        }
        catch (edu.virginia.shanti.om.bridge.soap.confluence.NotPermittedException e1) {
            throw new junit.framework.AssertionFailedError("NotPermittedException Exception caught: " + e1);
        }
        catch (edu.virginia.shanti.om.bridge.soap.confluence.RemoteException e2) {
            throw new junit.framework.AssertionFailedError("RemoteException Exception caught: " + e2);
        }
            // TBD - validate results
    }

    public void test79ConfluenceserviceV1AddAnonymousUsePermission() throws Exception {
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
            boolean value = false;
            value = binding.addAnonymousUsePermission(new java.lang.String());
        }
        catch (edu.virginia.shanti.om.bridge.soap.confluence.RemoteException e1) {
            throw new junit.framework.AssertionFailedError("RemoteException Exception caught: " + e1);
        }
            // TBD - validate results
    }

    public void test80ConfluenceserviceV1AddAnonymousViewUserProfilePermission() throws Exception {
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
            boolean value = false;
            value = binding.addAnonymousViewUserProfilePermission(new java.lang.String());
        }
        catch (edu.virginia.shanti.om.bridge.soap.confluence.RemoteException e1) {
            throw new junit.framework.AssertionFailedError("RemoteException Exception caught: " + e1);
        }
            // TBD - validate results
    }

    public void test81ConfluenceserviceV1RemoveAnonymousViewUserProfilePermission() throws Exception {
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
            boolean value = false;
            value = binding.removeAnonymousViewUserProfilePermission(new java.lang.String());
        }
        catch (edu.virginia.shanti.om.bridge.soap.confluence.RemoteException e1) {
            throw new junit.framework.AssertionFailedError("RemoteException Exception caught: " + e1);
        }
            // TBD - validate results
    }

    public void test82ConfluenceserviceV1RemoveGlobalPermission() throws Exception {
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
            boolean value = false;
            value = binding.removeGlobalPermission(new java.lang.String(), new java.lang.String(), new java.lang.String());
        }
        catch (edu.virginia.shanti.om.bridge.soap.confluence.RemoteException e1) {
            throw new junit.framework.AssertionFailedError("RemoteException Exception caught: " + e1);
        }
            // TBD - validate results
    }

    public void test83ConfluenceserviceV1AddPermissionsToSpace() throws Exception {
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
            boolean value = false;
            value = binding.addPermissionsToSpace(new java.lang.String(), new java.lang.String[0], new java.lang.String(), new java.lang.String());
        }
        catch (edu.virginia.shanti.om.bridge.soap.confluence.RemoteException e1) {
            throw new junit.framework.AssertionFailedError("RemoteException Exception caught: " + e1);
        }
            // TBD - validate results
    }

    public void test84ConfluenceserviceV1RemovePermissionFromSpace() throws Exception {
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
            boolean value = false;
            value = binding.removePermissionFromSpace(new java.lang.String(), new java.lang.String(), new java.lang.String(), new java.lang.String());
        }
        catch (edu.virginia.shanti.om.bridge.soap.confluence.NotPermittedException e1) {
            throw new junit.framework.AssertionFailedError("NotPermittedException Exception caught: " + e1);
        }
        catch (edu.virginia.shanti.om.bridge.soap.confluence.RemoteException e2) {
            throw new junit.framework.AssertionFailedError("RemoteException Exception caught: " + e2);
        }
            // TBD - validate results
    }

    public void test85ConfluenceserviceV1EditUser() throws Exception {
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
            boolean value = false;
            value = binding.editUser(new java.lang.String(), new edu.virginia.shanti.om.bridge.soap.confluence.RemoteUser());
        }
        catch (edu.virginia.shanti.om.bridge.soap.confluence.InvalidSessionException e1) {
            throw new junit.framework.AssertionFailedError("InvalidSessionException Exception caught: " + e1);
        }
        catch (edu.virginia.shanti.om.bridge.soap.confluence.NotPermittedException e2) {
            throw new junit.framework.AssertionFailedError("NotPermittedException Exception caught: " + e2);
        }
        catch (edu.virginia.shanti.om.bridge.soap.confluence.RemoteException e3) {
            throw new junit.framework.AssertionFailedError("RemoteException Exception caught: " + e3);
        }
            // TBD - validate results
    }

    public void test86ConfluenceserviceV1AddUserToGroup() throws Exception {
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
            boolean value = false;
            value = binding.addUserToGroup(new java.lang.String(), new java.lang.String(), new java.lang.String());
        }
        catch (edu.virginia.shanti.om.bridge.soap.confluence.InvalidSessionException e1) {
            throw new junit.framework.AssertionFailedError("InvalidSessionException Exception caught: " + e1);
        }
        catch (edu.virginia.shanti.om.bridge.soap.confluence.NotPermittedException e2) {
            throw new junit.framework.AssertionFailedError("NotPermittedException Exception caught: " + e2);
        }
        catch (edu.virginia.shanti.om.bridge.soap.confluence.RemoteException e3) {
            throw new junit.framework.AssertionFailedError("RemoteException Exception caught: " + e3);
        }
            // TBD - validate results
    }

    public void test87ConfluenceserviceV1RemoveUserFromGroup() throws Exception {
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
            boolean value = false;
            value = binding.removeUserFromGroup(new java.lang.String(), new java.lang.String(), new java.lang.String());
        }
        catch (edu.virginia.shanti.om.bridge.soap.confluence.InvalidSessionException e1) {
            throw new junit.framework.AssertionFailedError("InvalidSessionException Exception caught: " + e1);
        }
        catch (edu.virginia.shanti.om.bridge.soap.confluence.NotPermittedException e2) {
            throw new junit.framework.AssertionFailedError("NotPermittedException Exception caught: " + e2);
        }
        catch (edu.virginia.shanti.om.bridge.soap.confluence.RemoteException e3) {
            throw new junit.framework.AssertionFailedError("RemoteException Exception caught: " + e3);
        }
            // TBD - validate results
    }

    public void test88ConfluenceserviceV1GetActiveUsers() throws Exception {
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
            java.lang.String[] value = null;
            value = binding.getActiveUsers(new java.lang.String(), true);
        }
        catch (edu.virginia.shanti.om.bridge.soap.confluence.InvalidSessionException e1) {
            throw new junit.framework.AssertionFailedError("InvalidSessionException Exception caught: " + e1);
        }
        catch (edu.virginia.shanti.om.bridge.soap.confluence.RemoteException e2) {
            throw new junit.framework.AssertionFailedError("RemoteException Exception caught: " + e2);
        }
            // TBD - validate results
    }

    public void test89ConfluenceserviceV1ChangeMyPassword() throws Exception {
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
            boolean value = false;
            value = binding.changeMyPassword(new java.lang.String(), new java.lang.String(), new java.lang.String());
        }
        catch (edu.virginia.shanti.om.bridge.soap.confluence.InvalidSessionException e1) {
            throw new junit.framework.AssertionFailedError("InvalidSessionException Exception caught: " + e1);
        }
        catch (edu.virginia.shanti.om.bridge.soap.confluence.RemoteException e2) {
            throw new junit.framework.AssertionFailedError("RemoteException Exception caught: " + e2);
        }
            // TBD - validate results
    }

    public void test90ConfluenceserviceV1ChangeUserPassword() throws Exception {
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
            boolean value = false;
            value = binding.changeUserPassword(new java.lang.String(), new java.lang.String(), new java.lang.String());
        }
        catch (edu.virginia.shanti.om.bridge.soap.confluence.InvalidSessionException e1) {
            throw new junit.framework.AssertionFailedError("InvalidSessionException Exception caught: " + e1);
        }
        catch (edu.virginia.shanti.om.bridge.soap.confluence.NotPermittedException e2) {
            throw new junit.framework.AssertionFailedError("NotPermittedException Exception caught: " + e2);
        }
        catch (edu.virginia.shanti.om.bridge.soap.confluence.RemoteException e3) {
            throw new junit.framework.AssertionFailedError("RemoteException Exception caught: " + e3);
        }
            // TBD - validate results
    }

    public void test91ConfluenceserviceV1SetUserInformation() throws Exception {
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
            boolean value = false;
            value = binding.setUserInformation(new java.lang.String(), new edu.virginia.shanti.om.bridge.soap.confluence.RemoteUserInformation());
        }
        catch (edu.virginia.shanti.om.bridge.soap.confluence.InvalidSessionException e1) {
            throw new junit.framework.AssertionFailedError("InvalidSessionException Exception caught: " + e1);
        }
        catch (edu.virginia.shanti.om.bridge.soap.confluence.NotPermittedException e2) {
            throw new junit.framework.AssertionFailedError("NotPermittedException Exception caught: " + e2);
        }
        catch (edu.virginia.shanti.om.bridge.soap.confluence.RemoteException e3) {
            throw new junit.framework.AssertionFailedError("RemoteException Exception caught: " + e3);
        }
            // TBD - validate results
    }

    public void test92ConfluenceserviceV1GetUserInformation() throws Exception {
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
            edu.virginia.shanti.om.bridge.soap.confluence.RemoteUserInformation value = null;
            value = binding.getUserInformation(new java.lang.String(), new java.lang.String());
        }
        catch (edu.virginia.shanti.om.bridge.soap.confluence.InvalidSessionException e1) {
            throw new junit.framework.AssertionFailedError("InvalidSessionException Exception caught: " + e1);
        }
        catch (edu.virginia.shanti.om.bridge.soap.confluence.RemoteException e2) {
            throw new junit.framework.AssertionFailedError("RemoteException Exception caught: " + e2);
        }
            // TBD - validate results
    }

    public void test93ConfluenceserviceV1HasUser() throws Exception {
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
            boolean value = false;
            value = binding.hasUser(new java.lang.String(), new java.lang.String());
        }
        catch (edu.virginia.shanti.om.bridge.soap.confluence.InvalidSessionException e1) {
            throw new junit.framework.AssertionFailedError("InvalidSessionException Exception caught: " + e1);
        }
        catch (edu.virginia.shanti.om.bridge.soap.confluence.RemoteException e2) {
            throw new junit.framework.AssertionFailedError("RemoteException Exception caught: " + e2);
        }
            // TBD - validate results
    }

    public void test94ConfluenceserviceV1HasGroup() throws Exception {
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
            boolean value = false;
            value = binding.hasGroup(new java.lang.String(), new java.lang.String());
        }
        catch (edu.virginia.shanti.om.bridge.soap.confluence.InvalidSessionException e1) {
            throw new junit.framework.AssertionFailedError("InvalidSessionException Exception caught: " + e1);
        }
        catch (edu.virginia.shanti.om.bridge.soap.confluence.RemoteException e2) {
            throw new junit.framework.AssertionFailedError("RemoteException Exception caught: " + e2);
        }
            // TBD - validate results
    }

    public void test95ConfluenceserviceV1AddProfilePicture() throws Exception {
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
            boolean value = false;
            value = binding.addProfilePicture(new java.lang.String(), new java.lang.String(), new java.lang.String(), new java.lang.String(), new byte[0]);
        }
        catch (edu.virginia.shanti.om.bridge.soap.confluence.InvalidSessionException e1) {
            throw new junit.framework.AssertionFailedError("InvalidSessionException Exception caught: " + e1);
        }
        catch (edu.virginia.shanti.om.bridge.soap.confluence.NotPermittedException e2) {
            throw new junit.framework.AssertionFailedError("NotPermittedException Exception caught: " + e2);
        }
        catch (edu.virginia.shanti.om.bridge.soap.confluence.RemoteException e3) {
            throw new junit.framework.AssertionFailedError("RemoteException Exception caught: " + e3);
        }
            // TBD - validate results
    }

    public void test96ConfluenceserviceV1GetBlogEntryByDayAndTitle() throws Exception {
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
            edu.virginia.shanti.om.bridge.soap.confluence.RemoteBlogEntry value = null;
            value = binding.getBlogEntryByDayAndTitle(new java.lang.String(), new java.lang.String(), 0, new java.lang.String());
        }
        catch (edu.virginia.shanti.om.bridge.soap.confluence.RemoteException e1) {
            throw new junit.framework.AssertionFailedError("RemoteException Exception caught: " + e1);
        }
            // TBD - validate results
    }

    public void test97ConfluenceserviceV1GetBlogEntry() throws Exception {
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
            edu.virginia.shanti.om.bridge.soap.confluence.RemoteBlogEntry value = null;
            value = binding.getBlogEntry(new java.lang.String(), 0);
        }
        catch (edu.virginia.shanti.om.bridge.soap.confluence.RemoteException e1) {
            throw new junit.framework.AssertionFailedError("RemoteException Exception caught: " + e1);
        }
            // TBD - validate results
    }

    public void test98ConfluenceserviceV1GetBlogEntries() throws Exception {
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
            edu.virginia.shanti.om.bridge.soap.confluence.RemoteBlogEntrySummary[] value = null;
            value = binding.getBlogEntries(new java.lang.String(), new java.lang.String());
        }
        catch (edu.virginia.shanti.om.bridge.soap.confluence.InvalidSessionException e1) {
            throw new junit.framework.AssertionFailedError("InvalidSessionException Exception caught: " + e1);
        }
        catch (edu.virginia.shanti.om.bridge.soap.confluence.RemoteException e2) {
            throw new junit.framework.AssertionFailedError("RemoteException Exception caught: " + e2);
        }
            // TBD - validate results
    }

    public void test99ConfluenceserviceV1StoreBlogEntry() throws Exception {
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
            edu.virginia.shanti.om.bridge.soap.confluence.RemoteBlogEntry value = null;
            value = binding.storeBlogEntry(new java.lang.String(), new edu.virginia.shanti.om.bridge.soap.confluence.RemoteBlogEntry());
        }
        catch (edu.virginia.shanti.om.bridge.soap.confluence.InvalidSessionException e1) {
            throw new junit.framework.AssertionFailedError("InvalidSessionException Exception caught: " + e1);
        }
        catch (edu.virginia.shanti.om.bridge.soap.confluence.NotPermittedException e2) {
            throw new junit.framework.AssertionFailedError("NotPermittedException Exception caught: " + e2);
        }
        catch (edu.virginia.shanti.om.bridge.soap.confluence.VersionMismatchException e3) {
            throw new junit.framework.AssertionFailedError("VersionMismatchException Exception caught: " + e3);
        }
        catch (edu.virginia.shanti.om.bridge.soap.confluence.RemoteException e4) {
            throw new junit.framework.AssertionFailedError("RemoteException Exception caught: " + e4);
        }
            // TBD - validate results
    }

    public void test100ConfluenceserviceV1ExportSite() throws Exception {
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
            value = binding.exportSite(new java.lang.String(), true);
        }
        catch (edu.virginia.shanti.om.bridge.soap.confluence.RemoteException e1) {
            throw new junit.framework.AssertionFailedError("RemoteException Exception caught: " + e1);
        }
            // TBD - validate results
    }

    public void test101ConfluenceserviceV1FlushIndexQueue() throws Exception {
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
            boolean value = false;
            value = binding.flushIndexQueue(new java.lang.String());
        }
        catch (edu.virginia.shanti.om.bridge.soap.confluence.RemoteException e1) {
            throw new junit.framework.AssertionFailedError("RemoteException Exception caught: " + e1);
        }
            // TBD - validate results
    }

    public void test102ConfluenceserviceV1ClearIndexQueue() throws Exception {
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
            boolean value = false;
            value = binding.clearIndexQueue(new java.lang.String());
        }
        catch (edu.virginia.shanti.om.bridge.soap.confluence.RemoteException e1) {
            throw new junit.framework.AssertionFailedError("RemoteException Exception caught: " + e1);
        }
            // TBD - validate results
    }

    public void test103ConfluenceserviceV1GetClusterNodeStatuses() throws Exception {
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
            edu.virginia.shanti.om.bridge.soap.confluence.RemoteNodeStatus[] value = null;
            value = binding.getClusterNodeStatuses(new java.lang.String());
        }
        catch (edu.virginia.shanti.om.bridge.soap.confluence.RemoteException e1) {
            throw new junit.framework.AssertionFailedError("RemoteException Exception caught: " + e1);
        }
            // TBD - validate results
    }

    public void test104ConfluenceserviceV1ImportSpace() throws Exception {
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
            boolean value = false;
            value = binding.importSpace(new java.lang.String(), new byte[0]);
        }
        catch (edu.virginia.shanti.om.bridge.soap.confluence.RemoteException e1) {
            throw new junit.framework.AssertionFailedError("RemoteException Exception caught: " + e1);
        }
            // TBD - validate results
    }

    public void test105ConfluenceserviceV1SetEnableAnonymousAccess() throws Exception {
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
            boolean value = false;
            value = binding.setEnableAnonymousAccess(new java.lang.String(), true);
        }
        catch (edu.virginia.shanti.om.bridge.soap.confluence.RemoteException e1) {
            throw new junit.framework.AssertionFailedError("RemoteException Exception caught: " + e1);
        }
            // TBD - validate results
    }

    public void test106ConfluenceserviceV1GetLabelsById() throws Exception {
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
            edu.virginia.shanti.om.bridge.soap.confluence.RemoteLabel[] value = null;
            value = binding.getLabelsById(new java.lang.String(), 0);
        }
        catch (edu.virginia.shanti.om.bridge.soap.confluence.InvalidSessionException e1) {
            throw new junit.framework.AssertionFailedError("InvalidSessionException Exception caught: " + e1);
        }
        catch (edu.virginia.shanti.om.bridge.soap.confluence.RemoteException e2) {
            throw new junit.framework.AssertionFailedError("RemoteException Exception caught: " + e2);
        }
            // TBD - validate results
    }

    public void test107ConfluenceserviceV1GetLabelContentById() throws Exception {
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
            edu.virginia.shanti.om.bridge.soap.confluence.RemoteSearchResult[] value = null;
            value = binding.getLabelContentById(new java.lang.String(), 0);
        }
        catch (edu.virginia.shanti.om.bridge.soap.confluence.InvalidSessionException e1) {
            throw new junit.framework.AssertionFailedError("InvalidSessionException Exception caught: " + e1);
        }
        catch (edu.virginia.shanti.om.bridge.soap.confluence.RemoteException e2) {
            throw new junit.framework.AssertionFailedError("RemoteException Exception caught: " + e2);
        }
            // TBD - validate results
    }

    public void test108ConfluenceserviceV1GetLabelContentByName() throws Exception {
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
            edu.virginia.shanti.om.bridge.soap.confluence.RemoteSearchResult[] value = null;
            value = binding.getLabelContentByName(new java.lang.String(), new java.lang.String());
        }
        catch (edu.virginia.shanti.om.bridge.soap.confluence.InvalidSessionException e1) {
            throw new junit.framework.AssertionFailedError("InvalidSessionException Exception caught: " + e1);
        }
        catch (edu.virginia.shanti.om.bridge.soap.confluence.RemoteException e2) {
            throw new junit.framework.AssertionFailedError("RemoteException Exception caught: " + e2);
        }
            // TBD - validate results
    }

    public void test109ConfluenceserviceV1GetLabelContentByObject() throws Exception {
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
            edu.virginia.shanti.om.bridge.soap.confluence.RemoteSearchResult[] value = null;
            value = binding.getLabelContentByObject(new java.lang.String(), new edu.virginia.shanti.om.bridge.soap.confluence.RemoteLabel());
        }
        catch (edu.virginia.shanti.om.bridge.soap.confluence.InvalidSessionException e1) {
            throw new junit.framework.AssertionFailedError("InvalidSessionException Exception caught: " + e1);
        }
        catch (edu.virginia.shanti.om.bridge.soap.confluence.RemoteException e2) {
            throw new junit.framework.AssertionFailedError("RemoteException Exception caught: " + e2);
        }
            // TBD - validate results
    }

    public void test110ConfluenceserviceV1AddLabelByName() throws Exception {
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
            boolean value = false;
            value = binding.addLabelByName(new java.lang.String(), new java.lang.String(), 0);
        }
        catch (edu.virginia.shanti.om.bridge.soap.confluence.InvalidSessionException e1) {
            throw new junit.framework.AssertionFailedError("InvalidSessionException Exception caught: " + e1);
        }
        catch (edu.virginia.shanti.om.bridge.soap.confluence.NotPermittedException e2) {
            throw new junit.framework.AssertionFailedError("NotPermittedException Exception caught: " + e2);
        }
        catch (edu.virginia.shanti.om.bridge.soap.confluence.RemoteException e3) {
            throw new junit.framework.AssertionFailedError("RemoteException Exception caught: " + e3);
        }
            // TBD - validate results
    }

    public void test111ConfluenceserviceV1AddLabelById() throws Exception {
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
            boolean value = false;
            value = binding.addLabelById(new java.lang.String(), 0, 0);
        }
        catch (edu.virginia.shanti.om.bridge.soap.confluence.InvalidSessionException e1) {
            throw new junit.framework.AssertionFailedError("InvalidSessionException Exception caught: " + e1);
        }
        catch (edu.virginia.shanti.om.bridge.soap.confluence.NotPermittedException e2) {
            throw new junit.framework.AssertionFailedError("NotPermittedException Exception caught: " + e2);
        }
        catch (edu.virginia.shanti.om.bridge.soap.confluence.RemoteException e3) {
            throw new junit.framework.AssertionFailedError("RemoteException Exception caught: " + e3);
        }
            // TBD - validate results
    }

    public void test112ConfluenceserviceV1AddLabelByObject() throws Exception {
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
            boolean value = false;
            value = binding.addLabelByObject(new java.lang.String(), new edu.virginia.shanti.om.bridge.soap.confluence.RemoteLabel(), 0);
        }
        catch (edu.virginia.shanti.om.bridge.soap.confluence.InvalidSessionException e1) {
            throw new junit.framework.AssertionFailedError("InvalidSessionException Exception caught: " + e1);
        }
        catch (edu.virginia.shanti.om.bridge.soap.confluence.NotPermittedException e2) {
            throw new junit.framework.AssertionFailedError("NotPermittedException Exception caught: " + e2);
        }
        catch (edu.virginia.shanti.om.bridge.soap.confluence.RemoteException e3) {
            throw new junit.framework.AssertionFailedError("RemoteException Exception caught: " + e3);
        }
            // TBD - validate results
    }

    public void test113ConfluenceserviceV1AddLabelByNameToSpace() throws Exception {
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
            boolean value = false;
            value = binding.addLabelByNameToSpace(new java.lang.String(), new java.lang.String(), new java.lang.String());
        }
        catch (edu.virginia.shanti.om.bridge.soap.confluence.InvalidSessionException e1) {
            throw new junit.framework.AssertionFailedError("InvalidSessionException Exception caught: " + e1);
        }
        catch (edu.virginia.shanti.om.bridge.soap.confluence.NotPermittedException e2) {
            throw new junit.framework.AssertionFailedError("NotPermittedException Exception caught: " + e2);
        }
        catch (edu.virginia.shanti.om.bridge.soap.confluence.RemoteException e3) {
            throw new junit.framework.AssertionFailedError("RemoteException Exception caught: " + e3);
        }
            // TBD - validate results
    }

    public void test114ConfluenceserviceV1RemoveLabelByName() throws Exception {
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
            boolean value = false;
            value = binding.removeLabelByName(new java.lang.String(), new java.lang.String(), 0);
        }
        catch (edu.virginia.shanti.om.bridge.soap.confluence.InvalidSessionException e1) {
            throw new junit.framework.AssertionFailedError("InvalidSessionException Exception caught: " + e1);
        }
        catch (edu.virginia.shanti.om.bridge.soap.confluence.NotPermittedException e2) {
            throw new junit.framework.AssertionFailedError("NotPermittedException Exception caught: " + e2);
        }
        catch (edu.virginia.shanti.om.bridge.soap.confluence.RemoteException e3) {
            throw new junit.framework.AssertionFailedError("RemoteException Exception caught: " + e3);
        }
            // TBD - validate results
    }

    public void test115ConfluenceserviceV1RemoveLabelById() throws Exception {
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
            boolean value = false;
            value = binding.removeLabelById(new java.lang.String(), 0, 0);
        }
        catch (edu.virginia.shanti.om.bridge.soap.confluence.InvalidSessionException e1) {
            throw new junit.framework.AssertionFailedError("InvalidSessionException Exception caught: " + e1);
        }
        catch (edu.virginia.shanti.om.bridge.soap.confluence.NotPermittedException e2) {
            throw new junit.framework.AssertionFailedError("NotPermittedException Exception caught: " + e2);
        }
        catch (edu.virginia.shanti.om.bridge.soap.confluence.RemoteException e3) {
            throw new junit.framework.AssertionFailedError("RemoteException Exception caught: " + e3);
        }
            // TBD - validate results
    }

    public void test116ConfluenceserviceV1RemoveLabelByObject() throws Exception {
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
            boolean value = false;
            value = binding.removeLabelByObject(new java.lang.String(), new edu.virginia.shanti.om.bridge.soap.confluence.RemoteLabel(), 0);
        }
        catch (edu.virginia.shanti.om.bridge.soap.confluence.InvalidSessionException e1) {
            throw new junit.framework.AssertionFailedError("InvalidSessionException Exception caught: " + e1);
        }
        catch (edu.virginia.shanti.om.bridge.soap.confluence.NotPermittedException e2) {
            throw new junit.framework.AssertionFailedError("NotPermittedException Exception caught: " + e2);
        }
        catch (edu.virginia.shanti.om.bridge.soap.confluence.RemoteException e3) {
            throw new junit.framework.AssertionFailedError("RemoteException Exception caught: " + e3);
        }
            // TBD - validate results
    }

    public void test117ConfluenceserviceV1RemoveLabelByNameFromSpace() throws Exception {
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
            boolean value = false;
            value = binding.removeLabelByNameFromSpace(new java.lang.String(), new java.lang.String(), new java.lang.String());
        }
        catch (edu.virginia.shanti.om.bridge.soap.confluence.InvalidSessionException e1) {
            throw new junit.framework.AssertionFailedError("InvalidSessionException Exception caught: " + e1);
        }
        catch (edu.virginia.shanti.om.bridge.soap.confluence.NotPermittedException e2) {
            throw new junit.framework.AssertionFailedError("NotPermittedException Exception caught: " + e2);
        }
        catch (edu.virginia.shanti.om.bridge.soap.confluence.RemoteException e3) {
            throw new junit.framework.AssertionFailedError("RemoteException Exception caught: " + e3);
        }
            // TBD - validate results
    }

    public void test118ConfluenceserviceV1RemoveAnonymousUsePermission() throws Exception {
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
            boolean value = false;
            value = binding.removeAnonymousUsePermission(new java.lang.String());
        }
        catch (edu.virginia.shanti.om.bridge.soap.confluence.RemoteException e1) {
            throw new junit.framework.AssertionFailedError("RemoteException Exception caught: " + e1);
        }
            // TBD - validate results
    }

    public void test119ConfluenceserviceV1AddAnonymousPermissionToSpace() throws Exception {
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
            boolean value = false;
            value = binding.addAnonymousPermissionToSpace(new java.lang.String(), new java.lang.String(), new java.lang.String());
        }
        catch (edu.virginia.shanti.om.bridge.soap.confluence.RemoteException e1) {
            throw new junit.framework.AssertionFailedError("RemoteException Exception caught: " + e1);
        }
            // TBD - validate results
    }

    public void test120ConfluenceserviceV1AddAnonymousPermissionsToSpace() throws Exception {
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
            boolean value = false;
            value = binding.addAnonymousPermissionsToSpace(new java.lang.String(), new java.lang.String[0], new java.lang.String());
        }
        catch (edu.virginia.shanti.om.bridge.soap.confluence.RemoteException e1) {
            throw new junit.framework.AssertionFailedError("RemoteException Exception caught: " + e1);
        }
            // TBD - validate results
    }

    public void test121ConfluenceserviceV1RemoveAnonymousPermissionFromSpace() throws Exception {
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
            boolean value = false;
            value = binding.removeAnonymousPermissionFromSpace(new java.lang.String(), new java.lang.String(), new java.lang.String());
        }
        catch (edu.virginia.shanti.om.bridge.soap.confluence.NotPermittedException e1) {
            throw new junit.framework.AssertionFailedError("NotPermittedException Exception caught: " + e1);
        }
        catch (edu.virginia.shanti.om.bridge.soap.confluence.RemoteException e2) {
            throw new junit.framework.AssertionFailedError("RemoteException Exception caught: " + e2);
        }
            // TBD - validate results
    }

    public void test122ConfluenceserviceV1GetPagePermissions() throws Exception {
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
            edu.virginia.shanti.om.bridge.soap.confluence.RemotePermission[] value = null;
            value = binding.getPagePermissions(new java.lang.String(), 0);
        }
        catch (edu.virginia.shanti.om.bridge.soap.confluence.InvalidSessionException e1) {
            throw new junit.framework.AssertionFailedError("InvalidSessionException Exception caught: " + e1);
        }
        catch (edu.virginia.shanti.om.bridge.soap.confluence.RemoteException e2) {
            throw new junit.framework.AssertionFailedError("RemoteException Exception caught: " + e2);
        }
            // TBD - validate results
    }

}
