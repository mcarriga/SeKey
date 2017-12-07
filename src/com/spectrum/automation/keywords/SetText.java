package com.spectrum.automation.keywords;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.spectrum.automation.Interfaces.IAfterAction;
import com.spectrum.automation.Interfaces.ILogging;

public class SetText extends ActionKeyword {
	private final WebElement _element;
	private final ILogging _logger;
	private final String _text;
	private By locator = null;
	
	public SetText(WebElement element, ILogging logger, String text) {
		this._element = element;
		this._logger = logger;
		this._text = text;
	}
	
	public SetText(WebDriver driver, By locator, ILogging logger, String text) {
		this.locator = locator;
		this._element = driver.findElement(locator);
		this._logger = logger;
		this._text = text;
	}

	@Override
	public IAfterAction guarantee() {
		return new AfterAction((ActionKeyword)build(), 2);
	}

	@Override
	public Void perform() {
		_element.sendKeys(_text);
		return null;
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
