package keywords;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import data.ObjectDef;
import framework.AssertKeyword;
import framework.Framework;
import interfaces.ILogging;
import interfaces.IWait;

public class AssertPageTitleContains extends AssertKeyword {

	private final ILogging logger;
	private final IWait wait;
	private final long timeout;
	private final WebDriver driver;
	private final String expected;
	
	public AssertPageTitleContains(WebDriver driver, String title, ILogging logger, IWait wait, long timeoutSeconds) {
		this.logger = logger;
		this.wait = wait;
		this.timeout = timeoutSeconds;
		this.driver = driver;
		this.expected = title;
	}

	@Override
	public Void perform() {
		wait.untilPageTitleContains(expected, timeout).perform();
		Assert.assertTrue(driver.getTitle().contains(expected), "Page Title did not contain '"+expected+"'");
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

	public static AssertKeyword instantiateExternal(Framework framework, List<ObjectDef> defs,
			List<String> params) {
		if(params.size() > 1) {
			return new AssertPageTitleContains(framework.driver, params.get(0), framework.logger, framework.wait,  (long)Double.parseDouble(params.get(1)));
		} else {
			return new AssertPageTitleContains(framework.driver, params.get(0), framework.logger, framework.wait, framework.asserter.getDefaultWait());
		}
	}

}
