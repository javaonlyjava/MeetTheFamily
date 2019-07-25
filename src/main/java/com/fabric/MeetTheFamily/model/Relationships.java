package com.fabric.MeetTheFamily.model;

public enum Relationships {
	
	PaternalUncle("Paternal-Uncle"), 
	MaternalUncle("Maternal-Uncle"),
	PaternalAunt("Paternal-Aunt"),
	Mother("Mother"),
	Father("Father");
	
	private final String relationship;
	
	Relationships(String relationship) {
		this.relationship = relationship;
	}
	
	public String getRelationship(String relationship) {
		return relationship;
	}

}
