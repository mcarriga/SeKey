package data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
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
		for(int i = startRowNum; i< endRowNum; i++) {
			Row testStep = sheet.getSheet().getRow(i);
			String keyword = testStep.getCell(1, MissingCellPolicy.RETURN_NULL_AND_BLANK).getStringCellValue();
			List<String> objects = Arrays.asList( testStep.getCell(2, MissingCellPolicy.RETURN_NULL_AND_BLANK).getStringCellValue().split("\\|"));
			List<Object> params = getParams( testStep.getCell(3, MissingCellPolicy.RETURN_NULL_AND_BLANK));
			
			testSteps.add(new ExcelTestStep(keyword, objects, params));
		}
	}
	
	private List<Object> getParams(Cell cell) {
		List<Object> values = new ArrayList<Object>();
		FormulaEvaluator evaluator = sheet.getWorkbook().getWorkbook().getCreationHelper().createFormulaEvaluator();
		switch(evaluator.evaluateFormulaCellEnum(cell)) {
		case BLANK:
			Object[] vals = cell.getStringCellValue().split("\\|");
			values = Arrays.asList(vals);
			break;
		case BOOLEAN:
			values = Arrays.asList(cell.getBooleanCellValue());
			break;
		case ERROR:
			values = Arrays.asList("");
			break;
		case FORMULA: // should not be possible since we already evaluated the cell if needed
			break;
		case NUMERIC:
			values = Arrays.asList(cell.getNumericCellValue());
			break;
		case STRING:
			Object[] valsString = cell.getStringCellValue().split("\\|");
			values = Arrays.asList(valsString);
			break;
		case _NONE:
			Object[] valsNone = cell.getStringCellValue().split("\\|");
			values = Arrays.asList(valsNone);
			break;
		default:
			values = Arrays.asList("");
			break;
		}
		
		return values;
	}
}
