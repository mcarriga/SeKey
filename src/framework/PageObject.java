package framework;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import interfaces.IAction;
import interfaces.IAssert;
import interfaces.IGet;
import interfaces.ILogging;
import interfaces.IWait;

/**
 * Base Class for all Page Object classes to be used for the KeywordProvider and Project under test
 * @author Mathew Carrigan
 *
 */
public abstract class PageObject {
	public final KeywordProvider keywordProvider;
	public final IWait waits; 
	public final IGet gets;
	public final IAssert asserts;
	public final IAction actions;
	public final ILogging loggers;
	public final WebDriver driver;
	
	/**
	 * Initialized an instance of this class- Required and only constructor parameter is KeywordProvider
	 * @param keywordProvider KeywordProvider
	 */
	public PageObject(KeywordProvider keywordProvider) {
		this.keywordProvider = keywordProvider;
		this.waits = keywordProvider.waits;
		this.gets= keywordProvider.gets;
		this.asserts = keywordProvider.asserts;
		this.actions = keywordProvider.actions;
		this.loggers = keywordProvider.loggers;
		this.driver = keywordProvider.driver;
		PageFactory.initElements(driver, this);
	}
}
