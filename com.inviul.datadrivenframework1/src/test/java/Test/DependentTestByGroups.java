package Test;

import org.testng.annotations.Test;

public class DependentTestByGroups {
 
	 @Test(groups = {"group1"})
	  public void testMethodByGroup1() {
		  System.out.println("This is test method by group 1 invoking...");
	  }
	 
	 @Test(groups = {"group2"})
	  public void testMethodByGroup2() {
		  System.out.println("This is test method by group 2 invoking...");
	  }
}
