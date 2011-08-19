package edu.virginia.shanti.om.bridge.webflow;

import javax.servlet.http.HttpServletRequest;

import org.springframework.webflow.context.servlet.FilenameFlowUrlHandler;
import org.springframework.webflow.core.collection.AttributeMap;

public class BridgeToolFlowUrlHandler extends FilenameFlowUrlHandler {

	@Override
	public String getFlowId(HttpServletRequest request) {
//		System.err.println("getFlowId()");
		return super.getFlowId(request);
	}

	@Override
	public String createFlowDefinitionUrl(String flowId, AttributeMap input,
			HttpServletRequest request) {
//		System.err.println("createFlowDefinitionUrl");
		return super.createFlowDefinitionUrl(flowId, input, request);
	}

	@Override
	public void setEncodingScheme(String encodingScheme) {
//		System.err.println("setEncodingScheme()");
		super.setEncodingScheme(encodingScheme);
	}

	@Override
	public String getFlowExecutionKey(HttpServletRequest request) {
//		System.err.println("servletPath: " + request.getServletPath());
		
		// path will be something like "/xxx/yyy/user/main" where xxx=contextId and yyy=subcontextId
		
		String[] path = request.getServletPath().split("/");
		
		// Assert.assertEquals("Path is wrong length (path = " + request.getServletPath() + " length = " + path.length + ")", 5, path.length);
		
		if (path.length == 5) {
		
			//TODO: sanitize the path elements!
			request.setAttribute("localContext",path[1]);
			request.setAttribute("localSubContext",path[2]);
			request.setAttribute("service", path[3]);
			
			//
			
			
			
//			System.err.println("Adding to request attributes: localContext=" + path[1] + " localSubContext=" + path[2] + " user=" + path[3]);
		}
		
		return super.getFlowExecutionKey(request);
	}

	@Override
	public String createFlowExecutionUrl(String flowId,
			String flowExecutionKey, HttpServletRequest request) {
//		System.err.println("createFlowExecutionUrl()");
		return super.createFlowExecutionUrl(flowId, flowExecutionKey, request);
	}
	
}
