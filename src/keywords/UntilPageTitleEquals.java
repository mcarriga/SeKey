package keywords;

import java.util.List;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import data.ObjectDef;
import framework.Framework;
import framework.WaitKeyword;
import interfaces.ILogging;

public class UntilPageTitleEquals extends WaitKeyword {

	private final WebDriver driver;
	private final ILogging logger;
	private final long maxTime;
	private final String title;
	
	public UntilPageTitleEquals(WebDriver driver, String title, ILogging logger, long maxWaitSeconds) {
		this.driver = driver;
		this.logger = logger;
		this.maxTime = maxWaitSeconds;
		this.title = title;
	}

	@Override
	public Boolean perform() {
		WebDriverWait wait = new WebDriverWait(driver, maxTime);
		try {
			return wait.until(ExpectedConditions.titleIs(title));
		} catch(TimeoutException e) {
			return false;
		}
	}

	@Override
	public void startLog() {
		logger.beginKeyword(this, ";Expected Title: "+title);
	}

	@Override
	public void endLog() {
		logger.endKeyword(this);
	}

	@Override
	public WaitKeyword instantiateExternal(Framework framework, List<ObjectDef> defs, List<String> objects,
			List<String> params) {
		return new UntilPageTitleEquals(framework.driver, params.get(0), framework.logger,  (long)Double.parseDouble(params.get(1)));
	}
}
