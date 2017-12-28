package data;

import org.apache.poi.ss.usermodel.Sheet;

public class ExcelWorksheet 
{
	private final String sheetName;
	private final ExcelWorkbook workbook;
	
	public ExcelWorksheet(ExcelWorkbook workbook, String sheetName) 
	{
		this.sheetName = sheetName;
		this.workbook = workbook;
	}
	
	public Sheet getSheet() 
	{
		Sheet sheet = workbook.getWorkbook().getSheet(sheetName);
		if(sheet == null) {
			throw new java.lang.UnsupportedOperationException("Worksheet with name '"+sheetName+"' does not exist in "+workbook.getWorkbookName());
		} else {
			return sheet;
		}
	}
	
	public ExcelWorkbook getWorkbook() 
	{
		return workbook;
	}
}
