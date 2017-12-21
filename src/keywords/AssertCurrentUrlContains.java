package keywords;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import data.ObjectDef;
import framework.AssertKeyword;
import framework.Framework;
import interfaces.ILogging;
import interfaces.IWait;

public class AssertCurrentUrlContains extends AssertKeyword {
	
	private final ILogging logger;
	private final IWait wait;
	private final long timeout;
	private final WebDriver driver;
	private final String expected;

	public AssertCurrentUrlContains(WebDriver driver, String url, ILogging logger, IWait wait, long timeoutSeconds) {
		this.logger = logger;
		this.wait = wait;
		this.timeout = timeoutSeconds;
		this.driver = driver;
		this.expected = url;
	}

	@Override
	public Void perform() {
		wait.untilCurrentUrlContains(expected, timeout).perform();
		Assert.assertTrue(driver.getCurrentUrl().contains(expected), "Current URL did not contain '"+expected+"'");
		return null;
	}

	@Override
	public void startLog() {
		logger.beginKeyword(this, "URL: "+expected);
	}

	@Override
	public void endLog() {
		logger.endKeyword(this);
	}

	@Override
	public AssertKeyword instantiateExternal(Framework framework, List<ObjectDef> defs, List<String> objects,
			List<String> params) {
		if(params.size() > 1) {
			return new AssertCurrentUrlContains(framework.driver, params.get(0), framework.logger, framework.wait,  (long)Double.parseDouble(params.get(1)));
		} else {
			return new AssertCurrentUrlContains(framework.driver, params.get(0), framework.logger, framework.wait, framework.asserter.getDefaultWait());
		}
	}

}
