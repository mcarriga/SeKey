package keywords;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import interfaces.ILogging;

public class UntilDropDownSelectedValueIs extends WaitKeyword {

	private final WebDriver driver;
	private final ILogging logger;
	private final long maxTime;
	private final WebElement element;
	private final String expectedText;
	private By locator = null;
	
	public UntilDropDownSelectedValueIs(WebDriver driver, WebElement element, String expectedValue, ILogging logger, long maxWaitSeconds) {
		this.driver = driver;
		this.logger = logger;
		this.element = element;
		this.maxTime = maxWaitSeconds;
		this.expectedText = expectedValue;
	}
	
	public UntilDropDownSelectedValueIs(WebDriver driver, By locator, String expectedValue, ILogging logger, long maxWaitSeconds) {
		this.driver = driver;
		this.locator = locator;
		this.element = driver.findElement(locator);
		this.logger = logger;
		this.maxTime = maxWaitSeconds;
		this.expectedText = expectedValue;
	}

	@Override
	public Boolean perform() {
		WebDriverWait wait = new WebDriverWait(driver, maxTime);
		Select select = new Select(element);
		try {
			return wait.until(x -> select.getFirstSelectedOption().getAttribute("value").equals(expectedText));
		}catch(TimeoutException e) {
			return false;
		}
	}

	@Override
	public void startLog() {
		logger.beginKeyword(this, locator, ";expectedValue: "+expectedText);
	}

	@Override
	public void endLog() {
		logger.endKeyword(this);
	}
}
