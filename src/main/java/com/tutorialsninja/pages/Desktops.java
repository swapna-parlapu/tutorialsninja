package com.tutorialsninja.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.tutorialninja.utilities.utilities;

public class Desktops extends basepage{
	public Desktops(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver,this);
	}
	public void movetotooltipwishlist(String productname)
	{
		utilities.getwebdriverwait(driver, driver.findElement(By.xpath("//div[@class=\"caption\"]//a[text()='"+productname+"']/ancestor::div[@class=\"caption\"]/following-sibling::div/button[2]")));
		driver.findElement(By.xpath("//div[@class=\"caption\"]//a[text()='"+productname+"']/ancestor::div[@class=\"caption\"]/following-sibling::div/button[2]")).click();
		}

}
