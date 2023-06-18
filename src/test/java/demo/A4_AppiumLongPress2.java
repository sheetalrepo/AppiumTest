package demo;

import java.net.MalformedURLException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import io.appium.java_client.AppiumDriver;
import demo.helper.AppDriver;
import demo.helper.AppFactory;
import demo.helper.AppOptions;
import demo.helper.Utils;

/*
 * Using Framework related classes
 * 
 * functionally same as previous class
 */
public class A4_AppiumLongPress2 {

	static AppiumDriver driver;

	// Views > Expandable Lists > Custom Adapter > Dog Names (Long Press)
	public static void testLongPress() throws InterruptedException {
		AppDriver.getDriver().findElement(By.xpath("//android.widget.TextView[@content-desc='Views']")).click();
		AppDriver.getDriver().findElement(By.xpath("//android.widget.TextView[@content-desc='Expandable Lists']")).click();
		AppDriver.getDriver().findElement(By.xpath("//android.widget.TextView[@content-desc='1. Custom Adapter']")).click();

		WebElement dogNames = AppDriver.getDriver().findElement(By.xpath("//*[contains(@text,'Dog')]"));
		Utils.longPress(dogNames);
		Thread.sleep(3000);
		AppDriver.getDriver().findElement(By.xpath("//android.widget.TextView[@text='Sample action']")).click();
	}

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		System.out.println("---------- Run Started ----------");

		// Initialise Driver
		AppOptions option = new AppOptions();
		AppFactory.androidLaunchApp(option.getOptions("app1"));

		// method
		testLongPress();
		
		System.out.println("---------- Run Finished ----------");
	}

}
