package com.tutorialsninja.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.tutorialninja.utilities.utilities;

public class homepage extends basepage{
	registerpage registerpage;
	Loginpage Loginpage;
	Wishlistpage Wishlistpage;
	

	
	

	@FindBy(xpath="//*[@id=\"top-links\"]/ul/li[4]/a/i")
	WebElement shopping_cart;
	public homepage(WebDriver driver)
	{

		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	
	public registerpage navigatetoRegister()
	{
		utilities.getwebdriverwait(driver, myAccountDropMenu);
		myAccountDropMenu.click();
		utilities.getwebdriverwait(driver, Register);
		Register.click();
		return new registerpage(driver);
	}
	public Loginpage navigatetologin()
	{
		utilities.getwebdriverwait(driver, myAccountDropMenu);
		myAccountDropMenu.click();
		utilities.getwebdriverwait(driver, login);
		login.click();
		return  new Loginpage(driver);
		
	}
	public void searchinvalidproductname(String invalidproduct)
	{
		searchbox.clear();
		searchbox.sendKeys(invalidproduct);
	}

	
	public void entervalidproductinsearchbox(String validproductname)
	{
		searchbox.sendKeys(validproductname);
	}
	public Searchpage clickonsearchbutton()
	{
		searchbutton.click();
		return new Searchpage(driver) ;
	}
	public registerpage navigatetoregisterusingkeyboardkeys()
	{
		Actions act=new Actions(driver);
		act.sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.ENTER).sendKeys(Keys.ARROW_DOWN).build().perform();
		act.sendKeys(Keys.ENTER).build().perform();
		act.sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB)
		.sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB)
		.sendKeys(Keys.TAB).sendKeys(Keys.TAB).build().perform();
		return new registerpage(driver);
	}
	public Loginpage navigatetologinusingkeyboardkeys()
	{
		Actions act=new Actions(driver);
		act.sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.ENTER).sendKeys(Keys.ARROW_DOWN).sendKeys(Keys.ARROW_DOWN).build().perform();
		act.sendKeys(Keys.ENTER).build().perform();
		act.sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).
		sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB)
		.sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).
		sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB).sendKeys(Keys.TAB)
		.sendKeys(Keys.TAB).sendKeys(Keys.TAB).build().perform();
		return new Loginpage(driver);
	}
	public void movetodesktops()
	{
		Actions act=new Actions(driver);
		act.moveToElement(Desktops).build().perform();
	}
	public Searchpage clickonshowaalldesktops()
	{
		showalldesktops.click();
		return new Searchpage(driver);
	}
	public Wishlistpage clickon_wishlist()
	{
		wishlist.click();
		return new Wishlistpage(driver);
	}
	public void movetotooltipwishlist(String productname)
	{
		utilities.getwebdriverwait(driver, driver.findElement(By.xpath("//div[@class=\"caption\"]//a[text()='"+productname+"']/ancestor::div[@class=\"caption\"]/following-sibling::div/button[2]")));
		driver.findElement(By.xpath("//div[@class=\"caption\"]//a[text()='"+productname+"']/ancestor::div[@class=\"caption\"]/following-sibling::div/button[2]")).click();
		}
	
	
	
	
	

}
