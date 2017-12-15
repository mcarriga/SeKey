package interfaces;

import java.util.concurrent.Callable;
import java.util.function.Predicate;

import framework.ActionKeyword;
import framework.WaitKeyword;

public interface IAfterAction {
	IAfterAction that(Predicate<Boolean> condition);
	IAfterAction that(Callable<Boolean> condition);
	IAfterAction that(WaitKeyword wait);
	ActionKeyword getAction();
}
