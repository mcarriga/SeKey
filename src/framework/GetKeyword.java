package framework;

import java.util.List;

import data.ObjectDef;
import interfaces.IKeyword;

public abstract class GetKeyword <T extends Object> extends Keyword<Object> implements IKeyword<Object> {
	public final String getKeywordType() {
		return "Get";
	}
	public abstract T perform();
	
	public abstract GetKeyword<?> instantiateExternal(Framework framework, List<ObjectDef> defs, List<String> objects, List<String> params);
}
