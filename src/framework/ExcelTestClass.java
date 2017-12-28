package framework;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Listeners;

import data.ExcelTestCase;
import data.ExcelTestRunner;
import interfaces.IAction;
import interfaces.IAssert;
import interfaces.IGet;
import interfaces.ILogging;
import interfaces.IWait;
import logging.KeywordLogger;

@Listeners(listeners.TestListeners.class)
public class ExcelTestClass 
{
	public static Framework framework;
	public static WebDriver driver;
	public ExcelTestRunner runner;
	public ExcelTestCase testCase;
	public IWait wait; 
	public IGet get;
	public IAssert asserts;
	public IAction action;
	public ILogging logger;
	//public MvnProperties mavenProperties;
	
	public void init(Framework framework) 
	{
		TestClass.framework = framework;
		this.wait = framework.wait;
		this.get = framework.get;
		this.asserts = framework.asserter;
		this.action = framework.action;
		this.logger = KeywordLogger.getInstance();
		//mavenProperties = new MvnProperties();
	}

}
