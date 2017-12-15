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

public class ClickAndDrag extends ActionKeyword {

	private final ILogging logger;
	private final IWait wait;
	private By sourceBy;
	private By targetBy;
	private final WebDriver driver;
	private final WebElement sourceElem;
	private final WebElement targetElem;
	
	
	public ClickAndDrag(WebDriver driver, By source, By target, ILogging logger, IWait wait) {
		this(driver, driver.findElement(source), driver.findElement(target), logger, wait);
	}
	
	public ClickAndDrag(WebDriver driver, WebElement source, By target, ILogging logger, IWait wait) {
		this(driver, source, driver.findElement(target), logger, wait);
	}
	
	public ClickAndDrag(WebDriver driver, WebElement source, WebElement target, ILogging logger, IWait wait) {
		this.driver = driver;
		this.sourceElem = source;
		this.targetElem = target;
		this.logger = logger;
		this.wait = wait; 
	}
	
	public ClickAndDrag(WebDriver driver, By source, WebElement target, ILogging logger, IWait wait) {
		this(driver, driver.findElement(source), target, logger, wait);
	}

	@Override
	public Void perform() {
		wait.untilElementClickable(sourceElem, 10);
		wait.untilElementClickable(targetElem, 10);
		Actions builder = new Actions(driver);
		builder.dragAndDrop(sourceElem, targetElem).build().perform();
		return null;
	}

	@Override
	public void startLog() {
		logger.beginKeyword(this, sourceBy, targetBy);
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
