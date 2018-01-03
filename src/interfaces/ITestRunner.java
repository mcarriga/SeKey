package interfaces;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import data.KeywordRunner;
import data.ObjectDef;
import data.ObjectFinder;
import framework.Framework;
import framework.Keyword;

public interface ITestRunner
{
	void runTest(ITestCase testCase) throws Exception;
	Class<?> getPageObjectPackage();
	Framework getFramework();
	KeywordRunner getKeywordRunner();
	List<Method> actionsX = Arrays.asList(IAction.class.getDeclaredMethods());
	List<Method> assertsX = Arrays.asList(IAssert.class.getDeclaredMethods());
	List<Method> getsX = Arrays.asList(IGet.class.getDeclaredMethods());
	List<Method> waitsX = Arrays.asList(IWait.class.getDeclaredMethods());
	List<Method> touchX = Arrays.asList(ITouchAction.class.getDeclaredMethods());
	List<Method> aaaX = Arrays.asList(IAAALogEvent.class.getDeclaredMethods());
	List<String> actions = actionsX.stream().map(x -> x.getName()).collect(Collectors.toList());
	List<String> asserts = assertsX.stream().map(x -> x.getName()).collect(Collectors.toList());
	List<String> gets = getsX.stream().map(x -> x.getName()).collect(Collectors.toList());
	List<String> waits = waitsX.stream().map(x -> x.getName()).collect(Collectors.toList());
	List<String> gestures = touchX.stream().map(x -> x.getName()).collect(Collectors.toList());
	List<String> tripleALogs = aaaX.stream().map(x -> x.getName()).collect(Collectors.toList());
	
	default void runCustomMethod(String objects, List<String> params) 
	{
		String[] vals = objects.split("\\.");
		String cls = getPageObjectPackage().getSimpleName()+"."+vals[0];
		String method = vals[1];
		try {
			ObjectFinder.getMethod(getFramework(), cls, method, params);
		} catch (ClassNotFoundException | NoSuchMethodException | SecurityException | InstantiationException
				| IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			org.testng.Assert.fail("Unabled to run Page Object method with name '"+cls+"."+method+"'. Please check Method Name, Spelling, Punctuation, Access Modifier and insure method does not require any input params", e);
		}
	}
	
	default void runCustomKeyword(String keywordName, List<ObjectDef> defs, List<String> params) 
	{
		Class<?> cls = null;
		Method method = null;
		Keyword<?> keyword = null;
		
		try {
			cls = Class.forName(keywordName);
		} catch (ClassNotFoundException c) {
			org.testng.Assert.fail("Unable to find class with name '"+keywordName+"'", c);
		}
		
		try {
			method = cls.getDeclaredMethod("instantiateExternal", Framework.class, List.class, List.class);
		} catch(NoSuchMethodException m) {
			org.testng.Assert.fail("Custom Keyword class does no properly implement the instantiateExternal method with params Framework, List<ObjectDef>, List<String>'"+keywordName+"'", m);
		}
		
		try {
			keyword = (Keyword<?>) method.invoke(null, getFramework(), defs, params);
		} catch(InvocationTargetException | IllegalAccessException a) {
			org.testng.Assert.fail("Unable to invoke instantiateExternal() method on custom Keyword '"+keywordName+"'. Please check method Access Modifier and implementation", a);
		}
		keyword.build();
	}
	
	default void runKeyword(String keywordName, List<ObjectDef> defs, List<String> params) throws InstantiationException, IllegalAccessException
	{
		int index = 0;
		for(String param : params) {
			if(param.startsWith("${") && param.endsWith("}")) {
				String paramName = param.substring(2, param.length()-1);
				param = (String)getKeywordRunner().getterObjects.get(paramName);
				params.set(index, param);
			}
			index++;
		}
		
		if(containsIgnoreCase(actions, keywordName)) {
			String methodName = getMethodName(actionsX, keywordName);
			getKeywordRunner().doAction(methodName, defs, params);
			
		} else if(containsIgnoreCase(asserts, keywordName)) {
			String methodName = getMethodName(assertsX, keywordName);
			getKeywordRunner().doAssert(methodName, defs, params);
			
		} else if(containsIgnoreCase(gets, keywordName)) {
			String methodName = getMethodName(getsX, keywordName);
			getKeywordRunner().doGet(methodName, defs, params);
			
		} else if(containsIgnoreCase(waits, keywordName)) {
			String methodName = getMethodName(waitsX, keywordName);
			getKeywordRunner().doWait(methodName, defs, params);
			
		} else if(containsIgnoreCase(gestures, keywordName)) {
			
		} else if(containsIgnoreCase(tripleALogs, keywordName)) {
			String methodName = getMethodName(aaaX, keywordName);
			getKeywordRunner().doAAALog(methodName, defs, params);
			
		} else {
			
		}
	}
	
	default boolean containsIgnoreCase(List <String> l, String s) 
	{
		 Iterator<String> it = l.iterator();
		 while(it.hasNext()){
		  if(it.next().equalsIgnoreCase(s))
		  return true;
		 }
		 return false;
	}
	
	default String getMethodName(List <Method> l, String s) 
	{
		Iterator<Method> it = l.iterator();
			while(it.hasNext()){
				Method method = it.next();
				String name = method.getName();
				if(name.equalsIgnoreCase(s)) {
					return name;
				}
			}
		throw new java.lang.UnsupportedOperationException("Method with name '"+s+"' not found in available keywords");
	}
	
	default List<ObjectDef> getObjectDefs(ITestStep step) throws Exception 
	{
		List<String> objects = step.getObjects();
		List<ObjectDef> defs = new ArrayList<ObjectDef>();
		for(String obj : objects) {
			String[] vals = obj.split("\\.");
			
			ObjectDef def = ObjectFinder.x(getFramework(), getPageObjectPackage().getSimpleName()+"."+vals[0], vals[1]);
			defs.add(def);
		}
		return defs;
	}
	
}
