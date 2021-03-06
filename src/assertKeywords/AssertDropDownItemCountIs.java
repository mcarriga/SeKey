package assertKeywords;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import data.ObjectDef;
import framework.AssertKeyword;
import framework.KeywordProvider;
import interfaces.ILogging;
import interfaces.IWait;
import junit.framework.Assert;

public class AssertDropDownItemCountIs extends AssertKeyword {

	private final ILogging logger;
	private final long maxTime;
	private final WebElement element;
	private final int count;
	private final IWait wait;
	private By locator = null;
	
	public AssertDropDownItemCountIs(WebElement element, int expectedCount, ILogging logger, IWait wait, long maxWaitSeconds) {
		this.logger = logger;
		this.element = element;
		this.maxTime = maxWaitSeconds;
		this.count = expectedCount;
		this.wait = wait;
	}
	
	public AssertDropDownItemCountIs(WebDriver driver, By locator, int expectedCount, ILogging logger, IWait wait, long maxWaitSeconds) {
		this(driver.findElement(locator), expectedCount, logger, wait, maxWaitSeconds);
	}

	@Override
	public Void perform() {
		wait.untilDropDownItemCountIs(element, count, maxTime).perform();
		Select select = new Select(element);
		Assert.assertEquals(count, select.getAllSelectedOptions().size());
		return null;
	}

	@Override
	public void startLog() {
		logger.beginKeyword(this, locator, ";expectedCount: "+count);
	}

	@Override
	public void endLog() {
		logger.endKeyword(this);
	}

	public static AssertKeyword instantiateExternal(KeywordProvider keywordProvider, List<ObjectDef> defs,
			List<String> params) {
		if(isBy(defs.get(0))) {
			if(params.size() > 1) {
				return new AssertDropDownItemCountIs(keywordProvider.driver, castToBy(defs.get(0)), (int)Double.parseDouble(params.get(0)), keywordProvider.loggers, keywordProvider.waits,  (long)Double.parseDouble(params.get(1)));
			} else {
				return new AssertDropDownItemCountIs(keywordProvider.driver, castToBy(defs.get(0)), (int)Double.parseDouble(params.get(0)), keywordProvider.loggers, keywordProvider.waits, keywordProvider.asserts.getDefaultWait());
			}
		} else {
			if(params.size() > 1) {
				return new AssertDropDownItemCountIs(castToElem(defs.get(0)), (int)Double.parseDouble(params.get(0)), keywordProvider.loggers, keywordProvider.waits,  (long)Double.parseDouble(params.get(1)));
			} else {
				return new AssertDropDownItemCountIs(castToElem(defs.get(0)), (int)Double.parseDouble(params.get(0)), keywordProvider.loggers, keywordProvider.waits, keywordProvider.asserts.getDefaultWait());
			}
		}
	}
}
