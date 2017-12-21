package keywords;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import data.ObjectDef;
import framework.Framework;
import framework.WaitKeyword;
import interfaces.ILogging;

public class UntilElementNotPresentBy extends WaitKeyword {
	private final WebDriver driver;
	private final ILogging _logger;
	private final long _maxTime;
	private final By _locator;
	
	public UntilElementNotPresentBy(WebDriver driver, By locator, ILogging logger, long maxWaitSeconds) {
		this.driver = driver;
		this._locator = locator;
		this._logger = logger;
		this._maxTime = maxWaitSeconds;
	}

	@Override
	public Boolean perform() {
		WebDriverWait wait = new WebDriverWait(driver, _maxTime);
		try {
			return wait.until(ExpectedConditions.invisibilityOfElementLocated(_locator));
		}catch(TimeoutException e) {
			return false;
		}
		
	}

	@Override
	public void startLog() {
		_logger.beginKeyword(this, _locator);
	}

	@Override
	public void endLog() {
		_logger.endKeyword(this);
	}

	public static WaitKeyword instantiateExternal(Framework framework, List<ObjectDef> defs,
			List<String> params) {
		return new UntilElementNotPresentBy(framework.driver, castToBy(defs.get(0)), framework.logger, (long)Double.parseDouble(params.get(0)));
	}

}
