// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package edu.virginia.shanti.om.bridge.webflow;

import edu.virginia.shanti.om.bridge.service.CurrentUser;
import edu.virginia.shanti.om.bridge.service.RemoteServerService;
import org.apache.commons.logging.Log;

privileged aspect RemoteServerFlowService_Roo_JavaBean {
    
    public Log RemoteServerFlowService.getLog() {
        return this.log;
    }
    
    public void RemoteServerFlowService.setLog(Log log) {
        this.log = log;
    }
    
    public RemoteServerService RemoteServerFlowService.getRemoteServerService() {
        return this.remoteServerService;
    }
    
    public void RemoteServerFlowService.setRemoteServerService(RemoteServerService remoteServerService) {
        this.remoteServerService = remoteServerService;
    }
    
    public CurrentUser RemoteServerFlowService.getCurrentUser() {
        return this.currentUser;
    }
    
    public void RemoteServerFlowService.setCurrentUser(CurrentUser currentUser) {
        this.currentUser = currentUser;
    }
    
}
