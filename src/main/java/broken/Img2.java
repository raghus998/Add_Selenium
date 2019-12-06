package broken;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Img2 
{
	@Test
	public void testImages() throws Exception
	{
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("file:///D:/RS/HTMLFiles/Add_Selenium/images.html");
		List<WebElement> allImages = driver.findElements(By.xpath("//img"));
		System.out.println(allImages.size());
		for (WebElement image : allImages)
		{
			String src = image.getAttribute("src");
			URL url = new URL(src);
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			int code = con.getResponseCode();
			System.out.println("The "+src+" image response code is :"+code);
		}
		driver.close();
	}
}
