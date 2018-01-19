package framework;

import java.net.MalformedURLException;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.Listeners;

import data.ExcelTestRunner;
import interfaces.IAction;
import interfaces.IAssert;
import interfaces.IGet;
import interfaces.ILogging;
import interfaces.ITestCase;
import interfaces.ITestRunner;
import interfaces.IWait;
import logging.KeywordLogger;

/**
 * Base Class for all TestNG test classes that use the Excel Workbook Runner format
 * Uses Listener: listeners.TestListeners
 * @author Mathew Carrigan
 *
 */
@Listeners(listeners.TestListeners.class)
public class ExcelTestClass implements org.testng.ITest
{
	public static KeywordProvider keywordProvider;
	public static WebDriver driver;
	public ITestRunner runner;
	public ITestCase testCase;
	public IWait waits; 
	public IGet gets;
	public IAssert asserts;
	public IAction actions;
	public ILogging loggers;
	public MvnProperties mavenProperties;
	public webDriverHandler.DriverService driverService;
	
	/**
	 * Initialized the fields in this class
	 * @param keywordProvider KeywordProvider instance to use
	 * @throws MalformedURLException if Grid Hub URL is not valid
	 */
	private void init(KeywordProvider keywordProvider) throws MalformedURLException 
	{
		ExcelTestClass.keywordProvider = keywordProvider;
		this.waits = keywordProvider.waits;
		this.gets = keywordProvider.gets;
		this.asserts = keywordProvider.asserts;
		this.actions = keywordProvider.actions;
		this.loggers = KeywordLogger.getInstance();
	}
	
	/**
	 * 
	 * @param context ITestContext passed in by TestNG
	 * @param driversPackageFolder Name of the package/folder that contains WebDrivers for running local. ChromeDriver, GeckoDriver, IEDriver, etc...
	 * @param pageObjectsPackageFolder Name of the Page objects package/folder that contains all Page Object Classes
	 * @throws Exception If unable to find drivers or page object folders
	 */
	public void Initialize(ITestContext context, String driversPackageFolder, String pageObjectsPackageFolder) throws Exception{
		driverService = new webDriverHandler.DriverService(driversPackageFolder);
		driver = driverService.getBrowser();
		keywordProvider = new KeywordProvider(driver, KeywordLogger.getInstance());
		
		this.init(keywordProvider);
		runner = new ExcelTestRunner(keywordProvider, pageObjectsPackageFolder, context);
		context.getCurrentXmlTest().setName(testCase.getTestName());
		context.getCurrentXmlTest().getSuite().setName(testCase.getSuiteName());
	}

	/**
	 * Sets the test name to the name provided by the Excel Spreadsheet
	 */
	@Override
	public String getTestName()
	{
		return testCase.getTestName();
	}
}
