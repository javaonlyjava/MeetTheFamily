
package com.fabric.MeetTheFamily;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.Banner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;


import com.fabric.MeetTheFamily.service.BuildFamilyTree;


import com.fabric.MeetTheFamily.exception.BuildFamilyTreeException;;

/**
 * This Family Tree coding test is done for Fabric group by Nitin Aggarwal.
 * @author Nitin
 *
 */
@ComponentScan("com.fabric.MeetTheFamily")
@SpringBootApplication
public class App implements CommandLineRunner 
{
	@Autowired
	BuildFamilyTree buildFamilyTree;
	
    public static void main( String[] args ) throws Exception
    {
    	SpringApplication app = new SpringApplication(App.class);
        app.setBannerMode(Banner.Mode.OFF);
        app.run(args);
    }
    
    @Override
    public void run(String...args) throws BuildFamilyTreeException {
    	buildFamilyTree.executeTree(args);
    }
}
