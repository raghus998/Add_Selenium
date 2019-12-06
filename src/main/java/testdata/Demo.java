package testdata;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.testng.Reporter;
import org.testng.annotations.Test;

public class Demo 
{
	@Test
	public void test() throws IOException
	{
		File f = new File("./data/data.properties");
		FileInputStream fis = new FileInputStream(f);
		Properties p = new Properties();
		p.load(fis);
		String un = p.getProperty("un");
		String pw = p.getProperty("pw");
		Reporter.log("Username is : "+un,true);
		Reporter.log("Password is "+pw,true);
	}

}
