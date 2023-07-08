package com.tutorialsninja.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Aboutuspage extends basepage{
	
	public Aboutuspage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);

	}
	public String displayofAboutustitle()
	{
		return driver.getTitle();
	}
	
	

}
