package keywords;

import java.net.URL;
import java.util.List;

import org.openqa.selenium.WebDriver;

import data.ObjectDef;
import framework.ActionKeyword;
import framework.AfterAction;
import framework.Framework;
import interfaces.IAfterAction;
import interfaces.ILogging;

public class NavigateToUrl extends ActionKeyword {
	private final WebDriver driver;
	private final String url;
	private final ILogging logger;
	
	public NavigateToUrl(WebDriver driver, ILogging logger, String url) {
		this.driver = driver;
		this.url = url;
		this.logger = logger;
	}
	
	public NavigateToUrl(WebDriver driver, ILogging logger, URL url) {
		this.driver = driver;
		this.url = url.toString();
		this.logger = logger;
	}

	@Override
	public IAfterAction guarantee() {
		return new AfterAction((ActionKeyword)build(), 2);
	}

	@Override
	public Void perform() {
		driver.navigate().to(url);
		return null;
	}

	@Override
	public void startLog() {
		logger.beginKeyword(this, "; Url: "+url);
	}

	@Override
	public void endLog() {
		logger.endKeyword(this);
	}

	@Override
	public ActionKeyword instantiateExternal(Framework framework, List<ObjectDef> defs, List<String> objects,
			List<String> params) {
		return new NavigateToUrl(framework.driver, framework.logger, params.get(0));
	}

}
