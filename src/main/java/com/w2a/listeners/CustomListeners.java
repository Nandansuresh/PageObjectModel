package com.w2a.listeners;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.SkipException;

import com.relevantcodes.extentreports.LogStatus;
import com.w2a.base.Page;
import com.w2a.utilities.TestUtils;

public class CustomListeners extends Page implements ITestListener {

	public void onTestStart(ITestResult result) {
		test = rep.startTest(result.getName().toUpperCase());
        
		//run mode
		
//		if(!TestUtils.isTestRunnable(result.getName(), excel))
//		{
//			throw new SkipException("Skipping the test"+ result.getName().toUpperCase()+ " as the run mode is NO");
//		}
		
	}

	public void onTestSuccess(ITestResult result) {
//		System.setProperty("org.uncommons.reportng.escape-output", "false");
//		Reporter.log("Capturing the screenshot");
//		try {
//			Reporter.log("Entering in to the try block");
//			TestUtils.CaptureScreenshot();
//		} catch (IOException e) {
//            Reporter.log("Entering in to the catch block");
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	    Reporter.log("<a target=\"_blank\"href="+TestUtils.ScreenshotName+">Screenshot</a>");
//	    Reporter.log("<br>");
//		Reporter.log("<a target=\"_blank\"href=\"+TestUtils.ScreenshotName+\"><img src="+TestUtils.ScreenshotName+"  height=200 width=200></img></a>");
      
		test.log(LogStatus.PASS, result.getName().toUpperCase()+"Pass");
	//	test.log(LogStatus.PASS, test.addScreenCapture(TestUtils.ScreenshotName));
		rep.endTest(test);
		rep.flush();
		
		
		
	}

	public void onTestFailure(ITestResult result) {
		System.setProperty("org.uncommons.reportng.escape-output", "false");
		Reporter.log("Capturing the screenshot");
		try {
			TestUtils.CaptureScreenshot();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    Reporter.log("<a target=\"_blank\"href="+TestUtils.ScreenshotName+">Screenshot</a>");
	    Reporter.log("<br>");
		Reporter.log("<a target=\"_blank\"href="+TestUtils.ScreenshotName+"><img src=\"+TestUtils.ScreenshotName+\" height=200 width=200></img></a>");
		
		test.log(LogStatus.FAIL, result.getName().toUpperCase()+"Failed with exception: "+result.getThrowable()+ "Failed");
		test.log(LogStatus.FAIL, test.addScreenCapture(TestUtils.ScreenshotName));
        rep.endTest(test);
        rep.flush();
        
	}

	public void onTestSkipped(ITestResult result) {
		test.log(LogStatus.SKIP, result.getName().toUpperCase() + "Skipped the test as run mode is NO");
		 rep.endTest(test);
	     rep.flush();
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub

	}

	public void onStart(ITestContext context) {
		// TODO Auto-generated method stub

	}

	public void onFinish(ITestContext context) {
		// TODO Auto-generated method stub

	}

}
