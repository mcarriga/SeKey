package actionKeywords;

import java.util.List;

import org.openqa.selenium.WebDriver;

import data.ObjectDef;
import framework.ActionKeyword;
import framework.AfterAction;
import framework.KeywordProvider;
import interfaces.IAfterAction;
import interfaces.ILogging;

public class NavigateForward extends ActionKeyword {

	private final WebDriver driver;
	private final ILogging logger;
	
	public NavigateForward(WebDriver driver, ILogging logger) {
		this.driver = driver;
		this.logger = logger;
	}
	
	@Override
	public IAfterAction guarantee() {
		return new AfterAction((ActionKeyword)build(), 2);
	}

	@Override
	public Void perform() {
		driver.navigate().forward();
		return null;
	}

	@Override
	public void startLog() {
		logger.beginKeyword(this);
	}

	@Override
	public void endLog() {
		logger.endKeyword(this);
	}

	public static ActionKeyword instantiateExternal(KeywordProvider keywordProvider, List<ObjectDef> defs,
			List<String> params) {
		return new NavigateForward(keywordProvider.driver, keywordProvider.loggers);
	}
}
