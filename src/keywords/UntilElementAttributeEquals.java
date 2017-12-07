package keywords;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import interfaces.ILogging;

public class UntilElementAttributeEquals extends WaitKeyword {

	private final WebDriver driver;
	private final ILogging logger;
	private final long maxTime;
	private final WebElement element;
	private final String expectedValue;
	private final String attrName;
	private By locator = null;
	
	public UntilElementAttributeEquals(WebDriver driver, WebElement element, String attrName, String expectedValue, ILogging logger, long maxWaitSeconds) {
		this.driver = driver;
		this.logger = logger;
		this.element = element;
		this.maxTime = maxWaitSeconds;
		this.expectedValue = expectedValue;
		this.attrName = attrName;
	}
	
	public UntilElementAttributeEquals(WebDriver driver, By locator, String attrName, String expectedValue, ILogging logger, long maxWaitSeconds) {
		this.driver = driver;
		this.locator = locator;
		this.element = driver.findElement(locator);
		this.logger = logger;
		this.maxTime = maxWaitSeconds;
		this.expectedValue = expectedValue;
		this.attrName = attrName;
	}

	@Override
	public Boolean perform() {
		WebDriverWait wait = new WebDriverWait(driver, maxTime);
		return wait.until(x -> element.getAttribute(attrName).equals(expectedValue));
	}

	@Override
	public void startLog() {
		logger.beginKeyword(this, locator, "; attrName: "+attrName+"; expectedValue: "+expectedValue);
	}

	@Override
	public void endLog() {
		logger.endKeyword(this);
	}

}
