package edu.virginia.shanti.om.bridge.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.webflow.core.collection.AttributeMap;
import org.springframework.webflow.core.collection.MutableAttributeMap;
import org.springframework.webflow.definition.FlowDefinition;
import org.springframework.webflow.definition.StateDefinition;
import org.springframework.webflow.definition.TransitionDefinition;
import org.springframework.webflow.execution.EnterStateVetoException;
import org.springframework.webflow.execution.Event;
import org.springframework.webflow.execution.FlowExecutionException;
import org.springframework.webflow.execution.FlowExecutionListenerAdapter;
import org.springframework.webflow.execution.FlowSession;
import org.springframework.webflow.execution.RequestContext;
import org.springframework.webflow.execution.View;

public class LoggingFlowExecutionListener extends FlowExecutionListenerAdapter {
	
	Logger logger = LoggerFactory.getLogger(LoggingFlowExecutionListener.class);	
	
	@Override
	public void requestSubmitted(RequestContext context) {
		// TODO Auto-generated method stub
		super.requestSubmitted(context);
		logger.debug("requestSubmitted: " + context);
	}

	@Override
	public void requestProcessed(RequestContext context) {
		// TODO Auto-generated method stub
		super.requestProcessed(context);
		logger.debug("requestProcessed: " + context);
	}

	@Override
	public void sessionCreating(RequestContext context,
			FlowDefinition definition) {
		// TODO Auto-generated method stub
		super.sessionCreating(context, definition);
		logger.debug("sessionCreating: " + definition);
	}

	@Override
	public void sessionStarting(RequestContext context, FlowSession session,
			MutableAttributeMap input) {
		// TODO Auto-generated method stub
		super.sessionStarting(context, session, input);
		logger.debug("sessionStarting: " + session + " -- input: " + input);
	}

	@Override
	public void sessionStarted(RequestContext context, FlowSession session) {
		// TODO Auto-generated method stub
		super.sessionStarted(context, session);
		logger.debug("sessionStarted: " + session);
	}

	@Override
	public void eventSignaled(RequestContext context, Event event) {
		// TODO Auto-generated method stub
		super.eventSignaled(context, event);
		logger.debug("eventSignaled:  " + event);
	}

	@Override
	public void transitionExecuting(RequestContext context,
			TransitionDefinition transition) {
		// TODO Auto-generated method stub
		super.transitionExecuting(context, transition);
		logger.debug("transitionExecuting:  " + transition);
	}

	@Override
	public void stateEntering(RequestContext context, StateDefinition state)
			throws EnterStateVetoException {
		// TODO Auto-generated method stub
		super.stateEntering(context, state);
		logger.debug("stateEntering: " + state);
	}

	@Override
	public void viewRendered(RequestContext context, View view,
			StateDefinition viewState) {
		// TODO Auto-generated method stub
		super.viewRendered(context, view, viewState);
		logger.debug("viewRendered: " + view + " -- viewState: " + viewState );
	}

	@Override
	public void viewRendering(RequestContext context, View view,
			StateDefinition viewState) {
		// TODO Auto-generated method stub
		super.viewRendering(context, view, viewState);
		logger.debug("viewRendering: " + view + " -- viewState:" + viewState );
	}

	@Override
	public void stateEntered(RequestContext context,
			StateDefinition previousState, StateDefinition newState) {
		// TODO Auto-generated method stub
		super.stateEntered(context, previousState, newState);
		logger.debug("stateEntered: " + newState + " -- prev state: " + previousState);
	}

	@Override
	public void paused(RequestContext context) {
		// TODO Auto-generated method stub
		super.paused(context);
		logger.debug("paused");
	}

	@Override
	public void resuming(RequestContext context) {
		// TODO Auto-generated method stub
		super.resuming(context);
		logger.debug("resuming");
	}

	@Override
	public void sessionEnding(RequestContext context, FlowSession session,
			String outcome, MutableAttributeMap output) {
		// TODO Auto-generated method stub
		super.sessionEnding(context, session, outcome, output);
		logger.debug("sessionEnding");
	}

	@Override
	public void sessionEnded(RequestContext context, FlowSession session,
			String outcome, AttributeMap output) {
		// TODO Auto-generated method stub
		super.sessionEnded(context, session, outcome, output);
		logger.debug("sessionEnded");
	}

	@Override
	public void exceptionThrown(RequestContext context,
			FlowExecutionException exception) {
		super.exceptionThrown(context, exception);
		logger.error("Active Flow (" + context.getActiveFlow().getId()
				+ ") threw exception in state " + context.getCurrentState(),
				exception);
		
		logger.error("Current Event: " + context.getCurrentEvent());
		logger.error("Current Transition: " + context.getCurrentTransition());
		logger.error("Current View: " + context.getCurrentView());

	}

}

