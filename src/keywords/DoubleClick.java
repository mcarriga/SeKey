package keywords;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

import framework.ActionKeyword;
import framework.AfterAction;
import interfaces.IAfterAction;
import interfaces.ILogging;
import interfaces.IWait;

public class DoubleClick extends ActionKeyword {

	private final WebElement element;
	private final ILogging logger;
	private final IWait wait;
	private final WebDriver driver;
	private By locator;
	
	public DoubleClick(WebDriver driver, ILogging logger, IWait wait, By locator) {
		this.driver = driver;
		this.locator = locator;
		this.element = driver.findElement(locator);
		this.logger = logger;
		this.wait = wait;
	}
	
	public DoubleClick(WebDriver driver, WebElement element, ILogging logger, IWait wait) {
		this.driver = driver;
		this.element = element;
		this.logger = logger;
		this.wait = wait;
	}

	@Override
	public Void perform() {
		wait.untilElementClickable(element, 10);
		Actions builder = new Actions(driver);
		builder.doubleClick(element).perform();
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
