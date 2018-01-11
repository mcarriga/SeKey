package data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

/**
 * This class organized the creation and execution of ExcelTestCases to run.
 * ExcelTestCases are run by TestNG using a class factory strategy that sets the ExcelTestCase to run and then runs all ExcelTestStep/ITestStep within the ExcelTestStep
 * @see org.testng.annotations.Factory
 * @see org.testng.annotations.Test
 * @see ExcelTestCase
 * @see interfaces.ITestStep
 * @author Mathew Carrigan
 *
 */
public class ExcelTestOrchestrator 
{
	private final ExcelWorkbook workbook;
	private final Iterable<String> sheetsToRun;
	
	public ExcelTestOrchestrator(ExcelWorkbook workbook, Iterable<String> sheetsToRun) 
	{
		this.workbook = workbook;
		this.sheetsToRun = sheetsToRun;
	}
	
	public ExcelTestOrchestrator(ExcelWorkbook workbook, String... sheetsToRun) 
	{
		this(workbook, Arrays.asList(sheetsToRun));
	}
	
	@SuppressWarnings("serial")
	public ExcelTestOrchestrator(ExcelWorkbook workbook, String sheetToRun) 
	{
		this(workbook, new ArrayList<String>() {{add(sheetToRun);}});
	}
	
	/**
	 * Finds all ExcelTestCases to run for the test excution.
	 * This is used for TestNG to produce test cases for each ExcelTestCase to run using a TestNG Factory and DataProvider strategy
	 * @return List of all ExcelTestCases to run via TestNG Factory strategy
	 */
	public List<ExcelTestCase> getTests() 
	{
		ExcelTestCreator runner = new ExcelTestCreator(workbook, sheetsToRun);
		HashMap<ExcelWorksheet, List<ExcelTestCase>> worksheetsWithTests = runner.init();
		Set<ExcelWorksheet> sheets = worksheetsWithTests.keySet();
		
		List<ExcelTestCase> tests = new ArrayList<ExcelTestCase>();
		for(ExcelWorksheet sheet : sheets) {
			tests.addAll(worksheetsWithTests.get(sheet));
		}
		return tests;
	}
}
