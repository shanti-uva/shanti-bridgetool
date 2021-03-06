// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package edu.virginia.shanti.om.bridge.domain;

import edu.virginia.shanti.om.bridge.domain.Bridge;
import edu.virginia.shanti.om.bridge.domain.PermissionMapDataOnDemand;
import java.util.List;
import java.util.Random;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

privileged aspect BridgeDataOnDemand_Roo_DataOnDemand {
    
    declare @type: BridgeDataOnDemand: @Component;
    
    private Random BridgeDataOnDemand.rnd = new java.security.SecureRandom();
    
    private List<Bridge> BridgeDataOnDemand.data;
    
    @Autowired
    private PermissionMapDataOnDemand BridgeDataOnDemand.permissionMapDataOnDemand;
    
    public Bridge BridgeDataOnDemand.getNewTransientBridge(int index) {
        edu.virginia.shanti.om.bridge.domain.Bridge obj = new edu.virginia.shanti.om.bridge.domain.Bridge();
        setBridgeToolPermissionEvaluator(obj, index);
        setCurrentUser(obj, index);
        setRemoteName(obj, index);
        setLocalContext(obj, index);
        setLocalSubContext(obj, index);
        setRemoteContext(obj, index);
        setPermissionMap(obj, index);
        setInFrame(obj, index);
        setSiteAlias(obj, index);
        setPreLoginUrl(obj, index);
        return obj;
    }
    
    private void BridgeDataOnDemand.setBridgeToolPermissionEvaluator(Bridge obj, int index) {
        edu.virginia.shanti.om.bridge.auth.BridgeToolPermissionEvaluator bridgeToolPermissionEvaluator = null;
        obj.setBridgeToolPermissionEvaluator(bridgeToolPermissionEvaluator);
    }
    
    private void BridgeDataOnDemand.setCurrentUser(Bridge obj, int index) {
        edu.virginia.shanti.om.bridge.service.CurrentUser currentUser = null;
        obj.setCurrentUser(currentUser);
    }
    
    private void BridgeDataOnDemand.setRemoteName(Bridge obj, int index) {
        java.lang.String remoteName = "remoteName_" + index;
        obj.setRemoteName(remoteName);
    }
    
    private void BridgeDataOnDemand.setLocalContext(Bridge obj, int index) {
        java.lang.String localContext = "localContext_" + index;
        obj.setLocalContext(localContext);
    }
    
    private void BridgeDataOnDemand.setLocalSubContext(Bridge obj, int index) {
        java.lang.String localSubContext = "localSubContext_" + index;
        obj.setLocalSubContext(localSubContext);
    }
    
    private void BridgeDataOnDemand.setRemoteContext(Bridge obj, int index) {
        edu.virginia.shanti.om.bridge.domain.RemoteContext remoteContext = null;
        obj.setRemoteContext(remoteContext);
    }
    
    private void BridgeDataOnDemand.setPermissionMap(Bridge obj, int index) {
        edu.virginia.shanti.om.bridge.domain.PermissionMap permissionMap = permissionMapDataOnDemand.getRandomPermissionMap();
        obj.setPermissionMap(permissionMap);
    }
    
    private void BridgeDataOnDemand.setInFrame(Bridge obj, int index) {
        java.lang.Boolean inFrame = true;
        obj.setInFrame(inFrame);
    }
    
    private void BridgeDataOnDemand.setSiteAlias(Bridge obj, int index) {
        edu.virginia.shanti.om.bridge.domain.SiteAlias siteAlias = null;
        obj.setSiteAlias(siteAlias);
    }
    
    private void BridgeDataOnDemand.setPreLoginUrl(Bridge obj, int index) {
        java.lang.String preLoginUrl = "preLoginUrl_" + index;
        obj.setPreLoginUrl(preLoginUrl);
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
