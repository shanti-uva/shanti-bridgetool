package edu.virginia.shanti.om.bridge.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.NotNull;
import org.springframework.roo.addon.entity.RooEntity;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.serializable.RooSerializable;
import org.springframework.roo.addon.tostring.RooToString;
import edu.virginia.shanti.om.bridge.domain.PermissionMap;

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
}
