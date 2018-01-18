package listeners;

import java.lang.reflect.Method;
import java.util.HashMap;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentTest;

import annotations.AlmProperties;
import annotations.TestCaseId;
import interfaces.ILogging;
import logging.AlmAdapter;
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
		extentTests.get(result.getName()).pass(result.getName()+" passed");
		logger.info("Ending Test: "+ result.getName());
		printTestResults(result);
		//updateALM(result);
	}

	@Override
	public void onTestFailure(ITestResult result) {
		//Reporter.log("Ending Test: "+ result.getName(), true);
		extentTests.get(result.getName()).fail(result.getThrowable());
		logger.info("Ending Test: "+ result.getName());
		printTestResults(result);
		//updateALM(result);
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		extentTests.get(result.getName()).skip(result.getName()+" skipped");
		printTestResults(result);
		//updateALM(result);
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

	private void updateALM(ITestResult result) {
		Method method = result.getMethod().getConstructorOrMethod().getMethod();
		Class<?> clazz = result.getTestClass().getRealClass();
		
		boolean hasAlmProps = false;
		boolean hasAlmTestId = false;
		
		String domain = null;
		String project = null;
		String url = null;
		int port = 0;
		String userName = null;
		String userPass = null;
		String testId = null;
		
		if(clazz.isAnnotationPresent(AlmProperties.class)) {
			AlmProperties almProperties = clazz.getAnnotation(AlmProperties.class);
			domain = almProperties.Domain();
			project = almProperties.Project();
			url = almProperties.Url();
			port = almProperties.Port();
			userName = almProperties.userName();
			userPass = almProperties.userPass();
			hasAlmProps = true;
		}
		
		if(method.isAnnotationPresent(TestCaseId.class)) {
			TestCaseId id = method.getAnnotation(TestCaseId.class);
			testId = id.value();
			hasAlmTestId = true;
		}
		
		if(hasAlmProps && hasAlmTestId) {
			try
			{
				AlmAdapter adapter = new AlmAdapter(url, port, userName, userPass, domain, project);
				adapter.updateTestInALM(testId, result);
			} catch (Exception e)
			{
				logger.warn("Unable to create instance of AlmAdapter");
				e.printStackTrace();
			}
		} else {
			logger.warn("Please make sure Test Class has AlmProperties annotation and Test method has TestCaseId annotation or ExcelTest case has TestCaseId column filled out");
		}
	}
}
