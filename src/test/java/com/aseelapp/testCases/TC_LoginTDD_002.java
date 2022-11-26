package com.aseelapp.testCases;

import java.io.IOException;

import org.openqa.selenium.NoAlertPresentException;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.aseelapp.pageObjects.homePage;
import com.aseelapp.pageObjects.loginPage;
import com.aseelapp.utilities.XLUtils;

public class TC_LoginTDD_002 extends BaseClass{
	@Test(dataProvider = "LoginData")
	public void loginDDT(String user, String pwd) throws IOException, InterruptedException {
		loginPage lp= new loginPage(driver);
homePage hp = new homePage(driver);
		

				driver.get("https://aseelapp.com/en_us/customer/account/login/referer/aHR0cHM6Ly9hc2VlbGFwcC5jb20vZW5fdXMvY3VzdG9tZXIvYWNjb3VudC9sb2dvdXQv/");
		lp.setUserName(user);
		lg.info("username provided");
		
		lp.setPassword(pwd);
		lg.info("password provided");
		
		lp.clickSubmit();
		lg.info("login button clicked");
		Thread.sleep(3000);
		if(driver.getPageSource().contains( "Sign Out"))
		{
			
			lg.info("Login test passed");
		
		

			Thread.sleep(20000);
			Assert.assertTrue(true);
		}
		
		else
		{lg.info("Login test failed") ;
			captureScreenshot(driver,"loginDDT");
			Assert.assertTrue(false);
			
			
			
		}
		
		
	}
	
	
		
		
	
	
	
	@DataProvider(name = "LoginData")
	public String[] [] getData() throws IOException
	{
		String path= System.getProperty("user.dir")+"\\src\\test\\java\\com\\aseelapp\\testData\\LoginData.xlsx";
		int rownb = XLUtils.getRowCount(path, "Sheet1");
		int colnb= XLUtils.getCellCount(path, "Sheet1", 1);
		
		String loginData[][ ] = new String[rownb][colnb];
		
		for (int i = 1; i <= rownb; i++) {
			
			for (int j = 0; j < colnb; j++) {
				
				loginData[i-1][j]=XLUtils.getCellData(path, "Sheet1", i, j);
				
			}
			
		}
		return loginData;
		
	}

}
