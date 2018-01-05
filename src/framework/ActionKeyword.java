package framework;

import interfaces.IAfterAction;
import interfaces.IKeyword;

/**
 * Abstract template for all Action Keywords
 * @author Mathew Carrigan
 *
 */
public abstract class ActionKeyword extends Keyword<Object> implements IKeyword<Object> {
	
	public String getKeywordType() {
		return "Action";
	}
	
	/**
	 * 
	 * @return a new IAfterAction
	 */
	public IAfterAction guarantee() {
		return new AfterAction((ActionKeyword)build(), 2);
	}
	
	public abstract Object perform();
	
}
