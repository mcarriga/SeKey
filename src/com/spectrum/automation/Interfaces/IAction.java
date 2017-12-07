package com.spectrum.automation.Interfaces;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.spectrum.automation.keywords.ActionKeyword;

public interface IAction {
	ActionKeyword selectByName(By locator, String name);
	ActionKeyword selectByName(WebElement element, String name);
	ActionKeyword click(By locator);
	ActionKeyword click(WebElement element);
	ActionKeyword sendKeys(By locator, String text);
	ActionKeyword sendKeys(WebElement element, String text);
	ActionKeyword executeJavaScript(String js);
	ActionKeyword executeJavaScript(String js, Object... args);
	ActionKeyword NavigateTo(String url);
	ActionKeyword NavigateTo(URL url);
	ActionKeyword NavigateBack();
	ActionKeyword NavigateForward();
	ActionKeyword NavigateRefresh();
}
