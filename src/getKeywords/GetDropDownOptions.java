package getKeywords;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import data.ObjectDef;
import framework.KeywordProvider;
import framework.GetKeyword;
import interfaces.ILogging;

public class GetDropDownOptions extends GetKeyword<List<String>> {
	private final WebElement element;
	private final ILogging logger;
	private By locator;
	
	public GetDropDownOptions(WebDriver driver, ILogging logger, By locator) {
		this(driver.findElement(locator), logger);
	}
	
	public GetDropDownOptions(WebElement element, ILogging logger) {
		this.element = element;
		this.logger = logger;
	}

	@Override
	public List<String> perform() {
		Select select = new Select(element);
		List<WebElement> all = select.getOptions();
		
		List<String> ops = new ArrayList<String>();
		for(WebElement el : all) {
			ops.add(el.getText());
		}
		return ops;
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
	public static GetKeyword<List<String>> instantiateExternal(KeywordProvider keywordProvider, List<ObjectDef> defs,
			List<String> params) {
		if(isBy(defs.get(0))) {
			return new GetDropDownOptions(keywordProvider.driver, keywordProvider.loggers, castToBy(defs.get(0)));
		} else {
			return new GetDropDownOptions(castToElem(defs.get(0)), keywordProvider.loggers);
		}
	}

}
