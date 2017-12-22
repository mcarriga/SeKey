package interfaces;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import framework.GetKeyword;

public interface IGet {
	GetKeyword<String> getElementText(By locator);
	GetKeyword<String> getElementText(WebElement element);
	GetKeyword<String> getElementValue(By locator);
	GetKeyword<String> getElementValue(WebElement element);
	GetKeyword<String> getElementAttribute(By locator, String attrName);
	GetKeyword<String> getElementAttribute(WebElement element, String attrName);
	GetKeyword<Integer> getElementCount(By locator);
	GetKeyword<Boolean> isVisible(By locator);
	GetKeyword<Boolean> isVisible(WebElement element);
	GetKeyword<Boolean> isEnabled(By locator);
	GetKeyword<Boolean> isEnabled(WebElement element);
	GetKeyword<Boolean> isSelected(By locator);
	GetKeyword<Boolean> isSelected(WebElement element);
	GetKeyword<List<String>> getDropDownOptions(By locator);
	GetKeyword<List<String>> getDropDownOptions(WebElement element);
	GetKeyword<String> getDropDownSelectedOption(By locator);
	GetKeyword<String> getDropDownSelectedOption(WebElement element);
	GetKeyword<Integer> getDropDownOptionsCount(By locator);
	GetKeyword<Integer> getDropDownOptionsCount(WebElement element);
	GetKeyword<String> getPageTitle();
	GetKeyword<String> getCurrentUrl();
}
