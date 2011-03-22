package edu.virginia.shanti.om.bridge.web;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import edu.virginia.shanti.om.bridge.form.ConfigBean;
import edu.virginia.shanti.om.bridge.form.ConfluenceConfigBean;

@RequestMapping("/login")
@Controller
public class LoginController {
	
// ?user=ys2n&
//	internaluser=ys2n&
//	site=remoteauth&
//	role=Owner&
//	session=af6f3c76cef6650a4094997d31de13d19d69a1abc2ddfaee8c7191dbb2009e9b646520dfd210bbed&
//	serverurl=https%3A%2F%2Fcollab.itc.virginia.edu&
//	time=1300725343653&
//	placement=61576d0a-994f-4499-a188-dc3300e8c83f&
//	serverId=sakai10&
//	sign=e368c04c9862ce7f5978df0f88e8d02280c0182a
	
    @RequestMapping(method = RequestMethod.GET)
    public String login(
    		@RequestParam(value = "user", required = true) String user,
    		@RequestParam(value = "site", required = true) String site,
    		@RequestParam(value = "placement", required = true) String placement,
    		@RequestParam(value = "time", required = true) Long time,
    		HttpSession session) {
    	
    	System.err.println(" user = " + user);
    	System.err.println(" site = " + site);
    	System.err.println(" placement = " + placement);
    	System.err.println(" time = " + time);
    	
    	
    	
    	
    	
        return "redirect:/main";   
    }

}
