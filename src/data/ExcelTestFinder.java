package data;

import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellValue;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Row.MissingCellPolicy;

public class ExcelTestFinder 
{
	private final ExcelWorksheet sheet;
	private final String testName;
	private ExcelTestCase test = null;
	private String suiteName;
	
	public ExcelTestFinder(ExcelWorksheet sheet, String testName) 
	{
		this.sheet = sheet;
		this.testName = testName;
	}
	
	public ExcelTestCase getTest(String suiteName) 
	{
		this.suiteName = suiteName;
		if(test == null) {
			test = find();
		}
		return test;
	}
	
	private ExcelTestCase find() 
	{
		Iterator<Row> rows = sheet.getSheet().iterator();
		boolean found = false;
		int rowStartNum = 0;
		//Row starterRow = null;
		
		// Find the row in the sheet with the provided Test Name in the first column
		while(rows.hasNext()) {
			Row row = rows.next();
			
			// ignore the header row
			if(row.getRowNum() == 0) {
				continue; // go to the next row
			}
			
			String cellText = row.getCell(0, MissingCellPolicy.RETURN_NULL_AND_BLANK).getStringCellValue();
			if(cellText.trim().equalsIgnoreCase(testName)) {
				found = true;
				//starterRow = row;
				rowStartNum = row.getRowNum();
				break;
			}
		}
		if(!found) {
			throw new java.lang.UnsupportedOperationException("Test with name '"+testName+"' was not found in worksheet '"+sheet.getSheet().getSheetName()+"' of workbook '"+sheet.getWorkbook().getWorkbookName()+"'");
		}else {
			return(createExcelTest(rowStartNum));
		}
	}
	
	private ExcelTestCase createExcelTest(int rowStartForTest) 
	{
		String testDesc = sheet.getSheet().getRow(rowStartForTest).getCell(0, MissingCellPolicy.RETURN_BLANK_AS_NULL).getStringCellValue();
		String testId = getCellValue(sheet.getSheet().getRow(rowStartForTest).getCell(1, MissingCellPolicy.RETURN_BLANK_AS_NULL));
		int startStepsRowNum = rowStartForTest +1;
		int lastStepsRowNum = 0;
		
		Iterator<Row> rows = sheet.getSheet().iterator();
		
		while(rows.hasNext()) {
			Row row = rows.next();
			// skip all rows before test case start declaration (Test case name provided in column A indicates the start of a test case)
			if(row.getRowNum() <= rowStartForTest) {
				continue; // keep iterating through rows until we get to the rows that have the test case steps in them
			}
			
			// check to see if this row starts the beginning of a new test case and break the loop if so
			Cell cellFirstColumn = row.getCell(0, MissingCellPolicy.RETURN_NULL_AND_BLANK);
			String cellTxt = null;
			if(cellFirstColumn != null) {
				cellTxt = cellFirstColumn.getStringCellValue();
			}
			if((cellTxt != null && cellTxt != "" && cellTxt.trim() != "") || rows.hasNext() == false) {
				lastStepsRowNum = row.getRowNum();
				break; // exit loop as this indicates end of test steps and beginning of next test
			}
		}

		
		// CreateTest
		ExcelTestCase eTest = new ExcelTestCase(sheet, startStepsRowNum,lastStepsRowNum, suiteName, testDesc, testId);
		return eTest;
	}
	
	private String getCellValue(Cell cell)
	{
		FormulaEvaluator evaluator = sheet.getWorkbook().getWorkbook().getCreationHelper().createFormulaEvaluator();
		CellValue cellValue = evaluator.evaluate(cell);
		
		if(cellValue == null) {
			return "";
		}
		switch(cellValue.getCellTypeEnum()) {
		case BLANK:
			return "";

		case BOOLEAN:
			return String.valueOf(cell.getBooleanCellValue());

		case ERROR:
			return "";

		case FORMULA: // should not be possible since we already evaluated the cell if needed

		case NUMERIC:
			return String.valueOf(cell.getNumericCellValue());

		case STRING:
			return cell.getStringCellValue();

		case _NONE:
			try {
				return cell.getStringCellValue();
			} catch (Exception e) {
				return "";
			}

		default:
			return cell.getStringCellValue();

		}
		
	}

}
