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

public class UntilDropDownContainsOption extends WaitKeyword {

	private final WebDriver driver;
	private final ILogging logger;
	private final long maxTime;
	private final WebElement element;
	private final String itemText;
	private By locator = null;
	
	public UntilDropDownContainsOption(WebDriver driver, WebElement element, String itemText, ILogging logger, long maxWaitSeconds) {
		this.driver = driver;
		this.logger = logger;
		this.element = element;
		this.maxTime = maxWaitSeconds;
		this.itemText = itemText;
	}
	
	public UntilDropDownContainsOption(WebDriver driver, By locator, String itemText, ILogging logger, long maxWaitSeconds) {
		this.driver = driver;
		this.locator = locator;
		this.element = driver.findElement(locator);
		this.logger = logger;
		this.maxTime = maxWaitSeconds;
		this.itemText = itemText;
	}

	@Override
	public Boolean perform() {
		WebDriverWait wait = new WebDriverWait(driver, maxTime);
		Select select = new Select(element);
		try {
			return wait.until(x -> select.getAllSelectedOptions().removeIf(b -> b.getText().equals(itemText)));
		}catch(TimeoutException e) {
			return false;
		}
	}

	@Override
	public void startLog() {
		logger.beginKeyword(this, locator, ";itemText: "+itemText);
	}

	@Override
	public void endLog() {
		logger.endKeyword(this);
	}

	public static WaitKeyword instantiateExternal(Framework framework, List<ObjectDef> defs,
			List<String> params) {
		if(isBy(defs.get(0))) {
			return new UntilDropDownContainsOption(framework.driver, castToBy(defs.get(0)), params.get(0), framework.logger, (long)Double.parseDouble(params.get(1)));
		} else {
			return new UntilDropDownContainsOption(framework.driver, castToElem(defs.get(0)), params.get(0), framework.logger, (long)Double.parseDouble(params.get(1)));
		}
	}
}
