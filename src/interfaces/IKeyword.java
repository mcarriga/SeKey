package interfaces;

public interface IKeyword<T extends Object> {
	T perform();
	void startLog();
	void endLog();
	T build();
	String getKeywordType();
}
