package getKeywords;

import java.util.List;

import org.openqa.selenium.WebDriver;

import data.ObjectDef;
import framework.KeywordProvider;
import framework.GetKeyword;
import interfaces.ILogging;

public class GetCurrentUrl extends GetKeyword<String> {
	private final ILogging _logger;
	private final WebDriver driver;
	
	public GetCurrentUrl(WebDriver driver, ILogging logger) {
		this._logger = logger;
		this.driver = driver;
	}

	@Override
	public String perform() {
		return driver.getCurrentUrl();
	}

	@Override
	public void startLog() {
		_logger.beginKeyword(this);
	}

	@Override
	public void endLog() {
		_logger.endKeyword(this);
	}

	public static GetKeyword<?> instantiateExternal(KeywordProvider keywordProvider, List<ObjectDef> defs,
			List<String> params) {
		return new GetCurrentUrl(keywordProvider.driver, keywordProvider.loggers);

	}
}
