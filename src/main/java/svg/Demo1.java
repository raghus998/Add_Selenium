package svg;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Demo1
{
	@Test
	public void testSvg1() throws InterruptedException 
	{
		int count = 0;
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("file:///D:/Raghu/Add_Selenium/add_selenium/htmlfiles/svgdemo.html");
		List<WebElement> allElements = driver.findElements(By.xpath("//*"));
		for (WebElement circle : allElements) 
		{
			String tName = circle.getTagName();
			if (tName.equals("circle")) 
			{
				count++;
				String cx = circle.getCssValue("cx");
				String cy = circle.getCssValue("cy");
				String fillOpacity = circle.getCssValue("fill-opacity");
				System.out.println("Cx value is :" + cx);
				System.out.println("Cy value is : " + cy);
				System.out.println("Fill Opacity value is :" + fillOpacity);
				System.out.println("==============================================");
			}
		}
		System.out.println("Total No of Circle are :"+count);
		driver.close();
	}
}