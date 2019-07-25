package com.fabric.MeetTheFamily.service;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.fabric.MeetTheFamily.exception.BuildFamilyTreeException;
import com.fabric.MeetTheFamily.model.FamilyTree;
import com.fabric.MeetTheFamily.model.Node;
import com.fabric.MeetTheFamily.model.Relationships;


@Service
public class BuildFamilyTree {
	
	private FamilyTree familyTree;
	
	private static final String ADDCHILD = "ADD_CHILD";

	private static final String GETRELATIONSHIP = "GET_RELTIONSHIP";

	public BuildFamilyTree(FamilyTree familyTree) throws BuildFamilyTreeException {
		this.familyTree = familyTree;
		instantiateFamilyTree(familyTree);
	}
	
	
	private void instantiateFamilyTree(FamilyTree familyTree) throws BuildFamilyTreeException {
		addChild("", "Queen Margret", "Female");
		addChild("Queen Margret", "Flora", "Female");
		addChild("Queen Margret", "Audrey", "Female");
		addChild("Queen Margret", "Helen", "Female");
		addChild("Queen Margret", "Ginerva", "Female");
		addChild("Flora", "Victorie", "Female");
		addChild("Audrey", "Molly", "Female");
		
	}


	public void addChild (String motherName, String childName, String gender) throws BuildFamilyTreeException {
		/** first need to check if mother exists in the family tree */
		if (familyTree.getNodes().isEmpty()) {
			familyTree.addNode(motherName, childName, Relationships.Mother.name(), gender);
		} else if (getNodeBasedOnName(motherName) !=null && !familyTree.getNodes().isEmpty()) {
			familyTree.addNode(motherName, childName, Relationships.Mother.name(), gender);
		} else {
			 System.out.println(motherName + " does not exist in the family tree");
			 throw new BuildFamilyTreeException(motherName + "does not exist in the family tree");
		}
	}
	
	public void getRelationShip(String name, String relationship){
		int i = 0;
		ArrayList<String> names = new ArrayList<String>();
		//ArrayList<Node> nodes = familyTree.get(depth).nodes;
		//for(Node node : nodes){
		//	names.add(node.name);
		//}
		//Object[] names =  names.toArray();
		//Arrays.sort(names2);
		//for(Object name : names2) System.out.println(name);
	}
	
	public List<Node> getFamilyTree() {
		return familyTree.getNodes();
	}
	
	public Node getNodeBasedOnNameAndParentName(String name, String parentName) {
		for (Node node : familyTree.getNodes()) {
			if (node.getChildName().equalsIgnoreCase(name) && node.getParentName().equalsIgnoreCase(parentName)) {
				return node;
			}
		}
		return null;
	}
	
	public Node getNodeBasedOnName(String name) {
		for (Node node : familyTree.getNodes()) {
			if (node.getChildName().equalsIgnoreCase(name)) {
				return node;
			}
		}
		return null;
	}

	public void executeTree(String[] arguments) throws BuildFamilyTreeException {
		if (arguments==null) {
			throw new BuildFamilyTreeException("Please enter an input file with commands");
		} else {
			ClassLoader classLoader = getClass().getClassLoader();
			InputStream inputStream = classLoader.getResourceAsStream(arguments[0]);
			readFromInputStream(inputStream);
		}
		
	}
	
	private void readFromInputStream(InputStream inputStream)  throws BuildFamilyTreeException {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {
			 
		     String line;
		     while ((line = br.readLine()) != null) {
	    		   readandExecuteCommand(line);

	    		   
		     }
		 } catch (Exception ex) {
			    	throw new BuildFamilyTreeException (ex);
		}
		
	}
	
	private void readandExecuteCommand(String line) throws BuildFamilyTreeException {
		if (line!=null) {
			String[] lineArgs = convertLinetoLineArgs(line);
			String command= lineArgs[0];
			String motherName="";
			String childName=""; 
			String gender="";
			String name="";
			String relationShip="";
			if (lineArgs.length ==4 && command.equalsIgnoreCase(ADDCHILD)) {
				motherName=lineArgs[1];
				childName=lineArgs[2];
				gender=lineArgs[3];
				
			} else if (lineArgs.length ==3 && command.equalsIgnoreCase(GETRELATIONSHIP)) {
				name = lineArgs[1];
				relationShip=lineArgs[2];
			} else {
				throw new BuildFamilyTreeException("Input parameters entered is wrong");
			}
			switch (command) {
				case ADDCHILD : addChild(motherName,childName, gender);
					break;
				case GETRELATIONSHIP: getRelationShip(name, relationShip);
					break;
				
			}
		} else {
			throw new BuildFamilyTreeException("Please enter an input file with commands");
		}
		
	}

	private String[] convertLinetoLineArgs(String line) throws BuildFamilyTreeException {
		List<String> argsList = new ArrayList<String>();
		if (line.contains(" ")) {
			String[] spaceSplit = line.split(" ");
			for (int i=0; i<spaceSplit.length;i++) {
				argsList.add(spaceSplit[i]);
			}
			
		} else {
			throw new BuildFamilyTreeException("Wrong input parameters");
		}
		 
		
		String[] lineArgs = new String[argsList.size()];
		return argsList.toArray(lineArgs);
	}
	


}
