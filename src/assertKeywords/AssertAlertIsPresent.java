package assertKeywords;

import java.util.List;

import org.testng.Assert;

import data.ObjectDef;
import framework.AssertKeyword;
import framework.KeywordProvider;
import interfaces.ILogging;
import interfaces.IWait;

public class AssertAlertIsPresent extends AssertKeyword {

	private final ILogging logger;
	private final IWait wait;
	private final long timeout;

	public AssertAlertIsPresent(ILogging logger, IWait wait, long timeoutSeconds) {
		this.logger = logger;
		this.wait = wait;
		this.timeout = timeoutSeconds;
	}

	@Override
	public Void perform() {
		Assert.assertTrue(wait.untilAlertIsPresent(timeout).perform(), "No Alert is present");;
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

	public static AssertKeyword instantiateExternal(KeywordProvider keywordProvider, List<ObjectDef> defs, List<String> params) {
		if(params.size() > 0) {
			return new AssertAlertIsPresent(keywordProvider.loggers, keywordProvider.waits,  (long)Double.parseDouble(params.get(0)));
		}
		return new AssertAlertIsPresent(keywordProvider.loggers, keywordProvider.waits, keywordProvider.asserts.getDefaultWait());
	}

}
