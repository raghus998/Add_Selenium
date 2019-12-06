package broken;

import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Link3
{
	@Test
	public void testLink()
	{
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("file:///D:/Raghu/Add_Selenium/add_selenium/htmlfiles/linkes.html");
		List<WebElement> allLinks = driver.findElements(By.tagName("a"));
		int count = allLinks.size();
		for (int i = 0; i < count; i++)
		{
			WebElement link = allLinks.get(i);
			String href = link.getAttribute("href");
			LinkUtlity.responseForLink(href);
		}
	}

}
