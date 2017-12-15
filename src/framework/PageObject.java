package framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import interfaces.IAction;
import interfaces.IAssert;
import interfaces.IGet;
import interfaces.ILogging;
import interfaces.IWait;

public abstract class PageObject {
	public final Framework framework;
	public final IWait wait; 
	public final IGet get;
	public final IAssert asserts;
	public final IAction action;
	public final ILogging logger;
	public final WebDriver driver;
	public PageObject(Framework framework) {
		this.framework = framework;
		this.wait = framework.wait;
		this.get= framework.get;
		this.asserts = framework.asserter;
		this.action = framework.action;
		this.logger = framework.logger;
		this.driver = framework.driver;
		PageFactory.initElements(driver, this);
	}
}
