/**
 * SakaiScriptService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package edu.virginia.shanti.om.bridge.soap.sakai;

public interface SakaiScriptService extends javax.xml.rpc.Service {
    public java.lang.String getSakaiScriptAddress();

    public edu.virginia.shanti.om.bridge.soap.sakai.SakaiScript_PortType getSakaiScript() throws javax.xml.rpc.ServiceException;

    public edu.virginia.shanti.om.bridge.soap.sakai.SakaiScript_PortType getSakaiScript(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
