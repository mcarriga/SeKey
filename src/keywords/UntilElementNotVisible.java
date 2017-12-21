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

public class UntilElementNotVisible extends WaitKeyword {

	private final WebDriver driver;
	private final ILogging _logger;
	private final long _maxTime;
	private final WebElement _element;
	private By locator = null;
	
	public UntilElementNotVisible(WebDriver driver, WebElement element, ILogging logger, long maxWaitSeconds) {
		this.driver = driver;
		this._logger = logger;
		this._element = element;
		this._maxTime = maxWaitSeconds;
	}
	
	public UntilElementNotVisible(WebDriver driver, By locator, ILogging logger, long maxWaitSeconds) {
		this.driver = driver;
		this.locator = locator;
		this._element = driver.findElement(locator);
		this._logger = logger;
		this._maxTime = maxWaitSeconds;
	}
	
	@Override
	public Boolean perform() {
		WebDriverWait wait = new WebDriverWait(driver, _maxTime);
		try {
			if(locator != null) {
				return wait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
			}else {
				return wait.until(ExpectedConditions.invisibilityOf(_element));
			}
		}catch(TimeoutException e) {
			return false;
		}
	}

	@Override
	public void startLog() {
		_logger.beginKeyword(this, locator);
	}

	@Override
	public void endLog() {
		_logger.endKeyword(this);
	}

	@Override
	public WaitKeyword instantiateExternal(Framework framework, List<ObjectDef> defs, List<String> objects,
			List<String> params) {
		if(isBy(defs.get(0))) {
			return new UntilElementNotVisible(framework.driver, castToBy(defs.get(0)), framework.logger,  (long)Double.parseDouble(params.get(0)));
		} else {
			return new UntilElementNotVisible(framework.driver, castToElem(defs.get(0)), framework.logger,  (long)Double.parseDouble(params.get(0)));
		}
	}

}
