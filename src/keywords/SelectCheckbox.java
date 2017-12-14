package keywords;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import interfaces.IAfterAction;
import interfaces.ILogging;
import interfaces.IWait;

public class SelectCheckbox extends ActionKeyword {

	private final WebElement element;
	private final ILogging logger;
	private final IWait wait;
	private By locator;
	
	public SelectCheckbox(WebDriver driver, ILogging logger, IWait wait, By locator) {
		this.locator = locator;
		this.element = driver.findElement(locator);
		this.logger = logger;
		this.wait = wait;
	}
	
	public SelectCheckbox(WebElement element, ILogging logger, IWait wait) {
		this.element = element;
		this.logger = logger;
		this.wait = wait;
	}

	@Override
	public Void perform() {
		wait.untilElementClickable(element, 10);
		if(!element.isSelected()) {
			element.click();
		}
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
