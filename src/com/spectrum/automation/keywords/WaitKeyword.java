package com.spectrum.automation.keywords;

import com.spectrum.automation.Interfaces.IKeyword;

public abstract class WaitKeyword extends Keyword<Object> implements IKeyword<Object>{
	public String getKeywordType() {
		return "Wait";
	}
	public abstract Boolean perform();
}