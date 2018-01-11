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

public class SelectByText extends ActionKeyword {

	private final WebElement element;
	private final ILogging logger;
	private final IWait wait;
	private final String text;
	private By locator;
	
	public SelectByText(WebDriver driver, By locator, String text, ILogging logger, IWait wait) {
		this.locator = locator;
		this.element = driver.findElement(locator);
		this.text = text;
		this.logger = logger;
		this.wait = wait;
	}
	
	public SelectByText(WebElement element, String text, ILogging logger, IWait wait) {
		this.element = element;
		this.text = text;
		this.logger = logger;
		this.wait = wait;
	}

	@Override
	public Void perform() {
		wait.untilElementClickable(element, 10);
		Select select = new Select(element);
		select.selectByVisibleText(text);
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
	public IAfterAction guarantee() {
		return new AfterAction((ActionKeyword)build(), 2);
	}

	public static ActionKeyword instantiateExternal(KeywordProvider keywordProvider, List<ObjectDef> defs,
			List<String> params) {
		if(isBy(defs.get(0))) {
			return new SelectByText(keywordProvider.driver, castToBy(defs.get(0)), params.get(0), keywordProvider.loggers, keywordProvider.waits);
		} else {
			return new SelectByText(castToElem(defs.get(0)), params.get(0), keywordProvider.loggers, keywordProvider.waits);
		}
	}


}
