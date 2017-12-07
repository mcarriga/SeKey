package com.spectrum.automation.keywords;

import java.util.concurrent.Callable;
import java.util.function.Predicate;

import com.spectrum.automation.Interfaces.IAfterAction;

public class AfterAction implements IAfterAction {
	protected final ActionKeyword _afterAction;
	protected int _retries;
	
	public AfterAction(ActionKeyword method, int maxRetries) {
		this._afterAction = method;
		this._retries = maxRetries;
	}
	
	@Override
	public IAfterAction that(Predicate<Boolean> condition) {
		// TODO Auto-generated method stub
		return this;
	}

	@Override
	public IAfterAction that(Callable<Boolean> condition) {
		Boolean met;
		int tries = 0;
		try {
			met = condition.call();
		} catch (Exception e1) {
			met = false;
		}
		
		while(!met && tries <= _retries) {
			try {
				_afterAction.perform();
				met = condition.call();
			} catch (Exception e) {
				met = false;
			} finally {
				tries++;
			}
		}
		
		return this;
	}

	@Override
	public ActionKeyword getAction() {
		return _afterAction;
	}

	@Override
	public IAfterAction that(WaitKeyword wait) {
		// TODO Auto-generated method stub
		return null;
	}

}
