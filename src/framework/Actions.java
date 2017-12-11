package framework;

import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import interfaces.IAction;
import interfaces.ILogging;
import interfaces.IWait;
import keywords.*;

public class Actions implements IAction {
	private final WebDriver driver;
	private final ILogging logger;
	private final IWait wait;
	
	public Actions(WebDriver driver, ILogging logger, IWait wait) {
		this.wait = wait;
		this.driver = driver;
		this.logger = logger;
	}

	@Override
	public ActionKeyword selectByText(By locator, String text) {
		return new SelectByText(driver, locator, text, logger, wait);
	}

	@Override
	public ActionKeyword selectByText(WebElement element, String text) {
		return new SelectByText(element, text, logger, wait);
	}

	@Override
	public ActionKeyword click(By locator) {
		return new Click(driver, logger, wait, locator);
	}

	@Override
	public ActionKeyword click(WebElement element) {
		return new Click(element, logger, wait);
	}

	@Override
	public ActionKeyword sendKeys(By locator, String text) {
		return new SetText(driver, locator, logger, text);
	}

	@Override
	public ActionKeyword sendKeys(WebElement element, String text) {
		return new SetText(element, logger, text);
	}
	
	@Override
	public ActionKeyword executeJavaScript(String js) {
		return new ExecuteJavaScript<Object>(driver, logger, js);
	}

	@Override
	public ActionKeyword navigateTo(String url) {
		return new NavigateToUrl(driver, logger, url);
	}

	@Override
	public ActionKeyword navigateTo(URL url) {
		return new NavigateToUrl(driver, logger, url);
	}

	@Override
	public ActionKeyword navigateBack() {
		return new NavigateBack(driver, logger);
	}

	@Override
	public ActionKeyword navigateForward() {
		return new NavigateForward(driver, logger);
	}

	@Override
	public ActionKeyword navigateRefresh() {
		return new NavigateRefresh(driver, logger);
	}

	@Override
	public ActionKeyword executeJavaScript(String js, Object... args) {
		return new ExecuteJavaScript<Object>(driver, logger, js, args);
	}

	@Override
	public ActionKeyword selectByIndex(By locator, int index) {
		return new SelectByIndex(driver, locator, index, logger, wait);
	}

	@Override
	public ActionKeyword selectByIndex(WebElement element, int index) {
		return new SelectByIndex(element, index, logger, wait);
	}

	@Override
	public ActionKeyword doubleClick(By locator) {
		return new DoubleClick(driver, logger, wait, locator);
	}

	@Override
	public ActionKeyword doubleClick(WebElement element) {
		return new DoubleClick(driver, element, logger, wait);
	}

	@Override
	public ActionKeyword hover(By locator, long seconds) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ActionKeyword hover(WebElement element, long seconds) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ActionKeyword hover(By locator) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ActionKeyword hover(WebElement element) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ActionKeyword mouseTo(By locator) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ActionKeyword mouseTo(WebElement element) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ActionKeyword clickAndDrag(By source, By target) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ActionKeyword clickAndDrag(By source, WebElement target) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ActionKeyword clickAndDrag(WebElement source, By target) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ActionKeyword clickAndDrag(WebElement source, WebElement target) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ActionKeyword selectCheckbox(By locator) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ActionKeyword selectCheckbox(WebElement element) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ActionKeyword unselectCheckbox(By locator) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ActionKeyword unselectCheckbox(WebElement element) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ActionKeyword selectRadioOptionByName(By parent, String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ActionKeyword selectRadioOptionByName(WebElement parent, String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ActionKeyword selectRadioOptionByText(By parent, String text) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ActionKeyword selectRadioOptionByText(WebElement parent, String text) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ActionKeyword selectRadioOptionByValue(By parent, String value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ActionKeyword selectRadioOptionByValue(WebElement parent, String value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ActionKeyword srollToElement(By locator) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ActionKeyword srollToElement(WebElement element) {
		// TODO Auto-generated method stub
		return null;
	}

}
