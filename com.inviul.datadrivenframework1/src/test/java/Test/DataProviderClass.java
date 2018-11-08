package Test;


import org.testng.annotations.DataProvider;

public class DataProviderClass {

  @DataProvider (name="dataProvider")
  public static Object[][] dp() {
	  return new Object[][] {
	    	{"First Name", "Last Name"},
	    	{"Avinash", "Mishra"}
	    };
   
  }
}
