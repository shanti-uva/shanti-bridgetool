// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package edu.virginia.shanti.om.bridge.domain;

import java.lang.String;

privileged aspect RemoteServer_Roo_ToString {
    
    public String RemoteServer.toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ImplementationName: ").append(getImplementationName()).append(", ");
        sb.append("RemoteName: ").append(getRemoteName()).append(", ");
        sb.append("RemoteUrl: ").append(getRemoteUrl());
        return sb.toString();
    }
    
}
