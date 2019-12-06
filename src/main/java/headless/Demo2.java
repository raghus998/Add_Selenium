package headless;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Demo2 
{
	static
	{
		WebDriverManager.phantomjs().setup();
	}
	@Test
	public void Demo2() throws IOException
	{
		WebDriver driver = new PhantomJSDriver();
		driver.manage().window().maximize();
		driver.get("https://demo.actitime.com/login.do");
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getTitle());
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File("./screenshots/name2.png");
		FileUtils.copyFile(src, dest);
		driver.close();
	}

}
