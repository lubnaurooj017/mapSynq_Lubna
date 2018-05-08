package mapSynqPages;


import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import utility.businessClass;

public class liveClass extends businessClass{

	public By userName = By.id("name");
	public By password =  By.id("password");
	public By signinBtn = By.className("button_org");
	public By forgotUserPwdLink = By.linkText("forgot_password");
	public By invalidusrpwdMsg = By.id("notice");						
	public By signInLink = By.linkText("Sign in");
	public By mapSynqHome = By.xpath("//a[@href='http://mapsynq.com']");	

	public WebElement getUserNameField()
	{
		return dr.findElement(userName);
	}

	public WebElement getPasswordField()
	{
		return dr.findElement(password);
	}

	public WebElement getSigninBtn()
	{
		return dr.findElement(signinBtn);
	}

	public WebElement getForgotPwdUserLink()
	{
		return dr.findElement(forgotUserPwdLink);
	}

	public WebElement getInvalidUsrPwdMsg()
	{
		return dr.findElement(invalidusrpwdMsg);
	}

	public WebElement getsignInLink()
	{
		return dr.findElement(signInLink);
	}

	public WebElement getmapSynqHomeLink()
	{
		return dr.findElement(mapSynqHome);
	}

	public void signInToMapSynq(String userName, String password)
	{
		getsignInLink().click();
		getUserNameField().sendKeys(userName);
		getPasswordField().sendKeys(password);
		getSigninBtn().click();
	}

	public String getInvalidUsrPwdText()
	{
		if(getInvalidUsrPwdMsg().isDisplayed())
		{
			return getInvalidUsrPwdMsg().getText();
		}
		return null;
	}

	public boolean clickLinkByHref(String href) 
	{	
		List<WebElement> anchors = dr.findElements(By.tagName("a"));
		Iterator<WebElement> i = anchors.iterator();

		while(i.hasNext()) {
			WebElement anchor = i.next();
			if(anchor.getAttribute("href").contains(href)) 
			{
				return anchor.isDisplayed();
			}
		}
		return false;
	}

}
