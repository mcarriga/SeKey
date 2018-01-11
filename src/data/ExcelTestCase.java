package data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellValue;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Row.MissingCellPolicy;

import interfaces.ITestCase;
import interfaces.ITestStep;
/**
 * Implements the ITestCase Interface to produce Test Cases to be ran via the ITestRunner interface
 * This class reads from an ExcelWorsheet with given start and end row numbers and reads the information from those applicable rows to create an ITestCase containing ITestSteps
 */
public class ExcelTestCase implements ITestCase
{
	private final ExcelWorksheet sheet;
	private final int startRowNum;
	private final int endRowNum;
	private final String TestCaseName;
	private final String TestCaseId;
	private final String suiteName;
	private final int keywordIndex = 2;
	private final int objectsIndex = 3;
	private final int paramsIndex = 4;
	private List<ITestStep> testSteps = new ArrayList<ITestStep>();
	
	public ExcelTestCase(ExcelWorksheet sheet, int startRowNum, int endRowNum, String suiteName, String TestCaseName, String TestCaseId) 
	{
		this.sheet = sheet;
		this.startRowNum = startRowNum;
		this.endRowNum = endRowNum;
		this.suiteName = suiteName;
		this.TestCaseName = TestCaseName;
		this.TestCaseId = TestCaseId;
		init();
	}
	
	@Override
	public String getTestName() 
	{
		return TestCaseName;
	}
	
	@Override
	public String getTestId() 
	{
		return TestCaseId;
	}
	
	@Override
	public String getSuiteName() 
	{
		return suiteName;
	}
	
	@Override
	public List<ITestStep> getTestSteps()
	{
		return testSteps;
	}
	
	private void init() 
	{
		for(int i = startRowNum; i<= endRowNum; i++) {
			Row testStep = sheet.getSheet().getRow(i);
			String keyword = testStep.getCell(keywordIndex, MissingCellPolicy.RETURN_NULL_AND_BLANK).getStringCellValue();
			List<String> objects = new ArrayList<String>();
			
			Cell cell = testStep.getCell(objectsIndex, MissingCellPolicy.RETURN_NULL_AND_BLANK);
			if(cell != null) {
				objects = Arrays.asList(cell.getStringCellValue().split("\\|"));
			}

			List<String> params = getParams( testStep.getCell(paramsIndex, MissingCellPolicy.RETURN_NULL_AND_BLANK));
			
			testSteps.add(new ExcelTestStep(keyword, objects, params));
		}
	}
	
	private List<String> getParams(Cell cell) 
	{
		List<String> values = new ArrayList<String>();
		FormulaEvaluator evaluator = sheet.getWorkbook().getWorkbook().getCreationHelper().createFormulaEvaluator();
		CellValue cellValue = evaluator.evaluate(cell);
		if(cellValue == null) {
			return values;
		}
		switch(cellValue.getCellTypeEnum()) {
		case BLANK:
			String[] vals = cell.getStringCellValue().split("\\|");
			values = Arrays.asList(vals);
			break;
		case BOOLEAN:
			values = Arrays.asList(cell.getStringCellValue());
			break;
		case ERROR:
			values = Arrays.asList("");
			break;
		case FORMULA: // should not be possible since we already evaluated the cell if needed
			break;
		case NUMERIC:
			values = Arrays.asList(String.valueOf(cell.getNumericCellValue()));
			break;
		case STRING:
			String[] valsString = cell.getStringCellValue().replaceAll("\\\\n", "\n").replaceAll("\\\\r", "\r").split("\\|");
			values = Arrays.asList(valsString);
			break;
		case _NONE:
			String cellText = null;
			if(cell != null) {
				cellText = cell.getStringCellValue();
			}
			String[] valsNone = null;
			if(cellText != null) {
				valsNone = cellText.split("\\|");
			}
			if(valsNone != null) {
				values = Arrays.asList(valsNone);
			} else {
				values = Arrays.asList("");
			}
			break;
		default:
			values = Arrays.asList("");
			break;
		}
		
		return values;
	}
}
