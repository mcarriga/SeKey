package framework;

import interfaces.IKeyword;

/**
 * Abstract template for all Get Keywords
 * @author Mathew Carrigan
 *
 * @param <T> Type the Keyword returns
 */
public abstract class GetKeyword <T extends Object> extends Keyword<Object> implements IKeyword<Object> {
	public final String getKeywordType() {
		return "Get";
	}
	public abstract T perform();
}
