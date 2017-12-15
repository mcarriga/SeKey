package interfaces;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import framework.TouchKeyword;

public interface ITouchAction {
	TouchKeyword press(WebElement element);
	TouchKeyword press(By locator);
	TouchKeyword press(int xCoord, int yCoord);
	TouchKeyword longPress(WebElement element);
	TouchKeyword longPress(By locator);
	TouchKeyword longPress(int xCoord, int yCoord);
	TouchKeyword tap(WebElement element);
	TouchKeyword tap(By locator);
	TouchKeyword tap(int xCoord, int yCoord);
	TouchKeyword reelase();
	TouchKeyword moveTo(WebElement element);
	TouchKeyword moveTo(By locator);
	TouchKeyword moveTo(int xCoord, int yCoord);
}
