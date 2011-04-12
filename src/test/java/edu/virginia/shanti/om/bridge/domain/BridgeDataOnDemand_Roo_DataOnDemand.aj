// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package edu.virginia.shanti.om.bridge.domain;

import edu.virginia.shanti.om.bridge.domain.Bridge;
import java.util.List;
import java.util.Random;
import org.springframework.stereotype.Component;

privileged aspect BridgeDataOnDemand_Roo_DataOnDemand {
    
    declare @type: BridgeDataOnDemand: @Component;
    
    private Random BridgeDataOnDemand.rnd = new java.security.SecureRandom();
    
    private List<Bridge> BridgeDataOnDemand.data;
    
    public Bridge BridgeDataOnDemand.getNewTransientBridge(int index) {
        edu.virginia.shanti.om.bridge.domain.Bridge obj = new edu.virginia.shanti.om.bridge.domain.Bridge();
        obj.setRemoteName("remoteName_" + index);
        obj.setLocalContext("localContext_" + index);
        obj.setLocalSubContext("localSubContext_" + index);
        obj.setRemoteContext(null);
        obj.setPermissionMap(null);
        return obj;
    }
    
    public Bridge BridgeDataOnDemand.getSpecificBridge(int index) {
        init();
        if (index < 0) index = 0;
        if (index > (data.size() - 1)) index = data.size() - 1;
        Bridge obj = data.get(index);
        return Bridge.findBridge(obj.getId());
    }
    
    public Bridge BridgeDataOnDemand.getRandomBridge() {
        init();
        Bridge obj = data.get(rnd.nextInt(data.size()));
        return Bridge.findBridge(obj.getId());
    }
    
    public boolean BridgeDataOnDemand.modifyBridge(Bridge obj) {
        return false;
    }
    
    public void BridgeDataOnDemand.init() {
        data = edu.virginia.shanti.om.bridge.domain.Bridge.findBridgeEntries(0, 10);
        if (data == null) throw new IllegalStateException("Find entries implementation for 'Bridge' illegally returned null");
        if (!data.isEmpty()) {
            return;
        }
        
        data = new java.util.ArrayList<edu.virginia.shanti.om.bridge.domain.Bridge>();
        for (int i = 0; i < 10; i++) {
            edu.virginia.shanti.om.bridge.domain.Bridge obj = getNewTransientBridge(i);
            obj.persist();
            obj.flush();
            data.add(obj);
        }
    }
    
}
