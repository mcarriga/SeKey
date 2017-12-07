package com.spectrum.automation.keywords;

import com.spectrum.automation.Interfaces.IKeyword;

public abstract class Keyword <T extends Object> implements IKeyword<Object>{
	public abstract T perform();
	public abstract void startLog();
	public abstract void endLog();
	public final T build() {
		startLog();
		T x = perform();
		endLog();
		return x;
	}
}
