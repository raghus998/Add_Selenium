package broken;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;


import org.testng.annotations.Test;

public class Img
{
	@Test
	public void testImg() throws IOException
	{
		URL url = new URL("https://demo.actitime.com/favicon2.ico");
		HttpURLConnection con = (HttpURLConnection) url.openConnection();
		int code = con.getResponseCode();
		System.out.println(code);
	}

}
