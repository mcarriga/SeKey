package data;

import java.util.List;

import interfaces.ITestStep;

public class ExcelTestStep implements ITestStep
{
	private final String keyword;
	private final List<String> objects;
	private final List<String> params;
	
	public ExcelTestStep(String keyword, List<String> objects, List<String> params) 
	{
		this.keyword = keyword;
		this.objects = objects;
		this.params = params;
	}
	
	@Override
	public String getKeyword() 
	{
		return keyword;
	}
	
	@Override
	public List<String> getObjects()
	{
		return objects;
	}
	
	@Override
	public List<String> getParams()
	{
		return params;
	}
}
