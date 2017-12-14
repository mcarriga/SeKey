package framework;

import java.lang.ref.Reference;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;

import interfaces.*;
import keywords.ActionKeyword;
import keywords.AssertKeyword;
import keywords.GetKeyword;
import keywords.WaitKeyword;

public class Framework {
	public final WebDriver driver;
	public final ILogging logger;
	public final IAction action;
	public final IAssert asserter;
	public final IWait wait;
	public final IGet get;
	
	public Framework(WebDriver driver, ILogging logger) {
		this.driver = driver;
		this.logger = logger;
		wait = new Waits(driver, logger);
		action = new Actions(driver, logger, wait);
		get = new Gets(driver, logger);
		asserter = new Asserts(driver, logger, wait);
	}
	
	public Framework withAction(ActionKeyword func) {
		func.build();
		return this;
	}
	
	public Framework withAction(IAfterAction action) {
		action.getAction().build();
		return this;
	}
	
	public Framework withAssert(AssertKeyword func) {
		func.build();
		return this;
	}
	
	public Framework withWait(WaitKeyword func) {
		func.build();
		return this;
	}
	
	@SuppressWarnings("unchecked")
	public <T> T withGet(GetKeyword<?> func) {
		return (T)func.build();
	}
	
	@SuppressWarnings("unchecked")
	public <T> T withWait(WaitKeyword func, T out) {
		return (T)func.build();
	}
	
	@SuppressWarnings("unchecked")
	public Framework withWait(WaitKeyword func, Reference<Boolean> out) {
		out = (Reference<Boolean>) func.build();
		return this;
	}
	
	public Framework withLogEvent(IAAALogEvent aaa) {
		aaa.doLog();
		return this;
	}
	
	public Framework withDelay(int seconds) {
		ScheduledThreadPoolExecutor exec = new ScheduledThreadPoolExecutor(seconds);

		exec.schedule(new Runnable() {
		          public void run() {
		              
		          }
		     }, 1, TimeUnit.SECONDS);
		return this;
	}
}


