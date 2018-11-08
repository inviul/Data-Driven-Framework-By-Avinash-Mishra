package Test;

import org.testng.annotations.Test;

public class DependenciesSample {
	
	
	 @Test(dependsOnMethods = {"testMethod2"})
	  public void testMethod1() {
		  System.out.println("This is test method 1 invoking...");
	  }
	 
	 @Test
	  public void testMethod2() {
		  System.out.println("This is test method 2 invoking...");
	  }
}
