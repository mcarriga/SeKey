package keywords;

import framework.Keyword;
import interfaces.IAfterAction;
import interfaces.IKeyword;

public abstract class ActionKeyword extends Keyword<Object> implements IKeyword<Object> {
	public String getKeywordType() {
		return "Action";
	}
	public IAfterAction guarantee() {
		return new AfterAction((ActionKeyword)build(), 2);
	}
	public abstract Object perform();
}
