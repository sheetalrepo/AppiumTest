package demo;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.MobileBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;

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


public class A1_AppiumBasics_v8 {

	static AndroidDriver driver; // Working in 8.3.3
	
	public UiAutomator2Options getUIAutomator2Options() {
		UiAutomator2Options options = new UiAutomator2Options();
		options
			.setDeviceName("emulator-5554")
			.setPlatformVersion("8.1")
			.setAppPackage("io.appium.android.apis")
			.setAppActivity(".ApiDemos");

		return options;
	}
	
	//App > Activity > Animation > Back to home page
	public void testBasicFlow() {
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc='App']")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc='Activity']")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc='Animation']")).click();
		driver.navigate().back();
		driver.navigate().back();
		driver.navigate().back();
	}
	
	//android.widget.TextView[@content-desc="App"]
	//android.widget.TextView[@resource-id="android:id/text1"]
	//android.widget.TextView[@index=3]
	//*[contains(@text,'Read')]
	//android.widget.TextView[@text="Assets"]

	//*[@resource-id='android:id/text1' or @text='Media']
	//*[@resource-id='android:id/text1' and @text='Media']
	
	//Content > Assets > Read Asset > Copy given text > Back to home page
	public void testXpaths() {
		driver.findElement(By.xpath("//android.widget.TextView[@index=3]")).click();
		
		int list1 = driver.findElements(By.xpath("//android.widget.TextView[@resource-id='android:id/text1']")).size();
		System.out.println("List of Element 1: " + list1); //6
		
		
		driver.findElement(By.xpath("//android.widget.TextView[@text='Assets']")).click();
		driver.findElement(By.xpath("//*[contains(@text,'Read')]")).click();
		String text = driver.findElement(By.id("io.appium.android.apis:id/text")).getText();
		System.out.println(text);
		
		driver.navigate().back();
		driver.navigate().back();
		driver.navigate().back();
		
		
		int list2 = driver.findElements(By.xpath("//*[@resource-id='android:id/text1' or @text='Media']")).size();
		System.out.println("List of Element 2: " + list2); //11
		driver.findElement(By.xpath("//*[@resource-id='android:id/text1' and @text='Media']")).click();
		driver.navigate().back();
	}
	
	//Locator = className
	public void testClassNameLocator() {
		System.out.println("---- Element Name----");
		List<WebElement> list = driver.findElements(By.className("android.widget.TextView"));
		for(WebElement ele: list){
			System.out.println(ele.getText());
		}
	}
	
	//resource-id = Use driver.findElement(By.id(""))
	//accessibility id or content-desc= Use driver.findElementByAccessibilityId(""))
	public void testIdAndAccessibilityId() {
		driver.findElement(By.id("android:id/text1")).click();
		driver.navigate().back();
		//driver.findElementByAccessibilityId("Accessibility").click(); //Removed from java-client v8
		
		driver.findElement(MobileBy.AccessibilityId("Animation")).click();
		driver.navigate().back();
		
		driver.findElement(AppiumBy.accessibilityId("App")).click();
		driver.navigate().back();
	}
	

	/*
	 * When you call the getAttribute("name") method on an element in Appium for Android,
	 * it will return the text value of the element if it is a TextView, 
	 * or the content-desc value if it is not TextView
	 * 
	 */
	//Accessibility
	public void testGetAttribute() {
		String name = driver.findElement(By.xpath("//android.widget.TextView[@content-desc='Accessibility']"))
				.getAttribute("name");
		System.out.println(name);
		
		String getText = driver.findElement(By.xpath("//android.widget.TextView[@content-desc='Accessibility']"))
				.getText();
		System.out.println(getText);
		
		String contentDesc = driver.findElement(By.xpath("//android.widget.TextView[@content-desc='Accessibility']"))
				.getAttribute("content-desc");
		System.out.println(contentDesc);

		String bounds = driver.findElement(By.xpath("//android.widget.TextView[@content-desc='Accessibility']"))
				.getAttribute("bounds");
		System.out.println(bounds);
	}
	
	
	public static void main(String[] args) throws MalformedURLException {
		A1_AppiumBasics_v8 obj = new A1_AppiumBasics_v8();
		
		
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),
				obj.getUIAutomator2Options());
		
		obj.testBasicFlow();
		//obj.testXpaths();	
		//obj.testClassNameLocator();
		//obj.testIdAndAccessibilityId();
		//obj.testGetAttribute();
		
		System.out.println("-------- Run Finished ----------");
	}

}
