package com.fabric.MeetTheFamily.service;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import com.fabric.MeetTheFamily.exception.BuildFamilyTreeException;
import com.fabric.MeetTheFamily.model.FamilyTree;
import com.fabric.MeetTheFamily.model.Node;

@RunWith(SpringRunner.class)
public class BuildFamilyTreesTest {
	
	private BuildFamilyTree buildFamilyTree;
	private FamilyTree familyTree;
	
	@Before
	public void setUp() throws BuildFamilyTreeException {
		familyTree = new FamilyTree();
		buildFamilyTree = new BuildFamilyTree(familyTree);
	}
	
	@Test
	public void testAddAChildMinerva() throws BuildFamilyTreeException {
		String[] arguments= new String[] { "test_file_Flora_Minerva.txt"};
		buildFamilyTree.executeTree(arguments);
		assertNotNull(buildFamilyTree.getNodeBasedOnNameAndParentName("Minerva", "Flora"));
		
	}
	
	@Test(expected = BuildFamilyTreeException.class)
	public void testAddAChildLolaToLuna() throws BuildFamilyTreeException {
		String[] arguments= new String[] { "test_file_Luna_Lola.txt"};
		buildFamilyTree.executeTree(arguments);
		assertNotNull(buildFamilyTree.getNodeBasedOnNameAndParentName("Lola", "Luna"));
		
	}

}
