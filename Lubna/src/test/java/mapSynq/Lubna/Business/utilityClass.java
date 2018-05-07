package mapSynq.Lubna.Business;

import java.io.File;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import mapSynq.Lubna.Directions.directionClass;

public class utilityClass extends directionClass{	

	public utilityClass(WebDriver dr) {
		super(dr);
	}
	String filePath = System.getProperty("user.dir") + "/Screenshots/";
	
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

	public void captureScreenshot(WebDriver driver,String screenshotName)
	{

		try 
		{			
			TakesScreenshot ts=(TakesScreenshot)driver;

			File source=ts.getScreenshotAs(OutputType.FILE);

			FileUtils.copyFile(source, new File(filePath+"_"+screenshotName+".png"));

			System.out.println("Screenshot taken");
		} 
		catch (Exception e)
		{

			System.out.println("Exception while taking screenshot "+e.getMessage());
		} 
	}
}
