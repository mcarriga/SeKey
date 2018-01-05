package interfaces;

import java.util.concurrent.Callable;
import java.util.function.Predicate;

import framework.ActionKeyword;
import framework.WaitKeyword;

/**
 * IAfterAction is a way to perform an Action Keywords a given number of times until the expected outcome is achieved.
 * If the expected outcome is never present, then an exception is finally thrown
 * The purpose of this is that in some scenarios Selenium performs an action but due to some executing javascript or other reason the given action is not actually rendered byt the browser
 * This can often be due to timing of scripts or behavior in the browser
 * @author Mathew Carrigan
 *
 */
public interface IAfterAction {
	
	/**
	 * That represents the expected outcome and the action will be repeated until either the Predicate condition is met or the timeout is met
	 * @param condition Predicate to be evaluated
	 * @return IAfterAction for method chaining purposes and to be able to have multiple conditions to be met
	 */
	IAfterAction that(Predicate<Boolean> condition);
	
	/**
	 * That represents the expected outcome and the action will be repeated until either the Callable condition is met or the timeout is met
	 * @param condition Callable to returned and evaluated
	 * @return IAfterAction for method chaining purposes and to be able to have multiple conditions to be met
	 */
	IAfterAction that(Callable<Boolean> condition);
	
	/**
	 * That represents the expected outcome and the action will be repeated until either the WaitKeyword return is true or the timeout is met
	 * @param wait WaitKeyword to be executed and evaulated. WaitKeywords all return true or false depending on if the wait condition was met
	 * @return IAfterAction for method chaining purposes and to be able to have multiple conditions to be met
	 */
	IAfterAction that(WaitKeyword wait);
	
	/**
	 * Returns the action that was performed in order to evaluate if the expected condition was met. This action gets repeated until either the condition is met or the timeout occurs
	 * @return ActionKeyword's action event to execute
	 */
	ActionKeyword getAction();
}
