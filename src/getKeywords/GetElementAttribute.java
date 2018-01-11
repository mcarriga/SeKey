package getKeywords;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import data.ObjectDef;
import framework.KeywordProvider;
import framework.GetKeyword;
import interfaces.ILogging;

public class GetElementAttribute extends GetKeyword<String> {

	private final WebElement _element;
	private final ILogging _logger;
	private final String attrName;
	private By locator;
	
	public GetElementAttribute(WebDriver driver, By locator, String attrName, ILogging logger) {
		this(driver.findElement(locator), attrName, logger);
	}
	
	public GetElementAttribute(WebElement element, String attrName, ILogging logger) {
		this._logger = logger;
		this._element = element;
		this.attrName = attrName;
	}

	@Override
	public String perform() {
		return _element.getAttribute(attrName);
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
			return new GetElementAttribute(keywordProvider.driver, castToBy(defs.get(0)), params.get(0), keywordProvider.loggers);
		} else {
			return new GetElementAttribute(castToElem(defs.get(0)), params.get(0), keywordProvider.loggers);
		}
	}

}
