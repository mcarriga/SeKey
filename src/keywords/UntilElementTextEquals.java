package keywords;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import framework.WaitKeyword;
import interfaces.ILogging;

public class UntilElementTextEquals extends WaitKeyword {
	private final WebDriver driver;
	private final ILogging logger;
	private final long maxTime;
	private final WebElement element;
	private final String expectedText;
	private By locator = null;
	
	public UntilElementTextEquals(WebDriver driver, WebElement element, String expectedText, ILogging logger, long maxWaitSeconds) {
		this.driver = driver;
		this.logger = logger;
		this.element = element;
		this.maxTime = maxWaitSeconds;
		this.expectedText = expectedText;
	}
	
	public UntilElementTextEquals(WebDriver driver, By locator, String expectedText, ILogging logger, long maxWaitSeconds) {
		this.driver = driver;
		this.locator = locator;
		this.element = driver.findElement(locator);
		this.logger = logger;
		this.maxTime = maxWaitSeconds;
		this.expectedText = expectedText;
	}

	@Override
	public Boolean perform() {
		WebDriverWait wait = new WebDriverWait(driver, maxTime);
		try {
			if(locator != null) {
				return wait.until(ExpectedConditions.textToBe(locator, expectedText));
			} else {
				return wait.until(x -> element.getText().equals(expectedText));
			}
		}catch(TimeoutException e) {
			return false;
		}
	}

	@Override
	public void startLog() {
		logger.beginKeyword(this, locator, ";expectedText: "+expectedText);
	}

	@Override
	public void endLog() {
		logger.endKeyword(this);
	}

}
