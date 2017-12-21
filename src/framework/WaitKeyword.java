package framework;

import interfaces.IKeyword;

public abstract class WaitKeyword extends Keyword<Object> implements IKeyword<Object>{
	public String getKeywordType() {
		return "Wait";
	}
	
	public abstract Boolean perform();
}