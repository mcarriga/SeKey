package com.spectrum.automation.keywords;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.spectrum.automation.Interfaces.ILogging;

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
		return wait.until(ExpectedConditions.titleIs(title));
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
