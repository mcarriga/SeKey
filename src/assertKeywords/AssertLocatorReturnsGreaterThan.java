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

public class AssertLocatorReturnsGreaterThan extends AssertKeyword {

	private final ILogging logger;
	private final IWait wait;
	private final long timeout;
	private final By locator;
	private final int number;
	private final WebDriver driver;
	
	public AssertLocatorReturnsGreaterThan(WebDriver driver, By locator, int greaterNumber, ILogging logger, IWait wait, long timeoutSeconds) {
		this.locator = locator;
		this.logger = logger;
		this.wait = wait;
		this.timeout = timeoutSeconds;
		this.number = greaterNumber;
		this.driver = driver;
	}

	@Override
	public Void perform() {
		wait.untilLocatorReturnsGreaterThan(locator, number, timeout).perform();
		List<WebElement> all = driver.findElements(locator);
		Assert.assertTrue(all.size() > number, "Expected to find greater than "+number +" elements but found "+all.size());
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
		if(params.size() > 1) {
			return new AssertLocatorReturnsGreaterThan(framework.driver, castToBy(defs.get(0)), (int)Double.parseDouble(params.get(0)), framework.logger, framework.wait,  (long)Double.parseDouble(params.get(1)));
		} else {
			return new AssertLocatorReturnsGreaterThan(framework.driver, castToBy(defs.get(0)), (int)Double.parseDouble(params.get(0)), framework.logger, framework.wait, framework.asserter.getDefaultWait());
		}
	}

}
