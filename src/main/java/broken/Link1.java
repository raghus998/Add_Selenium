package broken;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Link1 {
	@Test
	public void testLinks() throws InterruptedException {
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		driver.get("https://www.guru99.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		List<WebElement> links = driver.findElements(By.tagName("a"));
		int totNoOfLinks = links.size();
		System.out.println("Total no of Links present om Webpage are : " + totNoOfLinks);
		for (int i = 0; i < totNoOfLinks; i++) {
			WebElement link = links.get(i);
			String href = link.getAttribute("href");
			LinkUtlity.responseForLink(href);
			System.out.println("-----------------------------------------------------");
			Thread.sleep(2000);
		}
		driver.close();
	}

	

}
