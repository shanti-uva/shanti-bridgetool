/**
 * UVa Sakai Extension Client.
 */

package edu.virginia.shanti.om.bridge.auth.sakai;

import java.io.IOException;
import java.io.StringReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.rmi.RemoteException;

import javax.xml.rpc.ServiceException;

import org.apache.axis.client.Call;
import org.apache.axis.client.Service;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;

public class ExtensionClient {

	private LinktoolFormValues linktoolPackage = null;

	private String decryptedSakaiSessionId = null;

	private Log log = LogFactory.getLog(ExtensionClient.class);

	private boolean debug = log.isDebugEnabled();

	/**
	 * Constructor
	 * 
	 * @param v
	 *            an object of type LinktoolFormValues
	 */
	public ExtensionClient(LinktoolFormValues v) {
		setLinktoolPackage(v);
	}

	public LinktoolFormValues getLinktoolPackage() {
		return linktoolPackage;
	}

	public void setLinktoolPackage(LinktoolFormValues linktoolPackage) {
		this.linktoolPackage = linktoolPackage;
	}

	public boolean authenticate() throws Exception {

		String authenticateResult = null;
		try {
			Service service = new Service();
			Call call = (Call) service.createCall();

			call.setOperationName("testsign");
			call
					.setTargetEndpointAddress(new java.net.URL(
							getSakaiSigningUrl()));
			
			System.err.println ("SAKAISIGNING URL = " + getSakaiSigningUrl());
			
			
			authenticateResult = (String) call
					.invoke(new Object[] { getLinktoolPackage()
							.getKeyValueString() });
			if (authenticateResult.equalsIgnoreCase("stale value")) {
				log.warn("stale value found!");
				authenticateResult = "false";
			}
			if (!Boolean.parseBoolean(authenticateResult)) {
				return false;
			}
			return true;
		} catch (MalformedURLException e) {
			log.warn(e);
			throw e;
		} catch (RemoteException e) {
			log.warn(e);
			throw e;
		} catch (ServiceException e) {
			log.warn(e);
			throw e;
		} catch (Exception e) {
			log.warn(e);
			throw e;
		}
	}

	public SakaiUserInfo getSakaiUserInfo() throws Exception {
		if (debug) {
			log.debug("---ExtensionClient.getSakaiUserInfo()");
		}

		try {
			if (!authenticate()) {
				throw new Exception("Not authenticated!");
			}
		} catch (Exception e) {
			log.warn(e);
			throw e;
		}
		String decryptSessionResult = null;
		
		log.warn("calling decryptSession with " + getLinktoolPackage());
		
		try {
			Service service = new Service();
			Call call = (Call) service.createCall();
			call.setOperationName("decryptSession");
			call.setTargetEndpointAddress(new URL(getSakaiSigningUrl()));
			decryptSessionResult = (String) call
					.invoke(new Object[] { getLinktoolPackage().getSession() });
			setDecryptedSakaiSessionId(decryptSessionResult);

		} catch (MalformedURLException e) {
			throw e;
		} catch (RemoteException e) {
			throw e;
		} catch (ServiceException e) {
			throw e;
		}
		String getUserInfoResult = null;
		try {
			System.err.println("decrypted session id =" + getDecryptedSakaiSessionId());
			Service service = new Service();
			Call call = (Call) service.createCall();
			call.setOperationName("extensionOperation");
			call
					.setTargetEndpointAddress(new URL(
							getSakaiOperationServiceUrl()));
			getUserInfoResult = (String) call.invoke(new Object[] {
					"public/getUserInfo", getDecryptedSakaiSessionId() });
		} catch (MalformedURLException e) {
			throw e;
		} catch (RemoteException e) {
			throw e;
		} catch (ServiceException e) {
			throw e;
		}
		
		Document resultDocument = null;
		StringReader resultReader = new StringReader(getUserInfoResult);
		SAXBuilder thisSAXBuilder = new SAXBuilder();
		try {
			resultDocument = thisSAXBuilder.build(resultReader);
		} catch (JDOMException e) {
			throw e;
		} catch (IOException e) {
			throw e;
		}
		Element resultRoot = resultDocument.getRootElement();
		Element userInfoElement = resultRoot
				.getChild("LoggedInUserInformation");
		String eid = userInfoElement.getAttributeValue("eid");
		String email = userInfoElement.getAttributeValue("email");
		String firstName = userInfoElement.getAttributeValue("firstName");
		String lastName = userInfoElement.getAttributeValue("lastName");
		String type = userInfoElement.getAttributeValue("type");
		String siteId = getLinktoolPackage().getSite();
		String serverId = getLinktoolPackage().getServerId();
		String serverUrl = getLinktoolPackage().getServerurl();
		SakaiUserInfo info = new SakaiUserInfo(eid, firstName,
				lastName, getDecryptedSakaiSessionId(), email, type, siteId, serverUrl, serverId);

		return info;
	}

	private String getSakaiSigningUrl() {
		return "https://" + getLinktoolPackage().getServerId()
				+ ".itc.virginia.edu" + "/sakai-axis/SakaiSigning.jws";
	}

	private String getSakaiOperationServiceUrl() {
		return "https://" + getLinktoolPackage().getServerId()
				+ ".itc.virginia.edu" + "/sakai-axis/SakaiOperationService.jws";
	}

	public String getDecryptedSakaiSessionId() {
		return decryptedSakaiSessionId;
	}

	public void setDecryptedSakaiSessionId(String decryptedSakaiSessionId) {
		this.decryptedSakaiSessionId = decryptedSakaiSessionId;
	}
}