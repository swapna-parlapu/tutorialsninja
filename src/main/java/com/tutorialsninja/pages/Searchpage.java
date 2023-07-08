package com.tutorialsninja.pages;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import com.tutorialsninja.pages.*;

import org.apache.commons.collections4.bag.SynchronizedSortedBag;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.tutorialninja.utilities.utilities;


public class Searchpage extends basepage{
	homepage homepage=new homepage(driver);
	
	@FindBy(xpath="//*[@id=\"content\"]/p[2]")
	private WebElement noProductwarning;
	@FindBy(xpath="//*[@id=\"compare-total\"]")
	private WebElement productcompare;
	@FindBy(xpath="//*[@id=\"input-sort\"]")
	private WebElement sortdropdown;
	@FindBy(xpath="//*[@id=\"product-category\"]/div[1]/a[2]")
	private WebElement product_comparison;
	@FindBy(xpath="//*[@id=\"product-category\"]/div[1]/a[2]")
	private WebElement wishlist;
	
	
	
	
	
	public Searchpage(WebDriver driver)
	{

		this.driver = driver;
		PageFactory.initElements(driver,this);
	}
	public String noproductmatchmessage()
	{
		return noProductwarning.getText();
	}
	


	
	public Boolean validproductverification(String productname)
	{
		String producctname= driver.findElement(By.xpath("(//div[@class=\"caption\"])[1]//a[1]")).getText();
		System.out.println(productname);
		System.out.println(producctname);
		return producctname.contains(productname);
	
		
	}
	public void enterproductnameonsearchbox(String productname)
	{
		homepage.searchbox.clear();
		homepage.searchbox.sendKeys(productname);
	}
	public void clickoksearchbutton()
	{
		homepage.searchbutton.click();
	}
	public Productcomparepage clickonproductcompare()
	{
		utilities.getwebdriverwait(driver,productcompare);
		JavascriptExecutor js=utilities.getjavascriptexceutor(driver);
		js.executeScript("arguments[0].click();", productcompare);
		
		return new Productcomparepage(driver);
	}
	public void Selectfromdropdownsort(String typrofsortingtheproduct)
	{
	sortdropdown.click();
	Select dropdown= new Select(sortdropdown);
	dropdown.selectByVisibleText(typrofsortingtheproduct);
	}
	public Integer verifypriceofproductdisplayed()
	{										
		List<WebElement> price=driver.findElements(By.xpath("//p[@class=\"price\"]"));
		
		ArrayList<Integer> li=new ArrayList<Integer>();
		for(int i=0;i<price.size();i++)
		{
			String s=price.get(i).getText().toString();
			System.out.println(s.length());
			System.out.println(s);
			String s1=s.replace(s.substring(s.indexOf("E"), s.length()),"").replace("$", "").replace(",", "");
			Double f1=Double.parseDouble(s1);
			int i1=(int) Math.floor(f1);
			li.add(i1);
			
			
			}
			Collections.sort(li);
			System.out.println(li);
			return li.get(li.size()-1);
			}

	public void movetotooltipproductcompare(String productname)
	{

		utilities.getwebdriverwait(driver, driver.findElement(By.xpath("//div[@class=\"caption\"]//a[text()='"+productname+"']/ancestor::div[@class=\"caption\"]/following-sibling::div/button[3]")));
		JavascriptExecutor js=utilities.getjavascriptexceutor(driver);
		js.executeScript("arguments[0].click();",driver.findElement(By.xpath("//div[@class=\"caption\"]//a[text()='"+productname+"']/ancestor::div[@class=\"caption\"]/following-sibling::div/button[3]"))
);

		
		
	}
	public Boolean verifyproductcomparesucessmessage(String productname)
	{
		return driver.findElement(By.xpath("//*[@id=\"product-search\"]/div[1]")).getText().contains(productname);
		
	}
	public void movetotooltipwishlist(String productname)
	{
		utilities.getwebdriverwait(driver, driver.findElement(By.xpath("//div[@class=\"caption\"]//a[text()='"+productname+"']/ancestor::div[@class=\"caption\"]/following-sibling::div/button[2]")));
		driver.findElement(By.xpath("//div[@class=\"caption\"]//a[text()='"+productname+"']/ancestor::div[@class=\"caption\"]/following-sibling::div/button[2]")).click();
		}
	public Wishlistpage clickonwishlist()
	{
		homepage.wishlist.click();
		return new Wishlistpage(driver);
	}
	public Boolean productaddedtowishlistsucessmessage(String productname)
	{
		
		return driver.findElement(By.xpath("//*[@id=\"product-search\"]/div[1]")).getText().contains(productname);
	}
	public void enterproductinsearchbox(String validproductname)
	{
		searchbox.clear();
		searchbox.sendKeys(validproductname);
	}
	public Searchpage clickonsearchbutton()
	{
		searchbox.clear();

		searchbutton.click();
		return new Searchpage(driver) ;
	}
	
	

	
}
