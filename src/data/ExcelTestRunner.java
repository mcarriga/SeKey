package data;

import java.util.List;

import framework.Framework;
import interfaces.ITestCase;
import interfaces.ITestRunner;
import interfaces.ITestStep;

public class ExcelTestRunner implements ITestRunner
{
	private final Framework framework;
	private final Class<?> pageObjectPackage;
	private final KeywordRunner keywordRunner;
	
	public ExcelTestRunner(Framework framework, Class<?> pageObjectPackage) 
	{
		this.framework = framework;
		this.pageObjectPackage = pageObjectPackage;
		this.keywordRunner= new KeywordRunner(framework);
	}
	
	@Override
	public void runTest(ITestCase testCase) throws Exception 
	{
		List<ITestStep> steps = testCase.getTestSteps();
		for(ITestStep step : steps) {
			
			if(step.getKeyword().contains(".")) {
				runCustomKeyword(step.getKeyword(), getObjectDefs(step), step.getParams());
			}else if(!step.getKeyword().equalsIgnoreCase("PageObject")) {
				runKeyword(step.getKeyword(), getObjectDefs(step), step.getParams());
			} else {
				runCustomMethod(step.getObjects().get(0), step.getParams());
			}
		}
	}

	@Override
	public Class<?> getPageObjectPackage()
	{
		return this.pageObjectPackage;
	}

	@Override
	public Framework getFramework()
	{
		return this.framework;
	}

	@Override
	public KeywordRunner getKeywordRunner()
	{
		return this.keywordRunner;
	}
	
	
}
