package helper;

import java.io.IOException;
import java.util.Set;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestNGMethod;
import org.testng.ITestResult;

import pages.BasePage;

public class TestListener implements ITestListener {

	/**
	 * method set the test counter, if failed test rerun 10 times then this will
	 * count only 1 case not 11 case 
	 * Refer:https://www.seleniumeasy.com/testng-tutorials/retry-listener-failed-tests-count-update 
	 * Note: I have modified this method a bit as my test cases are getting skipped and result count is not proper
	 */
	public void onFinish(ITestContext context) {
		//Set<ITestResult> failedTests = context.getFailedTests().getAllResults();
		Set<ITestResult> failedTests = context.getSkippedTests().getAllResults();

		for (ITestResult temp : failedTests) {
			ITestNGMethod method = temp.getMethod();
			// if (context.getFailedTests().getResults(method).size() > 1) {
			if (context.getSkippedTests().getResults(method).size() > 0) {
				failedTests.remove(temp);
			} else {
				if (context.getPassedTests().getResults(method).size() > 0) {
					failedTests.remove(temp);
				}
			}
		}
	}

	public void onTestStart(ITestResult result) {
	}

	public void onTestSuccess(ITestResult result) {
	}

	/**
	 * In case any test failed then screenshot of application will be taken
	 */
	public void onTestFailure(ITestResult result) {
		String testclassRaw = result.getTestClass().toString().trim();
		String testclass = testclassRaw.substring(32, testclassRaw.length() - 1);
		String testname = result.getName().toString().trim();
		System.out.println("*************** Capture Screenshot for :  " + testname);
		try {
			BasePage.getScreenshot(testclass, testname);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void onTestSkipped(ITestResult result) {
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
	}

	public void onStart(ITestContext context) {
	}

}
