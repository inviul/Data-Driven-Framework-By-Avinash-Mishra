package Base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage extends BaseTest{
	
	public static void clickBy(String loc, String exp, WebDriver driver){
		try{
			if(loc.equalsIgnoreCase("xpath")){
				driver.findElement(By.xpath(exp)).click();
				logger.info("User clicked by xpath- "+loc);
			}else if(loc.equalsIgnoreCase("id")){
				driver.findElement(By.id(exp)).click();
				logger.info("User clicked by id- "+loc);
			}else {
				logger.info("User didn't provide any locator");
			}
		}catch (Exception e){
			e.printStackTrace();
		}

	}
	
	public static void type(String loc, String exp, String text,  WebDriver driver){
		try{
			if(loc.equalsIgnoreCase("xpath")){
				driver.findElement(By.xpath(exp)).sendKeys(text);
				logger.info("User types by xpath- "+loc);
			}else if(loc.equalsIgnoreCase("id")){
				driver.findElement(By.id(exp)).sendKeys(text);
				logger.info("User types by id- "+loc);
			}else {
				logger.info("User didn't provide any locator");
			}
		}catch (Exception e){
			e.printStackTrace();
		}
	}
	
	public static void explicitlyWait(WebDriver driver, WebElement element){
		try{
			WebDriverWait wait = new WebDriverWait(driver, 10);
			wait.until(ExpectedConditions.visibilityOf(element));
			logger.info("Visiblity checked for- "+element);
		}catch (Exception e){
			e.printStackTrace();
		}
	}

}
