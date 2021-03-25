package pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import utilities.Constants;
import utilities.DriverBase;

public class TShirtPage extends DriverBase {

	public WebDriver driver;

	public TShirtPage(WebDriver driver) {
		this.driver = driver;
	}

	// contains the element identifiers for all the elements on the My Accounts
	// Page &
	// Methods applicable
	// on the T shirt Page such as order tshirt & validate order
	// so on..
	public static final By btn_TShirts = By.xpath("//*[@id='block_top_menu']/ul/li[3]/a");
	public static final By btn_MyPersonalInformation = By.xpath("//*[@id='center_column']/div/div[1]/ul/li[4]/a/span");
	public static final By btn_OrderHistoryAndDetails = By.xpath("//*[@id='center_column']/div/div[1]/ul/li[1]/a");
	public static final By img_TShirt = By.xpath("//*[@id='center_column']/ul/li/div/div[1]/div/a[1]/img");
	public static final By btn_Cross = By.xpath("//*[@id='category']/div[2]/div/div/a");
	public static final By btn_AddToCart = By.xpath("//*[@id='center_column']/ul/li/div/div[2]/div[2]/a[1]");

	public void placeOrder() throws InterruptedException {
		driver.findElement(btn_TShirts).click();
		Thread.sleep(5000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");
		Thread.sleep(1000);
		driver.findElement(img_TShirt).click();
		Thread.sleep(5000);
		List<WebElement> buttons = driver.findElements(By.xpath("//span[contains(text(),'Add')]"));
		int buttonCount = 0;
		for (WebElement a : buttons) {

			if (buttonCount == buttonCount) {

				try {
					System.out.println("trying to click ");
					System.out.println("Button count" + buttonCount);

					System.out.println("detail sof web element " + a.getClass());
					System.out.println("detail sof web element " + a.getTagName());
					System.out.println("detail sof web element " + a.toString());

					JavascriptExecutor js11 = (JavascriptExecutor) driver;
					js.executeScript("arguments[0].click();", a);
					System.out.println(a.getText());
				} catch (Exception e) {
					System.out.println("Excpetion is " + e.toString());
				}
			}
			buttonCount++;
		}
		Thread.sleep(1000);

		driver.findElement(btn_Cross).click();
		driver.findElement(By.xpath("//*[@id='layer_cart']/div[1]/div[2]/div[4]/a")).click();
		driver.findElement(By.xpath("//*[@id='center_column']/p[2]/a[1]")).click();

		driver.findElement(By.xpath("//*[@id='center_column']/form/p/button")).click();

		driver.findElement(By.id("cgv")).click();

		driver.findElement(By.xpath("//*[@id='form']/p/button")).click();

		driver.findElement(By.xpath("//*[@id='HOOK_PAYMENT']/div[1]/div/p/a")).click();

		driver.findElement(By.xpath("//*[@id='cart_navigation']/button")).click();

		driver.findElement(By.xpath("//*[@id='center_column']/p/a")).click();

	}
	
	public boolean ValidateTShirtOrder()
	{
		if (driver.findElement(By.xpath("//*[@id='order-list']/tbody/tr[1]/td[1]/a")).isDisplayed())
		{
			return true;
		}
		else {
			return false;
		}
	}

}
