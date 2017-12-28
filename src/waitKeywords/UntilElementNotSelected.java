package waitKeywords;

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

public class UntilElementNotSelected extends WaitKeyword {

	private final WebElement element;
	private final ILogging logger;
	private final long maxTime;
	private final WebDriver driver;
	private By locator;
	
	public UntilElementNotSelected(WebDriver driver, By locator, ILogging logger, long maxWaitSeconds) {
		this.locator = locator;
		this.element = driver.findElement(locator);
		this.logger = logger;
		this.maxTime = maxWaitSeconds;
		this.driver = driver;
	}
	
	public UntilElementNotSelected(WebDriver driver, WebElement element, ILogging logger, long maxWaitSeconds) {
		this.element = element;
		this.logger = logger;
		this.maxTime = maxWaitSeconds;
		this.driver = driver;
	}

	@Override
	public Boolean perform() {
		WebDriverWait wait = new WebDriverWait(driver, maxTime);
		try {
			if(locator != null) {
				return wait.until(ExpectedConditions.elementSelectionStateToBe(locator, false));
			} else {
				return wait.until(ExpectedConditions.elementSelectionStateToBe(element, false));
			}
		}catch(TimeoutException e) {
			return false;
		}
	}

	@Override
	public void startLog() {
		logger.beginKeyword(this, locator);
	}

	@Override
	public void endLog() {
		logger.endKeyword(this);
	}

	public static WaitKeyword instantiateExternal(Framework framework, List<ObjectDef> defs,
			List<String> params) {
		if(isBy(defs.get(0))) {
			return new UntilElementNotSelected(framework.driver, castToBy(defs.get(0)), framework.logger,  (long)Double.parseDouble(params.get(0)));
		} else {
			return new UntilElementNotSelected(framework.driver, castToElem(defs.get(0)), framework.logger,  (long)Double.parseDouble(params.get(0)));
		}
	}
}
