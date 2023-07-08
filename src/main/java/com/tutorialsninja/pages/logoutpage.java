package com.tutorialsninja.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class logoutpage extends basepage {
	@FindBy(xpath="//*[@id=\"content\"]/div/div/a")
	private WebElement continuebutton;
	public logoutpage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);

	}
	public void clickoncontinuebutton()
	{
		continuebutton.click();
	}
	
}
