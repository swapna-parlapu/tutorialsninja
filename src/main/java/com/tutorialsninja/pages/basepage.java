package com.tutorialsninja.pages;

import java.io.File;
import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.tutorialninja.utilities.utilities;

public class basepage {
	public static  WebDriver driver;
	public WebDriverWait wait=null;
	public Properties prop ;
	public Properties dataprop;
	@FindBy(xpath="//*[@id='top-links']/ul/li[2]/a")
	WebElement myAccountDropMenu;
	@FindBy(xpath="//a[text()='Login']")
	 WebElement login;
	@FindBy(xpath="//a[text()='Register']")
	WebElement Register; 
	@FindBy(xpath="//*[@id=\"top-links\"]/ul/li[2]/ul/li[5]/a")
	WebElement logout;
	@FindBy(xpath="//*[@id='search']/input")
	 WebElement searchbox;
	@FindBy(xpath="//*[@id='search']/span/button")
	WebElement searchbutton;
	@FindBy(xpath="//*[@id=\"wishlist-total\"]/i")
	WebElement wishlist;

	@FindBy(xpath="//*[@id=\"menu\"]/div[2]/ul/li[1]/a")
	WebElement Desktops;
	@FindBy(xpath="//*[@id=\"menu\"]/div[2]/ul/li[1]/div/a")
	WebElement showalldesktops;
	
	
	
	public basepage()
	{
	prop=new Properties();
	dataprop=new Properties();
	 File file=new File(System.getProperty("user.dir")+"\\src\\main\\java\\com\\tutorialsninja\\config\\config.properties");
	 File datafile=new File(System.getProperty("user.dir")+"\\src\\main\\java\\com\\tutorialsninja\\testdata\\testdata.properties");
	 try{
	 FileInputStream fis=new FileInputStream(file);
	 FileInputStream fisdatapro=new FileInputStream(datafile);
	 prop.load(fis);
	 dataprop.load(fisdatapro);
	 }
	 catch(Throwable e)
	 {
		 e.printStackTrace();
	 }
	 }
	


	public void Initializebrower_and_open_application_url(String browsername,String url)
	{
		if(browsername.equals("Chrome")) {
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--remote-allow-origins=*");
			 driver = new ChromeDriver(options);
		
		}
		if(browsername.equals("Edge")) {
			driver=new EdgeDriver();
			}
		if(browsername.equals("FireFox")) {
			driver=new FirefoxDriver();
			}
			
			
		
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(utilities.WAIT_TIME));
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(utilities.PAGE_WAIT_TIME));
		
		
		 driver.navigate().to(url);
		 
	}
	public WebDriverWait getwebdriverwait(WebDriver driver) {
	wait = new WebDriverWait(driver,Duration.ofSeconds(10));
	return wait;
	
	}
	
}
