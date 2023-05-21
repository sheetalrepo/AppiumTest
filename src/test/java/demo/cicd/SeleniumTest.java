package demo.cicd;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/*
 * Selenium Manager
 * https://www.selenium.dev/blog/2022/introducing-selenium-manager/
 * 
 * 
 */
public class SeleniumTest {

	public static void main(String[] args) {
		System.out.println("Hello World");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.amazon.com/");
		driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Prod bug");
		driver.findElement(By.id("nav-search-submit-button")).click();
		System.out.println("Title: "+ driver.getTitle());
		System.out.println("Url: "+ driver.getCurrentUrl());
		driver.quit();
		System.out.println("End");

	}

}
