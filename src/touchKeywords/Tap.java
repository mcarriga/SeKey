package touchKeywords;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.TapOptions;
import io.appium.java_client.touch.offset.ElementOption;
import framework.TouchKeyword;
import interfaces.ILogging;

public class Tap extends TouchKeyword
{
	private final AppiumDriver<?> driver;
	private final WebElement element;
	private final ILogging logger;
	private By locator;
	private Integer xCoord = null;
	private Integer yCoord = null;
	
	public Tap(AppiumDriver<?> driver, WebElement element, ILogging logger)
	{
		this.driver = driver;
		this.element = element;
		this.logger = logger;
	}
	
	public Tap(AppiumDriver<?> driver, By locator, ILogging logger) {
		this(driver, driver.findElement(locator), logger);
		this.locator = locator;
	}
	
	public Tap(AppiumDriver<?> driver, WebElement element, int xOffset, int yOffset, ILogging logger)
	{
		this(driver, element, logger);
		this.xCoord = xOffset;
		this.yCoord = yOffset;
	}
	
	public Tap(AppiumDriver<?> driver, By locator, int xOffset, int yOffset, ILogging logger) {
		this(driver, driver.findElement(locator), xOffset, yOffset, logger);
		this.locator = locator;
	}

	@Override
	public TouchAction<?> perform()
	{
		if(xCoord != null && yCoord != null) {
			return new TouchAction<>(driver).tap(new TapOptions().withElement(new ElementOption().withElement(element).withCoordinates(xCoord, yCoord))).perform();
		}
		return new TouchAction<>(driver).tap(new TapOptions().withElement(new ElementOption().withElement(element))).perform();
	}

	@Override
	public void startLog()
	{
		logger.beginKeyword(this, locator);

	}

	@Override
	public void endLog()
	{
		logger.endKeyword(this);

	}

}
