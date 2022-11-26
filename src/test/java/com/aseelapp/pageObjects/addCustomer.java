package com.aseelapp.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class addCustomer {
	
	WebDriver ldriver;
	
	public addCustomer(WebDriver rdriver) {
		
		ldriver=rdriver;
		PageFactory.initElements(rdriver,this );
		
	}
	
	 @FindBy(how = How.NAME, using="name")
	 @CacheLookup
	 WebElement custName;
	 
	 @FindBy(xpath = "//input[@value='m']")
	 @CacheLookup
	 WebElement custGenderM;
	
	 
	 @FindBy(xpath = "//input[@value='f'];")
	 @CacheLookup
	 WebElement custGenderF;
	 
	 @FindBy(name = "dob")
	 @CacheLookup
	 WebElement custDOB;
	 
	 @FindBy(name = "addr")
	 @CacheLookup
	 WebElement custAddr;
	 
	 @FindBy(name = "city")
	 @CacheLookup
	 WebElement custCity;

	 @FindBy(name = "state")
	 @CacheLookup
	 WebElement custState;

	 @FindBy(name = "pinno")
	 @CacheLookup
	 WebElement custPin;
	 
	 @FindBy(name = "telephoneno")
	 @CacheLookup
	 WebElement custTel;
	 
	 @FindBy(name = "emailid")
	 @CacheLookup
	 WebElement custEmail;
	 
	 @FindBy(name = "password")
	 @CacheLookup
	 WebElement custPassword;
	 
	 @FindBy(name = "sub")
	 @CacheLookup
	 WebElement custSubmit;
	 
	 @FindBy(xpath = "//a[normalize-space()='New Customer']")
	 @CacheLookup
	 WebElement newCustBt;

	public void setCustName(String ss) {
		
		custName.clear();
		custName.sendKeys(ss);
		
	}

	public void setCustGender(String ss) {
		
		if(ss.equals("male"))
		{
			custGenderM.click();
		}
		else
		{
			custGenderF.click();
		}
	}

	public void setCustDOB(String dd, String mm, String yy) {
		custDOB.clear();
		custDOB.sendKeys(dd);
		custDOB.sendKeys(mm);
		custDOB.sendKeys(yy);
	}

	public void setCustAddr(String Addr) {
		custAddr.clear();
		custAddr.sendKeys(Addr);
	}

	public void setCustCity(String City) {
custCity.clear();
custCity.sendKeys(City);

	}

	public void setCustState(String State) {
		this.custState.clear();
		this.custState.sendKeys(State);
	}

	public void setCustPin(String custPin) {
		this.custPin.clear();
		this.custPin.sendKeys(String.valueOf(custPin) );
	}

	public void setCustTel(String custTel) {
		this.custTel.clear();
		this.custTel.sendKeys(custTel);
	}

	public void setCustEmail(String custEmail) {
		this.custEmail.clear();
		this.custEmail.sendKeys( custEmail);
	}

	public void setCustPassword(String custPassword) {
		this.custPassword.clear();
		this.custPassword.sendKeys(custPassword);
	}

	public void setCustSubmit() {
		this.custSubmit.click();
	}

	public void setNewCustBt() {
		this.newCustBt.click();
	}
	 
	 
	 
	 

}
