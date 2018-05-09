package mapSynqTest;

import org.testng.annotations.Test;
import org.json.JSONObject;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import mapSynqPages.directionClass;
import utility.businessClass;
import utility.parseJsonClass;


public class mapSynqTestClass extends businessClass{

	parseJsonClass pjc= new parseJsonClass();
	String browserUrl="";
	directionClass dc = new directionClass();
	//WebDriver dr = getDriver();
	JSONObject jsonObj= null;

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
	public void ValidateDirectionDisplayedForFilledSourceAndDestination()
	{   
		try
		{
			String SourceLoc=pjc.parseJsonTestData(jsonObj, "ValidateDirectionDisplayedForFilledSourceAndDestination", "Source");
			String DestLoc= pjc.parseJsonTestData(jsonObj, "ValidateDirectionDisplayedForFilledSourceAndDestination", "Destination");
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

	@Test(priority = 2, enabled=true, description = "Open a browser with http://www.mapsynq.com/ url")
	public void  ValidateAndClickOnAlertForAllCheckboxesUnchecked()
	{
		try
		{	
			String SourceLoc=pjc.parseJsonTestData(jsonObj, "testMapDirectionWithAllOptionsDisabled", "Source");
			String DestLoc= pjc.parseJsonTestData(jsonObj, "testMapDirectionWithAllOptionsDisabled", "Destination");
			dc.uncheckAllCheckBoxes();
			dc.setLocationsAndClickDirectionBtn(SourceLoc, DestLoc);
			String alertText = getAlertMessage();
			if(alertText.equalsIgnoreCase("We are unable to find the directions for given from/to. Please try again."))
			{
				System.out.println("Valid Alert Message is displayed when None of the checkboxes are checked before clicking on Get Directions");
				clickOnAlert();
			}
			else
			{
				System.out.println("InValid Alert Message is displayed when None of the checkboxes are checked before clicking on Get Directions");
				System.exit(1);
			}	
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	@Test(priority = 3, enabled=true, description = "Open a browser with http://www.mapsynq.com/ url")
	public void  ValidateDirectionDisplayedForAllCheckboxesChecked()
	{
		try
		{
			String SourceLoc=pjc.parseJsonTestData(jsonObj, "testMapDirectionWithAllOptionsEnabled", "Source");
			String DestLoc= pjc.parseJsonTestData(jsonObj, "testMapDirectionWithAllOptionsEnabled", "Destination");

			dc.setLocation(SourceLoc, DestLoc);
			dc.checkAllCheckBoxes();
			dc.getGetDirectionsBtn().click();
			if(dc.ValidateTravelTimeDistanceDisplayedAsPerCheckBoxChecked("ALL"))
			{
				System.out.println("The direction is displayed for all the checkboxes checked");
			}
			else
			{
				System.out.println("The direction is not displayed for all the checkboxes checked");
				System.exit(1);
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}

	@Test(priority = 4, enabled=true, description = "Open a browser with http://www.mapsynq.com/ url")
	public void  ValidateDirectionDisplayedForSelectedCheckBox()
	{
		try
		{
			String SourceLoc=pjc.parseJsonTestData(jsonObj, "testMapDirectionWithFastestOptionEnabledOnly", "Source");
			String DestLoc= pjc.parseJsonTestData(jsonObj, "testMapDirectionWithFastestOptionEnabledOnly", "Destination");
			dc.setLocation(SourceLoc, DestLoc);
			dc.uncheckAllCheckBoxes();
			if(dc.selectCheckBox("Fastest") == true && dc.selectCheckBox("Shortest") == true)
			{
				dc.getGetDirectionsBtn().click();
				if(dc.ValidateTravelTimeDistanceDisplayedAsPerCheckBoxChecked("Fastest") == true && dc.ValidateTravelTimeDistanceDisplayedAsPerCheckBoxChecked("Shortest") == true)
				{
					System.out.println("The Travel Time Distance is displayed as per the checkboxes checked");
				}
				else
				{
					System.out.println("The Travel Time Distance is not displayed as per the checkboxes checked");
					System.exit(1);
				}
			}
			else
			{
				System.out.println("Unable to check the CheckBox");
				System.exit(1);
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	@Test(priority = 5, enabled=true, description = "Open a browser with http://www.mapsynq.com/ url")
	public void  ValidateDirectionDisplayedForTollAwareCheckBox()
	{
		try
		{
			String SourceLoc=pjc.parseJsonTestData(jsonObj, "testMapDirectionWithTollAwareOptionEnabledOnly", "Source");
			String DestLoc= pjc.parseJsonTestData(jsonObj, "testMapDirectionWithTollAwareOptionEnabledOnly", "Destination");
			dc.setLocation(SourceLoc, DestLoc);
			dc.uncheckAllCheckBoxes();
			if(dc.selectCheckBox("TOLLAWARE"))
			{
				dc.getGetDirectionsBtn().click();
				if(dc.ValidateTravelTimeDistanceDisplayedAsPerCheckBoxChecked("TOLLAWARE"))
				{
					System.out.println("The Travel Time Distance is displayed as for Toll Aware checkbox");
				}
				else
				{
					System.out.println("The Travel Time Distance is NOT displayed as for Toll Aware checkbox");
					System.exit(1);
				}
			}
			else
			{
				System.out.println("Unable to check the CheckBox");
				System.exit(1);
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	@Test(priority = 6, enabled=true, description = "Open a browser with http://www.mapsynq.com/ url")
	public void  ValidateDirectionDisplayedForTrafficAwareCheckBox()
	{
		try
		{
			String SourceLoc=pjc.parseJsonTestData(jsonObj, "testMapDirectionWithTrafficAwareOptionEnabledOnly", "Source");
			String DestLoc= pjc.parseJsonTestData(jsonObj, "testMapDirectionWithTrafficAwareOptionEnabledOnly", "Destination");
			dc.setLocation(SourceLoc, DestLoc);
			dc.uncheckAllCheckBoxes();
			if(dc.selectCheckBox("TRAFFICAWARE"))
			{
				dc.getGetDirectionsBtn().click();
				if(dc.ValidateTravelTimeDistanceDisplayedAsPerCheckBoxChecked("TRAFFICAWARE"))
				{
					System.out.println("The Travel Time Distance is displayed as for TRAFFICAWARE checkbox");
				}
				else
				{
					System.out.println("The Travel Time Distance is NOT displayed as for TRAFFICAWARE checkbox");
					System.exit(1);
				}
			}
			else
			{
				System.out.println("Unable to check the CheckBox");
				System.exit(1);
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	@Test(priority = 7, enabled=true, description = "Open a browser with http://www.mapsynq.com/ url")
	public void  ValidateDirectionDisplayedForFastestCheckBox()
	{
		try
		{
			String SourceLoc=pjc.parseJsonTestData(jsonObj, "testMapDirectionWithFastestOptionEnabledOnly", "Source");
			String DestLoc= pjc.parseJsonTestData(jsonObj, "testMapDirectionWithFastestOptionEnabledOnly", "Destination");
			dc.setLocation(SourceLoc, DestLoc);
			dc.uncheckAllCheckBoxes();
			if(dc.selectCheckBox("Fastest"))
			{
				dc.getGetDirectionsBtn().click();
				if(dc.ValidateTravelTimeDistanceDisplayedAsPerCheckBoxChecked("Fastest"))
				{
					System.out.println("The Travel Time Distance is displayed as for Fastest checkbox");
				}
				else
				{
					System.out.println("The Travel Time Distance is NOT displayed as for Fastest checkbox");
					System.exit(1);
				}
			}
			else
			{
				System.out.println("Unable to check the CheckBox");
				System.exit(1);
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	@Test(priority = 8, enabled=true, description = "Open a browser with http://www.mapsynq.com/ url")
	public void  ValidateDirectionDisplayedForShortestCheckBox()
	{
		try
		{
			String SourceLoc=pjc.parseJsonTestData(jsonObj, "testMapDirectionWithShortestOptionEnabledOnly", "Source");
			String DestLoc= pjc.parseJsonTestData(jsonObj, "testMapDirectionWithShortestOptionEnabledOnly", "Destination");
			dc.setLocation(SourceLoc, DestLoc);
			dc.uncheckAllCheckBoxes();
			if(dc.selectCheckBox("Shortest"))
			{
				dc.getGetDirectionsBtn().click();
				if(dc.ValidateTravelTimeDistanceDisplayedAsPerCheckBoxChecked("Shortest"))
				{
					System.out.println("The Travel Time Distance is displayed as for Shortest checkbox");
				}
				else
				{
					System.out.println("The Travel Time Distance is NOT displayed as for Shortest checkbox");
					System.exit(1);
				}
			}
			else
			{
				System.out.println("Unable to check the CheckBox");
				System.exit(1);
			}
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
	}
	
	@AfterMethod
	public void afterMethod()
	{
		System.out.println("Aftet method");
	}

	@AfterTest
	public void afterTest()
	{
		System.out.println("Aftet test");

	}

	@AfterSuite
	public void afterSuite()
	{
		dr.close();
	}
}
