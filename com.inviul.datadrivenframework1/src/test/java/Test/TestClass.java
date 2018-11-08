package Test;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class TestClass {
	
  @Test(dataProvider="dataProvider")
  public void readData(String u, String p) {
	 
	  System.out.println(u+" - "+p);
	  
	  
  }
	  

@DataProvider(name="dataProvider")
  public Object[][] dataMethod(){
	  Object[][] data = new Object[2][2];
	  
	  data[0][0] = "First Name";
	  data[0][1] = "Last Name";
	  
	  data[1][0] = "Avinash";
	  data[1][1] = "Mishra";
	return data;
	 
  }
}
