package edu.virginia.shanti.om.bridge.web;

import javax.servlet.http.HttpSession;

import junit.framework.Assert;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import edu.virginia.shanti.om.bridge.form.GestaltBean;

@RequestMapping("/login")
@Controller
public class LoginController {

	// ?user=ys2n&
	// internaluser=ys2n&
	// site=remoteauth&
	// role=Owner&
	// session=af6f3c76cef6650a4094997d31de13d19d69a1abc2ddfaee8c7191dbb2009e9b646520dfd210bbed&
	// serverurl=https%3A%2F%2Fcollab.itc.virginia.edu&
	// time=1300725343653&
	// placement=61576d0a-994f-4499-a188-dc3300e8c83f&
	// serverId=sakai10&
	// sign=e368c04c9862ce7f5978df0f88e8d02280c0182a

	@RequestMapping(method = RequestMethod.GET)
	public String login(
			@RequestParam(value = "user", required = true) String user,
			@RequestParam(value = "site", required = true) String site,
			@RequestParam(value = "placement", required = true) String placement,
			@RequestParam(value = "role", required = true) String role,
			@RequestParam(value = "sign", required = true) String sign,
			@RequestParam(value = "service", required = false) String service,
			HttpSession session) {

		// System.err.println(" user = " + user);
		// System.err.println(" site = " + site);
		// System.err.println(" placement = " + placement);

		// Cleaning
		if (site.contains(",")) {
			site = site.split(",")[0];
		}
		// sanity check
		Assert.assertTrue("illegal character in username",
				user.matches("[\\S]+"));
		Assert.assertTrue("username too long: " + user.length(),
				user.length() < 64);
		Assert.assertTrue("illegal characeter in site: " + site,
				site.matches("[A-z0-9\\-~]+"));
		Assert.assertTrue("site too long: " + site.length(), site.length() < 64);
		Assert.assertTrue("placement too long: " + placement.length(),
				placement.length() < 64);

		// need to save role

		// TODO: need to verify signature

		if (service == null || "".equals(service)) {
			service = "shanti-wiki";
		}

		return "redirect:/" + site + "/" + placement + "/" + service + "/main";
	}

}
