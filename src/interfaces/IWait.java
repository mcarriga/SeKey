package interfaces;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import framework.WaitKeyword;

/**
 * KeywordProvider provided Wait Keywords
 * Wait Keywords are any keyword intended delay the execution of Selenium until some specific condition is met.
 * Generally, these Keywords look at various properties of WebElements or page/browser properties like URL and page title.
 * Wait Keywords return a true or false depending on if the condition was met within the given time
 * All Wait Keywords have a max timeout set in seconds and if the wait condition is not met within the timeout a false is returned.
 * @author Mathew Carrigan
 *
 */
public interface IWait {
	/**
	 * Waits until an element exists with given By Locator
	 * @param locator By locator for WebElement
	 * @param maxWaitSeconds max wait time in seconds for condition to be met
	 * @return WaitKeyword
	 */
	WaitKeyword untilElementExists(By locator, long maxWaitSeconds);
	
	/**
	 * Waits until an element is not present on the page
	 * @param locator By locator for the WebElement
	 * @param maxWaitSeconds max wait time in seconds for condition to be met
	 * @return  WaitKeyword
	 */
	WaitKeyword untilElementNotPresent(By locator, long maxWaitSeconds);
	
	/**
	 * Waits until an element is not present on the page
	 * @param element WebElement to perform wait on
	 * @param maxWaitSeconds max wait time in seconds for condition to be met
	 * @return  WaitKeyword
	 */
	WaitKeyword untilElementNotPresent(WebElement element, long maxWaitSeconds);
	
	/**
	 * Waits until an element is Visible on the page
	 * @param locator By locator for the WebElement
	 * @param maxWaitSeconds max wait time in seconds for condition to be met
	 * @return WaitKeyword
	 */
	WaitKeyword untilElementVisible(By locator, long maxWaitSeconds);
	
	/**
	 * Waits until an element is Visible on the page
	 * @param element WebElement to perform wait on
	 * @param maxWaitSeconds max wait time in seconds for condition to be met
	 * @return WaitKeyword
	 */
	WaitKeyword untilElementVisible(WebElement element, long maxWaitSeconds);
	
	/**
	 * Waits until an element is NOT Visible on the page
	 * @param locator By locator for the WebElement
	 * @param maxWaitSeconds max wait time in seconds for condition to be met
	 * @return WaitKeyword
	 */
	WaitKeyword untilElementNotVisible(By locator, long maxWaitSeconds);
	
	/**
	 * Waits until an element is NOT Visible on the page
	 * @param element WebElement to perform wait on
	 * @param maxWaitSeconds max wait time in seconds for condition to be met
	 * @return WaitKeyword
	 */
	WaitKeyword untilElementNotVisible(WebElement element, long maxWaitSeconds);
	
	/**
	 * Waits until the page load status is complete
	 * @param maxWaitSeconds max wait time in seconds for condition to be met
	 * @return WaitKeyword
	 */
	WaitKeyword untilPageLoadStatusComplete(long maxWaitSeconds);
	
	/**
	 * Waits until an element is clickable - both visible and enabled
	 * @param locator By locator for the WebElement
	 * @param maxWaitSeconds max wait time in seconds for condition to be met
	 * @return WaitKeyword
	 */
	WaitKeyword untilElementClickable(By locator, long maxWaitSeconds);
	
	/**
	 * Waits until an element is clickable - both visible and enabled
	 * @param element WebElement to perform wait on
	 * @param maxWaitSeconds max wait time in seconds for condition to be met
	 * @return WaitKeyword
	 */
	WaitKeyword untilElementClickable(WebElement element, long maxWaitSeconds);
	
	/**
	 * Waits until the text of an element matches expected text
	 * @param locator By locator for the WebElement
	 * @param expectedText Expected text to match against
	 * @param maxWaitSeconds max wait time in seconds for condition to be met
	 * @return WaitKeyword
	 */
	WaitKeyword untilElementTextEquals(By locator, String expectedText, long maxWaitSeconds);
	
	/**
	 * Waits until the text of an element matches expected text
	 * @param element WebElement to perform wait on
	 * @param expectedText Expected text to match against
	 * @param maxWaitSeconds max wait time in seconds for condition to be met
	 * @return WaitKeyword
	 */
	WaitKeyword untilElementTextEquals(WebElement element, String expectedText, long maxWaitSeconds);
	
	/**
	 * Waits until the text of an element contains the expected text
	 * @param locator By locator for the WebElement
	 * @param expectedText Expected text to be contained in the element
	 * @param maxWaitSeconds max wait time in seconds for condition to be met
	 * @return WaitKeyword
	 */
	WaitKeyword untilElementTextContains(By locator, String expectedText, long maxWaitSeconds);
	
	/**
	 * Waits until the text of an element contains the expected text
	 * @param element WebElement to perform wait on
	 * @param expectedText Expected text to be contained in the element
	 * @param maxWaitSeconds max wait time in seconds for condition to be met
	 * @return WaitKeyword
	 */
	WaitKeyword untilElementTextContains(WebElement element, String expectedText, long maxWaitSeconds);
	
	/**
	 * Waits until an element's value attribute equals expected text
	 * @param locator By locator for the WebElement
	 * @param expectedValue Expected text of value attribute
	 * @param maxWaitSeconds max wait time in seconds for condition to be met
	 * @return WaitKeyword
	 */
	WaitKeyword untilElementValueEquals(By locator, String expectedValue, long maxWaitSeconds);
	
	/**
	 * Waits until an element's value attribute equals expected text
	 * @param element WebElement to perform wait on
	 * @param expectedValue Expected text of value attribute
	 * @param maxWaitSeconds max wait time in seconds for condition to be met
	 * @return WaitKeyword
	 */
	WaitKeyword untilElementValueEquals(WebElement element, String expectedValue, long maxWaitSeconds);
	
	/**
	 * Waits until an element's value attribute contains expected text
	 * @param locator By locator for the WebElement
	 * @param expectedValue Expected text to be contained in element's value attribute
	 * @param maxWaitSeconds max wait time in seconds for condition to be met
	 * @return WaitKeyword
	 */
	WaitKeyword untilElementValueContains(By locator, String expectedValue, long maxWaitSeconds);
	
	/**
	 * Waits until an element's value attribute contains expected text
	 * @param element WebElement to perform wait on
	 * @param expectedValue Expected text to be contained in element's value attribute
	 * @param maxWaitSeconds max wait time in seconds for condition to be met
	 * @return WaitKeyword
	 */
	WaitKeyword untilElementValueContains(WebElement element, String expectedValue, long maxWaitSeconds);
	
	/**
	 * Waits until an element's given attribute matches expected value
	 * @param locator By locator for the WebElement
	 * @param attrName Attribute name to match against
	 * @param expectedValue Expected value of given attribute
	 * @param maxWaitSeconds max wait time in seconds for condition to be met
	 * @return WaitKeyword
	 */
	WaitKeyword untilElementAttributeEquals(By locator, String attrName,  String expectedValue, long maxWaitSeconds);
	
	/**
	 * Waits until an element's given attribute matches expected value
	 * @param element WebElement to perform wait on
	 * @param attrName Attribute name to match against
	 * @param expectedValue Expected value of given attribute
	 * @param maxWaitSeconds max wait time in seconds for condition to be met
	 * @return WaitKeyword
	 */
	WaitKeyword untilElementAttributeEquals(WebElement element, String attrName,  String expectedValue, long maxWaitSeconds);
	
	/**
	 * Waits until an element's given attribute contains expected value
	 * @param locator By locator for the WebElement
	 * @param attrName Attribute name to match against
	 * @param expectedValue Expected value to be contained in given attribute
	 * @param maxWaitSeconds max wait time in seconds for condition to be met
	 * @return WaitKeyword
	 */
	WaitKeyword untilElementAttributeContains(By locator, String attrName,  String expectedValue, long maxWaitSeconds);
	
	/**
	 * Waits until an element's given attribute contains expected value
	 * @param element WebElement to perform wait on
	 * @param attrName Attribute name to match against
	 * @param expectedValue Expected value to be contained in given attribute
	 * @param maxWaitSeconds max wait time in seconds for condition to be met
	 * @return WaitKeyword
	 */
	WaitKeyword untilElementAttributeContains(WebElement element, String attrName,  String expectedValue, long maxWaitSeconds);
	
	/**
	 * Waits until an element's selected state is true
	 * @param locator By locator for the WebElement
	 * @param maxWaitSeconds max wait time in seconds for condition to be met
	 * @return WaitKeyword
	 */
	WaitKeyword untilElementSelected(By locator, long maxWaitSeconds);
	
	/**
	 * Waits until an element's selected state is true
	 * @param element WebElement to perform wait on
	 * @param maxWaitSeconds max wait time in seconds for condition to be met
	 * @return WaitKeyword
	 */
	WaitKeyword untilElementSelected(WebElement element, long maxWaitSeconds);
	
	/**
	 * Waits until an element's selected state is false
	 * @param locator By locator for the WebElement
	 * @param maxWaitSeconds max wait time in seconds for condition to be met
	 * @return WaitKeyword
	 */
	WaitKeyword untilElementNotSelected(By locator, long maxWaitSeconds);
	
	/**
	 * Waits until an element's selected state is false
	 * @param element WebElement to perform wait on
	 * @param maxWaitSeconds max wait time in seconds for condition to be met
	 * @return WaitKeyword
	 */
	WaitKeyword untilElementNotSelected(WebElement element, long maxWaitSeconds);
	
	/**
	 * Waits until the current page title matches expected
	 * @param title String to match title against
	 * @param maxWaitSeconds max wait time in seconds for condition to be met
	 * @return WaitKeyword
	 */
	WaitKeyword untilPageTitleEquals(String title, long maxWaitSeconds);
	
	/**
	 * Waits until the current page title contains expected text
	 * @param title String to match title against
	 * @param maxWaitSeconds max wait time in seconds for condition to be met
	 * @return WaitKeyword
	 */
	WaitKeyword untilPageTitleContains(String title, long maxWaitSeconds);
	
	/**
	 * Waits until the current page URL matches expected
	 * @param Url String to match URL against
	 * @param maxWaitSeconds max wait time in seconds for condition to be met
	 * @return WaitKeyword
	 */
	WaitKeyword untilCurrentUrlEquals(String Url, long maxWaitSeconds);
	
	/**
	 * Waits until the current page URL contains expected text
	 * @param Url String to match URL against
	 * @param maxWaitSeconds max wait time in seconds for condition to be met
	 * @return WaitKeyword
	 */
	WaitKeyword untilCurrentUrlContains(String Url, long maxWaitSeconds);
	
	/**
	 * Waits until an alert dialog is present
	 * @param maxWaitSeconds max wait time in seconds for condition to be met
	 * @return WaitKeyword
	 */
	WaitKeyword untilAlertIsPresent(long maxWaitSeconds);
	
	/**
	 * Waits until an alert dialog is NOT present
	 * @param maxWaitSeconds max wait time in seconds for condition to be met
	 * @return WaitKeyword
	 */
	WaitKeyword untilAlertIsNotPresent(long maxWaitSeconds);
	
	/**
	 * Waits until given By locator returns the expected number of elements
	 * @param locator By locator for the WebElement
	 * @param expectedNumber Integer number of expected elements from given By locator
	 * @param maxWaitSeconds max wait time in seconds for condition to be met
	 * @return WaitKeyword
	 */
	WaitKeyword untilLocatorReturnsNumberOfElements(By locator, int expectedNumber, long maxWaitSeconds);
	
	/**
	 * Waits until given By locator returns greater than the given number of WebElements
	 * @param locator By locator for the WebElement
	 * @param lessNumber Integer number of WebElements to be greater than
	 * @param maxWaitSeconds max wait time in seconds for condition to be met
	 * @return WaitKeyword
	 */
	WaitKeyword untilLocatorReturnsLessThan(By locator, int lessNumber, long maxWaitSeconds);
	
	/**
	 * Waits until given By locator returns less than the given number of WebElements
	 * @param locator By locator for the WebElement
	 * @param greaterNumber Integer number of WebElements to be less than
	 * @param maxWaitSeconds max wait time in seconds for condition to be met
	 * @return WaitKeyword
	 */
	WaitKeyword untilLocatorReturnsGreaterThan(By locator, int greaterNumber, long maxWaitSeconds);
	
	/**
	 * Wiats until all sub elements from an element are found that match the given child By locator
	 * @param locator By locator for the parent element
	 * @param childLocator By locator for child elements of the parent element
	 * @param number Integer number of expected child elements to be found
	 * @param maxWaitSeconds max wait time in seconds for condition to be met
	 * @return WaitKeyword
	 */
	WaitKeyword untilPresenceOfNestedElements(By locator, By childLocator, int number, long maxWaitSeconds);
	
	/**
	 * Wiats until all sub elements from an element are found that match the given child By locator
	 * @param element Parent element to perform findelements on with given child By locator
	 * @param childLocator By locator for child elements of the parent element
	 * @param number Integer number of expected child elements to be found
	 * @param maxWaitSeconds max wait time in seconds for condition to be met
	 * @return WaitKeyword
	 */
	WaitKeyword untilPresenceOfNestedElements(WebElement element, By childLocator, int number, long maxWaitSeconds);
	
	/**
	 * Waits until an expected sub element of a parent element is present
	 * @param locator By locator for Parent WebElement to search for child elements from
	 * @param childLocator By locator to search from the Parent Element
	 * @param maxWaitSeconds max wait time in seconds for condition to be met
	 * @return WaitKeyword
	 */
	WaitKeyword untilPresenceOfNestedElement(By locator, By childLocator, long maxWaitSeconds);
	
	/**
	 * Waits until an expected sub element of a parent element is present
	 * @param element Parent WebElement to search for child elements from
	 * @param childLocator By locator to search from the Parent Element
	 * @param maxWaitSeconds max wait time in seconds for condition to be met
	 * @return WaitKeyword
	 */
	WaitKeyword untilPresenceOfNestedElement(WebElement element, By childLocator, long maxWaitSeconds);
	
	/**
	 * Waits until a DropDown's selected element text matches expectd text
	 * @param locator By locator for the input WebElement
	 * @param name Expected text of the selected element
	 * @param maxWaitSeconds max wait time in seconds for condition to be met
	 * @return WaitKeyword
	 */
	WaitKeyword untilDropDownSelectedTextIs(By locator, String name, long maxWaitSeconds);
	
	/**
	 * Waits until a DropDown's selected element text matches expected text
	 * @param element WebElement of DropDown input
	 * @param name Expected text of the selected element
	 * @param maxWaitSeconds max wait time in seconds for condition to be met
	 * @return WaitKeyword
	 */
	WaitKeyword untilDropDownSelectedTextIs(WebElement element, String name, long maxWaitSeconds);
	
	/**
	 * Waits until a DropDown's selected element value matched expected
	 * @param locator By locator for the input WebElement
	 * @param value Expected value of the selected element
	 * @param maxWaitSeconds max wait time in seconds for condition to be met
	 * @return WaitKeyword
	 */
	WaitKeyword untilDropDownSelectedValueIs(By locator, String value, long maxWaitSeconds);
	
	/**
	 * Waits until a DropDown's selected element value matched expected
	 * @param element WebElement of DropDown input
	 * @param value Expected value of the selected element
	 * @param maxWaitSeconds max wait time in seconds for condition to be met
	 * @return WaitKeyword
	 */
	WaitKeyword untilDropDownSelectedValueIs(WebElement element, String value, long maxWaitSeconds);
	
	/**
	 * Waits until a DropDown contains expected number of options
	 * @param locator By locator for the input WebElement
	 * @param count Expected number of DropDown options
	 * @param maxWaitSeconds max wait time in seconds for condition to be met
	 * @return WaitKeyword
	 */
	WaitKeyword untilDropDownItemCountIs(By locator, int count, long maxWaitSeconds);
	
	/**
	 * Waits until a DropDown contains expected number of options
	 * @param element WebElement of DropDown input
	 * @param count Expected number of DropDown options
	 * @param maxWaitSeconds max wait time in seconds for condition to be met
	 * @return WaitKeyword
	 */
	WaitKeyword untilDropDownItemCountIs(WebElement element, int count, long maxWaitSeconds);
	
	/**
	 * Waits until a DropDown contains an option with provided text
	 * @param locator By locator for the input WebElement
	 * @param text Expected option text to search for
	 * @param maxWaitSeconds max wait time in seconds for condition to be met
	 * @return WaitKeywords
	 */
	WaitKeyword untilDropDownCountainsOption(By locator, String text, long maxWaitSeconds);
	
	/**
	 * Waits until a DropDown contains an option with provided text
	 * @param element WebElement of DropDown input
	 * @param text Expected option text to search for
	 * @param maxWaitSeconds max wait time in seconds for condition to be met
	 * @return WaitKeywords
	 */
	WaitKeyword untilDropDownCountainsOption(WebElement element, String text, long maxWaitSeconds);
	
	/**
	 * Waits until a DropDown contains all options with provided texts
	 * @param locator By locator for the input WebElement
	 * @param texts Expected option texts to search for
	 * @param maxWaitSeconds max wait time in seconds for condition to be met
	 * @return WaitKeywords
	 */
	WaitKeyword untilDropDownCountainsOptions(By locator, List<String> texts, long maxWaitSeconds);
	
	/**
	 * Waits until a DropDown contains all options with provided texts
	 * @param element WebElement of DropDown input
	 * @param texts Expected option texts to search for
	 * @param maxWaitSeconds max wait time in seconds for condition to be met
	 * @return WaitKeywords
	 */
	WaitKeyword untilDropDownCountainsOptions(WebElement element, List<String> texts, long maxWaitSeconds);
	
	/**
	 * Waits until A DropDown contains options with provided texts and in the same order as the provided list of texts
	 * @param locator locator By locator for the input WebElement
	 * @param texts texts Expected option texts to search for
	 * @param maxWaitSeconds max wait time in seconds for condition to be met
	 * @return WaitKeywords
	 */
	WaitKeyword untilDropDownOptionsInOrderOf(By locator, List<String> texts, long maxWaitSeconds);
	
	/**
	 * Waits until A DropDown contains options with provided texts and in the same order as the provided list of texts
	 * @param element WebElement of DropDown input
	 * @param texts texts Expected option texts to search for
	 * @param maxWaitSeconds max wait time in seconds for condition to be met
	 * @return WaitKeywords
	 */
	WaitKeyword untilDropDownOptionsInOrderOf(WebElement element, List<String> texts, long maxWaitSeconds);
	
	/**
	 * Waits until an Element goes Stale meaning it is no longer attached to the DOM and throws a StaleElementReferenceException
	 * @param locator By locator for the WebElement
	 * @param maxWaitSeconds max wait time in seconds for condition to be met
	 * @return WaitKeywords
	 */
	WaitKeyword untilStalenessOf(By locator, long maxWaitSeconds);
	
	/**
	 * Waits until an Element goes Stale meaning it is no longer attached to the DOM and throws a StaleElementReferenceException
	 * @param element WebElement to perform wait on
	 * @param maxWaitSeconds max wait time in seconds for condition to be met
	 * @return WaitKeywords
	 */
	WaitKeyword untilStalenessOf(WebElement element, long maxWaitSeconds);
	
	/**
	 * Waits until an Element's isEnabled() property is true
	 * @param locator By locator for the WebElement
	 * @param maxWaitSeconds max wait time in seconds for condition to be met
	 * @return WaitKeywords
	 */
	WaitKeyword untilElementEnabled(By locator, long maxWaitSeconds);
	
	/**
	 * Waits until an Element's isEnabled() property is true
	 * @param element WebElement to perform wait on
	 * @param maxWaitSeconds max wait time in seconds for condition to be met
	 * @return WaitKeywords
	 */
	WaitKeyword untilElementEnabled(WebElement element, long maxWaitSeconds);
	
	/**
	 * Waits until an Element's isEnabled() property is false
	 * @param locator By locator for the WebElement
	 * @param maxWaitSeconds max wait time in seconds for condition to be met
	 * @return WaitKeywords
	 */
	WaitKeyword untilElementNotEnabled(By locator, long maxWaitSeconds);
	
	/**
	 * Waits until an Element's isEnabled() property is false
	 * @param element WebElement to perform wait on
	 * @param maxWaitSeconds max wait time in seconds for condition to be met
	 * @return WaitKeywords
	 */
	WaitKeyword untilElementNotEnabled(WebElement element, long maxWaitSeconds);
}
