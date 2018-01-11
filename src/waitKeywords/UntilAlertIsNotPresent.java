package waitKeywords;

import java.util.List;

import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import data.ObjectDef;
import framework.KeywordProvider;
import framework.WaitKeyword;
import interfaces.ILogging;

public class UntilAlertIsNotPresent extends WaitKeyword {

	private final WebDriver driver;
	private final ILogging logger;
	private final long maxTime;
	
	public UntilAlertIsNotPresent(WebDriver driver, ILogging logger, long maxWaitSeconds) {
		this.driver = driver;
		this.logger = logger;
		this.maxTime = maxWaitSeconds;
	}

	@Override
	public Boolean perform() {
		WebDriverWait wait = new WebDriverWait(driver, maxTime);
		return wait.until(x -> {
			try {
				Assert.assertThrows(NoAlertPresentException.class, () -> driver.switchTo().alert());
				return true;
			}catch(AssertionError e) {
				return false;
			}
		});
	}

	@Override
	public void startLog() {
		logger.beginKeyword(this);
	}

	@Override
	public void endLog() {
		logger.endKeyword(this);
	}

	public static WaitKeyword instantiateExternal(KeywordProvider keywordProvider, List<ObjectDef> defs,
			List<String> params) {
		return new UntilAlertIsNotPresent(keywordProvider.driver, keywordProvider.loggers,  (long)Double.parseDouble(params.get(0)));
	}

}
