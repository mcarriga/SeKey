package data;

import java.util.List;

public class ExcelTestStep {
	private final String keyword;
	private final List<String> objects;
	private final List<Object> params;
	
	public ExcelTestStep(String keyword, List<String> objects, List<Object> params) {
		this.keyword = keyword;
		this.objects = objects;
		this.params = params;
	}
	
	public String getKeyword() {
		return keyword;
	}
	
	public List<String> getObjects(){
		return objects;
	}
	
	public List<Object> getParams(){
		return params;
	}
}
