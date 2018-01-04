package interfaces;

/**
 * The IKeyword interface is the base model for all of the Framework Selenium Keywords.
 * This interface contains the basic methods called on by the Framework class to execute a keyword
 * Ideally, various abstract classes would be created from this interface to serve as templates for the different categories of keywords like action, assert, wait...
 * @author Mathew Carrigan
 *
 */
public interface IKeyword<T extends Object> {
	/**
	 * perform is the core method that executes the desired action of the Keyword. Example: A 'Click' Keyword would execute WebElement.click() inside this method
	 * @return Generic T Object of whatever abstract type/category class or desired concrete class needs to return. Can be any type of object including Void for void methods.
	 * This should be parameterless as any and all needed params should be passed to the constructor of the concrete class implementation
	 */
	T perform();
	
	/**
	 * Log message to be performed before the perform() method is called.
	 * Typically, all Keywords should take in an ILogging instance in the constructor of the concrete class.
	 * startLog() should always use the ILogging implementation and utilize ILogging's provided beginKeyword() methods with various overloads
	 * @see ILogging
	 * @see ILogging.beginKeyword()
	 */
	void startLog();
	
	/**
	 * Log message to be performed upon completion of the perform() method.
	 * Typically, all Keywords should take in an ILogging instance in the constructor of the concrete class.
	 * endLog() should always use the ILogging implementation and utilize ILogging's provided endKeyword() method
	 * @see ILogging and @see ILogging.beginKeyword()
	 */
	void endLog();
	
	/**
	 * Calls the startLog(), perform(), and endLog() methods in that order
	 * @see startLog()
	 * @see perform()
	 * @see endLog()
	 * @return the Generic T Object returned by perform() method
	 */
	T build();
	
	/**
	 * Should be implemented by the category/type abstract classes and NOT the concrete keyword implementation classes
	 * Used to provide some info to ILogging to provide syntax to the log messages like 'Starting Action.Click...'
	 * @return String category/Type of keyword like Action, Assert, Get, Wait, etc...
	 */
	String getKeywordType();
}
