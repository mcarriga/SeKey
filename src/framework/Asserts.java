package framework;

import java.util.List;
import java.util.concurrent.Callable;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import assertKeywords.*;
import interfaces.IAssert;
import interfaces.ILogging;
import interfaces.IWait;

public class Asserts implements IAssert, Callable<Void> {
	private final WebDriver driver;
	private final ILogging logger;
	private final IWait wait;
	private long defaultWait = 15;

	public Asserts(WebDriver driver, ILogging logger, IWait wait) {
		this.wait = wait;
		this.driver = driver;
		this.logger = logger;
	}
	
	@Override
	public long getDefaultWait() {
		return defaultWait;
	}

	@Override
	public Void call() throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AssertKeyword assertText(By locator, String expected, long timeoutSeconds) {
		return new AssertText(driver, logger, wait, locator, expected, timeoutSeconds);
	}

	@Override
	public AssertKeyword assertText(WebElement element, String expected, long timeoutSeconds) {
		return new AssertText(element, logger, wait, expected, timeoutSeconds);
	}

	@Override
	public AssertKeyword assertTextContains(By locator, String expected, long timeoutSeconds) {
		return new AssertTextContains(driver, logger, wait, locator, expected, timeoutSeconds);
	}

	@Override
	public AssertKeyword assertTextContains(WebElement element, String expected, long timeoutSeconds) {
		return new AssertTextContains(element, logger, wait, expected, timeoutSeconds);
	}

	@Override
	public AssertKeyword assertValue(By locator, String expected, long timeoutSeconds) {
		return new AssertValue(driver, logger, wait, locator, expected, timeoutSeconds);
	}

	@Override
	public AssertKeyword assertValue(WebElement element, String expected, long timeoutSeconds) {
		return new AssertValue(element, logger, wait, expected, timeoutSeconds);
	}

	@Override
	public AssertKeyword assertValueContains(By locator, String expected, long timeoutSeconds) {
		return new AssertValueContains(driver, logger, wait, locator, expected, timeoutSeconds);
	}

	@Override
	public AssertKeyword assertValueContains(WebElement element, String expected, long timeoutSeconds) {
		return new AssertValueContains(element, logger, wait, expected, timeoutSeconds);
	}

	@Override
	public AssertKeyword assertElementAttributeValue(By locator, String attrName, String expected, long timeoutSeconds) {
		return new AssertElementAttributeValue(driver, logger, wait, expected, locator, expected, timeoutSeconds);
	}

	@Override
	public AssertKeyword assertElementAttributeValue(WebElement element, String attrName, String expected,
			long timeoutSeconds) {
		return new AssertElementAttributeValue(element, logger, wait, expected, expected, timeoutSeconds);
	}

	@Override
	public AssertKeyword assertElementAttributeValueContains(By locator, String attrName, String expected,
			long timeoutSeconds) {
		return new AssertElementAttributeValueContains(driver, logger, wait, expected, locator, expected, timeoutSeconds);
	}

	@Override
	public AssertKeyword assertElementAttributeValueContains(WebElement element, String attrName, String expected,
			long timeoutSeconds) {
		return new AssertElementAttributeValueContains(element, logger, wait, expected, expected, timeoutSeconds);
	}

	@Override
	public AssertKeyword assertElementExists(By locator, long timeoutSeconds) {
		return new AssertElementExists(driver, logger, wait, locator, timeoutSeconds);
	}

	@Override
	public AssertKeyword assertElementVisible(By locator, long timeoutSeconds) {
		return new AssertElementVisible(driver, logger, wait, locator, timeoutSeconds);
	}

	@Override
	public AssertKeyword assertElementVisible(WebElement element, long timeoutSeconds) {
		return new AssertElementVisible(element, logger, wait, timeoutSeconds);
	}

	@Override
	public AssertKeyword assertElementNotVisible(By locator, long timeoutSeconds) {
		return new AssertElementNotVisible(driver, logger, wait, locator, timeoutSeconds);
	}

	@Override
	public AssertKeyword assertElementNotVisible(WebElement element, long timeoutSeconds) {
		return new AssertElementNotVisible(element, logger, wait, timeoutSeconds);
	}

	@Override
	public AssertKeyword assertElementEnabled(By locator, long timeoutSeconds) {
		return new AssertElementEnabled(driver, logger, wait, locator, timeoutSeconds);
	}

	@Override
	public AssertKeyword assertElementEnabled(WebElement element, long timeoutSeconds) {
		return new AssertElementEnabled(element, logger, wait, timeoutSeconds);
	}

	@Override
	public AssertKeyword assertElementNotEnabled(By locator, long timeoutSeconds) {
		return new AssertElementNotEnabled(driver, logger, wait, locator, timeoutSeconds);
	}

	@Override
	public AssertKeyword assertElementNotEnabled(WebElement element, long timeoutSeconds) {
		return new AssertElementNotEnabled(element, logger, wait, timeoutSeconds);
	}

	@Override
	public AssertKeyword assertElementSelected(By locator, long timeoutSeconds) {
		return new AssertElementSelected(driver, logger, wait, locator, timeoutSeconds);
	}

	@Override
	public AssertKeyword assertElementSelected(WebElement element, long timeoutSeconds) {
		return new AssertElementSelected(element, logger, wait, timeoutSeconds);
	}

	@Override
	public AssertKeyword assertElementNotSelected(By locator, long timeoutSeconds) {
		return new AssertElementNotSelected(driver, logger, wait, locator, timeoutSeconds);
	}

	@Override
	public AssertKeyword assertElementNotSelected(WebElement element, long timeoutSeconds) {
		return new AssertElementNotSelected(element, logger, wait, timeoutSeconds);
	}

	@Override
	public AssertKeyword assertPageTitleEquals(String title, long timeoutSeconds) {
		return new AssertPageTitleEquals(driver, title, logger, wait, timeoutSeconds);
	}

	@Override
	public AssertKeyword assertPageTitleContains(String title, long timeoutSeconds) {
		return new AssertPageTitleContains(driver, title, logger, wait, timeoutSeconds);
	}

	@Override
	public AssertKeyword assertCurrentUrlEquals(String Url, long timeoutSeconds) {
		return new AssertCurrentUrlEquals(driver, Url, logger, wait, timeoutSeconds);
	}

	@Override
	public AssertKeyword assertCurrentUrlContains(String Url, long timeoutSeconds) {
		return new AssertCurrentUrlContains(driver, Url, logger, wait, timeoutSeconds);
	}

	@Override
	public AssertKeyword assertAlertIsPresent(long timeoutSeconds) {
		return new AssertAlertIsPresent(logger, wait, timeoutSeconds);
	}

	@Override
	public AssertKeyword assertLocatorReturnsNumberOfElements(By locator, int expectedNumber, long timeoutSeconds) {
		return new AssertLocatorReturnsNumberOfElements(driver, locator, expectedNumber, logger, wait, timeoutSeconds);
	}

	@Override
	public AssertKeyword assertLocatorReturnsLessThan(By locator, int lessNumber, long timeoutSeconds) {
		return new AssertLocatorReturnsLessThan(driver, locator, lessNumber, logger, wait, timeoutSeconds);
	}

	@Override
	public AssertKeyword assertLocatorReturnsGreaterThan(By locator, int greaterNumber, long timeoutSeconds) {
		return new AssertLocatorReturnsGreaterThan(driver, locator, greaterNumber, logger, wait, timeoutSeconds);
	}

	@Override
	public AssertKeyword assertDropDownSelectedTextIs(By locator, String name, long timeoutSeconds) {
		return new AssertDropDownSelectedTextIs(driver, locator, name, logger, wait, timeoutSeconds);
	}

	@Override
	public AssertKeyword assertDropDownSelectedTextIs(WebElement element, String name, long timeoutSeconds) {
		return new AssertDropDownSelectedTextIs(element, name, logger, wait, timeoutSeconds);
	}

	@Override
	public AssertKeyword assertDropDownSelectedValueIs(By locator, String name, long timeoutSeconds) {
		return new AssertDropDownSelectedValueIs(driver, locator, name, logger, wait, timeoutSeconds);
	}

	@Override
	public AssertKeyword assertDropDownSelectedValueIs(WebElement element, String name, long timeoutSeconds) {
		return new AssertDropDownSelectedValueIs(element, name, logger, wait, timeoutSeconds);
	}

	@Override
	public AssertKeyword assertDropDownItemCountIs(By locator, int count, long timeoutSeconds) {
		return new AssertDropDownItemCountIs(driver, locator, count, logger, wait, timeoutSeconds);
	}

	@Override
	public AssertKeyword assertDropDownItemCountIs(WebElement element, int count, long timeoutSeconds) {
		return new AssertDropDownItemCountIs(element, count, logger, wait, timeoutSeconds);
	}

	@Override
	public AssertKeyword assertDropDownCountainsOption(By locator, String optionText, long timeoutSeconds) {
		return new AssertDropDownContainsOption(driver, locator, optionText, logger, wait, timeoutSeconds);
	}

	@Override
	public AssertKeyword assertDropDownCountainsOption(WebElement element, String optionText, long timeoutSeconds) {
		return new AssertDropDownContainsOption(element, optionText, logger, wait, timeoutSeconds);
	}

	@Override
	public AssertKeyword assertDropDownCountainsOptions(By locator, List<String> options, long timeoutSeconds) {
		return new AssertDropDownContainsOptions(driver, locator, options, logger, wait, timeoutSeconds);
	}

	@Override
	public AssertKeyword assertDropDownCountainsOptions(WebElement element, List<String> options, long timeoutSeconds) {
		return new AssertDropDownContainsOptions(element, options, logger, wait, timeoutSeconds);
	}

	@Override
	public AssertKeyword assertDropDownOptionsInOrderOf(By locator, List<String> text, long timeoutSeconds) {
		return new AssertDropDownOptionsInOrderOf(driver, locator, text, logger, wait, timeoutSeconds);
	}

	@Override
	public AssertKeyword assertDropDownOptionsInOrderOf(WebElement element, List<String> text, long timeoutSeconds) {
		return new AssertDropDownOptionsInOrderOf(element, text, logger, wait, timeoutSeconds);
	}

	@Override
	public AssertKeyword assertText(By locator, String expected) {
		return new AssertText(driver, logger, wait, locator, expected, defaultWait);
	}

	@Override
	public AssertKeyword assertText(WebElement element, String expected) {
		return new AssertText(element, logger, wait, expected, defaultWait);
	}

	@Override
	public AssertKeyword assertTextContains(By locator, String expected) {
		return new AssertTextContains(driver, logger, wait, locator, expected, defaultWait);
	}

	@Override
	public AssertKeyword assertTextContains(WebElement element, String expected) {
		return new AssertTextContains(element, logger, wait, expected, defaultWait);
	}

	@Override
	public AssertKeyword assertValue(By locator, String expected) {
		return new AssertValue(driver, logger, wait, locator, expected, defaultWait);
	}

	@Override
	public AssertKeyword assertValue(WebElement element, String expected) {
		return new AssertValue(element, logger, wait, expected, defaultWait);
	}

	@Override
	public AssertKeyword assertValueContains(By locator, String expected) {
		return new AssertValueContains(driver, logger, wait, locator, expected, defaultWait);
	}

	@Override
	public AssertKeyword assertValueContains(WebElement element, String expected) {
		return new AssertValueContains(element, logger, wait, expected, defaultWait);
	}

	@Override
	public AssertKeyword assertElementAttributeValue(By locator, String attrName, String expected) {
		return new AssertElementAttributeValue(driver, logger, wait, expected, locator, expected, defaultWait);
	}

	@Override
	public AssertKeyword assertElementAttributeValue(WebElement element, String attrName, String expected) {
		return new AssertElementAttributeValue(element, logger, wait, expected, expected, defaultWait);
	}

	@Override
	public AssertKeyword assertElementAttributeValueContains(By locator, String attrName, String expected) {
		return new AssertElementAttributeValueContains(driver, logger, wait, expected, locator, expected, defaultWait);
	}

	@Override
	public AssertKeyword assertElementAttributeValueContains(WebElement element, String attrName, String expected) {
		return new AssertElementAttributeValueContains(element, logger, wait, expected, expected, defaultWait);
	}

	@Override
	public AssertKeyword assertElementExists(By locator) {
		return new AssertElementExists(driver, logger, wait, locator, defaultWait);
	}

	@Override
	public AssertKeyword assertElementVisible(By locator) {
		return new AssertElementVisible(driver, logger, wait, locator, defaultWait);
	}

	@Override
	public AssertKeyword assertElementVisible(WebElement element) {
		return new AssertElementVisible(element, logger, wait, defaultWait);
	}

	@Override
	public AssertKeyword assertElementNotVisible(By locator) {
		return new AssertElementNotVisible(driver, logger, wait, locator, defaultWait);
	}

	@Override
	public AssertKeyword assertElementNotVisible(WebElement element) {
		return new AssertElementNotVisible(element, logger, wait, defaultWait);
	}

	@Override
	public AssertKeyword assertElementEnabled(By locator) {
		return new AssertElementEnabled(driver, logger, wait, locator, defaultWait);
	}

	@Override
	public AssertKeyword assertElementEnabled(WebElement element) {
		return new AssertElementEnabled(element, logger, wait, defaultWait);
	}

	@Override
	public AssertKeyword assertElementNotEnabled(By locator) {
		return new AssertElementNotEnabled(driver, logger, wait, locator, defaultWait);
	}

	@Override
	public AssertKeyword assertElementNotEnabled(WebElement element) {
		return new AssertElementNotEnabled(element, logger, wait, defaultWait);
	}

	@Override
	public AssertKeyword assertElementSelected(By locator) {
		return new AssertElementSelected(driver, logger, wait, locator, defaultWait);
	}

	@Override
	public AssertKeyword assertElementSelected(WebElement element) {
		return new AssertElementSelected(element, logger, wait, defaultWait);
	}

	@Override
	public AssertKeyword assertElementNotSelected(By locator) {
		return new AssertElementNotSelected(driver, logger, wait, locator, defaultWait);
	}

	@Override
	public AssertKeyword assertElementNotSelected(WebElement element) {
		return new AssertElementNotSelected(element, logger, wait, defaultWait);
	}

	@Override
	public AssertKeyword assertPageTitleEquals(String title) {
		return new AssertPageTitleEquals(driver, title, logger, wait, defaultWait);
	}

	@Override
	public AssertKeyword assertPageTitleContains(String title) {
		return new AssertPageTitleContains(driver, title, logger, wait, defaultWait);
	}

	@Override
	public AssertKeyword assertCurrentUrlEquals(String Url) {
		return new AssertCurrentUrlEquals(driver, Url, logger, wait, defaultWait);
	}

	@Override
	public AssertKeyword assertCurrentUrlContains(String Url) {
		return new AssertCurrentUrlContains(driver, Url, logger, wait, defaultWait);
	}

	@Override
	public AssertKeyword assertAlertIsPresent() {
		return new AssertAlertIsPresent(logger, wait, defaultWait);
	}

	@Override
	public AssertKeyword assertLocatorReturnsNumberOfElements(By locator, int expectedNumber) {
		return new AssertLocatorReturnsNumberOfElements(driver, locator, expectedNumber, logger, wait, defaultWait);
	}

	@Override
	public AssertKeyword assertLocatorReturnsLessThan(By locator, int lessNumber) {
		return new AssertLocatorReturnsLessThan(driver, locator, lessNumber, logger, wait, defaultWait);
	}

	@Override
	public AssertKeyword assertLocatorReturnsGreaterThan(By locator, int greaterNumber) {
		return new AssertLocatorReturnsGreaterThan(driver, locator, greaterNumber, logger, wait, defaultWait);
	}

	@Override
	public AssertKeyword assertDropDownSelectedTextIs(By locator, String name) {
		return new AssertDropDownSelectedTextIs(driver, locator, name, logger, wait, defaultWait);
	}

	@Override
	public AssertKeyword assertDropDownSelectedTextIs(WebElement element, String name) {
		return new AssertDropDownSelectedTextIs(element, name, logger, wait, defaultWait);
	}

	@Override
	public AssertKeyword assertDropDownSelectedValueIs(By locator, String name) {
		return new AssertDropDownSelectedValueIs(driver, locator, name, logger, wait, defaultWait);
	}

	@Override
	public AssertKeyword assertDropDownSelectedValueIs(WebElement element, String name) {
		return new AssertDropDownSelectedValueIs(element, name, logger, wait, defaultWait);
	}

	@Override
	public AssertKeyword assertDropDownItemCountIs(By locator, int count) {
		return new AssertDropDownItemCountIs(driver, locator, count, logger, wait, defaultWait);
	}

	@Override
	public AssertKeyword assertDropDownItemCountIs(WebElement element, int count) {
		return new AssertDropDownItemCountIs(element, count, logger, wait, defaultWait);
	}

	@Override
	public AssertKeyword assertDropDownCountainsOption(By locator, String text) {
		return new AssertDropDownContainsOption(driver, locator, text, logger, wait, defaultWait);
	}

	@Override
	public AssertKeyword assertDropDownCountainsOption(WebElement element, String text) {
		return new AssertDropDownContainsOption(element, text, logger, wait, defaultWait);
	}

	@Override
	public AssertKeyword assertDropDownCountainsOptions(By locator, List<String> text) {
		return new AssertDropDownContainsOptions(driver, locator, text, logger, wait, defaultWait);
	}

	@Override
	public AssertKeyword assertDropDownCountainsOptions(WebElement element, List<String> text) {
		return new AssertDropDownContainsOptions(element, text, logger, wait, defaultWait);
	}

	@Override
	public AssertKeyword assertDropDownOptionsInOrderOf(By locator, List<String> text) {
		return new AssertDropDownOptionsInOrderOf(driver, locator, text, logger, wait, defaultWait);
	}

	@Override
	public AssertKeyword assertDropDownOptionsInOrderOf(WebElement element, List<String> text) {
		return new AssertDropDownOptionsInOrderOf(element, text, logger, wait, defaultWait);
	}

	@Override
	public void setDefaultWait(long seconds)
	{
		defaultWait = seconds;
		
	}
	
}
