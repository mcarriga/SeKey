package keywords;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import interfaces.IAfterAction;
import interfaces.ILogging;
import interfaces.IWait;

public class SelectRadioOptionByIndex extends ActionKeyword {

	private final WebElement element;
	private final ILogging logger;
	private final int index;
	private final IWait wait;
	private By locator = null;
	
	public SelectRadioOptionByIndex(WebElement element, int index, ILogging logger, IWait wait) {
		this.element = element;
		this.logger = logger;
		this.index = index;
		this.wait = wait;
	}
	
	public SelectRadioOptionByIndex(WebDriver driver, By locator, int index, ILogging logger, IWait wait) {
		this(driver.findElement(locator), index, logger, wait);
	}

	@Override
	public IAfterAction guarantee() {
		return new AfterAction((ActionKeyword)build(), 2);
	}

	@Override
	public Void perform() {
		wait.untilElementClickable(element, 10);
		element.findElement(By.xpath("(./input[@type='radio'])["+(index+1)+"]")).click();
		return null;
	}

	@Override
	public void startLog() {
		logger.beginKeyword(this, locator, "; Index: "+index);
	}

	@Override
	public void endLog() {
		logger.endKeyword(this);
	}
}
