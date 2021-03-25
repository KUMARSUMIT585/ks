package stepImplementations;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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

public class UpdateAndVerifyPersonalInformationTest {

	// TODO Auto-generated constructor stub

	// TODO Auto-generated constructor stub

	WebDriver driver;
	ExtentReports reports;
	ExtentTest test;
	ExtentReports extent;
	HomePage hm;
	DriverBase db = null;
	MyAccountPage mp;

	@Given("^user is already logged into the user account$")

	public void user_is_already_logged_into_the_user_account() throws InterruptedException {
		try {

			extent = new ExtentReports("./Reports/UpdatePersonalInfo.html", false);
			// starting test
			test = extent.startTest("Update Personal Info",
					"The user should be able to update and verify Perosnal Information");

			// hm.launchApp();
			if (db == null) {
				db = new DriverBase();
			}
			driver = db.launchApp();
			hm = new HomePage(driver);
			hm.loginApp(Constants.USER_NAME, Constants.USER_PASSWORD);
			hm.navigatePersonalInformation();
			test.log(LogStatus.PASS, "GIVEN user is already logged into the user account");

		} catch (Exception e) {
			System.out.println("The excpetion encountered-" + e.toString());
			test.log(LogStatus.FAIL, "GIVEN user is already logged into the user account");
			extent.endTest(test);
			// writing everything to document
			extent.flush();
			// driver.close();
		}
	}

	@When("^user clicks on the Personal Information and saves the changes$")
	public void user_clicks_on_the_Personal_Information_And_Saves_the_changes() throws InterruptedException {
		try {
			mp = new MyAccountPage(driver);
			mp.editLastName(driver, Constants.LAST_NAME, Constants.USER_PASSWORD);
			test.log(LogStatus.PASS, "WHEN user clicks on the Personal Information And Saves the changes");
		} catch (Exception e) {
			System.out.println("The excpetion encountered-" + e.toString());
			test.log(LogStatus.FAIL, "WHEN user clicks on the Personal Information And Saves the changes");
			extent.endTest(test);
			// writing everything to document
			extent.flush();
			driver.close();

		}
	}

	@Then("^user should be able to see the Updated personal information$")
	public void user_should_be_able_to_see_the_Updated_personal_information() throws InterruptedException {
		try {
			Thread.sleep(5000);
			String updatedLastName = mp.extractLastName();
			if (updatedLastName.equalsIgnoreCase(Constants.NEW_LAST_NAME)) {

				test.log(LogStatus.PASS, "THEN user should be able to see the Updated personal information");
			} else {
				test.log(LogStatus.FAIL, "THEN user should be able to see the Updated personal information");
			}
			// ending test
			extent.endTest(test);
			// writing everything to document
			extent.flush();
			driver.close();
		} catch (Exception e) {
			test.log(LogStatus.FAIL, "THEN user should be able to see the Updated personal information");
			System.out.println("The excpetion encountered-" + e.toString());
			// ending test
			extent.endTest(test);
			// writing everything to document
			extent.flush();
			// driver.close();
		}

	}

}
