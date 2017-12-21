package keywords;

import java.util.List;

import org.openqa.selenium.WebDriver;

import data.ObjectDef;
import framework.ActionKeyword;
import framework.AfterAction;
import framework.Framework;
import interfaces.IAfterAction;
import interfaces.ILogging;

public class NavigateBack extends ActionKeyword {

	private final WebDriver driver;
	private final ILogging logger;
	
	public NavigateBack(WebDriver driver, ILogging logger) {
		this.driver = driver;
		this.logger = logger;
	}
	
	@Override
	public IAfterAction guarantee() {
		return new AfterAction((ActionKeyword)build(), 2);
	}

	@Override
	public Void perform() {
		driver.navigate().back();
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

	@Override
	public ActionKeyword instantiateExternal(Framework framework, List<ObjectDef> defs, List<String> objects,
			List<String> params) {
		return new NavigateBack(framework.driver, framework.logger);
	}

}
