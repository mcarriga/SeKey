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

public class AssertElementAttributeValue extends AssertKeyword {

	private final WebElement element;
	private final ILogging logger;
	private final String ExpectedText;
	private final String AttrName;
	private final IWait wait;
	private final long timeout;
	private By locator;
	
	public AssertElementAttributeValue(WebDriver driver, ILogging logger, IWait wait, String attrName, By locator, String expectedText, long timeoutSeconds) {
		this(driver.findElement(locator), logger, wait, attrName, expectedText, timeoutSeconds);
	}
	
	public AssertElementAttributeValue(WebElement element, ILogging logger, IWait wait, String attrName, String expectedText, long timeoutSeconds) {
		this.element = element;
		this.logger = logger;
		this.AttrName = attrName;
		this.ExpectedText = expectedText;
		this.wait = wait;
		this.timeout = timeoutSeconds;
	}

	@Override
	public Void perform() {
		wait.untilElementAttributeEquals(element, AttrName,ExpectedText, timeout).perform();
		Assert.assertEquals(element.getAttribute(AttrName), ExpectedText);
		return null;
	}

	@Override
	public void startLog() {
		logger.beginKeyword(this, locator, "; Attribute: "+AttrName+" ;Expected Attribute Text: "+ExpectedText);
	}

	@Override
	public void endLog() {
		logger.endKeyword(this);
	}

	public static AssertKeyword instantiateExternal(KeywordProvider keywordProvider, List<ObjectDef> defs,
			List<String> params) {
		if(isBy(defs.get(0))) {
			if(params.size() > 2) {
				return new AssertElementAttributeValue(keywordProvider.driver, keywordProvider.loggers, keywordProvider.waits, params.get(0), castToBy(defs.get(0)), params.get(1),  (long)Double.parseDouble(params.get(2)));
			} else {
				return new AssertElementAttributeValue(keywordProvider.driver, keywordProvider.loggers, keywordProvider.waits, params.get(0), castToBy(defs.get(0)), params.get(1), keywordProvider.asserts.getDefaultWait());
			}
		} else {
			if(params.size() > 2) {
				return new AssertElementAttributeValue(castToElem(defs.get(0)), keywordProvider.loggers, keywordProvider.waits, params.get(0), params.get(1),  (long)Double.parseDouble(params.get(2)));
			} else {
				return new AssertElementAttributeValue(castToElem(defs.get(0)), keywordProvider.loggers, keywordProvider.waits, params.get(0), params.get(1), keywordProvider.asserts.getDefaultWait());
			}
		}
	}
}
