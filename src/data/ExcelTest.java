package data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellValue;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Row.MissingCellPolicy;

public class ExcelTest {
	private final ExcelWorksheet sheet;
	private final int startRowNum;
	private final int endRowNum;
	private final String TestCaseName;
	private final String TestCaseId;
	private final String suiteName;
	private List<ExcelTestStep> testSteps = new ArrayList<ExcelTestStep>();
	
	public ExcelTest(ExcelWorksheet sheet, int startRowNum, int endRowNum, String suiteName, String TestCaseName, String TestCaseId) {
		this.sheet = sheet;
		this.startRowNum = startRowNum;
		this.endRowNum = endRowNum;
		this.suiteName = suiteName;
		this.TestCaseName = TestCaseName;
		this.TestCaseId = TestCaseId;
		init();
	}
	
	public String getTestName() {
		return TestCaseName;
	}
	
	public String getTestId() {
		return TestCaseId;
	}
	
	public String getSuiteName() {
		return suiteName;
	}
	
	public List<ExcelTestStep> getTestSteps(){
		return testSteps;
	}
	
	private void init() {
		for(int i = startRowNum; i<= endRowNum; i++) {
			Row testStep = sheet.getSheet().getRow(i);
			String keyword = testStep.getCell(1, MissingCellPolicy.RETURN_NULL_AND_BLANK).getStringCellValue();
			List<String> objects = new ArrayList<String>();
			
			Cell cell = testStep.getCell(2, MissingCellPolicy.RETURN_NULL_AND_BLANK);
			if(cell != null) {
				objects = Arrays.asList(cell.getStringCellValue().split("\\|"));
			}

			List<String> params = getParams( testStep.getCell(3, MissingCellPolicy.RETURN_NULL_AND_BLANK));
			
			testSteps.add(new ExcelTestStep(keyword, objects, params));
		}
	}
	
	private List<String> getParams(Cell cell) {
		List<String> values = new ArrayList<String>();
		FormulaEvaluator evaluator = sheet.getWorkbook().getWorkbook().getCreationHelper().createFormulaEvaluator();
		CellValue cellValue = evaluator.evaluate(cell);
		if(cellValue == null) {
			values = Arrays.asList("");
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
			String[] valsString = cell.getStringCellValue().split("\\|");
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
