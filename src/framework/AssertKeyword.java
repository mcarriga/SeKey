package framework;

import java.util.List;

import data.ObjectDef;
import interfaces.IKeyword;

public abstract class AssertKeyword extends Keyword<Object> implements IKeyword<Object> {
	public String getKeywordType() {
		return "Assert";
	}
	
	public abstract AssertKeyword instantiateExternal(Framework framework, List<ObjectDef> defs, List<String> objects, List<String> params);
}