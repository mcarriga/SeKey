package framework;


import org.testng.annotations.Listeners;

import interfaces.IAction;
import interfaces.IAssert;
import interfaces.IGet;
import interfaces.ILogging;
import interfaces.IWait;
import logging.KeywordLogger;

/**
 * Base Test Class for all KeywordProvider tests in the Coded(non-Excel) format
 * Uses Listener: listeners.TestListeners
 * @author Mathew Carrigan
 *
 */
@Listeners(listeners.TestListeners.class)
public abstract class TestClass {
	public static KeywordProvider keywordProvider;
	public IWait waits; 
	public IGet gets;
	public IAssert asserts;
	public IAction actions;
	public ILogging loggers;
	
	/**
	 * Initialized fields for this class
	 * @param keywordProvider KeywordProvider implementation to use
	 */
	public void init(KeywordProvider keywordProvider) {
		TestClass.keywordProvider = keywordProvider;
		this.waits = keywordProvider.waits;
		this.gets = keywordProvider.gets;
		this.asserts = keywordProvider.asserts;
		this.actions = keywordProvider.actions;
		this.loggers = KeywordLogger.getInstance();
	}
	
}
