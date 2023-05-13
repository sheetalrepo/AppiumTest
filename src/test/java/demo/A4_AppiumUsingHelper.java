package demo;

import java.net.MalformedURLException;
import java.net.URL;

import demo.helper.AppDriver;
import demo.helper.AppFactory;
import demo.helper.AppOptions;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;


/*
 * This class will work with SauceLab Apk file
 * 
 * class AndroidDriver extends AppiumDriver
 * 
 * 
 */
public class A4_AppiumUsingHelper {

	static AppiumDriver driver; 
	//static AndroidDriver driver; 

	//App > Activity > Animation > Back to home page
	public void testSaucelabBasicFlow() throws InterruptedException {
		driver.findElement(AppiumBy.accessibilityId("open menu")).click();
		Thread.sleep(1000L);
		driver.findElement(AppiumBy.accessibilityId("menu item log in")).click();;
		Thread.sleep(1000L);
		driver.findElement(AppiumBy.accessibilityId("Username input field")).sendKeys("bob@example.com");;
		Thread.sleep(1000L);
		driver.findElement(AppiumBy.accessibilityId("Password input field")).sendKeys("10203040");;
		Thread.sleep(1000L);
		driver.findElement(AppiumBy.xpath("//android.view.ViewGroup[@content-desc='Login button']")).click();;
	}
		
	
	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		AppFactory.androidLaunchApp(new AppOptions().getOptions("app2"));
		driver = AppDriver.getDriver();

		A4_AppiumUsingHelper obj = new A4_AppiumUsingHelper();
		obj.testSaucelabBasicFlow();
		
		System.out.println("---------- Run Finished ----------");
	}

}
