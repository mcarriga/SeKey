package keywords;

import java.util.List;

import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import data.ObjectDef;
import framework.Framework;
import framework.WaitKeyword;
import interfaces.ILogging;

public class UntilElementNotPresent extends WaitKeyword {
	private final WebDriver driver;
	private final ILogging _logger;
	private final long _maxTime;
	private final WebElement _element;
	
	public UntilElementNotPresent(WebDriver driver, WebElement element, ILogging logger, long maxWaitSeconds) {
		this.driver = driver;
		this._logger = logger;
		this._element = element;
		this._maxTime = maxWaitSeconds;
	}

	@Override
	public Boolean perform() {
		WebDriverWait wait = new WebDriverWait(driver, _maxTime);
		try {
			return wait.until(ExpectedConditions.invisibilityOf(_element));
		} catch(TimeoutException e) {
			return false;
		}
	}

	@Override
	public void startLog() {
		_logger.beginKeyword(this);
	}

	@Override
	public void endLog() {
		_logger.endKeyword(this);
	}

	public static WaitKeyword instantiateExternal(Framework framework, List<ObjectDef> defs,
			List<String> params) {
		return new UntilElementNotPresent(framework.driver, castToElem(defs.get(0)), framework.logger, (long)Double.parseDouble(params.get(0)));
	}

}
