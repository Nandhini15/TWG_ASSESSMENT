package twg.entaxy.utils;

import java.io.FileInputStream;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

public class ExcelUtil {
	
	HSSFWorkbook workbook;
	HSSFSheet sheet;

	public ExcelUtil(String filePath, int index)
	{
		try
		{
		FileInputStream fis = new FileInputStream("./src/test/resources/Login.xls");
		workbook = new HSSFWorkbook(fis);
		sheet = workbook.getSheetAt(index);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	public String getCellValue(int rowNo, int colNo)
	{
		HSSFRow row = sheet.getRow(rowNo);
		HSSFCell cell = row.getCell(colNo);
		return cell.toString();
	}
	public int getRowCount()
	{
		return sheet.getLastRowNum();
	}
}
