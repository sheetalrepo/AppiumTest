package demo;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

/*
 * Appium 2.0
 * Java-client 8
 * 
 * This class will work with ApiDemos-debug.apk
 * App1: https://github.com/appium-boneyard/sample-code/blob/master/sample-code/apps/ApiDemos/bin/ApiDemos-debug.apk
 * 
 */
public class A1_AppiumBasicsApp1 {

	static AndroidDriver driver; // Working in 8.3.3

	//App > Activity > Animation > Back to home page
	public void testBasicFlow() {
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc='App']")).click();
		driver.findElement(AppiumBy.xpath("//android.widget.TextView[@content-desc='Activity']")).click();
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
		System.out.println("List of Element 1: " + list1); 
		
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
	//accessibility id or content-desc= Use driver.findElement(AppiumBy.accessibilityId("Animation"))
	public void testIdAndAccessibilityId() {
		driver.findElement(AppiumBy.id("android:id/text1")).click();
		driver.navigate().back();
		//driver.findElementByAccessibilityId("Accessibility").click(); //Removed from java-client v8
		//driver.findElement(MobileBy.accessibilityId("Animation")).click(); // Deprecated in v8
		
		driver.findElement(AppiumBy.accessibilityId("Animation")).click();
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
		A0_UiAutomator2Options options = new A0_UiAutomator2Options();
		
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/"),
				options.getApiDemoApkOptions());

		A1_AppiumBasicsApp1 obj = new A1_AppiumBasicsApp1();
		//obj.testBasicFlow();
		//obj.testXpaths();	
		//obj.testClassNameLocator();
		//obj.testIdAndAccessibilityId();
		obj.testGetAttribute();
		
		System.out.println("---------- Run Finished ----------");
	}

}
