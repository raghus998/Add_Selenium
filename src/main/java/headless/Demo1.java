package headless;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Demo1 
{
	static
	{
		WebDriverManager.firefoxdriver().setup();
	}
	@Test
	public void Demo1() throws IOException
	{
		FirefoxOptions op = new FirefoxOptions();
		String name = op.getBrowserName();
		op.setHeadless(true);
		System.out.println("Browser Name is :"+name);
		WebDriver driver = new FirefoxDriver(op);
		driver.manage().window().maximize();
		driver.get("https://demo.actitime.com/login.do");
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getTitle());
		TakesScreenshot ts = (TakesScreenshot) driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File("./screenshots/name1.png");
		FileUtils.copyFile(src, dest);
		driver.close();
	}

}
