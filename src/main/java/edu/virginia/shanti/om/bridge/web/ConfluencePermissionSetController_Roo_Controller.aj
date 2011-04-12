// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package edu.virginia.shanti.om.bridge.web;

import edu.virginia.shanti.om.bridge.domain.ConfluencePermissionSet;
import edu.virginia.shanti.om.bridge.domain.LocalGroupType;
import java.io.UnsupportedEncodingException;
import java.lang.Integer;
import java.lang.Long;
import java.lang.String;
import java.util.Arrays;
import java.util.Collection;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.util.UriUtils;
import org.springframework.web.util.WebUtils;

privileged aspect ConfluencePermissionSetController_Roo_Controller {
    
    @RequestMapping(method = RequestMethod.POST)
    public String ConfluencePermissionSetController.create(@Valid ConfluencePermissionSet confluencePermissionSet, BindingResult result, Model model, HttpServletRequest request) {
        if (result.hasErrors()) {
            model.addAttribute("confluencePermissionSet", confluencePermissionSet);
            return "confluencepermissionsets/create";
        }
        confluencePermissionSet.persist();
        return "redirect:/confluencepermissionsets/" + encodeUrlPathSegment(confluencePermissionSet.getId().toString(), request);
    }
    
    @RequestMapping(params = "form", method = RequestMethod.GET)
    public String ConfluencePermissionSetController.createForm(Model model) {
        model.addAttribute("confluencePermissionSet", new ConfluencePermissionSet());
        return "confluencepermissionsets/create";
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public String ConfluencePermissionSetController.show(@PathVariable("id") Long id, Model model) {
        model.addAttribute("confluencepermissionset", ConfluencePermissionSet.findConfluencePermissionSet(id));
        model.addAttribute("itemId", id);
        return "confluencepermissionsets/show";
    }
    
    @RequestMapping(method = RequestMethod.GET)
    public String ConfluencePermissionSetController.list(@RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, Model model) {
        if (page != null || size != null) {
            int sizeNo = size == null ? 10 : size.intValue();
            model.addAttribute("confluencepermissionsets", ConfluencePermissionSet.findConfluencePermissionSetEntries(page == null ? 0 : (page.intValue() - 1) * sizeNo, sizeNo));
            float nrOfPages = (float) ConfluencePermissionSet.countConfluencePermissionSets() / sizeNo;
            model.addAttribute("maxPages", (int) ((nrOfPages > (int) nrOfPages || nrOfPages == 0.0) ? nrOfPages + 1 : nrOfPages));
        } else {
            model.addAttribute("confluencepermissionsets", ConfluencePermissionSet.findAllConfluencePermissionSets());
        }
        return "confluencepermissionsets/list";
    }
    
    @RequestMapping(method = RequestMethod.PUT)
    public String ConfluencePermissionSetController.update(@Valid ConfluencePermissionSet confluencePermissionSet, BindingResult result, Model model, HttpServletRequest request) {
        if (result.hasErrors()) {
            model.addAttribute("confluencePermissionSet", confluencePermissionSet);
            return "confluencepermissionsets/update";
        }
        confluencePermissionSet.merge();
        return "redirect:/confluencepermissionsets/" + encodeUrlPathSegment(confluencePermissionSet.getId().toString(), request);
    }
    
    @RequestMapping(value = "/{id}", params = "form", method = RequestMethod.GET)
    public String ConfluencePermissionSetController.updateForm(@PathVariable("id") Long id, Model model) {
        model.addAttribute("confluencePermissionSet", ConfluencePermissionSet.findConfluencePermissionSet(id));
        return "confluencepermissionsets/update";
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public String ConfluencePermissionSetController.delete(@PathVariable("id") Long id, @RequestParam(value = "page", required = false) Integer page, @RequestParam(value = "size", required = false) Integer size, Model model) {
        ConfluencePermissionSet.findConfluencePermissionSet(id).remove();
        model.addAttribute("page", (page == null) ? "1" : page.toString());
        model.addAttribute("size", (size == null) ? "10" : size.toString());
        return "redirect:/confluencepermissionsets?page=" + ((page == null) ? "1" : page.toString()) + "&size=" + ((size == null) ? "10" : size.toString());
    }
    
    @ModelAttribute("localgrouptypes")
    public Collection<LocalGroupType> ConfluencePermissionSetController.populateLocalGroupTypes() {
        return Arrays.asList(LocalGroupType.class.getEnumConstants());
    }
    
    String ConfluencePermissionSetController.encodeUrlPathSegment(String pathSegment, HttpServletRequest request) {
        String enc = request.getCharacterEncoding();
        if (enc == null) {
            enc = WebUtils.DEFAULT_CHARACTER_ENCODING;
        }
        try {
            pathSegment = UriUtils.encodePathSegment(pathSegment, enc);
        }
        catch (UnsupportedEncodingException uee) {}
        return pathSegment;
    }
    
}