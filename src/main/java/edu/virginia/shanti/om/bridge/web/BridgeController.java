package edu.virginia.shanti.om.bridge.web;

import edu.virginia.shanti.om.bridge.domain.Bridge;
import org.springframework.roo.addon.web.mvc.controller.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RooWebScaffold(path = "bridges", formBackingObject = Bridge.class)
@RequestMapping("/bridges")
@Controller
public class BridgeController {
}
