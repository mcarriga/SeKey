package framework;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import interfaces.*;
import keywords.ActionKeyword;
import keywords.AssertKeyword;
import keywords.GetKeyword;
import keywords.WaitKeyword;

public class Framework {
	private final WebDriver _driver;
	public final ILogging logger;
	public final IAction actions;
	public final IAssert asserts;
	public final IWait waits;
	public final IGet gets;
	
	public Framework(WebDriver driver, ILogging logger) {
		this._driver = driver;
		this.logger = logger;
		waits = new Waits(driver, logger);
		actions = new Actions(driver, logger, waits);
		gets = new Gets(driver, logger);
		asserts = new Asserts(driver, logger, actions, waits);
	}
	
	public Framework withAction(ActionKeyword func) {
		func.build();
		return this;
	}
	
	public Framework withAction(IAfterAction action) {
		//action.getAction().build();
		return this;
	}
	
	public Framework withAssert(AssertKeyword func) {
		func.build();
		return this;
	}
	
	public Framework withWait(WaitKeyword func) {
		func.build();
		return this;
	}
	
	@SuppressWarnings("unchecked")
	public <T> T withGet(GetKeyword<?> func) {
		return (T)func.build();
	}
	
	@SuppressWarnings("unchecked")
	public <T> Framework withWait(WaitKeyword func, T out) {
		out = (T)func.build();
		return this;
	}
	
	public Framework withLogEvent(IAAALogEvent aaa) {
		aaa.doLog();
		return this;
	}
	
	public void x() throws AWTException {
		this
		.withLogEvent(logger.arrangeSection("Navigating to Google"))
		.withAction(actions.navigateTo("https://www.engprod2-spectrumbusiness.net/#/login"));
		_driver.switchTo().alert();
		
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);
		
		robot.keyPress(KeyEvent.VK_P);
		robot.keyRelease(KeyEvent.VK_P);
		
		robot.keyPress(KeyEvent.VK_2);
		robot.keyRelease(KeyEvent.VK_2);
		
		robot.keyPress(KeyEvent.VK_7);
		robot.keyRelease(KeyEvent.VK_7);
		
		robot.keyPress(KeyEvent.VK_7);
		robot.keyRelease(KeyEvent.VK_7);
		
		robot.keyPress(KeyEvent.VK_6);
		robot.keyRelease(KeyEvent.VK_6);
		
		robot.keyPress(KeyEvent.VK_6);
		robot.keyRelease(KeyEvent.VK_6);
		
		robot.keyPress(KeyEvent.VK_8);
		robot.keyRelease(KeyEvent.VK_8);
		
		robot.keyPress(KeyEvent.VK_9);
		robot.keyRelease(KeyEvent.VK_9);
		
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyRelease(KeyEvent.VK_TAB);
		
		robot.keyPress(KeyEvent.VK_TAB);
		robot.keyPress(KeyEvent.VK_ENTER);
	}
	
	public void y() {
		this
		.withLogEvent(logger.arrangeSection("Navigating to Google"))
		.withAction(actions.navigateTo("https://www.google.com/"))
		.withLogEvent(logger.actSection("Searching for Selenium"))
		.withAction(actions.click(By.xpath("//*[@name='q']")))
		.withAction(actions.sendKeys(By.xpath("//*[@name='q']"), "selenium"))
		.withWait(waits.untilElementExists(By.xpath("//li[@role='presentation']"), 5));
		
		String inputText = this.withGet(gets.GetElementText(By.xpath("//li[@role='presentation']")));
		this
		.withLogEvent(logger.assertSection("Asserting results in popup search"))
		.withAssert(asserts.assertText(By.xpath("//li[@role='presentation']"), "selenium", 15));
		
		System.out.println("inputText: "+inputText);
	}
}


