package edu.virginia.shanti.om.bridge.web;

import edu.virginia.shanti.om.bridge.domain.PermissionSet;
import org.springframework.roo.addon.web.mvc.controller.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RooWebScaffold(path = "permissionsets", formBackingObject = PermissionSet.class)
@RequestMapping("/permissionsets")
@Controller
public class PermissionSetController {
}
