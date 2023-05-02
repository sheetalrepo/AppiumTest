package pages;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.commons.io.FileUtils;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import helper.DriverRepo;
import helper.DriverRepo_v8;
import helper.Logo;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

/*
 * Base page is parent class of all page classes
 * contains all static general methods
 * reading property file + driver repo 
 * 
 * @author: sheetal
 */
public class BasePage {

	// static AppiumDriver driver;
	static AndroidDriver driver;

	public Properties properties;
	String cmd_osdevice, osdevice, device;
	static String os;

	public BasePage() throws MalformedURLException {
		getProperties();
		initDriver_v8(os, device);
	}

	public void getProperties() {
		// reading from properties file
		properties = new Properties();
		try {
			properties.load(new FileInputStream("src/test/resources/qa.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		// reading from command line
		cmd_osdevice = System.getProperty("osdevice");

		// priority will be given to cmd
		if (cmd_osdevice != null && !cmd_osdevice.trim().isEmpty()) {
			os = cmd_osdevice.split("#")[0];
			device = cmd_osdevice.split("#")[1];
			System.out.println("###------ Reading from mvn cmd line -----###");
			System.out.println("#OS = " + os);
			System.out.println("#Device = " + device);

		} else {
			osdevice = properties.getProperty("osdevice");
			os = osdevice.split("#")[0];
			device = osdevice.split("#")[1];
			System.out.println("###------ Reading from qa.properties file -----###");
			System.out.println("#OS = " + os);
			System.out.println("#Device = " + device);

		}
	}

	public void initDriver_v8(String os, String device) throws MalformedURLException {
		System.out.println("###------ Initialising Driver v8 -----###");

		if (os.equals("ANDROID") && device.equals("NEXUS_5_API24_APP")) {
			driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),
					DriverRepo_v8.ANDROID_NEXUS_5_API24_APP.getUiAutomator2Options());
			// Logo.printLogo("android");
		} else if (os.equalsIgnoreCase("ANDROID") && device.equals("PIXEL_4_API27_APP")) {
			driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),
					DriverRepo_v8.ANDROID_PIXEL_4_API27_APP.getUiAutomator2Options());
		} else if (os.equals("android") && device.equals("Nexus_5_API_24_Chrome")) {
			driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),
					DriverRepo.ANDROID_NEXUS_5_API24_CHROME.getDesiredCapabilities());
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			// Logo.printLogo("android");
		} else if (os.equals("ios") && device.equals("iPhone_6_9.2")) {
			System.out.println("Driver: iOS driver not configured");
		} else {
			System.out.println("Driver: no driver selected");
			System.out.println("Running test with driver: " + os + " & device: " + device);
		}

	}

	/**
	 * Based on android and ios, this method will return By locator of any element
	 */
	public static By getByElement(By android_element, By ios_element) {
		if (os.equalsIgnoreCase("ANDROID")) {
			return android_element;
		} else if (os.equalsIgnoreCase("IOS")) {
			return ios_element;
		}
		return null;
	}

	public static MobileBy getMobileByElement(MobileBy android_element, MobileBy ios_element) {
		if (os.equalsIgnoreCase("ANDROID")) {
			return android_element;
		} else if (os.equalsIgnoreCase("IOS")) {
			return ios_element;
		}
		return null;
	}

	public static void quit() {
		driver.quit();
	}

	public static void resetApp() {
		// driver.resetApp();
	}

	/*
	 * This method will take screen shot and place in specified folder
	 */
	public static void getScreenshot(String testclass, String testname) throws IOException {
		String timestamp = new SimpleDateFormat("yyyyMMddhhmmss'.png'").format(new Date());
		String dir;

		// todo: path need to be relative
		if (os.equals("android")) {
			System.out.println("BasePage > getScreenShot");
			dir = "src/test/resources/screenshots/android/";

//			dir = "C:\\Users\\cmash\\Documents\\Papi\\Repo\\AppiumTest\\src\\test\\resources\\screenshots\\android\\";
		} else {
			dir = "/Users/sheetalsingh/Documents/workspace/AppiumApp/src/test/resources/screenshots/ios/";
		}

		String path = dir + testclass + "_" + testname + "_" + timestamp;
		System.out.println("path:" + path);

		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(scrFile, new File(path));
	}

	public static void sendKeys(By locator, String keyword) {
		driver.findElement(locator).clear();
		driver.findElement(locator).sendKeys(keyword);
	}

	public static void navigateBack() {
		driver.navigate().back();
	}

	public static void click(By locator) {
		driver.findElement(locator).click();
	}

	public static boolean isPageLoaded(By locator) {
		return driver.findElement(locator).isDisplayed();
	}

	public static boolean isElementPresent(By locator) {
		return driver.findElement(locator).isDisplayed();
	}

	public static List getElementList(By locator) {
		return driver.findElements(locator);
	}

	public static String getText(By locator) {
		return driver.findElement(locator).getText();
	}

	public static String getAttributeValue(By locator, String attribute) {
		return driver.findElement(locator).getAttribute(attribute);
	}

	/**
	 * Method will swipe from bottom to top direction means page will move towards
	 * downward accept parameter like 0.90, 0.10 and swipe accordingly
	 */

	public static void swipeVerticallyBottomToUp(double bottom, double up) {
		/*
		 * Dimension size; size = driver.manage().window().getSize();
		 * 
		 * int startX = size.width / 2; int startY = (int) (size.height * bottom); int
		 * endY = (int) (size.height * up); System.out.println("starty = " + startY +
		 * " ,endy = " + endY + " , startx = " + startX);
		 * 
		 * 
		 * driver.swipe(startX, startY, startX, endY, 1000);
		 */
	}

	public static void swipeHorizontal(double startPercentage, double finalPercentage, double anchorPercentage,
			int duration) throws Exception {
		/*
		 * TouchAction action = new TouchAction(driver); Dimension size =
		 * driver.manage().window().getSize(); int width=size.width; int
		 * height=size.height;
		 * 
		 * int middleOfY=height/2; int startXCoordinate= (int)(width*.7); int
		 * endXCoordinate= (int)(width*.2);
		 * 
		 * action.press(PointOption.point(middleOfY, startXCoordinate))
		 * .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
		 * .moveTo(PointOption.point(middleOfY, endXCoordinate)).release().perform();
		 */
	}

	public static void swipeVertical(double startPercentage, double finalPercentage, double anchorPercentage,
			int duration) throws Exception {
		/*
		 * TouchAction action =new TouchAction(driver); Dimension size
		 * =driver.manage().window().getSize(); int width=size.width; int
		 * height=size.height; int middleOfX=width/2; int startYCoordinate=
		 * (int)(height*.7); int endYCoordinate= (int)(height*.2);
		 * 
		 * action.press(PointOption.point(middleOfX, startYCoordinate))
		 * .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2)))
		 * .moveTo(PointOption.point(middleOfX, endYCoordinate)).release().perform();
		 */
	}

}
