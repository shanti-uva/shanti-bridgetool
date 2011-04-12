package edu.virginia.shanti.om.bridge.domain;

import javax.persistence.Enumerated;

import org.springframework.roo.addon.entity.RooEntity;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.serializable.RooSerializable;
import org.springframework.roo.addon.tostring.RooToString;

@RooJavaBean
@RooToString
@RooEntity
@RooSerializable
public class ConfluencePermissionSet extends PermissionSet {

	private static final long serialVersionUID = 8185639652956373824L;
    
    // [VIEWSPACE, COMMENT, EDITSPACE, SETSPACEPERMISSIONS, REMOVEPAGE, REMOVECOMMENT, 
    // REMOVEBLOG, CREATEATTACHMENT, REMOVEATTACHMENT, EDITBLOG, EXPORTPAGE, EXPORTSPACE, 
    // REMOVEMAIL, SETPAGEPERMISSIONS, VIEWSPACE]
    
    private Boolean viewSpace;
    
    private Boolean comment;
    
    private Boolean editSpace;
    
    private Boolean setSpacePermissions;
    
    private Boolean removePage;
    
    private Boolean removeComment;
    
    private Boolean removeBlog;
    
    private Boolean createAttachment;
    
    private Boolean removeAttachment;
    
    private Boolean editBlog;
    
    private Boolean exportPage;
    
    private Boolean exportSpace;
    
    private Boolean removeMail;
    
    private Boolean setPagePermissions;
        
}
