package com.tutorialsninja.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class privacypolicypage extends basepage{
	@FindBy(xpath="//*[@id=\"content\"]/h1")
	private WebElement privacypolicy;
	public privacypolicypage(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);

	}
	public String displayofprivacypolicytitle()
	{
		return privacypolicy.getText();
	}
	
	

}


