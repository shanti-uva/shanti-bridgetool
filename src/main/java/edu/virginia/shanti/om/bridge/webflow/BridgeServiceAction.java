package edu.virginia.shanti.om.bridge.webflow;

import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.binding.message.MessageBuilder;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.stereotype.Component;
import org.springframework.webflow.execution.RequestContext;

import edu.virginia.shanti.om.bridge.domain.Bridge;
import edu.virginia.shanti.om.bridge.domain.RemoteServer;
import edu.virginia.shanti.om.bridge.form.ConfigBean;
import edu.virginia.shanti.om.bridge.form.ConfluenceSpaceForm;
import edu.virginia.shanti.om.bridge.form.RemoteContextChoice;
import edu.virginia.shanti.om.bridge.service.BridgeService;
import edu.virginia.shanti.om.bridge.service.RemoteServerService;

@RooJavaBean
@Component
public class BridgeServiceAction {

	private static final boolean failfast = true;

	Log log = LogFactory.getLog(BridgeServiceAction.class);

	@Autowired
	private BridgeService bridgeService;

	@Autowired
	private RemoteServerService remoteServerService;

	public String save(Bridge bridge, RequestContext context) {

		try {
			bridgeService.save(bridge);
			return "success";
		} catch (Exception e) {
			log.error(e);
			return handleError(e, context);
		}

	}

	public String checkConfig(RequestContext context) {
		try {

			ConfigBean config = (ConfigBean) context.getFlowScope().get(
					"config");
			return (bridgeService.checkConfig(config)) ? "configured"
					: "unconfigured";
		} catch (Exception e) {
			return handleError(e, context);
		}
	}

	public String newBridge(ConfigBean config, RequestContext context) {
		try {
			Bridge newBridge = bridgeService.newBridge(config);
			context.getFlashScope().put("bridge", newBridge);
			return "success";
		} catch (Exception e) {
			return handleError(e, context);
		}
	}

	public String setup(RequestContext context) {
		try {
			populateConfig(context);
			populateRemoteServers(context);
			populateRemoteContexts(context);
			return "success";
		} catch (Exception e) {
			return handleError(e, context);
		}
	}

	public String setupCreateForm(RequestContext context) {
		try {
			populateConfig(context);
			populateRemoteServers(context);
			populateCreateForm(context);
			return "success";
		} catch (Exception e) {
			return handleError(e, context);
		}
	}

	private void populateCreateForm(RequestContext context) {
		// / TODO: eliminate dependence on ConfluenceSpaceForm!
		ConfigBean config = (ConfigBean) context.getFlowScope().get("config");
		ConfluenceSpaceForm confluenceSpaceForm = (ConfluenceSpaceForm) context
				.getFlowScope().get("confluenceSpaceForm");
		confluenceSpaceForm.populate(config);
	}

	public String prepareNormalView(RequestContext context) {
		try {
			populateBridge(context);
			populateMarkup(context);
			return "success";
		} catch (Exception e) {
			return handleError(e, context);
		}
	}

	public String prepareForm(RequestContext context) {
		try {
			populateBridge(context);
			populateRemoteContexts(context);
			return "success";
		} catch (Exception e) {
			return handleError(e, context);
		}
	}
	
	public String delete(RequestContext context) {
		try {
			deleteBridge(context);
			return "success";
		} catch (Exception e) {
			return handleError(e, context);
		}
	}

	private void deleteBridge(RequestContext context) {
		if (context.getFlowScope().contains("config")) {
			ConfigBean config = (ConfigBean) context.getFlowScope().get(
					"config");
			Bridge bridge = bridgeService.getBridge(config);

			if (bridge != null) {
				bridgeService.remove(bridge);
				context.getFlowScope().remove("bridge");
			}
		} else {
			throw new RuntimeException("config is not found in flow scope.");
		}		
	}

	private void populateMarkup(RequestContext context) {
		if (context.getFlowScope().contains("bridge")) {
			Bridge bridge = (Bridge) context.getFlowScope().get("bridge");

			try {
				String markUp = bridgeService.getSummaryMarkup(bridge);
				context.getFlowScope().put("markUp", markUp);
			} catch (Exception e) {
				log.error(e);
			}
		} else {
			throw new RuntimeException("bridge is not found in flow scope.");
		}
	}

	private void populateBridge(RequestContext context) {
		if (context.getFlowScope().contains("config")) {
			ConfigBean config = (ConfigBean) context.getFlowScope().get(
					"config");
			Bridge bridge = bridgeService.getBridge(config);

			if (bridge == null) {
				bridge = bridgeService.newBridge(config);
			}
			context.getFlowScope().put("bridge", bridge);
		} else {
			throw new RuntimeException("config is not found in flow scope.");
		}
	}

	private void populateRemoteServers(RequestContext context) {
		List<RemoteServer> remoteServers = remoteServerService
				.getAllRemoteServers();
		context.getFlowScope().put("remoteServers", remoteServers);
	}

	private void populateRemoteContexts(RequestContext context) {
		ConfigBean config = (ConfigBean) context.getFlowScope().get("config");
		List<RemoteContextChoice> remoteContexts = remoteServerService
				.getRemoteContexts(config.getRemoteService());
		context.getFlowScope().put("remoteContexts", remoteContexts);
	}

	private void populateConfig(RequestContext context) {
		ConfigBean configBean = bridgeService
				.populateConfigFromContext(context);
		context.getFlowScope().put("config", configBean);
	}

	private String handleError(Exception e, RequestContext context) {
		log.error(e);

		// if (failfast)throw new RuntimeException(e);

		StringWriter s = new StringWriter();
		PrintWriter p = new PrintWriter(s);
		e.printStackTrace(p);

		context.getMessageContext().addMessage(
				new MessageBuilder().error()
						.defaultText("Error: " + s.toString()).build());
		return "error";
	}

}
