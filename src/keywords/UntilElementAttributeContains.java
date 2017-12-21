package keywords;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import data.ObjectDef;
import framework.Framework;
import framework.WaitKeyword;
import interfaces.ILogging;

public class UntilElementAttributeContains extends WaitKeyword {

	private final WebDriver driver;
	private final ILogging logger;
	private final long maxTime;
	private final WebElement element;
	private final String expectedValue;
	private final String attrName;
	private By locator = null;
	
	public UntilElementAttributeContains(WebDriver driver, WebElement element, String attrName, String expectedValue, ILogging logger, long maxWaitSeconds) {
		this.driver = driver;
		this.logger = logger;
		this.element = element;
		this.maxTime = maxWaitSeconds;
		this.expectedValue = expectedValue;
		this.attrName = attrName;
	}
	
	public UntilElementAttributeContains(WebDriver driver, By locator, String attrName, String expectedValue, ILogging logger, long maxWaitSeconds) {
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
			if(locator != null) {
				return wait.until(ExpectedConditions.textToBePresentInElementValue(locator, expectedValue));
			} else {
				return wait.until(ExpectedConditions.textToBePresentInElementValue(element, expectedValue));
			}
		}catch(TimeoutException e) {
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

	public static WaitKeyword instantiateExternal(Framework framework, List<ObjectDef> defs,
			List<String> params) {
		if(isBy(defs.get(0))) {
			return new UntilElementAttributeContains(framework.driver, castToBy(defs.get(0)), params.get(0), params.get(1), framework.logger, (long)Double.parseDouble(params.get(2)));
		} else {
			return new UntilElementAttributeContains(framework.driver, castToElem(defs.get(0)), params.get(0), params.get(1), framework.logger, (long)Double.parseDouble(params.get(2)));
		}
	}

}
