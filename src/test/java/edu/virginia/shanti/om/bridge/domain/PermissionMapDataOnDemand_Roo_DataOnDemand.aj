// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package edu.virginia.shanti.om.bridge.domain;

import edu.virginia.shanti.om.bridge.domain.PermissionMap;
import java.util.List;
import java.util.Random;
import org.springframework.stereotype.Component;

privileged aspect PermissionMapDataOnDemand_Roo_DataOnDemand {
    
    declare @type: PermissionMapDataOnDemand: @Component;
    
    private Random PermissionMapDataOnDemand.rnd = new java.security.SecureRandom();
    
    private List<PermissionMap> PermissionMapDataOnDemand.data;
    
    public PermissionMap PermissionMapDataOnDemand.getNewTransientPermissionMap(int index) {
        edu.virginia.shanti.om.bridge.domain.PermissionMap obj = new edu.virginia.shanti.om.bridge.domain.PermissionMap();
        setName(obj, index);
        setLocalContextMask(obj, index);
        setService(obj, index);
        setLocalContextType(obj, index);
        return obj;
    }
    
    private void PermissionMapDataOnDemand.setName(PermissionMap obj, int index) {
        java.lang.String name = "name_" + index;
        obj.setName(name);
    }
    
    private void PermissionMapDataOnDemand.setLocalContextMask(PermissionMap obj, int index) {
        java.lang.String localContextMask = "localContextMask_" + index;
        obj.setLocalContextMask(localContextMask);
    }
    
    private void PermissionMapDataOnDemand.setService(PermissionMap obj, int index) {
        java.lang.String service = "service_" + index;
        obj.setService(service);
    }
    
    private void PermissionMapDataOnDemand.setLocalContextType(PermissionMap obj, int index) {
        edu.virginia.shanti.om.bridge.domain.LocalContextType localContextType = edu.virginia.shanti.om.bridge.domain.LocalContextType.class.getEnumConstants()[0];
        obj.setLocalContextType(localContextType);
    }
    
    public PermissionMap PermissionMapDataOnDemand.getSpecificPermissionMap(int index) {
        init();
        if (index < 0) index = 0;
        if (index > (data.size() - 1)) index = data.size() - 1;
        PermissionMap obj = data.get(index);
        return PermissionMap.findPermissionMap(obj.getId());
    }
    
    public PermissionMap PermissionMapDataOnDemand.getRandomPermissionMap() {
        init();
        PermissionMap obj = data.get(rnd.nextInt(data.size()));
        return PermissionMap.findPermissionMap(obj.getId());
    }
    
    public boolean PermissionMapDataOnDemand.modifyPermissionMap(PermissionMap obj) {
        return false;
    }
    
    public void PermissionMapDataOnDemand.init() {
        data = edu.virginia.shanti.om.bridge.domain.PermissionMap.findPermissionMapEntries(0, 10);
        if (data == null) throw new IllegalStateException("Find entries implementation for 'PermissionMap' illegally returned null");
        if (!data.isEmpty()) {
            return;
        }
        
        data = new java.util.ArrayList<edu.virginia.shanti.om.bridge.domain.PermissionMap>();
        for (int i = 0; i < 10; i++) {
            edu.virginia.shanti.om.bridge.domain.PermissionMap obj = getNewTransientPermissionMap(i);
            obj.persist();
            obj.flush();
            data.add(obj);
        }
    }
    
}
