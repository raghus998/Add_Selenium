package broken;

import java.net.HttpURLConnection;
import java.net.URL;
import org.testng.annotations.Test;

public class Link 
{
	@Test
	public void testlink() throws Exception
	{
		String demourl = "https://selenium.dev/downloads/csac";
		//Create a object of URL class 
		URL url = new URL(demourl);
		
		//establish the conection
		HttpURLConnection httpUrlConcection = (HttpURLConnection) url.openConnection();
		
		httpUrlConcection.setConnectTimeout(2000);
		
		//connect to url
		httpUrlConcection.connect();
		if(httpUrlConcection.getResponseCode() == 200)
		{
			System.out.println(demourl +"is not broken..."+httpUrlConcection.getResponseCode()+httpUrlConcection.getResponseMessage());
		}
		else
		{
			System.out.println(demourl +"is  broken..."+httpUrlConcection.getResponseCode()+httpUrlConcection.getResponseMessage());
			
		}
		
	}

}
