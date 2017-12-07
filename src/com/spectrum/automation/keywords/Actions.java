package com.spectrum.automation.keywords;

import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.spectrum.automation.Interfaces.IAction;
import com.spectrum.automation.Interfaces.ILogging;
import com.spectrum.automation.Interfaces.IWait;

public class Actions implements IAction {
	private final WebDriver _driver;
	private final ILogging _logger;
	private final IWait _wait;
	
	public Actions(WebDriver driver, ILogging logger, IWait wait) {
		this._wait = wait;
		this._driver = driver;
		this._logger = logger;
	}

	@Override
	public ActionKeyword selectByName(By locator, String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ActionKeyword selectByName(WebElement element, String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ActionKeyword click(By locator) {
		return new Click(_driver, _logger, _wait, locator);
	}

	@Override
	public ActionKeyword click(WebElement element) {
		return new Click(element, _logger, _wait);
	}

	@Override
	public ActionKeyword sendKeys(By locator, String text) {
		return new SetText(_driver, locator, _logger, text);
	}

	@Override
	public ActionKeyword sendKeys(WebElement element, String text) {
		return new SetText(element, _logger, text);
	}
	
	@Override
	public ActionKeyword executeJavaScript(String js) {
		return new ExecuteJavaScript<Object>(_driver, _logger, js);
	}

	@Override
	public ActionKeyword NavigateTo(String url) {
		return new NavigateToUrl(_driver, _logger, url);
	}

	@Override
	public ActionKeyword NavigateTo(URL url) {
		return new NavigateToUrl(_driver, _logger, url);
	}

	@Override
	public ActionKeyword NavigateBack() {
		return new NavigateBack(_driver, _logger);
	}

	@Override
	public ActionKeyword NavigateForward() {
		return new NavigateForward(_driver, _logger);
	}

	@Override
	public ActionKeyword NavigateRefresh() {
		return new NavigateRefresh(_driver, _logger);
	}

	@Override
	public ActionKeyword executeJavaScript(String js, Object... args) {
		return new ExecuteJavaScript<Object>(_driver, _logger, js, args);
	}

}
