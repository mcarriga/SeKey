package waitKeywords;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import data.ObjectDef;
import framework.KeywordProvider;
import framework.WaitKeyword;
import interfaces.ILogging;

public class UntilElementAttributeEquals extends WaitKeyword {

	private final WebDriver driver;
	private final ILogging logger;
	private final long maxTime;
	private final WebElement element;
	private final String expectedValue;
	private final String attrName;
	private By locator = null;
	
	public UntilElementAttributeEquals(WebDriver driver, WebElement element, String attrName, String expectedValue, ILogging logger, long maxWaitSeconds) {
		this.driver = driver;
		this.logger = logger;
		this.element = element;
		this.maxTime = maxWaitSeconds;
		this.expectedValue = expectedValue;
		this.attrName = attrName;
	}
	
	public UntilElementAttributeEquals(WebDriver driver, By locator, String attrName, String expectedValue, ILogging logger, long maxWaitSeconds) {
		this.driver = driver;
		this.locator = locator;
		this.element = driver.findElement(locator);
		this.logger = logger;
		this.maxTime = maxWaitSeconds;
		this.expectedValue = expectedValue;
		this.attrName = attrName;
	}

	@Override
	public Boolean perform() {
		WebDriverWait wait = new WebDriverWait(driver, maxTime);
		try {
			return wait.until(x -> element.getAttribute(attrName).equals(expectedValue));
		} catch(TimeoutException e) {
			return false;
		}
	}

	@Override
	public void startLog() {
		logger.beginKeyword(this, locator, "; attrName: "+attrName+"; expectedValue: "+expectedValue);
	}

	@Override
	public void endLog() {
		logger.endKeyword(this);
	}

	public static WaitKeyword instantiateExternal(KeywordProvider keywordProvider, List<ObjectDef> defs,
			List<String> params) {
		if(isBy(defs.get(0))) {
			return new UntilElementAttributeEquals(keywordProvider.driver, castToBy(defs.get(0)), params.get(0), params.get(1), keywordProvider.loggers, (long)Double.parseDouble(params.get(2)));
		} else {
			return new UntilElementAttributeEquals(keywordProvider.driver, castToElem(defs.get(0)), params.get(0), params.get(1), keywordProvider.loggers, (long)Double.parseDouble(params.get(2)));
		}
	}

}
