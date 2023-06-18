package demo;

import java.net.MalformedURLException;

import org.openqa.selenium.By;
import io.appium.java_client.AppiumBy;
import demo.helper.AppDriver;
import demo.helper.AppFactory;
import demo.helper.AppOptions;
import io.appium.java_client.android.AndroidDriver;
import java.util.ArrayList;
import java.util.Set;

/*
 * AndroidDriver extends AppiumDriver
 * 
 */
public class A6_AppiumNativeAppToWeb {

	static AndroidDriver driver;

	
	/*
	 * For Xpath, id, css etc
	 * https://webdriver.io/
	 * 
	 * Open hamburger > close it > click on Getting started button
	 */
	public static void nativeToWebToNative() throws InterruptedException {

		System.out.println("Current Context: " + driver.getContext());
		System.out.println("Current Handles: " + driver.getContextHandles());
		System.out.println("Go to WebView");
		driver.findElement(AppiumBy.accessibilityId("Webview")).click();
		Thread.sleep(5000);
		System.out.println("Current Handles: " + driver.getContextHandles());

		//Get All available Context - [NATIVE_APP, WEBVIEW_com.wdiodemoapp]
		Set<String> handles = driver.getContextHandles();
		String webContext = new ArrayList<String>(handles).get(1);
		System.out.println("Fetch WebContext: " + webContext);
		
		// Native to WebView
		driver.context(webContext);
		System.out.println("Current Context:" + webContext);
		Thread.sleep(1000);
		driver.findElement(By.cssSelector("[aria-label='Toggle navigation bar']")).click();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("[aria-label='Close navigation bar']")).click();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("[class='buttons_pzbO'] [href='/docs/gettingstarted']")).click();
		Thread.sleep(2000);
		
		// WebView to Native
		driver.context("NATIVE_APP");
		driver.findElement(AppiumBy.accessibilityId("Login")).click();
		Thread.sleep(1000);
		driver.findElement(AppiumBy.accessibilityId("input-email")).sendKeys("abc@gmail.com");
		Thread.sleep(2000);
	}

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		System.out.println("---------- Run Started ----------");

		// Initialise Driver
		AppOptions option = new AppOptions();
		AppFactory.androidLaunchApp(option.getOptions("app3"));

		//Android Driver
		driver = (AndroidDriver) AppDriver.getDriver();

		// method
		nativeToWebToNative();

		System.out.println("---------- Run Finished ----------");
	}

}
