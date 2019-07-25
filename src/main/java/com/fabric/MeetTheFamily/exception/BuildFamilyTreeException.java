package com.fabric.MeetTheFamily.exception;

public class BuildFamilyTreeException extends Exception {
	
	public BuildFamilyTreeException(String errorMessage) {
		super(errorMessage);
	}

	public BuildFamilyTreeException(Exception ex) {
		super(ex.getMessage());
	}

}
