package utility;

import java.io.File;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class businessClass {

	public static WebDriver dr = null;
	public WebDriver getDriver()
	{
		String browserName = System.getProperty("browser");	
		browserName = browserName.toUpperCase();
		//String browserName = "FIREFOX";
		browserName = browserName.toUpperCase();
		switch(browserName) 
		{
		case "CHROME" :
			dr = new ChromeDriver();
			break;
		case "FIREFOX" :
			String vpath = new File("src/driverfile/geckodriver").getAbsolutePath();		
			System.setProperty("webdriver.gecko.driver", vpath);
			dr = new FirefoxDriver();
			break;	
		case "SAFARI" :   ///usr/bin/safaridriver --enable 
			dr = new SafariDriver();
			break;
		}
		return dr;
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
