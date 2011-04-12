package edu.virginia.shanti.om.bridge.web;

import edu.virginia.shanti.om.bridge.domain.SiteAlias;
import org.springframework.roo.addon.web.mvc.controller.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RooWebScaffold(path = "sitealiases", formBackingObject = SiteAlias.class)
@RequestMapping("/sitealiases")
@Controller
public class SiteAliasController {
}
