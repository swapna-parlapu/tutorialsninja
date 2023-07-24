
package com.tutorialsninja.testcases;

import java.io.FileNotFoundException;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.tutorialninja.base.basetest;
import com.tutorialninja.utilities.utilities;
import com.tutorialsninja.pages.*;

public class LoginTest extends basetest {
	homepage homepage;
	My_Account My_Account;
	basetest basetest;
	Loginpage Loginpage;
	Forgetpasswordpage  Forgetpasswordpage;
	registerpage registerpage;
	logoutpage logoutpage;
	
	SoftAssert s_assert = new SoftAssert();

	@BeforeClass
	public void openbrowser_and_enter_url() {
		basetest = new basetest();
		basetest.openbrowser_and_enter_url(prop.getProperty("browsername"), prop.getProperty("url"));
		homepage = new homepage(driver);
		
	}
	@BeforeMethod
	public void navigatetologin()
	{
		Loginpage = homepage.navigatetologin();
		
	}

	@AfterClass
	public void close() {
		driver.close();
	}
	//@AfterMethod()
	public void clickonlogout()
	{
		logoutpage=My_Account.clickonLogout();
		logoutpage.clickoncontinuebutton();
	}
	@Test(priority = 2)
	public void verify_login_with_valid_credencials() {
		
		My_Account=Loginpage.enter_valid_login_credencials(prop.getProperty("validemail"), prop.getProperty("validpassword"));

		Assert.assertEquals(dataprop.getProperty("myaccountpagetitle"),
				driver.getTitle());
		logoutpage=My_Account.clickonLogout();
		logoutpage.clickoncontinuebutton();
		
	}

	
	
	@Test(priority=4)
	public void verify_forgetpasswordlink_in_loginpage()
	{
		
		Forgetpasswordpage=Loginpage.clickonforgetpasswordlink();
		if(driver.getTitle().equals(dataprop.getProperty("myaccountpagetitle")))
		{
			logoutpage=My_Account.clickonLogout();
			logoutpage.clickoncontinuebutton();
			
		}
		
	}
	
	@Test(priority=3)
	public void verifyloggingintoapplicationusingkeyboardkeys()
	{
		My_Account=Loginpage.entervalidcrendencialswithkeyboard(prop.getProperty("validemail"), prop.getProperty("validpassword"));
		s_assert.assertEquals(dataprop.getProperty("myaccountpagetitle"),
				driver.getTitle());
		if(driver.getTitle().equals(dataprop.getProperty("myaccountpagetitle")))
		{
			logoutpage=My_Account.clickonLogout();
			logoutpage.clickoncontinuebutton();
			
		}
	
		
		}
	//@Test(priority=5)
	public void verify_Loggingino_the_application_and_browsingback_using_browserback_button() throws InterruptedException 
	{
		
		My_Account=Loginpage.enter_valid_login_credencials(prop.getProperty("validemail"), prop.getProperty("validpassword"));
		Thread.sleep(2000);
		driver.navigate().back();
		Thread.sleep(2000);
		
		System.out.println(driver.getTitle());
		driver.findElement(By.xpath("//*[@id=\"top-links\"]/ul/li[2]/a")).click();
		List<WebElement> ele=driver.findElements(By.xpath("//ul[@class=\"dropdown-menu dropdown-menu-right\"]/li"));
		for(int i=0;i<ele.size();i++)
		{
			if(ele.get(i).getText().equalsIgnoreCase("logout"))
			{
				ele.get(i).click();
				Assert.assertTrue(true);
			}
			else
				Assert.assertTrue(false);
		}
		
		
		
		
		
	}
	//@Test(priority=6)
	public void verify_Loggingout_of_the_application_and_browsingback_using_browserback_button() throws InterruptedException
	{

		Thread.sleep(4000);
		My_Account.clickonLogout();
		
		driver.navigate().back();
		Thread.sleep(3000);
		
		s_assert.assertEquals(driver.getTitle(), dataprop.getProperty("myaccountpagetitle"));
		
		
		if(driver.getTitle().equals(dataprop.getProperty("myaccountpagetitle")))
		{
			logoutpage=My_Account.clickonLogout();
			logoutpage.clickoncontinuebutton();
			
		}
		s_assert.assertAll();
		
		
		
		
	}
	//@Test(priority=8)
	public void verify_Loggingino_the_application_afterchangingpassword()
	{
		
		Forgetpasswordpage=Loginpage.clickonforgetpasswordlink();
		Loginpage=Forgetpasswordpage.entereamilintextbox(prop.getProperty("validemail"));
		SoftAssert Assert = new SoftAssert();
		Assert.assertEquals(Loginpage.retriveforgetpasswordemailsentsucessmessage(),dataprop.getProperty("passwordlinksenttoemailsucessmesage"));
		My_Account=Loginpage.enter_valid_login_credencials(prop.getProperty("validemail"), prop.getProperty("validpassword"));
		Assert.assertEquals(driver.getTitle(), dataprop.getProperty("pagetitlebeforelogin"));
		homepage.navigatetologin();
		Loginpage.enter_valid_login_credencials(prop.getProperty("validemail"), "12345");
		Assert.assertEquals(driver.getTitle(), dataprop.getProperty("myaccountpagetitle"));

		

		
	}
	//@Test(priority=8)
	public void verify__naviagting_to_registerccountpagefromloginpage_from_new_customerdialogbox()
	{
		Loginpage=homepage.navigatetologin();
		registerpage=Loginpage.clickoncontinuebuttoninnewCustomerdialogbox();
	}
	//@Test(priority=9)
	public void verify_differentways_of_naviagting_to_registerccountpagefromright_column_options_in_loginpage()
	{
		Loginpage=homepage.navigatetologin();
		registerpage=Loginpage.clickonregister();
		
	}
	@Test(priority=8)
	public void verify_password_is_not_visible_in_pagesource()
	{
		
		String pagesource=Loginpage.viewpagesourceofpasswordfield(prop.getProperty("validemail"), prop.getProperty("validpassword") );
		Assert.assertFalse(pagesource.contains(prop.getProperty("validpassword")));
	}

		
		
	
	@Test(priority=11)
	public void Verify_Logging_into_the_Application_closing_the_Browser_without_loggingout_and_opening_the_application_in_the_Browser_again()
	{
		My_Account=Loginpage.enter_valid_login_credencials(prop.getProperty("validemail"), prop.getProperty("validpassword"));
		driver.close();
		basetest = new basetest();
		basetest.openbrowser_and_enter_url(prop.getProperty("browsername"), prop.getProperty("url"));
		homepage = new homepage(driver);
		Loginpage = homepage.navigatetologin();
		My_Account=Loginpage.enter_valid_login_credencials(prop.getProperty("validemail"), prop.getProperty("validpassword"));
		Assert.assertEquals(dataprop.getProperty("myaccountpagetitle"),
				driver.getTitle());
		
		}

	
	
	
	
	
}
