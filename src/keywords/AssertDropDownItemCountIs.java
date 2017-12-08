package keywords;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import interfaces.ILogging;
import interfaces.IWait;
import junit.framework.Assert;

public class AssertDropDownItemCountIs extends AssertKeyword {

	private final ILogging logger;
	private final long maxTime;
	private final WebElement element;
	private final int count;
	private final IWait wait;
	private By locator = null;
	
	public AssertDropDownItemCountIs(WebElement element, int expectedCount, ILogging logger, IWait wait, long maxWaitSeconds) {
		this.logger = logger;
		this.element = element;
		this.maxTime = maxWaitSeconds;
		this.count = expectedCount;
		this.wait = wait;
	}
	
	public AssertDropDownItemCountIs(WebDriver driver, By locator, int expectedCount, ILogging logger, IWait wait, long maxWaitSeconds) {
		this(driver.findElement(locator), expectedCount, logger, wait, maxWaitSeconds);
	}

	@Override
	public Void perform() {
		wait.untilDropDownItemCountIs(element, count, maxTime).perform();
		Select select = new Select(element);
		Assert.assertEquals(count, select.getAllSelectedOptions().size());
		return null;
	}

	@Override
	public void startLog() {
		logger.beginKeyword(this, locator, ";expectedCount: "+count);
	}

	@Override
	public void endLog() {
		logger.endKeyword(this);
	}
}
