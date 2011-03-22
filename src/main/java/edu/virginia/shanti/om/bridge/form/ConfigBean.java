package edu.virginia.shanti.om.bridge.form;

public interface ConfigBean {

	String getLocalContext();

	void setLocalContext(String localContext);

	String getLocalSubContext();

	void setLocalSubContext(String localSubContext);
	
	String getRemoteService();
	
	void setRemoteService(String remoteService);

}
