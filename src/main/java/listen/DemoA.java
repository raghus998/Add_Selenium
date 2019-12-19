package listen;

import org.testng.Assert;
import org.testng.Reporter;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

//@Listeners(value = DemoListen.class)
public class DemoA {

	@Test
	public void TestA()
	{
		Reporter.log("TestA.... ",true);
	}
	
	@Test
	public void TestB()
	{
		Reporter.log("TestB.... ",true);
		Assert.fail();
	}
}
