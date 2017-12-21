package keywords;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import data.ObjectDef;
import framework.Framework;
import framework.WaitKeyword;
import interfaces.ILogging;

public class UntilDropDownSelectedTextIs extends WaitKeyword {

	private final WebDriver driver;
	private final ILogging logger;
	private final long maxTime;
	private final WebElement element;
	private final String expectedText;
	private By locator = null;
	
	public UntilDropDownSelectedTextIs(WebDriver driver, WebElement element, String expectedText, ILogging logger, long maxWaitSeconds) {
		this.driver = driver;
		this.logger = logger;
		this.element = element;
		this.maxTime = maxWaitSeconds;
		this.expectedText = expectedText;
	}
	
	public UntilDropDownSelectedTextIs(WebDriver driver, By locator, String expectedText, ILogging logger, long maxWaitSeconds) {
		this.driver = driver;
		this.locator = locator;
		this.element = driver.findElement(locator);
		this.logger = logger;
		this.maxTime = maxWaitSeconds;
		this.expectedText = expectedText;
	}

	@Override
	public Boolean perform() {
		WebDriverWait wait = new WebDriverWait(driver, maxTime);
		Select select = new Select(element);
		Boolean b = null;
		try {
			b = wait.until(x -> select.getFirstSelectedOption().getText().equals(expectedText));
		}catch(TimeoutException e) {
			return false;
		}
		if(select.getFirstSelectedOption().isSelected() == false && expectedText != "") {
			return false;
		}
		return b;
	}

	@Override
	public void startLog() {
		logger.beginKeyword(this, locator, ";expectedText: "+expectedText);
	}

	@Override
	public void endLog() {
		logger.endKeyword(this);
	}

	@Override
	public WaitKeyword instantiateExternal(Framework framework, List<ObjectDef> defs, List<String> objects,
			List<String> params) {
		if(isBy(defs.get(0))) {
			return new UntilDropDownSelectedTextIs(framework.driver, castToBy(defs.get(0)), params.get(0), framework.logger, (long)Double.parseDouble(params.get(1)));
		} else {
			return new UntilDropDownSelectedTextIs(framework.driver, castToElem(defs.get(0)), params.get(0), framework.logger, (long)Double.parseDouble(params.get(1)));
		}
	}

}
