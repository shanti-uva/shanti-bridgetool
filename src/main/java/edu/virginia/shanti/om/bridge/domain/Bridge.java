package edu.virginia.shanti.om.bridge.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.roo.addon.entity.RooEntity;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.serializable.RooSerializable;
import org.springframework.roo.addon.tostring.RooToString;
import org.springframework.security.access.prepost.PreAuthorize;

import edu.virginia.shanti.om.bridge.auth.BridgeToolPermissionEvaluator;
import edu.virginia.shanti.om.bridge.domain.PermissionMap;
import edu.virginia.shanti.om.bridge.service.CurrentUser;

@RooJavaBean
@RooToString
@RooSerializable
@Table(name = "bridge", uniqueConstraints = { @UniqueConstraint(columnNames = { "localContext", "localSubContext" }) })
@RooEntity(finders = { "findBridgesByLocalContext", "findBridgesByLocalSubContext" })
public class Bridge implements Serializable {

    /**
	 * 
	 */
    private static final long serialVersionUID = 471402102713234589L;

    /** the name of the remote instance */
    private String remoteName;
    
    @Autowired
    transient private BridgeToolPermissionEvaluator bridgeToolPermissionEvaluator;
    
    public void setBridgeToolPermissionEvaluator(
			BridgeToolPermissionEvaluator bridgeToolPermissionEvaluator) {
		this.bridgeToolPermissionEvaluator = bridgeToolPermissionEvaluator;
	}


	public void setCurrentUser(CurrentUser currentUser) {
		this.currentUser = currentUser;
	}


	@Autowired
    transient private CurrentUser currentUser;
    
    /** primary local context: e.g. Sakai siteId */
    @NotNull
    private String localContext;

    /** local subcontext: e.g. Sakai toolPlacementId */
    @NotNull
    @Column(unique = true)
    private String localSubContext;

    /** remote context: e.g. confluence space identifier */
    @ManyToOne
    private RemoteContext remoteContext;

    /** permission map: sets of permissions that apply to this Bridged context */
    @ManyToOne
    private PermissionMap permissionMap;
    
    
    public boolean isAdmin() {
    	return bridgeToolPermissionEvaluator.hasPermission(currentUser.getAuthentication(), this, "admin");
    }
    
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("LocalContext: ").append(getLocalContext()).append(", ");
        sb.append("LocalSubContext: ").append(getLocalSubContext()).append(", ");
        sb.append("PermissionMap: ").append(getPermissionMap()).append(", ");
        sb.append("RemoteContext: ").append(getRemoteContext()).append(", ");
        sb.append("RemoteName: ").append(getRemoteName()).append(", ");
        // sb.append("Admin: ").append(isAdmin());
        return sb.toString();
    }
    
    
    
}
