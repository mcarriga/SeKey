package keywords;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import interfaces.ILogging;

public class UntilDropDownCountainsValueText extends WaitKeyword {

	private final WebDriver driver;
	private final ILogging logger;
	private final long maxTime;
	private final WebElement element;
	private final String itemText;
	private By locator = null;
	
	public UntilDropDownCountainsValueText(WebDriver driver, WebElement element, String itemText, ILogging logger, long maxWaitSeconds) {
		this.driver = driver;
		this.logger = logger;
		this.element = element;
		this.maxTime = maxWaitSeconds;
		this.itemText = itemText;
	}
	
	public UntilDropDownCountainsValueText(WebDriver driver, By locator, String itemText, ILogging logger, long maxWaitSeconds) {
		this.driver = driver;
		this.locator = locator;
		this.element = driver.findElement(locator);
		this.logger = logger;
		this.maxTime = maxWaitSeconds;
		this.itemText = itemText;
	}

	@Override
	public Boolean perform() {
		WebDriverWait wait = new WebDriverWait(driver, maxTime);
		Select select = new Select(element);
		return wait.until(x -> select.getAllSelectedOptions().removeIf(b -> b.getText().equals(itemText)));
	}

	@Override
	public void startLog() {
		logger.beginKeyword(this, locator, ";itemText: "+itemText);
	}

	@Override
	public void endLog() {
		logger.endKeyword(this);
	}
}
