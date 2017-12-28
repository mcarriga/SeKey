package getKeywords;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import data.ObjectDef;
import framework.Framework;
import framework.GetKeyword;
import interfaces.ILogging;

public class IsEnabled extends GetKeyword<Boolean> {
	private final WebElement _element;
	private final ILogging _logger;
	private By locator;
	
	public IsEnabled(WebDriver driver, By locator, ILogging logger) {
		this(driver.findElement(locator), logger);
	}
	
	public IsEnabled(WebElement element, ILogging logger) {
		this._logger = logger;
		this._element = element;
	}

	@Override
	public Boolean perform() {
		return _element.isEnabled();
	}

	@Override
	public void startLog() {
		_logger.beginKeyword(this, locator);
	}

	@Override
	public void endLog() {
		_logger.endKeyword(this);
	}

	public static GetKeyword<?> instantiateExternal(Framework framework, List<ObjectDef> defs,
			List<String> params) {
		if(isBy(defs.get(0))) {
			return new IsEnabled(framework.driver, castToBy(defs.get(0)), framework.logger);
		} else {
			return new IsEnabled(castToElem(defs.get(0)), framework.logger);
		}
	}
}
