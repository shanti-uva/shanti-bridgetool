package edu.virginia.shanti.om.bridge.web;

import edu.virginia.shanti.om.bridge.domain.ConfluencePermissionSet;
import org.springframework.roo.addon.web.mvc.controller.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RooWebScaffold(path = "confluencepermissionsets", formBackingObject = ConfluencePermissionSet.class)
@RequestMapping("/confluencepermissionsets")
@Controller
public class ConfluencePermissionSetController {
}
