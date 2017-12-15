package interfaces;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import framework.ActionKeyword;

public interface IAction {
	ActionKeyword selectByText(By locator, String name);
	ActionKeyword selectByText(WebElement element, String name);
	ActionKeyword selectByIndex(By locator, int index);
	ActionKeyword selectByIndex(WebElement element, int index);
	ActionKeyword click(By locator);
	ActionKeyword click(WebElement element);
	ActionKeyword sendKeys(By locator, String text);
	ActionKeyword sendKeys(WebElement element, String text);
	ActionKeyword executeJavaScript(String js);
	ActionKeyword executeJavaScript(String js, Object... args);
	ActionKeyword navigateTo(String url);
	ActionKeyword navigateTo(URL url);
	ActionKeyword navigateBack();
	ActionKeyword navigateForward();
	ActionKeyword navigateRefresh();
	ActionKeyword doubleClick(By locator);
	ActionKeyword doubleClick(WebElement element);
	ActionKeyword hover(By locator, long seconds);
	ActionKeyword hover(WebElement element, long seconds);
	ActionKeyword hover(By locator);
	ActionKeyword hover(WebElement element);
	ActionKeyword mouseTo(By locator);
	ActionKeyword mouseTo(WebElement element);
	ActionKeyword clickAndDrag(By source, By target);
	ActionKeyword clickAndDrag(By source, WebElement target);
	ActionKeyword clickAndDrag(WebElement source, By target);
	ActionKeyword clickAndDrag(WebElement source, WebElement target);
	ActionKeyword clickAndDrag(By source, int offsetX, int offsetY);
	ActionKeyword clickAndDrag(WebElement source, int offsetX, int offsetY);
	ActionKeyword selectCheckbox(By locator);
	ActionKeyword selectCheckbox(WebElement element);
	ActionKeyword unselectCheckbox(By locator);
	ActionKeyword unselectCheckbox(WebElement element);
	ActionKeyword selectRadioOptionByIndex(By parent, int index);
	ActionKeyword selectRadioOptionByIndex(WebElement parent, int index);
	ActionKeyword selectRadioOptionByValue(By parent, String value);
	ActionKeyword selectRadioOptionByValue(WebElement parent, String value);
	ActionKeyword scrollToElement(By locator);
	ActionKeyword scrollToElement(WebElement element);
	ActionKeyword switchToFrame(String idOrName);
	ActionKeyword switchToFrame(int index);
	ActionKeyword switchToFrame(WebElement frame);
	ActionKeyword switchToFrame(By frame);
}
