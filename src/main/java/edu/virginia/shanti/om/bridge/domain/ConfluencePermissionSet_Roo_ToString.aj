// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package edu.virginia.shanti.om.bridge.domain;

import java.lang.String;

privileged aspect ConfluencePermissionSet_Roo_ToString {
    
    public String ConfluencePermissionSet.toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Id: ").append(getId()).append(", ");
        sb.append("Version: ").append(getVersion()).append(", ");
        sb.append("GroupName: ").append(getGroupName()).append(", ");
        sb.append("LocalGroupType: ").append(getLocalGroupType()).append(", ");
        sb.append("ViewSpace: ").append(getViewSpace()).append(", ");
        sb.append("Comment: ").append(getComment()).append(", ");
        sb.append("EditSpace: ").append(getEditSpace()).append(", ");
        sb.append("SetSpacePermissions: ").append(getSetSpacePermissions()).append(", ");
        sb.append("RemovePage: ").append(getRemovePage()).append(", ");
        sb.append("RemoveComment: ").append(getRemoveComment()).append(", ");
        sb.append("RemoveBlog: ").append(getRemoveBlog()).append(", ");
        sb.append("CreateAttachment: ").append(getCreateAttachment()).append(", ");
        sb.append("RemoveAttachment: ").append(getRemoveAttachment()).append(", ");
        sb.append("EditBlog: ").append(getEditBlog()).append(", ");
        sb.append("ExportPage: ").append(getExportPage()).append(", ");
        sb.append("ExportSpace: ").append(getExportSpace()).append(", ");
        sb.append("RemoveMail: ").append(getRemoveMail()).append(", ");
        sb.append("SetPagePermissions: ").append(getSetPagePermissions());
        return sb.toString();
    }
    
}
