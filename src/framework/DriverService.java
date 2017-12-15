package framework;

import org.openqa.selenium.WebDriver;

public class DriverService {
	private final Type type;
	private WebDriver driver;
	
	public static enum Type{
		Chrome,
		Firefox,
		IE,
		MobileChrome,
		MobileFirefox,
		AndroidNative,
		AppleNative
	}
	
	public DriverService(Type type) {
		this.type = type;
	}
	
	public Type getType() {
		return type;
	}
	
	public WebDriver getDriver() {
		return driver;
	}
	
	public void overrideDriver(WebDriver driver) {
		this.driver = driver;
	}
}
