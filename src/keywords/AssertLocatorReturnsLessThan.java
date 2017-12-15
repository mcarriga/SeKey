package keywords;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import framework.AssertKeyword;
import interfaces.ILogging;
import interfaces.IWait;

public class AssertLocatorReturnsLessThan extends AssertKeyword {

	private final ILogging logger;
	private final IWait wait;
	private final long timeout;
	private final By locator;
	private final int number;
	private final WebDriver driver;
	
	public AssertLocatorReturnsLessThan(WebDriver driver, By locator, int lessNumber, ILogging logger, IWait wait, long timeoutSeconds) {
		this.locator = locator;
		this.logger = logger;
		this.wait = wait;
		this.timeout = timeoutSeconds;
		this.number = lessNumber;
		this.driver = driver;
	}

	@Override
	public Void perform() {
		wait.untilLocatorReturnsLessThan(locator, number, timeout).perform();
		List<WebElement> all = driver.findElements(locator);
		Assert.assertTrue(all.size() < number, "Expected to find less than "+number +" elements but found "+all.size());
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
