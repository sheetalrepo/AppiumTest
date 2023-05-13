package demo.helper;

import java.net.MalformedURLException;
import java.net.URL;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.options.XCUITestOptions;

public class AppFactory {
	static AppiumDriver driver;

	public static void androidLaunchApp(UiAutomator2Options options) throws MalformedURLException {
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/"), options);
		AppDriver.setDriver(driver);
		System.out.println("---------- Android Driver has been set ----------");
	}

	public static void iosLaunchApp(XCUITestOptions options) throws MalformedURLException {
		driver = new IOSDriver(new URL("http://127.0.0.1:4723/"), options);
		AppDriver.setDriver(driver);
		System.out.println("---------- iOS Driver has been set ----------");
	}
}
