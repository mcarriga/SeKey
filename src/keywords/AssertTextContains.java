package keywords;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import framework.AssertKeyword;
import interfaces.ILogging;
import interfaces.IWait;

public class AssertTextContains extends AssertKeyword {

	private final WebElement element;
	private final ILogging logger;
	private final String ExpectedText;
	private final IWait wait;
	private final long timeout;
	private By locator;
	
	public AssertTextContains(WebDriver driver, ILogging logger, IWait wait, By locator, String expectedText, long timeoutSeconds) {
		this(driver.findElement(locator), logger, wait, expectedText, timeoutSeconds);
	}
	
	public AssertTextContains(WebElement element, ILogging logger, IWait wait, String expectedText, long timeoutSeconds) {
		this.element = element;
		this.logger = logger;
		this.ExpectedText = expectedText;
		this.wait = wait;
		this.timeout = timeoutSeconds;
	}


	@Override
	public Void perform() {
		wait.untilElementTextContains(element, ExpectedText, timeout).perform();
		Assert.assertTrue(element.getText().contains(ExpectedText), "Element did not contain expected text: "+ExpectedText);
		return null;
	}

	@Override
	public void startLog() {
		logger.beginKeyword(this, locator, "; Expected Text: "+ExpectedText);
	}

	@Override
	public void endLog() {
		logger.endKeyword(this);
	}

}
