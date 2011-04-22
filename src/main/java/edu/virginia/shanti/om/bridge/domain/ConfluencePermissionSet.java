package edu.virginia.shanti.om.bridge.domain;

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
	
	private Boolean viewSpace = false;

	private Boolean comment = false;

	private Boolean editSpace = false;

	private Boolean setSpacePermissions = false;

	private Boolean removePage = false;

	private Boolean removeComment = false;

	private Boolean removeBlog = false;

	private Boolean createAttachment = false;

	private Boolean removeAttachment = false;

	private Boolean editBlog = false;

	private Boolean exportPage = false;

	private Boolean exportSpace = false;

	private Boolean removeMail = false;

	private Boolean setPagePermissions = false;

}
