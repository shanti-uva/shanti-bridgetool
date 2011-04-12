package edu.virginia.shanti.om.bridge.web;

import edu.virginia.shanti.om.bridge.domain.PermissionMap;
import org.springframework.roo.addon.web.mvc.controller.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RooWebScaffold(path = "permissionmaps", formBackingObject = PermissionMap.class)
@RequestMapping("/permissionmaps")
@Controller
public class PermissionMapController {
}
