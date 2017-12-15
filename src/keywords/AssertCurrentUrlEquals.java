package keywords;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import framework.AssertKeyword;
import interfaces.ILogging;
import interfaces.IWait;

public class AssertCurrentUrlEquals extends AssertKeyword {

	private final ILogging logger;
	private final IWait wait;
	private final long timeout;
	private final WebDriver driver;
	private final String expected;
	
	public AssertCurrentUrlEquals(WebDriver driver, String url, ILogging logger, IWait wait, long timeoutSeconds) {
		this.logger = logger;
		this.wait = wait;
		this.timeout = timeoutSeconds;
		this.driver = driver;
		this.expected = url;
	}

	@Override
	public Void perform() {
		wait.untilCurrentUrlEquals(expected, timeout).perform();
		Assert.assertEquals(driver.getCurrentUrl(), expected);
		return null;
	}

	@Override
	public void startLog() {
		logger.beginKeyword(this, "URL: "+expected);
	}

	@Override
	public void endLog() {
		logger.endKeyword(this);
	}
}
