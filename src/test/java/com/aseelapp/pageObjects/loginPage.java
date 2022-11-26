package com.aseelapp.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class loginPage {

		WebDriver ldriver;
		
		public loginPage(WebDriver rdriver) {
			
			ldriver=rdriver;
			PageFactory.initElements(rdriver, this);
			
		}
		
		
		
		@FindBy(xpath =  "//input[@id='email']")
		@CacheLookup
		WebElement TxtUserName;
		
		@FindBy(xpath = "//div[@class='form-group']//input[@id='pass']")
		@CacheLookup
		WebElement TxtPassword;
		
		@FindBy(xpath = "//div[@class='actions-toolbar padding-top10']//span[contains(text(),'Sign In')]")
		@CacheLookup
		WebElement btnLogin;
		
		/*@FindBy(xpath = "//a[normalize-space()='Log out']")
		@CacheLookup
		WebElement btnLogout;*/
		
		
		public void setUserName(String uname)
		{
			TxtUserName.clear();
			TxtUserName.sendKeys(uname);
		}
		
		public void setPassword(String pwd)
		{
			TxtPassword.clear();
			TxtPassword.sendKeys(pwd);
		}
		public void clickSubmit()
		{
			btnLogin.click();
			}
		
		
		
}
