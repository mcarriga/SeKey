package actionKeywords;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import data.ObjectDef;
import framework.ActionKeyword;
import framework.AfterAction;
import framework.Framework;
import interfaces.IAfterAction;
import interfaces.ILogging;
import interfaces.IWait;

public class JsClick extends ActionKeyword
{
private final WebElement element;
	private final ILogging logger;
	private final IWait wait;
	private final WebDriver driver;
	private By locator;
	
	public JsClick(WebDriver driver, ILogging logger, IWait wait, By locator) {
		this(driver, driver.findElement(locator), logger, wait);
		this.locator = locator;
	}
	
	public JsClick(WebDriver driver, WebElement element, ILogging logger, IWait wait) {
		this.driver = driver;
		this.element = element;
		this.logger = logger;
		this.wait = wait;
	}

	@Override
	public Void perform() {
		wait.untilElementClickable(element, 10);
		JavascriptExecutor executor = (JavascriptExecutor)driver;
		executor.executeScript("arguments[0].click();", element);
		return null;
	}

	@Override
	public void startLog() {
		logger.beginKeyword(this, locator);
	}

	@Override
	public void endLog() {
		logger.endKeyword(this);
	}

	@Override
	public IAfterAction guarantee() {
		return new AfterAction((ActionKeyword)build(), 2);
	}

	//@Override
	public static ActionKeyword instantiateExternal(Framework framework, List<ObjectDef> defs,
			List<String> params) {
		if(isBy(defs.get(0))) {
			return new Click(framework.driver, framework.logger, framework.wait, castToBy(defs.get(0)));
		} else {
			return new Click(castToElem(defs.get(0)), framework.logger, framework.wait);
		}
	}

}
