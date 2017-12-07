package com.spectrum.automation.Interfaces;

public interface IKeyword<T extends Object> {
	T perform();
	void startLog();
	void endLog();
	T build();
	String getKeywordType();
}
