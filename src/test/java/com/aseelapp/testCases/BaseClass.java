package com.aseelapp.testCases;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.aseelapp.utilities.ReadConfig;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseClass {

	ReadConfig readConfig= new ReadConfig();
	
	public String BaseUrl=readConfig.getApplicationURL();
	public String username=readConfig.getUsername();
	public String pswd=readConfig.getPswd();
	public WebDriver driver;
	public static Logger lg;
	public Actions action;
	
	
@Parameters("browser")
@BeforeClass
public void setup(String browser)
{
	
	 lg=  Logger.getLogger("BaseClass");
	 PropertyConfigurator.configure("log4j.properties");	
	if (browser.equals("chrome"))
	{
		WebDriverManager.chromedriver().setup();
		ChromeOptions opt = new ChromeOptions();
		opt.setExperimentalOption("excludeSwitches", Arrays.asList("disable-popup-blocking"));
		opt.addArguments("--disable-infobars");
		driver= new ChromeDriver(opt);
	}
	else if(browser.equals("firefox"))
	{
		WebDriverManager.firefoxdriver().setup();
		driver= new FirefoxDriver();
	}
	else if(browser.equals("edge"))
	{
		WebDriverManager.edgedriver().setup();
		driver= new EdgeDriver();
	}
	else if(browser.equals("IE"))
	{
		WebDriverManager.iedriver().setup();
		driver= new InternetExplorerDriver();
	}
	
	driver.get(BaseUrl);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().timeouts().pageLoadTimeout(100, TimeUnit.SECONDS);
		lg.info("URL is open");

		driver.manage().window().maximize();
		
		action = new Actions(driver);
		
		
		
		
}


@AfterClass
public void tearDown()
{
	driver.quit();
}
//capture screenshot

public void captureScreenshot(WebDriver driver, String name) throws IOException
{
	TakesScreenshot ts = (TakesScreenshot) driver;
	File src= ts.getScreenshotAs(OutputType.FILE);
	//File trg=new File(".\\screenshots\\home1.png");
	File trg = new File(System.getProperty("user.dir")+"\\screenshots\\"+ name+".png");
	FileUtils.copyFile(src, trg);
	System.out.println("screenshot taken!!!");
	
	
}
	
}
