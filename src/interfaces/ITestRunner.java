package interfaces;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import org.testng.Assert;
import org.testng.ITestContext;

import data.KeywordRunner;
import data.ObjectDef;
import data.ObjectFinder;
import framework.KeywordProvider;
import framework.Keyword;

/**
 *  Primary interface model for executing ITestCase implementations
 *  This Interface will run KeywordProvider Keywords, Custom created Keywords, and Page Object methods
 * @author Mathew Carrigan
 *
 */
public interface ITestRunner
{
	/**
	 * Runs the provided ITestCase by executing the ITestSteps within the ITestCase
	 * @param testCase the ITestCase to run
	 * @throws Exception If any ITestSteps in the ITestCase throw an error
	 */
	void runTest(ITestCase testCase) throws Exception;
	
	ITestContext getTestContext();
	
	/**
	 * Gets the Package of the client project that contains all of the Page Objects in it. This is used for reflection purposes to be able to get objects and methods from a Page Object
	 * @return the Package/Class that contains the classes of Page Objects.
	 */
	String getPageObjectPackage();
	
	/**
	 * Returns the current active KeywordProvider instance
	 * @see KeywordProvider
	 * @return KeywordProvider instance
	 */
	KeywordProvider getFramework();
	
	/**
	 * Returns active KeywordRunner instance
	 * @see data.KeywordRunner
	 * @return data.KeywordRunner
	 */
	KeywordRunner getKeywordRunner();
	
	/**
	 * List of all the methods in the interfaces.IAction interface
	 */
	List<Method> actionsX = Arrays.asList(IAction.class.getDeclaredMethods());
	
	/**
	 * List of all the methods in the interfaces.IAssert interface
	 */
	List<Method> assertsX = Arrays.asList(IAssert.class.getDeclaredMethods());
	
	/**
	 * List of all the methods in the interfaces.IGet interface
	 */
	List<Method> getsX = Arrays.asList(IGet.class.getDeclaredMethods());
	
	/**
	 * List of all the methods in the interfaces.Wait interface
	 */
	List<Method> waitsX = Arrays.asList(IWait.class.getDeclaredMethods());
	
	/**
	 * List of all the methods in the interfaces.ITouchAction interface
	 */
	List<Method> touchX = Arrays.asList(ITouchAction.class.getDeclaredMethods());
	
	/**
	 * List of all the methods in the interfaces.IAAALogEvent interface
	 */
	List<Method> aaaX = Arrays.asList(IAAALogEvent.class.getDeclaredMethods());
	
	/**
	 * List of all the method names as String in the interfaces.IAction interface
	 */
	List<String> actions = actionsX.stream().map(x -> x.getName()).collect(Collectors.toList());
	
	/**
	 * List of all the method names as String in the interfaces.IAssert interface
	 */
	List<String> asserts = assertsX.stream().map(x -> x.getName()).collect(Collectors.toList());
	
	/**
	 * List of all the method names as String in the interfaces.IGet interface
	 */
	List<String> gets = getsX.stream().map(x -> x.getName()).collect(Collectors.toList());
	
	/**
	 * List of all the method names as String in the interfaces.IWait interface
	 */
	List<String> waits = waitsX.stream().map(x -> x.getName()).collect(Collectors.toList());
	
	/**
	 * List of all the method names as String in the interfaces.ITouchActions interface
	 */
	List<String> gestures = touchX.stream().map(x -> x.getName()).collect(Collectors.toList());
	
	/**
	 * List of all the method names as String in the interfaces.IAAALogEvent interface
	 */
	List<String> tripleALogs = aaaX.stream().map(x -> x.getName()).collect(Collectors.toList());
	
	/**
	 * Runs a Page Object method. Currently ONLY parameterless page object methods are supported by Excel test runner
	 * @param objects String of the Keyword name provided in the Keyword column of an Excel Test Case. This string will be split by a '.' as it should be in the syntax of class.method format
	 * @param params List of params from the params column of an Excel Test Case.
	 */
	default void runCustomMethod(String objects, List<String> params) 
	{
		String[] vals = objects.split("\\.");
		String cls = getPageObjectPackage()+"."+vals[0];
		String method = vals[1];
		try {
			ObjectFinder.getMethod(getFramework(), cls, method, params);
		} catch (ClassNotFoundException | NoSuchMethodException | SecurityException | InstantiationException
				| IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
			org.testng.Assert.fail("Unabled to run Page Object method with name '"+cls+"."+method+"'. Please check Method Name, Spelling, Punctuation, Access Modifier and insure method does not require any input params", e);
		}
	}
	
	/**
	 * Runs a Custom created Keyword that is NOT part of the KeywordProvider's provided keywords
	 * @param keywordName Name of the Keyword in the following Syntax: package.Class
	 * @param defs List of ObjectDef objects- ObjectDefs are created by supplying a String name of the object in format of Class.Field and the Field should be either a By locator or a WebElement
	 * @param params List of params to supply to the keyword
	 */
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
			method = cls.getDeclaredMethod("instantiateExternal", KeywordProvider.class, List.class, List.class);
		} catch(NoSuchMethodException m) {
			org.testng.Assert.fail("Custom Keyword class does no properly implement the instantiateExternal method with params KeywordProvider, List<ObjectDef>, List<String>'"+keywordName+"'", m);
		}
		
		try {
			keyword = (Keyword<?>) method.invoke(null, getFramework(), defs, params);
		} catch(InvocationTargetException | IllegalAccessException a) {
			org.testng.Assert.fail("Unable to invoke instantiateExternal() method on custom Keyword '"+keywordName+"'. Please check method Access Modifier and implementation", a);
		}
		keyword.build();
	}
	
	/**
	 * Runs a KeywordProvider provided Keyword
	 * @param keywordName Name of the Keyword to run
	 * @param defs List of ObjectDef objects- ObjectDefs are created by supplying a String name of the object in format of Class.Field and the Field should be either a By locator or a WebElement
	 * @param params List of Params to supply to the keyword
	 * @throws InstantiationException If the provided Keyword name is not found
	 * @throws IllegalAccessException If the keyword does not properly implement the instantiateExternal method.
	 */
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
	
	/**
	 * Helper method to figure out if a particular list of Keywords contains the provided Keyword name ignoring capitalization
	 * @param l List of Keywords to look through
	 * @param s String keyword to match against
	 * @return true if found, false otherwise
	 */
	default boolean containsIgnoreCase(List <String> l, String s) 
	{
		 Iterator<String> it = l.iterator();
		 while(it.hasNext()){
		  if(it.next().equalsIgnoreCase(s))
		  return true;
		 }
		 return false;
	}
	
	/**
	 * Helper method to get the name from the provided list of methods given a name to look for
	 * @param l List of method to look through
	 * @param s Name of method to find
	 * @return String of the found method name
	 */
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
	
	/**
	 * Helper method that converts a List of Strings of PageObject fields and finds their actual Objects using reflection and converts them into ObjectDef instances
	 * The ObjectDef instance stores the actual Object and the Type of  that object in order be able to determine if it is a By locator or a WebElement
	 * @param step ITestStep which contains a list of Objects as Strings
	 * @return List of ObjectDefs representing the actual objects
	 * @throws Exception if issues finding the object on the provided class or if there is an issue with access modifiers like private
	 */
	default List<ObjectDef> getObjectDefs(ITestStep step) throws Exception 
	{
		List<String> objects = step.getObjects();
		List<ObjectDef> defs = new ArrayList<ObjectDef>();
		for(String obj : objects) {
			String[] vals = obj.split("\\.");
			
			ObjectDef def = null;
			try {
				def = ObjectFinder.x(getFramework(), getPageObjectPackage()+"."+vals[0], vals[1]);
			}catch (org.openqa.selenium.NoSuchElementException no) {
				// TODO: handle exception
				getFramework().loggers.error("Unable to locate Element: "+vals[0]+"."+vals[1]);
				Assert.fail("Unable to locate Element: "+vals[0]+"."+vals[1], no);
			}catch(Exception e) {
				getFramework().loggers.error(e.getMessage(), e);
				Assert.fail(e.getMessage(), e);
			}
			defs.add(def);
		}
		return defs;
	}
	
}
