package com.tutorialsninja.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class deliveryinformationpage extends basepage {
	@FindBy(xpath="//*[@id=\"content\"]/h1")
	WebElement deliveryinformation;
	public deliveryinformationpage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
		
	}
	public String displayofdeliveryInforamtion()
	{
		return deliveryinformation.getText() ;
		
	}
}
