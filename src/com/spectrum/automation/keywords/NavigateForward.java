package com.spectrum.automation.keywords;

import org.openqa.selenium.WebDriver;

import com.spectrum.automation.Interfaces.IAfterAction;
import com.spectrum.automation.Interfaces.ILogging;

public class NavigateForward extends ActionKeyword {

	private final WebDriver driver;
	private final ILogging logger;
	
	public NavigateForward(WebDriver driver, ILogging logger) {
		this.driver = driver;
		this.logger = logger;
	}
	
	@Override
	public IAfterAction guarantee() {
		return new AfterAction((ActionKeyword)build(), 2);
	}

	@Override
	public Void perform() {
		driver.navigate().forward();
		return null;
	}

	@Override
	public void startLog() {
		logger.beginKeyword(this);
	}

	@Override
	public void endLog() {
		logger.endKeyword(this);
	}
}
