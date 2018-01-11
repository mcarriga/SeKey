package interfaces;

import java.util.List;

/**
 * Model used by the keywordProvider to allow for various types of Non-coded test design like Excel spreadsheets and JSON files
 * This Interface models a Test Case and includes methods for getting information about a Test Case
 * @author Mathew Carrigan
 *
 */
public interface ITestCase
{
	/**
	 * Gets the name of the Test Case
	 * @return String the name of the Test Case
	 */
	String getTestName();
	
	/**
	 * Gets the HP ALM Test Id of the TestCase
	 * @return String HP ALM Test Id
	 */
	String getTestId();
	
	/**
	 * Gets the Suite Name this test case belongs to
	 * @return String Sutie name - Example: for Excel runner this will return the name of the spreadsheet that is running various tests
	 */
	String getSuiteName();
	
	/**
	 * Gets a list of all the ITestSteps included in this test case
	 * @return A List of ITestSteps to be performed for this Test Case
	 */
	List<ITestStep> getTestSteps();
	
}
