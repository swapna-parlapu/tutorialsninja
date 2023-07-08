package com.tutorialsninja.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.tutorialninja.utilities.utilities;
import com.tutorialsninja.pages.homepage;

public class Wishlistpage extends basepage{
	@FindBy(xpath="//*[@id=\"content\"]/p")
	private WebElement wishlistemptymessage;
	@FindBy(xpath="//*[@id=\"account-wishlist\"]/ul/li[1]/a")
	private WebElement linktohome;
	
	homepage homepage=new homepage(driver);
	
	public Wishlistpage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver,this);
		
	}
public Boolean verifyoneisproductaddedtowishlist(String productname)
{
	return driver.findElement(By.xpath("//div[@id=\"content\"]//table//tbody[1]/tr/td[2]")).getText().contains(productname);
}
public int verifyproductsaddedtowishlist(ArrayList s)
{
	 
	for(int i=0;i<s.size();i++)
	{
		driver.findElement(By.xpath("//div[@id=\"content\"]//table//tbody[1]/tr/td[2]/a[text()='"+s.get(i)+"']"));
			}
	return s.size();
	
	
}
public int verifywhensixthproductisadded(ArrayList s)  
{
	for(int i=1;i<s.size();i++)
	{
		driver.findElement(By.xpath("//div[@id=\"content\"]//table//tbody[1]/tr/td[2]/a[text()='"+s.get(i)+"']"));
			}
	return s.size();
}
public String wishlistemptymessage()
{
	utilities.getwebdriverwait(driver,wishlistemptymessage );
	return wishlistemptymessage.getText();
}

public Boolean productaddedtoshoppincartsucessmessage(String productname)
{
	return driver.findElement(By.xpath("//*[@id=\"account-wishlist\"]/div[1]")).getText().contains(productname);
}
public void clickonAddtoCart(String productname)
{
	WebElement addtocart=driver.findElement(By.xpath("//td/a[text()='"+productname+"']/ancestor::td/following-sibling::td/button"));
	

	utilities.getjavascriptexceutor(driver).executeScript("arguments[0].click();", addtocart);
}
public void clickonremovebutton(String productname)
{
	driver.findElement(By.xpath("//td/a[text()='"+productname+"']/ancestor::td/following-sibling::td/a")).click();
}
public String productremovedsucessmessage()
{
	return driver.findElement(By.xpath("//*[@id=\"account-wishlist\"]/div[1]")).getText();
}
public Searchpage clickonsearchButton()
{
	searchbutton.click();
	return new Searchpage(driver);
}
public void enterproductnameinsearchbox(String productname)
{
	searchbox.sendKeys(productname);
}
public void linktohome()
{
	utilities.getjavascriptexceutor(driver).executeScript("arguments[0].click();", linktohome);
	
}
public void movetodesktops()
{
	Actions act=new Actions(driver);
	act.moveToElement(Desktops).build().perform();
}
public Desktops clickonshowaalldesktops()
{
	showalldesktops.click();
	return new Desktops(driver);
}

}
