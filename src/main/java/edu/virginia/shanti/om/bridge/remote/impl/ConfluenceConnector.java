package edu.virginia.shanti.om.bridge.remote.impl;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import javax.xml.rpc.ServiceException;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.roo.addon.serializable.RooSerializable;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import edu.virginia.shanti.om.bridge.domain.RemoteContext;
import edu.virginia.shanti.om.bridge.domain.RemoteServer;
import edu.virginia.shanti.om.bridge.form.RemoteContextChoice;
import edu.virginia.shanti.om.bridge.remote.RemoteConnector;
import edu.virginia.shanti.om.bridge.remote.RemotePermissions;
import edu.virginia.shanti.om.bridge.soap.confluence.AuthenticationFailedException;
import edu.virginia.shanti.om.bridge.soap.confluence.ConfluenceSoapService;
import edu.virginia.shanti.om.bridge.soap.confluence.ConfluenceSoapServiceServiceLocator;
import edu.virginia.shanti.om.bridge.soap.confluence.RemoteException;
import edu.virginia.shanti.om.bridge.soap.confluence.RemoteSpace;
import edu.virginia.shanti.om.bridge.soap.confluence.RemoteSpaceSummary;
import edu.virginia.shanti.om.bridge.soap.confluence.SudoSoapServiceLocator;

@Service
@Component
@RooSerializable
public class ConfluenceConnector implements RemoteConnector {

	private static final long serialVersionUID = 7461979436195181130L;

	private Log log = LogFactory.getLog(ConfluenceConnector.class);

	// @Value("#{appConfiguration.adminUser}")
	@Value("${adminUser}")
	public String adminUser;

	// @Value("#{appConfiguration.adminPassword}")

	@Value("${adminPassword}")
	public String adminPassword;

	transient private ConfluenceSoapServiceServiceLocator confLocator;

	transient private SudoSoapServiceLocator sudoLocator;

	public ConfluenceConnector() {
		super();
		confLocator = new ConfluenceSoapServiceServiceLocator();
		sudoLocator = new SudoSoapServiceLocator();
	}

	public ConfluenceConnector(String baseUrl) {
		this();
		getConfLocator().setConfluenceserviceV1EndpointAddress(baseUrl
				+ "/rpc/soap-axis/confluenceservice-v1");
	}

	private ConfluenceSoapServiceServiceLocator getConfLocator() {
		if (confLocator == null) {
			confLocator = new ConfluenceSoapServiceServiceLocator();
		}
		return confLocator;
	}

	@Override
	public List<RemoteContextChoice> getContexts(RemoteServer remoteServer) {
		try {
			ConfluenceSoapService conf = getConfLocator().getConfluenceserviceV1();
			String sess = login(conf);

			RemoteSpaceSummary[] spaces = conf.getSpaces(sess);

			List<RemoteContextChoice> list = new LinkedList<RemoteContextChoice>();

			for (RemoteSpaceSummary summary : spaces) {

				System.err.print(summary);

				RemoteContextChoice choice = new RemoteContextChoice();
				choice.setContextId(summary.getKey());
				choice.setContextLabel(summary.getName());
				choice.setRemoteName(remoteServer.getRemoteName());
				choice.setUrl(summary.getUrl());

				list.add(choice);

			}
			return list;

		} catch (ServiceException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (AuthenticationFailedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (java.rmi.RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * edu.virginia.shanti.om.bridge.remote.RemoteConnector#createRemoteContext
	 * (edu.virginia.shanti.om.bridge.domain.RemoteContext)
	 */
	@Transactional(propagation = Propagation.REQUIRES_NEW)
	@Override
	public RemoteContext createRemoteContext(RemoteContext newContext) {
		try {

			// TODO: use remote server attribute of new context to
			// determine/verify
			// which server to contact

			ConfluenceSoapService conf = getConfLocator().getConfluenceserviceV1();
			String sess = login(conf);
			RemoteSpace rs = new RemoteSpace();
			rs.setKey(newContext.getContextId());
			rs.setName(newContext.getContextLabel());
			rs.setDescription("Auto-generated space which needs more of a description.");
			RemoteSpace newSpace = conf.addSpace(sess, rs);
			try {
				conf.logout(sess);
			} catch (RemoteException e) {
				// ignore
				e.printStackTrace();
			} catch (java.rmi.RemoteException e) {
				// ignore
				e.printStackTrace();
			}
			newContext.setUrl(newSpace.getUrl());
			newContext.persist();
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

		return newContext;
	}

	private String login(ConfluenceSoapService conf)
			throws java.rmi.RemoteException, AuthenticationFailedException,
			RemoteException {
		String sess = conf.login(adminUser, adminPassword);
		System.err.println("XXXXXXXXXXXX  adminUser = " + adminUser);
		log.info("Logging in using user = " + adminUser);
		return sess;
	}

	@Override
	public String getSummaryMarkup(RemoteContext remoteContext) {
		ConfluenceSoapService conf;
		try {
			conf = getConfLocator().getConfluenceserviceV1();
			String sess = login(conf);

			String spacekey = remoteContext.getContextId();

			RemoteSpace space = conf.getSpace(sess, spacekey);

			long pageid = space.getHomePage();

			HashMap<String, String> params = new HashMap<String, String>();
			// params.put("style", "clean");

			String theme = ""; // "|theme=concise";

			return conf.renderContent(sess, spacekey, pageid,
					"{recently-updated-dashboard:spaces=" + spacekey + theme + "}",
					params);
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	@Override
	public RemotePermissions getRemotePermissions(RemoteContext remoteContext) {
		// TODO Auto-generated method stub
		return null;
	}

	public void removeRemoteContext(RemoteContext remoteContext) {
		ConfluenceSoapService conf;
		try {
			conf = getConfLocator().getConfluenceserviceV1();
			String sess = login(conf);
			conf.removeSpace(sess, remoteContext.getContextId());
		} catch (Exception e) {
			throw new RuntimeException(e);
		}

	}

}
