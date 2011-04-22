package edu.virginia.shanti.om.bridge.domain;


public enum LocalContextType {
	
    COLLABORATION ("collaboration"), COURSE ("course");
    
    private String type;

	private LocalContextType(String type) {
    	this.type = type;
    }
	
	public String getType() {
		return type;
	}
	
	public String toString() {
		return type;
	}
    
}
