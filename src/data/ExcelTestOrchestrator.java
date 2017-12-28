package data;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

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
