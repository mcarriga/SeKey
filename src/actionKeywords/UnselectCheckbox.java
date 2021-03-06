package actionKeywords;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import data.ObjectDef;
import framework.ActionKeyword;
import framework.AfterAction;
import framework.KeywordProvider;
import interfaces.IAfterAction;
import interfaces.ILogging;
import interfaces.IWait;

public class UnselectCheckbox extends ActionKeyword {

	private final WebElement element;
	private final ILogging logger;
	private final IWait wait;
	private By locator;
	
	public UnselectCheckbox(WebDriver driver, ILogging logger, IWait wait, By locator) {
		this.locator = locator;
		this.element = driver.findElement(locator);
		this.logger = logger;
		this.wait = wait;
	}
	
	public UnselectCheckbox(WebElement element, ILogging logger, IWait wait) {
		this.element = element;
		this.logger = logger;
		this.wait = wait;
	}

	@Override
	public Void perform() {
		wait.untilElementClickable(element, 10);
		if(element.isSelected()) {
			element.click();
		}
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

	public static ActionKeyword instantiateExternal(KeywordProvider keywordProvider, List<ObjectDef> defs,
			List<String> params) {
		if(isBy(defs.get(0))) {
			return new UnselectCheckbox(keywordProvider.driver, keywordProvider.loggers, keywordProvider.waits, castToBy(defs.get(0)));
		} else {
			return new UnselectCheckbox(castToElem(defs.get(0)), keywordProvider.loggers, keywordProvider.waits);
		}
	}

}
