// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package edu.virginia.shanti.om.bridge.remote.impl;

import java.lang.String;

privileged aspect MockConfluenceConnector_Roo_ToString {
    
    public String MockConfluenceConnector.toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("ContextStore: ").append(getContextStore() == null ? "null" : getContextStore().size());
        return sb.toString();
    }
    
}