package edu.virginia.shanti.om.bridge.webflow;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.binding.message.MessageBuilder;
import org.springframework.binding.message.MessageContext;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.stereotype.Component;

import edu.virginia.shanti.om.bridge.domain.Bridge;
import edu.virginia.shanti.om.bridge.service.BridgeService;

@RooJavaBean
@Component
public class BridgeServiceAction {
	
	@Autowired
	private BridgeService bridgeService;
	
	public String save(Bridge bridge, MessageContext context) {
		
		try {
			
			bridgeService.save(bridge);
			return "success";
			
		} catch (Exception e) {
			context.addMessage(new MessageBuilder().error().defaultText(e.getMessage()).build());
			return "error";
		}
		
	}

}
