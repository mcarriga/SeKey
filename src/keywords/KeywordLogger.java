package keywords;

import org.apache.logging.log4j.*;
import org.apache.logging.log4j.message.MessageFactory;
import org.openqa.selenium.By;

import interfaces.IAAALogEvent;
import interfaces.IKeyword;
import interfaces.ILogging;

public class KeywordLogger implements ILogging {
	private static final Logger logger = LogManager.getLogger();
	
	public KeywordLogger(String loggerName) {
		//logger = LogManager.getLogger(loggerName);
	}
	
	public KeywordLogger(Class<?> clazz) {
		//logger = LogManager.getLogger(clazz);
	}
	
	public KeywordLogger() {
		//logger = LogManager.getLogger("FrameworkLogger");
	}
	
	public KeywordLogger(String loggerName, MessageFactory messageFactory) {
		//logger = LogManager.getLogger(messageFactory);
	}

	@Override
	public void beginKeyword(IKeyword<?> keyword) {
		beginKeyword(keyword, null, null);
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
	public void error() {
		// TODO Auto-generated method stub

	}

	@Override
	public void warn() {
		// TODO Auto-generated method stub

	}

	@Override
	public void debug() {
		// TODO Auto-generated method stub

	}
}
