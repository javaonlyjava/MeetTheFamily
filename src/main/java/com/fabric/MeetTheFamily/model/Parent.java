package com.fabric.MeetTheFamily.model;

public abstract class Parent {
	
	protected String parentName;
	
	protected String relationShip;
	
	public Parent(String parentName, String relationShip) {
		this.parentName = parentName;
		this.relationShip = relationShip;		
	}
	
	public abstract String displayMe();

	public String getParentName() {
		return parentName;
	}

	public void setParentName(String parentName) {
		this.parentName = parentName;
	}

	public String getRelationShip() {
		return relationShip;
	}

	public void setRelationShip(String relationShip) {
		this.relationShip = relationShip;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((parentName == null) ? 0 : parentName.hashCode());
		result = prime * result + ((relationShip == null) ? 0 : relationShip.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Parent other = (Parent) obj;
		if (parentName == null) {
			if (other.parentName != null)
				return false;
		} else if (!parentName.equals(other.parentName))
			return false;
		if (relationShip == null) {
			if (other.relationShip != null)
				return false;
		} else if (!relationShip.equals(other.relationShip))
			return false;
		return true;
	}
	
	
		

}
