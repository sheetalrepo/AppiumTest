package testcases;

import java.net.MalformedURLException;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import pages.BasePage;

/*
 * Run this test class in every testng.xml files to initialise driver once
 */
public class SetupTest {

	ExtentReports extent;
	ExtentTest test;
	final String filePath = "src/test/resources/extentreporting/report.html";
	final String screenShotPath = "src/test/resources/extentreporting";
	
	
	@BeforeSuite
	public void beforeSuite() throws MalformedURLException {
		System.out.println("---------- Setup Test: Before Suite ----------");
		
		extent = new ExtentReports(filePath, false);  // false will append the reports
		new BasePage();
	}


	@AfterSuite
	public void end() {
		System.out.println("---------- Setup Test: After Suite ----------");
		
		//added here from after method
		extent.flush();
		
		extent.close();
	}
	
}
