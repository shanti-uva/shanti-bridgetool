// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package edu.virginia.shanti.om.bridge.webflow;

import edu.virginia.shanti.om.bridge.service.RemoteServerService;

privileged aspect RemoteServerFlowService_Roo_JavaBean {
    
    public RemoteServerService RemoteServerFlowService.getRemoteServerService() {
        return this.remoteServerService;
    }
    
    public void RemoteServerFlowService.setRemoteServerService(RemoteServerService remoteServerService) {
        this.remoteServerService = remoteServerService;
    }
    
}
