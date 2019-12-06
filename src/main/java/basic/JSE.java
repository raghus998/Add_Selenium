package basic;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class JSE
{
	@Test
	public void testA() throws InterruptedException
	{
		WebDriverManager.firefoxdriver().setup();
		WebDriver driver = new FirefoxDriver();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get("https://ksrtc.in/oprs-web/guest/home.do?h=1");
		WebElement fromPlaceName = driver.findElement(By.id("fromPlaceName"));
		//fromPlaceName.sendKeys(Keys.SHIFT+"ban");
		Actions act = new Actions(driver);
		act.moveToElement(fromPlaceName).click().keyDown(Keys.SHIFT).sendKeys("ban").perform();
		for (int i = 0; i <= 5; i++) 
		{
			fromPlaceName.sendKeys(Keys.DOWN);
			Thread.sleep(2000);
		}
		System.out.println(fromPlaceName.getText());
		String stmt = " return document.getElementById('fromPlaceName').value";
		JavascriptExecutor js = (JavascriptExecutor) driver;
		String cityName = (String) js.executeScript(stmt);
		System.out.println(cityName);
		driver.close();
	}

}
