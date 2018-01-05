package framework;

import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import actionKeywords.Click;
import actionKeywords.ClickAndDrag;
import actionKeywords.ClickAndDragOffset;
import actionKeywords.DoubleClick;
import actionKeywords.ExecuteJavaScript;
import actionKeywords.Hover;
import actionKeywords.JsClick;
import actionKeywords.NavigateBack;
import actionKeywords.NavigateForward;
import actionKeywords.NavigateRefresh;
import actionKeywords.NavigateToUrl;
import actionKeywords.ScrollToElement;
import actionKeywords.SelectByIndex;
import actionKeywords.SelectByText;
import actionKeywords.SelectCheckbox;
import actionKeywords.SelectRadioOptionByIndex;
import actionKeywords.SelectRadioOptionByValue;
import actionKeywords.SetText;
import actionKeywords.SwitchToDefaultContent;
import actionKeywords.SwitchToFrame;
import actionKeywords.SwitchToFrameElement;
import actionKeywords.SwitchToFrameIndex;
import actionKeywords.UnselectCheckbox;
import interfaces.IAction;
import interfaces.ILogging;
import interfaces.IWait;

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
		return new SetText(driver, locator, text, logger, wait);
	}

	@Override
	public ActionKeyword sendKeys(WebElement element, String text) {
		return new SetText(element, text, logger, wait);
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
		return new Hover(driver, locator, seconds, logger, wait);
	}

	@Override
	public ActionKeyword hover(WebElement element, long seconds) {
		return new Hover(driver, element, seconds, logger, wait);
	}

	@Override
	public ActionKeyword hover(By locator) {
		return new Hover(driver, locator, 0, logger, wait);
	}

	@Override
	public ActionKeyword hover(WebElement element) {
		return new Hover(driver, element, 0, logger, wait);
	}

	@Override
	public ActionKeyword mouseTo(By locator) {
		return new Hover(driver, locator, 0, logger, wait);
	}

	@Override
	public ActionKeyword mouseTo(WebElement element) {
		return new Hover(driver, element, 0, logger, wait);
	}

	@Override
	public ActionKeyword clickAndDrag(By source, By target) {
		return new ClickAndDrag(driver, target, target, logger, wait);
	}

	@Override
	public ActionKeyword clickAndDrag(By source, WebElement target) {
		return new ClickAndDrag(driver, source, target, logger, wait);
	}

	@Override
	public ActionKeyword clickAndDrag(WebElement source, By target) {
		return new ClickAndDrag(driver, source, target, logger, wait);
	}

	@Override
	public ActionKeyword clickAndDrag(WebElement source, WebElement target) {
		return new ClickAndDrag(driver, target, target, logger, wait);
	}
	
	@Override
	public ActionKeyword clickAndDrag(By source, int offsetX, int offsetY) {
		return new ClickAndDragOffset(driver, source, offsetY, offsetY, logger, wait);
	}

	@Override
	public ActionKeyword clickAndDrag(WebElement source, int offsetX, int offsetY) {
		return new ClickAndDragOffset(driver, source, offsetY, offsetY, logger, wait);
	}

	@Override
	public ActionKeyword selectCheckbox(By locator) {
		return new SelectCheckbox(driver, logger, wait, locator);
	}

	@Override
	public ActionKeyword selectCheckbox(WebElement element) {
		return new SelectCheckbox(element, logger, wait);
	}

	@Override
	public ActionKeyword unselectCheckbox(By locator) {
		return new UnselectCheckbox(driver, logger, wait, locator);
	}

	@Override
	public ActionKeyword unselectCheckbox(WebElement element) {
		return new UnselectCheckbox(element, logger, wait);
	}

	@Override
	public ActionKeyword selectRadioOptionByIndex(By parent, int index) {
		return new SelectRadioOptionByIndex(driver, parent, index, logger, wait);
	}

	@Override
	public ActionKeyword selectRadioOptionByIndex(WebElement parent, int index) {
		return new SelectRadioOptionByIndex(parent, index, logger, wait);
	}

	@Override
	public ActionKeyword selectRadioOptionByValue(By parent, String value) {
		return new SelectRadioOptionByValue(driver, parent, value, logger, wait);
	}

	@Override
	public ActionKeyword selectRadioOptionByValue(WebElement parent, String value) {
		return new SelectRadioOptionByValue(parent, value, logger, wait);
	}

	@Override
	public ActionKeyword scrollToElement(By locator) {
		return new ScrollToElement(driver, locator, logger, wait);
	}

	@Override
	public ActionKeyword scrollToElement(WebElement element) {
		return new ScrollToElement(driver, element, logger, wait);
	}

	@Override
	public ActionKeyword switchToFrame(String idOrName) {
		return new SwitchToFrame(driver, logger, idOrName);
	}

	@Override
	public ActionKeyword switchToFrame(int index) {
		return new SwitchToFrameIndex(driver, logger, index);
	}

	@Override
	public ActionKeyword switchToFrame(WebElement frame) {
		return new SwitchToFrameElement(driver, frame, logger);
	}

	@Override
	public ActionKeyword switchToFrame(By frame) {
		return new SwitchToFrameElement(driver, frame, logger);
	}

	
	@Override
	public ActionKeyword switchToDefaultContent()
	{
		return new SwitchToDefaultContent(driver, logger);
	}

	
	@Override
	public ActionKeyword jsClick(By locator)
	{
		return new JsClick(driver, logger, wait, locator);
	}

	
	@Override
	public ActionKeyword jsClick(WebElement element)
	{
		return new JsClick(driver, element, logger, wait);
	}
}
