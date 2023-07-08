package com.tutorialsninja.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class termsandconditionspage extends basepage {
	@FindBy(xpath="//*[@id=\"content\"]/h1")
	WebElement termsandconditions;
	public termsandconditionspage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
		
	}
	public String termsandconditions()
	{
		return termsandconditions.getText() ;
		
	}

}
