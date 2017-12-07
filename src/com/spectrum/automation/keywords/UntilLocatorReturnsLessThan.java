package com.spectrum.automation.keywords;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.spectrum.automation.Interfaces.ILogging;

public class UntilLocatorReturnsLessThan extends WaitKeyword {

	private final ILogging logger;
	private final long maxTime;
	private final WebDriver driver;
	private final int number;
	private By locator;
	
	public UntilLocatorReturnsLessThan(WebDriver driver, By locator, int lessNumber, ILogging logger, long maxWaitSeconds) {
		this.locator = locator;
		this.logger = logger;
		this.maxTime = maxWaitSeconds;
		this.driver = driver;
		this.number = lessNumber;
	}

	@Override
	public Boolean perform() {
		WebDriverWait wait = new WebDriverWait(driver, maxTime);
		try {
			List<WebElement> list = wait.until(ExpectedConditions.numberOfElementsToBeLessThan(locator, number));
			if(list.size() < number) {
				return true;
			} else {
				return false;
			}
		} catch(TimeoutException e) {
			return false;
		}
		
	}

	@Override
	public void startLog() {
		logger.beginKeyword(this, locator);
	}

	@Override
	public void endLog() {
		logger.endKeyword(this);
	}
}
