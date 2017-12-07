package com.spectrum.automation.Interfaces;

import java.util.concurrent.Callable;
import java.util.function.Predicate;

import com.spectrum.automation.keywords.ActionKeyword;
import com.spectrum.automation.keywords.WaitKeyword;

public interface IAfterAction {
	IAfterAction that(Predicate<Boolean> condition);
	IAfterAction that(Callable<Boolean> condition);
	IAfterAction that(WaitKeyword wait);
	ActionKeyword getAction();
}
