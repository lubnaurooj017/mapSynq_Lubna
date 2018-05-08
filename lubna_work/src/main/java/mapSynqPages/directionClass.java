package mapSynqPages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utility.businessClass;

public class directionClass extends businessClass{

	public By trafficAware  = By.id("also_traffic");
	public By fastest       = By.id("also_fastest");
	public By tollAware     = By.id("also_erp");
	public By shortest      = By.id("also_shortest");
	public By fromLoc       = By.id("poi_from");
	public By toLoc         = By.id("poi_to");
	public By clearBtn      = By.id("btnClear");
	public By getDirectionBtn = By.id("get_direction");
	public By directionsTab   = By.xpath("//a[@data-tabid='0']");
	public By locationDropDown = By.xpath("//div[starts-with(@id, 'Autocomplete_') and @class = 'autocomplete']/div");
	public String selectTimeDropwDown ="slJourneyTimeTraffic";
	
	public WebElement getDirectionTab()
	{
		return dr.findElement(directionsTab);
	}

	public WebElement getClearBtn()
	{
		return dr.findElement(clearBtn);
	}

	public WebElement getSourceLocation()
	{
		return dr.findElement(fromLoc);

	}

	public WebElement getDestinationLocation()
	{
		return dr.findElement(toLoc);
	}

	public WebElement getGetDirectionsBtn()
	{
		return dr.findElement(getDirectionBtn);
	}

	public WebElement getTrafficAwareCheckBox()
	{
		return dr.findElement(trafficAware);
	}

	public WebElement getFastestCheckBox()
	{
		return dr.findElement(fastest);
	}

	public WebElement getTollAwareCheckBox()
	{
		return dr.findElement(tollAware);
	}

	public WebElement getShortestCheckBox()
	{
		return dr.findElement(shortest);
	}

	public List<WebElement> getLocationBootstrapDropdown()
	{
		return dr.findElements(locationDropDown);
	}
	
	public String getSelectTimeDropDown()
	{
		return selectTimeDropwDown;
	}

	public boolean getDirections(String strSourceLoc, String strDestinationLoc) 
	{
		//Clicking on the Directions Tab
		getDirectionTab().click();

		//Clicking on clear Route Button
		getClearBtn().click();

		//Set Source Location
		getSourceLocation().sendKeys(strSourceLoc);
		boolean sourceSelected = selectValuesFromBootstrapDropdowns(strSourceLoc);
		if(sourceSelected)
		{
			//Set Destination Location
			getDestinationLocation().sendKeys(strDestinationLoc);
			boolean destinationSelected = selectValuesFromBootstrapDropdowns(strDestinationLoc);
			if(destinationSelected)
			{
				//Click on Get Directions Button
				getGetDirectionsBtn().click();
				WebDriverWait wait = new WebDriverWait(dr,20);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(getSelectTimeDropDown())));		

				return true;
			}
			else
			{
				System.out.println("The given Destination " + strDestinationLoc + " is not found.Please input correct value");
				return false;
			}
		}
		else
		{
			System.out.println("The given Source Location " + strSourceLoc + " is not found.Please input correct value");
			return false;
		}
	}
	
	public boolean selectValuesFromBootstrapDropdowns(String location) 
	{
		WebDriverWait wait = new WebDriverWait(dr,20);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[starts-with(@id,'Autocomplete_')]//div[2][starts-with(@title,'" + location + "')]")));		
		List<WebElement> wl= getLocationBootstrapDropdown();

		for(int i=0; i< wl.size(); i++)
		{
			WebElement wel= wl.get(i);
			String drpvalue = wel.getAttribute("title");
			if(drpvalue.equalsIgnoreCase(location))
			{
				wel.click();
				return true;
			}

		}
		return false;
	}
	
	public void getDirectionsForUnfilledLocations()
	{
		getDirectionTab().click();
		getClearBtn().click();
		getGetDirectionsBtn().click();
	}
	
}
