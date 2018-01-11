package data;

import java.util.List;

import framework.KeywordProvider;
import interfaces.ITestCase;
import interfaces.ITestRunner;
import interfaces.ITestStep;

public class ExcelTestRunner implements ITestRunner
{
	private final KeywordProvider keywordProvider;
	private final Class<?> pageObjectPackage;
	private final KeywordRunner keywordRunner;
	
	public ExcelTestRunner(KeywordProvider keywordProvider, Class<?> pageObjectPackage) 
	{
		this.keywordProvider = keywordProvider;
		this.pageObjectPackage = pageObjectPackage;
		this.keywordRunner= new KeywordRunner(keywordProvider);
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
	public KeywordProvider getFramework()
	{
		return this.keywordProvider;
	}

	@Override
	public KeywordRunner getKeywordRunner()
	{
		return this.keywordRunner;
	}
	
	
}
