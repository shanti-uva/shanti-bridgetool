// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package edu.virginia.shanti.om.bridge.form;

import java.lang.String;

privileged aspect GestaltBean_Roo_ToString {
    
    public String GestaltBean.toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("LocalContext: ").append(getLocalContext()).append(", ");
        sb.append("LocalSubContext: ").append(getLocalSubContext()).append(", ");
        sb.append("RemoteService: ").append(getRemoteService()).append(", ");
        sb.append("Timestamp: ").append(getTimestamp()).append(", ");
        sb.append("User: ").append(getUser());
        return sb.toString();
    }
    
}
