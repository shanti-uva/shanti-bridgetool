package edu.virginia.shanti.om.bridge.webflow;

import java.io.IOException;

import org.springframework.binding.message.MessageBuilder;
import org.springframework.stereotype.Component;
import org.springframework.webflow.engine.FlowExecutionExceptionHandler;
import org.springframework.webflow.engine.RequestControlContext;
import org.springframework.webflow.engine.ViewState;
import org.springframework.webflow.execution.FlowExecutionException;

@Component
public class RemoteConfluenceExceptionHandler implements FlowExecutionExceptionHandler {

    public boolean canHandle(FlowExecutionException ex) {
	if (findBusinessException(ex) != null) {
	    return true;
	} else {
	    return false;
	}
    }

    public void handle(FlowExecutionException ex, RequestControlContext context) {
	context.getMessageContext().addMessage(
		new MessageBuilder().error().source(null).defaultText(findBusinessException(ex).getMessage()).build());

	Object testState = context.getCurrentState();

	if (testState instanceof ViewState) {
	    ViewState viewState = (ViewState) testState;
	    try {
		viewState.getViewFactory().getView(context).render();
	    } catch (IOException e) {
		//Properly handle rendering errors here
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
