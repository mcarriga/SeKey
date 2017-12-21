package keywords;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import data.ObjectDef;
import framework.Framework;
import framework.WaitKeyword;
import interfaces.ILogging;

public class UntilAlertIsPresent extends WaitKeyword {

	private final WebDriver driver;
	private final ILogging logger;
	private final long maxTime;
	
	public UntilAlertIsPresent(WebDriver driver, ILogging logger, long maxWaitSeconds) {
		this.driver = driver;
		this.logger = logger;
		this.maxTime = maxWaitSeconds;
	}

	@Override
	public Boolean perform() {
		WebDriverWait wait = new WebDriverWait(driver, maxTime);
		@SuppressWarnings("unused")
		Alert alert = null;
		try {
			alert = wait.until(ExpectedConditions.alertIsPresent());
			return true;
		} catch(TimeoutException e) {
			return false;
		}
	}

	@Override
	public void startLog() {
		logger.beginKeyword(this);
	}

	@Override
	public void endLog() {
		logger.endKeyword(this);
	}

	@Override
	public WaitKeyword instantiateExternal(Framework framework, List<ObjectDef> defs, List<String> objects,
			List<String> params) {
		return new UntilAlertIsPresent(framework.driver, framework.logger,  (long)Double.parseDouble(params.get(0)));
	}
}
