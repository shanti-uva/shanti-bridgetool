// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package edu.virginia.shanti.om.bridge.service;

import java.lang.String;

privileged aspect RemoteServerService_Roo_ToString {
    
    public String RemoteServerService.toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("AllRemoteServers: ").append(getAllRemoteServers() == null ? "null" : getAllRemoteServers().size()).append(", ");
        sb.append("ApplicationContext: ").append(getApplicationContext()).append(", ");
        sb.append("CurrentUser: ").append(getCurrentUser());
        return sb.toString();
    }
    
}
