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

public class UntilPresenceOfNestedElement extends WaitKeyword {

	private final ILogging logger;
	private final long maxTime;
	private final WebDriver driver;
	private final By child;
	private WebElement element = null;
	private By parent = null;
	
	public UntilPresenceOfNestedElement(WebDriver driver, By parent, By childLocator, ILogging logger, long maxWaitSeconds) {
		this.child = childLocator;
		this.parent = parent;
		this.logger = logger;
		this.maxTime = maxWaitSeconds;
		this.driver = driver;
	}
	
	public UntilPresenceOfNestedElement(WebDriver driver, WebElement element, By childLocator, ILogging logger, long maxWaitSeconds) {
		this.child = childLocator;
		this.element = element;
		this.logger = logger;
		this.maxTime = maxWaitSeconds;
		this.driver = driver;
	}

	@Override
	public Boolean perform() {
		WebDriverWait wait = new WebDriverWait(driver, maxTime);
		@SuppressWarnings("unused")
		WebElement all = null;
		try {
			if(parent != null) {
				all = wait.until(ExpectedConditions.presenceOfNestedElementLocatedBy(parent, child));
			} else {
				all = wait.until(ExpectedConditions.presenceOfNestedElementLocatedBy(element, child));
			}
			
			if(all != null) {
				return true;
			} else {
				return false;
			}
		} catch(TimeoutException e){
			return false;
		}
	}

	@Override
	public void startLog() {
		logger.beginKeyword(this, child);
	}

	@Override
	public void endLog() {
		logger.endKeyword(this);
	}

	public static WaitKeyword instantiateExternal(Framework framework, List<ObjectDef> defs,
			List<String> params) {
		if(isBy(defs.get(0))) {
			return new UntilPresenceOfNestedElement(framework.driver, castToBy(defs.get(0)), castToBy(defs.get(1)), framework.logger, (long)Double.parseDouble(params.get(1)));
		} else {
			return new UntilPresenceOfNestedElement(framework.driver, castToElem(defs.get(0)), castToBy(defs.get(1)), framework.logger, (long)Double.parseDouble(params.get(1)));
		}
	}
}
