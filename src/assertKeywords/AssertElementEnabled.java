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

public class AssertElementEnabled extends AssertKeyword {

	private final ILogging logger;
	private final IWait wait;
	private final long timeout;
	private final WebElement element;
	private By locator = null;
	
	public AssertElementEnabled(WebDriver driver, ILogging logger, IWait wait, By locator, long timeoutSeconds) {
		this(driver.findElement(locator), logger, wait, timeoutSeconds);
	}
	
	public AssertElementEnabled(WebElement element, ILogging logger, IWait wait, long timeoutSeconds) {
		this.element = element;
		this.logger = logger;
		this.wait = wait;
		this.timeout = timeoutSeconds;
	}

	@Override
	public Void perform() {
		wait.untilElementEnabled(element, timeout).perform();
		StringBuilder builder = new StringBuilder();
		builder.append("Element is NOT Enabled");
		if(locator !=null) builder.append("; By: "+locator);
		Assert.assertTrue(element.isEnabled(), builder.toString());
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
		if(isBy(defs.get(0))) {
			if(params.size() > 0) {
				return new AssertElementEnabled(keywordProvider.driver, keywordProvider.loggers, keywordProvider.waits, castToBy(defs.get(0)),  (long)Double.parseDouble(params.get(0)));
			} else {
				return new AssertElementEnabled(keywordProvider.driver, keywordProvider.loggers, keywordProvider.waits, castToBy(defs.get(0)), keywordProvider.asserts.getDefaultWait());
			}
		} else {
			if(params.size() > 0) {
				return new AssertElementEnabled(castToElem(defs.get(0)), keywordProvider.loggers, keywordProvider.waits,  (long)Double.parseDouble(params.get(0)));
			} else {
				return new AssertElementEnabled(castToElem(defs.get(0)), keywordProvider.loggers, keywordProvider.waits, keywordProvider.asserts.getDefaultWait());
			}
		}
	}
}
