package framework;

import interfaces.IKeyword;

/**
 * Abstract template for all Wait Keywords
 * @author Mathew Carrigan
 *
 */
public abstract class WaitKeyword extends Keyword<Object> implements IKeyword<Object>{
	public String getKeywordType() {
		return "Wait";
	}
	
	public abstract Boolean perform();
}