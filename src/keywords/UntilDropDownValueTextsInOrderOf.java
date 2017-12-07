package keywords;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import interfaces.ILogging;

public class UntilDropDownValueTextsInOrderOf extends WaitKeyword {

	private final WebDriver driver;
	private final ILogging logger;
	private final long maxTime;
	private final WebElement element;
	private final List<String> items;
	private By locator = null;
	
	public UntilDropDownValueTextsInOrderOf(WebDriver driver, WebElement element, List<String> items, ILogging logger, long maxWaitSeconds) {
		this.driver = driver;
		this.logger = logger;
		this.element = element;
		this.maxTime = maxWaitSeconds;
		this.items = items;
	}
	
	public UntilDropDownValueTextsInOrderOf(WebDriver driver, By locator, List<String> items, ILogging logger, long maxWaitSeconds) {
		this.driver = driver;
		this.locator = locator;
		this.element = driver.findElement(locator);
		this.logger = logger;
		this.maxTime = maxWaitSeconds;
		this.items = items;
	}

	@Override
	public Boolean perform() {
		WebDriverWait wait = new WebDriverWait(driver, maxTime);
		Select select = new Select(element);
		List<WebElement> allElems;
		
		try {
			allElems = wait.until(x -> select.getAllSelectedOptions());
		}catch(TimeoutException e) {
			return false;
		}
		
		List<String> allElemStrings = new ArrayList<String>();
		
		for(WebElement e : allElems) {
			allElemStrings.add(e.getText());
		}
		
		return allElemStrings.equals(items);
	}

	@Override
	public void startLog() {
		String x = String.join(",", items);
		logger.beginKeyword(this, locator, ";Items: "+x);
	}

	@Override
	public void endLog() {
		logger.endKeyword(this);
	}
}
