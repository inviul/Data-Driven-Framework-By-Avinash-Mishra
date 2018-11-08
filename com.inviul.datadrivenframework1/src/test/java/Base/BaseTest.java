package Base;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import Utilities.Log;

public class BaseTest {
	
	public static Logger logger = Log.getLogData(Log.class.getName());
	
	public static ResourceBundle resource;
	
	public static String screenshotPath;
	
	public static WebDriver setUpBrowser(String testCaseName, WebDriver driver){
		
		resource = ResourceBundle.getBundle("config");
		
		String browser = resource.getString("browser");
		
		String url = resource.getString("url");
		
		if(!(browser==null)){
			SimpleDateFormat df = new SimpleDateFormat("HH::MM::SS");
			Date date = new Date();
			
			String formattedDate = df.format(date).toString().trim();
			
			logger.info("\n"
					+ "\n Test Case Name	: "
					+ testCaseName
					+"\n Start Time			: "
					+ formattedDate
					+ "\n URL				: "
						+url
						+"\n----------------------------------------");
			
			logger.info("Browser is- "+browser);
			
			if(browser.equalsIgnoreCase("chrome")){
				String chromeDriverPath = resource.getString("chromedriver_path");
				
				System.setProperty("webdriver.chrome.driver", chromeDriverPath);
				
				driver = new ChromeDriver();
				
				driver.get(url);
				
				driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				
				driver.manage().window().maximize();
				
				logger.info("Website opened");
				
			}else {
				logger.error("Please configure your framework for other browsers");
			}
			
		} else {
			logger.error("Please add browser");
		}
		return driver;
		
		
	}
	
	public void tearDown(ExtentTest test, ExtentReports report, WebDriver driver){
		driver.close();
		driver.quit();
		
		report.endTest(test);
		report.flush();
		report.close();
		
	}
	
	static String desti;
	public static String captureScreenshot(WebDriver driver){
		try{
			screenshotPath = new File("").getAbsolutePath().toString().trim()+"/TestReport/Screenshot";
			
			TakesScreenshot ts = (TakesScreenshot)driver;
			File source = ts.getScreenshotAs(OutputType.FILE);
			
			String str = Thread.currentThread().getClass().getName();
			
			 desti = screenshotPath+str+System.nanoTime()+".png";
			File Destination = new File(desti);
			
			FileUtils.copyFile(source, Destination);
			logger.info("Screenshot captured- "+desti);
			
			
			
		}catch (IOException e){
			e.printStackTrace();
		}
		return desti;
	}
	
	public static ExtentTest generateTest(ExtentReports report, String testName, String desc){
		ExtentTest test = report.startTest(testName, desc);
		return test;
	}
	
	public static void reportFail(WebDriver driver, ExtentTest test, String expected, String actual){
		String scrn = captureScreenshot(driver);
		
		String img = test.addScreenCapture(scrn);
		
		test.log(LogStatus.FAIL, expected+", Actual result: "+actual, img);
		
	}
	
	public static void reportPass(ExtentTest test, String expected, String actual){
		test.log(LogStatus.PASS, expected, actual);
	}
		

}
