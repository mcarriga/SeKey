package keywords;

import java.util.List;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import data.ObjectDef;
import framework.Framework;
import framework.WaitKeyword;
import interfaces.ILogging;

public class UntilPageLoadStatusComplete extends WaitKeyword {
	private final WebDriver driver;
	private final ILogging logger;
	private final long timeout;
	
	public UntilPageLoadStatusComplete(WebDriver driver, ILogging logger, long maxTimeSeconds) {
		this.driver = driver;
		this.logger = logger;
		this.timeout = maxTimeSeconds;
	}

	@Override
	public Boolean perform() {
		try {
		return new WebDriverWait(driver, timeout).until(x -> ((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete"));
		}catch(TimeoutException e) {
			return false;
		}
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
	public WaitKeyword instantiateExternal(Framework framework, List<ObjectDef> defs, List<String> objects,
			List<String> params) {
		return new UntilPageLoadStatusComplete(framework.driver, framework.logger, (long)Double.parseDouble(params.get(0)));
	}

}
