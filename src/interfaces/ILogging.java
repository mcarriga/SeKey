package interfaces;


import org.openqa.selenium.By;

import com.aventstack.extentreports.ExtentReports;

/**
 * Primary interface used for Logging within the keywordProvider
 * Logging is designed to use an interface so that any type of logging library can be used without issues of refactoring.
 * Currently log4j is the provided logging library for the keywordProvider
 * @author Mathew Carrigan
 *
 */
public interface ILogging {
	/**
	 * Log message to be written before a keyword is executed
	 * @param keyword Instance of the Keyword being called - Pass in 'this' as the parameter
	 */
	void beginKeyword(IKeyword<?> keyword);
	
	/**
	 * Log message to be written before a keyword is executed
	 * @param keyword Instance of the Keyword being called - Pass in 'this' as the parameter
	 * @param locator Selenium By locator. If a keyword class has overloaded constructors one of which takes a By and the other takes a WebElement it is acceptable to still pass the By locator in as this method should check if the locator is null and process accordingly
	 */
	void beginKeyword(IKeyword<?> keyword, By locator);
	
	/**
	 * Log message to be written before a keyword is executed
	 * @param keyword Instance of the Keyword being called - Pass in 'this' as the parameter
	 * @param locators Selenium By locators. If a keyword class has overloaded constructors one of which takes 1 or more By locators  and the other takes WebElement/s it is acceptable to still pass the By locator in as this method should check if the locator is null and process accordingly
	 */
	void beginKeyword(IKeyword<?> keyword, By... locators);
	
	/**
	 * Log message to be written before a keyword is executed
	 * @param keyword Instance of the Keyword being called - Pass in 'this' as the parameter
	 * @param additionalInfo String of any additional information to display. Example SendKeys keyword logs an additionalInfo message of the keys being sent by the keyword
	 * @param locators Selenium By locators. If a keyword class has overloaded constructors one of which takes 1 or more By locators  and the other takes WebElement/s it is acceptable to still pass the By locator in as this method should check if the locator is null and process accordingly
	 */
	void beginKeyword(IKeyword<?> keyword, String additionalInfo, By... locators);
	
	/**
	 * 
	 *  Log message to be written before a keyword is executed
	 * @param keyword Instance of the Keyword being called - Pass in 'this' as the parameter
	 * @param additionalInfo String of any additional information to display. Example SendKeys keyword logs an additionalInfo message of the keys being sent by the keyword
	 * @param locator Selenium By locator. If a keyword class has overloaded constructors one of which takes a By and the other takes a WebElement it is acceptable to still pass the By locator in as this method should check if the locator is null and process accordingly
	 */
	void beginKeyword(IKeyword<?> keyword, By locator, String additionalInfo);
	
	/**
	 * Log message to be written before a keyword is executed
	 * @param keyword Instance of the Keyword being called - Pass in 'this' as the parameter
	 * @param additionalInfo String of any additional information to display. Example SendKeys keyword logs an additionalInfo message of the keys being sent by the keyword
	 */
	void beginKeyword(IKeyword<?> keyword, String additionalInfo);
	
	/**
	 * Log message to be written upon completion of a keyword perform() method
	 * @param keyword Instance of the Keyword being called - Pass in 'this' as the parameter
	 */
	void endKeyword(IKeyword<?> keyword);
	
	/**
	 * Used for Triple AAA Logging Pattern which breaks test cases down into several parts of Arrange, Act, Assert, and optionally Cleanup
	 * Generates a specially formatted log message indicating the current processing is in the Arrange section of the test case
	 * The Arrange section of a test case is any steps required to in order to get to the primary Act section of a test case. Example: Authenticating and navigating to the billing section in order to test Billing feature
	 * @param message Description of what is taking place in the Assert Section. Example: 'Navigating to the portal and authenticating as a Primary User'
	 * @return an instance of IAAALogEvent to be logged
	 */
	IAAALogEvent arrangeSection(String message);
	
	/**
	 * Used for Triple AAA Logging Pattern which breaks test cases down into several parts of Arrange, Act, Assert, and optionally Cleanup
	 * Generates a specially formatted log message indicating the current processing is in the Act section of the test case
	 * The Act section of a test case is the primary action that the test case is testing - referred to as the spirit of the test case
	 * @param message Description of what is taking place in the Arrange Section. Example: 'Paying full bill amount with preferred payment method'
	 * @return an instance of IAAALogEvent to be logged
	 */
	IAAALogEvent actSection(String message);
	
	/**
	 * Used for Triple AAA Logging Pattern which breaks test cases down into several parts of Arrange, Act, Assert, and optionally Cleanup
	 * Generates a specially formatted log message indicating the current processing is in the Assert section of the test case
	 * The Assert section of a test case is the validation that the actions performed in the Act section happened as expected.
	 * @param message Description of what is taking place in the Arrange Section. Example: 'Asserting there is a pending payment and current balance is 0 and that a successful transaction message is displayed after payment is sent'
	 * @return an instance of IAAALogEvent to be logged
	 */
	IAAALogEvent assertSection(String message);
	
	/**
	 * Used for Triple AAA Logging Pattern which breaks test cases down into several parts of Arrange, Act, Assert, and optionally Cleanup
	 * Generates a specially formatted log message indicating the current processing is in the Cleanup section of the test case
	 * The Cleanup section of a test case is any cleanup or breakdown needed after a test is complete to return the environment into is past state.
	 * @param message Description of what is taking place in the Arrange Section. Example: 'Canceling the payment and Closing the browser'
	 * @return an instance of IAAALogEvent to be logged
	 */
	IAAALogEvent cleanupSection(String message);
	
	/**
	 * An Informational log event. 
	 * @param message String message to written by the logger
	 */
	void info(String message);
	void error();
	void warn(String message);
	void debug();
	
	/**
	 * This keywordProvider is designed to generate HTML reports designed by the ExtentReports Enterprise edition Java Library
	 * This method should return the current active Extent Reports instance
	 * @return ExtentReport instance @see ExtentReports
	 * @see <a href="http://extentreports.com/">http://extentreports.com/</a>
	 */
	ExtentReports getExtent();
}
