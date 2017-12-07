package com.spectrum.automation.keywords;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.spectrum.automation.Interfaces.ILogging;
import com.spectrum.automation.Interfaces.IWait;

public class AssertText extends AssertKeyword {
	private final WebElement element;
	private final ILogging logger;
	private final String ExpectedText;
	private final IWait wait;
	private By locator;
	
	public AssertText(WebDriver driver, ILogging logger, IWait wait, By locator, String expectedText) {
		this.locator = locator;
		this.element = driver.findElement(locator);
		this.logger = logger;
		this.ExpectedText = expectedText;
		this.wait = wait;
	}
	
	public AssertText(WebElement element, ILogging logger, IWait wait, String expectedText) {
		this.element = element;
		this.logger = logger;
		this.ExpectedText = expectedText;
		this.wait = wait;
	}

	@Override
	public Void perform() {
		wait.untilElementTextEquals(element, ExpectedText, 10);
		Assert.assertEquals(element.getText(), ExpectedText);
		return null;
	}

	@Override
	public void startLog() {
		logger.beginKeyword(this, locator, "; Expected Text: "+ExpectedText);
	}

	@Override
	public void endLog() {
		logger.endKeyword(this);
	}

}
