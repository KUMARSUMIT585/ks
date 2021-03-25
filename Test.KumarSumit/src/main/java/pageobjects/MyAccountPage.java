package pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import utilities.Constants;
import utilities.DriverBase;

public class MyAccountPage extends DriverBase {

	public WebDriver driver;

	public MyAccountPage(WebDriver driver) {
		this.driver = driver;
	}

	// contains the element identifiers for all the elements on the My Accounts
	// Page &
	// Methods applicable
	// on the Home Page such as extract last name , see and edit personal info &
	// so on..
	public static final By btn_TShirts = By.xpath("//*[@id='block_top_menu']/ul/li[3]/a");
	public static final By btn_MyPersonalInformation = By.xpath("//*[@id='center_column']/div/div[1]/ul/li[4]/a/span");
	public static final By btn_OrderHistoryAndDetails = By.xpath("//*[@id='center_column']/div/div[1]/ul/li[1]/a");

	public void editLastName(WebDriver driver, String lastName, String password) {
		driver.findElement(txtBx_LastName).clear();
		driver.findElement(txtBx_LastName).sendKeys(lastName);
		driver.findElement(txtBx_ConfirmPassword).sendKeys(password);
		driver.findElement(txtBx_CurrentPassword).sendKeys(password);
		driver.findElement(txtBx_NewPassword).sendKeys(password);
		driver.findElement(btn_Save).click();
	}

	public String extractLastName() {
		String lastName = "";
		String arr[];
		String tempText = "";
		tempText = driver.findElement(txt_LastName).getText().toString();
		arr = tempText.split(" ");
		lastName = arr[1];
		return lastName;

	}

	public static final By btn_AddToCart = By.xpath("//*[@id='center_column']/ul/li/div/div[2]/div[2]/a[1]");

	// personal information page
	public static final By txtBx_LastName = By.id("lastname");
	public static final By btn_Save = By.xpath("//*[@id='center_column']/div/form/fieldset/div[11]/button");
	public static final By txtBx_CurrentPassword = By.id("old_passwd");
	public static final By txtBx_NewPassword = By.id("passwd");
	public static final By txtBx_ConfirmPassword = By.id("confirmation");

	// personal information update confirmation
	public static final By txt_PersonalInformationUpdateConfirmation = By.xpath("//*[@id='center_column']/div/p");
	public static final By txt_LastName = By.xpath("//*[@id='header']/div[2]/div/div/nav/div[1]/a/span");

}
