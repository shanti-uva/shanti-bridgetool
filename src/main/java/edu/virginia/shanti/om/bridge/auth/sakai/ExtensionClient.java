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
import java.util.Date;

import javax.xml.namespace.QName;
import javax.xml.rpc.ServiceException;

import org.apache.axis.client.Call;
import org.apache.axis.client.Service;
import org.apache.axis.client.Stub;
import org.apache.axis.client.Transport;
import org.apache.axis.message.SOAPBodyElement;
import org.apache.axis.transport.http.HTTPConstants;
import org.apache.commons.httpclient.Cookie;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpState;
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

	private static final String JSESSIONID = "JSESSIONID";

	private static final String AFFINITYID = "AFFINITYID";

	private static final String SAKAI_WS_SOAP_SIGNING_PATH = "/sakai-ws/soap/signing";

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
			
			log.info(AFFINITYID + " = " + getSakaiAffinityId()); 
			log.info(JSESSIONID + " = " + getSakaiSessionId());
			log.info("SAKAISIGNING URL = " + getSakaiSigningUrl());
			log.info("keyValueString = "
					+ getLinktoolPackage().getKeyValueString());
			
			
			Service service = new Service();
			Call call = (Call) service.createCall();
			call.setMaintainSession(true);
			call.setTargetEndpointAddress(new java.net.URL(getSakaiSigningUrl()));
			call.setProperty(
			        org.apache.axis.client.Call.SESSION_MAINTAIN_PROPERTY, 
			        new Boolean(true));
			call.setProperty(
			        org.apache.axis.transport.http.HTTPConstants.HEADER_COOKIE,
			        AFFINITYID + "=" + getSakaiAffinityId());
			call.addParameter("data", 
					  org.apache.axis.Constants.XSD_STRING,
					  javax.xml.rpc.ParameterMode.IN);
			call.setReturnType(org.apache.axis.Constants.XSD_STRING);
				
			authenticateResult = (String) call
					.invoke("http://webservices.sakaiproject.org/","testsign",
							new Object[] { getLinktoolPackage()
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

	private String getSakaiAffinityId() {
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
		String sakaiSessionId = null;

		if (getSakaiSessionId() == null) {
			log.warn("calling decryptSession with " + getLinktoolPackage());
			try {
				Service service = new Service();
				Call call = (Call) service.createCall();
				call.setTargetEndpointAddress(new URL(getSakaiSigningUrl()));
				call.setMaintainSession(true);
				call.setProperty(
				        org.apache.axis.client.Call.SESSION_MAINTAIN_PROPERTY, 
				        new Boolean(true));
				call.setProperty(
				        org.apache.axis.transport.http.HTTPConstants.HEADER_COOKIE,
				        AFFINITYID + "=" + getSakaiAffinityId());
				call.addParameter("esession", 
						  org.apache.axis.Constants.XSD_STRING,
						  javax.xml.rpc.ParameterMode.IN);
				call.setReturnType(org.apache.axis.Constants.XSD_STRING);
					
				sakaiSessionId = (String) call
						.invoke("http://webservices.sakaiproject.org/","decryptSession",
								new Object[] { getLinktoolPackage().getSession()});
				
				log.info("return from decryptSession: sakaiSessionId = " + sakaiSessionId);
				
				setSakaiSessionId(sakaiSessionId);

				
				
			} catch (MalformedURLException e) {
				throw e;
			} catch (RemoteException e) {
				throw e;
			} catch (ServiceException e) {
				throw e;
			}
		}
		String userInfoString = null;

		log.info("decrypted session id = "
				+ getSakaiSessionId());

		HttpClient client = new HttpClient();
		HttpState state = new HttpState();		
		String domain = new URL(URLDecoder.decode(getLinktoolPackage().getServerurl(), "UTF-8")).getHost();
		Cookie jsessionid = new Cookie(domain, JSESSIONID, getSakaiSessionId() + "." + getLinktoolPackage().getServerId() , "/", 0, false);
		Cookie affinityid = new Cookie(domain, AFFINITYID, getLinktoolPackage().getServerId(), "/", 0, false);
		log.info("JSESSIONID cookie" + jsessionid.toString() );
		log.info("AFFINITYID cookie" + affinityid.toString() );

		state.addCookie(jsessionid);
		state.addCookie(affinityid);
		client.setState(state);
		
		String directUserUrl = getLinktoolPackage().getServerurl()
		+ "/direct/user/current.xml?sakai.session="
		+ getSakaiSessionId();
		
		GetMethod get = new GetMethod(
				directUserUrl);
		int ret = client.executeMethod(get);
		log.info(directUserUrl + " returned: " + ret);
		userInfoString = get.getResponseBodyAsString();
		Document resultDocument = null;
		StringReader resultReader = new StringReader(userInfoString);
		SAXBuilder saxBuilder = new SAXBuilder();
		try {
			resultDocument = saxBuilder.build(resultReader);
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
				getSakaiSessionId(), email, type, siteId, serverUrl,
				serverId);

		return info;
	}

	private String getSakaiSigningUrl() {		
		String serverurl = getLinktoolPackage().getServerurl();
		return  serverurl + SAKAI_WS_SOAP_SIGNING_PATH;
	}

	public String getSakaiSessionId() {
		return decryptedSakaiSessionId;
	}

	public void setSakaiSessionId(String decryptedSakaiSessionId) {
		this.decryptedSakaiSessionId = decryptedSakaiSessionId;
	}
}

