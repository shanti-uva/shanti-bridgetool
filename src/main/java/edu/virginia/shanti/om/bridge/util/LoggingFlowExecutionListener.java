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
		logger.warn("requestSubmitted: " + context);
	}

	@Override
	public void requestProcessed(RequestContext context) {
		// TODO Auto-generated method stub
		super.requestProcessed(context);
		logger.warn("requestProcessed: " + context);
	}

	@Override
	public void sessionCreating(RequestContext context,
			FlowDefinition definition) {
		// TODO Auto-generated method stub
		super.sessionCreating(context, definition);
		logger.warn("sessionCreating: " + definition);
	}

	@Override
	public void sessionStarting(RequestContext context, FlowSession session,
			MutableAttributeMap input) {
		// TODO Auto-generated method stub
		super.sessionStarting(context, session, input);
		logger.warn("sessionStarting: " + session + " -- input: " + input);
	}

	@Override
	public void sessionStarted(RequestContext context, FlowSession session) {
		// TODO Auto-generated method stub
		super.sessionStarted(context, session);
		logger.warn("sessionStarted: " + session);
	}

	@Override
	public void eventSignaled(RequestContext context, Event event) {
		// TODO Auto-generated method stub
		super.eventSignaled(context, event);
		logger.warn("eventSignaled:  " + event);
	}

	@Override
	public void transitionExecuting(RequestContext context,
			TransitionDefinition transition) {
		// TODO Auto-generated method stub
		super.transitionExecuting(context, transition);
		logger.warn("transitionExecuting:  " + transition);
		System.err.println("transitionExecuting:  " + transition);
	}

	@Override
	public void stateEntering(RequestContext context, StateDefinition state)
			throws EnterStateVetoException {
		// TODO Auto-generated method stub
		super.stateEntering(context, state);
		logger.warn("stateEntering: " + state);
		System.err.println("stateEntering: " + state);
	}

	@Override
	public void viewRendered(RequestContext context, View view,
			StateDefinition viewState) {
		// TODO Auto-generated method stub
		super.viewRendered(context, view, viewState);
		logger.warn("viewRendered: " + view + " -- viewState: " + viewState );
		System.err.println("viewRendered: " + view + " -- viewState: " + viewState );
	}

	@Override
	public void viewRendering(RequestContext context, View view,
			StateDefinition viewState) {
		// TODO Auto-generated method stub
		super.viewRendering(context, view, viewState);
		logger.warn("viewRendering: " + view + " -- viewState:" + viewState );
		System.err.println("viewRendering: " + view + " -- viewState:" + viewState);
	}

	@Override
	public void stateEntered(RequestContext context,
			StateDefinition previousState, StateDefinition newState) {
		// TODO Auto-generated method stub
		super.stateEntered(context, previousState, newState);
		logger.warn("stateEntered: " + newState + " -- prev state: " + previousState);
		System.err.println("stateEntered: " + newState + " -- prev state: " + previousState);
	}

	@Override
	public void paused(RequestContext context) {
		// TODO Auto-generated method stub
		super.paused(context);
		logger.warn("paused");
	}

	@Override
	public void resuming(RequestContext context) {
		// TODO Auto-generated method stub
		super.resuming(context);
		logger.warn("resuming");
	}

	@Override
	public void sessionEnding(RequestContext context, FlowSession session,
			String outcome, MutableAttributeMap output) {
		// TODO Auto-generated method stub
		super.sessionEnding(context, session, outcome, output);
		logger.warn("sessionEnding");
	}

	@Override
	public void sessionEnded(RequestContext context, FlowSession session,
			String outcome, AttributeMap output) {
		// TODO Auto-generated method stub
		super.sessionEnded(context, session, outcome, output);
		logger.warn("sessionEnded");
		System.err.println("sessionEnded");
	}

	@Override
	public void exceptionThrown(RequestContext context,
			FlowExecutionException exception) {
		super.exceptionThrown(context, exception);
		logger.error("Webflow " + context.getActiveFlow()
				+ " threw exception in " + context.getCurrentState(),
				exception);
		
		exception.printStackTrace();
	}

}

