package keywords;

import java.util.List;
import java.util.concurrent.Callable;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import interfaces.IAction;
import interfaces.IAssert;
import interfaces.ILogging;
import interfaces.IWait;

public class Asserts implements IAssert, Callable<Void> {
	private final WebDriver driver;
	private final ILogging logger;
	private final IWait wait;
	private final IAction action;
	private final long defaultWait = 15;

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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AssertKeyword assertDropDownSelectedValueIs(WebElement element, String name, long timeoutSeconds) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AssertKeyword assertDropDownItemCountIs(By locator, int count, long timeoutSeconds) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AssertKeyword assertDropDownItemCountIs(WebElement element, int count, long timeoutSeconds) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AssertKeyword assertDropDownCountainsValueText(By locator, String text, long timeoutSeconds) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AssertKeyword assertDropDownCountainsValueText(WebElement element, String text, long timeoutSeconds) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AssertKeyword assertDropDownCountainsValueTexts(By locator, List<String> text, long timeoutSeconds) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AssertKeyword assertDropDownCountainsValueTexts(WebElement element, List<String> text, long timeoutSeconds) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AssertKeyword assertDropDownValueTextsInOrderOf(By locator, List<String> text, long timeoutSeconds) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AssertKeyword assertDropDownValueTextsInOrderOf(WebElement element, List<String> text, long timeoutSeconds) {
		// TODO Auto-generated method stub
		return null;
	}
}
