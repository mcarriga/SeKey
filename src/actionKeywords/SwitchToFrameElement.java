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

public class SwitchToFrameElement extends ActionKeyword {

	private final WebDriver driver;
	private final WebElement element;
	private final ILogging logger;
	private By locator;
	
	public SwitchToFrameElement(WebDriver driver, WebElement element, ILogging logger) {
		this.driver = driver;
		this.element = element;
		this.logger = logger;
	}
	
	public SwitchToFrameElement(WebDriver driver, By frame, ILogging logger) {
		this(driver, driver.findElement(frame), logger);
		this.locator = frame;
	}

	@Override
	public IAfterAction guarantee() {
		return new AfterAction((ActionKeyword)build(), 2);
	}

	@Override
	public Void perform() {
		driver.switchTo().frame(element);
		return null;
	}

	@Override
	public void startLog() {
		logger.beginKeyword(this, locator, "; Element: "+element.toString());
	}

	@Override
	public void endLog() {
		logger.endKeyword(this);
	}

	public static ActionKeyword instantiateExternal(KeywordProvider keywordProvider, List<ObjectDef> defs,
			List<String> params) {
		if(isBy(defs.get(0))) {
			return new SwitchToFrameElement(keywordProvider.driver, castToBy(defs.get(0)), keywordProvider.loggers);
		} else {
			return new SwitchToFrameElement(keywordProvider.driver, castToElem(defs.get(0)), keywordProvider.loggers);
		}
	}

}
