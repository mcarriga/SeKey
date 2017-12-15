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

public class Hover extends ActionKeyword {

	private final WebElement element;
	private final ILogging logger;
	private final IWait wait;
	private final long seconds;
	private final WebDriver driver;
	private By locator;
	
	public Hover(WebDriver driver, By locator, long seconds, ILogging logger, IWait wait) {
		this.driver = driver;
		this.locator = locator;
		this.element = driver.findElement(locator);
		this.seconds = seconds;
		this.logger = logger;
		this.wait = wait;
	}
	
	public Hover(WebDriver driver, WebElement element, long seconds, ILogging logger, IWait wait) {
		this.driver = driver;
		this.element = element;
		this.seconds = seconds;
		this.logger = logger;
		this.wait = wait;
	}

	@Override
	public Void perform() {
		wait.untilElementClickable(element, 10);
		Actions builder = new Actions(driver);
		builder.moveToElement(element).pause(seconds).build().perform();
		return null;
	}

	@Override
	public void startLog() {
		logger.beginKeyword(this, locator, "; Hover time in Seconds: "+seconds);
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
