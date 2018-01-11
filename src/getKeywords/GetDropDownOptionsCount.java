package getKeywords;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import data.ObjectDef;
import framework.KeywordProvider;
import framework.GetKeyword;
import interfaces.ILogging;

public class GetDropDownOptionsCount extends GetKeyword<Integer> {
	private final WebElement element;
	private final ILogging logger;
	private By locator;
	
	public GetDropDownOptionsCount(WebDriver driver, ILogging logger, By locator) {
		this(driver.findElement(locator), logger);
	}
	
	public GetDropDownOptionsCount(WebElement element, ILogging logger) {
		this.element = element;
		this.logger = logger;
	}

	@Override
	public Integer perform() {
		Select select = new Select(element);
		return select.getOptions().size();
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
	public static GetKeyword<Integer> instantiateExternal(KeywordProvider keywordProvider, List<ObjectDef> defs,
			List<String> params) {
		if(isBy(defs.get(0))) {
			return new GetDropDownOptionsCount(keywordProvider.driver, keywordProvider.loggers, castToBy(defs.get(0)));
		} else {
			return new GetDropDownOptionsCount(castToElem(defs.get(0)), keywordProvider.loggers);
		}
	}

}
