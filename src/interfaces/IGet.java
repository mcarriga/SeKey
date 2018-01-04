package interfaces;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import framework.GetKeyword;

/**
 * Interface for Framework provided Get Keywords.
 * Get Keywords are any Keyword intended to return some Browser or Element information. The Get Keywords should primarily be used to make code logic decisions paths and NOT to assert against. Assert Keywords should be used for that instead.
 * @author Mathew Carrigan
 *
 */
public interface IGet {
	/**
	 * Get's the text() property of an element. The text property of an element is the Text between the element tags like "<p> this is the text of a paragraph</p>"
	 * For Text Input boxes like username and password inputs you should use the getElementValue method instead to get the text present in a input textbox.
	 * @param locator By locator of the element to get the text of
	 * @return a GetKeyword
	 */
	GetKeyword<String> getElementText(By locator);
	
	/**
	 * Get's the text() property of an element. The text property of an element is the Text between the element tags like "<p> this is the text of a paragraph</p>"
	 * For Text Input boxes like username and password inputs you should use the getElementValue method instead to get the text present in a input textbox.
	 * @param element WebElement to get the text of
	 * @return a GetKeyword
	 */
	GetKeyword<String> getElementText(WebElement element);
	
	/**
	 * Returns the text of an element's value attribute. This is useful for many input elements
	 * @param locator By locator of the element to get value attribute of
	 * @return a GetKeyword
	 */
	GetKeyword<String> getElementValue(By locator);
	
	/**
	 * Returns the text of an element's value attribute. This is useful for many input elements
	 * @param element WebElement to get the value attribute of
	 * @return a GetKeyword
	 */
	GetKeyword<String> getElementValue(WebElement element);
	
	/**
	 * Returns the value of the provided attribute of an element
	 * @param locator By locator of the element to get attribute of
	 * @param attrName Attribute name
	 * @return a GetKeyword
	 */
	GetKeyword<String> getElementAttribute(By locator, String attrName);
	
	/**
	 * Returns the value of the provided attribute of an element
	 * @param element WebElement get attribute of
	 * @param attrName Attribute name
	 * @return a GetKeyword
	 */
	GetKeyword<String> getElementAttribute(WebElement element, String attrName);
	
	/**
	 * Finds all the elements that match the By locator and returns the number of elements found
	 * @param locator By locator to search the DOM for
	 * @return a GetKeyword
	 */
	GetKeyword<Integer> getElementCount(By locator);
	
	/**
	 * Whether or not an element is visible
	 * @param locator By locator for the element to check
	 * @return a GetKeyword
	 */
	GetKeyword<Boolean> isVisible(By locator);
	
	/**
	 * Whether or not an element is visible
	 * @param element WebElement to check
	 * @return a GetKeyword
	 */
	GetKeyword<Boolean> isVisible(WebElement element);
	
	/**
	 * Determines whether provided Element is enabled on the DOM or not
	 * @param locator By locator for the element to check
	 * @return a GetKeyword
	 */
	GetKeyword<Boolean> isEnabled(By locator);
	
	/**
	 * Determines whether provided Element is enabled on the DOM or not
	 * @param element WebElement to check
	 * @return a GetKeyword
	 */
	GetKeyword<Boolean> isEnabled(WebElement element);
	
	/**
	 * Determines whether an element is Selected or not
	 * @param locator By locator for the element to check
	 * @return a GetKeyword
	 */
	GetKeyword<Boolean> isSelected(By locator);
	
	/**
	 * Determines whether an element is Selected or not
	 * @param locator By locator for the element to check
	 * @return a GetKeyword
	 */
	GetKeyword<Boolean> isSelected(WebElement element);
	
	/**
	 * Returns a list of all option texts of a given input dropdown/combobox
	 * @param locator By locator of the input
	 * @return a GetKeyword
	 */
	GetKeyword<List<String>> getDropDownOptions(By locator);
	
	/**
	 * Returns a list of all option texts of a given input dropdown/combobox
	 * @param element input WebElement
	 * @return a GetKeyword
	 */
	GetKeyword<List<String>> getDropDownOptions(WebElement element);
	
	/**
	 * Returns the text of a Dropdown's selected option
	 * @param locator By locator of the input
	 * @return a GetKeyword
	 */
	GetKeyword<String> getDropDownSelectedOption(By locator);
	
	/**
	 * Returns the text of a Dropdown's selected option
	 * @param element input WebElement
	 * @return a GetKeyword
	 */
	GetKeyword<String> getDropDownSelectedOption(WebElement element);
	
	/**
	 * Returns the number of options in a given dropdown
	 * @param locator By locator of the input
	 * @return a GetKeyword
	 */
	GetKeyword<Integer> getDropDownOptionsCount(By locator);
	
	/**
	 * Returns the number of options in a given dropdown
	 * @param element input WebElement
	 * @return a GetKeyword
	 */
	GetKeyword<Integer> getDropDownOptionsCount(WebElement element);
	
	/**
	 * 
	 * @return Current Browser Tab's Page Title
	 */
	GetKeyword<String> getPageTitle();
	
	/**
	 * 
	 * @return Current Browser Tab's URL
	 */
	GetKeyword<String> getCurrentUrl();
}
