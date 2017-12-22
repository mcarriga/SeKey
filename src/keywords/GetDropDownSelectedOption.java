package keywords;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import data.ObjectDef;
import framework.Framework;
import framework.GetKeyword;
import interfaces.ILogging;

public class GetDropDownSelectedOption extends GetKeyword<String> {
	private final WebElement element;
	private final ILogging logger;
	private By locator;
	
	public GetDropDownSelectedOption(WebDriver driver, ILogging logger, By locator) {
		this(driver.findElement(locator), logger);
	}
	
	public GetDropDownSelectedOption(WebElement element, ILogging logger) {
		this.element = element;
		this.logger = logger;
	}

	@Override
	public String perform() {
		Select select = new Select(element);
		return select.getFirstSelectedOption().getText();
	}

	@Override
	public void startLog() {
		logger.beginKeyword(this, locator);
	}

	@Override
	public void endLog() {
		logger.endKeyword(this);
	}

	//@Override
	public static GetKeyword<String> instantiateExternal(Framework framework, List<ObjectDef> defs,
			List<String> params) {
		if(isBy(defs.get(0))) {
			return new GetDropDownSelectedOption(framework.driver, framework.logger, castToBy(defs.get(0)));
		} else {
			return new GetDropDownSelectedOption(castToElem(defs.get(0)), framework.logger);
		}
	}
}
