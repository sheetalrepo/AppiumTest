package testcases;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.google.common.collect.ImmutableMap;

import helper.DriverRepo;
import helper.Logo;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;

public class ZMainClass {

	public static void startChromeBrowser() throws MalformedURLException {
		DesiredCapabilities capabilities = DriverRepo.ANDROID_NEXUS_5_API24_CHROME.getDesiredCapabilities();

		AppiumDriver<MobileElement> driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub/"),
				capabilities);
		// driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get("https://www.google.com/");
	}

	public static void startNexusAndroidApp() throws MalformedURLException {
		DesiredCapabilities capabilities = DriverRepo.ANDROID_NEXUS_5_API24_APP.getDesiredCapabilities();

		AppiumDriver<MobileElement> driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub/"),
				capabilities);
		// driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		// driver.get("https://www.google.com/");
	}
	
	public static void startPixelAndroidApp() throws MalformedURLException {
		DesiredCapabilities capabilities = DriverRepo.ANDROID_PIXEL_4_API27_APP.getDesiredCapabilities();

		AppiumDriver<MobileElement> driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub/"),
				capabilities);
		// driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		// driver.get("https://www.google.com/");
	}

	public static void main(String [] args) throws MalformedURLException {
		System.out.println("Hola");
		//startChromeBrowser();
		//startNexusAndroidApp();
		startPixelAndroidApp();
		
	}
}
