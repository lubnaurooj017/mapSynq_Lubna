package mapSynq.Lubna.Business;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import mapSynq.Lubna.BaseClass;
import mapSynq.Lubna.Directions.directionClass;

public class BusinessDirectionClass{

	
	BaseClass bs = new BaseClass();
	WebDriver dr = bs.getDriver();
	directionClass dc = new directionClass();
	utilityClass uc = new utilityClass();

	public boolean getDirections(String strSourceLoc, String strDestinationLoc) 
	{
		//Clicking on the Directions Tab
		dc.getDirectionTab().click();

		//Clicking on clear Route Button
		dc.getClearBtn().click();

		//Set Source Location
		dc.getSourceLocation().sendKeys(strSourceLoc);
		boolean sourceSelected = uc.selectValuesFromBootstrapDropdowns(strSourceLoc);
		if(sourceSelected)
		{
			//Set Destination Location
			dc.getDestinationLocation().sendKeys(strDestinationLoc);
			boolean destinationSelected = uc.selectValuesFromBootstrapDropdowns(strDestinationLoc);
			if(destinationSelected)
			{
				//Click on Get Directions Button
				dc.getGetDirectionsBtn().click();
				WebDriverWait wait = new WebDriverWait(dr,20);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(dc.getSelectTimeDropDown())));		

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
	
	public void getDirectionsForUnfilledLocations()
	{
		dc.getDirectionTab().click();
		dc.getClearBtn().click();
		dc.getGetDirectionsBtn().click();
	}
	
}
