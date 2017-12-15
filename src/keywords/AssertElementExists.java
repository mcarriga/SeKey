package keywords;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import framework.AssertKeyword;
import interfaces.ILogging;
import interfaces.IWait;

public class AssertElementExists extends AssertKeyword {

	private final ILogging logger;
	private final IWait wait;
	private final long timeout;
	private final By locator;
	
	public AssertElementExists(WebDriver driver, ILogging logger, IWait wait, By locator, long timeoutSeconds) {
		this.locator = locator;
		this.logger = logger;
		this.wait = wait;
		this.timeout = timeoutSeconds;
	}

	@Override
	public Void perform() {
		Assert.assertTrue(wait.untilElementExists(locator, timeout).perform().equals(true), "Element with locator "+locator+" was not found on the DOM");
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
