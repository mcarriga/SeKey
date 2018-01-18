package framework;

import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.BeforeMethod;
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
	public drivers.DriverService driverService;
	
	/**
	 * Initialized the fields in this class
	 * @param keywordProvider KeywordProvider instance to use
	 * @throws MalformedURLException if Grid Hub URL is not valid
	 */
	public void init(KeywordProvider keywordProvider) throws MalformedURLException 
	{
		TestClass.keywordProvider = keywordProvider;
		this.waits = keywordProvider.waits;
		this.gets = keywordProvider.gets;
		this.asserts = keywordProvider.asserts;
		this.actions = keywordProvider.actions;
		this.loggers = KeywordLogger.getInstance();
	}

	/**
	 * Before method to run before all tests
	 * @param context ITestContext passed in by TestNG
	 * @param method Method passed in by TestNG
	 * @throws MalformedURLException if Grid Hub URL is not valid
	 */
	@BeforeMethod
	public void getAnnotation(ITestContext context, Method method) throws MalformedURLException {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.home")+"/Downloads/chromedriver");
		driverService = new drivers.DriverService();
		driver = driverService.createChromeDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
		keywordProvider = new KeywordProvider(driver, KeywordLogger.getInstance());
		
		this.init(keywordProvider);
		runner = new ExcelTestRunner(keywordProvider, PageObject.class, context);
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
