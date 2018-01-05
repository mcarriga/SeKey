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
	public static Framework framework;
	public static WebDriver driver;
	public ITestRunner runner;
	public ITestCase testCase;
	public IWait wait; 
	public IGet get;
	public IAssert asserts;
	public IAction action;
	public ILogging logger;
	public MvnProperties mavenProperties;
	public drivers.DriverService driverService;
	
	/**
	 * Initialized the fields in this class
	 * @param framework Framework instance to use
	 * @throws MalformedURLException if Grid Hub URL is not valid
	 */
	public void init(Framework framework) throws MalformedURLException 
	{
		TestClass.framework = framework;
		this.wait = framework.wait;
		this.get = framework.get;
		this.asserts = framework.asserter;
		this.action = framework.action;
		this.logger = KeywordLogger.getInstance();
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
		framework = new Framework(driver, KeywordLogger.getInstance());
		
		this.init(framework);
		runner = new ExcelTestRunner(framework, PageObject.class);
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
