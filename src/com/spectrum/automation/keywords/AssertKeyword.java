package com.spectrum.automation.keywords;

import com.spectrum.automation.Interfaces.IKeyword;

public abstract class AssertKeyword extends Keyword<Object> implements IKeyword<Object> {
	public String getKeywordType() {
		return "Assert";
	}
}