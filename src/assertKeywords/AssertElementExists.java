package assertKeywords;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import data.ObjectDef;
import framework.AssertKeyword;
import framework.KeywordProvider;
import interfaces.ILogging;
import interfaces.IWait;

public class AssertElementExists extends AssertKeyword {

	private final ILogging logger;
	private final IWait wait;
	private final long timeout;
	private final By locator;
	
	public AssertElementExists(WebDriver driver, ILogging logger, IWait wait, By locator, long timeoutSeconds) {
		this.locator = locator;
		this.logger = logger;
		this.wait = wait;
		this.timeout = timeoutSeconds;
	}

	@Override
	public Void perform() {
		Assert.assertTrue(wait.untilElementExists(locator, timeout).perform().equals(true), "Element with locator "+locator+" was not found on the DOM");
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
		if(params.size() > 0) {
			return new AssertElementExists(keywordProvider.driver, keywordProvider.loggers, keywordProvider.waits, castToBy(defs.get(0)),  (long)Double.parseDouble(params.get(0)));
		} else {
			return new AssertElementExists(keywordProvider.driver, keywordProvider.loggers, keywordProvider.waits, castToBy(defs.get(0)), keywordProvider.asserts.getDefaultWait());
		}
	}
}
