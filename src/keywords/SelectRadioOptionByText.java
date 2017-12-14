package keywords;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import interfaces.IAfterAction;
import interfaces.ILogging;
import interfaces.IWait;

public class SelectRadioOptionByText extends ActionKeyword {

	private final WebElement element;
	private final ILogging logger;
	private final String text;
	private final IWait wait;
	private By locator = null;
	
	public SelectRadioOptionByText(WebElement element, String text, ILogging logger, IWait wait) {
		this.element = element;
		this.logger = logger;
		this.text = text;
		this.wait = wait;
	}
	
	public SelectRadioOptionByText(WebDriver driver, By locator, String text, ILogging logger, IWait wait) {
		this(driver.findElement(locator), text, logger, wait);
	}

	@Override
	public IAfterAction guarantee() {
		return new AfterAction((ActionKeyword)build(), 2);
	}

	@Override
	public Void perform() {
		wait.untilElementClickable(element, 10);
		element.findElement(By.xpath("./input[@type='radio' and contains(text(), '"+text+"')]")).click();
		return null;
	}

	@Override
	public void startLog() {
		logger.beginKeyword(this, locator, "; Text: "+text);
	}

	@Override
	public void endLog() {
		logger.endKeyword(this);
	}

}
