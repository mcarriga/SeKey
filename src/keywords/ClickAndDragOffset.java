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

public class ClickAndDragOffset extends ActionKeyword {

	private final ILogging logger;
	private final IWait wait;
	private By sourceBy;
	private final WebDriver driver;
	private final WebElement sourceElem;
	private final int offsetX;
	private final int offsetY;
	
	
	public ClickAndDragOffset(WebDriver driver, By source, int offsetX, int offsetY, ILogging logger, IWait wait) {
		this(driver, driver.findElement(source), offsetX, offsetY, logger, wait);
	}
	
	public ClickAndDragOffset(WebDriver driver, WebElement source, int offsetX, int offsetY, ILogging logger, IWait wait) {
		this.sourceElem = source;
		this.offsetX = offsetX;
		this.offsetY = offsetY;
		this.driver = driver;
		this.logger = logger;
		this.wait = wait;
	}
	

	@Override
	public Void perform() {
		wait.untilElementClickable(sourceElem, 10);
		Actions builder = new Actions(driver);
		builder.dragAndDropBy(sourceElem, offsetX, offsetY).build().perform();
		return null;
	}

	@Override
	public void startLog() {
		logger.beginKeyword(this, sourceBy);
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
