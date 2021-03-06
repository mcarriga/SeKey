package assertKeywords;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import data.ObjectDef;
import framework.AssertKeyword;
import framework.KeywordProvider;
import interfaces.ILogging;
import interfaces.IWait;

public class AssertValue extends AssertKeyword {

	private final WebElement element;
	private final ILogging logger;
	private final String ExpectedText;
	private final IWait wait;
	private final long timeout;
	private By locator;
	
	public AssertValue(WebDriver driver, ILogging logger, IWait wait, By locator, String expectedText, long timeoutSeconds) {
		this(driver.findElement(locator), logger, wait, expectedText, timeoutSeconds);
	}
	
	public AssertValue(WebElement element, ILogging logger, IWait wait, String expectedText, long timeoutSeconds) {
		this.element = element;
		this.logger = logger;
		this.ExpectedText = expectedText;
		this.wait = wait;
		this.timeout = timeoutSeconds;
	}

	@Override
	public Void perform() {
		wait.untilElementValueEquals(element, ExpectedText, timeout).perform();
		Assert.assertEquals(element.getAttribute("value"), ExpectedText);
		return null;
	}

	@Override
	public void startLog() {
		logger.beginKeyword(this, locator, "; Expected Value: "+ExpectedText);
	}

	@Override
	public void endLog() {
		logger.endKeyword(this);
	}

	public static AssertKeyword instantiateExternal(KeywordProvider keywordProvider, List<ObjectDef> defs,
			List<String> params) {
		if(isBy(defs.get(0))) {
			if(params.size() > 1) {
				return new AssertValue(keywordProvider.driver, keywordProvider.loggers, keywordProvider.waits, castToBy(defs.get(0)), params.get(0),  (long)Double.parseDouble(params.get(1)));
			} else {
				return new AssertValue(keywordProvider.driver, keywordProvider.loggers, keywordProvider.waits, castToBy(defs.get(0)), params.get(0), keywordProvider.asserts.getDefaultWait());
			}
		} else {
			if(params.size() > 1) {
				return new AssertValue(castToElem(defs.get(0)), keywordProvider.loggers, keywordProvider.waits, params.get(0),  (long)Double.parseDouble(params.get(1)));
			} else {
				return new AssertValue(castToElem(defs.get(0)), keywordProvider.loggers, keywordProvider.waits, params.get(0), keywordProvider.asserts.getDefaultWait());
			}
		}
	}

}
