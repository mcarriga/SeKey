package com.spectrum.automation.keywords;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.spectrum.automation.Interfaces.ILogging;

public class UntilCurrentUrlEquals extends WaitKeyword {

	private final WebDriver driver;
	private final ILogging logger;
	private final long maxTime;
	private final String url;
	
	public UntilCurrentUrlEquals(WebDriver driver, String url, ILogging logger, long maxWaitSeconds) {
		this.driver = driver;
		this.logger = logger;
		this.maxTime = maxWaitSeconds;
		this.url = url;
	}

	@Override
	public Boolean perform() {
		WebDriverWait wait = new WebDriverWait(driver, maxTime);
		return wait.until(ExpectedConditions.urlToBe(url));
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
