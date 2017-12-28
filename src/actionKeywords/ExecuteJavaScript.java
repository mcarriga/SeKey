package actionKeywords;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;

import data.ObjectDef;
import framework.ActionKeyword;
import framework.Framework;
import interfaces.IAfterAction;
import interfaces.ILogging;

public class ExecuteJavaScript<T extends Object> extends ActionKeyword {
	private final WebDriver driver;
	private final String js;
	private final ILogging logger;
	private Object[] args = null;
	
	public ExecuteJavaScript(WebDriver driver, ILogging logger, String js) {
		this.logger = logger;
		this.args = null;
		this.driver = driver;
		this.js = js;
	}
	
	public ExecuteJavaScript(WebDriver driver, ILogging logger, String js, Object... args) {
		this.logger = logger;
		this.args = args;
		this.driver = driver;
		this.js = js;
	}

	@Override
	public IAfterAction guarantee() {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public T perform() {
		JavascriptExecutor JS = (JavascriptExecutor)driver;
		if(args != null) {
			return (T)JS.executeScript(js, args);
		} else {
			return (T)JS.executeScript(js);	
		}
	}

	@Override
	public void startLog() {
		logger.beginKeyword(this);
	}

	@Override
	public void endLog() {
		logger.endKeyword(this);
	}

	public static ActionKeyword instantiateExternal(Framework framework, List<ObjectDef> defs,
			List<String> params) {
		// TODO Auto-generated method stub
		return null;
	}
}
