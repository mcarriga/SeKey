package keywords;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import data.ObjectDef;
import framework.AssertKeyword;
import framework.Framework;
import interfaces.ILogging;
import interfaces.IWait;

public class AssertPageTitleEquals extends AssertKeyword {

	private final ILogging logger;
	private final IWait wait;
	private final long timeout;
	private final WebDriver driver;
	private final String expected;
	
	public AssertPageTitleEquals(WebDriver driver, String title, ILogging logger, IWait wait, long timeoutSeconds) {
		this.logger = logger;
		this.wait = wait;
		this.timeout = timeoutSeconds;
		this.driver = driver;
		this.expected = title;
	}

	@Override
	public Void perform() {
		wait.untilPageTitleEquals(expected, timeout).perform();
		Assert.assertEquals(driver.getTitle(), expected);
		return null;
	}

	@Override
	public void startLog() {
		logger.beginKeyword(this, "Title: "+expected);
	}

	@Override
	public void endLog() {
		logger.endKeyword(this);
	}

	@Override
	public AssertKeyword instantiateExternal(Framework framework, List<ObjectDef> defs, List<String> objects,
			List<String> params) {
		if(params.size() > 1) {
			return new AssertPageTitleEquals(framework.driver, params.get(0), framework.logger, framework.wait,  (long)Double.parseDouble(params.get(1)));
		} else {
			return new AssertPageTitleEquals(framework.driver, params.get(0), framework.logger, framework.wait, framework.asserter.getDefaultWait());
		}
	}

}
