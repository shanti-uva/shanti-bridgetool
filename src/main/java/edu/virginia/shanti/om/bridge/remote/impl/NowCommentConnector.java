package edu.virginia.shanti.om.bridge.remote.impl;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.security.Principal;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.text.WordUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.http.Header;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.AuthCache;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.params.HttpClientParams;
import org.apache.http.client.protocol.ClientContext;
import org.apache.http.impl.auth.BasicScheme;
import org.apache.http.impl.client.BasicAuthCache;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.util.EntityUtils;
import org.jdom.Element;
import org.junit.Assert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.roo.addon.serializable.RooSerializable;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.sun.syndication.feed.synd.SyndEntry;
import com.sun.syndication.feed.synd.SyndFeed;
import com.sun.syndication.io.FeedException;
import com.sun.syndication.io.SyndFeedInput;
import com.sun.syndication.io.XmlReader;

import edu.virginia.shanti.om.bridge.domain.PermissionMap;
import edu.virginia.shanti.om.bridge.domain.RemoteContext;
import edu.virginia.shanti.om.bridge.domain.RemoteServer;
import edu.virginia.shanti.om.bridge.form.ConfigBean;
import edu.virginia.shanti.om.bridge.form.RemoteContextChoice;
import edu.virginia.shanti.om.bridge.remote.RemoteConnector;
import edu.virginia.shanti.om.bridge.remote.RemotePermissions;
import edu.virginia.shanti.om.bridge.service.SiteAliasService;

@Service
@Component
@RooSerializable
public class NowCommentConnector implements RemoteConnector {

	private static final long serialVersionUID = -360593800242514401L;

	@Autowired
	private SiteAliasService siteAliasService;

	private Log log = LogFactory.getLog(NowCommentConnector.class);

	@Override
	public List<RemoteContextChoice> getContexts(Principal principal,
			RemoteServer remoteServer, ConfigBean config) {

		List<RemoteContextChoice> choices = new LinkedList<RemoteContextChoice>();

		RemoteContextChoice choice = new RemoteContextChoice();

		String siteAlias = siteAliasService.getAliasForSiteId(config
				.getLocalContext());

		String displayName = grokDisplayName(siteAlias);

		log.info("Got siteAlias " + siteAlias + " for "
				+ config.getLocalContext());
		choice.setContextId(siteAlias);
		choice.setContextLabel("NowComment Group: " + displayName);
		choice.setRemoteName(remoteServer.getRemoteName());
		log.info("remoteServer = " + remoteServer);
		// https://staging.nowcomment.com/uva?redirect_to_group=~collab:java-basics-fde0:summer2008
		choice.setUrl(remoteServer.getRemoteUrl() + "/uva?redirect_to_group="
				+ siteAlias);
		log.info("adding choice = " + choice);
		choices.add(choice);
		return choices;
	}

	private String grokDisplayName(String siteAlias) {

		siteAlias = siteAlias.split(":")[1];
		siteAlias = siteAlias.substring(0, siteAlias.length() - 5).replaceAll(
				"-", " ");
		String displayName = WordUtils.capitalize(siteAlias);

		return displayName;
	}

	@Override
	public RemoteContext createRemoteContext(Principal principal,
			RemoteContext remoteContext, ConfigBean config) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getSummaryMarkup(Principal principal,
			RemoteContext remoteContext) {

		String ctxId = remoteContext.getContextId();

		System.err.println("getSummaryMarkup called with remoteContext = "
				+ remoteContext);

		String remoteSummaryUrl = remoteContext.getUrl();

		try {

			HttpHost targetHost = org.apache.http.client.utils.URIUtils
					.extractHost(new URI(remoteSummaryUrl));

			// TODO: pool httpclients and localcontexts?
			DefaultHttpClient client = new DefaultHttpClient();
			BasicHttpContext httpcontext = prepareAuthentication(targetHost,
					client);

			long start2 = System.currentTimeMillis();
			String summary = fetchSummary(principal, ctxId, targetHost, client,
					httpcontext);
			long finish2 = System.currentTimeMillis();

			System.out.println("summary for " + ctxId + " =\n" + summary);

			System.out.println("PROFILE: fetchSummary took "
					+ (finish2 - start2) + " ms");

			return summary;
		} catch (URISyntaxException e) {
			throw new RuntimeException(e);
		} catch (IOException e) {
			throw new RuntimeException(e);
		} catch (IllegalArgumentException e) {
			throw new RuntimeException(e);
		} catch (FeedException e) {
			throw new RuntimeException(e);
		}

	}

	private String fetchSummary(Principal principal, String ctxId,
			HttpHost targetHost, DefaultHttpClient client,
			BasicHttpContext httpcontext) throws IOException, FeedException {

		String groupId = null;

		String summary = "<p>Summary is currently unavailable.</p>";

		groupId = fetchGroupId(ctxId, targetHost, client, httpcontext);

		System.err.println("Found groupId = " + groupId);

		String groupRSS = targetHost.toURI() + "/rss/group/" + groupId
				+ "/user/" + principal.getName() + "@virginia.edu";

		HttpGet httpget = new HttpGet(groupRSS);

		HttpClientParams.setRedirecting(client.getParams(), true);
		HttpResponse response = client
				.execute(targetHost, httpget, httpcontext);
		System.err.println("url = " + groupRSS);
		System.err.println("status = " + response.getStatusLine());

		int retcode = response.getStatusLine().getStatusCode();

		if (retcode == HttpServletResponse.SC_OK) {

			HttpEntity entity = response.getEntity();

			XmlReader reader = new XmlReader(entity.getContent());
			/*
			 * 
			 * <rss version="2.0" xmlns:nowcomment="http://nowcomment.com/rss/">
			 * <channel> <title>NowComment - Yuji Shinozaki's unread comments in
			 * the group Java Basics (Summer 2008)</title>
			 * <description>NowComment - Yuji Shinozaki's unread comments in the
			 * group Java Basics (Summer 2008)</description>
			 * <link>http://staging.nowcomment.com/groups/264</link>
			 * <nowcomment:shib_id
			 * >~collab:java-basics-fde0:summer2008</nowcomment:shib_id> <item>
			 * <title>Test Document</title>
			 * <link>http://staging.nowcomment.com/documents/2355/view</link>
			 * <nowcomment:document_id>2355</nowcomment:document_id>
			 * <nowcomment:unread_comments>0</nowcomment:unread_comments>
			 * </item> <lastBuildDate>Fri, 12 Aug 2011 10:55:41
			 * -0400</lastBuildDate> </channel> </rss>
			 */

			try {
				StringBuilder summaryBuilder = new StringBuilder();

				summaryBuilder.append("<ul>\n");

				SyndFeed feed = new SyndFeedInput().build(reader);
				System.out.println("Feed Title: " + feed.getTitle());

				for (Iterator i = feed.getEntries().iterator(); i.hasNext();) {
					int unreadCount = 0, documentId = 0;
					SyndEntry entry = (SyndEntry) i.next();
					System.out.println("\tEntry: " + entry.getTitle());

					String documentUrl = entry.getUri();
					System.out.println(entry);

					List<Element> foreignMarkupList = (List<Element>) entry
							.getForeignMarkup();

					for (Element x : foreignMarkupList) {
						System.out.println(">>>" + x.getName() + "="
								+ x.getText());
						if ("unread_comments".equals(x.getName())) {
							unreadCount = Integer.parseInt(x.getValue());
						} else if ("document_id".equals(x.getName())) {
							documentId = Integer.parseInt(x.getValue());
						}
					}

					summaryBuilder.append("\t<li>");
					summaryBuilder.append("<a href=\"");
					summaryBuilder.append(documentUrl);
					summaryBuilder.append("\">");
					summaryBuilder.append(entry.getTitle());
					summaryBuilder.append("</a>");
					summaryBuilder.append(" (");
					summaryBuilder.append(unreadCount);
					summaryBuilder.append(" unread comment");
					if (unreadCount != 1) {
						summaryBuilder.append("s");
					}
					summaryBuilder.append(")");
					summaryBuilder.append("</li>");
					summaryBuilder.append("\n");

				}
				summaryBuilder.append("</ul>\n");
				summary = summaryBuilder.toString();
			} catch (Exception e) {
				log.warn("There was a problem retrieving the feed: Return code was: " + retcode, e);
			} finally {
				if (reader != null)
					reader.close();
			}
		}
		return summary;
	}

	private String fetchGroupId(String ctxId, HttpHost targetHost,
			DefaultHttpClient client, BasicHttpContext httpcontext)
			throws IOException, ClientProtocolException {
		String groupId;
		String redirectUrl = targetHost.toURI() + "/rss/redirect/" + ctxId;

		System.err.println("redirectUrl = " + redirectUrl);

		HttpGet idGet = new HttpGet(redirectUrl);

		HttpClientParams.setRedirecting(client.getParams(), false);

		HttpResponse redirectResponse = client.execute(targetHost, idGet,
				httpcontext);
		HttpEntity entity2 = redirectResponse.getEntity();
		EntityUtils.consume(entity2);

		Header redirectHeader = redirectResponse.getFirstHeader("Location");
		String redirectString = redirectHeader.getValue();
		System.err.println("redirect = " + redirectString);

		Pattern pattern = Pattern.compile(".*/groups/(\\d+)");
		Matcher matcher = pattern.matcher(redirectString);

		Assert.assertTrue(matcher.matches());

		groupId = matcher.group(1);
		return groupId;
	}

	private BasicHttpContext prepareAuthentication(HttpHost targetHost,
			DefaultHttpClient client) {
		client.getCredentialsProvider().setCredentials(
				new AuthScope(targetHost.getHostName(), targetHost.getPort()),
				new UsernamePasswordCredentials("nowcomment", "3RefUspU"));

		AuthCache authCache = new BasicAuthCache(); // Generate BASIC scheme
													// object and add it to
		// the local auth cache
		BasicScheme basicAuth = new BasicScheme();
		authCache.put(targetHost, basicAuth);

		// Add AuthCache to the execution context
		BasicHttpContext localcontext = new BasicHttpContext();
		localcontext.setAttribute(ClientContext.AUTH_CACHE, authCache);
		return localcontext;
	}

	@Override
	public RemotePermissions getRemotePermissions(Principal principal,
			String localContext, RemoteContext remoteContext) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setRemotePermissions(Principal principal, String localContext,
			RemoteContext remoteContext, PermissionMap permissionMap) {
		// TODO Auto-generated method stub

	}

}
