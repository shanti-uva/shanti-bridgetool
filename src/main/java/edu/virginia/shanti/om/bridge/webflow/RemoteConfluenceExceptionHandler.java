package edu.virginia.shanti.om.bridge.webflow;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.binding.message.MessageBuilder;
import org.springframework.stereotype.Component;
import org.springframework.webflow.engine.FlowExecutionExceptionHandler;
import org.springframework.webflow.engine.RequestControlContext;
import org.springframework.webflow.engine.ViewState;
import org.springframework.webflow.execution.FlowExecutionException;

@Component
public class RemoteConfluenceExceptionHandler implements
		FlowExecutionExceptionHandler {

	private Log log = LogFactory.getLog(RemoteConfluenceExceptionHandler.class);

	public boolean canHandle(FlowExecutionException ex) {
		if (findBusinessException(ex) != null) {
			return true;
		} else {
			
			log.info(ex);
			
			return false;
		}
	}

	public void handle(FlowExecutionException ex, RequestControlContext context) {
		context.getMessageContext().addMessage(
				new MessageBuilder().error()
						.defaultText("Business Exception: " + findBusinessException(ex).getMessage())
						.build());

		Object testState = context.getCurrentState();

		log.info(ex);

		if (testState instanceof ViewState) {
			ViewState viewState = (ViewState) testState;
			try {
				context.getExternalContext().requestFlowExecutionRedirect();
				// viewState.getViewFactory().getView(context).render();
				log.info(ex);
			} catch (Exception e) {
				// Properly handle rendering errors here
				log.info(e);
				log.info("Original exception: " + ex);
				throw new RuntimeException("We are screwed!", e);
			}
		}

	}

	private Exception findBusinessException(FlowExecutionException ex) {
		Throwable cause = ex.getCause();
		while (cause != null) {
			if (cause instanceof Exception) {
				return (Exception) cause;
			}
			cause = cause.getCause();
		}
		return null;
	}

}
