/**
 * SudoSoapServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package edu.virginia.shanti.om.bridge.soap.sakai;

public class SudoSoapServiceLocator extends org.apache.axis.client.Service implements edu.virginia.shanti.om.bridge.soap.sakai.SudoSoapService {

    public SudoSoapServiceLocator() {
    }


    public SudoSoapServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public SudoSoapServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for sudo
    private java.lang.String sudo_address = "https://wiki.shanti.virginia.edu/rpc/soap-axis/sudo";

    public java.lang.String getsudoAddress() {
        return sudo_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String sudoWSDDServiceName = "sudo";

    public java.lang.String getsudoWSDDServiceName() {
        return sudoWSDDServiceName;
    }

    public void setsudoWSDDServiceName(java.lang.String name) {
        sudoWSDDServiceName = name;
    }

    public edu.virginia.shanti.om.bridge.soap.sakai.SudoSoap getsudo() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(sudo_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getsudo(endpoint);
    }

    public edu.virginia.shanti.om.bridge.soap.sakai.SudoSoap getsudo(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            edu.virginia.shanti.om.bridge.soap.sakai.SudoSoapBindingStub _stub = new edu.virginia.shanti.om.bridge.soap.sakai.SudoSoapBindingStub(portAddress, this);
            _stub.setPortName(getsudoWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setsudoEndpointAddress(java.lang.String address) {
        sudo_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (edu.virginia.shanti.om.bridge.soap.sakai.SudoSoap.class.isAssignableFrom(serviceEndpointInterface)) {
                edu.virginia.shanti.om.bridge.soap.sakai.SudoSoapBindingStub _stub = new edu.virginia.shanti.om.bridge.soap.sakai.SudoSoapBindingStub(new java.net.URL(sudo_address), this);
                _stub.setPortName(getsudoWSDDServiceName());
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
        if ("sudo".equals(inputPortName)) {
            return getsudo();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("https://wiki.shanti.virginia.edu/rpc/soap-axis/sudo", "SudoSoapService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("https://wiki.shanti.virginia.edu/rpc/soap-axis/sudo", "sudo"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("sudo".equals(portName)) {
            setsudoEndpointAddress(address);
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
