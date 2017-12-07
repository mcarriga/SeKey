package keywords;

import org.openqa.selenium.WebDriver;

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

}
