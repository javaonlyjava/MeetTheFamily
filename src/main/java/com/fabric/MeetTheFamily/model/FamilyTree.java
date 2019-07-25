package com.fabric.MeetTheFamily.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

/**
 * This is the whole family tree model class.
 * Here we maintain the list of all nodes.
 * @author Nitin
 *
 */
@Component
public class FamilyTree {
	private ArrayList<Node> nodes;
	
	public FamilyTree() {
		nodes = new ArrayList<Node>();
	}
	
	public void addNode(String parentName, String childName, String relationShip, String gender) {
		nodes.add(new Node(parentName, childName, relationShip, gender));
	}
	
	public void getRelationships(String name, String relationship) {
		/*for(Node child : nodes){
			for(Node par : parent) {
				if(child.parent.equals(par.name)){
					return true;
				}
			}
		}*/
	}
	
	public List<Node> getNodes() {
		return nodes;
	}

}
