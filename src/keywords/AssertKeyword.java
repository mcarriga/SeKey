package keywords;

import framework.Keyword;
import interfaces.IKeyword;

public abstract class AssertKeyword extends Keyword<Object> implements IKeyword<Object> {
	public String getKeywordType() {
		return "Assert";
	}
}