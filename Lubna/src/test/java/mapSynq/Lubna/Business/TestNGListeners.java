package mapSynq.Lubna.Business;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestNGListeners implements ITestListener{
	
	WebDriver dr = null;
	String filePath = System.getProperty("user.dir") + "/Screenshots/";
	utilityClass objutl= new utilityClass(dr);
	
	private String timestamp()
	{
		// TODO Auto-generated method stub
		// return null;
		return new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(new Date());
	}

	@Override
	public void onTestStart(ITestResult result) 
	{
		
	}

	@Override
	public void onTestSuccess(ITestResult result) 
	{
		System.out.println("Testcase Passes and details are : "+ result.getName());
		objutl.captureScreenshot(dr,result.getName()+timestamp());
	}

	@Override
	public void onTestFailure(ITestResult result) 
	{
		System.out.println("Testcase Failed and details are : "+ result.getName());
		objutl.captureScreenshot(dr,result.getName()+timestamp());
	}
	

	@Override
	public void onTestSkipped(ITestResult result) 
	{
		System.out.println("Testcase Skipped and details are : "+ result.getName());
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result)
	{
		
		
	}

	@Override
	public void onStart(ITestContext context)
	{
		
		
	}

	@Override
	public void onFinish(ITestContext context) 
	{
		
		
	}

}
