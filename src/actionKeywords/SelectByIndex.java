package actionKeywords;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import data.ObjectDef;
import framework.ActionKeyword;
import framework.AfterAction;
import framework.KeywordProvider;
import interfaces.IAfterAction;
import interfaces.ILogging;
import interfaces.IWait;

public class SelectByIndex extends ActionKeyword {

	private final WebElement element;
	private final ILogging logger;
	private final IWait wait;
	private final int index;
	private By locator;
	
	public SelectByIndex(WebDriver driver, By locator, int index, ILogging logger, IWait wait) {
		this.locator = locator;
		this.element = driver.findElement(locator);
		this.index = index;
		this.logger = logger;
		this.wait = wait;
	}
	
	public SelectByIndex(WebElement element, int index, ILogging logger, IWait wait) {
		this.element = element;
		this.index = index;
		this.logger = logger;
		this.wait = wait;
	}

	@Override
	public Void perform() {
		wait.untilElementClickable(element, 10);
		Select select = new Select(element);
		select.selectByIndex(index);
		return null;
	}

	@Override
	public void startLog() {
		logger.beginKeyword(this, locator, "; Inex: "+index);
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
			return new SelectByIndex(keywordProvider.driver, castToBy(defs.get(0)), (int)Double.parseDouble(params.get(0)), keywordProvider.loggers, keywordProvider.waits);
		} else {
			return new SelectByIndex(castToElem(defs.get(0)), (int)Double.parseDouble(params.get(0)), keywordProvider.loggers, keywordProvider.waits);
		}
	}

}
