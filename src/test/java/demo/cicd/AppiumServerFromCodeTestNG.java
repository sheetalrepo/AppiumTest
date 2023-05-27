package demo.cicd;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import demo.A0_UiAutomator2Options;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import java.io.File;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;

/*
 * netstat -ano | findStr "4723"
 * nodeJSMainPath : path need to be added very carefully
 * 
 * This class is for Appium v1
 * [Appium] Welcome to Appium v2.0.0-beta.66
 * 
 * 
 * 
 * mvn clean test -DsuiteXmlFile=appiumTestNG.xml
 * Report : target/surefire-reports/index.html
 * 
 */
public class AppiumServerFromCodeTestNG {

	static AppiumDriverLocalService server;
	static AndroidDriver driver;
	
	@BeforeClass
	public void init() throws MalformedURLException {
		//Start Appium Server
		AppiumServerFromCodeTestNG.startAppiumServer();
		
		//Initialise Driver
		A0_UiAutomator2Options options = new A0_UiAutomator2Options();
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/"), options.getSauceLabApkOptions());
	}
	
	@AfterClass
	public void closeAll() {
		AppiumServerFromCodeTestNG.stopAppiumServer();
		System.out.println("---------- Appium Run Finished ----------");
	}
	
	
	public static void startAppiumServer() {
		getInstance().start();
		System.out.println("---------- Starting Appium Server ----------");
		System.out.println("URL: " + server.getUrl());
		System.out.println("is Server Running: " + server.isRunning());
	}
	

	static AppiumDriverLocalService getInstance() {
		if (server == null) {
			setInstance();
		}
		return server;
	}

	static void setInstance() {
		String nodeJSMainPath = "C:\\Users\\cmash\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js";
		String nodeExePath = "C:\\Program Files\\nodejs\\node.exe";
		String logFilePath = "C:\\Users\\cmash\\Documents\\Papi\\Repo\\AppiumTest\\src\\test\\resources\\logs\\log2.txt";

		AppiumServiceBuilder builder = new AppiumServiceBuilder();
		builder
			.withAppiumJS(new File(nodeJSMainPath))
			.usingDriverExecutable(new File(nodeExePath))
			.usingPort(4723)
			.withArgument(GeneralServerFlag.LOCAL_TIMEZONE)
			.withLogFile(new File(logFilePath))
			.withIPAddress("127.0.0.1"); // wd/hub will not come in Appium 2

		server = AppiumDriverLocalService.buildService(builder);
	}

	public static void stopAppiumServer() {
		if (server != null) {
			getInstance().stop();
		}
		System.out.println("---- Stopped Appium Server----");
	}


	// App > Activity > Animation > Back to home page
	@Test
	public void testSaucelabBasicFlow() throws InterruptedException {
		System.out.println("Starting Appium Test on CICD...");
		
		driver.findElement(AppiumBy.accessibilityId("open menu")).click();
		Thread.sleep(1000L);
		driver.findElement(AppiumBy.accessibilityId("menu item log in")).click();
		
		Thread.sleep(1000L);
		driver.findElement(AppiumBy.accessibilityId("Username input field")).sendKeys("bob@example.com");
		
		Thread.sleep(1000L);
		driver.findElement(AppiumBy.accessibilityId("Password input field")).sendKeys("10203040");
		
		Thread.sleep(1000L);
		driver.findElement(AppiumBy.xpath("//android.view.ViewGroup[@content-desc='Login button']")).click();
		
		System.out.println("Test Complete : Appium Test CICD !!!");
	}

}
