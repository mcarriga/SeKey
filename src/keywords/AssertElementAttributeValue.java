package keywords;

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

	@Override
	public AssertKeyword instantiateExternal(Framework framework, List<ObjectDef> defs, List<String> objects,
			List<String> params) {
		if(isBy(defs.get(0))) {
			if(params.size() > 2) {
				return new AssertElementAttributeValue(framework.driver, framework.logger, framework.wait, params.get(0), castToBy(defs.get(0)), params.get(1),  (long)Double.parseDouble(params.get(2)));
			} else {
				return new AssertElementAttributeValue(framework.driver, framework.logger, framework.wait, params.get(0), castToBy(defs.get(0)), params.get(1), framework.asserter.getDefaultWait());
			}
		} else {
			if(params.size() > 2) {
				return new AssertElementAttributeValue(castToElem(defs.get(0)), framework.logger, framework.wait, params.get(0), params.get(1),  (long)Double.parseDouble(params.get(2)));
			} else {
				return new AssertElementAttributeValue(castToElem(defs.get(0)), framework.logger, framework.wait, params.get(0), params.get(1), framework.asserter.getDefaultWait());
			}
		}
	}
}
