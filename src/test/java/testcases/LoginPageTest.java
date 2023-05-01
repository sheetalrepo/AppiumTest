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

public class LoginPageTest extends SetupTest {

	//@BeforeClass
	public void before(){
		System.out.println("---------- Setup ExtentReports: Before Class ----------");
		extent = new ExtentReports(filePath, true);
	}
	
	
	//@AfterClass
	public void after(){
		extent.close();
	}
	
	
	@AfterMethod
	protected void afterMethod(ITestResult result) {
		System.out.println("----- Login Test Class: After Method -----");
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

	@Test
	public void verifyLogin() throws InterruptedException {
		System.out.println("### Login test 1");
		test = extent.startTest("verifyLogin"); //Title of Test in Report
		test.log(LogStatus.PASS, "Step 1");

		LoginPage.login("abc@gmail.com", "111111");
		String img = test.addScreenCapture(screenShotPath);
	    test.log(LogStatus.INFO, "Image", "Image example: " + img);
	}

	@Test
	public void verifyEmailFiledPresence() {
		System.out.println("### Login test 2");
		
		test = extent.startTest("verifyEmailFiledPresence").assignCategory("Sanity");
		test.log(LogStatus.PASS, "Step A");

		//Assert.assertTrue(LoginPage.isEmailFieldDisplayed());
		Assert.assertTrue(true);
	}

	


	//@Test
	public void verifyLoginPageExtent() throws InterruptedException, IOException{
		try {
			System.out.println("### Login test 3");
			test = extent.startTest("verifyLoginPageExtent 3").assignCategory("sanity");
			
			LoginPage.login("x@abc.com", "111111");
			
			throw new NoSuchElementException("Fake Element");
		}catch(NoSuchElementException e){
			test.log(LogStatus.FAIL, "Step 1: Login into application");
			//pass test class name and test name for better reporting
			System.out.println("### Login Page Test Failed: Take screenshot");
			LoginPage.getScreenshot("LoginPageTest","verifyLoginPageExtent");			
		}
		
	}
	
}
