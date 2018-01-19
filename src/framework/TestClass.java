package framework;


import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;

import interfaces.IAction;
import interfaces.IAssert;
import interfaces.IGet;
import interfaces.ILogging;
import interfaces.IWait;
import logging.KeywordLogger;

/**
 * Base Test Class for all KeywordProvider tests in the Coded(non-Excel) format
 * Uses Listener: listeners.TestListeners
 * @author Mathew Carrigan
 *
 */
@Listeners(listeners.TestListeners.class)
public abstract class TestClass {
	public WebDriver driver;
	public static KeywordProvider keywordProvider;
	public IWait waits; 
	public IGet gets;
	public IAssert asserts;
	public IAction actions;
	public ILogging loggers;
	public webDriverHandler.DriverService driverService;
	
	/**
	 * Initialized fields for this class
	 * @param keywordProvider KeywordProvider implementation to use
	 */
	private void init(KeywordProvider keywordProvider) {
		TestClass.keywordProvider = keywordProvider;
		this.waits = keywordProvider.waits;
		this.gets = keywordProvider.gets;
		this.asserts = keywordProvider.asserts;
		this.actions = keywordProvider.actions;
		this.loggers = KeywordLogger.getInstance();
	}
	
	/**
	 * 
	 * @param driversPackageFolder Name of the package/folder that contains WebDrivers for running local. ChromeDriver, GeckoDriver, IEDriver, etc...
	 * @param implicitWaitSeconds Implicit Wait Timeout in Seconds
	 * @param pageLoadTimeoutSeconds Page Load Timeout in Seconds
	 * @throws Exception
	 */
	public void initialize(String driversPackageFolder, long implicitWaitSeconds, long pageLoadTimeoutSeconds) throws Exception {
		driverService = new webDriverHandler.DriverService(driversPackageFolder);
		driver = driverService.getBrowser();
		driver.manage().timeouts().implicitlyWait(implicitWaitSeconds, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(pageLoadTimeoutSeconds, TimeUnit.SECONDS);
		keywordProvider = new KeywordProvider(driver, KeywordLogger.getInstance());
		
		this.init(keywordProvider);
	}
	
	/**
	 * 
	 * @param driversPackageFolder Name of the package/folder that contains WebDrivers for running local. ChromeDriver, GeckoDriver, IEDriver, etc...
	 */
	public void initialize(String driversPackageFolder) throws Exception{
		initialize(driversPackageFolder, 20, 30);
	}
	
	@BeforeTest
	public void testClassBeforeTest() {
		
	}
	
}
