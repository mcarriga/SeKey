package keywords;

import org.openqa.selenium.WebDriver;

import framework.ActionKeyword;
import framework.AfterAction;
import interfaces.IAfterAction;
import interfaces.ILogging;

public class SwitchToFrame extends ActionKeyword {

	private final WebDriver driver;
	private final String nameOrId;
	private final ILogging logger;
	
	public SwitchToFrame(WebDriver driver, ILogging logger, String nameOrId) {
		this.driver = driver;
		this.nameOrId = nameOrId;
		this.logger = logger;
	}

	@Override
	public IAfterAction guarantee() {
		return new AfterAction((ActionKeyword)build(), 2);
	}

	@Override
	public Void perform() {
		driver.switchTo().frame(nameOrId);
		return null;
	}

	@Override
	public void startLog() {
		logger.beginKeyword(this, "; nameOrId: "+nameOrId);
	}

	@Override
	public void endLog() {
		logger.endKeyword(this);
	}

}
