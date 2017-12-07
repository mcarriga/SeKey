package com.spectrum.automation.keywords;

import com.spectrum.automation.Interfaces.IAfterAction;
import com.spectrum.automation.Interfaces.IKeyword;

public abstract class ActionKeyword extends Keyword<Object> implements IKeyword<Object> {
	public String getKeywordType() {
		return "Action";
	}
	public abstract IAfterAction guarantee();
	public abstract Object perform();
}
