package demo;

import java.net.MalformedURLException;
import io.appium.java_client.AppiumBy;
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
public class A5_AppiumScrollB {

	static AppiumDriver driver; 

	public static void swipeMe() throws InterruptedException {
		AppDriver.getDriver().findElement(AppiumBy.accessibilityId("Swipe")).click();	
		Thread.sleep(4000);
		//Move page towards Right
		Utils.scroll("RIGHT", 0.5);
		Thread.sleep(2000);
		Utils.scroll("RIGHT", 0.5);
		Thread.sleep(2000);
		Utils.scroll("LEFT", 0.5);
		Thread.sleep(2000);
		Utils.scroll("DOWN", 0.8);
	}
	
	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		System.out.println("---------- Run Started ----------");
		
		//Initialise Driver 
		AppOptions option = new AppOptions();
		AppFactory.androidLaunchApp(option.getOptions("app3"));
		
		//method
		swipeMe();
		
		System.out.println("---------- Run Finished ----------");
	}

}
