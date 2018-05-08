package mapSynq.Lubna.Business;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import mapSynq.Lubna.BaseClass;
import mapSynq.Lubna.Directions.directionClass;


public class utilityClass{	
	
	
	BaseClass bs = new BaseClass();
	WebDriver dr = bs.getDriver();
	directionClass dc = new directionClass();
	public boolean selectValuesFromBootstrapDropdowns(String location) 
	{
		WebDriverWait wait = new WebDriverWait(dr,20);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[starts-with(@id,'Autocomplete_')]//div[2][starts-with(@title,'" + location + "')]")));		
		List<WebElement> wl= dc.getLocationBootstrapDropdown();

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
	
	public String getAlertMessage()
	{
		Alert alert = dr.switchTo().alert();
		String alertText = alert.getText();
		return alertText;
	}
	
	public void clickOnAlert()
	{
		Alert alert = dr.switchTo().alert();
		alert.accept();
	}
}
