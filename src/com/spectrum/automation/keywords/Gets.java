package com.spectrum.automation.keywords;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.spectrum.automation.Interfaces.IGet;
import com.spectrum.automation.Interfaces.ILogging;

public class Gets implements IGet {
	private WebDriver driver;
	private ILogging logger;
	
	public Gets(WebDriver driver, ILogging logger) {
		this.driver = driver;
		this.logger = logger;
	}

	@Override
	public GetKeyword<String> GetElementText(By locator) {
		return new GetText(driver, locator, logger);
	}

	@Override
	public GetKeyword<String> GetElementText(WebElement element) {
		return new GetText(element, logger);
	}

	@Override
	public GetKeyword<String> GetElementValue(By locator) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GetKeyword<String> GetElementValue(WebElement element) {
		// TODO Auto-generated method stub
		return null;
	}

}
