package com.tutorialsninja.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Forgetpasswordpage extends basepage{
	@FindBy(xpath="//*[@id=\"input-email\"]")
	WebElement emailtextbox;
	@FindBy(xpath="//*[@id=\"content\"]/form/div/div[2]/input")
	WebElement continuebutton;

	public  Forgetpasswordpage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
		
	}
	public String  Forgetpasswordpage()
	{
		return driver.getTitle();
		
	}
	public Loginpage entereamilintextbox(String email)
	{
		emailtextbox.sendKeys(email);
		continuebutton.click();
		return new Loginpage(driver);
	}
	

}
