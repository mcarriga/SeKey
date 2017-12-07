package keywords;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import interfaces.ILogging;
import interfaces.IWait;
import junit.framework.Assert;

public class AssertDropDownSelectedValueIs extends AssertKeyword {

	private final ILogging logger;
	private final long maxTime;
	private final WebElement element;
	private final String expectedText;
	private final IWait wait;
	private By locator = null;
	
	public AssertDropDownSelectedValueIs(WebElement element, String expectedValueText, ILogging logger, IWait wait, long maxWaitSeconds) {
		this.logger = logger;
		this.element = element;
		this.maxTime = maxWaitSeconds;
		this.expectedText = expectedValueText;
		this.wait = wait;
	}
	
	public AssertDropDownSelectedValueIs(WebDriver driver, By locator, String expectedValueText, ILogging logger, IWait wait, long maxWaitSeconds) {
		this(driver.findElement(locator), expectedValueText, logger, wait, maxWaitSeconds);
	}

	@Override
	public Void perform() {
		wait.untilDropDownSelectedValueIs(element, expectedText, maxTime).perform();
		Select select = new Select(element);
		if(select.getFirstSelectedOption().isSelected() == false && expectedText != "") {
			throw new AssertionError("Nothing currently selected in DropDown");
		}
		Assert.assertEquals(expectedText, select.getFirstSelectedOption().getAttribute("value"));
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
