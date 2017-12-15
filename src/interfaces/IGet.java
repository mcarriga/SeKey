package interfaces;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import framework.GetKeyword;

public interface IGet {
	GetKeyword<String> GetElementText(By locator);
	GetKeyword<String> GetElementText(WebElement element);
	GetKeyword<String> GetElementValue(By locator);
	GetKeyword<String> GetElementValue(WebElement element);
}
