package edu.virginia.shanti.om.bridge.form;

public interface ConfigBean {
	
	String getUser();
	
	void setUser(String user);

	String getLocalContext();

	void setLocalContext(String localContext);

	String getLocalSubContext();

	void setLocalSubContext(String localSubContext);
	
	String getRemoteService();
	
	void setRemoteService(String remoteService);
	
	String getServiceLabel();
	
	void setServiceLabel(String serviceLabel);

}
