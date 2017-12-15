package keywords;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import framework.WaitKeyword;
import interfaces.ILogging;

public class UntilElementExists extends WaitKeyword {
	private final WebDriver driver;
	private final ILogging _logger;
	private final long _maxTime;
	private final By _locator;
	
	public UntilElementExists(WebDriver driver, By locator, long maxWaitSeconds, ILogging logger) {
		this._locator = locator;
		this._logger = logger;
		this._maxTime = maxWaitSeconds;
		this.driver = driver;
	}
	
	@Override
	public Boolean perform() {
		WebDriverWait wait = new WebDriverWait(driver, _maxTime);
		try {
			WebElement x = wait.until(ExpectedConditions.presenceOfElementLocated(_locator));
			if(x == null) {
				return false;
			} else {
				return true;
			}
		} catch(TimeoutException e) {
			return false;
		}
	}

	@Override
	public void startLog() {
		_logger.beginKeyword(this, _locator);
	}

	@Override
	public void endLog() {
		_logger.endKeyword(this);
	}

}
