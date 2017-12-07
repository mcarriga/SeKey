package com.spectrum.automation.keywords;

import java.util.List;
import java.util.concurrent.Callable;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.spectrum.automation.Interfaces.IAction;
import com.spectrum.automation.Interfaces.IAssert;
import com.spectrum.automation.Interfaces.ILogging;
import com.spectrum.automation.Interfaces.IWait;

public class Asserts implements IAssert, Callable<Void> {
	private final WebDriver driver;
	private final ILogging logger;
	private final IWait wait;
	private final IAction action;

	public Asserts(WebDriver driver, ILogging logger, IAction action, IWait wait) {
		this.wait = wait;
		this.driver = driver;
		this.logger = logger;
		this.action = action;
	}

	@Override
	public Void call() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AssertKeyword assertText(By locator, String expected) {
		return new AssertText(driver, logger, wait, locator, expected);
	}

	@Override
	public AssertKeyword assertText(WebElement element, String expected) {
		return new AssertText(element, logger, wait, expected);
	}

	@Override
	public AssertKeyword assertValue(By locator, String expected) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AssertKeyword assertValue(WebElement element, String expected) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AssertKeyword assertTextContains(By locator, String expected) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AssertKeyword assertTextContains(WebElement element, String expected) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AssertKeyword assertValueContains(By locator, String expected) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AssertKeyword assertValueContains(WebElement element, String expected) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AssertKeyword assertElementAttributeValue(By locator, String attrName, String expected) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AssertKeyword assertElementAttributeValue(WebElement element, String attrName, String expected) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AssertKeyword assertElementAttributeValueContains(By locator, String attrName, String expected) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AssertKeyword assertElementAttributeValueContains(WebElement element, String attrName, String expected) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AssertKeyword assertElementExists(By locator) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AssertKeyword assertElementVisible(By locator) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AssertKeyword assertElementVisible(WebElement element) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AssertKeyword assertElementNotVisible(By locator) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AssertKeyword assertElementNotVisible(WebElement element) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AssertKeyword assertElementEnabled(By locator) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AssertKeyword assertElementEnabled(WebElement element) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AssertKeyword assertElementNotEnabled(By locator) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AssertKeyword assertElementNotEnabled(WebElement element) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AssertKeyword assertElementSelected(By locator) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AssertKeyword assertElementSelected(WebElement element) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AssertKeyword assertElementNotSelected(By locator) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AssertKeyword assertElementNotSelected(WebElement element) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AssertKeyword assertPageTitleEquals(String title) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AssertKeyword assertPageTitleContains(String title) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AssertKeyword assertCurrentUrlEquals(String Url) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AssertKeyword assertCurrentUrlContains(String Url) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AssertKeyword assertAlertIsPresent() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AssertKeyword assertLocatorReturnsNumberOfElements(By locator, int expectedNumber) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AssertKeyword assertLocatorReturnsLessThan(By locator, int lessNumber) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AssertKeyword assertLocatorReturnsGreaterThan(By locator, int greaterNumber) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AssertKeyword assertPresenceOfNestedElements(By locator, By childLocator, int greaterNumber) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AssertKeyword assertPresenceOfNestedElements(WebElement element, By childLocator, int greaterNumber) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AssertKeyword assertPresenceOfNestedElement(By locator, By childLocator, int greaterNumber) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AssertKeyword assertPresenceOfNestedElement(WebElement element, By childLocator, int greaterNumber) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AssertKeyword assertDropDownSelectedTextIs(By locator, String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AssertKeyword assertDropDownSelectedTextIs(WebElement element, String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AssertKeyword assertDropDownSelectedValueIs(By locator, String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AssertKeyword assertDropDownSelectedValueIs(WebElement element, String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AssertKeyword assertDropDownItemCountIs(By locator, int count) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AssertKeyword assertDropDownItemCountIs(WebElement element, int count) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AssertKeyword assertDropDownCountainsValueText(By locator, String text) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AssertKeyword assertDropDownCountainsValueText(WebElement element, String text) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AssertKeyword assertDropDownCountainsValueTexts(By locator, List<String> text) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AssertKeyword assertDropDownCountainsValueTexts(WebElement element, List<String> text) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AssertKeyword assertDropDownValueTextsInOrderOf(By locator, List<String> text) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AssertKeyword assertDropDownValueTextsInOrderOf(WebElement element, List<String> text) {
		// TODO Auto-generated method stub
		return null;
	}

}
