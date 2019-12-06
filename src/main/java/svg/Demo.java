package svg;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Demo
{
	@Test
	public void testSvg1() throws InterruptedException
	{
		int count = 0;
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("file:///D:/Raghu/Add_Selenium/add_selenium/htmlfiles/SVG.html");
		List<WebElement> allElements = driver.findElements(By.xpath("//*"));
		Actions act = new Actions(driver);
		for (WebElement lines : allElements) 
		{
			String tName = lines.getTagName();
			if(tName.equals("line"))
			{	
				count++;
			
				String bcolor = lines.getCssValue("stroke");
				System.out.println("Before Moving the cousor the Line color is :"+bcolor);
				
				act.moveToElement(lines).perform();
				Thread.sleep(2000);
				
				String acolor = lines.getCssValue("stroke");
				System.out.println("After Moving the cousor the Line color is :"+acolor);
				
				Thread.sleep(2000);
				WebElement toolTip = lines.findElement(By.xpath("./following-sibling::*[1]/*[2]"));
				String tText = toolTip.getText();
				System.out.println("Tool Tip text :"+tText);
				System.out.println("---------------------------------------------------------------");
			}
		}
		System.out.println("Total No of Lines are : "+count);
		driver.close();
	}

}
