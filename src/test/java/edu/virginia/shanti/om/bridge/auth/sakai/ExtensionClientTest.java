package edu.virginia.shanti.om.bridge.auth.sakai;

import static org.junit.Assert.*;

import java.io.IOException;
import java.net.URLDecoder;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.httpclient.Cookie;
import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.lang3.StringEscapeUtils;
import org.apache.http.HttpResponse;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

public class ExtensionClientTest {

	private HttpClient client;
	private String serverid = "sakai9";

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
		client = new HttpClient();
	}

	private String createSession() throws IOException, HttpException {
		String username = "yuji.shinozaki@gmail.com";
		String password = "totalDOG";

		PostMethod loginPost = new PostMethod(
				"https://"+ serverid + ".itc.virginia.edu/direct/session");
		loginPost.addParameter("_username", username);
		loginPost.addParameter("_password", password);
		int result = client.executeMethod(loginPost);
		String status = HttpStatus.getStatusText(result);
		System.err.println("result = " + result + " " + status);
		String sakaisession = loginPost.getResponseBodyAsString();
		return sakaisession;
	}

	@Test
	public void testLinkToolLaunch() throws Exception {

		String sess = createSession();
		
		Cookie[] cookies = client.getState().getCookies();
		for (Cookie cookie: cookies) {
			System.err.println(cookie);
		}

		GetMethod launch = new GetMethod(
				"https://" + serverid + ".itc.virginia.edu/portal/tool/b2d653ce-eb9b-4ea1-a5de-e8b08f7099b4?panel=Main");
		int ret = client.executeMethod(launch);
		System.err.println("Return: " + ret);
		for (Header header : launch.getResponseHeaders()) {
			System.err.print(header);
		}

		Cookie[] cookies2 = client.getState().getCookies();
		for (Cookie cookie: cookies2) {
			System.err.println(cookie);
		}
		
		
		
		
		String responseBody = launch.getResponseBodyAsString();
		System.err.println(responseBody);

		Pattern p = Pattern.compile("window\\.location = \'([^\']+)\'");
//		Pattern p = Pattern.compile("iframe src=\'([^\']+)\'");
		Matcher m = p.matcher(responseBody);
		if (!m.find()) {
			throw new RuntimeException("Couldn't parse response!");
		}

		String auth =  StringEscapeUtils.unescapeHtml4(m.group(1));

//		auth=URLDecoder.decode(auth, "UTF-8");
		
		if (auth.contains("?")) {
			auth = auth.split("\\?")[1];
		}

		System.err.println("AUTH:" + auth);
		LinktoolFormValues linkForm = new LinktoolFormValues(auth);
		ExtensionClient ex = new ExtensionClient(linkForm);
		System.err.println(linkForm);
		assertTrue(ex.authenticate());
		String session = ex.getDecryptedSakaiSessionId();
		System.err.println("Session: " + session);
		SakaiUserInfo info = ex.getSakaiUserInfo();

		assertEquals("yuji.shinozaki@gmail.com", info.getUserId());
		assertEquals("Yuji", info.getFirstName());
		assertEquals("Shinozaki", info.getLastName());
		assertEquals("yuji.shinozaki@gmail.com", info.getEmail());

	}
}
