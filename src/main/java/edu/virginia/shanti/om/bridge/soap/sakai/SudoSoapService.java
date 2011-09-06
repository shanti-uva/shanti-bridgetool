/**
 * SudoSoapService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package edu.virginia.shanti.om.bridge.soap.sakai;

public interface SudoSoapService extends javax.xml.rpc.Service {
    public java.lang.String getsudoAddress();

    public edu.virginia.shanti.om.bridge.soap.sakai.SudoSoap getsudo() throws javax.xml.rpc.ServiceException;

    public edu.virginia.shanti.om.bridge.soap.sakai.SudoSoap getsudo(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
