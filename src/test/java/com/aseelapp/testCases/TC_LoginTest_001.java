package com.aseelapp.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.aseelapp.pageObjects.homePage;
import com.aseelapp.pageObjects.loginPage;

public class TC_LoginTest_001 extends BaseClass

{
	@Test
	public void loginTest() throws IOException
	{
		
		
		
		loginPage lp= new loginPage(driver);
		
		homePage hp = new homePage(driver);
		
		action.moveToElement(hp.getUserIcon()).build().perform();
		action.moveToElement(hp.getSignIn()).build().perform();
		action.click().build().perform();
		
		lp.setUserName(username);
		lg.info("enter username");

		lp.setPassword(pswd);
		lg.info("enter password");

		lp.clickSubmit();
		
		if(driver.getPageSource().contains("My Account"))
		{
			Assert.assertTrue(true);
			lg.info("Login test passed");

		}
		else
		{
			captureScreenshot(driver,"loginTest");
			Assert.assertTrue(false);
			lg.info("Login test failed") ;
		}
	}
	

}
