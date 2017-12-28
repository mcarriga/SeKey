package getKeywords;

import java.util.List;

import org.openqa.selenium.WebDriver;

import data.ObjectDef;
import framework.Framework;
import framework.GetKeyword;
import interfaces.ILogging;

public class GetPageTitle extends GetKeyword<String> {
	private final ILogging _logger;
	private final WebDriver driver;
	
	public GetPageTitle(WebDriver driver, ILogging logger) {
		this._logger = logger;
		this.driver = driver;
	}

	@Override
	public String perform() {
		return driver.getTitle();
	}

	@Override
	public void startLog() {
		_logger.beginKeyword(this);
	}

	@Override
	public void endLog() {
		_logger.endKeyword(this);
	}

	public static GetKeyword<?> instantiateExternal(Framework framework, List<ObjectDef> defs,
			List<String> params) {
		return new GetPageTitle(framework.driver, framework.logger);

	}
}
