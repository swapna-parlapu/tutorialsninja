package com.tutorialsninja.testcases;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tutorialninja.base.basetest;
import com.tutorialsninja.pages.Productcomparepage;
import com.tutorialsninja.pages.Searchpage;
import com.tutorialsninja.pages.homepage;


public class search extends basetest {
	basetest basetest;
	homepage homepage;
	Searchpage searchpage;
	Productcomparepage productcomparepage;
	@BeforeClass
	public void openbrowser_and_enter_url() {
		basetest =new basetest();
		basetest.openbrowser_and_enter_url(prop.getProperty("browsername"), prop.getProperty("url"));
		homepage=new homepage(driver);
	}
	
	@Test(priority=1)
	public void verifyvalidproductinsearchtextbox()
	{
		homepage.entervalidproductinsearchbox(dataprop.getProperty("validproduct"));
		searchpage=homepage.clickonsearchbutton();

		Assert.assertTrue(searchpage.validproductverification(dataprop.getProperty("validproduct")));
		
	}
	@Test(priority=2)
	public void verifyinvalidproductinsearchtextbox()
	{
			searchpage.enterproductinsearchbox(dataprop.getProperty("invalidproduct"));
			searchpage=homepage.clickonsearchbutton();
			Assert.assertEquals(searchpage.noproductmatchmessage(), dataprop.getProperty("noproductmatchmessage"));
		}
	//@AfterMethod
	public void close()
	{
		driver.close();
	}
	@Test(priority=3)
	public void verify_no_product_search_in_searchbox()
	{
		searchpage=searchpage.clickonsearchbutton();
		Assert.assertEquals(dataprop.getProperty("noproductmatchmessage"),searchpage.noproductmatchmessage());
		
	}
	public void navigating_to_productcompare_page()
	{
		productcomparepage=searchpage.clickonproductcompare();
	}
	@Test(priority=4)
	public void verify_user_is_able_to_sort_products()
	{
		homepage.entervalidproductinsearchbox(dataprop.getProperty("validproduct"));
		searchpage=homepage.clickonsearchbutton();
	
		searchpage.Selectfromdropdownsort(dataprop.getProperty("typeofsort"));
		Assert.assertEquals(dataprop.getProperty("productwithhighestprice"), searchpage.verifypriceofproductdisplayed().toString());
	}
	
	
}
