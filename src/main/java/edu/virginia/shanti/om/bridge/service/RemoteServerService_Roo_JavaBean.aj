// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package edu.virginia.shanti.om.bridge.service;

import edu.virginia.shanti.om.bridge.service.CurrentUser;
import org.springframework.context.ApplicationContext;

privileged aspect RemoteServerService_Roo_JavaBean {
    
    public ApplicationContext RemoteServerService.getApplicationContext() {
        return this.applicationContext;
    }
    
    public void RemoteServerService.setApplicationContext(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }
    
    public CurrentUser RemoteServerService.getCurrentUser() {
        return this.currentUser;
    }
    
    public void RemoteServerService.setCurrentUser(CurrentUser currentUser) {
        this.currentUser = currentUser;
    }
    
}
