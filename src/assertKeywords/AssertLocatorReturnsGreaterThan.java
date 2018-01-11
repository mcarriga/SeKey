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

	public static AssertKeyword instantiateExternal(KeywordProvider keywordProvider, List<ObjectDef> defs,
			List<String> params) {
		if(params.size() > 1) {
			return new AssertLocatorReturnsGreaterThan(keywordProvider.driver, castToBy(defs.get(0)), (int)Double.parseDouble(params.get(0)), keywordProvider.loggers, keywordProvider.waits,  (long)Double.parseDouble(params.get(1)));
		} else {
			return new AssertLocatorReturnsGreaterThan(keywordProvider.driver, castToBy(defs.get(0)), (int)Double.parseDouble(params.get(0)), keywordProvider.loggers, keywordProvider.waits, keywordProvider.asserts.getDefaultWait());
		}
	}

}
