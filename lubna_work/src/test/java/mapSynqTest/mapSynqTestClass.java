package mapSynqTest;

import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import mapSynqPages.directionClass;
import utility.businessClass;


public class mapSynqTestClass extends businessClass{
	
	String browserUrl="";
	directionClass dc = new directionClass();
	WebDriver dr = getDriver();
	@BeforeSuite
	public void beforeSuite()
	{	
		dr.manage().window().maximize();
		browserUrl = System.getProperty("url");
		// browserUrl = "http://www.mapsynq.com/";
	}

	@BeforeTest
	public void beforeTest()
	{
		System.out.println("Before test");
		String url = browserUrl; //"http://www.mapsynq.com/";
		dr.get(url);
	}

	@Test(priority = 0, description = "Open a browser with http://www.mapsynq.com/ url, clear route, fill source and destination,click on getdirection button")
	public void ValidateDirectionDisplayedForFilledSourceAndDestination() 
	{   
		try
		{
			String SourceLoc="BEDOK";
			String DestLoc= "PUNGGOL";
			if(dc.getDirections(SourceLoc, DestLoc))
			{
				System.out.println("The direction between" + SourceLoc + " and " + DestLoc +" Is Displayed");
			}
			else
			{
				System.out.println("The direction between" + SourceLoc + " and " + DestLoc +" Is Displayed");
				System.exit(1);
			}
		}
		catch (Exception e)
		{

			e.printStackTrace();

		}

	}
	
	@Test(priority = 1, enabled=true, description = "Open a browser with http://www.mapsynq.com/ url")		
	public void ValidateAndClickAlertForUnfilledSourceAndDestination()
	{

		try
		{
			dc.getDirectionsForUnfilledLocations();
			String alertText = getAlertMessage();
			if(alertText.equalsIgnoreCase("Please enter route Start and Destination."))
			{
				System.out.println("Valid Alert Message is displayed when either Source or Destination or Both are left unfilled");
				clickOnAlert();
			}
			else
			{
				System.out.println("InValid Alert Message is displayed when either Source or Destination or Both are left unfilled");
				System.exit(1);
			}
		}
		catch (Exception e)
		{

			e.printStackTrace();

		}
	}

	
	@AfterTest
	public void afterTest()
	{
		System.out.println("Aftet test");
	}

	@AfterSuite
	public void afterSuite()
	{
		//dr.close();
	}
}
