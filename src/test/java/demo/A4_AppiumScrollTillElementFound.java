package demo;

import java.net.MalformedURLException;

import org.openqa.selenium.By;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import demo.helper.AppDriver;
import demo.helper.AppFactory;
import demo.helper.AppOptions;
import demo.helper.Utils;



public class A4_AppiumScrollTillElementFound {

	static AppiumDriver driver; 

	
	/*
	 * Scroll till Element found
	 */
	public static void swipeTill() throws InterruptedException {
		AppDriver.getDriver().findElement(AppiumBy.accessibilityId("Swipe")).click();	
		Thread.sleep(4000);
		
		By elementToFind = By.xpath("//android.widget.TextView[@text='EXTENDABLE']");
		Utils.scrollTill(elementToFind);
		AppDriver.getDriver().findElement(elementToFind).click();
	}
	
	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		System.out.println("---------- Run Started ----------");
		
		//Initialise Driver 
		AppOptions option = new AppOptions();
		AppFactory.androidLaunchApp(option.getOptions("app3"));
		
		//method
		swipeTill();
		
		System.out.println("---------- Run Finished ----------");
	}

}
