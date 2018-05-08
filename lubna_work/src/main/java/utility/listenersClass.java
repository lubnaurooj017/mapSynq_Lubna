package utility;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;



public class listenersClass extends businessClass implements ITestListener{
	
	private String timestamp()
	{
		return new SimpleDateFormat("yyyy-MM-dd HH-mm-ss").format(new Date());
	}
	
	static String filePath = System.getProperty("user.dir") + "/Screenshots/";
	public void captureScreenshot(String screenshotName)
	{
		File scrFile = ((TakesScreenshot) dr).getScreenshotAs(OutputType.FILE);
		try
		{
			FileUtils.copyFile(scrFile, new File(filePath + screenshotName + ".png"));
			System.out.println("***Placed screen shot in " + filePath + " ***");
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
	}
	
	@Override
	public void onTestStart(ITestResult result) {
		
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("Test Case : " + result.getName() + " Passed and details are captured in the Screenshot and Logs");
		captureScreenshot(result.getName() + "_" + timestamp());
		
	}

	@Override
	public void onTestFailure(ITestResult result) {
		System.out.println("Test Case : " + result.getName() + " Failed and details are captured in the Screenshot and Logs");
		captureScreenshot(result.getName() + "_" + timestamp());
		
	}

	@Override
	public void onTestSkipped(ITestResult result) {
		System.out.println("Test Case : " + result.getName() + " Skipped and details are captured in the Screenshot and Logs");
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
		
	}

	@Override
	public void onStart(ITestContext context) {
		
		
	}

	@Override
	public void onFinish(ITestContext context) {
		
	}

}
