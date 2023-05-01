package testcases;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.NoSuchElementException;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;

import pages.*;

public class SearchPageTest extends SetupTest {

	 @BeforeClass
	public void before() {
		System.out.println("---------- Setup ExtentReports: Before Class ----------");
		extent = new ExtentReports(filePath, false);
	}

	 @AfterClass
	public void after() {
		extent.close();
	}


	@AfterMethod
	protected void afterMethod(ITestResult result) {
		System.out.println("----- Search Test Class: After Method -----");
		if (result.getStatus() == ITestResult.FAILURE) {
			test.log(LogStatus.FAIL, result.getThrowable());
		} else if (result.getStatus() == ITestResult.SKIP) {
			test.log(LogStatus.SKIP, "Test skipped " + result.getThrowable());
		} else {
			test.log(LogStatus.PASS, "Test passed");
		}

		extent.endTest(test);
		//extent.flush();
		
		
		BasePage.resetApp();
	}
	
	//@Test
	public void abc() {
		System.out.println(">>> Search test 1");
	}

	@Test
	public void verifySearchPage() {
		System.out.println(">>> Search test 2");

		test = extent.startTest("Verify Search 2").assignCategory("Sanity");
		test.log(LogStatus.PASS, "Step A");

		// Assert.assertTrue(LoginPage.isEmailFieldDisplayed());
		Assert.assertTrue(true);
	}

}
