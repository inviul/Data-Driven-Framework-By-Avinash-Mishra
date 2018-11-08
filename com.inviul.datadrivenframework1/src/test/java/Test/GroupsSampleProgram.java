package Test;

import org.testng.annotations.Test;

public class GroupsSampleProgram {
	
  @Test(groups = {"Sanity"})
  public void sanityTest1() {
	  System.out.println("This is sanity test 1");
  }
  
  @Test(groups = {"Regression"})
  public void regressionTest1() {
	  System.out.println("This is regression test 1");
  }
  
  @Test(groups = {"Sanity"})
  public void sanityTest2() {
	  System.out.println("This is sanity test 2");
  }
  
  @Test(groups = {"Regression"})
  public void regressionTest2() {
	  System.out.println("This is regression test 2");
  }
  
  @Test(groups = {"Sanity"})
  public void sanityTest3() {
	  System.out.println("This is sanity test 3");
  }
  
  @Test(groups = {"Regression"})
  public void regressionTest3() {
	  System.out.println("This is regression test 3");
  }
  
  @Test(groups = {"Sanity"})
  public void sanityTest4() {
	  System.out.println("This is sanity test 4");
  }
  
  @Test(groups = {"Regression"})
  public void regressionTest4() {
	  System.out.println("This is regression test 4");
  }
  
  @Test(groups = {"Sanity", "Regression"})
  public void regressionSanity() {
	  System.out.println("This is regression and Sanity both");
  }
}
