package logging;

import java.util.Properties;

import org.alm.Config;
import org.alm.model.Field;
import org.alm.model.Run;
import org.alm.model.Test;
import org.alm.model.TestInstance;
import org.testng.ITestResult;

public class AlmAdapter
{
	private final String url;
	private final int port;
	private final String user;
	private final String pass;
	private final String domain;
	private final String project;
	
	public AlmAdapter(String url, int port, String user, String pass, String domain, String project) throws Exception {
		this.url = url;
		this.port = port;
		this.user = user;
		this.pass = pass;
		this.domain = domain;
		this.project = project;
	}
	
	private org.alm.Client getClient() throws Exception {
		
		Properties properties = new Properties();
		properties.setProperty("host", url);
		properties.setProperty("port", String.valueOf(port));
		properties.setProperty("domain", domain);
		properties.setProperty("project", project);
		properties.setProperty("username", user);
		properties.setProperty("password", pass);
		
		Config config = new Config(properties);
		org.alm.Client client = new org.alm.Client(config);
		return client;
	}
	
	public void updateTestInALM(String testId, ITestResult result) throws Exception {
		org.alm.Client client = getClient();
		client.login();
		
		try {
		TestInstance testInstance = new TestInstance();
		testInstance.testSetId(testId);
		org.alm.model.Test test = client.loadTest(testInstance);
		updateAutomationStatusIfNeeded(test);
		
		Run run = client.createRun(testInstance, test);
		run.status(parseTestResult(result));
		run.comments(createRunComments(result));
		run.duration(String.valueOf((result.getEndMillis() - result.getStartMillis()))+ "ms");
		} finally {
			client.logout();
		}
	}
	
	private String createRunComments(ITestResult result) {
		String className = result.getTestClass().getName();
		String testName = result.getName();

		StringBuilder builder = new StringBuilder();
		builder.append("This test execution was run by the SE Testing Automation KeywordProvider");
		builder.append("\nTotal Duration in milliseconds: "+ (result.getEndMillis() - result.getStartMillis())+"ms");
		builder.append("\nTest executed in class: "+className + " with test name of: "+testName);
		
		if(result.getStatus() == ITestResult.FAILURE) {
			Throwable throwable = result.getThrowable();
			builder.append("\nError Message from KeywordProvider is: \n");
			builder.append(throwable.getMessage());
		}
		
		
		return builder.toString();
	}
	
	private void updateAutomationStatusIfNeeded(Test test) {
		Field autoField = test.field("Automation Status");
		String autoStatus = autoField.value();
		if(!autoStatus.equalsIgnoreCase("Automated")) {
			autoField.value("Automated");
		}
	}
	
	private String parseTestResult(ITestResult result) {
		switch (result.getStatus())
		{
		case ITestResult.SUCCESS:
			return Run.STATUS_PASSED;
			
		case ITestResult.FAILURE:
			return Run.STATUS_FAILED;
			
		case ITestResult.SKIP:
			return Run.STATUS_NO_RUN;
		default:
			return Run.STATUS_NO_RUN;
		}
	}
}
