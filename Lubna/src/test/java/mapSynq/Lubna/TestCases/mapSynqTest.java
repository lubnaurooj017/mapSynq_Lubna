package mapSynq.Lubna.TestCases;

import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Listeners;

import mapSynq.Lubna.BaseClass;
import mapSynq.Lubna.Business.BusinessDirectionClass;
import mapSynq.Lubna.Business.utilityClass;

public class mapSynqTest {
	
	BaseClass bs = new BaseClass();
	WebDriver dr = bs.getDriver();
	utilityClass utl = new utilityClass();
	
	String browserUrl="";
	BusinessDirectionClass businessClass = PageFactory.initElements(dr, BusinessDirectionClass.class);
	static String filePath = System.getProperty("user.dir") + "/Screenshots/";

	public void captureScreenshot(String screenshotName)
	{
		File scrFile = ((TakesScreenshot) dr).getScreenshotAs(OutputType.FILE);
		try
		{
			FileUtils.copyFile(scrFile, new File(filePath + screenshotName + ".png"));
			System.out.println("***Placed screen shot in " + filePath + " ***");
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}

	@BeforeSuite
	public void beforeSuite()
	{	
		BaseClass baseObj = new BaseClass();
		dr = baseObj.getDriver();	
		dr.manage().window().maximize();
		//browserUrl = System.getProperty("url");
		browserUrl = "http://www.mapsynq.com/";
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
			if(businessClass.getDirections(SourceLoc, DestLoc))
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
	
	@Test(priority = 1, description = "Open a browser with http://www.mapsynq.com/ url")		
	public void ValidateAndClickAlertForUnfilledSourceAndDestination()
	{

		try
		{
			businessClass.getDirectionsForUnfilledLocations();
			String alertText = utl.getAlertMessage();
			if(alertText.equalsIgnoreCase("Please enter route Start and Destination."))
			{
				System.out.println("Valid Alert Message is displayed when either Source or Destination or Both are left unfilled");
				utl.clickOnAlert();
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
