package keywords;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import interfaces.ILogging;
import interfaces.IWait;

public class AssertElementSelected extends AssertKeyword {

	private final ILogging logger;
	private final IWait wait;
	private final long timeout;
	private final WebElement element;
	private By locator = null;
	
	public AssertElementSelected(WebDriver driver, ILogging logger, IWait wait, By locator, long timeoutSeconds) {
		this(driver.findElement(locator), logger, wait, timeoutSeconds);
	}
	
	public AssertElementSelected(WebElement element, ILogging logger, IWait wait, long timeoutSeconds) {
		this.element = element;
		this.logger = logger;
		this.wait = wait;
		this.timeout = timeoutSeconds;
	}

	@Override
	public Void perform() {
		wait.untilElementSelected(element, timeout).perform();
		StringBuilder builder = new StringBuilder();
		builder.append("Element is NOT Selected");
		if(locator !=null) builder.append("; By: "+locator);
		Assert.assertTrue(element.isSelected(), builder.toString());
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

}
