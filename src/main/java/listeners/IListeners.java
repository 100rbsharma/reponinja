package listeners;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

import resources.Base;
import utilities.ExtentReporter;

public class IListeners extends Base implements ITestListener {

	WebDriver driver = null;
	
	ExtentReports extentReport = ExtentReporter.extentReport();
	ExtentTest extentTest;
	
	ThreadLocal<ExtentTest> extentTestThread = new ThreadLocal <ExtentTest>();  // to safe thread whil parallel testing
	

	public void onTestStart(ITestResult result) {
		String testName = result.getTestName();
		
		extentTest = extentReport.createTest(testName + "execution start--------");
		extentTestThread.set(extentTest);									// to safe thread whle parallel testing
	}
	
	

	public void onTestSuccess(ITestResult result) {

		String testName = result.getName();
		
		
		//extentTest.log(Status.PASS, testName + " got passed");
		
		extentTestThread.get().log(Status.PASS, testName + " got passed");	// to safe thread while parallel testing
		
		
	}

	public void onTestFailure(ITestResult result) {
		
		String testName = result.getName();
		
		
		//extentTest.fail(result.getThrowable());
		
		extentTestThread.get().fail(result.getThrowable());	// to safe thread while parallel testing
		
			
		try {
			driver = (WebDriver)result.getTestClass().getRealClass().getDeclaredField("driver")
					.get(result.getInstance());
		} catch (Exception e) {
			e.printStackTrace();
		}

		
		try {
			String screenshotFilePath = takeScreenshot(testName, driver);
			extentTestThread.get().addScreenCaptureFromPath(screenshotFilePath, testName);
		} catch (IOException e) {

			e.printStackTrace();
		}

	}

	public void onTestSkipped(ITestResult result) {

	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	public void onTestFailedWithTimeout(ITestResult result) {

	}

	public void onStart(ITestContext context) {

	}

	public void onFinish(ITestContext context) {
		
		extentReport.flush(); 

	}

}
