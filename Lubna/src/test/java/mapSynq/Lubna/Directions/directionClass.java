package mapSynq.Lubna.Directions;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import mapSynq.Lubna.BaseClass;

public class directionClass extends BaseClass {
	public WebDriver dr;
	public directionClass(WebDriver dr)
	{
		this.dr = dr;
	}

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
	
}
