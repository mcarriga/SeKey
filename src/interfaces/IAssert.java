package interfaces;
import java.util.List;
import java.util.concurrent.Callable;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import keywords.AssertKeyword;

public interface IAssert extends Callable<Void> {
	AssertKeyword assertText(By locator, String expected, long timeoutSeconds);
	AssertKeyword assertText(WebElement element, String expected, long timeoutSeconds);
	AssertKeyword assertTextContains(By locator, String expected, long timeoutSeconds);
	AssertKeyword assertTextContains(WebElement element, String expected, long timeoutSeconds);
	AssertKeyword assertValue(By locator, String expected, long timeoutSeconds);
	AssertKeyword assertValue(WebElement element, String expected, long timeoutSeconds);
	AssertKeyword assertValueContains(By locator, String expected, long timeoutSeconds);
	AssertKeyword assertValueContains(WebElement element, String expected, long timeoutSeconds);
	AssertKeyword assertElementAttributeValue(By locator, String attrName, String expected, long timeoutSeconds);
	AssertKeyword assertElementAttributeValue(WebElement element, String attrName, String expected, long timeoutSeconds);
	AssertKeyword assertElementAttributeValueContains(By locator, String attrName, String expected, long timeoutSeconds);
	AssertKeyword assertElementAttributeValueContains(WebElement element, String attrName, String expected, long timeoutSeconds);
	AssertKeyword assertElementExists(By locator, long timeoutSeconds);
	AssertKeyword assertElementVisible(By locator, long timeoutSeconds);
	AssertKeyword assertElementVisible(WebElement element, long timeoutSeconds);
	AssertKeyword assertElementNotVisible(By locator, long timeoutSeconds);
	AssertKeyword assertElementNotVisible(WebElement element, long timeoutSeconds);
	AssertKeyword assertElementEnabled(By locator, long timeoutSeconds);
	AssertKeyword assertElementEnabled(WebElement element, long timeoutSeconds);
	AssertKeyword assertElementNotEnabled(By locator, long timeoutSeconds);
	AssertKeyword assertElementNotEnabled(WebElement element, long timeoutSeconds);
	AssertKeyword assertElementSelected(By locator, long timeoutSeconds);
	AssertKeyword assertElementSelected(WebElement element, long timeoutSeconds);
	AssertKeyword assertElementNotSelected(By locator, long timeoutSeconds);
	AssertKeyword assertElementNotSelected(WebElement element, long timeoutSeconds);
	AssertKeyword assertPageTitleEquals(String title, long timeoutSeconds);
	AssertKeyword assertPageTitleContains(String title, long timeoutSeconds);
	AssertKeyword assertCurrentUrlEquals(String Url, long timeoutSeconds);
	AssertKeyword assertCurrentUrlContains(String Url, long timeoutSeconds);
	AssertKeyword assertAlertIsPresent(long timeoutSeconds);
	AssertKeyword assertLocatorReturnsNumberOfElements(By locator, int expectedNumber, long timeoutSeconds);
	AssertKeyword assertLocatorReturnsLessThan(By locator, int lessNumber, long timeoutSeconds);
	AssertKeyword assertLocatorReturnsGreaterThan(By locator, int greaterNumber, long timeoutSeconds);
	AssertKeyword assertDropDownSelectedTextIs(By locator, String name, long timeoutSeconds);
	AssertKeyword assertDropDownSelectedTextIs(WebElement element, String name, long timeoutSeconds);
	AssertKeyword assertDropDownSelectedValueIs(By locator, String name, long timeoutSeconds);
	AssertKeyword assertDropDownSelectedValueIs(WebElement element, String name, long timeoutSeconds);
	AssertKeyword assertDropDownItemCountIs(By locator, int count, long timeoutSeconds);
	AssertKeyword assertDropDownItemCountIs(WebElement element, int count, long timeoutSeconds);
	AssertKeyword assertDropDownCountainsValueText(By locator, String text, long timeoutSeconds);
	AssertKeyword assertDropDownCountainsValueText(WebElement element, String text, long timeoutSeconds);
	AssertKeyword assertDropDownCountainsValueTexts(By locator, List<String> text, long timeoutSeconds);
	AssertKeyword assertDropDownCountainsValueTexts(WebElement element, List<String> text, long timeoutSeconds);
	AssertKeyword assertDropDownValueTextsInOrderOf(By locator, List<String> text, long timeoutSeconds);
	AssertKeyword assertDropDownValueTextsInOrderOf(WebElement element, List<String> text, long timeoutSeconds);
}
