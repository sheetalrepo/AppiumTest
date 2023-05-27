package demo.cicd;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
/*
 * Selenium Manager
 * https://www.selenium.dev/blog/2022/introducing-selenium-manager/
 * 
 * No need to set chrome driver path
 * Introduced since 4.6.0
 * 
 * mvn clean test -DsuiteXmlFile=seleniumTestNG.xml
 * Report : target/surefire-reports/index.html
 * 
 * 
 * Jenkin:
 * Chrome will not open from Jenkin
 * Test will pass
 */
public class SeleniumTestNG {
	
	WebDriver driver;
	
	@BeforeClass
	public void init() {
		driver = new ChromeDriver(); 
	}
	
	@Test
	public void simpleTest1() {
		System.out.println("Starting Test1...");
		driver.get("https://www.amazon.com/");
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Prod bug");
		driver.findElement(By.id("nav-search-submit-button")).click();
		String title = driver.getTitle();
		System.out.println("### Title: "+ driver.getTitle());
		System.out.println("### Url: "+ driver.getCurrentUrl());
		Assert.assertTrue(title.contains("Prod bug"));
		System.out.println("Test Complete 1 !!!");
	}
	
	@Test
	public void simpleTest2() throws InterruptedException {
		System.out.println("Starting Test1...");
		driver.get("https://www.amazon.com/");
		String title = driver.getTitle();
		Thread.sleep(3000);
		System.out.println("### Title: "+ title);
		Assert.assertTrue(title.contains("Spend less. Smile more."));
		System.out.println("Test Complete 2 !!!");
	}
	

	@AfterClass
	public void closeAll() {
		driver.close();
	}
	

	
}
