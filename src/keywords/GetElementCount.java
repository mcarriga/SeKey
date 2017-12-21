package keywords;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import data.ObjectDef;
import framework.Framework;
import framework.GetKeyword;
import interfaces.ILogging;

public class GetElementCount extends GetKeyword<Integer> {
	private final WebDriver driver;
	private final ILogging logger;
	private By locator;
	
	public GetElementCount(WebDriver driver, By locator, ILogging logger) {
		this.locator = locator;
		this.logger = logger;
		this.driver = driver;
	}

	@Override
	public Integer perform() {
		return driver.findElements(locator).size();
	}

	@Override
	public void startLog() {
		logger.beginKeyword(this, locator);
	}

	@Override
	public void endLog() {
		logger.endKeyword(this);
	}

	public static GetKeyword<?> instantiateExternal(Framework framework, List<ObjectDef> defs,List<String> params) {
		
		return new GetElementCount(framework.driver, castToBy(defs.get(0)), framework.logger);
	}

}
