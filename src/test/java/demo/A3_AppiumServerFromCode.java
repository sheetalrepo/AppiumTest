package demo;

import java.net.MalformedURLException;
import java.net.URL;
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
 */
public class A3_AppiumServerFromCode {

	static AppiumDriverLocalService server;
	static AndroidDriver driver;

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

	static AppiumDriverLocalService getInstance() {
		if (server == null) {
			setInstance();
		}
		return server;
	}

	public static void startAppiumServer() {
		getInstance().start();
		System.out.println("---------- Starting Appium Server ----------");
		System.out.println("URL: " + server.getUrl());
		System.out.println("is Server Running: " + server.isRunning());
	}

	public static void stopAppiumServer() {
		if (server != null) {
			getInstance().stop();
		}
		System.out.println("---- Stopped Appium Server----");
	}

	
	public void testSaucelabBasicFlow() throws InterruptedException {
		driver.findElement(AppiumBy.accessibilityId("open menu")).click();
		Thread.sleep(1000L);
		driver.findElement(AppiumBy.accessibilityId("menu item log in")).click();
		
		Thread.sleep(1000L);
		driver.findElement(AppiumBy.accessibilityId("Username input field")).sendKeys("bob@example.com");
		
		Thread.sleep(1000L);
		driver.findElement(AppiumBy.accessibilityId("Password input field")).sendKeys("10203040");
		
		Thread.sleep(1000L);
		driver.findElement(AppiumBy.xpath("//android.view.ViewGroup[@content-desc='Login button']")).click();
	}

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		A3_AppiumServerFromCode.startAppiumServer();

		A0_UiAutomator2Options options = new A0_UiAutomator2Options();
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/"), options.getSauceLabApkOptions());

		A3_AppiumServerFromCode obj = new A3_AppiumServerFromCode();
		obj.testSaucelabBasicFlow();

		A3_AppiumServerFromCode.stopAppiumServer();

		System.out.println("---------- Run Finished ----------");
	}

}
