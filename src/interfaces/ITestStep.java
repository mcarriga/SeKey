package interfaces;

import java.util.List;

/**
 * Model used by the keywordProvider to allow for various types of Non-coded test design like Excel spreadsheets and JSON files
 * This interface models a single test step as part of an ITestCase. A test step should include a Keyword or Action to be performed, Objects to be passed to the keyword, and any parameter
 * @author Mathew Carrigan
 * 
 */
public interface ITestStep
{
	/**
	 * Get's the Keyword to execute for this step.
	 * If Keyword = PageObject, the keywordProvider will look for the PageObject method specified in the Objects column using package.class.method syntax and attempt to execute the method providing no parameters
	 * If Keyword contains a '.' the keywordProvider will assume to execute a custom created keyword with the syntax of package.KeywordClass and look for a method on the keyword called 'instantiateExternal' and supply the given Excel column params to it
	 * @see interfaces.ITestRunner#runCustomKeyword(String, List, List)
	 * @return String of the Keyword name to execute
	 */
	String getKeyword();
	
	/**
	 * Gets the objects supplied in the Objects column of an Excel Test Case to supply to the Keyword
	 * @return List of Objects as Strings - These strings will be converted into actual java objects by the keywordProvider using reflection.
	 */
	List<String> getObjects();
	
	/**
	 * Gets the list of parameters to supply the keyword
	 * @return List of Strings of Parameters from the Params column of the Excel test case sheet.
	 */
	List<String> getParams();
}
