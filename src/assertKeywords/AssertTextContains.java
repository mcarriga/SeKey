package assertKeywords;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import data.ObjectDef;
import framework.AssertKeyword;
import framework.Framework;
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

	public static AssertKeyword instantiateExternal(Framework framework, List<ObjectDef> defs,
			List<String> params) {
		if(isBy(defs.get(0))) {
			if(params.size() > 1) {
				return new AssertTextContains(framework.driver, framework.logger, framework.wait, castToBy(defs.get(0)), params.get(0),  (long)Double.parseDouble(params.get(1)));
			} else {
				return new AssertTextContains(framework.driver, framework.logger, framework.wait, castToBy(defs.get(0)), params.get(0), framework.asserter.getDefaultWait());
			}
		} else {
			if(params.size() > 1) {
				return new AssertTextContains(castToElem(defs.get(0)), framework.logger, framework.wait, params.get(0),  (long)Double.parseDouble(params.get(1)));
			} else {
				return new AssertTextContains(castToElem(defs.get(0)), framework.logger, framework.wait, params.get(0), framework.asserter.getDefaultWait());
			}
		}
	}

}
