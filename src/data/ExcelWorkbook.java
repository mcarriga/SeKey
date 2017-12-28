package data;

import org.apache.commons.io.FilenameUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExcelWorkbook 
{
	private final String fileName;
	private final Workbook workbook;
	
	public ExcelWorkbook(String workBookFileName) throws FileNotFoundException, IOException 
	{
		this(new File(workBookFileName));
	}
	
	public ExcelWorkbook(File file) throws FileNotFoundException, IOException 
	{
		this.fileName = file.getName();
		String extension = FilenameUtils.getExtension(file.getName());
		FileInputStream excelFile = new FileInputStream(file);
		if(extension.equalsIgnoreCase("xlsx")) {
			workbook = new XSSFWorkbook(excelFile);
		} else if (extension.equalsIgnoreCase("xls")) {
			workbook = new HSSFWorkbook(excelFile);
		} else {
			excelFile.close();
			throw new java.lang.UnsupportedOperationException("File type: "+extension+" is not supported");
		}
		//excelFile.close();
	}

	public Workbook getWorkbook() 
	{
		return workbook;
	}
	
	public String getWorkbookName() 
	{
		return fileName;
	}
}
