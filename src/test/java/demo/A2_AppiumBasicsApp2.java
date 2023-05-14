package demo;

import java.net.MalformedURLException;
import java.net.URL;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;


/*
 * This class will work with SauceLab Apk file
 * App2: https://github.com/saucelabs/my-demo-app-rn/releases
 * 
 * class AndroidDriver extends AppiumDriver
 * 
 */
public class A2_AppiumBasicsApp2 {

	static AppiumDriver driver; 
	//static AndroidDriver driver; 

	//App > Activity > Animation > Back to home page
	public void testSaucelabBasicFlow() throws InterruptedException {
		driver.findElement(AppiumBy.accessibilityId("open menu")).click();
		Thread.sleep(1000L);
		driver.findElement(AppiumBy.accessibilityId("menu item log in")).click();;
		Thread.sleep(1000L);
		driver.findElement(AppiumBy.accessibilityId("Username input field")).sendKeys("bob@example.com");;
		Thread.sleep(1000L);
		driver.findElement(AppiumBy.accessibilityId("Password input field")).sendKeys("10203040");;
		Thread.sleep(1000L);
		driver.findElement(AppiumBy.xpath("//android.view.ViewGroup[@content-desc='Login button']")).click();;
	}
		
	
	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		
		A0_UiAutomator2Options options = new A0_UiAutomator2Options();
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/"),
				options.getSauceLabApkOptions());
		
		A2_AppiumBasicsApp2 obj = new A2_AppiumBasicsApp2();
		obj.testSaucelabBasicFlow();
		
		System.out.println("---------- Run Finished ----------");
	}

}
