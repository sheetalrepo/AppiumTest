package demo;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import com.google.common.collect.ImmutableList;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;


/*
 * This class will work with WebDriverIO Apk file
 * App3: https://github.com/webdriverio/native-demo-app/releases
 * 
 * class AndroidDriver extends AppiumDriver
 * 
 * 
 */
public class A4_AppiumScrollA {

	static AppiumDriver driver; 
	
	protected static void swipe(Point start, Point end, Duration duration) {
        PointerInput input = new PointerInput(PointerInput.Kind.TOUCH, "finger1");
        Sequence swipe = new Sequence(input, 0);
        swipe.addAction(input.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), start.x, start.y));
        swipe.addAction(input.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        swipe.addAction(input.createPointerMove(duration, PointerInput.Origin.viewport(), end.x, end.y));
        swipe.addAction(input.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        driver.perform(ImmutableList.of(swipe));
    }
	
	
	/*
	 * 
	 * If scrollRatio = 0.8 then page will scroll more
	 * If scrollRatio = 0.2 then page will scroll very less
	 * 
	 * If user want to scroll page in DOWN direction
	 * Then scroll mobile screen starting from Bottom to Top
	 * 
	 * If user want to scroll page in RIGHT direction
	 * Then scroll mobile screen starting from Right to Left
	 * 
	 * Assume Screen size = 50(x value) by 100(y value) 
	 * midpoint of screen will be 50*0.5 & 100*0.5 i.e. (25,50)
	 * 
	 */
	public static void scroll(String pageDirection, double scrollRatio){
        Duration SCROLL_DUR = Duration.ofMillis(300);
        if (scrollRatio < 0 || scrollRatio > 1) {
            throw new Error("Scroll distance must be between 0 and 1");
        }
        Dimension size = driver.manage().window().getSize();
        System.out.println("Screen Size = "+size);
        Point midPoint = new Point((int)(size.width * 0.5),(int)(size.height * 0.5));
        int bottom = midPoint.y + (int)(midPoint.y * scrollRatio); // 50 + 25 
        int top = midPoint.y - (int)(midPoint.y * scrollRatio); // 50 - 25
        int left = midPoint.x - (int)(midPoint.x * scrollRatio); // 25 - 12.5
        int right = midPoint.x + (int)(midPoint.x * scrollRatio); // 25 + 12.5

        if (pageDirection == "UP") {
        	//Swipe Top to bottom, Page will go UP
            swipe(new Point(midPoint.x, top), new Point(midPoint.x, bottom), SCROLL_DUR);
        } else if (pageDirection == "DOWN") {
            swipe(new Point(midPoint.x, bottom), new Point(midPoint.x, top), SCROLL_DUR);
        } else if (pageDirection == "LEFT") {
            swipe(new Point(left, midPoint.y), new Point(right, midPoint.y), SCROLL_DUR);
        } else {
        	//RIGHT
            swipe(new Point(right, midPoint.y), new Point(left, midPoint.y), SCROLL_DUR);
        }
    }
	
	public void swipeMe() throws InterruptedException {
		driver.findElement(AppiumBy.accessibilityId("Swipe")).click();	
		Thread.sleep(4000);
		//Move page towards Right
		scroll("RIGHT", 0.5);
		Thread.sleep(2000);
		scroll("RIGHT", 0.5);
		Thread.sleep(2000);
		scroll("LEFT", 0.5);
		Thread.sleep(2000);
		scroll("DOWN", 0.8);
	}
	
	public static void main(String[] args) throws MalformedURLException, InterruptedException {
		System.out.println("---------- Run Started ----------");
		A0_UiAutomator2Options options = new A0_UiAutomator2Options();
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/"),
				options.getWebdriverIOApkOptions());
		
		A4_AppiumScrollA obj = new A4_AppiumScrollA();
		obj.swipeMe();
		System.out.println("---------- Run Finished ----------");
	}

}
