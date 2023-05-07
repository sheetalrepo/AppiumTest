package demo;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.Collections;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.Rectangle;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.offset.ElementOption;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

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

public class A8_AppiumFeatures {

	//static AppiumDriver<MobileElement> driver;
	//static AppiumDriver driver;
	static AndroidDriver driver;
	
	/*
	 * Tap: Only for Mobile Click: For Mobile and Web
	 */
	public void testTap() {
		WebElement views = driver.findElement(By.xpath("//android.widget.TextView[@content-desc='Views']"));
		
		waitForElementToBeClickable(views);
	    Rectangle rec = views.getRect();
	    int centerX = rec.getX() + (rec.getWidth() / 2);
	    int centerY = rec.getY() + (rec.getHeight() / 2);
	    Point elementLocation = new Point(centerX, centerY);
	    tapPoint(elementLocation);
		
		driver.navigate().back();
	}
	
	
	public void waitForElementToBeClickable(WebElement element){
		 new WebDriverWait(driver, Duration.ofSeconds(20)).until(ExpectedConditions.elementToBeClickable(element));
	}
	
	
	public static void tapPoint(Point point) {
	    PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
	    Sequence tap = new Sequence(finger, 1);
	    tap.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), point.getX(), point.getY()));
	    tap.addAction(finger.createPointerDown(0));
	    tap.addAction(finger.createPointerUp(0));
	    driver.perform(Collections.singletonList(tap));
	}

	// Views > Expandable Lists > Custom Adapter > Dog Names (Long Press)
	public void testLongPress() {
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc='Views']")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc='Expandable Lists']")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc='1. Custom Adapter']")).click();

		WebElement dogNames = driver.findElement(By.xpath("//*[contains(@text,'Dog')]"));
		LongPressOptions longPressOptions = new LongPressOptions();
		longPressOptions.withDuration(Duration.ofSeconds(3)).withElement(ElementOption.element(dogNames));

		//TODO
		//TouchAction action = new TouchAction(driver);
		//action.longPress(longPressOptions).release().perform();
		
		driver.findElement(By.xpath("//android.widget.TextView[@text='Sample action']")).click();
	}

	public static void main(String[] args) throws MalformedURLException {
		
		A0_UIAutomator2 options = new A0_UIAutomator2();
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/"),
				options.getApiDemoApkOptions());
		
		
		A8_AppiumFeatures obj = new A8_AppiumFeatures();
		 obj.testTap();
		//obj.testLongPress();

	}

}
