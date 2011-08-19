package edu.virginia.shanti.om.bridge.web;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.roo.addon.web.mvc.controller.RooWebScaffold;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import edu.virginia.shanti.om.bridge.domain.Bridge;

@RooWebScaffold(path = "bridges", formBackingObject = Bridge.class)
@RequestMapping("/bridges")
@Controller
public class BridgeController {

	
    @RequestMapping(value = "/{id}.json", method = RequestMethod.GET)
    @ResponseBody
    public Object showJsonViaExtension(@PathVariable("id") Long id) {
        Bridge bridge = Bridge.findBridge(id);
        if (bridge == null) {
            HttpHeaders headers= new HttpHeaders();
            headers.add("Content-Type", "application/text");
            return new ResponseEntity<String>(headers, HttpStatus.NOT_FOUND);
        }
        return bridge.toJson();
    }
    
    
    @RequestMapping(value = "/json", method = RequestMethod.GET)
    @ResponseBody
    public String showJsonList() {
    	return Bridge.toJsonArray(Bridge.findAllBridges());
    }
	


}
