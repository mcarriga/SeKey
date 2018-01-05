package framework;

import org.openqa.selenium.WebDriver;

/**
 * Framework class for defining Types of supported WebDrivers
 * @author Mathew Carrigan
 *
 */
public class DriverService {
	private final Type type;
	private WebDriver driver;
	
	/**
	 * Supported Browsers
	 * @author Mathew Carrigan
	 *
	 */
	public static enum Type{
		Chrome,
		Firefox,
		IE,
		MobileChrome,
		MobileFirefox,
		AndroidNative,
		AppleNative
	}
	
	/**
	 * Constructor
	 * @param type Supported Browser to use
	 */
	public DriverService(Type type) {
		this.type = type;
	}
	
	/**
	 * Returns the
	 * @return Current Browser type
	 */
	public Type getType() {
		return type;
	}
	
	/**
	 * Gets the active WebDriver
	 * @return Current active WebDriver
	 */
	public WebDriver getDriver() {
		return driver;
	}
	
	/**
	 * Sets the current driver
	 * @param driver WebDriver to set
	 */
	public void overrideDriver(WebDriver driver) {
		this.driver = driver;
	}
}
