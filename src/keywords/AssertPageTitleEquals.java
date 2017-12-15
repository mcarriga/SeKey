package keywords;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import framework.AssertKeyword;
import interfaces.ILogging;
import interfaces.IWait;

public class AssertPageTitleEquals extends AssertKeyword {

	private final ILogging logger;
	private final IWait wait;
	private final long timeout;
	private final WebDriver driver;
	private final String expected;
	
	public AssertPageTitleEquals(WebDriver driver, String title, ILogging logger, IWait wait, long timeoutSeconds) {
		this.logger = logger;
		this.wait = wait;
		this.timeout = timeoutSeconds;
		this.driver = driver;
		this.expected = title;
	}

	@Override
	public Void perform() {
		wait.untilPageTitleEquals(expected, timeout).perform();
		Assert.assertEquals(driver.getTitle(), expected);
		return null;
	}

	@Override
	public void startLog() {
		logger.beginKeyword(this, "Title: "+expected);
	}

	@Override
	public void endLog() {
		logger.endKeyword(this);
	}

}
