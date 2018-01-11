package getKeywords;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import data.ObjectDef;
import framework.KeywordProvider;
import framework.GetKeyword;
import interfaces.ILogging;

public class IsVisible extends GetKeyword<Boolean> {
	private final WebElement _element;
	private final ILogging _logger;
	private By locator;
	
	public IsVisible(WebDriver driver, By locator, ILogging logger) {
		this(driver.findElement(locator), logger);
	}
	
	public IsVisible(WebElement element, ILogging logger) {
		this._logger = logger;
		this._element = element;
	}

	@Override
	public Boolean perform() {
		return _element.isDisplayed();
	}

	@Override
	public void startLog() {
		_logger.beginKeyword(this, locator);
	}

	@Override
	public void endLog() {
		_logger.endKeyword(this);
	}

	public static GetKeyword<?> instantiateExternal(KeywordProvider keywordProvider, List<ObjectDef> defs,
			List<String> params) {
		if(isBy(defs.get(0))) {
			return new IsVisible(keywordProvider.driver, castToBy(defs.get(0)), keywordProvider.loggers);
		} else {
			return new IsVisible(castToElem(defs.get(0)), keywordProvider.loggers);
		}
	}
}
