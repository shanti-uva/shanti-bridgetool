// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package edu.virginia.shanti.om.bridge.domain;

import java.lang.String;

privileged aspect RemoteContext_Roo_ToString {
    
    public String RemoteContext.toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ContextId: ").append(getContextId()).append(", ");
        sb.append("ContextLabel: ").append(getContextLabel()).append(", ");
        sb.append("RemoteContextChoice: ").append(getRemoteContextChoice()).append(", ");
        sb.append("RemoteName: ").append(getRemoteName()).append(", ");
        sb.append("Url: ").append(getUrl());
        return sb.toString();
    }
    
}
