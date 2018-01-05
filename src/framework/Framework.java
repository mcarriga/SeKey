package framework;

import java.io.IOException;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

import interfaces.*;

/**
 * Core Framework for running Keywords and PageObject repeatable methods
 * Allows for Method Chaining Keyword and PageObject methods for simplified clean code
 * @author Mathew Carrigan
 *
 */
public class Framework {
	/**
	 * Active WebDriver
	 */
	public final WebDriver driver;
	
	/**
	 * Active ILogging
	 */
	public final ILogging logger;
	
	/**
	 * Active IAction
	 */
	public final IAction action;
	
	/**
	 * Active IAssert
	 */
	public final IAssert asserter;
	
	/**
	 * Active IWait
	 */
	public final IWait wait;
	
	/**
	 * Active IGet
	 */
	public final IGet get;
	
	public Framework(WebDriver driver, ILogging logger) {
		this.driver = driver;
		this.logger = logger;
		wait = new Waits(driver, logger);
		action = new Actions(driver, logger, wait);
		get = new Gets(driver, logger);
		asserter = new Asserts(driver, logger, wait);
	}
	
	/**
	 * Performs an Action Keyword
	 * @param func ActionKeyword to run
	 * @return an instance of 'this' class for method chaining purposes
	 */
	public Framework withAction(ActionKeyword func) {
		func.build();
		return this;
	}
	
	/**
	 * Performs an Action Keyword
	 * @param action IAfterAction to run and evaluate
	 * @return an instance of 'this' class for method chaining purposes
	 */
	public Framework withAction(IAfterAction action) {
		action.getAction().build();
		return this;
	}
	
	/**
	 * Performs an Assert Keyword
	 * @param func Assert Keyword to run
	 * @return an instance of 'this' class for method chaining purposes
	 */
	public Framework withAssert(AssertKeyword func) {
		func.build();
		return this;
	}
	
	/**
	 * Performs a Wait Keyword
	 * @param func WaitKeyword to run
	 * @return an instance of 'this' class for method chaining purposes
	 */
	public Framework withWait(WaitKeyword func) {
		func.build();
		return this;
	}
	
	/**
	 * Performs a Get Keyword and returns the Keyword's Type
	 * @param func Get Keyword to run
	 * @return the Type the provided Get Keyword returns - Breaks method chaining
	 */
	@SuppressWarnings("unchecked")
	public <T> T withGet(GetKeyword<?> func) {
		return (T)func.build();
	}
	
	/**
	 * Performs and Wait Keyword and returns the Keyword's Type
	 * @param func Wait Keyword to run
	 * @param out 
	 * @return the Type the provided Wait Keyword returns - Breaks method chaining
	 */
	@SuppressWarnings("unchecked")
	public <T> T withWait(WaitKeyword func, T out) {
		return (T)func.build();
	}
	
	/**
	 * Performs and Wait Keyword and returns the Keyword's Type
	 * @param func Wait Keyword to run
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
	public Framework withLogEvent(IAAALogEvent aaa) {
		aaa.doLog();
		return this;
	}
	
	/**
	 * Performs and thread sleep for the given duration
	 * @param seconds Number of seconds to pause execution for
	 * @return an instance of 'this' class for method chaining purposes
	 */
	public Framework withDelay(int seconds) {
		ScheduledThreadPoolExecutor exec = new ScheduledThreadPoolExecutor(seconds);

		exec.schedule(new Runnable() {
		          public void run() {
		              
		          }
		     }, 1, TimeUnit.SECONDS);
		return this;
	}
	
	/**
	 * Performs a Page Object repeatable method.
	 * Use syntax: .withPageObject(() -> PageObjectClass.Method(method params...))
	 * @param func Page Object to run - Use () -> lambda syntax
	 * @return an instance of 'this' class for method chaining purposes
	 * @throws Exception
	 * @throws IOException
	 */
	public Framework withPageObject(CheckedRunnable func) throws Exception, IOException {
		func.run();
		return this;
	}
}


