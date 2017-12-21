package framework;

import interfaces.IKeyword;

public abstract class GetKeyword <T extends Object> extends Keyword<Object> implements IKeyword<Object> {
	public final String getKeywordType() {
		return "Get";
	}
	public abstract T perform();
}
