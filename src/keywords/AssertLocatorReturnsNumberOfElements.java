package keywords;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import interfaces.ILogging;
import interfaces.IWait;

public class AssertLocatorReturnsNumberOfElements extends AssertKeyword {

	private final ILogging logger;
	private final IWait wait;
	private final long timeout;
	private final By locator;
	private final int number;
	private final WebDriver driver;
	
	public AssertLocatorReturnsNumberOfElements(WebDriver driver, By locator, int expectedNumber, ILogging logger, IWait wait, long timeoutSeconds) {
		this.locator = locator;
		this.logger = logger;
		this.wait = wait;
		this.timeout = timeoutSeconds;
		this.number = expectedNumber;
		this.driver = driver;
	}

	@Override
	public Void perform() {
		wait.untilLocatorReturnsNumberOfElements(locator, number, timeout).perform();
		List<WebElement> all = driver.findElements(locator);
		Assert.assertEquals(all.size(), number, "Expected to find "+number +" elements but found "+all.size());
		return null;
	}

	@Override
	public void startLog() {
		logger.beginKeyword(this, locator);
	}

	@Override
	public void endLog() {
		logger.endKeyword(this);
	}

}
