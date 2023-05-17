package demo;

import org.openqa.selenium.By;
import io.appium.java_client.AppiumDriver;
import demo.helper.AppDriver;
import demo.helper.AppFactory;
import demo.helper.AppOptions;

/*
 * 
 * Demo WebSite: https://opensource-demo.orangehrmlive.com/web/index.php/auth/login
 * 
 * For locators directly use Desktop's Chrome Browser
 * For Mobile view use Chrome Devloper Tool > Toggle Device Tool bar
 * 
 */
public class A7_AppiumBrowserAutomation {

	static AppiumDriver driver;

	public static void testLogin() throws Exception {
		AppDriver.getDriver().get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		Thread.sleep(2000);
		AppDriver.getDriver().findElement(By.name("username")).sendKeys("Admin");
		AppDriver.getDriver().findElement(By.name("password")).sendKeys("admin123");
		AppDriver.getDriver().findElement(By.xpath("//button[@type='submit']")).click();

		Thread.sleep(4000);
		AppDriver.getDriver().findElement(By.xpath("//h6/following::i[1]")).click();
		Thread.sleep(2000);
		AppDriver.getDriver().findElement(By.xpath("//a[text()='Logout']")).click();
	}

	public static void main(String[] args) throws Exception {
		System.out.println("---------- Run Started ----------");

		// Initialise Driver
		AppOptions option = new AppOptions();
		AppFactory.androidLaunchApp(option.getOptions("Chrome"));

		// method
		testLogin();

		System.out.println("---------- Run Finished ----------");
	}

}
