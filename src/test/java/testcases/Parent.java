package testcases;

import java.net.MalformedURLException;

import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import pages.BasePage;
import pages.LoginPage;

public class Parent {
	ExtentReports extent;
	ExtentTest test;
	final String filePath = "src/test/resources/extentreporting/mainreportChild.html";
	final String screenShotPath = "src/test/resources/extentreporting";
	
	/*
	@BeforeSuite
	public void beforeSuite() throws MalformedURLException {
		extent = new ExtentReports(filePath, true);
		System.out.println("### Test Class: Before Suite ###");
		
		
		new BasePage();
	}

	@AfterSuite
	protected void afterSuite() throws InterruptedException {
		Thread.sleep(5000);
		extent.close();
	}

	*/
	@BeforeSuite
	public void beforeSuite() throws MalformedURLException {
		System.out.println("---------- Setup Test: Before Suite ----------");
		
		extent = new ExtentReports(filePath, true);
		new BasePage();
	}


	@AfterSuite
	public void end() {
		System.out.println("---------- Setup Test: After Suite ----------");
		extent.close();
	}
	
	
}
