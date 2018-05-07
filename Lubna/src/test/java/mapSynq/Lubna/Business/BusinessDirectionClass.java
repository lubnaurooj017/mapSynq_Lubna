package mapSynq.Lubna.Business;

import org.openqa.selenium.WebDriver;

import mapSynq.Lubna.Directions.directionClass;

public class BusinessDirectionClass extends directionClass{

	utilityClass uc= new utilityClass(dr);
	public BusinessDirectionClass(WebDriver dr) {
		super(dr);
	}

	public boolean getDirections(String strSourceLoc, String strDestinationLoc) 
	{
		//Clicking on the Directions Tab
		getDirectionTab().click();

		//Clicking on clear Route Button
		getClearBtn().click();

		//Set Source Location
		getSourceLocation().sendKeys(strSourceLoc);
		boolean sourceSelected = uc.selectValuesFromBootstrapDropdowns(strSourceLoc);
		if(sourceSelected)
		{
			//Set Destination Location
			getDestinationLocation().sendKeys(strDestinationLoc);
			boolean destinationSelected = uc.selectValuesFromBootstrapDropdowns(strDestinationLoc);
			if(destinationSelected)
			{
				//Click on Get Directions Button
				getGetDirectionsBtn().click();
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
}
