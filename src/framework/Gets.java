package framework;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import interfaces.IGet;
import interfaces.ILogging;
import keywords.*;

public class Gets implements IGet {
	private WebDriver driver;
	private ILogging logger;
	
	public Gets(WebDriver driver, ILogging logger) {
		this.driver = driver;
		this.logger = logger;
	}

	@Override
	public GetKeyword<String> getElementText(By locator) {
		return new GetText(driver, locator, logger);
	}

	@Override
	public GetKeyword<String> getElementText(WebElement element) {
		return new GetText(element, logger);
	}

	@Override
	public GetKeyword<String> getElementValue(By locator) {
		return new GetElementAttribute(driver, locator, "value", logger);
	}

	@Override
	public GetKeyword<String> getElementValue(WebElement element) {
		return new GetElementAttribute(element, "value", logger);
	}

	@Override
	public GetKeyword<String> getElementAttribute(By locator, String attrName) {
		return new GetElementAttribute(driver, locator, attrName, logger);
	}

	@Override
	public GetKeyword<String> getElementAttribute(WebElement element, String attrName) {
		return new GetElementAttribute(element, attrName, logger);
	}

	@Override
	public GetKeyword<Integer> getElementCount(By locator) {
		return new GetElementCount(driver, locator, logger);
	}

	@Override
	public GetKeyword<Boolean> isVisible(By locator) {
		return new IsVisible(driver, locator, logger);
	}

	@Override
	public GetKeyword<Boolean> isVisible(WebElement element) {
		return new IsVisible(element, logger);
	}

	@Override
	public GetKeyword<Boolean> isEnabled(By locator) {
		return new IsEnabled(driver, locator, logger);
	}

	@Override
	public GetKeyword<Boolean> isEnabled(WebElement element) {
		return new IsEnabled(element, logger);
	}

	@Override
	public GetKeyword<Boolean> isSelected(By locator) {
		return new IsSelected(driver, locator, logger);
	}

	@Override
	public GetKeyword<Boolean> isSelected(WebElement element) {
		return new IsSelected(element, logger);
	}

	@Override
	public GetKeyword<List<String>> getDropDownOptions(By locator) {
		return new GetDropDownOptions(driver, logger, locator);
	}

	@Override
	public GetKeyword<List<String>> getDropDownOptions(WebElement element) {
		return new GetDropDownOptions(element, logger);
	}

	@Override
	public GetKeyword<String> getDropDownSelectedOption(By locator) {
		return new GetDropDownSelectedOption(driver, logger, locator);
	}

	@Override
	public GetKeyword<String> getDropDownSelectedOption(WebElement element) {
		return new GetDropDownSelectedOption(element, logger);
	}

	@Override
	public GetKeyword<Integer> getDropDownOptionsCount(By locator) {
		return new GetDropDownOptionsCount(driver, logger, locator);
	}
	
	@Override
	public GetKeyword<Integer> getDropDownOptionsCount(WebElement element) {
		return new GetDropDownOptionsCount(element, logger);
	}

	@Override
	public GetKeyword<String> getPageTitle() {
		return new GetPageTitle(driver, logger);
	}

	@Override
	public GetKeyword<String> getCurrentUrl() {
		return new GetCurrentUrl(driver, logger);
	}

}
