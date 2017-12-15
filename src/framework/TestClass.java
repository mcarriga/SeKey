package framework;

import org.openqa.selenium.WebDriver;

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
	public WebDriver driver;
	
	
	
}
