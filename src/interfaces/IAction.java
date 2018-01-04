package interfaces;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import framework.ActionKeyword;

/**
 * Interface for Framework provided Action Keywords.
 * Action Keywords are any Keyword intended to perform a user simulated action using Keyboard amd Mouse on a web page
 * @author Mathew Carrigan
 *
 */
public interface IAction {
	
	/**
	 * Select an input dropdown/combobox by the name of the option to select. The By locator MUST be an input
	 * @param locator By locator for the input
	 * @param name Text of the input option to select
	 * @return an ActionKeyword instance
	 */
	ActionKeyword selectByText(By locator, String name);
	
	/**
	 * Select an input dropdown/combobox by the name of the option to select. The WebElement MUST be an input
	 * @param element WebElement for the input
	 * @param name Text of the input option to select
	 * @return an ActionKeyword instance
	 */
	ActionKeyword selectByText(WebElement element, String name);
	
	/**
	 * Select and input dropdown/combox option by the Index(nth) of the options. Index starts at 0 so first option would be 0th index.  The By locator MUST be an input element
	 * @param locator By locator for the input
	 * @param name Text of the input option to select
	 * @return an ActionKeyword instance
	 */
	ActionKeyword selectByIndex(By locator, int index);
	
	/**
	 * Select and input dropdown/combox option by the Index(nth) of the options. Index starts at 0 so first option would be 0th index.  The WebElement MUST be an input element
	 * @param element WebElement for the input
	 * @param name Text of the input option to select
	 * @return an ActionKeyword instance
	 */
	ActionKeyword selectByIndex(WebElement element, int index);
	
	/**
	 * Perform a mouse click on the provided Element
	 * @param locator By locator of the element to click on
	 * @return an ActionKeyword instance
	 */
	ActionKeyword click(By locator);
	
	/**
	 * Perform a mouse click on the provided Element
	 * @param element WebElement click on
	 * @return an ActionKeyword instance
	 */
	ActionKeyword click(WebElement element);
	
	/**
	 * Sends the provided String to an element. Used for text and password input boxes
	 * Can supply an actual String like 'send these keys' or use Selenium's Keys class for other keyboard keys like Enter, Return, Tab, etc...
	 * @see Keys
	 * @param locator By locator of the element to send Keys/Text to
	 * @param text Text or Selenium Keys @see Keys
	 * @return an ActionKeyword instance
	 */
	ActionKeyword sendKeys(By locator, String text);
	
	/**
	 * Sends the provided String to an element. Used for text and password input boxes
	 * Can supply an actual String like 'send these keys' or use Selenium's Keys class for other keyboard keys like Enter, Return, Tab, etc...
	 * @see Keys
	 * @param element WebElement to send Keys/Text to
	 * @param text Text or Selenium Keys @see Keys
	 * @return an ActionKeyword instance
	 */
	ActionKeyword sendKeys(WebElement element, String text);
	
	/**
	 * Run custom JavaScript command. Uses Selenium's IJavascriptExecutor
	 * @param js Javascript to run
	 * @return an ActionKeyword instance
	 */
	ActionKeyword executeJavaScript(String js);
	
	/**
	 * Run custom JavaScript command. Uses Selenium's IJavascriptExecutor
	 * @param js Javascript to run
	 * @param args list of objects to send along with the Javascript text. For example you can send a WebElement if your intended JS script acts on a specific WebElement
	 * @return an ActionKeyword instance
	 */
	ActionKeyword executeJavaScript(String js, Object... args);
	
	/**
	 * Navigates the currently focused Browser tab to the provided URL
	 * @param url URL as String to navigate to
	 * @return an ActionKeyword instance
	 */
	ActionKeyword navigateTo(String url);
	
	/**
	 * Navigates the currently focused Browser tab to the provided URL
	 * @param url URL to navigate to
	 * @return an ActionKeyword instance
	 */
	ActionKeyword navigateTo(URL url);
	
	/**
	 * Navigates the current Browser Tab backward as if clicking the browser's Back button
	 * @return an ActionKeyword instance
	 */
	ActionKeyword navigateBack();
	
	/**
	 * Navigates the current Browser tab forward as if clicking the browser's Forward button
	 * @return an ActionKeyword instance
	 */
	ActionKeyword navigateForward();
	
	/**
	 * Refreshes the current Browser Tab's URL as if clicking the browser's Refresh button
	 * @return
	 */
	ActionKeyword navigateRefresh();
	
	/**
	 * Performs a Double-Click on the provided element
	 * @param locator By locator of the element to double-click on
	 * @return an ActionKeyword instance
	 */
	ActionKeyword doubleClick(By locator);
	
	/**
	 * Performs a Double-Click on the provided element
	 * @param element WebElement to double-click on
	 * @return an ActionKeyword instance
	 */
	ActionKeyword doubleClick(WebElement element);
	
	/**
	 * Performs a mouse hover/onfocus() event on the provided element for the given duration
	 * @param locator By locator of the element to hover on
	 * @param seconds Amount of seconds t o perform hover event
	 * @return an ActionKeyword instance
	 */
	ActionKeyword hover(By locator, long seconds);
	
	/**
	 * Performs a mouse hover/onfocus() event on the provided element for the given duration
	 * @param element WebElement to hover on
	 * @param seconds Amount of seconds t o perform hover event
	 * @return an ActionKeyword instance
	 */
	ActionKeyword hover(WebElement element, long seconds);
	
	/**
	 * Performs a mouse hover/onfocus() event on the provided element
	 * @param locator By locator of the element to hover on
	 * @return an ActionKeyword instance
	 */
	ActionKeyword hover(By locator);
	
	/**
	 * Performs a mouse hover/onfocus() event on the provided element
	 * @param element WebElement to hover on
	 * @return an ActionKeyword instance
	 */
	ActionKeyword hover(WebElement element);
	
	/**
	 * Moves the mouse focus to the given element. Similiar to Hover but without any time delay
	 * @param locator By locator of the element to move to
	 * @return an ActionKeyword instance
	 */
	ActionKeyword mouseTo(By locator);
	
	/**
	 * Moves the mouse focus to the given element. Similiar to Hover but without any time delay
	 * @param element WebElement to move to
	 * @return an ActionKeyword instance
	 */
	ActionKeyword mouseTo(WebElement element);
	
	/**
	 * Performs a Click and Drag action from a source element to a target element. This will click and hold on the source element and move the cursor to the target element and release there
	 * @param source By locator of the element to be clicked on and dragged
	 * @param target By locator of the element to drag to and release on
	 * @return an ActionKeyword instance
	 */
	ActionKeyword clickAndDrag(By source, By target);
	
	/**
	 * Performs a Click and Drag action from a source element to a target element. This will click and hold on the source element and move the cursor to the target element and release there
	 * @param source By locator of the element to be clicked on and dragged
	 * @param target WebElement to drag to and release on
	 * @return an ActionKeyword instance
	 */
	ActionKeyword clickAndDrag(By source, WebElement target);
	
	/**
	 * Performs a Click and Drag action from a source element to a target element. This will click and hold on the source element and move the cursor to the target element and release there
	 * @param source WebElement to be clicked on and dragged
	 * @param target By locator of the element to drag to and release on
	 * @return an ActionKeyword instance
	 */
	ActionKeyword clickAndDrag(WebElement source, By target);
	
	/**
	 * Performs a Click and Drag action from a source element to a target element. This will click and hold on the source element and move the cursor to the target element and release there
	 * @param source WebElement to be clicked on and dragged
	 * @param target WebElement to drag to and release on
	 * @return an ActionKeyword instance
	 */
	ActionKeyword clickAndDrag(WebElement source, WebElement target);
	
	/**
	 * Performs a Click and Drag action from a source element to a target Location offset relative to the source location. Example xOffset and yOffset of 100 each will drag to 100 pixels Right and 100 Pixels Left of the source element
	 * @param source By locator of element to be clicked on and dragged
	 * @param offsetX number of pixels along the X axis. Positive is right, Negative is left, and 0 is same position on the X axis
	 * @param offsetY number of pixels along the Y axis. Positive is up, Negative is down, and 0 is the same position along the Y axis
	 * @return an ActionKeyword instance
	 */
	ActionKeyword clickAndDrag(By source, int offsetX, int offsetY);
	
	/**
	 * Performs a Click and Drag action from a source element to a target Location offset relative to the source location. Example xOffset and yOffset of 100 each will drag to 100 pixels Right and 100 Pixels Left of the source element
	 * @param source WebElement to be clicked on and dragged
	 * @param offsetX number of pixels along the X axis. Positive is right, Negative is left, and 0 is same position on the X axis
	 * @param offsetY number of pixels along the Y axis. Positive is up, Negative is down, and 0 is the same position along the Y axis
	 * @return an ActionKeyword instance
	 */
	ActionKeyword clickAndDrag(WebElement source, int offsetX, int offsetY);
	
	/**
	 * Makes a checkbox selected. This will first check is the checkbox is already selected and only perform a click if it is not already selected
	 * @param locator By locator of the checkbox element to make selected. Element MUST be a checkbox input element
	 * @return an ActionKeyword instance
	 */
	ActionKeyword selectCheckbox(By locator);
	
	/**
	 * Makes a checkbox selected. This will first check is the checkbox is already selected and only perform a click if it is not already selected
	 * @param element Checkbox WebElement to make selected. Element MUST be a checkbox input element
	 * @return an ActionKeyword instance
	 */
	ActionKeyword selectCheckbox(WebElement element);
	
	/**
	 * Makes a checkbox un-selected. This will first check is the checkbox is already selected and only perform a click if it currently selected
	 * @param locator By locator of the checkbox element to make unselected. Element MUST be a checkbox input element
	 * @return an ActionKeyword instance
	 */
	ActionKeyword unselectCheckbox(By locator);
	
	/**
	 * Makes a checkbox un-selected. This will first check is the checkbox is already selected and only perform a click if it currently selected
	 * @param locator Checkbox WebElement to make un-selected. Element MUST be a checkbox input element
	 * @return an ActionKeyword instance
	 */
	ActionKeyword unselectCheckbox(WebElement element);
	
	/**
	 * Selects an option for a radio group input by the 0-based index of the option. The first option would have index of 0
	 * Alternative of this method is to just perform a click action on a specific uniquely found Radio Button
	 * @param parent By locator for the radio group
	 * @param index Index of option to select
	 * @return an ActionKeyword instance
	 */
	ActionKeyword selectRadioOptionByIndex(By parent, int index);
	
	/**
	 * Selects an option for a radio group input by the 0-based index of the option. The first option would have index of 0
	 * Alternative of this method is to just perform a click action on a specific uniquely found Radio Button
	 * @param parent WebElement of the radio group
	 * @param index Index of option to select
	 * @return an ActionKeyword instance
	 */
	ActionKeyword selectRadioOptionByIndex(WebElement parent, int index);
	
	/**
	 * Selects an option for a radio group inoput based on the Value attribute of the option
	 * @param parent By locator of of the radio group element
	 * @param value Exact value of the value attribute for the desired radio option to be selected
	 * @return an ActionKeyword instance
	 */
	ActionKeyword selectRadioOptionByValue(By parent, String value);
	
	/**
	 * Selects an option for a radio group inoput based on the Value attribute of the option
	 * @param parent WebElement of the radio group
	 * @param value Exact value of the value attribute for the desired radio option to be selected
	 * @return an ActionKeyword instance
	 */
	ActionKeyword selectRadioOptionByValue(WebElement parent, String value);
	
	/**
	 * Uses the IJavascriptExecutor to scroll the browser to the provided element
	 * @param locator By locator for the Element to scroll to
	 * @return an ActionKeyword instance
	 */
	ActionKeyword scrollToElement(By locator);
	
	/**
	 * Uses the IJavascriptExecutor to scroll the browser to the provided element
	 * @param element WebElement to scroll to
	 * @return an ActionKeyword instance
	 */
	ActionKeyword scrollToElement(WebElement element);
	
	/**
	 * Switches Selenium's currently focused DOM to that of an IFrame in order to interact with any WebElements inside the given iFrame
	 * @param idOrName Name or ID of the iFrame element to switch to
	 * @return an ActionKeyword instance
	 */
	ActionKeyword switchToFrame(String idOrName);
	
	/**
	 * Switches Selenium's currently focused DOM to that of an IFrame in order to interact with any WebElements inside the given iFrame
	 * @param index switches to an iFrame of the nth index. For example, if it is required to always switch to the 3rd iFrame, then provide 2 as the index as index is 0 based
	 * @return an ActionKeyword instance
	 */
	ActionKeyword switchToFrame(int index);
	
	/**
	 * Switches Selenium's currently focused DOM to that of an IFrame in order to interact with any WebElements inside the given iFrame
	 * @param frame WebElement of the iFrame to switch to
	 * @return an ActionKeyword instance
	 */
	ActionKeyword switchToFrame(WebElement frame);
	
	/**
	 * Switches Selenium's currently focused DOM to that of an IFrame in order to interact with any WebElements inside the given iFrame
	 * @param frame by locator of the iFrame element to switch to
	 * @return an ActionKeyword instance
	 */
	ActionKeyword switchToFrame(By frame);
	
	/**
	 * Switches Selenium's DOM focus to the main parent DOM also known as the default DOM
	 * @return
	 */
	ActionKeyword switchToDefaultContent();
}
