package Test;

import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;

import Base.BaseTest;
import Controller.HomePage;

import org.testng.annotations.BeforeMethod;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;

public class MyTest extends BaseTest{
	WebDriver driver;
	
	ExtentReports extent;
	ExtentTest test;
	
	
  @Test
  public void myTest() throws Exception {
	  HomePage home = new HomePage();
	  
	  boolean testHome = home.searchValidation(driver);
	  
	  if(testHome==true){
		  reportPass(test, "Search Bar should display search results", "Search results displayed");
	  }else {
		  reportFail(driver, test, "Search Bar should display search results", "Search results didn't display");
		  throw new Exception();
	  }
	  
	  
	  
  }
  @BeforeMethod
  public void beforeMethod() {
	  extent = new ExtentReports(new File("").getAbsolutePath().toString().trim()+"TestReport/"+this.getClass().getSimpleName()+".html", false);
	  test = generateTest(extent, this.getClass().getSimpleName(), "This is first test");
	  
	  driver = setUpBrowser(this.getClass().getSimpleName(), driver);
	  
	  
  }

  @AfterMethod
  public void afterMethod() {
	  tearDown(test, extent, driver);
  }

}
