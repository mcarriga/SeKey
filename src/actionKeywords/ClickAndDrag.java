package actionKeywords;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import data.ObjectDef;
import framework.ActionKeyword;
import framework.AfterAction;
import framework.KeywordProvider;
import interfaces.IAfterAction;
import interfaces.ILogging;
import interfaces.IWait;

public class ClickAndDrag extends ActionKeyword {

	private final ILogging logger;
	private final IWait wait;
	private By sourceBy;
	private By targetBy;
	private final WebDriver driver;
	private final WebElement sourceElem;
	private final WebElement targetElem;
	
	
	public ClickAndDrag(WebDriver driver, By source, By target, ILogging logger, IWait wait) {
		this(driver, driver.findElement(source), driver.findElement(target), logger, wait);
	}
	
	public ClickAndDrag(WebDriver driver, WebElement source, By target, ILogging logger, IWait wait) {
		this(driver, source, driver.findElement(target), logger, wait);
	}
	
	public ClickAndDrag(WebDriver driver, WebElement source, WebElement target, ILogging logger, IWait wait) {
		this.driver = driver;
		this.sourceElem = source;
		this.targetElem = target;
		this.logger = logger;
		this.wait = wait; 
	}
	
	public ClickAndDrag(WebDriver driver, By source, WebElement target, ILogging logger, IWait wait) {
		this(driver, driver.findElement(source), target, logger, wait);
	}

	@Override
	public Void perform() {
		wait.untilElementClickable(sourceElem, 10);
		wait.untilElementClickable(targetElem, 10);
		Actions builder = new Actions(driver);
		builder.dragAndDrop(sourceElem, targetElem).build().perform();
		return null;
	}

	@Override
	public void startLog() {
		logger.beginKeyword(this, sourceBy, targetBy);
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
		if (isBy(defs.get(0)) && isBy(defs.get(1))) { // By, By
			return new ClickAndDrag(keywordProvider.driver, castToBy(defs.get(0)), castToBy(defs.get(1)), keywordProvider.loggers, keywordProvider.waits);
			
		} else if (isBy(defs.get(0)) && isElem(defs.get(1))) { // By, WebElement
			return new ClickAndDrag(keywordProvider.driver, castToBy(defs.get(0)), castToElem(defs.get(1)), keywordProvider.loggers, keywordProvider.waits);
			
		} else if (isElem(defs.get(0)) && isBy(defs.get(1))) { // WebElement, By
			return new ClickAndDrag(keywordProvider.driver, castToElem(defs.get(0)), castToBy(defs.get(1)), keywordProvider.loggers, keywordProvider.waits);
			
		} else { // WebElement, WebElement
			return new ClickAndDrag(keywordProvider.driver, castToElem(defs.get(0)), castToElem(defs.get(1)), keywordProvider.loggers, keywordProvider.waits);
			
		}
	}

}
