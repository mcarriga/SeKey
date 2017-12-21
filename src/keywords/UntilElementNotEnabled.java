package keywords;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

import data.ObjectDef;
import framework.Framework;
import framework.WaitKeyword;
import interfaces.ILogging;

public class UntilElementNotEnabled extends WaitKeyword {

	private final WebDriver driver;
	private final ILogging logger;
	private final long maxTime;
	private final WebElement element;
	private By locator = null;
	
	public UntilElementNotEnabled(WebDriver driver, WebElement element, ILogging logger, long maxWaitSeconds) {
		this.driver = driver;
		this.logger = logger;
		this.element = element;
		this.maxTime = maxWaitSeconds;
	}
	
	public UntilElementNotEnabled(WebDriver driver, By locator, ILogging logger, long maxWaitSeconds) {
		this.driver = driver;
		this.locator = locator;
		this.element = driver.findElement(locator);
		this.logger = logger;
		this.maxTime = maxWaitSeconds;
	}
	
	@Override
	public Boolean perform() {
		WebDriverWait wait = new WebDriverWait(driver, maxTime);
		try {
			return  wait.until(x -> element.isEnabled()).equals(false);
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
			return new UntilElementNotEnabled(framework.driver, castToBy(defs.get(0)), framework.logger,  (long)Double.parseDouble(params.get(0)));
		} else {
			return new UntilElementNotEnabled(framework.driver, castToElem(defs.get(0)), framework.logger,  (long)Double.parseDouble(params.get(0)));
		}
	}

}
