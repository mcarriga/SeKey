package framework;

import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

import interfaces.*;

/**
 * Core KeywordProvider for running Keywords and PageObject repeatable methods
 * Allows for Method Chaining Keyword and PageObject methods for simplified clean code
 * @author Mathew Carrigan
 *
 */
public class KeywordProvider {
	/**
	 * Active WebDriver
	 */
	public final WebDriver driver;
	
	/**
	 * Active ILogging
	 */
	public final ILogging loggers;
	
	/**
	 * Active IAction
	 */
	public final IAction actions;
	
	/**
	 * Active IAssert
	 */
	public final IAssert asserts;
	
	/**
	 * Active IWait
	 */
	public final IWait waits;
	
	/**
	 * Active IGet
	 */
	public final IGet gets;
	
	public KeywordProvider(WebDriver driver, ILogging logger) {
		this.driver = driver;
		this.loggers = logger;
		waits = new Waits(driver, logger);
		actions = new Actions(driver, logger, waits);
		gets = new Gets(driver, logger);
		asserts = new Asserts(driver, logger, waits);
	}
	
	/**
	 * Performs an Action Keyword
	 * @param func ActionKeyword to run
	 * @return an instance of 'this' class for method chaining purposes
	 */
	public KeywordProvider withAction(ActionKeyword func) {
		func.build();
		return this;
	}
	
	/**
	 * Performs an Action Keyword
	 * @param action IAfterAction to run and evaluate
	 * @return an instance of 'this' class for method chaining purposes
	 */
	public KeywordProvider withAction(IAfterAction action) {
		action.getAction().build();
		return this;
	}
	
	/**
	 * Performs an Assert Keyword
	 * @param func Assert Keyword to run
	 * @return an instance of 'this' class for method chaining purposes
	 */
	public KeywordProvider withAssert(AssertKeyword func) {
		func.build();
		return this;
	}
	
	/**
	 * Performs a Wait Keyword
	 * @param func WaitKeyword to run
	 * @return an instance of 'this' class for method chaining purposes
	 */
	public KeywordProvider withWait(WaitKeyword func) {
		func.build();
		return this;
	}
	
	/**
	 * Performs a Get Keyword and returns the Keyword's Type
	 * @param func Get Keyword to run
	 * @param <T> This is the type parameter
	 * @return the Type the provided Get Keyword returns - Breaks method chaining
	 */
	@SuppressWarnings("unchecked")
	public <T> T withGet(GetKeyword<?> func) {
		return (T)func.build();
	}
	
	/**
	 * Performs and Wait Keyword and returns the Keyword's Type
	 * @param func Wait Keyword to run
	 * @param out Type of WaitKeyword return - should be Boolean
	 * @param <T> This is the type parameter
	 * @return the Type the provided Wait Keyword returns - Breaks method chaining
	 */
	@SuppressWarnings("unchecked")
	public <T> T withWait(WaitKeyword func, T out) {
		return (T)func.build();
	}
	
	/**
	 * Performs and Wait Keyword and returns the Keyword's Type
	 * @param func Wait Keyword to run
	 * @param <T> This is the type parameter
	 * @return the Type the provided Wait Keyword returns - Breaks method chaining
	 */
	@SuppressWarnings("unchecked")
	public <T> T withWaitReturn(WaitKeyword func) {
		return (T) func.build();
	}
	
	/**
	 * Performs a IAALogEvent of type Arrange, Act, Assert, or Cleanup
	 * @param aaa Log Event to perform
	 * @return an instance of 'this' class for method chaining purposes
	 */
	public KeywordProvider withLogEvent(IAAALogEvent aaa) {
		aaa.doLog();
		return this;
	}
	
	/**
	 * Performs and thread sleep for the given duration
	 * @param seconds Number of seconds to pause execution for
	 * @return an instance of 'this' class for method chaining purposes
	 */
	public KeywordProvider withDelay(int seconds) {
		ScheduledThreadPoolExecutor exec = new ScheduledThreadPoolExecutor(seconds);

		exec.schedule(new Runnable() {
		          public void run() {
		              
		          }
		     }, 1, TimeUnit.SECONDS);
		return this;
	}
	
	/**
	 * Performs a Page Object repeatable method.
	 * Use syntax: .withPageObject(() -&gt; PageObjectClass.Method(method params...))
	 * @param func Page Object to run - Use ' () -&gt; ' lambda syntax
	 * @return an instance of 'this' class for method chaining purposes
	 * @throws Exception Can throw any type of exception as this is just executing a generic Runnable statement
	 */
	public KeywordProvider withPageObject(CheckedRunnable func) throws Exception {
		func.run();
		return this;
	}
}


