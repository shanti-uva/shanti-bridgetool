package edu.virginia.shanti.om.bridge.web;

import edu.virginia.shanti.om.bridge.domain.RemoteContext;
import org.springframework.roo.addon.web.mvc.controller.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RooWebScaffold(path = "remotecontexts", formBackingObject = RemoteContext.class)
@RequestMapping("/remotecontexts")
@Controller
public class RemoteContextController {
}
