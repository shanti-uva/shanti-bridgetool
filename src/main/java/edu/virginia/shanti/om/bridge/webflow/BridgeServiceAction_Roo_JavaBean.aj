// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package edu.virginia.shanti.om.bridge.webflow;

import edu.virginia.shanti.om.bridge.service.BridgeService;

privileged aspect BridgeServiceAction_Roo_JavaBean {
    
    public BridgeService BridgeServiceAction.getBridgeService() {
        return this.bridgeService;
    }
    
    public void BridgeServiceAction.setBridgeService(BridgeService bridgeService) {
        this.bridgeService = bridgeService;
    }
    
}
