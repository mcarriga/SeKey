package keywords;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import interfaces.ILogging;
import interfaces.IWait;

public class Waits implements IWait {
	private final WebDriver driver;
	private final ILogging logger;
	
	public Waits(WebDriver driver, ILogging logger) {
		this.driver = driver;
		this.logger = logger;
	}

	@Override
	public WaitKeyword untilElementExists(By locator, long maxWaitSeconds) {
		return new UntilElementExists(driver, locator, maxWaitSeconds,logger);
	}

	@Override
	public WaitKeyword untilElementNotPresent(By locator, long maxWaitSeconds) {
		return new UntilElementNotPresentBy(driver, locator, logger, maxWaitSeconds);
	}

	@Override
	public WaitKeyword untilElementVisible(By locator, long maxWaitSeconds) {
		return new UntilElementVisible(driver, locator, logger, maxWaitSeconds);
	}

	@Override
	public WaitKeyword untilElementVisible(WebElement element, long maxWaitSeconds) {
		return new UntilElementVisible(driver, element, logger, maxWaitSeconds);
	}

	@Override
	public WaitKeyword untilElementNotPresent(WebElement element, long maxWaitSeconds) {
		return new UntilElementNotPresent(driver, element, logger, maxWaitSeconds);
	}

	@Override
	public WaitKeyword untilPageLoadStatusComplete(long maxWaitSeconds) {
		return new UntilPageLoadStatusComplete(driver, logger, maxWaitSeconds);
	}

	@Override
	public WaitKeyword untilElementClickable(By locator, long maxWaitSeconds) {
		return new UntilElementClickable(driver, locator, logger, maxWaitSeconds);
	}

	@Override
	public WaitKeyword untilElementClickable(WebElement element, long maxWaitSeconds) {
		return new UntilElementClickable(driver, element, logger, maxWaitSeconds);
	}

	@Override
	public WaitKeyword untilElementTextEquals(By locator, String expectedText, long maxWaitSeconds) {
		return new UntilElementTextEquals(driver, locator, expectedText, logger, maxWaitSeconds);
	}

	@Override
	public WaitKeyword untilElementTextEquals(WebElement element, String expectedText, long maxWaitSeconds) {
		return new UntilElementTextEquals(driver, element, expectedText, logger, maxWaitSeconds);
	}

	@Override
	public WaitKeyword untilElementTextContains(By locator, String expectedText, long maxWaitSeconds) {
		return new UntilElementTextContains(driver, locator, expectedText, logger, maxWaitSeconds);
	}

	@Override
	public WaitKeyword untilElementTextContains(WebElement element, String expectedText, long maxWaitSeconds) {
		return new UntilElementTextContains(driver, element, expectedText, logger, maxWaitSeconds);
	}

	@Override
	public WaitKeyword untilElementValueEquals(By locator, String expectedValue, long maxWaitSeconds) {
		return new UntilElementAttributeEquals(driver, locator, "value", expectedValue, logger, maxWaitSeconds);
	}

	@Override
	public WaitKeyword untilElementValueEquals(WebElement element, String expectedValue, long maxWaitSeconds) {
		return new UntilElementAttributeEquals(driver, element, "value", expectedValue, logger, maxWaitSeconds);
	}

	@Override
	public WaitKeyword untilElementValueContains(By locator, String expectedValue, long maxWaitSeconds) {
		return new UntilElementAttributeContains(driver, locator, "value", expectedValue, logger, maxWaitSeconds);
	}

	@Override
	public WaitKeyword untilElementValueContains(WebElement element, String expectedValue, long maxWaitSeconds) {
		return new UntilElementAttributeContains(driver, element, "value", expectedValue, logger, maxWaitSeconds);
	}

	@Override
	public WaitKeyword untilElementAttributeEquals(By locator, String attrName, String expectedValue,
			long maxWaitSeconds) {
		return new UntilElementAttributeEquals(driver, locator, expectedValue, expectedValue, logger, maxWaitSeconds);
	}

	@Override
	public WaitKeyword untilElementAttributeEquals(WebElement element, String attrName, String expectedValue,
			long maxWaitSeconds) {
		return new UntilElementAttributeEquals(driver, element, expectedValue, expectedValue, logger, maxWaitSeconds);
	}

	@Override
	public WaitKeyword untilElementAttributeContains(By locator, String attrName, String expectedValue,
			long maxWaitSeconds) {
		return new UntilElementAttributeContains(driver, locator, expectedValue, expectedValue, logger, maxWaitSeconds);
	}

	@Override
	public WaitKeyword untilElementAttributeContains(WebElement element, String attrName, String expectedValue,
			long maxWaitSeconds) {
		return new UntilElementAttributeContains(driver, element, expectedValue, expectedValue, logger, maxWaitSeconds);
	}

	@Override
	public WaitKeyword untilElementSelected(By locator, long maxWaitSeconds) {
		return new UntilElementSelected(driver, locator, logger, maxWaitSeconds);
	}

	@Override
	public WaitKeyword untilElementSelected(WebElement element, long maxWaitSeconds) {
		return new UntilElementSelected(driver, element, logger, maxWaitSeconds);
	}

	@Override
	public WaitKeyword untilElementNotSelected(By locator, long maxWaitSeconds) {
		return new UntilElementNotSelected(driver, locator, logger, maxWaitSeconds);
	}

	@Override
	public WaitKeyword untilElementNotSelected(WebElement element, long maxWaitSeconds) {
		return new UntilElementNotSelected(driver, element, logger, maxWaitSeconds);
	}

	@Override
	public WaitKeyword untilPageTitleEquals(String title, long maxWaitSeconds) {
		return new UntilPageTitleEquals(driver, title, logger, maxWaitSeconds);
	}

	@Override
	public WaitKeyword untilPageTitleContains(String title, long maxWaitSeconds) {
		return new UntilPageTitleContains(driver, title, logger, maxWaitSeconds);
	}

	@Override
	public WaitKeyword untilCurrentUrlEquals(String Url, long maxWaitSeconds) {
		return new UntilCurrentUrlEquals(driver, Url, logger, maxWaitSeconds);
	}

	@Override
	public WaitKeyword untilCurrentUrlContains(String Url, long maxWaitSeconds) {
		return new UntilCurrentUrlContains(driver, Url, logger, maxWaitSeconds);
	}

	@Override
	public WaitKeyword untilAlertIsPresent(long maxWaitSeconds) {
		return new UntilAlertIsPresent(driver, logger, maxWaitSeconds);
	}

	@Override
	public WaitKeyword untilLocatorReturnsNumberOfElements(By locator, int expectedNumber, long maxWaitSeconds) {
		return new UntilLocatorReturnsNumberOfElements(driver, locator, expectedNumber, logger, maxWaitSeconds);
	}

	@Override
	public WaitKeyword untilLocatorReturnsLessThan(By locator, int lessNumber, long maxWaitSeconds) {
		return new UntilLocatorReturnsLessThan(driver, locator, lessNumber, logger, maxWaitSeconds);
	}

	@Override
	public WaitKeyword untilLocatorReturnsGreaterThan(By locator, int greaterNumber, long maxWaitSeconds) {
		return new UntilLocatorReturnsGreaterThan(driver, locator, greaterNumber, logger, maxWaitSeconds);
	}

	@Override
	public WaitKeyword untilPresenceOfNestedElements(By locator, By childLocator, int greaterNumber,
			long maxWaitSeconds) {
		return new UntilPresenceOfNestedElements(driver, locator, childLocator, logger, maxWaitSeconds);
	}

	@Override
	public WaitKeyword untilPresenceOfNestedElements(WebElement element, By childLocator, int greaterNumber,
			long maxWaitSeconds) {
		return new UntilPresenceOfNestedElements(driver, element, childLocator, logger, maxWaitSeconds);
	}

	@Override
	public WaitKeyword untilPresenceOfNestedElement(By locator, By childLocator, int greaterNumber,
			long maxWaitSeconds) {
		return new UntilPresenceOfNestedElement(driver, locator, childLocator, logger, maxWaitSeconds);
	}

	@Override
	public WaitKeyword untilPresenceOfNestedElement(WebElement element, By childLocator, int greaterNumber,
			long maxWaitSeconds) {
		return new UntilPresenceOfNestedElement(driver, element, childLocator, logger, maxWaitSeconds);
	}

	@Override
	public WaitKeyword untilDropDownSelectedTextIs(By locator, String name, long maxWaitSeconds) {
		return new UntilDropDownSelectedTextIs(driver, locator, name, logger, maxWaitSeconds);
	}

	@Override
	public WaitKeyword untilDropDownSelectedTextIs(WebElement element, String name, long maxWaitSeconds) {
		return new UntilDropDownSelectedTextIs(driver, element, name, logger, maxWaitSeconds);
	}

	@Override
	public WaitKeyword untilDropDownSelectedValueIs(By locator, String name, long maxWaitSeconds) {
		return new UntilDropDownSelectedValueIs(driver, locator, name, logger, maxWaitSeconds);
	}

	@Override
	public WaitKeyword untilDropDownSelectedValueIs(WebElement element, String name, long maxWaitSeconds) {
		return new UntilDropDownSelectedValueIs(driver, element, name, logger, maxWaitSeconds);
	}

	@Override
	public WaitKeyword untilDropDownItemCountIs(By locator, int count, long maxWaitSeconds) {
		return new UntilDropDownItemCountIs(driver, locator, count, logger, maxWaitSeconds);
	}

	@Override
	public WaitKeyword untilDropDownItemCountIs(WebElement element, int count, long maxWaitSeconds) {
		return new UntilDropDownItemCountIs(driver, element, count, logger, maxWaitSeconds);
	}

	@Override
	public WaitKeyword untilDropDownCountainsValueText(By locator, String text, long maxWaitSeconds) {
		return new UntilDropDownCountainsValueText(driver, locator, text, logger, maxWaitSeconds);
	}

	@Override
	public WaitKeyword untilDropDownCountainsValueText(WebElement element, String text, long maxWaitSeconds) {
		return new UntilDropDownCountainsValueText(driver, element, text, logger, maxWaitSeconds);
	}

	@Override
	public WaitKeyword untilDropDownCountainsValueTexts(By locator, List<String> texts, long maxWaitSeconds) {
		return new UntilDropDownCountainsValueTexts(driver, locator, texts, logger, maxWaitSeconds);
	}

	@Override
	public WaitKeyword untilDropDownCountainsValueTexts(WebElement element, List<String> texts, long maxWaitSeconds) {
		return new UntilDropDownCountainsValueTexts(driver, element, texts, logger, maxWaitSeconds);
	}

	@Override
	public WaitKeyword untilDropDownValueTextsInOrderOf(By locator, List<String> text, long maxWaitSeconds) {
		return new UntilDropDownValueTextsInOrderOf(driver, locator, text, logger, maxWaitSeconds);
	}

	@Override
	public WaitKeyword untilDropDownValueTextsInOrderOf(WebElement element, List<String> text, long maxWaitSeconds) {
		return new UntilDropDownValueTextsInOrderOf(driver, element, text, logger, maxWaitSeconds);
	}

	@Override
	public WaitKeyword untilStalenessOf(By locator, long maxWaitSeconds) {
		return new UntilStalenessOf(driver, locator, logger, maxWaitSeconds);
	}

	@Override
	public WaitKeyword untilStalenessOf(WebElement element, long maxWaitSeconds) {
		return new UntilStalenessOf(driver, element, logger, maxWaitSeconds);
	}

	@Override
	public WaitKeyword untilElementNotVisible(By locator, long maxWaitSeconds) {
		return new UntilElementNotVisible(driver, locator, logger, maxWaitSeconds);
	}

	@Override
	public WaitKeyword untilElementNotVisible(WebElement element, long maxWaitSeconds) {
		return new UntilElementNotVisible(driver, element, logger, maxWaitSeconds);
	}

	@Override
	public WaitKeyword untilElementEnabled(By locator, long maxWaitSeconds) {
		return new UntilElementEnabled(driver, locator, logger, maxWaitSeconds);
	}

	@Override
	public WaitKeyword untilElementEnabled(WebElement element, long maxWaitSeconds) {
		return new UntilElementEnabled(driver, element, logger, maxWaitSeconds);
	}

	@Override
	public WaitKeyword untilElementNotEnabled(By locator, long maxWaitSeconds) {
		return new UntilElementNotEnabled(driver, locator, logger, maxWaitSeconds);
	}

	@Override
	public WaitKeyword untilElementNotEnabled(WebElement element, long maxWaitSeconds) {
		return new UntilElementNotEnabled(driver, element, logger, maxWaitSeconds);
	}

	@Override
	public WaitKeyword untilAlertIsNotPresent(long maxWaitSeconds) {
		return new UntilAlertIsNotPresent(driver, logger, maxWaitSeconds);
	}
}
