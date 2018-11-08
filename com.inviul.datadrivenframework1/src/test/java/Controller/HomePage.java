package Controller;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.relevantcodes.extentreports.ExtentTest;

import Base.BasePage;
import Utilities.TestDataReader;

public class HomePage extends BasePage{

	private static final String searchBarId = "lst-ib";
	private static final String searchBtn = "//*[@name='btnK']";
	
	public static boolean searchValidation(WebDriver driver) throws IOException {
		
		boolean flag = false;
		
		WebElement element = driver.findElement(By.id(searchBarId));
		
		explicitlyWait(driver, element);
		
		String testValue = TestDataReader.getMapData("key1");
		
		type(searchBarId, "id", testValue, driver);
		
		clickBy(searchBtn, "xpath", driver);
		
		flag= true;
		
		return flag;
	}
	
	
	
}
