package keywords;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import framework.WaitKeyword;
import interfaces.ILogging;

public class UntilElementVisible extends WaitKeyword {
	private final WebDriver driver;
	private final ILogging _logger;
	private final long _maxTime;
	private final WebElement _element;
	private By locator = null;
	
	public UntilElementVisible(WebDriver driver, WebElement element, ILogging logger, long maxWaitSeconds) {
		this.driver = driver;
		this._logger = logger;
		this._element = element;
		this._maxTime = maxWaitSeconds;
	}
	
	public UntilElementVisible(WebDriver driver, By locator, ILogging logger, long maxWaitSeconds) {
		this.driver = driver;
		this.locator = locator;
		this._element = driver.findElement(locator);
		this._logger = logger;
		this._maxTime = maxWaitSeconds;
	}
	
	@Override
	public Boolean perform() {
		WebDriverWait wait = new WebDriverWait(driver, _maxTime);
		WebElement x;
		try {
			if(locator != null) {
				x = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
			}else {
				x = wait.until(ExpectedConditions.visibilityOf(_element));
			}
		return x != null;
		}catch(TimeoutException e) {
			return false;
		}
	}

	@Override
	public void startLog() {
		_logger.beginKeyword(this, locator);
	}

	@Override
	public void endLog() {
		_logger.endKeyword(this);
	}

}
