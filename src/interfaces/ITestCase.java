package interfaces;

import java.util.List;

public interface ITestCase
{
	String getTestName();
	String getTestId();
	String getSuiteName();
	List<ITestStep> getTestSteps();
	
}
