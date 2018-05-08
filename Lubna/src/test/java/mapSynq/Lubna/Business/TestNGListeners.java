package mapSynq.Lubna.Business;


import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import mapSynq.Lubna.BaseClass;
import mapSynq.Lubna.TestCases.mapSynqTest;



public class TestNGListeners implements ITestListener{

	BaseClass bs = new BaseClass();
	WebDriver dr = bs.getDriver();

	mapSynqTest stst= new mapSynqTest();
	private String timestamp()
	{
		return new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(new Date());
	}

	@Override
	public void onTestStart(ITestResult result) 
	{
		
	}

	@Override
	public void onTestSuccess(ITestResult result) 
	{
		System.out.println("Test Case : " + result.getName() + " Passed and details are captured in the Screenshot and Logs");
		stst.captureScreenshot(result.getName() + "_" + timestamp());
	}

	@Override
	public void onTestFailure(ITestResult result) 
	{
		System.out.println("Test Case : " + result.getName() + " Failed and details are captured in the Screenshot and Logs");
		stst.captureScreenshot(result.getName() + "_" + timestamp());
	}
	

	@Override
	public void onTestSkipped(ITestResult result) 
	{
		System.out.println("Test Case : " + result.getName() + " Skipped and details are captured in the Screenshot and Logs");
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
