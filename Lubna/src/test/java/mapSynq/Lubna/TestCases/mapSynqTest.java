package mapSynq.Lubna.TestCases;

import org.testng.annotations.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import mapSynq.Lubna.BaseClass;
import mapSynq.Lubna.Business.BusinessDirectionClass;

public class mapSynqTest {

	WebDriver dr =null;
	String browserUrl="";
	
	@BeforeSuite
	public void beforeSuite()
	{	
		BaseClass baseObj = new BaseClass();
        dr = baseObj.getDriver();	
	    dr.manage().window().maximize();
	    //browserUrl = System.getProperty("url");
	    browserUrl = "http://www.mapsynq.com/";
	}
	
	@Test
	public void validateAndClickAlertForUnfilledSourceAndDestination() 
	{   
		BusinessDirectionClass businessClass = PageFactory.initElements(dr, BusinessDirectionClass.class);
		String url = browserUrl; //"http://www.mapsynq.com/";
		dr.get(url);
		businessClass.getDirections("BEDOK", "PUNGGOL");
		
	}
	
	@AfterSuite
	public void afterSuite()
	{
		//dr.close();
	}
	
}
