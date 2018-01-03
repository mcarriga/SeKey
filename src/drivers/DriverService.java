package drivers;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import framework.MvnProperties;

public class DriverService
{
	
	public DriverService() {
	}
	
	private boolean isBrowserArgsNull() {
		if(MvnProperties.browserArgs == null || MvnProperties.browserArgs.trim().isEmpty() || MvnProperties.browserArgs.trim().equals("")) {
			return true;
		} else {
			return false;
		}
	}
	
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
	
	public WebDriver createChromeDriver(ChromeOptions options) throws MalformedURLException {
		DesiredCapabilities capabilities = DesiredCapabilities.chrome();
		capabilities.setCapability(ChromeOptions.CAPABILITY, options);
		
		if(MvnProperties.runLocal) {
			return new ChromeDriver(options);
		} else {
			return new RemoteWebDriver(new URL(MvnProperties.gridUrl), capabilities);
		}
	}
	
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
