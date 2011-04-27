// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package edu.virginia.shanti.om.bridge.web;

import java.lang.String;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

privileged aspect BridgeController_Roo_Controller_Finder {
    
    @RequestMapping(params = { "find=ByLocalContext", "form" }, method = RequestMethod.GET)
    public String BridgeController.findBridgesByLocalContextForm(Model uiModel) {
        return "bridges/findBridgesByLocalContext";
    }
    
    @RequestMapping(params = { "find=ByLocalSubContext", "form" }, method = RequestMethod.GET)
    public String BridgeController.findBridgesByLocalSubContextForm(Model uiModel) {
        return "bridges/findBridgesByLocalSubContext";
    }
    
}
