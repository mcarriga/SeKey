package framework;

import interfaces.IKeyword;

/**
 * Abstract template for all Assert Keywords
 * @author p2776689
 *
 */
public abstract class AssertKeyword extends Keyword<Object> implements IKeyword<Object> {
	
	public String getKeywordType() {
		return "Assert";
	}
}