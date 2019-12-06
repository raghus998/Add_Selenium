package broken;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Img1 
{
	@Test
	public void testImgA() throws Exception
	{
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("file:///D:/RS/HTMLFiles/Add_Selenium/images.html");
		WebElement img = driver.findElement(By.xpath("//img[@value='w3']"));
		String src = img.getAttribute("src");
		System.out.println(src);
		String value = img.getAttribute("value");
		URL url = new URL(src);
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		int code = con.getResponseCode();
		System.out.println("The "+value+" image response code is : "+code);
	}

}
