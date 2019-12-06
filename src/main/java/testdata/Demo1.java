package testdata;

import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.Test;

public class Demo1 
{	
	@Test
	public void read() throws Exception
	{
		FileInputStream fis = new FileInputStream("./data/inputs.xls");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet("Sheet1");
		Cell c = sh.getRow(0).getCell(0);
		
		DataFormatter d = new DataFormatter();
		String no = d.formatCellValue(c);
		System.out.println(no);
	}
}
