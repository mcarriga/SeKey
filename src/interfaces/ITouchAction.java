package interfaces;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import framework.ScrollDirection;
import framework.TouchKeyword;

public interface ITouchAction {
	TouchKeyword press(WebElement element);
	TouchKeyword press(By locator);
	TouchKeyword press(WebElement element, int xCoord, int yCoord);
	TouchKeyword press(By locator, int xCoord, int yCoord);
	TouchKeyword press(int xCoord, int yCoord);
	TouchKeyword longPress(WebElement element);
	TouchKeyword longPress(By locator);
	TouchKeyword longPress(int xCoord, int yCoord);
	TouchKeyword tap(WebElement element);
	TouchKeyword tap(By locator);
	TouchKeyword tap(WebElement element, int xCoord, int yCoord);
	TouchKeyword tap(By locator, int xCoord, int yCoord);
	TouchKeyword tap(int xCoord, int yCoord);
	TouchKeyword release();
	TouchKeyword moveTo(WebElement element);
	TouchKeyword moveTo(By locator);
	TouchKeyword moveTo(int xCoord, int yCoord);
	TouchKeyword swipeTo(By source, By target);
	TouchKeyword swipeTo(By source, WebElement target);
	TouchKeyword swipeTo(WebElement source, By target);
	TouchKeyword swipeTo(WebElement source, WebElement target);
	TouchKeyword swipeTo(By source, int xCoordTarget, int yCoordTarget);
	TouchKeyword swipeTo(WebElement source, int xCoordTarget, int yCoordTarget);
	TouchKeyword swipeTo(int xCoordSource, int yCoordSource, By target);
	TouchKeyword swipeTo(int xCoordSource, int yCoordSource, WebElement target);
	TouchKeyword scrollByDirection(ScrollDirection direction);
	TouchKeyword scrollByDirection(By locator, ScrollDirection direction);
	TouchKeyword scrollByDirection(WebElement element, ScrollDirection direction);
	TouchKeyword swipeByDirection(ScrollDirection direction);
	TouchKeyword swipeByDirection(By locator, ScrollDirection direction);
	TouchKeyword swipeByDirection(WebElement element, ScrollDirection direction);
}
