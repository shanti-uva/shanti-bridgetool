package edu.virginia.shanti.om.bridge.service;

public interface SessionAffinity {

	String getAffinityId();

	String getSession();

	String getServer();

}