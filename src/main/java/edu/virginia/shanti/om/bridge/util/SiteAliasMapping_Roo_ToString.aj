// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package edu.virginia.shanti.om.bridge.util;

import java.lang.String;

privileged aspect SiteAliasMapping_Roo_ToString {
    
    public String SiteAliasMapping.toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Alias: ").append(getAlias()).append(", ");
        sb.append("LocalContext: ").append(getLocalContext()).append(", ");
        sb.append("RemoteName: ").append(getRemoteName());
        return sb.toString();
    }
    
}
