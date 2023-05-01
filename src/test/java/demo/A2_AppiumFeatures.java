package demo;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.TouchAction;
import org.openqa.selenium.WebElement;

/*
 * platformName : Android
 * platformVersion : 8.1, Emulator settings will show platform version (Edit Emulator Device)
 * 
 * appPackage: adb shell dumpsys window windows | grep mFocusedApp
 * appActivity: same as above
 * 
 * deviceName: emulator-5554, adb devices
 * appium-version : 1.22.3, Start Appium server and it will display
 * app: Can be download directly in emulators or better pass from project
 */


/*
 * Tap
 * 
 * 
 */

public class A2_AppiumFeatures {

	static AppiumDriver<MobileElement> driver;
	
	public void testTap() {
		WebElement views = driver.findElement(By.xpath("//android.widget.TextView[@content-desc='Views']"));
		TouchAction touch =new TouchAction(driver);
		touch.tap(TapOptions.tapOptions().withElement(ElementOption.element(views))).perform();
	
		driver.navigate().back();

	}
	
	public static void main(String[] args) throws MalformedURLException {
		A1_AppiumBasics basicObj = new A1_AppiumBasics();
		driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"),
				basicObj.getDesiredCapabilities());
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		
		A2_AppiumFeatures obj = new A2_AppiumFeatures();
		obj.testTap();
		
	
	}

}
