package pages;

import java.net.MalformedURLException;

import org.openqa.selenium.By;
//import io.appium.java_client.AppiumBy;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileBy.ByAccessibilityId;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.bys.builder.AppiumByBuilder;

public class HomePage extends BasePage {

	/**
	 * Page elements
	 */
	
	static By a_app = By.xpath("//android.widget.TextView[@content-desc=\"App\"]");
	static By i_app = By.id("App");
	static By app = getByElement(a_app, i_app);

	public HomePage() throws MalformedURLException  {
		super();
	}

	/**
	 * Actions methods
	 * 
	 * App > Activity > Animation > Zoom In
	 */
	public static void clickApp() {
		System.out.println("----App");
		//click(app);
		driver.findElement(app).click();
	}
	
	public static void clickActivity() {
		System.out.println("---- Activity");
		//driver.findElementByAccessibilityId("Activity");
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"Activity\"]")).click();
	}
	
	public static void clickAnimation() {
		System.out.println("---- Animation");
		//driver.findElementByAccessibilityId("Activity");
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"Animation\"]")).click();
	}
	
	public static void clickPreference() {
		System.out.println("---- Preference");
		//driver.findElement(AppiumBy.accessibilityId("ss"));
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc=\"Activity\"]")).click();
	}
	

	/**
	 * Getters
	 */

	/**
	 * Setters
	 */

	/**
	 * Verification methods
	 */
	public static boolean isAppFieldDisplayed() {
		return isElementPresent(app);
	}

}
