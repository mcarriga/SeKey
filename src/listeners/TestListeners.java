package listeners;

import java.util.HashMap;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentTest;

import interfaces.ILogging;
import logging.KeywordLogger;

public class TestListeners implements ITestListener {
	private ILogging logger = KeywordLogger.getInstance();
	private HashMap<String, ExtentTest> extentTests = new HashMap<String, ExtentTest>();

	@Override
	public void onStart(ITestContext context) {
		//Reporter.log("Starting Test: "+ context.getName(), true);

	}

	@Override
	public void onFinish(ITestContext context) {
		//Reporter.log("Ending Test: "+ context.getName(), true);
		logger.getExtent().flush();
	}
	
	@Override
	public void onTestStart(ITestResult result) {
		//Reporter.log("Starting Test: "+ result.getName(), true);
		extentTests.put(result.getName(), logger.getExtent().createTest(result.getName()));
		logger.info("Starting Test: "+ result.getName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		//Reporter.log("Ending Test: "+ result.getName(), true);
		extentTests.get(result.getName()).pass(result.getName()+" passed");
		logger.info("Ending Test: "+ result.getName());
		printTestResults(result);
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		//Reporter.log("Ending Test: "+ result.getName(), true);
		extentTests.get(result.getName()).fail(result.getThrowable());
		logger.info("Ending Test: "+ result.getName());
		printTestResults(result);
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		extentTests.get(result.getName()).skip(result.getName()+" skipped");
		printTestResults(result);
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		// TODO Auto-generated method stub
		
	}
	
	// This is the method which will be executed in case of test pass or fail
	 
		// This will provide the information on the test
	 
		private void printTestResults(ITestResult result) {
	 
			//Reporter.log("Test Method resides in " + result.getTestClass().getName(), true);
	 
			if (result.getParameters().length != 0) {
	 
				String params = null;
	 
				for (Object parameter : result.getParameters()) {
	 
					params += parameter.toString() + ",";
	 
				}
	 
				logger.info("Test Method had the following parameters : " + params);
	 
			}
	 
			String status = null;
	 
			switch (result.getStatus()) {
	 
			case ITestResult.SUCCESS:
	 
				status = "Pass";
	 
				break;
	 
			case ITestResult.FAILURE:
	 
				status = "Failed";
	 
				break;
	 
			case ITestResult.SKIP:
	 
				status = "Skipped";
	 
			}
	 
			logger.info("Test Status: " + status);
	 
		}
}
