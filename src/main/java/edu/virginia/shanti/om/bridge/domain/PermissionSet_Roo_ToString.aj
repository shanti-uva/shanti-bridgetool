// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package edu.virginia.shanti.om.bridge.domain;

import java.lang.String;

privileged aspect PermissionSet_Roo_ToString {
    
    public String PermissionSet.toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("GroupName: ").append(getGroupName()).append(", ");
        sb.append("LocalGroupType: ").append(getLocalGroupType());
        return sb.toString();
    }
    
}