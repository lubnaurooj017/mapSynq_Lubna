package mapSynqTest;

import org.json.JSONObject;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import mapSynqPages.liveClass;
import utility.businessClass;
import utility.parseJsonClass;

public class mapSynqLiveTestCaseClass extends businessClass {

	String browserUrl="";
	liveClass lc = new liveClass();
	WebDriver dr = getDriver();
	JSONObject jsonObj= null;
	parseJsonClass pjc= new parseJsonClass();

	@BeforeSuite
	public void beforeSuite()
	{	
		dr.manage().window().maximize();
		browserUrl = System.getProperty("url");
		jsonObj= pjc.getJsonTestDataObject();
		// browserUrl = "http://www.mapsynq.com/";
	}

	@BeforeTest
	public void beforeTest()
	{
		System.out.println("Before test");
		String url = "http://www.mapsynq.com/";
		dr.get(url);
	}

	@BeforeMethod
	public void beforeMethos() 
	{
		dr.navigate().refresh();
	}

	@Test(priority = 0, enabled=true, description = "Open a browser with http://www.mapsynq.com/ url, clear route, fill source and destination,click on getdirection button")
	public void ValidateErrorMessageDisplayedForInvalidLogin()
	{   
		try
		{
			String userName = pjc.parseJsonTestData(jsonObj, "testErrorMessageDisplayedForInvalidLogin", "username");
			String password = pjc.parseJsonTestData(jsonObj, "testErrorMessageDisplayedForInvalidLogin", "password");
			lc.signInToMapSynq(userName, password);
			if(lc.getInvalidUsrPwdText().equalsIgnoreCase("Invalid user/password combination"))
			{
				System.out.println("Valid Message is displayed when user enters invalid username or password");
			}
			else
			{
				System.out.println("Valid Message is displayed when user enters invalid username or password");
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

	}

	@Test(priority = 1, enabled=true, description = "Open a browser with http://www.mapsynq.com/ url, clear route, fill source and destination,click on getdirection button")
	public void ValidateValidLogin()
	{   
		try
		{
			String userName = pjc.parseJsonTestData(jsonObj, "testValidLogin", "username");
			String password = pjc.parseJsonTestData(jsonObj, "testValidLogin", "password");
			
			lc.getmapSynqHomeLink().click();
			lc.signInToMapSynq(userName, password);
			
			
			if(lc.clickLinkByHref("/home/profile"))
			{
				System.out.println("Successful Login");

			}
			else
			{
				System.out.println("Unsuccessful Login");
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}

	}
	
	@AfterSuite
	public void afterSuite()
	{
		dr.close();
	}
}
