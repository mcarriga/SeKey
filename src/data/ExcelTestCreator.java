package data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Row.MissingCellPolicy;

public class ExcelTestCreator 
{
	private final Iterable<String> sheetsToRun;
	private final ExcelWorkbook workbook;
	
	public ExcelTestCreator(ExcelWorkbook workbook, Iterable<String> sheetsToRun) 
	{
		this.sheetsToRun = sheetsToRun;
		this.workbook = workbook;
	}
	
	public ExcelTestCreator(ExcelWorkbook workbook, String[] sheetsToRun)
	{
		this(workbook, Arrays.asList(sheetsToRun));
	}
	
	public HashMap<ExcelWorksheet, List<ExcelTestCase>> init()
	{
		
		HashMap<ExcelWorksheet, List<ExcelTestCase>> Suite = new HashMap<ExcelWorksheet, List<ExcelTestCase>>();
		
		// get all Runner/Suite worksheets to loop through for test cases
		List<ExcelWorksheet> allWorkSheets = new ArrayList<ExcelWorksheet>();
		for(String sheetName : sheetsToRun) {
			ExcelWorksheet currSheet = new ExcelWorksheet(workbook, sheetName);
			allWorkSheets.add(currSheet);
		}
		
		// loop through each Runner/Suite worksheet to get list of Test Cases to Execute
		for(ExcelWorksheet sheet : allWorkSheets) {
			List<ExcelTestCase> testsToRunInWorksheet = getAllValidTestsInRunnerSheet(sheet);
			Suite.put(sheet, testsToRunInWorksheet);
		}
		return Suite;
	}
	
	private List<ExcelTestCase> getAllValidTestsInRunnerSheet(ExcelWorksheet sheet) 
	{
		
		List<ExcelTestCase> testsInRunnerSheet = new ArrayList<ExcelTestCase>();
		
		Iterator<Row> rows = sheet.getSheet().iterator();
		while(rows.hasNext()) {
			Row row = rows.next();
			//skip header row
			if(row.getRowNum() ==0) {
				continue;
			}
			
			String sheetName = row.getCell(0, MissingCellPolicy.RETURN_NULL_AND_BLANK).getStringCellValue().trim();
			String testName = row.getCell(1, MissingCellPolicy.RETURN_NULL_AND_BLANK).getStringCellValue().trim();
			String doRun = row.getCell(2, MissingCellPolicy.RETURN_NULL_AND_BLANK).getStringCellValue().trim();
			
			if(doRun.equalsIgnoreCase("yes")) {
				ExcelWorksheet workSheet = new ExcelWorksheet(workbook, sheetName);
				ExcelTestFinder finder = new ExcelTestFinder(workSheet, testName);
				ExcelTestCase test = finder.getTest(sheet.getSheet().getSheetName());
				testsInRunnerSheet.add(test);
			}
		}
		return testsInRunnerSheet;
	}
}
