package demo;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;

import com.google.common.collect.ImmutableList;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import demo.helper.AppDriver;
import demo.helper.AppFactory;
import demo.helper.AppOptions;
import demo.helper.Utils;

/*
 * Using Framework related classes
 * 
 * functionally same as previous class
 */
public class A4_AppiumLongPress1 {

	static AppiumDriver driver;


	/*
	 * finger : unique id, can be any name
	 * 
	 * 
	 */
	public static void longPress(WebElement ele) {
        Point location = ele.getLocation();
        PointerInput input = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence sequence = new Sequence(input, 0);
        sequence.addAction(input.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), location.x, location.y));
        sequence.addAction(input.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        sequence.addAction(input.createPointerMove(Duration.ofSeconds(1), PointerInput.Origin.viewport(), location.x, location.y));
        sequence.addAction(input.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        driver.perform(ImmutableList.of(sequence));
    }
    
	
	// Views > Expandable Lists > Custom Adapter > Dog Names (Long Press)
	public static void testLongPress() throws InterruptedException {
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc='Views']")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc='Expandable Lists']")).click();
		driver.findElement(By.xpath("//android.widget.TextView[@content-desc='1. Custom Adapter']")).click();

		WebElement dogNames = driver.findElement(By.xpath("//*[contains(@text,'Dog')]"));
		longPress(dogNames);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//android.widget.TextView[@text='Sample action']")).click();
		driver.navigate().back();
		driver.navigate().back();
		driver.navigate().back();
	}

	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		System.out.println("---------- Run Started ----------");

		A0_UiAutomator2Options options = new A0_UiAutomator2Options();
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/"),
				options.getApiDemoApkOptions());
		
		// method
		testLongPress();
		
		System.out.println("---------- Run Finished ----------");
	}

}
