package logging;

import org.apache.logging.log4j.*;
import org.openqa.selenium.By;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import interfaces.IAAALogEvent;
import interfaces.IKeyword;
import interfaces.ILogging;

/**
 * Concrete implementation of ILogging
 * @author Mathew Carrigan
 *
 */
public class KeywordLogger implements ILogging {
	private static Logger logger;
	private ExtentHtmlReporter htmlReporter;
	private ExtentReports extent;
	
	// Singleton pattern initialize
	private static final KeywordLogger instance = new KeywordLogger();
	private KeywordLogger() {
		logger = LogManager.getLogger();
		htmlReporter = new ExtentHtmlReporter("extent.html");
		extent = new ExtentReports();
		extent.attachReporter(htmlReporter);
	}
	public static KeywordLogger getInstance() {
		return instance;
	}
	//End Singleton pattern initialize
	
	@Override
	public ExtentReports getExtent() {
		return extent;
	}

	@Override
	public void beginKeyword(IKeyword<?> keyword) {
		beginKeyword(keyword, null, "");
	}
	
	@Override
	public void beginKeyword(IKeyword<?> keyword, String additionalInfo) {
		beginKeyword(keyword, null, additionalInfo);
	}
	
	@Override
	public void beginKeyword(IKeyword<?> keyword, By locator, String additionalInfo) {
		StringBuilder builder = new StringBuilder();
		builder.append("Starting Keyword - "+keyword.getKeywordType()+"."+keyword.getClass().getSimpleName());
		if(locator != null) {
			builder.append("; with By locator: "+locator);
		}
		if(additionalInfo != null && additionalInfo != "") {
			builder.append(additionalInfo);
		}
		info(builder.toString());
	}
	
	@Override
	public void beginKeyword(IKeyword<?> keyword, By... locators) {
		beginKeyword(keyword, "", locators);
	}
	
	@Override
	public void beginKeyword(IKeyword<?> keyword, String additionalInfo, By... locators) {
		StringBuilder builder = new StringBuilder();
		builder.append("Starting Keyword - "+keyword.getKeywordType()+"."+keyword.getClass().getSimpleName());
		for(By by : locators) {
			if(by != null) {
				builder.append("; locator: "+by);
			}
		}
		
		if(additionalInfo != null && additionalInfo != "") {
			builder.append(additionalInfo);
		}
		
		info(builder.toString());
	}
	
	@Override
	public void beginKeyword(IKeyword<?> keyword, By locator) {
		beginKeyword(keyword, locator, null);
	}

	@Override
	public void endKeyword(IKeyword<?> keyword) {
		info("Ending Keyword   - "+keyword.getKeywordType()+"."+keyword.getClass().getSimpleName());
	}

	@Override
	public IAAALogEvent arrangeSection(String message) {
		return new ArrangeSection(this, message);
	}

	@Override
	public IAAALogEvent actSection(String message) {
		return new ActSection(this, message);
	}

	@Override
	public IAAALogEvent assertSection(String message) {
		return new AssertSection(this, message);
	}
	
	@Override
	public IAAALogEvent cleanupSection(String message) {
		return new CleanupSection(this, message);
	}

	@Override
	public void info(String message) {
		logger.info(message);

	}

	@Override
	public void error(String message) {
		logger.error(message);

	}
	
	@Override
	public void error(String message, Throwable t)
	{
		logger.error(message, t);
		
	}

	@Override
	public void warn(String message) {
		logger.warn(message);

	}

	@Override
	public void debug() {
		// TODO Auto-generated method stub

	}
}
