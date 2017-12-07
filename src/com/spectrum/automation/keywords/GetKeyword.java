package com.spectrum.automation.keywords;

import com.spectrum.automation.Interfaces.IKeyword;

public abstract class GetKeyword <T extends Object> extends Keyword<Object> implements IKeyword<Object> {
	public final String getKeywordType() {
		return "Get";
	}
	public abstract T perform();
}
