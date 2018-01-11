package interfaces;
import java.util.List;
import java.util.concurrent.Callable;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import framework.AssertKeyword;

/**
 * KeywordProvider provided Assert Keywords
 * Assert Keywords are any keywords intended to perform a validation that can pass or fail a Test Case. Generally these assert against WebElement or Page properties
 * All Assert Keywords utilize a timeout which allows the assert conditions to be true within the given amount of time or result in a failed assert if not met within the given time
 * The timeout can explicitly set or use the default timeout provided by the getDefaultWait() method which is 15 seconds by default but can changed using setDefaultWait() method
 * @author Mathew Carrigan
 *
 */
public interface IAssert extends Callable<Void> {
	
	/**
	 * Asserts that a WebElement's text matches the expected text
	 * text is the String text between an element's opening and closing tags like '<p> This is an element's text</p>'
	 * @param locator By locator for WebElement to Assert Against
	 * @param expected String Expected Element text
	 * @param timeoutSeconds Max time in seconds to wait for Assert conditions to be true before failing the assert
	 * @return AssertKeyword
	 */
	AssertKeyword assertText(By locator, String expected, long timeoutSeconds);
	
	/**
	 * Asserts that a WebElement's text matches the expected text
	 * text is the String text between an element's opening and closing tags like '<p> This is an element's text</p>'
	 * @param element WebElement to Assert against
	 * @param expected String Expected Element text
	 * @param timeoutSeconds Max time in seconds to wait for Assert conditions to be true before failing the assert
	 * @return AssertKeyword
	 */
	AssertKeyword assertText(WebElement element, String expected, long timeoutSeconds);
	
	/**
	 * Asserts that a WebElements text contains the expected text
	 * text is the String text between an element's opening and closing tags like '<p> This is an element's text</p>'
	 * @param locator By locator for WebElement to Assert Against
	 * @param expected String Expected containing element text
	 * @param timeoutSeconds Max time in seconds to wait for Assert conditions to be true before failing the assert
	 * @return AssertKeyword
	 */
	AssertKeyword assertTextContains(By locator, String expected, long timeoutSeconds);
	
	/**
	 * Asserts that a WebElements text contains the expected text
	 * text is the String text between an element's opening and closing tags like '<p> This is an element's text</p>'
	 * @param element WebElement to Assert against
	 * @param expected String Expected containing element text
	 * @param timeoutSeconds Max time in seconds to wait for Assert conditions to be true before failing the assert
	 * @return AssertKeyword
	 */
	AssertKeyword assertTextContains(WebElement element, String expected, long timeoutSeconds);
	
	/**
	 * Asserts that a WebElement's value attribute matches the expected text
	 * text is the String text between an element's opening and closing tags like '<p> This is an element's text</p>'
	 * @param locator By locator for WebElement to Assert Against
	 * @param expected String Expected element value attribute
	 * @param timeoutSeconds Max time in seconds to wait for Assert conditions to be true before failing the assert
	 * @return AssertKeyword
	 */
	AssertKeyword assertValue(By locator, String expected, long timeoutSeconds);
	
	/**
	 * Asserts that a WebElement's value attribute matches the expected text
	 * The value attribute is generally used for input elements like textboxes and passwords inputs
	 * @param element WebElement to Assert against
	 * @param expected String Expected element value attribute
	 * @param timeoutSeconds Max time in seconds to wait for Assert conditions to be true before failing the assert
	 * @return AssertKeyword
	 */
	AssertKeyword assertValue(WebElement element, String expected, long timeoutSeconds);
	
	/**
	 * Asserts that a WebElement's value attribute contains the expected text
	 * The value attribute is generally used for input elements like textboxes and passwords inputs
	 * @param locator By locator for WebElement to Assert Against
	 * @param expected String Expected element value attribute
	 * @param timeoutSeconds Max time in seconds to wait for Assert conditions to be true before failing the assert
	 * @return AssertKeyword
	 */
	AssertKeyword assertValueContains(By locator, String expected, long timeoutSeconds);
	
	/**
	 * Asserts that a WebElement's value attribute contains the expected text
	 * The value attribute is generally used for input elements like textboxes and passwords inputs
	 * @param element WebElement to Assert against
	 * @param expected String Expected element value attribute
	 * @param timeoutSeconds Max time in seconds to wait for Assert conditions to be true before failing the assert
	 * @return AssertKeyword
	 */
	AssertKeyword assertValueContains(WebElement element, String expected, long timeoutSeconds);
	
	/**
	 * Asserts that a WebElement's value attribute contains the expected text
	 * The value attribute is generally used for input elements like textboxes and passwords inputs
	 * @param locator By locator for WebElement to Assert Against
	 * @param attrName Attribute name to assert against
	 * @param expected Expected attribute text
	 * @param timeoutSeconds Max time in seconds to wait for Assert conditions to be true before failing the assert
	 * @return AssertKeyword
	 */
	AssertKeyword assertElementAttributeValue(By locator, String attrName, String expected, long timeoutSeconds);
	
	/**
	 * Asserts than a WebElement's given attribute matches the expected value
	 * @param element WebElement to Assert against
	 * @param attrName Attribute name to assert against
	 * @param expected Expected attribute text
	 * @param timeoutSeconds Max time in seconds to wait for Assert conditions to be true before failing the assert
	 * @return AssertKeyword
	 */
	AssertKeyword assertElementAttributeValue(WebElement element, String attrName, String expected, long timeoutSeconds);
	
	/**
	 * Asserts than a WebElement's given attribute contains the expected value
	 * @param locator By locator for WebElement to Assert Against
	 * @param attrName Attribute name to assert against
	 * @param expected Expected attribute text
	 * @param timeoutSeconds Max time in seconds to wait for Assert conditions to be true before failing the assert
	 * @return AssertKeyword
	 */
	AssertKeyword assertElementAttributeValueContains(By locator, String attrName, String expected, long timeoutSeconds);
	
	/**
	 * Asserts than a WebElement's given attribute contains the expected value
	 * @param element WebElement to Assert against
	 * @param attrName Attribute name to assert against
	 * @param expected Expected attribute text
	 * @param timeoutSeconds Max time in seconds to wait for Assert conditions to be true before failing the assert
	 * @return AssertKeyword
	 */
	AssertKeyword assertElementAttributeValueContains(WebElement element, String attrName, String expected, long timeoutSeconds);
	
	/**
	 * Asserts that a WebElement exists on the DOM
	 * @param locator By locator for WebElement to Assert Against
	 * @param timeoutSeconds Max time in seconds to wait for Assert conditions to be true before failing the assert
	 * @return AssertKeyword
	 */
	AssertKeyword assertElementExists(By locator, long timeoutSeconds);
	
	/**
	 * Asserts that a WebElement's displayed property is true
	 * @param locator By locator for WebElement to Assert Against
	 * @param timeoutSeconds Max time in seconds to wait for Assert conditions to be true before failing the assert
	 * @return AssertKeyword
	 */
	AssertKeyword assertElementVisible(By locator, long timeoutSeconds);
	
	/**
	 * Asserts that a WebElement's displayed property is true
	 * @param element WebElement to Assert against
	 * @param timeoutSeconds Max time in seconds to wait for Assert conditions to be true before failing the assert
	 * @return AssertKeyword
	 */
	AssertKeyword assertElementVisible(WebElement element, long timeoutSeconds);
	
	/**
	 * Asserts that a WebElement's displayed property is false
	 * @param locator By locator for WebElement to Assert Against
	 * @param timeoutSeconds Max time in seconds to wait for Assert conditions to be true before failing the assert
	 * @return AssertKeyword
	 */
	AssertKeyword assertElementNotVisible(By locator, long timeoutSeconds);
	
	/**
	 * Asserts that a WebElement's displayed property is false
	 * @param element WebElement to Assert against
	 * @param timeoutSeconds Max time in seconds to wait for Assert conditions to be true before failing the assert
	 * @return AssertKeyword
	 */
	AssertKeyword assertElementNotVisible(WebElement element, long timeoutSeconds);
	
	/**
	 * Asserts that a WebElement's enabled property is true
	 * @param locator By locator for WebElement to Assert Against
	 * @param timeoutSeconds Max time in seconds to wait for Assert conditions to be true before failing the assert
	 * @return AssertKeyword
	 */
	AssertKeyword assertElementEnabled(By locator, long timeoutSeconds);
	
	/**
	 * Asserts that a WebElement's enabled property is true
	 * @param element WebElement to Assert against
	 * @param timeoutSeconds Max time in seconds to wait for Assert conditions to be true before failing the assert
	 * @return AssertKeyword
	 */
	AssertKeyword assertElementEnabled(WebElement element, long timeoutSeconds);
	
	/**
	 * Asserts that a WebElement's enabled property is false
	 * @param locator By locator for WebElement to Assert Against
	 * @param timeoutSeconds Max time in seconds to wait for Assert conditions to be true before failing the assert
	 * @return AssertKeyword
	 */
	AssertKeyword assertElementNotEnabled(By locator, long timeoutSeconds);
	
	/**
	 * Asserts that a WebElement's enabled property is false
	 * @param element WebElement to Assert against
	 * @param timeoutSeconds Max time in seconds to wait for Assert conditions to be true before failing the assert
	 * @return AssertKeyword
	 */
	AssertKeyword assertElementNotEnabled(WebElement element, long timeoutSeconds);
	
	/**
	 * Asserts that a WebElement's selected property is true
	 * @param locator By locator for WebElement to Assert Against
	 * @param timeoutSeconds Max time in seconds to wait for Assert conditions to be true before failing the assert
	 * @return AssertKeyword
	 */
	AssertKeyword assertElementSelected(By locator, long timeoutSeconds);
	
	/**
	 * Asserts that a WebElement's selected property is true
	 * @param element WebElement to Assert against
	 * @param timeoutSeconds Max time in seconds to wait for Assert conditions to be true before failing the assert
	 * @return AssertKeyword
	 */
	AssertKeyword assertElementSelected(WebElement element, long timeoutSeconds);
	
	/**
	 * Asserts that a WebElement's selected property is false
	 * @param locator By locator for WebElement to Assert Against
	 * @param timeoutSeconds Max time in seconds to wait for Assert conditions to be true before failing the assert
	 * @return AssertKeyword
	 */
	AssertKeyword assertElementNotSelected(By locator, long timeoutSeconds);
	
	/**
	 * Asserts that a WebElement's selected property is false
	 * @param element WebElement to Assert against
	 * @param timeoutSeconds Max time in seconds to wait for Assert conditions to be true before failing the assert
	 * @return AssertKeyword
	 */
	AssertKeyword assertElementNotSelected(WebElement element, long timeoutSeconds);
	
	/**
	 * Asserts that the current page title matches the expected text
	 * @param title Expected title
	 * @param timeoutSeconds Max time in seconds to wait for Assert conditions to be true before failing the assert
	 * @return AssertKeyword
	 */
	AssertKeyword assertPageTitleEquals(String title, long timeoutSeconds);
	
	/**
	 * Asserts that the current page title contains the expected text
	 * @param title expected containing text
	 * @param timeoutSeconds Max time in seconds to wait for Assert conditions to be true before failing the assert
	 * @return AssertKeyword
	 */
	AssertKeyword assertPageTitleContains(String title, long timeoutSeconds);
	
	/**
	 * Asserts that the URL matches the expected text
	 * @param Url Expected URL text
	 * @param timeoutSeconds Max time in seconds to wait for Assert conditions to be true before failing the assert
	 * @return AssertKeyword
	 */
	AssertKeyword assertCurrentUrlEquals(String Url, long timeoutSeconds);
	
	/**
	 * Asserts that the URL contains the expected text
	 * @param Url Expected containing URL text
	 * @param timeoutSeconds Max time in seconds to wait for Assert conditions to be true before failing the assert
	 * @return AssertKeyword
	 */
	AssertKeyword assertCurrentUrlContains(String Url, long timeoutSeconds);
	
	/**
	 * Asserts that an Aleert is present
	 * @param timeoutSeconds Max time in seconds to wait for Assert conditions to be true before failing the assert
	 * @return AssertKeyword
	 */
	AssertKeyword assertAlertIsPresent(long timeoutSeconds);
	
	/**
	 * Asserts that the given By locator returns the expected number of WebElements
	 * @param locator By locator for WebElement to Assert Against
	 * @param expectedNumber Integer expected number of elements to be found
	 * @param timeoutSeconds Max time in seconds to wait for Assert conditions to be true before failing the assert
	 * @return AssertKeyword
	 */
	AssertKeyword assertLocatorReturnsNumberOfElements(By locator, int expectedNumber, long timeoutSeconds);
	
	/**
	 * Asserts that the given By locator returns less than the given number of WebElements
	 * @param locator By locator for WebElement to Assert Against
	 * @param lessNumber Integer lower bound number
	 * @param timeoutSeconds Max time in seconds to wait for Assert conditions to be true before failing the assert
	 * @return AssertKeyword
	 */
	AssertKeyword assertLocatorReturnsLessThan(By locator, int lessNumber, long timeoutSeconds);
	
	/**
	 * Asserts that the given By locator returns greater than the given number of WebElements
	 * @param locator By locator for WebElement to Assert Against
	 * @param greaterNumber Integer upper bound number
	 * @param timeoutSeconds Max time in seconds to wait for Assert conditions to be true before failing the assert
	 * @return AssertKeyword
	 */
	AssertKeyword assertLocatorReturnsGreaterThan(By locator, int greaterNumber, long timeoutSeconds);
	
	/**
	 * Asserts that a DropDown's selected option text matches expected text
	 * @param locator By locator for WebElement to Assert Against
	 * @param text Expected text of currently selected option
	 * @param timeoutSeconds Max time in seconds to wait for Assert conditions to be true before failing the assert
	 * @return AssertKeyword
	 */
	AssertKeyword assertDropDownSelectedTextIs(By locator, String text, long timeoutSeconds);
	
	/**
	 * Asserts that a DropDown's selected option text matches expected text
	 * @param element WebElement to Assert against
	 * @param text Expected text of currently selected option
	 * @param timeoutSeconds Max time in seconds to wait for Assert conditions to be true before failing the assert
	 * @return AssertKeyword
	 */
	AssertKeyword assertDropDownSelectedTextIs(WebElement element, String text, long timeoutSeconds);
	
	/**
	 * Asserts that a DropDown's selected option value matches expected text
	 * @param locator By locator for WebElement to Assert Against
	 * @param value Expected value text
	 * @param timeoutSeconds Max time in seconds to wait for Assert conditions to be true before failing the assert
	 * @return AssertKeyword
	 */
	AssertKeyword assertDropDownSelectedValueIs(By locator, String value, long timeoutSeconds);
	
	/**
	 * Asserts that a DropDown's selected option value matches expected text
	 * @param element WebElement to Assert against
	 * @param value Expected value text
	 * @param timeoutSeconds Max time in seconds to wait for Assert conditions to be true before failing the assert
	 * @return AssertKeyword
	 */
	AssertKeyword assertDropDownSelectedValueIs(WebElement element, String value, long timeoutSeconds);
	
	/**
	 * Asserts that a DropDown contains expected number of options
	 * @param locator By locator for WebElement to Assert Against
	 * @param count Expected number of options in DropDown
	 * @param timeoutSeconds Max time in seconds to wait for Assert conditions to be true before failing the assert
	 * @return AssertKeyword
	 */
	AssertKeyword assertDropDownItemCountIs(By locator, int count, long timeoutSeconds);
	
	/**
	 * Asserts that a DropDown contains expected number of options
	 * @param element WebElement to Assert against
	 * @param count Expected number of options in DropDown
	 * @param timeoutSeconds Max time in seconds to wait for Assert conditions to be true before failing the assert
	 * @return AssertKeyword
	 */
	AssertKeyword assertDropDownItemCountIs(WebElement element, int count, long timeoutSeconds);
	
	/**
	 * Asserts that a DropDown contains an option with the expected option text
	 * @param locator By locator for WebElement to Assert Against
	 * @param text option text to find
	 * @param timeoutSeconds Max time in seconds to wait for Assert conditions to be true before failing the assert
	 * @return AssertKeyword
	 */
	AssertKeyword assertDropDownCountainsOption(By locator, String text, long timeoutSeconds);
	
	/**
	 * Asserts that a DropDown contains an option with the expected option text
	 * @param element WebElement to Assert against
	 * @param text option text to find
	 * @param timeoutSeconds Max time in seconds to wait for Assert conditions to be true before failing the assert
	 * @return AssertKeyword
	 */
	AssertKeyword assertDropDownCountainsOption(WebElement element, String text, long timeoutSeconds);
	
	/**
	 * Asserts that a DropDown contains all options with texts in provided List of Strings
	 * @param locator By locator for WebElement to Assert Against
	 * @param texts Option texts to find
	 * @param timeoutSeconds Max time in seconds to wait for Assert conditions to be true before failing the assert
	 * @return AssertKeyword
	 */
	AssertKeyword assertDropDownCountainsOptions(By locator, List<String> texts, long timeoutSeconds);
	
	/**
	 * Asserts that a DropDown contains all options with texts in provided List of Strings
	 * @param element WebElement to Assert against
	 * @param texts Option texts to find
	 * @param timeoutSeconds Max time in seconds to wait for Assert conditions to be true before failing the assert
	 * @return AssertKeyword
	 */
	AssertKeyword assertDropDownCountainsOptions(WebElement element, List<String> texts, long timeoutSeconds);
	
	/**
	 * Asserts that a DropDown contains all options with texts in provided List of Strings in the same order as the provided List of Strings
	 * @param locator By locator for WebElement to Assert Against
	 * @param texts Option texts to find in expected order
	 * @param timeoutSeconds Max time in seconds to wait for Assert conditions to be true before failing the assert
	 * @return AssertKeyword
	 */
	AssertKeyword assertDropDownOptionsInOrderOf(By locator, List<String> texts, long timeoutSeconds);
	
	/**
	 * Asserts that a DropDown contains all options with texts in provided List of Strings in the same order as the provided List of Strings
	 * @param element WebElement to Assert against
	 * @param texts Option texts to find in expected order
	 * @param timeoutSeconds Max time in seconds to wait for Assert conditions to be true before failing the assert
	 * @return AssertKeyword
	 */
	AssertKeyword assertDropDownOptionsInOrderOf(WebElement element, List<String> texts, long timeoutSeconds);
	
	/**
	 * Asserts that a WebElement's text matches the expected text
	 * text is the String text between an element's opening and closing tags like '<p> This is an element's text</p>'
	 * @param locator By locator for WebElement to Assert Against
	 * @param expected String Expected Element text
	 * @return AssertKeyword
	 */
	AssertKeyword assertText(By locator, String expected);
	
	/**
	 * Asserts that a WebElement's text matches the expected text
	 * text is the String text between an element's opening and closing tags like '<p> This is an element's text</p>'
	 * @param element WebElement to Assert against
	 * @param expected String Expected Element text
	 * @return AssertKeyword
	 */
	AssertKeyword assertText(WebElement element, String expected);
	
	/**
	 * Asserts that a WebElements text contains the expected text
	 * text is the String text between an element's opening and closing tags like '<p> This is an element's text</p>'
	 * @param locator By locator for WebElement to Assert Against
	 * @param expected String Expected containing Element text
	 * @return AssertKeyword
	 */
	AssertKeyword assertTextContains(By locator, String expected);
	
	/**
	 * Asserts that a WebElements text contains the expected text
	 * text is the String text between an element's opening and closing tags like '<p> This is an element's text</p>'
	 * @param element WebElement to Assert against
	 * @param expected String Expected containing Element text
	 * @return AssertKeyword
	 */
	AssertKeyword assertTextContains(WebElement element, String expected);
	
	/**
	 * Asserts that a WebElement's value attribute contains the expected text
	 * The value attribute is generally used for input elements like textboxes and passwords inputs
	 * @param locator By locator for WebElement to Assert Against
	 * @param expected String Expected element value attribute
	 * @return AssertKeyword
	 */
	AssertKeyword assertValue(By locator, String expected);
	
	/**
	 * Asserts that a WebElement's value attribute contains the expected text
	 * The value attribute is generally used for input elements like textboxes and passwords inputs
	 * @param element WebElement to Assert against
	 * @param expected String Expected element value attribute
	 * @return AssertKeyword
	 */
	AssertKeyword assertValue(WebElement element, String expected);
	
	/**
	 * Asserts that a WebElement's value attribute contains the expected text
	 * The value attribute is generally used for input elements like textboxes and passwords inputs
	 * @param locator By locator for WebElement to Assert Against
	 * @param expected String Expected containing element value attribute
	 * @return AssertKeyword
	 */
	AssertKeyword assertValueContains(By locator, String expected);
	
	/**
	 * Asserts that a WebElement's value attribute contains the expected text
	 * The value attribute is generally used for input elements like textboxes and passwords inputs
	 * @param element WebElement to Assert against
	 * @param expected String Expected containing element value attribute
	 * @return AssertKeyword
	 */
	AssertKeyword assertValueContains(WebElement element, String expected);
	
	/**
	 * Asserts than a WebElement's given attribute matches the expected value
	 * @param locator By locator for WebElement to Assert Against
	 * @param attrName Attribute name to assert against
	 * @param expected Expected attribute text
	 * @return AssertKeyword
	 */
	AssertKeyword assertElementAttributeValue(By locator, String attrName, String expected);
	
	/**
	 * Asserts than a WebElement's given attribute matches the expected value
	 * @param element WebElement to Assert against
	 * @param attrName Attribute name to assert against
	 * @param expected Expected attribute text
	 * @return AssertKeyword
	 */
	AssertKeyword assertElementAttributeValue(WebElement element, String attrName, String expected);
	
	/**
	 * Asserts than a WebElement's given attribute contains the expected value
	 * @param locator By locator for WebElement to Assert Against
	 * @param attrName Attribute name to assert against
	 * @param expected Expected attribute text
	 * @return AssertKeyword
	 */
	AssertKeyword assertElementAttributeValueContains(By locator, String attrName, String expected);
	
	/**
	 * Asserts than a WebElement's given attribute contains the expected value
	 * @param element WebElement to Assert against
	 * @param attrName Attribute name to assert against
	 * @param expected Expected attribute text
	 * @return AssertKeyword
	 */
	AssertKeyword assertElementAttributeValueContains(WebElement element, String attrName, String expected);
	
	/**
	 * Asserts that a WebElement's displayed property is true
	 * @param locator By locator for WebElement to Assert Against
	 * @return AssertKeyword
	 */
	AssertKeyword assertElementExists(By locator);
	
	/**
	 * Asserts that a WebElement's displayed property is true
	 * @param locator By locator for WebElement to Assert Against
	 * @return AssertKeyword
	 */
	AssertKeyword assertElementVisible(By locator);
	
	/**
	 * Asserts that a WebElement's displayed property is true
	 * @param element WebElement to Assert against
	 * @return AssertKeyword
	 */
	AssertKeyword assertElementVisible(WebElement element);
	
	/**
	 * Asserts that a WebElement's displayed property is false
	 * @param locator By locator for WebElement to Assert Against
	 * @return AssertKeyword
	 */
	AssertKeyword assertElementNotVisible(By locator);
	
	/**
	 * Asserts that a WebElement's displayed property is false
	 * @param element WebElement to Assert against
	 * @return AssertKeyword
	 */
	AssertKeyword assertElementNotVisible(WebElement element);
	
	/**
	 * Asserts that a WebElement's enabled property is true
	 * @param locator By locator for WebElement to Assert Against
	 * @return AssertKeyword
	 */
	AssertKeyword assertElementEnabled(By locator);
	
	/**
	 * Asserts that a WebElement's enabled property is true
	 * @param element WebElement to Assert against
	 * @return AssertKeyword
	 */
	AssertKeyword assertElementEnabled(WebElement element);
	
	/**
	 * Asserts that a WebElement's enabled property is false
	 * @param locator By locator for WebElement to Assert Against
	 * @return AssertKeyword
	 */
	AssertKeyword assertElementNotEnabled(By locator);
	
	/**
	 * Asserts that a WebElement's enabled property is false
	 * @param element WebElement to Assert against
	 * @return AssertKeyword
	 */
	AssertKeyword assertElementNotEnabled(WebElement element);
	
	/**
	 * Asserts that a WebElement's selected property is true
	 * @param locator By locator for WebElement to Assert Against
	 * @return AssertKeyword
	 */
	AssertKeyword assertElementSelected(By locator);
	
	/**
	 * Asserts that a WebElement's selected property is true
	 * @param element WebElement to Assert against
	 * @return AssertKeyword
	 */
	AssertKeyword assertElementSelected(WebElement element);
	
	/**
	 * Asserts that a WebElement's selected property is false
	 * @param locator By locator for WebElement to Assert Against
	 * @return AssertKeyword
	 */
	AssertKeyword assertElementNotSelected(By locator);
	
	/**
	 * Asserts that a WebElement's selected property is false
	 * @param element WebElement to Assert against
	 * @return AssertKeyword
	 */
	AssertKeyword assertElementNotSelected(WebElement element);
	
	/**
	 * Asserts that the current page title matches the expected text
	 * @param title Expected title
	 * @return AssertKeyword
	 */
	AssertKeyword assertPageTitleEquals(String title);
	
	/**
	 * Asserts that the current page title contains the expected text
	 * @param title Expected title
	 * @return AssertKeyword
	 */
	AssertKeyword assertPageTitleContains(String title);
	
	/**
	 * Asserts that the URL matches the expected text
	 * @param Url Expected URL
	 * @return AssertKeyword
	 */
	AssertKeyword assertCurrentUrlEquals(String Url);
	
	/**
	 * Asserts that the URL contains the expected text
	 * @param Url Expected URL
	 * @return AssertKeyword
	 */
	AssertKeyword assertCurrentUrlContains(String Url);
	
	/**
	 * Asserts that an Alert is present
	 * @return AssertKeyword
	 */
	AssertKeyword assertAlertIsPresent();
	
	/**
	 * Asserts that the given By locator returns the expected number of WebElements
	 * @param locator By locator for WebElement to Assert Against
	 * @param expectedNumber Integer expected number of elements to be found
	 * @return AssertKeyword
	 */
	AssertKeyword assertLocatorReturnsNumberOfElements(By locator, int expectedNumber);
	
	/**
	 * Asserts that the given By locator returns less than the given number of WebElements
	 * @param locator By locator for WebElement to Assert Against
	 * @param lessNumber  Integer lower bound number
	 * @return AssertKeyword
	 */
	AssertKeyword assertLocatorReturnsLessThan(By locator, int lessNumber);
	
	/**
	 * Asserts that the given By locator returns greater than the given number of WebElements
	 * @param locator By locator for WebElement to Assert Against
	 * @param greaterNumber  Integer greater bound number
	 * @return AssertKeyword
	 */
	AssertKeyword assertLocatorReturnsGreaterThan(By locator, int greaterNumber);
	
	/**
	 * Asserts that a DropDown's selected option text matches expected text
	 * @param locator By locator for WebElement to Assert Against
	 * @param name expected text of DropDown's selected option
	 * @return AssertKeyword
	 */
	AssertKeyword assertDropDownSelectedTextIs(By locator, String name);
	
	/**
	 * Asserts that a DropDown's selected option text matches expected text
	 * @param element WebElement to Assert against
	 * @param name Expected text of currently selected option
	 * @return AssertKeyword
	 */
	AssertKeyword assertDropDownSelectedTextIs(WebElement element, String name);
	
	/**
	 * Asserts that a DropDown's selected option value matches expected text
	 * @param locator By locator for WebElement to Assert Against
	 * @param name Expected value text
	 * @return AssertKeyword
	 */
	AssertKeyword assertDropDownSelectedValueIs(By locator, String name);
	
	/**
	 * Asserts that a DropDown's selected option value matches expected text
	 * @param element WebElement to Assert against
	 * @param name Expected value text
	 * @return AssertKeyword
	 */
	AssertKeyword assertDropDownSelectedValueIs(WebElement element, String name);
	
	/**
	 * Asserts that a DropDown contains expected number of options
	 * @param locator By locator for WebElement to Assert Against
	 * @param count Expected number of options
	 * @return AssertKeyword
	 */
	AssertKeyword assertDropDownItemCountIs(By locator, int count);
	
	/**
	 * Asserts that a DropDown contains expected number of options
	 * @param element WebElement to Assert against
	 * @param count Expected number of options
	 * @return AssertKeyword
	 */
	AssertKeyword assertDropDownItemCountIs(WebElement element, int count);
	
	/**
	 * Asserts that a DropDown contains an option with the expected option text
	 * @param locator By locator for WebElement to Assert Against
	 * @param text option text to find
	 * @return AssertKeyword
	 */
	AssertKeyword assertDropDownCountainsOption(By locator, String text);
	
	/**
	 * Asserts that a DropDown contains an option with the expected option text
	 * @param element WebElement to Assert against
	 * @param text option text to find
	 * @return AssertKeyword
	 */
	AssertKeyword assertDropDownCountainsOption(WebElement element, String text);
	
	/**
	 * Asserts that a DropDown contains all options with texts in provided List of Strings
	 * @param locator By locator for WebElement to Assert Against
	 * @param texts Option texts to find
	 * @return AssertKeyword
	 */
	AssertKeyword assertDropDownCountainsOptions(By locator, List<String> texts);
	
	/**
	 * Asserts that a DropDown contains all options with texts in provided List of Strings
	 * @param element WebElement to Assert against
	 * @param texts Option texts to find
	 * @return AssertKeyword
	 */
	AssertKeyword assertDropDownCountainsOptions(WebElement element, List<String> texts);
	
	/**
	 * Asserts that a DropDown contains all options with texts in provided List of Strings in the same order as the provided List of Strings
	 * @param locator By locator for WebElement to Assert Against
	 * @param texts Option texts to find in expected order
	 * @return AssertKeyword
	 */
	AssertKeyword assertDropDownOptionsInOrderOf(By locator, List<String> texts);
	
	/**
	 * Asserts that a DropDown contains all options with texts in provided List of Strings in the same order as the provided List of Strings
	 * @param element WebElement to Assert against
	 * @param texts Option texts to find in expected order
	 * @return AssertKeyword
	 */
	AssertKeyword assertDropDownOptionsInOrderOf(WebElement element, List<String> texts);
	
	/**
	 * 
	 * @return Default timeout in seconds
	 */
	long getDefaultWait();
	
	/**
	 * Sets the default timeout
	 * @param seconds number of seconds for default timeout
	 */
	void setDefaultWait(long seconds);
}
