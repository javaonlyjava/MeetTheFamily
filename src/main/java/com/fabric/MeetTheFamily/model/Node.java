package com.fabric.MeetTheFamily.model;

/**
 *  This is a child class representing a node in the tree.
 * @author Nitin
 *
 */

public class Node extends Parent {
	
	private String childName;
	private String gender;

	public Node(String parentName, String relationShip) {
		super(parentName, relationShip);
		// TODO Auto-generated constructor stub
	}
	
	public Node(String parentName, String childName, String relationShip, String gender) {
		super(parentName, relationShip);
		this.childName = childName;
		this.gender = gender;
	}

	@Override
	public String displayMe() {
		return "Parent Name = " + parentName + " " + "relationShip =" + relationShip + "childName=" + childName + " Gender=" + gender; 
	}

	public String getChildName() {
		return childName;
	}

	public void setChildName(String childName) {
		this.childName = childName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((childName == null) ? 0 : childName.hashCode());
		result = prime * result + ((gender == null) ? 0 : gender.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Node other = (Node) obj;
		if (childName == null) {
			if (other.childName != null)
				return false;
		} else if (!childName.equals(other.childName))
			return false;
		if (gender == null) {
			if (other.gender != null)
				return false;
		} else if (!gender.equals(other.gender))
			return false;
		return true;
	}
	
	


}
