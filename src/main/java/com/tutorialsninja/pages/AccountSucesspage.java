package com.tutorialsninja.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class AccountSucesspage extends basepage{
	public AccountSucesspage (WebDriver driver)
	{

		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	public String account_created_sucess_message()
	{
		return driver.findElement(By.xpath("//*[@id=\"content\"]/h1")).getText();
	}
	public void clickonmyaccountdropmenu()
	{
		myAccountDropMenu.click();
	}

}
