/**
 * SudoSoap.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package edu.virginia.shanti.om.bridge.soap.confluence;

public interface SudoSoap extends java.rmi.Remote {
    public boolean canUseConfluence(java.lang.String in0, java.lang.String in1) throws java.rmi.RemoteException, edu.virginia.shanti.om.bridge.soap.confluence.EntityException;
    public void sudo(java.lang.String in0, java.lang.String in1, java.lang.String in2) throws java.rmi.RemoteException, edu.virginia.shanti.om.bridge.soap.confluence.EntityException;
    public java.lang.String whoami(java.lang.String in0) throws java.rmi.RemoteException;
    public java.lang.String login(java.lang.String in0, java.lang.String in1) throws java.rmi.RemoteException, edu.virginia.shanti.om.bridge.soap.confluence.AuthenticationFailedException, edu.virginia.shanti.om.bridge.soap.confluence.RemoteException;
    public boolean logout(java.lang.String in0) throws java.rmi.RemoteException, edu.virginia.shanti.om.bridge.soap.confluence.RemoteException;
}
