package utilities;

import java.lang.reflect.Method;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import org.testng.*;
import utilities.Constants;

/**
 * This is the Driver Class where the driver, extent reports , extent tests are
 * set up for the tests and all set up and tear down operations are performed
 * here like closing the App, launching App URL & loading test data
 * 
 * @author kumarsumit
 *
 */

public class DriverBase {
	public WebDriver driver;
	public ExtentReports reports;
	public ExtentTest test;

	public WebDriver launchApp() {
		//driver = new SafariDriver();
		System.setProperty("webdriver.chrome.driver", "./src/main/java/Driver/chromedriver.exe");
		driver=new ChromeDriver();
		driver.get(Constants.APP_URL);
		driver.manage().window().maximize();
		return driver;

	}

}
