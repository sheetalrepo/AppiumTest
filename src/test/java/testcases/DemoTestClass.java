package testcases;

import java.net.MalformedURLException;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import pages.BasePage;
import pages.HomePage;

/*
 * Demo class for TCs
 * 
 */
public class DemoTestClass {
	ExtentReports extent;
	ExtentTest test;
	final String filePath = "src/test/resources/extentreporting/demo_test_report_v8.html";
	final String screenShotPath = "src/test/resources/extentreporting";
	
	@BeforeSuite
	public void beforeSuite() throws MalformedURLException {
		extent = new ExtentReports(filePath, true);
		System.out.println("###------ Test Class: Before Suite -----###");
		new BasePage();
	}

	@AfterSuite
	protected void afterSuite() {
		extent.close();
	}
	
	@AfterMethod
	protected void afterMethod(ITestResult result) {
		System.out.println("TestClass: After Method");
		if (result.getStatus() == ITestResult.FAILURE) {
			test.log(LogStatus.FAIL, result.getThrowable());
		} else if (result.getStatus() == ITestResult.SKIP) {
			test.log(LogStatus.SKIP, "Test skipped " + result.getThrowable());
		} else {
			test.log(LogStatus.PASS, "Test passed");
		}

		extent.endTest(test);
		extent.flush();
		
		
		//BasePage.resetApp();
	}

	
	
	@Test
	public void verifyBasicNavigationSanity() throws InterruptedException {
		System.out.println("### Demo Test 1");
		test = extent.startTest("Demo Test 1"); //Title of Test in Report
	    HomePage.clickApp();
	    HomePage.clickActivity();
	    HomePage.clickAnimation();
	    HomePage.navigateBack();
	    HomePage.navigateBack();
	    HomePage.navigateBack();
		test.log(LogStatus.PASS, "App > Activity > Animation > Zoom In");
	    
	}

	
	
	@Test
	public void verifyBasicNavigationSanity2() throws InterruptedException {
		System.out.println("### Demo Test 2");
		test = extent.startTest("Demo Test 2");
	    HomePage.clickApp();
	    HomePage.clickActivity();
	    HomePage.clickAnimation();
	    HomePage.navigateBack();
	    HomePage.navigateBack();
	    HomePage.navigateBack();
		test.log(LogStatus.PASS, "App > Activity > Animation > Zoom In");
	    
	}
	
	
	
	
}
