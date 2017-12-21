package framework;

import java.util.List;

import data.ObjectDef;
import interfaces.IKeyword;

public abstract class WaitKeyword extends Keyword<Object> implements IKeyword<Object>{
	public String getKeywordType() {
		return "Wait";
	}
	public abstract Boolean perform();
	
	public abstract WaitKeyword instantiateExternal(Framework framework, List<ObjectDef> defs, List<String> objects, List<String> params);
}