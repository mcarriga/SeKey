package com.spectrum.automation.keywords;

import java.net.URL;

import org.openqa.selenium.WebDriver;

import com.spectrum.automation.Interfaces.IAfterAction;
import com.spectrum.automation.Interfaces.ILogging;

public class NavigateToUrl extends ActionKeyword {
	private final WebDriver driver;
	private final String url;
	private final ILogging logger;
	
	public NavigateToUrl(WebDriver driver, ILogging logger, String url) {
		this.driver = driver;
		this.url = url;
		this.logger = logger;
	}
	
	public NavigateToUrl(WebDriver driver, ILogging logger, URL url) {
		this.driver = driver;
		this.url = url.toString();
		this.logger = logger;
	}

	@Override
	public IAfterAction guarantee() {
		return new AfterAction((ActionKeyword)build(), 2);
	}

	@Override
	public Void perform() {
		driver.navigate().to(url);
		return null;
	}

	@Override
	public void startLog() {
		logger.beginKeyword(this, "; Url: "+url);
	}

	@Override
	public void endLog() {
		logger.endKeyword(this);
	}

}
