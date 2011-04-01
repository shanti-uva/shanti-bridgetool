/**
 * SakaiLoginService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package edu.virginia.shanti.om.bridge.soap.sakai;

public interface SakaiLoginService extends javax.xml.rpc.Service {
    public java.lang.String getSakaiLoginAddress();

    public edu.virginia.shanti.om.bridge.soap.sakai.SakaiLogin_PortType getSakaiLogin() throws javax.xml.rpc.ServiceException;

    public edu.virginia.shanti.om.bridge.soap.sakai.SakaiLogin_PortType getSakaiLogin(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
