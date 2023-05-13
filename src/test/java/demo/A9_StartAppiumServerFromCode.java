package demo;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.GeneralServerFlag;


/*
 * This class is for Appium v1
 * Welcome to Appium v1.22.3
 * 
 * Close Appium Server GUI, Restart Emulator
 * Appium Inspector will not work as we have closed local Appium Server
 */
public class A9_StartAppiumServerFromCode {

	static AndroidDriver driver;
	
	public UiAutomator2Options getUIAutomator2Options() {
		UiAutomator2Options options = new UiAutomator2Options();
		options
			.setDeviceName("emulator-5554")
			.setPlatformVersion("8.1")
			.setAppPackage("io.appium.android.apis")
			.setAppActivity(".ApiDemos");

		return options;
	}
	
	/*
	 * nodeJSMainPath: Path may change as per installation setup
	 * 		C:\Users\<Username>\AppData\Local\Program\resources\app\node_modules\appium\build\lib\main.js
	 * 
	 */
	public void startAppiumServer() {
		String nodeExePath = "C:\\Program Files\\nodejs\\node.exe";
		String nodeJSMainPath = "C:\\Users\\cmash\\Downloads\\Appium-Desktop\\resources\\app\\node_modules\\appium\\build\\lib\\main.js";
		String logFilePath = "C:\\Users\\cmash\\Documents\\Papi\\Repo\\AppiumTest\\src\\test\\resources\\logs\\log.txt";

		AppiumDriverLocalService service = AppiumDriverLocalService
				.buildService(new AppiumServiceBuilder()
						.withAppiumJS(new File(nodeJSMainPath))
						.usingDriverExecutable(new File(nodeExePath))
						.withIPAddress("127.0.0.1")
						.withArgument(GeneralServerFlag.BASEPATH, "/wd/hub")
						.usingPort(4723)
						.withLogFile(new File(logFilePath))
						
				);

		String appiumUrl = service.getUrl().toString();
		service.start();
		System.out.println("Starting Appium Server ....");
		System.out.println(appiumUrl);
	}

	
	public void testBasicFlow() {
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc='App']")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc='Activity']")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc='Animation']")).click();
		driver.navigate().back();
		driver.navigate().back();
		driver.navigate().back();
	}
	
	public static void main(String[] args) throws MalformedURLException {
		A9_StartAppiumServerFromCode obj = new A9_StartAppiumServerFromCode();
		obj.startAppiumServer();
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), obj.getUIAutomator2Options());
		//driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		obj.testBasicFlow();
	}

}
