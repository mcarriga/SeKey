package keywords;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import data.ObjectDef;
import framework.AssertKeyword;
import framework.Framework;
import interfaces.ILogging;
import interfaces.IWait;
import junit.framework.Assert;

public class AssertDropDownContainsOption extends AssertKeyword {

	private final ILogging logger;
	private final long maxTime;
	private final WebElement element;
	private final String expectedText;
	private final IWait wait;
	private By locator = null;
	
	public AssertDropDownContainsOption(WebElement element, String expectedOptionText, ILogging logger, IWait wait, long maxWaitSeconds) {
		this.logger = logger;
		this.element = element;
		this.maxTime = maxWaitSeconds;
		this.expectedText = expectedOptionText;
		this.wait = wait;
	}
	
	public AssertDropDownContainsOption(WebDriver driver, By locator, String expectedOptionText, ILogging logger, IWait wait, long maxWaitSeconds) {
		this(driver.findElement(locator), expectedOptionText, logger, wait, maxWaitSeconds);
	}

	@Override
	public Void perform() {
		wait.untilDropDownCountainsOption(element, expectedText, maxTime).perform();
		Select select = new Select(element);
		boolean found = false;
		List<WebElement> all = select.getAllSelectedOptions();
		for(WebElement e : all) {
			if(e.getText().equals(expectedText)) {
				found =  true;
				break;
			}
		}
		Assert.assertTrue("No option with text '"+expectedText+"' was found in drop down", found);;
		return null;
	}

	@Override
	public void startLog() {
		logger.beginKeyword(this, locator, ";expectedOptionText: "+expectedText);
	}

	@Override
	public void endLog() {
		logger.endKeyword(this);
	}

	@Override
	public AssertKeyword instantiateExternal(Framework framework, List<ObjectDef> defs, List<String> objects,
			List<String> params) {
		if(isBy(defs.get(0))) {
			if(params.size() > 1) {
				return new AssertDropDownContainsOption(framework.driver, castToBy(defs.get(0)), params.get(0), framework.logger, framework.wait,  (long)Double.parseDouble(params.get(1)));
			} else {
				return new AssertDropDownContainsOption(framework.driver, castToBy(defs.get(0)), params.get(0), framework.logger, framework.wait, framework.asserter.getDefaultWait());
			}
		} else {
			if(params.size() > 1) {
				return new AssertDropDownContainsOption(castToElem(defs.get(0)), params.get(0), framework.logger, framework.wait,  (long)Double.parseDouble(params.get(1)));
			} else {
				return new AssertDropDownContainsOption(castToElem(defs.get(0)), params.get(0), framework.logger, framework.wait, framework.asserter.getDefaultWait());
			}
		}
	}

}
