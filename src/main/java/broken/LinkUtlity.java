package broken;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class LinkUtlity {
	public static void responseForLink(String link) {
		try {
			URL url = new URL(link);
			HttpURLConnection httpUrlConection = (HttpURLConnection) url.openConnection();
			httpUrlConection.setConnectTimeout(2000);
			httpUrlConection.connect();
			int code = httpUrlConection.getResponseCode();
			String msg = httpUrlConection.getResponseMessage();
			URL url1 = httpUrlConection.getURL();
			if (code == 200) {
				System.out.println(url1 + " is working fine.And response code is :" + code + " response msg is :" + msg);
			} else {
				System.out.println(url1 + " is broken.And response code is :" + code + " response msg is :" + msg);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void getReposneForImg(String src)  
	{
		int Ecode = 200;
		try 
		{
			URL url = new URL(src);
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			int code = con.getResponseCode();
			String msg = con.getResponseMessage();
			SoftAssert sa = new SoftAssert();
			sa.assertEquals(code, Ecode);
			System.out.println(src +" image is not broken and response code is "+code);
		}
		catch (IOException e)
		{
			
			e.printStackTrace();
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
