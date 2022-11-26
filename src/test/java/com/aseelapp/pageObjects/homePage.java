package com.aseelapp.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class homePage {
	WebDriver ldriver;
	
	public homePage(WebDriver rdriver) {
		
		ldriver=rdriver;
		PageFactory.initElements(rdriver, this);
		
	}
	public WebDriver getLdriver() {
		return ldriver;
	}

	public void setLdriver(WebDriver ldriver) {
		this.ldriver = ldriver;
	}

	public WebElement getUserIcon() {
		return userIcon;
	}

	public void setUserIcon(WebElement userIcon) {
		this.userIcon = userIcon;
	}

	public WebElement getSignIn() {
		return signIn;
	}

	public void setSignIn(WebElement signIn) {
		this.signIn = signIn;
	}
	@FindBy(xpath = "//i[@class='pe-7s-user']")
	@CacheLookup
	WebElement userIcon;
	
	@FindBy(xpath = "//div[@class='dropdown-menu']//a[contains(text(),'Sign In')]")
	@CacheLookup
	WebElement signIn;
					 //div[@class='dropdown-menu']//a[normalize-space()='Sign Out']
	@FindBy(xpath = "//div[@class='dropdown-menu']//a[normalize-space()='Sign Out']")
	
	WebElement signOut;

	public WebElement getSignOut() {
		return signOut;
	}
	public void setSignOut(WebElement signOut) {
		this.signOut = signOut;
	}
}
