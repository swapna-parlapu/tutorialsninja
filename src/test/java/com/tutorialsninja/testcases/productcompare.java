package com.tutorialsninja.testcases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.tutorialninja.base.basetest;
import com.tutorialsninja.pages.Productcomparepage;
import com.tutorialsninja.pages.Searchpage;
import com.tutorialsninja.pages.homepage;

import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;

public class productcompare extends basetest{
	 Productcomparepage Productcomparepage;
	 basetest basetest;
	 homepage homepage;
	 Searchpage Searchpage;
	 
	
	 @BeforeClass
		public void openbrowser_and_enter_url() {
			basetest = new basetest();
			basetest.openbrowser_and_enter_url(prop.getProperty("browsername"), prop.getProperty("url"));
			homepage = new homepage(driver);
			
}
	 //@AfterClass
	 public void quit()
	 {
		 driver.close();
	 }
	 //@Test(priority=2)
	 public void Verify_adding_the_product_for_comparision_from_Product_Display_Page()
	 {
		 homepage.entervalidproductinsearchbox(dataprop.getProperty("validproduct"));
		Searchpage= homepage.clickonsearchbutton();
		Searchpage.movetotooltipproductcompare(dataprop.getProperty("firstproductnameforproductcomparison"));
		Assert.assertTrue(Searchpage.verifyproductcomparesucessmessage(dataprop.getProperty("firstproductnameforproductcomparison")));
		Productcomparepage=Searchpage.clickonproductcompare();
		Productcomparepage.verifythesameproductisaddedornot(dataprop.getProperty("firstproductnameforproductcomparison"));
		Productcomparepage.clickonlinktohome();

	 }
	 @Test(priority=1)
	 public void verify_productdisplaypage_when_no_product_are_added()
	 {
		 homepage.movetodesktops();
		Searchpage= homepage.clickonshowaalldesktops();
		Productcomparepage= Searchpage.clickonproductcompare();
		 Assert.assertEquals(dataprop.getProperty("warningmessagewhennoproductsareadded"),Productcomparepage.getwarningmessagewhennoproductsareadded());
		homepage= Productcomparepage.clickoncontinuebutton();
	 }
	 @Test(priority=3)
	 public void verify_adding_one_product_to_productcomparepage()
	 {
		 homepage.entervalidproductinsearchbox(dataprop.getProperty("validproduct"));
			Searchpage= homepage.clickonsearchbutton();
			Searchpage.movetotooltipproductcompare(dataprop.getProperty("firstproductnameforproductcomparison"));
			Productcomparepage=Searchpage.clickonproductcompare();
			System.out.println(Productcomparepage.verifywhenproductsareadded());
			Assert.assertTrue(Productcomparepage.verifywhenproductsareadded()==2);
			

	 }
	 
	 @Test(priority=4)
	 public void verify_when_two_products_are_added_to_productcompare()
	 {
		 Productcomparepage.enterproductnameinsearchbox(dataprop.getProperty("validproduct"));
			Searchpage= Productcomparepage .clickonsearchbutton();
			Searchpage.movetotooltipproductcompare(dataprop.getProperty("Secondproductnameforproductcomparison"));
			
			Productcomparepage=Searchpage.clickonproductcompare();
			System.out.println(Productcomparepage.verifywhenproductsareadded());
			Assert.assertTrue(Productcomparepage.verifywhenproductsareadded()==3);
			Productcomparepage.clickonlinktohome();

		 }
	 @Test(priority=5)
	 public void verify_when_three_products_are_added_to_productcompare()
	 {
		 Productcomparepage.enterproductnameinsearchbox(dataprop.getProperty("validproduct"));
			Searchpage= Productcomparepage .clickonsearchbutton();
			Searchpage.movetotooltipproductcompare(dataprop.getProperty("Thirdproductnameforproductcomparison"));

			Productcomparepage=Searchpage.clickonproductcompare();
			System.out.println(Productcomparepage.verifywhenproductsareadded());
			Assert.assertTrue(Productcomparepage.verifywhenproductsareadded()==4);
			Productcomparepage.clickonlinktohome();

		 }
	@Test(priority=6)
	 public void verify_when_four_products_are_added_to_productcompare()
	 {
		 Productcomparepage.enterproductnameinsearchbox(dataprop.getProperty("validproduct"));
			Searchpage= Productcomparepage .clickonsearchbutton();
			Searchpage.movetotooltipproductcompare(dataprop.getProperty("fourthproductnameforproductcomparison"));


			Productcomparepage=Searchpage.clickonproductcompare();
			System.out.println(Productcomparepage.verifywhenproductsareadded());
			Assert.assertTrue(Productcomparepage.verifywhenproductsareadded()==5);
			Productcomparepage.clickonlinktohome();

		 }
	 @Test(priority=7)
	 public void verify_user_is_not_able_to_add_five_products_to_productcompare()
	 {
		 Productcomparepage.enterproductnameinsearchbox(dataprop.getProperty("fifthproductnameforproductcomparison"));
			Searchpage= Productcomparepage .clickonsearchbutton();
			Searchpage.clickoksearchbutton();
			Searchpage.movetotooltipproductcompare(dataprop.getProperty("fifthproductnameforproductcomparison"));


			Productcomparepage=Searchpage.clickonproductcompare();
			Assert.assertTrue(Productcomparepage.verifywhenfifthproductwasadded(dataprop.getProperty("Secondproductnameforproductcomparison"), dataprop.getProperty("fifthproductnameforproductcomparison")));
			Assert.assertTrue(Productcomparepage.verifywhenproductsareadded()==5);
			Productcomparepage.clickonlinktohome();

		 }
	 @Test(priority=8)
	 public void verify_adding_product_to_cart_from_productcomparepage()
	 {
		 Productcomparepage.enterproductnameinsearchbox(dataprop.getProperty("validproduct"));
			Searchpage= Productcomparepage .clickonsearchbutton();
			Productcomparepage=Searchpage.clickonproductcompare();
			Productcomparepage.clickonaddtocart(dataprop.getProperty("Secondproductnameforproductcomparison"));
			Assert.assertTrue(Productcomparepage.verifyaddtocartsucessmessage(dataprop.getProperty("Secondproductnameforproductcomparison")));
			Productcomparepage.clickonlinktohome();

	 }
	 @Test(priority=9)
	 public void verifyremovingproductfromproductcomparepage()
	  {
		 Productcomparepage.enterproductnameinsearchbox(dataprop.getProperty("validproduct"));
			Searchpage= Productcomparepage .clickonsearchbutton();
						
		
			Productcomparepage=Searchpage.clickonproductcompare();
			Productcomparepage.clickonremove(dataprop.getProperty("Thirdproductnameforproductcomparison"));
			System.out.println(Productcomparepage.verifywhenproductsareadded());
			Assert.assertTrue(Productcomparepage.verifywhenproductsareadded()==4);
			Productcomparepage.clickonlinktohome();

			}
	 @Test(priority=10)
	 public void verifysameproductisaddedforproductcomparision() {
		 Productcomparepage.enterproductnameinsearchbox(dataprop.getProperty("validproduct"));
			Searchpage= Productcomparepage .clickonsearchbutton();
			
			Searchpage.movetotooltipproductcompare(dataprop.getProperty("fourthproductnameforproductcomparison"));			
			Productcomparepage=Searchpage.clickonproductcompare();
			Assert.assertTrue(Productcomparepage.verifywhenproductsareadded()==4);
			Productcomparepage.clickonlinktohome();
			
	 }
	
	 
}

