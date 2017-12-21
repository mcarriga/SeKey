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

public class AssertElementVisible extends AssertKeyword {

	private final ILogging logger;
	private final IWait wait;
	private final long timeout;
	private final WebElement element;
	private By locator = null;
	
	public AssertElementVisible(WebDriver driver, ILogging logger, IWait wait, By locator, long timeoutSeconds) {
		this(driver.findElement(locator), logger, wait, timeoutSeconds);
	}
	
	public AssertElementVisible(WebElement element, ILogging logger, IWait wait, long timeoutSeconds) {
		this.element = element;
		this.logger = logger;
		this.wait = wait;
		this.timeout = timeoutSeconds;
	}

	@Override
	public Void perform() {
		wait.untilElementVisible(element, timeout).perform();
		StringBuilder builder = new StringBuilder();
		builder.append("Element is NOT Visible/Displayed");
		if(locator !=null) builder.append("; By: "+locator);
		Assert.assertTrue(element.isDisplayed(), builder.toString());
		return null;
	}

	@Override
	public void startLog() {
		logger.beginKeyword(this, locator);
	}

	@Override
	public void endLog() {
		logger.endKeyword(this);
	}

	public static AssertKeyword instantiateExternal(Framework framework, List<ObjectDef> defs,
			List<String> params) {
		if(isBy(defs.get(0))) {
			if(params.size() > 0) {
				return new AssertElementVisible(framework.driver, framework.logger, framework.wait, castToBy(defs.get(0)),  (long)Double.parseDouble(params.get(0)));
			} else {
				return new AssertElementVisible(framework.driver, framework.logger, framework.wait, castToBy(defs.get(0)), framework.asserter.getDefaultWait());
			}
		} else {
			if(params.size() > 0) {
				return new AssertElementVisible(castToElem(defs.get(0)), framework.logger, framework.wait,  (long)Double.parseDouble(params.get(0)));
			} else {
				return new AssertElementVisible(castToElem(defs.get(0)), framework.logger, framework.wait, framework.asserter.getDefaultWait());
			}
		}
	}
}
