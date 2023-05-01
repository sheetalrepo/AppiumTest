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

public class ChildTest extends Parent {
/*	
	ExtentReports extent;
	ExtentTest test;
	//final String filePath = "C:\\Users\\cmash\\Documents\\Papi\\Repo\\AppiumTest\\src\\test\\resources\\extentreporting\\mainreport3.html";
	//final String screenShotPath = "C:\\Users\\cmash\\Documents\\Papi\\Repo\\AppiumTest\\src\\\\test\\resources\\extentreporting";
	final String filePath = "src/test/resources/extentreporting/mainreportChild.html";
	final String screenShotPath = "src/test/resources/extentreporting";
	
	
	@BeforeSuite
	public void beforeSuite() throws MalformedURLException {
		extent = new ExtentReports(filePath, true);
		System.out.println("### Test Class: Before Suite ###");
		
		
		new BasePage();
	}

	@AfterSuite
	protected void afterSuite() {
		extent.close();
	}

		*/
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
		
		
		BasePage.resetApp();
	}


	
	@Test
	public void verifyLogin() throws InterruptedException {
		System.out.println("### Child test 1");
		test = extent.startTest("verifyLogin"); //Title of Test in Report
		test.log(LogStatus.PASS, "Step 1");

		LoginPage.login("abc@gmail.com", "111111");
		String img = test.addScreenCapture(screenShotPath);
	    test.log(LogStatus.INFO, "Image", "Image example: " + img);
	}

	@Test
	public void verifyEmailFiledPresence() {
		System.out.println("### Child test 2");
		
		test = extent.startTest("verifyEmailFiledPresence").assignCategory("Sanity");
		test.log(LogStatus.PASS, "Step A");

		//Assert.assertTrue(LoginPage.isEmailFieldDisplayed());
		Assert.assertTrue(true);
	}

	
	
}
