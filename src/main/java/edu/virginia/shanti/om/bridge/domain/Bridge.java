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

@RooJavaBean
@RooToString
@RooSerializable
@RooEntity(finders = { "findBridgesByLocalContext" })
@Table(name = "bridge", uniqueConstraints = { @UniqueConstraint(columnNames = {
		"localContext", "localSubContext" }) })
public class Bridge implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 471402102713234589L;

	/** adapter implementation of this bridge */
	// private String implementationName;

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

}
