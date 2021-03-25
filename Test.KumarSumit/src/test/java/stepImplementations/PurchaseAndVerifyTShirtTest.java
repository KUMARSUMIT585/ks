package stepImplementations;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.safari.SafariDriver;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;

import utilities.Constants;
import utilities.DriverBase;
import pageobjects.HomePage;
import pageobjects.MyAccountPage;
import pageobjects.TShirtPage;

public class PurchaseAndVerifyTShirtTest {

	// TODO Auto-generated constructor stub

	WebDriver driver;
	ExtentReports reports;
	ExtentTest test;
	HomePage hm;
	TShirtPage tp;
	ExtentReports extent;
	DriverBase db = null;

	@Given("^user is logged into the user account$")
	public void user_is_logged_into_the_user_account() throws InterruptedException {
		try {

			extent = new ExtentReports("./Reports/TShirtPurchase.html", false);

			// starting test
			test = extent.startTest("T shirt purchase Test",
					"The user should be able to purchase and verify T Shirt in Orders");

			// hm.launchApp();
			if (db == null) {
				db = new DriverBase();
			}
			driver = db.launchApp();
			hm = new HomePage(driver);
			hm.loginApp(Constants.USER_NAME, Constants.USER_PASSWORD);
			test.log(LogStatus.PASS, "GIVEN user_is_logged_into_the_user_account");

		} catch (Exception e) {
			System.out.println("The exception encountered is " + e.toString());
			test.log(LogStatus.FAIL, "GIVEN user_is_logged_into_the_user_account");
			// driver.close();

			// ending test
			extent.endTest(test);

			// writing everything to document
			extent.flush();
		}
	}

	@When("^user clicks on the T shirt link & completes the purchase steps$")
	public void user_clicks_on_the_T_shirt_link_and_completes_the_purchase_steps() throws InterruptedException {
		try {
			tp = new TShirtPage(driver);
			tp.placeOrder();
			test.log(LogStatus.PASS, "WHEN user clicks on the T shirt link & completes the purchase steps");

			// *[@id="order-list"]/tbody/tr[1]/td[5]/span

		} catch (Exception e) {
			System.out.println("The exception encountered is " + e.toString());
			test.log(LogStatus.FAIL, "WHEN user clicks on the T shirt link & completes the purchase steps");
			// driver.close();

			// ending test
			extent.endTest(test);

			// writing everything to document
			extent.flush();
		}
	}

	@Then("^user should be able to see the T shirt in Orders$")
	public void user_should_be_able_to_see_the_T_shirt_in_orders() {
		try {
			if (tp.ValidateTShirtOrder()) {
				test.log(LogStatus.PASS, "THEN user should be able to see the T shirt in Orders");

			} else {
				test.log(LogStatus.FAIL, "THEN user should be able to see the T shirt in Orders");

			}
			// driver.close();

			// ending test
			extent.endTest(test);

			// writing everything to document
			extent.flush();

		} catch (Exception e) {
			test.log(LogStatus.FAIL, "THEN user should be able to see the T shirt in Orders");
			// driver.close();

			// ending test
			extent.endTest(test);

			// writing everything to document
			extent.flush();

		}
	}

}
