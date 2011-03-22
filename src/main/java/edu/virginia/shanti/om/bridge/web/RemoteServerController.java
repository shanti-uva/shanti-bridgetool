package edu.virginia.shanti.om.bridge.web;

import edu.virginia.shanti.om.bridge.domain.RemoteServer;
import org.springframework.roo.addon.web.mvc.controller.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RooWebScaffold(path = "remoteservers", formBackingObject = RemoteServer.class)
@RequestMapping("/remoteservers")
@Controller
public class RemoteServerController {
}
