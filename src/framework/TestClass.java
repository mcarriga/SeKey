package framework;


import org.testng.annotations.Listeners;

import interfaces.IAction;
import interfaces.IAssert;
import interfaces.IGet;
import interfaces.ILogging;
import interfaces.IWait;
import logging.KeywordLogger;

@Listeners(listeners.TestListeners.class)
public abstract class TestClass {
	public static Framework framework;
	public IWait wait; 
	public IGet get;
	public IAssert asserts;
	public IAction action;
	public ILogging logger;
	
	public void init(Framework framework) {
		TestClass.framework = framework;
		this.wait = framework.wait;
		this.get = framework.get;
		this.asserts = framework.asserter;
		this.action = framework.action;
		this.logger = KeywordLogger.getInstance();
	}
	
}
