package framework;


import interfaces.IAction;
import interfaces.IAssert;
import interfaces.IGet;
import interfaces.ILogging;
import interfaces.IWait;

public abstract class TestClass {
	public Framework framework;
	public IWait wait; 
	public IGet get;
	public IAssert asserts;
	public IAction action;
	public ILogging logger;
	
	public void init(Framework framework) {
		this.framework = framework;
		this.wait = framework.wait;
		this.get = framework.get;
		this.asserts = framework.asserter;
		this.action = framework.action;
		this.logger = framework.logger;
	}
	
}
