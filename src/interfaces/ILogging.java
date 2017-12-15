package interfaces;


import org.openqa.selenium.By;

import com.aventstack.extentreports.ExtentReports;

public interface ILogging {
	void beginKeyword(IKeyword<?> keyword);
	void beginKeyword(IKeyword<?> keyword, By locator);
	void beginKeyword(IKeyword<?> keyword, By... locators);
	void beginKeyword(IKeyword<?> keyword, String additionalInfo, By... locators);
	void beginKeyword(IKeyword<?> keyword, By locator, String additionalInfo);
	void beginKeyword(IKeyword<?> keyword, String additionalInfo);
	void endKeyword(IKeyword<?> keyword);
	IAAALogEvent arrangeSection(String description);
	IAAALogEvent actSection(String message);
	IAAALogEvent assertSection(String message);
	IAAALogEvent cleanupSection(String message);
	void info(String message);
	void error();
	void warn();
	void debug();
	ExtentReports getExtent();
}
