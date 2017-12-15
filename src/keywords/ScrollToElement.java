package keywords;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import framework.ActionKeyword;
import framework.AfterAction;
import interfaces.IAfterAction;
import interfaces.ILogging;
import interfaces.IWait;

public class ScrollToElement extends ActionKeyword {

	private final WebElement element;
	private final ILogging logger;
	private final IWait wait;
	private final WebDriver driver;
	private By locator;
	
	public ScrollToElement(WebDriver driver, By locator, ILogging logger, IWait wait) {
		this(driver, driver.findElement(locator), logger, wait);
		this.locator = locator;
	}
	
	public ScrollToElement(WebDriver driver, WebElement element, ILogging logger, IWait wait) {
		this.driver = driver;
		this.element = element;
		this.logger = logger;
		this.wait = wait;
	}

	@Override
	public Void perform() {
		wait.untilElementClickable(element, 10);
		new ExecuteJavaScript<Void>(driver, logger, "arguments[0].scrollIntoView(true)", element).perform();
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
