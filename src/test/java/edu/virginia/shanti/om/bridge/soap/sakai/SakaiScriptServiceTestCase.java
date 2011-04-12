/**
 * SakaiScriptServiceTestCase.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package edu.virginia.shanti.om.bridge.soap.sakai;

public class SakaiScriptServiceTestCase extends junit.framework.TestCase {
    public SakaiScriptServiceTestCase(java.lang.String name) {
        super(name);
    }
    
    public void testNothingYet() {
    	// fail("Not Yet Implemented"); 	
    }

    
    /* 
    public void testSakaiScriptWSDL() throws Exception {
        javax.xml.rpc.ServiceFactory serviceFactory = javax.xml.rpc.ServiceFactory.newInstance();
        java.net.URL url = new java.net.URL(new edu.virginia.shanti.om.bridge.soap.sakai.SakaiScriptServiceLocator().getSakaiScriptAddress() + "?WSDL");
        javax.xml.rpc.Service service = serviceFactory.createService(url, new edu.virginia.shanti.om.bridge.soap.sakai.SakaiScriptServiceLocator().getServiceName());
        assertTrue(service != null);
    }

    public void test1SakaiScriptRemoveUser() throws Exception {
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

        // Time out after a minute
        binding.setTimeout(60000);

        // Test operation
        java.lang.String value = null;
        value = binding.removeUser(new java.lang.String(), new java.lang.String());
        // TBD - validate results
    }

    public void test2SakaiScriptGetUserId() throws Exception {
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

        // Time out after a minute
        binding.setTimeout(60000);

        // Test operation
        java.lang.String value = null;
        value = binding.getUserId(new java.lang.String(), new java.lang.String());
        // TBD - validate results
    }

    public void test3SakaiScriptGetUserType() throws Exception {
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

        // Time out after a minute
        binding.setTimeout(60000);

        // Test operation
        java.lang.String value = null;
        value = binding.getUserType(new java.lang.String(), new java.lang.String());
        // TBD - validate results
    }

    public void test4SakaiScriptGetSiteTitle() throws Exception {
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

        // Time out after a minute
        binding.setTimeout(60000);

        // Test operation
        java.lang.String value = null;
        value = binding.getSiteTitle(new java.lang.String(), new java.lang.String());
        // TBD - validate results
    }

    public void test5SakaiScriptRemoveAuthzGroup() throws Exception {
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

        // Time out after a minute
        binding.setTimeout(60000);

        // Test operation
        java.lang.String value = null;
        value = binding.removeAuthzGroup(new java.lang.String(), new java.lang.String());
        // TBD - validate results
    }

    public void test6SakaiScriptGetSiteDescription() throws Exception {
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

        // Time out after a minute
        binding.setTimeout(60000);

        // Test operation
        java.lang.String value = null;
        value = binding.getSiteDescription(new java.lang.String(), new java.lang.String());
        // TBD - validate results
    }

    public void test7SakaiScriptGetUserDisplayName() throws Exception {
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

        // Time out after a minute
        binding.setTimeout(60000);

        // Test operation
        java.lang.String value = null;
        value = binding.getUserDisplayName(new java.lang.String());
        // TBD - validate results
    }

    public void test8SakaiScriptGetUserDisplayName() throws Exception {
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

        // Time out after a minute
        binding.setTimeout(60000);

        // Test operation
        java.lang.String value = null;
        value = binding.getUserDisplayName(new java.lang.String(), new java.lang.String());
        // TBD - validate results
    }

    public void test9SakaiScriptGetUserEmail() throws Exception {
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

        // Time out after a minute
        binding.setTimeout(60000);

        // Test operation
        java.lang.String value = null;
        value = binding.getUserEmail(new java.lang.String());
        // TBD - validate results
    }

    public void test10SakaiScriptGetUserEmail() throws Exception {
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

        // Time out after a minute
        binding.setTimeout(60000);

        // Test operation
        java.lang.String value = null;
        value = binding.getUserEmail(new java.lang.String(), new java.lang.String());
        // TBD - validate results
    }

    public void test11SakaiScriptCheckForUser() throws Exception {
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

        // Time out after a minute
        binding.setTimeout(60000);

        // Test operation
        boolean value = false;
        value = binding.checkForUser(new java.lang.String(), new java.lang.String());
        // TBD - validate results
    }

    public void test12SakaiScriptRemoveSite() throws Exception {
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

        // Time out after a minute
        binding.setTimeout(60000);

        // Test operation
        java.lang.String value = null;
        value = binding.removeSite(new java.lang.String(), new java.lang.String());
        // TBD - validate results
    }

    public void test13SakaiScriptGetSiteSkin() throws Exception {
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

        // Time out after a minute
        binding.setTimeout(60000);

        // Test operation
        java.lang.String value = null;
        value = binding.getSiteSkin(new java.lang.String(), new java.lang.String());
        // TBD - validate results
    }

    public void test14SakaiScriptAddMemberToGroup() throws Exception {
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

        // Time out after a minute
        binding.setTimeout(60000);

        // Test operation
        boolean value = false;
        value = binding.addMemberToGroup(new java.lang.String(), new java.lang.String(), new java.lang.String(), new java.lang.String());
        // TBD - validate results
    }

    public void test15SakaiScriptAddNewUser() throws Exception {
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

        // Time out after a minute
        binding.setTimeout(60000);

        // Test operation
        java.lang.String value = null;
        value = binding.addNewUser(new java.lang.String(), new java.lang.String(), new java.lang.String(), new java.lang.String(), new java.lang.String(), new java.lang.String(), new java.lang.String());
        // TBD - validate results
    }

    public void test16SakaiScriptAddNewUser() throws Exception {
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

        // Time out after a minute
        binding.setTimeout(60000);

        // Test operation
        java.lang.String value = null;
        value = binding.addNewUser(new java.lang.String(), new java.lang.String(), new java.lang.String(), new java.lang.String(), new java.lang.String(), new java.lang.String(), new java.lang.String(), new java.lang.String());
        // TBD - validate results
    }

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

        // Time out after a minute
        binding.setTimeout(60000);

        // Test operation
        java.lang.String value = null;
        value = binding.getSiteProperty(new java.lang.String(), new java.lang.String(), new java.lang.String());
        // TBD - validate results
    }

    public void test18SakaiScriptAddNewSite() throws Exception {
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

        // Time out after a minute
        binding.setTimeout(60000);

        // Test operation
        java.lang.String value = null;
        value = binding.addNewSite(new java.lang.String(), new java.lang.String(), new java.lang.String(), new java.lang.String(), new java.lang.String(), new java.lang.String(), new java.lang.String(), true, new java.lang.String(), true, true, new java.lang.String(), new java.lang.String());
        // TBD - validate results
    }

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

        // Time out after a minute
        binding.setTimeout(60000);

        // Test operation
        java.lang.String value = null;
        value = binding.checkSession(new java.lang.String());
        // TBD - validate results
    }

    public void test20SakaiScriptChangeUserInfo() throws Exception {
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

        // Time out after a minute
        binding.setTimeout(60000);

        // Test operation
        java.lang.String value = null;
        value = binding.changeUserInfo(new java.lang.String(), new java.lang.String(), new java.lang.String(), new java.lang.String(), new java.lang.String(), new java.lang.String(), new java.lang.String());
        // TBD - validate results
    }

    public void test21SakaiScriptChangeUserName() throws Exception {
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

        // Time out after a minute
        binding.setTimeout(60000);

        // Test operation
        java.lang.String value = null;
        value = binding.changeUserName(new java.lang.String(), new java.lang.String(), new java.lang.String(), new java.lang.String());
        // TBD - validate results
    }

    public void test22SakaiScriptChangeUserEmail() throws Exception {
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

        // Time out after a minute
        binding.setTimeout(60000);

        // Test operation
        java.lang.String value = null;
        value = binding.changeUserEmail(new java.lang.String(), new java.lang.String(), new java.lang.String());
        // TBD - validate results
    }

    public void test23SakaiScriptChangeUserType() throws Exception {
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

        // Time out after a minute
        binding.setTimeout(60000);

        // Test operation
        java.lang.String value = null;
        value = binding.changeUserType(new java.lang.String(), new java.lang.String(), new java.lang.String());
        // TBD - validate results
    }

    public void test24SakaiScriptChangeUserPassword() throws Exception {
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

        // Time out after a minute
        binding.setTimeout(60000);

        // Test operation
        java.lang.String value = null;
        value = binding.changeUserPassword(new java.lang.String(), new java.lang.String(), new java.lang.String());
        // TBD - validate results
    }

    public void test25SakaiScriptAddGroupToSite() throws Exception {
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

        // Time out after a minute
        binding.setTimeout(60000);

        // Test operation
        java.lang.String value = null;
        value = binding.addGroupToSite(new java.lang.String(), new java.lang.String(), new java.lang.String(), new java.lang.String());
        // TBD - validate results
    }

    public void test26SakaiScriptGetGroupsInSite() throws Exception {
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

        // Time out after a minute
        binding.setTimeout(60000);

        // Test operation
        java.lang.String value = null;
        value = binding.getGroupsInSite(new java.lang.String(), new java.lang.String());
        // TBD - validate results
    }

    public void test27SakaiScriptAddNewAuthzGroup() throws Exception {
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

        // Time out after a minute
        binding.setTimeout(60000);

        // Test operation
        java.lang.String value = null;
        value = binding.addNewAuthzGroup(new java.lang.String(), new java.lang.String());
        // TBD - validate results
    }

    public void test28SakaiScriptAddNewRoleToAuthzGroup() throws Exception {
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

        // Time out after a minute
        binding.setTimeout(60000);

        // Test operation
        java.lang.String value = null;
        value = binding.addNewRoleToAuthzGroup(new java.lang.String(), new java.lang.String(), new java.lang.String(), new java.lang.String());
        // TBD - validate results
    }

    public void test29SakaiScriptRemoveAllRolesFromAuthzGroup() throws Exception {
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

        // Time out after a minute
        binding.setTimeout(60000);

        // Test operation
        java.lang.String value = null;
        value = binding.removeAllRolesFromAuthzGroup(new java.lang.String(), new java.lang.String());
        // TBD - validate results
    }

    public void test30SakaiScriptRemoveRoleFromAuthzGroup() throws Exception {
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

        // Time out after a minute
        binding.setTimeout(60000);

        // Test operation
        java.lang.String value = null;
        value = binding.removeRoleFromAuthzGroup(new java.lang.String(), new java.lang.String(), new java.lang.String());
        // TBD - validate results
    }

    public void test31SakaiScriptAllowFunctionForRole() throws Exception {
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

        // Time out after a minute
        binding.setTimeout(60000);

        // Test operation
        java.lang.String value = null;
        value = binding.allowFunctionForRole(new java.lang.String(), new java.lang.String(), new java.lang.String(), new java.lang.String());
        // TBD - validate results
    }

    public void test32SakaiScriptDisallowAllFunctionsForRole() throws Exception {
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

        // Time out after a minute
        binding.setTimeout(60000);

        // Test operation
        java.lang.String value = null;
        value = binding.disallowAllFunctionsForRole(new java.lang.String(), new java.lang.String(), new java.lang.String());
        // TBD - validate results
    }

    public void test33SakaiScriptDisallowFunctionForRole() throws Exception {
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

        // Time out after a minute
        binding.setTimeout(60000);

        // Test operation
        java.lang.String value = null;
        value = binding.disallowFunctionForRole(new java.lang.String(), new java.lang.String(), new java.lang.String(), new java.lang.String());
        // TBD - validate results
    }

    public void test34SakaiScriptSetRoleDescription() throws Exception {
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

        // Time out after a minute
        binding.setTimeout(60000);

        // Test operation
        java.lang.String value = null;
        value = binding.setRoleDescription(new java.lang.String(), new java.lang.String(), new java.lang.String(), new java.lang.String());
        // TBD - validate results
    }

    public void test35SakaiScriptAddMemberToAuthzGroupWithRole() throws Exception {
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

        // Time out after a minute
        binding.setTimeout(60000);

        // Test operation
        java.lang.String value = null;
        value = binding.addMemberToAuthzGroupWithRole(new java.lang.String(), new java.lang.String(), new java.lang.String(), new java.lang.String());
        // TBD - validate results
    }

    public void test36SakaiScriptRemoveMemberFromAuthzGroup() throws Exception {
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

        // Time out after a minute
        binding.setTimeout(60000);

        // Test operation
        java.lang.String value = null;
        value = binding.removeMemberFromAuthzGroup(new java.lang.String(), new java.lang.String(), new java.lang.String());
        // TBD - validate results
    }

    public void test37SakaiScriptRemoveAllMembersFromAuthzGroup() throws Exception {
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

        // Time out after a minute
        binding.setTimeout(60000);

        // Test operation
        java.lang.String value = null;
        value = binding.removeAllMembersFromAuthzGroup(new java.lang.String(), new java.lang.String());
        // TBD - validate results
    }

    public void test38SakaiScriptSetRoleForAuthzGroupMaintenance() throws Exception {
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

        // Time out after a minute
        binding.setTimeout(60000);

        // Test operation
        java.lang.String value = null;
        value = binding.setRoleForAuthzGroupMaintenance(new java.lang.String(), new java.lang.String(), new java.lang.String());
        // TBD - validate results
    }

    public void test39SakaiScriptAddMemberToSiteWithRole() throws Exception {
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

        // Time out after a minute
        binding.setTimeout(60000);

        // Test operation
        java.lang.String value = null;
        value = binding.addMemberToSiteWithRole(new java.lang.String(), new java.lang.String(), new java.lang.String(), new java.lang.String());
        // TBD - validate results
    }

    public void test40SakaiScriptCopySite() throws Exception {
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

        // Time out after a minute
        binding.setTimeout(60000);

        // Test operation
        java.lang.String value = null;
        value = binding.copySite(new java.lang.String(), new java.lang.String(), new java.lang.String(), new java.lang.String(), new java.lang.String(), new java.lang.String(), new java.lang.String(), new java.lang.String(), true, new java.lang.String(), true, true, new java.lang.String(), new java.lang.String());
        // TBD - validate results
    }

    public void test41SakaiScriptAddNewPageToSite() throws Exception {
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

        // Time out after a minute
        binding.setTimeout(60000);

        // Test operation
        java.lang.String value = null;
        value = binding.addNewPageToSite(new java.lang.String(), new java.lang.String(), new java.lang.String(), 0);
        // TBD - validate results
    }

    public void test42SakaiScriptAddNewPageToSite() throws Exception {
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

        // Time out after a minute
        binding.setTimeout(60000);

        // Test operation
        java.lang.String value = null;
        value = binding.addNewPageToSite(new java.lang.String(), new java.lang.String(), new java.lang.String(), 0, 0, true);
        // TBD - validate results
    }

    public void test43SakaiScriptRemovePageFromSite() throws Exception {
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

        // Time out after a minute
        binding.setTimeout(60000);

        // Test operation
        java.lang.String value = null;
        value = binding.removePageFromSite(new java.lang.String(), new java.lang.String(), new java.lang.String());
        // TBD - validate results
    }

    public void test44SakaiScriptAddNewToolToPage() throws Exception {
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

        // Time out after a minute
        binding.setTimeout(60000);

        // Test operation
        java.lang.String value = null;
        value = binding.addNewToolToPage(new java.lang.String(), new java.lang.String(), new java.lang.String(), new java.lang.String(), new java.lang.String(), new java.lang.String());
        // TBD - validate results
    }

    public void test45SakaiScriptAddConfigPropertyToTool() throws Exception {
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

        // Time out after a minute
        binding.setTimeout(60000);

        // Test operation
        java.lang.String value = null;
        value = binding.addConfigPropertyToTool(new java.lang.String(), new java.lang.String(), new java.lang.String(), new java.lang.String(), new java.lang.String(), new java.lang.String());
        // TBD - validate results
    }

    public void test46SakaiScriptCheckForSite() throws Exception {
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

        // Time out after a minute
        binding.setTimeout(60000);

        // Test operation
        boolean value = false;
        value = binding.checkForSite(new java.lang.String(), new java.lang.String());
        // TBD - validate results
    }

    public void test47SakaiScriptCheckForMemberInAuthzGroupWithRole() throws Exception {
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

        // Time out after a minute
        binding.setTimeout(60000);

        // Test operation
        boolean value = false;
        value = binding.checkForMemberInAuthzGroupWithRole(new java.lang.String(), new java.lang.String(), new java.lang.String(), new java.lang.String());
        // TBD - validate results
    }

    public void test48SakaiScriptGetSitesUserCanAccess() throws Exception {
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

        // Time out after a minute
        binding.setTimeout(60000);

        // Test operation
        java.lang.String value = null;
        value = binding.getSitesUserCanAccess(new java.lang.String());
        // TBD - validate results
    }

    public void test49SakaiScriptIsSiteJoinable() throws Exception {
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

        // Time out after a minute
        binding.setTimeout(60000);

        // Test operation
        boolean value = false;
        value = binding.isSiteJoinable(new java.lang.String(), new java.lang.String());
        // TBD - validate results
    }

    public void test50SakaiScriptChangeSiteTitle() throws Exception {
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

        // Time out after a minute
        binding.setTimeout(60000);

        // Test operation
        java.lang.String value = null;
        value = binding.changeSiteTitle(new java.lang.String(), new java.lang.String(), new java.lang.String());
        // TBD - validate results
    }

    public void test51SakaiScriptChangeSiteSkin() throws Exception {
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

        // Time out after a minute
        binding.setTimeout(60000);

        // Test operation
        java.lang.String value = null;
        value = binding.changeSiteSkin(new java.lang.String(), new java.lang.String(), new java.lang.String());
        // TBD - validate results
    }

    public void test52SakaiScriptChangeSiteJoinable() throws Exception {
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

        // Time out after a minute
        binding.setTimeout(60000);

        // Test operation
        java.lang.String value = null;
        value = binding.changeSiteJoinable(new java.lang.String(), new java.lang.String(), true, new java.lang.String(), true);
        // TBD - validate results
    }

    public void test53SakaiScriptChangeSiteIconUrl() throws Exception {
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

        // Time out after a minute
        binding.setTimeout(60000);

        // Test operation
        java.lang.String value = null;
        value = binding.changeSiteIconUrl(new java.lang.String(), new java.lang.String(), new java.lang.String());
        // TBD - validate results
    }

    public void test54SakaiScriptChangeSiteDescription() throws Exception {
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

        // Time out after a minute
        binding.setTimeout(60000);

        // Test operation
        java.lang.String value = null;
        value = binding.changeSiteDescription(new java.lang.String(), new java.lang.String(), new java.lang.String());
        // TBD - validate results
    }

    public void test55SakaiScriptSetSiteProperty() throws Exception {
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

        // Time out after a minute
        binding.setTimeout(60000);

        // Test operation
        java.lang.String value = null;
        value = binding.setSiteProperty(new java.lang.String(), new java.lang.String(), new java.lang.String(), new java.lang.String());
        // TBD - validate results
    }

    public void test56SakaiScriptRemoveSiteProperty() throws Exception {
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

        // Time out after a minute
        binding.setTimeout(60000);

        // Test operation
        java.lang.String value = null;
        value = binding.removeSiteProperty(new java.lang.String(), new java.lang.String(), new java.lang.String());
        // TBD - validate results
    }

    public void test57SakaiScriptCheckForRoleInAuthzGroup() throws Exception {
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

        // Time out after a minute
        binding.setTimeout(60000);

        // Test operation
        boolean value = false;
        value = binding.checkForRoleInAuthzGroup(new java.lang.String(), new java.lang.String(), new java.lang.String());
        // TBD - validate results
    }

    public void test58SakaiScriptSearchForUsers() throws Exception {
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

        // Time out after a minute
        binding.setTimeout(60000);

        // Test operation
        java.lang.String value = null;
        value = binding.searchForUsers(new java.lang.String(), new java.lang.String(), 0, 0);
        // TBD - validate results
    }

    public void test59SakaiScriptCheckForAuthzGroup() throws Exception {
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

        // Time out after a minute
        binding.setTimeout(60000);

        // Test operation
        boolean value = false;
        value = binding.checkForAuthzGroup(new java.lang.String(), new java.lang.String());
        // TBD - validate results
    }

    public void test60SakaiScriptRemoveMemberFromSite() throws Exception {
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

        // Time out after a minute
        binding.setTimeout(60000);

        // Test operation
        java.lang.String value = null;
        value = binding.removeMemberFromSite(new java.lang.String(), new java.lang.String(), new java.lang.String());
        // TBD - validate results
    }

    public void test61SakaiScriptCheckForUserInAuthzGroup() throws Exception {
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

        // Time out after a minute
        binding.setTimeout(60000);

        // Test operation
        boolean value = false;
        value = binding.checkForUserInAuthzGroup(new java.lang.String(), new java.lang.String(), new java.lang.String());
        // TBD - validate results
    }

    public void test62SakaiScriptGetUsersInAuthzGroupWithRole() throws Exception {
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

        // Time out after a minute
        binding.setTimeout(60000);

        // Test operation
        java.lang.String value = null;
        value = binding.getUsersInAuthzGroupWithRole(new java.lang.String(), new java.lang.String(), new java.lang.String());
        // TBD - validate results
    }

    public void test63SakaiScriptGetUsersInAuthzGroup() throws Exception {
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

        // Time out after a minute
        binding.setTimeout(60000);

        // Test operation
        java.lang.String value = null;
        value = binding.getUsersInAuthzGroup(new java.lang.String(), new java.lang.String());
        // TBD - validate results
    }

    public void test64SakaiScriptCopyCalendarEvents() throws Exception {
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

        // Time out after a minute
        binding.setTimeout(60000);

        // Test operation
        java.lang.String value = null;
        value = binding.copyCalendarEvents(new java.lang.String(), new java.lang.String(), new java.lang.String());
        // TBD - validate results
    }

    public void test65SakaiScriptAddNewToolToAllWorkspaces() throws Exception {
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

        // Time out after a minute
        binding.setTimeout(60000);

        // Test operation
        java.lang.String value = null;
        value = binding.addNewToolToAllWorkspaces(new java.lang.String(), new java.lang.String(), new java.lang.String(), new java.lang.String(), 0, 0, true);
        // TBD - validate results
    }

    public void test66SakaiScriptCopyRole() throws Exception {
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

        // Time out after a minute
        binding.setTimeout(60000);

        // Test operation
        java.lang.String value = null;
        value = binding.copyRole(new java.lang.String(), new java.lang.String(), new java.lang.String(), new java.lang.String(), new java.lang.String(), true);
        // TBD - validate results
    }

    public void test67SakaiScriptCopyRole() throws Exception {
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

        // Time out after a minute
        binding.setTimeout(60000);

        // Test operation
        java.lang.String value = null;
        value = binding.copyRole(new java.lang.String(), new java.lang.String(), new java.lang.String(), new java.lang.String(), new java.lang.String());
        // TBD - validate results
    }

    public void test68SakaiScriptGetAllUsers() throws Exception {
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

        // Time out after a minute
        binding.setTimeout(60000);

        // Test operation
        java.lang.String value = null;
        value = binding.getAllUsers(new java.lang.String());
        // TBD - validate results
    }

    public void test69SakaiScriptGetSessionForUser() throws Exception {
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

        // Time out after a minute
        binding.setTimeout(60000);

        // Test operation
        java.lang.String value = null;
        value = binding.getSessionForUser(new java.lang.String(), new java.lang.String());
        // TBD - validate results
    }

    public void test70SakaiScriptGetPagesAndToolsForSite() throws Exception {
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

        // Time out after a minute
        binding.setTimeout(60000);

        // Test operation
        java.lang.String value = null;
        value = binding.getPagesAndToolsForSite(new java.lang.String(), new java.lang.String());
        // TBD - validate results
    }

    public void test71SakaiScriptGetPagesAndToolsForSite() throws Exception {
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

        // Time out after a minute
        binding.setTimeout(60000);

        // Test operation
        java.lang.String value = null;
        value = binding.getPagesAndToolsForSite(new java.lang.String(), new java.lang.String(), new java.lang.String());
        // TBD - validate results
    }
    */

}
