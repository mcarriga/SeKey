package keywords;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import data.ObjectDef;
import framework.ActionKeyword;
import framework.AfterAction;
import framework.Framework;
import interfaces.IAfterAction;
import interfaces.ILogging;
import interfaces.IWait;

public class SetText extends ActionKeyword {
	private final WebElement element;
	private final ILogging logger;
	private final String text;
	private final IWait wait;
	private By locator = null;
	
	public SetText(WebElement element, String text, ILogging logger, IWait wait) {
		this.element = element;
		this.logger = logger;
		this.text = text;
		this.wait = wait;
	}
	
	public SetText(WebDriver driver, By locator, String text, ILogging logger, IWait wait) {
		this(driver.findElement(locator), text, logger, wait);
	}

	@Override
	public IAfterAction guarantee() {
		return new AfterAction((ActionKeyword)build(), 2);
	}

	@Override
	public Void perform() {
		wait.untilElementClickable(element, 10);
		element.sendKeys(text);
		return null;
	}

	@Override
	public void startLog() {
		logger.beginKeyword(this, locator, "; Text: "+text);
	}

	@Override
	public void endLog() {
		logger.endKeyword(this);
	}

	@Override
	public ActionKeyword instantiateExternal(Framework framework, List<ObjectDef> defs, List<String> objects,
			List<String> params) {
		if(isBy(defs.get(0))) {
			return new SetText(framework.driver, castToBy(defs.get(0)), params.get(0), framework.logger, framework.wait);
		} else {
			return new SetText(castToElem(defs.get(0)), params.get(0), framework.logger, framework.wait);
		}
	}

}
