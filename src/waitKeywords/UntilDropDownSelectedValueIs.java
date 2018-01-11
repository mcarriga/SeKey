package waitKeywords;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import data.ObjectDef;
import framework.KeywordProvider;
import framework.WaitKeyword;
import interfaces.ILogging;

public class UntilDropDownSelectedValueIs extends WaitKeyword {

	private final WebDriver driver;
	private final ILogging logger;
	private final long maxTime;
	private final WebElement element;
	private final String expectedText;
	private By locator = null;
	
	public UntilDropDownSelectedValueIs(WebDriver driver, WebElement element, String expectedValue, ILogging logger, long maxWaitSeconds) {
		this.driver = driver;
		this.logger = logger;
		this.element = element;
		this.maxTime = maxWaitSeconds;
		this.expectedText = expectedValue;
	}
	
	public UntilDropDownSelectedValueIs(WebDriver driver, By locator, String expectedValue, ILogging logger, long maxWaitSeconds) {
		this.driver = driver;
		this.locator = locator;
		this.element = driver.findElement(locator);
		this.logger = logger;
		this.maxTime = maxWaitSeconds;
		this.expectedText = expectedValue;
	}

	@Override
	public Boolean perform() {
		WebDriverWait wait = new WebDriverWait(driver, maxTime);
		Select select = new Select(element);
		try {
			return wait.until(x -> select.getFirstSelectedOption().getAttribute("value").equals(expectedText));
		}catch(TimeoutException e) {
			return false;
		}
	}

	@Override
	public void startLog() {
		logger.beginKeyword(this, locator, ";expectedValue: "+expectedText);
	}

	@Override
	public void endLog() {
		logger.endKeyword(this);
	}

	public static WaitKeyword instantiateExternal(KeywordProvider keywordProvider, List<ObjectDef> defs,
			List<String> params) {
		if(isBy(defs.get(0))) {
			return new UntilDropDownSelectedValueIs(keywordProvider.driver, castToBy(defs.get(0)), params.get(0), keywordProvider.loggers, (long)Double.parseDouble(params.get(1)));
		} else {
			return new UntilDropDownSelectedValueIs(keywordProvider.driver, castToElem(defs.get(0)), params.get(0), keywordProvider.loggers, (long)Double.parseDouble(params.get(1)));
		}
	}
}
