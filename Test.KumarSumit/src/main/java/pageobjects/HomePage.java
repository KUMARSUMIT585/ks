package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import utilities.Constants;
import utilities.DriverBase;
import pageobjects.MyAccountPage;

public class HomePage extends DriverBase {
	public WebDriver driver;

	public HomePage(WebDriver driver) {
		this.driver = driver;
	}

	// contains the element identifiers for all the elements on the Home Page &
	// Methods applicable
	// on the Home Page such as Login , Search T Shirt & so on..
	public static final By lnk_SignIn = By.xpath("//*[@id='header']/div[2]/div/div/nav/div[1]/a");
	public static final By txtBx_Email = By.id("email");
	public static final By txtBx_Password = By.id("passwd");
	public static final By btn_SignIn = By.id("SubmitLogin");
	public static final By btn_SignOut = By.xpath("//*[@id='header']/div[2]/div/div/nav/div[2]/a");

	public void launchApp1() {
		driver = new SafariDriver();
		driver.get(Constants.APP_URL);
		driver.manage().window().maximize();

	}

	public void loginApp(String userName, String password) throws InterruptedException {
		Thread.sleep(100);
		driver.findElement(lnk_SignIn).click();
		Thread.sleep(5000);
		driver.findElement(txtBx_Email).sendKeys(Constants.USER_NAME);
		driver.findElement(txtBx_Password).sendKeys(Constants.USER_PASSWORD);
		driver.findElement(btn_SignIn).click();
		Thread.sleep(5000);
		// return driver;
	}

	public void navigatePersonalInformation() throws InterruptedException {
		driver.findElement(MyAccountPage.btn_MyPersonalInformation).click();
		Thread.sleep(5000);
	}

}
