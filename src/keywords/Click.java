package keywords;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import framework.ActionKeyword;
import framework.AfterAction;
import interfaces.IAfterAction;
import interfaces.ILogging;
import interfaces.IWait;

public class Click extends ActionKeyword {
	private final WebElement element;
	private final ILogging logger;
	private final IWait wait;
	private By locator;
	
	public Click(WebDriver driver, ILogging logger, IWait wait, By locator) {
		this.locator = locator;
		this.element = driver.findElement(locator);
		this.logger = logger;
		this.wait = wait;
	}
	
	public Click(WebElement element, ILogging logger, IWait wait) {
		this.element = element;
		this.logger = logger;
		this.wait = wait;
	}

	@Override
	public Void perform() {
		wait.untilElementClickable(element, 10);
		element.click();
		return null;
	}

	@Override
	public void startLog() {
		logger.beginKeyword(this, locator);
	}

	@Override
	public void endLog() {
		logger.endKeyword(this);
	}

	@Override
	public IAfterAction guarantee() {
		return new AfterAction((ActionKeyword)build(), 2);
	}

}
