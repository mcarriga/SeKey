package keywords;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import framework.WaitKeyword;
import interfaces.ILogging;

public class UntilDropDownItemCountIs extends WaitKeyword {

	private final WebDriver driver;
	private final ILogging logger;
	private final long maxTime;
	private final WebElement element;
	private final int expectedCount;
	private By locator = null;
	
	public UntilDropDownItemCountIs(WebDriver driver, WebElement element, int expectedCount, ILogging logger, long maxWaitSeconds) {
		this.driver = driver;
		this.logger = logger;
		this.element = element;
		this.maxTime = maxWaitSeconds;
		this.expectedCount = expectedCount;
	}
	
	public UntilDropDownItemCountIs(WebDriver driver, By locator, int expectedCount, ILogging logger, long maxWaitSeconds) {
		this.driver = driver;
		this.locator = locator;
		this.element = driver.findElement(locator);
		this.logger = logger;
		this.maxTime = maxWaitSeconds;
		this.expectedCount = expectedCount;
	}

	@Override
	public Boolean perform() {
		WebDriverWait wait = new WebDriverWait(driver, maxTime);
		Select select = new Select(element);
		try {
			return wait.until(x -> select.getAllSelectedOptions().size() == (expectedCount));
		}catch(TimeoutException e) {
			return false;
		}
	}

	@Override
	public void startLog() {
		logger.beginKeyword(this, locator, ";expectedCount: "+expectedCount);
	}

	@Override
	public void endLog() {
		logger.endKeyword(this);
	}
}
