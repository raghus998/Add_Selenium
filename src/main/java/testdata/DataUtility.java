package testdata;

import java.io.FileInputStream;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class DataUtility 
{
	public static String getPropertiesData(String key)
	{
		Properties p = new Properties();
		try 
		{
			FileInputStream fis = new FileInputStream("./data/data.properties");
			p.load(fis);
			String value = p.getProperty(key);
			return value;
		} 
		catch (Exception e) 
		{
			return " ";
		}
		
	}
	
	public static String getNumaricData(String sheetName,int rn,int cn)
	{
		try 
		{
			FileInputStream fis = new FileInputStream("./data/inputs.xls");
			Workbook wb = WorkbookFactory.create(fis);
			Cell c = wb.getSheet(sheetName).getRow(rn).getCell(cn);
			DataFormatter d = new DataFormatter();
			String no = d.formatCellValue(c);
			return no;
		} 
		catch (Exception e) 
		{
			return " ";
		}
	}

}
