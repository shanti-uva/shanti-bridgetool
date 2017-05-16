/**
 * UVa Sakai Extension Client.
 */

package edu.virginia.shanti.om.bridge.auth.sakai;

import java.io.IOException;
import java.io.StringReader;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLDecoder;
import java.rmi.RemoteException;

import javax.xml.rpc.ServiceException;

import org.apache.axis.client.Call;
import org.apache.axis.client.Service;
import org.apache.axis.client.Stub;
import org.apache.axis.client.Transport;
import org.apache.axis.transport.http.HTTPConstants;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;

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
		log.info(linktoolPackage);
		this.linktoolPackage = linktoolPackage;
	}

	public boolean authenticate() throws Exception {

		String authenticateResult = null;
		try {
			Service service = new Service();
			Call call = (Call) service.createCall();
			call.setMaintainSession(true);
			call.setOperationName("testsign");
			call.setTargetEndpointAddress(new java.net.URL(getSakaiSigningUrl()));
			call.setProperty(
			        org.apache.axis.client.Call.SESSION_MAINTAIN_PROPERTY, 
			        new Boolean(true));
			call.setProperty(
			        org.apache.axis.transport.http.HTTPConstants.HEADER_COOKIE,
			        "AFFINITYID=" + getSakaiAffinityID());

			log.info("AFFINITYID = " + getSakaiAffinityID()); 
			log.info("SAKAISIGNING URL = " + getSakaiSigningUrl());
			log.info("keyValueString = "
					+ getLinktoolPackage().getKeyValueString());

			authenticateResult = (String) call
					.invoke(new Object[] { getLinktoolPackage()
							.getKeyValueString() });

			log.info("authenticate result = " + authenticateResult);

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

	private String getSakaiAffinityID() {
		// TODO Auto-generated method stub
		return getLinktoolPackage().getServerId();
	}

	/**
	 * 
	 * @return
	 * @throws Exception
	 */
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

		if (getDecryptedSakaiSessionId() == null) {
			log.warn("calling decryptSession with " + getLinktoolPackage());
			try {
				Service service = new Service();
				Call call = (Call) service.createCall();
				call.setOperationName("decryptSession");
				call.setTargetEndpointAddress(new URL(getSakaiSigningUrl()));
				decryptSessionResult = (String) call
						.invoke(new Object[] { getLinktoolPackage()
								.getSession() });
				setDecryptedSakaiSessionId(decryptSessionResult);

			} catch (MalformedURLException e) {
				throw e;
			} catch (RemoteException e) {
				throw e;
			} catch (ServiceException e) {
				throw e;
			}
		}
		String getUserInfoResult = null;

		log.info("decrypted session id = "
				+ getDecryptedSakaiSessionId());

		HttpClient client = new HttpClient();
		GetMethod get = new GetMethod("https://"
				+ getLinktoolPackage().getServerId()
				+ ".itc.virginia.edu/direct/user/current.xml?sakai.session="
				+ getDecryptedSakaiSessionId());
		int ret = client.executeMethod(get);

		// check ret

		getUserInfoResult = get.getResponseBodyAsString();

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

		// XMLOutputter xout = new XMLOutputter();
		// xout.setFormat(Format.getPrettyFormat());
		// System.err.println(xout.outputString(resultRoot));
		// System.err.println(resultRoot.getChild("eid").getText());
		String eid = resultRoot.getChildText("eid");
		String email = resultRoot.getChildText("email");
		
		String firstName = resultRoot.getChildText("firstName");
		String lastName = resultRoot.getChildText("lastName");
		String type = resultRoot.getChildText("type");
		String siteId = getLinktoolPackage().getSite();
		String serverId = getLinktoolPackage().getServerId();
		String serverUrl = getLinktoolPackage().getServerurl();
		SakaiUserInfo info = new SakaiUserInfo(eid, firstName, lastName,
				getDecryptedSakaiSessionId(), email, type, siteId, serverUrl,
				serverId);

		return info;
	}

	private String getSakaiSigningUrl() {
//		return "https://" + getLinktoolPackage().getServerId()
//				+ ".itc.virginia.edu" + "/sakai-axis/SakaiSigning.jws";
		
		String serverurl;
		try {
			serverurl = URLDecoder.decode(getLinktoolPackage().getServerurl(),"UTF-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			serverurl = "https://collab-dev.its.virginia.edu";
			log.error("Couldn't find serverurl from linktool package! Defaulting to " + serverurl);
		}
		return  serverurl + "/sakai-ws/soap/signing";
	}

	public String getDecryptedSakaiSessionId() {
		return decryptedSakaiSessionId;
	}

	public void setDecryptedSakaiSessionId(String decryptedSakaiSessionId) {
		this.decryptedSakaiSessionId = decryptedSakaiSessionId;
	}
}

