package interfaces;

public interface IKeyword<T extends Object> {
	T perform();
	void startLog();
	void endLog();
	T build();
	String getKeywordType();
	//static IKeyword<?> instantiateExternal(Framework framework, List<ObjectDef> defs, List<String> params);
	//ActionKeyword instantiateExternal(Framework framework, List<ObjectDef> defs, List<String> params);
}
