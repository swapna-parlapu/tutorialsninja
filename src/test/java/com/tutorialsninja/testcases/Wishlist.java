package com.tutorialsninja.testcases;

import java.util.ArrayList;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tutorialninja.base.basetest;
import com.tutorialsninja.pages.homepage;
import com.tutorialsninja.pages.Loginpage;
import com.tutorialsninja.pages.Wishlistpage;
import com.tutorialsninja.pages.Searchpage;
import com.tutorialsninja.pages.My_Account;
import com.tutorialsninja.pages.Desktops;

public class Wishlist extends basetest{
	homepage homepage;
	Loginpage Loginpage;
	Wishlistpage Wishlistpage;
	basetest 		basetest;
	Searchpage Searchpage;
	Desktops Desktops;
	My_Account My_Account;
	ArrayList<String> s= new ArrayList<String>();
	
	@BeforeClass
	public void openbrowser_and_enter_url() {
		basetest =new basetest();
		basetest.openbrowser_and_enter_url(prop.getProperty("browsername"), prop.getProperty("url"));
		homepage=new homepage(driver);
		Loginpage=homepage.navigatetologin();
		My_Account=Loginpage.enter_valid_login_credencials(prop.getProperty("validemail"), prop.getProperty("validpassword"));
		
		
	}
	//@AfterClass
	public void close()
	{
		driver.close();
	}
	@Test(priority=1)
	public void whennoproductsareadded()
	{
		Wishlistpage=My_Account.clickon_wishlist();
		Wishlistpage.wishlistemptymessage();
		Assert.assertEquals(Wishlistpage.wishlistemptymessage(),dataprop.getProperty("wishlistemptymessage"));
	
	}
	@Test(priority=2)
	public void verify_adding_firstproduct_to_wishlist_after_loginfrom_homepage() {
		Wishlistpage.enterproductnameinsearchbox(dataprop.getProperty("validproduct"));
		Searchpage=My_Account.clickonsearchbutton();
		Searchpage.movetotooltipwishlist(dataprop.getProperty("firstproducttoaddforwishlist"));

		Wishlistpage=homepage.clickon_wishlist();
		s.add(dataprop.getProperty("firstproducttoaddforwishlist"));
		
		Assert.assertTrue(Wishlistpage.verifyproductsaddedtowishlist(s)==1);
	}
	@Test(priority=3)
	public void verify_adding_second_product_from_searchresultspage() {
		Wishlistpage.enterproductnameinsearchbox(dataprop.getProperty("validproduct"));
		Searchpage=Wishlistpage.clickonsearchButton();
		Searchpage.movetotooltipwishlist(dataprop.getProperty("secondproducttoaddforwishlist"));
		Searchpage.clickonwishlist();
		
		
		s.add(dataprop.getProperty("secondproducttoaddforwishlist"));
		Wishlistpage.verifyproductsaddedtowishlist(s);
		Assert.assertTrue(Wishlistpage.verifyproductsaddedtowishlist(s)==2);

		Wishlistpage.linktohome();
		}
	@Test(priority=4)
	public void verifyadding_third_product_to_wishlistfrom_categoryorsubcategoryofthehomepage()
	{
		Wishlistpage.movetodesktops();
		Desktops=Wishlistpage.clickonshowaalldesktops();
		Desktops.movetotooltipwishlist(dataprop.getProperty("Thirdproductnameforwishlist"));
		s.add(dataprop.getProperty("Thirdproductnameforwishlist"));
		Searchpage.clickonwishlist();
		Assert.assertTrue(Wishlistpage.verifyproductsaddedtowishlist(s)==3);

		}
	@Test(priority=5)
	public void verifyaddingfourthproductstowishlist()
	{
		Wishlistpage.enterproductnameinsearchbox(dataprop.getProperty("validproduct"));
		Searchpage=Wishlistpage.clickonsearchButton();
		
		Searchpage.movetotooltipwishlist(dataprop.getProperty("fourthproductnameforwishlist"));
		s.add(dataprop.getProperty("fourthproductnameforwishlist"));

		Wishlistpage=Searchpage.clickonwishlist();
		Assert.assertTrue(Wishlistpage.verifyproductsaddedtowishlist(s)==4);
		}
	@Test(priority=6)
	public void verifyaddingfifthproductstowishlist()
	{
		Wishlistpage.enterproductnameinsearchbox(dataprop.getProperty("fifthproductnameforwishlist"));
		Searchpage=Wishlistpage.clickonsearchButton();
		
		Searchpage.movetotooltipwishlist(dataprop.getProperty("fifthproductnameforwishlist"));
		s.add(dataprop.getProperty("fifthproductnameforwishlist"));

		Wishlistpage=Searchpage.clickonwishlist();
		Assert.assertTrue(Wishlistpage.verifyproductsaddedtowishlist(s)==5);
		}
	@Test(priority=7)
	public void verify_user_not_able_to_add_sixth_product_to_wishlist()
	{
		Wishlistpage.enterproductnameinsearchbox(dataprop.getProperty("sixthproductforwishlist"));
		Searchpage=Wishlistpage.clickonsearchButton();
		
		Searchpage.movetotooltipwishlist(dataprop.getProperty("sixthproductforwishlist"));
		s.add(dataprop.getProperty("sixthproductforwishlist"));

		Wishlistpage=Searchpage.clickonwishlist();
		Assert.assertTrue(Wishlistpage.verifywhensixthproductisadded(s)==6);
		}
	
	@Test(priority=8)
	public void verifyaddingproducttocartfromwishlist()
	{
		Wishlistpage=Searchpage.clickonwishlist();
		Wishlistpage.clickonAddtoCart(dataprop.getProperty("sixthproductforwishlist"));
		Wishlistpage.productaddedtoshoppincartsucessmessage(dataprop.getProperty("sixthproductforwishlist"));
	
		
		
	}
	@Test(priority=9)
	public void verifyremoveproductfromwishlist()
	{
		
		Wishlistpage.clickonremovebutton(dataprop.getProperty("fifthproductnameforwishlist"));
		
		Assert.assertTrue(Wishlistpage.productremovedsucessmessage().contains(dataprop.getProperty("productremovedsucessmessage")));
	}
	
	
	}
	


