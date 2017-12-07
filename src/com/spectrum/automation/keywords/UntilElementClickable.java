package com.spectrum.automation.keywords;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.spectrum.automation.Interfaces.ILogging;

public class UntilElementClickable extends WaitKeyword {
	private final WebDriver driver;
	private final ILogging _logger;
	private final long _maxTime;
	private final WebElement _element;
	private By locator = null;
	
	public UntilElementClickable(WebDriver driver, WebElement element, ILogging logger, long maxWaitSeconds) {
		this.driver = driver;
		this._logger = logger;
		this._element = element;
		this._maxTime = maxWaitSeconds;
	}
	
	public UntilElementClickable(WebDriver driver, By locator, ILogging logger, long maxWaitSeconds) {
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
		if(locator != null) {
			x = wait.until(ExpectedConditions.elementToBeClickable(locator));
		}else {
			x = wait.until(ExpectedConditions.elementToBeClickable(_element));
		}
		return x != null;
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
