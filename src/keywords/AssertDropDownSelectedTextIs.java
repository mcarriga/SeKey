package keywords;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import interfaces.ILogging;
import interfaces.IWait;
import junit.framework.Assert;

public class AssertDropDownSelectedTextIs extends AssertKeyword {

	private final ILogging logger;
	private final long maxTime;
	private final WebElement element;
	private final String expectedText;
	private final IWait wait;
	private By locator = null;
	
	public AssertDropDownSelectedTextIs(WebElement element, String expectedText, ILogging logger, IWait wait, long maxWaitSeconds) {
		this.logger = logger;
		this.element = element;
		this.maxTime = maxWaitSeconds;
		this.expectedText = expectedText;
		this.wait = wait;
	}
	
	public AssertDropDownSelectedTextIs(WebDriver driver, By locator, String expectedText, ILogging logger, IWait wait, long maxWaitSeconds) {
		this(driver.findElement(locator), expectedText, logger, wait, maxWaitSeconds);
	}

	@Override
	public Void perform() {
		wait.untilDropDownSelectedTextIs(element, expectedText, maxTime).perform();
		Select select = new Select(element);
		if(select.getFirstSelectedOption().isSelected() == false && expectedText != "") {
			throw new AssertionError("Nothing currently selected in DropDown");
		}
		Assert.assertEquals(expectedText, select.getFirstSelectedOption().getText());
		return null;
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
