/**
 * SakaiScriptServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package edu.virginia.shanti.om.bridge.soap.sakai;

import org.apache.axis.client.Call;

public class SakaiScriptServiceLocator extends org.apache.axis.client.Service implements edu.virginia.shanti.om.bridge.soap.sakai.SakaiScriptService {

    public SakaiScriptServiceLocator() {
    }


    public SakaiScriptServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public SakaiScriptServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for SakaiScript
    private java.lang.String SakaiScript_address = "https://collab-dev.its.virginia.edu/sakai-ws/soap/sakai";

    public java.lang.String getSakaiScriptAddress() {
        return SakaiScript_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String SakaiScriptWSDDServiceName = "SakaiScript";

    public java.lang.String getSakaiScriptWSDDServiceName() {
        return SakaiScriptWSDDServiceName;
    }

    public void setSakaiScriptWSDDServiceName(java.lang.String name) {
        SakaiScriptWSDDServiceName = name;
    }

    public edu.virginia.shanti.om.bridge.soap.sakai.SakaiScript_PortType getSakaiScript() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(SakaiScript_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getSakaiScript(endpoint);
    }

    public edu.virginia.shanti.om.bridge.soap.sakai.SakaiScript_PortType getSakaiScript(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            edu.virginia.shanti.om.bridge.soap.sakai.SakaiScriptSoapBindingStub _stub = new edu.virginia.shanti.om.bridge.soap.sakai.SakaiScriptSoapBindingStub(portAddress, this);
            _stub.setPortName(getSakaiScriptWSDDServiceName());
            _stub._setProperty(Call.SESSION_MAINTAIN_PROPERTY, new Boolean(true));
            _stub.setMaintainSession(true);
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setSakaiScriptEndpointAddress(java.lang.String address) {
        SakaiScript_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (edu.virginia.shanti.om.bridge.soap.sakai.SakaiScript_PortType.class.isAssignableFrom(serviceEndpointInterface)) {
                edu.virginia.shanti.om.bridge.soap.sakai.SakaiScriptSoapBindingStub _stub = new edu.virginia.shanti.om.bridge.soap.sakai.SakaiScriptSoapBindingStub(new java.net.URL(SakaiScript_address), this);
                _stub.setPortName(getSakaiScriptWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("SakaiScript".equals(inputPortName)) {
            return getSakaiScript();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("https://collab-dev.its.virginia.edu/sakai-ws/soap/sakai", "SakaiScriptService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("https://collab-dev.its.virginia.edu/sakai-ws/soap/sakai", "SakaiScript"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("SakaiScript".equals(portName)) {
            setSakaiScriptEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
