package com.tutorialsninja.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Loginpage extends basepage{
	registerpage registerpage;
	Forgetpasswordpage forgetpasswordpage;
	My_Account My_Account;
	Loginpage Loginpage;
	@FindBy(xpath="//input[@name='email']")
	private WebElement emailtextbox; 
	@FindBy(xpath="//input[@name='password']")
	private WebElement passwordtextbox; 
	@FindBy(xpath="//input[@type='submit']")
	private WebElement submitbutton;
	@FindBy(xpath="//*[@id='account-login']/div[1]")
	private WebElement emailpasswordnotmatchingwarning;
	@FindBy(xpath="//*[@id=\"content\"]/div/div[1]/div/a")
	private WebElement continuebutton;
	@FindBy(xpath="//*[@id=\"column-right\"]/div/a[2]")
	private WebElement registerbutton;
	@FindBy(xpath="//*[@id=\"content\"]/div/div[2]/div/form/div[2]/a")
	private WebElement forgettenpassword;
	@FindBy(xpath="//*[@id=\"account-login\"]/div[1]")
	private WebElement passwordlinksenttoemailsucessmesage;
	@FindBy(xpath="//*[@id=\"account-login\"]/div[1]")
	private WebElement warningmessageafter5unsucessfullloginattempts;
	
	
public Loginpage(WebDriver driver) {
		
		this.driver = driver;
		PageFactory.initElements(driver,this);
}
	public My_Account enter_valid_login_credencials(String email,String password)
	{
		emailtextbox.clear();

		emailtextbox.sendKeys(email);
		passwordtextbox.clear();

		passwordtextbox.sendKeys(password);
		submitbutton.click();
		 return new My_Account(driver);
	}

	public String retrive_emailpassword_not_matching_warning()
	{
	 return	emailpasswordnotmatchingwarning.getText();
	}
	public void enter_invalid_crendencials(String email,String password)
	{
		emailtextbox.clear();
		emailtextbox.sendKeys(email);
		passwordtextbox.clear();
		passwordtextbox.sendKeys(password);
		submitbutton.click();
	}
	public registerpage clickoncontinuebuttoninnewCustomerdialogbox()
	{
		continuebutton.click();
		return registerpage;
	}
	public registerpage clickonregister()
	{
		registerbutton.click();
		return registerpage;
		
	}
	public Forgetpasswordpage clickonforgetpasswordlink()
	{
		forgettenpassword.click();
		return new Forgetpasswordpage(driver);
	}
	public My_Account entervalidcrendencialswithkeyboard(String email,String password)
	{
		
		Actions act=new Actions(driver);
		act.sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).
		sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB)
		.sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).
		sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB)
		.sendKeys(Keys.TAB).sendKeys(Keys.TAB).build().perform();

		emailtextbox.sendKeys(email);
		act.sendKeys(Keys.TAB).build().perform();
		passwordtextbox.sendKeys(password);
		act.sendKeys(Keys.TAB).build().perform();
		act.sendKeys(Keys.TAB).build().perform();
		act.sendKeys(Keys.ENTER).build().perform();
		 return new My_Account(driver);
	}
	
	public String retriveforgetpasswordemailsentsucessmessage()
	{
		return passwordlinksenttoemailsucessmesage.getText();
		
	}
	public String viewpagesourceofpasswordfield(String email,String password)
	{
		emailtextbox.sendKeys(email);
		passwordtextbox.sendKeys(password);
		return driver.getPageSource();
	}
	public String retriverwarningmessageafter5unsucessfullloginattempts() {
		return warningmessageafter5unsucessfullloginattempts.getText();
	}
	
	

}
