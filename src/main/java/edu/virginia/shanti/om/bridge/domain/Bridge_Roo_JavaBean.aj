// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package edu.virginia.shanti.om.bridge.domain;

import edu.virginia.shanti.om.bridge.domain.RemoteContext;
import java.lang.String;

privileged aspect Bridge_Roo_JavaBean {
    
    public String Bridge.getRemoteName() {
        return this.remoteName;
    }
    
    public void Bridge.setRemoteName(String remoteName) {
        this.remoteName = remoteName;
    }
    
    public String Bridge.getLocalContext() {
        return this.localContext;
    }
    
    public void Bridge.setLocalContext(String localContext) {
        this.localContext = localContext;
    }
    
    public String Bridge.getLocalSubContext() {
        return this.localSubContext;
    }
    
    public void Bridge.setLocalSubContext(String localSubContext) {
        this.localSubContext = localSubContext;
    }
    
    public RemoteContext Bridge.getRemoteContext() {
        return this.remoteContext;
    }
    
    public void Bridge.setRemoteContext(RemoteContext remoteContext) {
        this.remoteContext = remoteContext;
    }
    
}
