package data;

import java.util.List;

import org.testng.ITestContext;

import framework.KeywordProvider;
import interfaces.ITestCase;
import interfaces.ITestRunner;
import interfaces.ITestStep;

public class ExcelTestRunner implements ITestRunner
{
	private final ITestContext context;
	private final KeywordProvider keywordProvider;
	private final String pageObjectPackage;
	private final KeywordRunner keywordRunner;
	
	public ExcelTestRunner(KeywordProvider keywordProvider, String pageObjectPackage, ITestContext context) 
	{
		this.keywordProvider = keywordProvider;
		this.pageObjectPackage = pageObjectPackage;
		this.keywordRunner= new KeywordRunner(keywordProvider);
		this.context = context;
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
	public String getPageObjectPackage()
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

	
	@Override
	public ITestContext getTestContext()
	{
		return context;
	}
	
	
}
