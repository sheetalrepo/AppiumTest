package demo.helper;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import io.appium.java_client.AppiumDriver;

/*
 * AppiumDriver extends RemoteWebDriver implements WebDriver
 * 
 * Threadlocal will handle Parallel running driver issues
 */
public class AppDriver {
	private static final ThreadLocal<AppiumDriver> driver = new ThreadLocal<>();

	public static AppiumDriver getDriver() {
		return driver.get();
	}

	public static void setDriver(AppiumDriver Driver) {
		driver.set(Driver);
		System.out.println("---------- Appium Driver has been set (Threadlocal) ----------");
	}
}
