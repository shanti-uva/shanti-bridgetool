// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package edu.virginia.shanti.om.bridge.service;

import java.lang.String;

privileged aspect BridgeService_Roo_ToString {
    
    public String BridgeService.toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Log: ").append(getLog()).append(", ");
        sb.append("PermissionMapService: ").append(getPermissionMapService()).append(", ");
        sb.append("RemoteServerService: ").append(getRemoteServerService()).append(", ");
        sb.append("SiteAliasService: ").append(getSiteAliasService());
        return sb.toString();
    }
    
}
