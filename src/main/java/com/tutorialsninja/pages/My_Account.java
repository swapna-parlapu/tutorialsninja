package com.tutorialsninja.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.tutorialninja.utilities.utilities;

public class My_Account extends basepage {
	
	
	homepage homepage;
	
	
	public My_Account(WebDriver driver)
	{

		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
 
 public logoutpage clickonLogout()
	{
	 	utilities.getwebdriverwait(driver, myAccountDropMenu);
	 myAccountDropMenu.click();
	 	utilities.getwebdriverwait(driver, logout);
	 	logout.click();
	 	return new logoutpage(driver);

		
	}
 public void enterproductnameinsearchbox(String productname)
 {
	 searchbox.sendKeys(productname);
 }
 public Searchpage clickonsearchbutton()
 {
	 searchbutton.click();
	 return new Searchpage(driver);
 }
	public Wishlistpage clickon_wishlist()
	{
		wishlist.click();
		return new Wishlistpage(driver);
	}

}
