package Test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParametersAnnotationUses {
	
	
  @Test
  @Parameters("url")
  public void parametersAnnotationExample(String url) {
	  
	  System.out.println("Value assigned from testng.xml is- "+url);
	  
	  System.setProperty("webdriver.chrome.driver", "C:\\Selenium\\chromedriver.exe");
	  	 
  	  WebDriver driver = new ChromeDriver();
  	  
  	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  
  	  driver.get(url);
	  
  	  driver.manage().window().maximize();
  	
  	  driver.close();
		  
	  driver.quit();
  }
}
