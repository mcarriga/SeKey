package webDriverHandler;

import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.apache.tools.ant.DirectoryScanner;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import framework.MvnProperties;
import logging.KeywordLogger;

/**
 * KeywordProvider helper for creating and managing WebDrivers
 * @author Mathew Carrigan
 *
 */
public class DriverService
{
	private String driversLocation;
	public DriverService(String driversFolder) 
	{
		Path path = Paths.get(System.getProperty("user.dir"));
		DirectoryScanner scanner = new DirectoryScanner();
		scanner.setBasedir(path.toFile());
		scanner.setIncludes(new String[] {"*/"+driversFolder});
		scanner.setCaseSensitive(false);
		scanner.scan();
		String[] results = scanner.getIncludedDirectories();
		boolean found = false;
		for(String result : results) {
			Path foundPath = Paths.get(result);
			if(foundPath.toFile().isDirectory()) {
				found = true;
				driversLocation = foundPath.toString();
				break;
			}
		}
		if(found == false) {
			KeywordLogger.getInstance().warn("Unable to find the provided folder name: "+driversFolder+"; attempting to set location to: "+path.toString()+"/src/"+driversFolder);
			driversLocation = path.toString()+"/src/"+driversFolder;
		}
		System.setProperty("webdriver.chrome.driver", driversLocation+"/chromedriver");
		System.setProperty("webdriver.gecko.driver", driversLocation+"/geckodriver");
		
	}
	
	private boolean isBrowserArgsNull() {
		if(MvnProperties.browserArgs == null || MvnProperties.browserArgs.trim().isEmpty() || MvnProperties.browserArgs.trim().equals("")) {
			return true;
		} else {
			return false;
		}
	}
	
	/**
	 * Reads the Maven SureFire SystemProperties to get which WebDriver to create and creates it
	 * @return WebDriver of type specified in Maven SureFire SystemProperties
	 * @throws MalformedURLException if Grid Hub Url is not valid
	 */
	public WebDriver getBrowser() throws MalformedURLException {
		String name = MvnProperties.browser.trim().toLowerCase();
		switch (name)
		{
		case "chrome":
			return createChromeDriver();
		case "firefox":
			return createFirefoxDriver();
		default:
			return createChromeDriver();
		}
	}
	
	/**
	 * Creates a new ChromeDriver with default ChromeOptions
	 * Looks at the Maven SureFire plugin System Properties to determine whether to run local or not and whether to add any custom DriverOptions Arguments
	 * @return ChromeDriver WebDriver
	 * @throws MalformedURLException if Grid Hub URL is not valid
	 */
	public WebDriver createChromeDriver() throws MalformedURLException{
		ChromeOptions options = new ChromeOptions();
		if(isBrowserArgsNull()) {
			options.addArguments("--disable-infobars", "--start-maximized", "--ignore-certificate-errors");
		} else {
			String[] args = MvnProperties.browserArgs.split(";");
			options.addArguments(args);
		}
		options.setCapability("credentials_enable_service", false);
		options.setCapability("profile.password_manager_enabled", false);
		
		return createChromeDriver(options);
	}
	
	/**
	 * Creates a new ChromeDriver with provided ChromeOptions
	 * Looks at the Maven SureFire plugin System Properties to determine whether to run local or not and whether to add any custom DriverOptions Arguments
	 * @param options ChromeOptions to include with the ChromeDriver
	 * @return ChromeDriver WebDriver
	 * @throws MalformedURLException if Grid Hub URL is not valid 
	 */
	public WebDriver createChromeDriver(ChromeOptions options) throws MalformedURLException {
		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		capabilities.setCapability(ChromeOptions.CAPABILITY, options);
		
		if(MvnProperties.runLocal) {
			return new ChromeDriver(options);
		} else {
			return new RemoteWebDriver(new URL(MvnProperties.gridUrl), capabilities);
		}
	}
	
	/**
	 * Creates a new FirefoxDriver with default FirefoxOptions
	 * Looks at the Maven SureFire plugin System Properties to determine whether to run local or not and whether to add any custom DriverOptions Arguments
	 * @return FirefoxDriver WebDriver
	 * @throws MalformedURLException if Grid Hub URL is not valid
	 */
	public WebDriver createFirefoxDriver() throws MalformedURLException {
		FirefoxProfile profile = new FirefoxProfile();
		profile.setAcceptUntrustedCertificates(true);
		profile.setPreference("security.insecure_password.ui.enabled", false);
		profile.setPreference("security.insecure_field_warning.contextual.enabled",false);
		
		FirefoxOptions options = new FirefoxOptions();
		if(isBrowserArgsNull()) {
			// for now do nothing
		} else {
			String[] args = MvnProperties.browserArgs.split(";");
			options.addArguments(args);
		}
		options.setCapability("acceptInsecureCerts", true);
		options.setCapability("pageLoadStrategy", "normal");
		options.setProfile(profile);
		
		DesiredCapabilities capabilities = DesiredCapabilities.firefox();
		capabilities.setCapability(FirefoxDriver.PROFILE, profile);
		capabilities.setCapability(FirefoxOptions.FIREFOX_OPTIONS, options);
		
		if(MvnProperties.runLocal) {
			return new FirefoxDriver(options);
		} else {
			return new RemoteWebDriver(new URL(MvnProperties.gridUrl), capabilities);
		}
	}
	
	/**
	 * Creates a new FirefoxDriver with provided FirefoxProfile
	 * Looks at the Maven SureFire plugin System Properties to determine whether to run local or not and whether to add any custom DriverOptions Arguments
	 * @param profile FirefoxProfile to create FirefoxDriver with
	 * @return FirefoxDriver WebDriver
	 * @throws MalformedURLException if Grid Hub URL is not valid
	 */
	public WebDriver createFirefoxDriver(FirefoxProfile profile) throws MalformedURLException {
		FirefoxOptions options = new FirefoxOptions();
		options.setCapability("acceptInsecureCerts", true);
		options.setCapability("pageLoadStrategy", "normal");
		options.setProfile(profile);
		
		DesiredCapabilities capabilities = DesiredCapabilities.firefox();
		capabilities.setCapability(FirefoxDriver.PROFILE, profile);
		capabilities.setCapability(FirefoxOptions.FIREFOX_OPTIONS, options);
		
		if(MvnProperties.runLocal) {
			return new FirefoxDriver(options);
		} else {
			return new RemoteWebDriver(new URL(MvnProperties.gridUrl), capabilities);
		}
	}
	
	/**
	 * Creates a new FirefoxDriver with provided FirefoxOptions
	 * Looks at the Maven SureFire plugin System Properties to determine whether to run local or not and whether to add any custom DriverOptions Arguments
	 * @param options FirefoxOptions to create FirefoxDriver with
	 * @return FirefoxDriver WebDriver
	 * @throws MalformedURLException if Grid Hub URL is not valid
	 */
	public WebDriver createFirefoxDriver(FirefoxOptions options) throws MalformedURLException {
		DesiredCapabilities capabilities = DesiredCapabilities.firefox();
		capabilities.setCapability(FirefoxOptions.FIREFOX_OPTIONS, options);
		
		if(MvnProperties.runLocal) {
			return new FirefoxDriver(options);
		} else {
			return new RemoteWebDriver(new URL(MvnProperties.gridUrl), capabilities);
		}
	}

}
