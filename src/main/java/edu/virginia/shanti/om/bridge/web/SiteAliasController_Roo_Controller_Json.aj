// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package edu.virginia.shanti.om.bridge.web;

import edu.virginia.shanti.om.bridge.domain.SiteAlias;
import java.lang.Long;
import java.lang.Object;
import java.lang.String;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

privileged aspect SiteAliasController_Roo_Controller_Json {
    
    @RequestMapping(value = "/{id}", method = RequestMethod.GET, headers = "Accept=application/json")
    @ResponseBody
    public Object SiteAliasController.showJson(@PathVariable("id") Long id) {
        SiteAlias sitealias = SiteAlias.findSiteAlias(id);
        if (sitealias == null) {
            HttpHeaders headers= new HttpHeaders();
            headers.add("Content-Type", "application/text");
            return new ResponseEntity<String>(headers, HttpStatus.NOT_FOUND);
        }
        return sitealias.toJson();
    }
    
    @RequestMapping(headers = "Accept=application/json")
    @ResponseBody
    public String SiteAliasController.listJson() {
        return SiteAlias.toJsonArray(SiteAlias.findAllSiteAliases());
    }
    
    @RequestMapping(method = RequestMethod.POST, headers = "Accept=application/json")
    public org.springframework.http.ResponseEntity<String> SiteAliasController.createFromJson(@RequestBody String json) {
        SiteAlias.fromJsonToSiteAlias(json).persist();
        HttpHeaders headers= new HttpHeaders();
        headers.add("Content-Type", "application/text");
        return new ResponseEntity<String>(headers, HttpStatus.CREATED);
    }
    
    @RequestMapping(value = "/jsonArray", method = RequestMethod.POST, headers = "Accept=application/json")
    public org.springframework.http.ResponseEntity<String> SiteAliasController.createFromJsonArray(@RequestBody String json) {
        for (SiteAlias siteAlias: SiteAlias.fromJsonArrayToSiteAliases(json)) {
            siteAlias.persist();
        }
        HttpHeaders headers= new HttpHeaders();
        headers.add("Content-Type", "application/text");
        return new ResponseEntity<String>(headers, HttpStatus.CREATED);
    }
    
    @RequestMapping(method = RequestMethod.PUT, headers = "Accept=application/json")
    public org.springframework.http.ResponseEntity<String> SiteAliasController.updateFromJson(@RequestBody String json) {
        HttpHeaders headers= new HttpHeaders();
        headers.add("Content-Type", "application/text");
        if (SiteAlias.fromJsonToSiteAlias(json).merge() == null) {
            return new ResponseEntity<String>(headers, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<String>(headers, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/jsonArray", method = RequestMethod.PUT, headers = "Accept=application/json")
    public org.springframework.http.ResponseEntity<String> SiteAliasController.updateFromJsonArray(@RequestBody String json) {
        HttpHeaders headers= new HttpHeaders();
        headers.add("Content-Type", "application/text");
        for (SiteAlias siteAlias: SiteAlias.fromJsonArrayToSiteAliases(json)) {
            if (siteAlias.merge() == null) {
                return new ResponseEntity<String>(headers, HttpStatus.NOT_FOUND);
            }
        }
        return new ResponseEntity<String>(headers, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE, headers = "Accept=application/json")
    public org.springframework.http.ResponseEntity<String> SiteAliasController.deleteFromJson(@PathVariable("id") Long id) {
        SiteAlias sitealias = SiteAlias.findSiteAlias(id);
        HttpHeaders headers= new HttpHeaders();
        headers.add("Content-Type", "application/text");
        if (sitealias == null) {
            return new ResponseEntity<String>(headers, HttpStatus.NOT_FOUND);
        }
        sitealias.remove();
        return new ResponseEntity<String>(headers, HttpStatus.OK);
    }
    
    @RequestMapping(params = "find=ByAlias", method = RequestMethod.GET, headers = "Accept=application/json")
    @ResponseBody
    public String SiteAliasController.jsonFindSiteAliasesByAlias(@RequestParam("alias") String alias) {
        return SiteAlias.toJsonArray(SiteAlias.findSiteAliasesByAlias(alias).getResultList());
    }
    
    @RequestMapping(params = "find=BySiteId", method = RequestMethod.GET, headers = "Accept=application/json")
    @ResponseBody
    public String SiteAliasController.jsonFindSiteAliasesBySiteId(@RequestParam("siteId") String siteId) {
        return SiteAlias.toJsonArray(SiteAlias.findSiteAliasesBySiteId(siteId).getResultList());
    }
    
}