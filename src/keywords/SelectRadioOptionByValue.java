package keywords;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import data.ObjectDef;
import framework.ActionKeyword;
import framework.AfterAction;
import framework.Framework;
import interfaces.IAfterAction;
import interfaces.ILogging;
import interfaces.IWait;

public class SelectRadioOptionByValue extends ActionKeyword {

	private final WebElement element;
	private final ILogging logger;
	private final String text;
	private final IWait wait;
	private By locator = null;
	
	public SelectRadioOptionByValue(WebElement element, String value, ILogging logger, IWait wait) {
		this.element = element;
		this.logger = logger;
		this.text = value;
		this.wait = wait;
	}
	
	public SelectRadioOptionByValue(WebDriver driver, By locator, String value, ILogging logger, IWait wait) {
		this(driver.findElement(locator), value, logger, wait);
	}

	@Override
	public IAfterAction guarantee() {
		return new AfterAction((ActionKeyword)build(), 2);
	}

	@Override
	public Void perform() {
		wait.untilElementClickable(element, 10);
		element.findElement(By.xpath("./input[@type='radio' and @value='"+text+"']")).click();
		return null;
	}

	@Override
	public void startLog() {
		logger.beginKeyword(this, locator, "; Value: "+text);
	}

	@Override
	public void endLog() {
		logger.endKeyword(this);
	}

	public static ActionKeyword instantiateExternal(Framework framework, List<ObjectDef> defs,
			List<String> params) {
		if(isBy(defs.get(0))) {
			return new SelectRadioOptionByValue(framework.driver, castToBy(defs.get(0)), params.get(0), framework.logger, framework.wait);
		} else {
			return new SelectRadioOptionByValue(castToElem(defs.get(0)), params.get(0), framework.logger, framework.wait);
		}
	}


}
