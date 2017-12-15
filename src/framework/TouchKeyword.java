package framework;

import interfaces.IKeyword;

public abstract class TouchKeyword extends Keyword<Object> implements IKeyword<Object> {
	public String getKeywordType() {
		return "Touch";
	}

}
