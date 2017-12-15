package keywords;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import framework.AssertKeyword;
import interfaces.ILogging;
import interfaces.IWait;
import junit.framework.Assert;

public class AssertDropDownOptionsInOrderOf extends AssertKeyword {

	private final ILogging logger;
	private final long maxTime;
	private final WebElement element;
	private final List<String> expectedTexts;
	private final IWait wait;
	private By locator = null;
	private List<String> allElemStrings = new ArrayList<String>();
	
	public AssertDropDownOptionsInOrderOf(WebElement element, List<String> expectedOptions, ILogging logger, IWait wait, long maxWaitSeconds) {
		this.logger = logger;
		this.element = element;
		this.maxTime = maxWaitSeconds;
		this.expectedTexts = expectedOptions;
		this.wait = wait;
	}
	
	public AssertDropDownOptionsInOrderOf(WebDriver driver, By locator, List<String> expectedOptions, ILogging logger, IWait wait, long maxWaitSeconds) {
		this(driver.findElement(locator), expectedOptions, logger, wait, maxWaitSeconds);
	}

	@Override
	public Void perform() {
		wait.untilDropDownOptionsInOrderOf(element, expectedTexts, maxTime).perform();
		Select select = new Select(element);
		List<WebElement> allElems;
		
		try {
			allElems =select.getAllSelectedOptions();
		}catch(TimeoutException e) {
			allElems = new ArrayList<WebElement>();
		}
		
		for(WebElement we : allElems) {
			try {
				allElemStrings.add(we.getText());
			} catch(StaleElementReferenceException st) {
				allElems =select.getAllSelectedOptions();
				allElemStrings.add(we.getText());
			}
		}
	
		Assert.assertEquals(expectedTexts, allElemStrings);
		return null;
	}

	@Override
	public void startLog() {
		logger.beginKeyword(this, locator, ";Expected Options In order: "+String.join(", ", expectedTexts));
	}

	@Override
	public void endLog() {
		logger.endKeyword(this);
	}

}
