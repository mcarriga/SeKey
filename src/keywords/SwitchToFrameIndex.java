package keywords;

import java.util.List;

import org.openqa.selenium.WebDriver;

import data.ObjectDef;
import framework.ActionKeyword;
import framework.AfterAction;
import framework.Framework;
import interfaces.IAfterAction;
import interfaces.ILogging;

public class SwitchToFrameIndex extends ActionKeyword {

	private final WebDriver driver;
	private final int index;
	private final ILogging logger;
	
	public SwitchToFrameIndex(WebDriver driver, ILogging logger, int index) {
		this.driver = driver;
		this.index = index;
		this.logger = logger;
	}

	@Override
	public IAfterAction guarantee() {
		return new AfterAction((ActionKeyword)build(), 2);
	}

	@Override
	public Void perform() {
		driver.switchTo().frame(index);
		return null;
	}

	@Override
	public void startLog() {
		logger.beginKeyword(this, "; Index: "+index);
	}

	@Override
	public void endLog() {
		logger.endKeyword(this);
	}

	public static ActionKeyword instantiateExternal(Framework framework, List<ObjectDef> defs,
			List<String> params) {
		return new SwitchToFrameIndex(framework.driver, framework.logger, (int)Double.parseDouble(params.get(0)));
	}

}
