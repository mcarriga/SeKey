package keywords;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import interfaces.ILogging;

public class UntilPageTitleContains extends WaitKeyword {

	private final WebDriver driver;
	private final ILogging logger;
	private final long maxTime;
	private final String title;
	
	public UntilPageTitleContains(WebDriver driver, String title, ILogging logger, long maxWaitSeconds) {
		this.driver = driver;
		this.logger = logger;
		this.maxTime = maxWaitSeconds;
		this.title = title;
	}

	@Override
	public Boolean perform() {
		WebDriverWait wait = new WebDriverWait(driver, maxTime);
		try {
			return wait.until(ExpectedConditions.titleContains(title));
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
}
