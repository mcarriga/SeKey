package keywords;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import interfaces.ILogging;

public class UntilCurrentUrlContains extends WaitKeyword {

	private final WebDriver driver;
	private final ILogging logger;
	private final long maxTime;
	private final String url;
	
	public UntilCurrentUrlContains(WebDriver driver, String url, ILogging logger, long maxWaitSeconds) {
		this.driver = driver;
		this.logger = logger;
		this.maxTime = maxWaitSeconds;
		this.url = url;
	}

	@Override
	public Boolean perform() {
		WebDriverWait wait = new WebDriverWait(driver, maxTime);
		try {
			return wait.until(ExpectedConditions.urlContains(url));
		}catch(TimeoutException e) {
			return false;
		}
	}

	@Override
	public void startLog() {
		logger.beginKeyword(this, ";Expected URL: "+url);
	}

	@Override
	public void endLog() {
		logger.endKeyword(this);
	}
}
