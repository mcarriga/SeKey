package keywords;

import interfaces.IAfterAction;
import interfaces.IKeyword;

public abstract class ActionKeyword extends Keyword<Object> implements IKeyword<Object> {
	public String getKeywordType() {
		return "Action";
	}
	public abstract IAfterAction guarantee();
	public abstract Object perform();
}
