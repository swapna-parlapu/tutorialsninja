package com.tutorialsninja.testcases;

import static org.testng.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.tutorialninja.base.basetest;
import com.tutorialninja.utilities.utilities;
import com.tutorialsninja.pages.homepage;
import com.tutorialsninja.pages.registerpage;
import com.tutorialsninja.pages.AccountSucesspage;
import com.tutorialsninja.pages.Loginpage;
public class register extends basetest {
	homepage homepage;
	registerpage registerpage;
	basetest basetest;
	AccountSucesspage AccountSucesspage;
	Loginpage Loginpage;

	

	@BeforeClass
	public void openbrowser_and_enter_url() {
		basetest =new basetest();
		basetest.openbrowser_and_enter_url(prop.getProperty("browsername"), prop.getProperty("url"));
		homepage=new homepage(driver);
		
		
	}
	@BeforeMethod
	public void navigatetoregister()
	{
		registerpage=homepage.navigatetoRegister();
	}
	
	
	@AfterClass
	public void close()
	{
		driver.close();
	}

	@Test(priority = 1)
	public void verify_registering_an_account_providing_all_feilds() {
		
		AccountSucesspage=registerpage.register_an_account_by_providing_all_feilds(dataprop.getProperty("firstname"),
				dataprop.getProperty("lastname"), utilities.generateEmailWithTimeStamp(),
				dataprop.getProperty("telephone"), dataprop.getProperty("password"));
		
		Assert.assertEquals(AccountSucesspage.account_created_sucess_message(), dataprop.getProperty("accountcreatedsucessmessage"));
		AccountSucesspage.clickonmyaccountdropmenu();
		List<WebElement> ele=driver.findElements(By.xpath("//ul[@class=\"dropdown-menu dropdown-menu-right\"]/li"));
		for(int i=0;i<ele.size();i++)
		{
			if(ele.get(i).getText().equalsIgnoreCase("logout"))
			{
				ele.get(i).click();
				
			}
		}
	}

	@Test(priority = 2)
	public void verify_registering_an_account_providing_only_manadatory_feilds() {
		
		
		AccountSucesspage=registerpage.register_an_account_by_providing_only_manadtaory_fields(dataprop.getProperty("firstname"),
				dataprop.getProperty("lastname"), utilities.generateEmailWithTimeStamp(),
				dataprop.getProperty("telephone"), dataprop.getProperty("password"));
	
		Assert.assertEquals(AccountSucesspage.account_created_sucess_message(), dataprop.getProperty("accountcreatedsucessmessage"));
		AccountSucesspage.clickonmyaccountdropmenu();
		List<WebElement> ele=driver.findElements(By.xpath("//ul[@class=\"dropdown-menu dropdown-menu-right\"]/li"));
		for(int i=0;i<ele.size();i++)
		{
			if(ele.get(i).getText().equalsIgnoreCase("logout"))
			{
				ele.get(i).click();
				
			}
		}
	}

	@Test(priority = 3)
	public void verify_properwarning_messages_displayed_when_you_dont_provide_anything_in_manadatory_feilds() {
		
		registerpage.clickonsubmitbutton();
		Assert.assertTrue(registerpage.displaystatusofwarning(dataprop.getProperty("Firstnamewarning"),
				dataprop.getProperty("Lastnamewarning"), dataprop.getProperty("Emailwarning"),
				dataprop.getProperty("Emailwarning"), dataprop.getProperty("passwordwarning")));
	}

	//@Test(priority=4)
	public void verify_properwarning_message_when_u_enter_existed_account_details() {
	
	registerpage.verify_enter_existed_account_details(dataprop.getProperty("firstname"),
				dataprop.getProperty("lastname"), prop.getProperty("validemail"),
				dataprop.getProperty("telephone"), dataprop.getProperty("password"));
		
	}
	//@Test(priority=4)
	public void verify_registereing_an_account_by_providing_invalid_email_address()
	{
		registerpage=homepage.navigatetoRegister();
		registerpage.enteringinvalidemailaddress(dataprop.getProperty("firstname"),
				dataprop.getProperty("lastname"), dataprop.getProperty("invalidemail"),
				dataprop.getProperty("telephone"), dataprop.getProperty("password"));
		Assert.assertEquals(dataprop.getProperty("invalidemail"),registerpage.displayofwarningwhenuenterinvalidemailaddress());
		
		
	}
	@Test(priority=5)
	public void verify_registeringan_account_by_providing_different_passwords_in_password_and_confirm_password_feilds()
	{

		registerpage.enterdifferentpasswordinbothpasswordandconfirmpassword(dataprop.getProperty("firstname"),
				dataprop.getProperty("lastname"),  utilities.generateEmailWithTimeStamp(),
				dataprop.getProperty("telephone"), dataprop.getProperty("password"),dataprop.getProperty("differentpasswordinconfirpassword"));	
	Assert.assertEquals(dataprop.getProperty("confirmpasswordwarning"),registerpage.displayofwarningwhenuenterdfferentpasswordinbothpasswordandconfrmpasswordfields());
	
}
	@Test(priority=6)
	public void VerifyRegistering_an_Account_by_providing_an_invalid_phone_number()
	{
		
		registerpage.enterinvalidphonenumber(dataprop.getProperty("firstname"),
				dataprop.getProperty("lastname"),  utilities.generateEmailWithTimeStamp(),
				dataprop.getProperty("invaildphonenumber"), dataprop.getProperty("password"),dataprop.getProperty("password"));	
	Assert.assertEquals(dataprop.getProperty("telephonewarning"),registerpage.displayoftelephonewarning());
	
	
	}
	@Test(priority=7)
	public void Verify_Registering_an_Account_by_using_the_Keyboard_keys()
	{
		
		registerpage.usingkeyboardkeys(dataprop.getProperty("firstname"),
				dataprop.getProperty("lastname"), utilities.generateEmailWithTimeStamp(),
				dataprop.getProperty("telephone"), dataprop.getProperty("password"));
		AccountSucesspage=registerpage.usingkeyboardkeys(dataprop.getProperty("firstname"),
				dataprop.getProperty("lastname"),  utilities.generateEmailWithTimeStamp(),
				dataprop.getProperty("telephone"), dataprop.getProperty("password"));
		
		Assert.assertEquals(AccountSucesspage.account_created_sucess_message(), dataprop.getProperty("accountcreatedsucessmessage"));
		AccountSucesspage.clickonmyaccountdropmenu();
		List<WebElement> ele=driver.findElements(By.xpath("//ul[@class=\"dropdown-menu dropdown-menu-right\"]/li"));
		for(int i=0;i<ele.size();i++)
		{
			if(ele.get(i).getText().equalsIgnoreCase("logout"))
			{
				ele.get(i).click();
				
			}
		}
}
	
	@Test(priority=8)
	public void Verify_whether_the_Password_fields_in_the_Register_Account_page_are_following_Password_Complexity_Standards() {
		
		registerpage.enterpasswordwithoutfollowingpasswordcomplexitystandards(dataprop.getProperty("firstname"),
				dataprop.getProperty("lastname"),  utilities.generateEmailWithTimeStamp(),
				dataprop.getProperty("telephone"), dataprop.getProperty("invalidpassword"));
		Assert.assertEquals(dataprop.getProperty("passwordwarning"), registerpage.displayofinvalidpasswordwarning());
}
	@Test(priority=9)
	public void Verify_whether_the_Privacy_Policy_checkbox_option_is_not_selected_by_default()
	{
		
		if(registerpage.privacypolicyselectedornot()==false)
				{
			Assert.assertTrue(true);
				}
	}
	@Test(priority=10)
	public void Verify_Registering_the_Account_without_selecting_the_Privacy_Policy_checkbox_option()
	{
		
		registerpage.privacypolicyisnotselected(dataprop.getProperty("firstname"),
				dataprop.getProperty("lastname"),  utilities.generateEmailWithTimeStamp(),
				dataprop.getProperty("telephone"), dataprop.getProperty("password"));
		Assert.assertEquals(dataprop.getProperty("privacypolicywarning"), registerpage.displayofprivacypolicywarning());
		
	}
	//@Test
	public void Verify_navigating_to_aboutuspage_by_clicking_on_link_provided_on_the_Register_Account_page()
	{
		registerpage=homepage.navigatetoRegister();
		registerpage.navigatetoaboutuspage();
		
	}
	//@Test
	public void Verify_navigating_to_deleveryinformationpage_by_clicking_on_link_provided_on_the_Register_Account_page()
	{
		registerpage=homepage.navigatetoRegister();
		registerpage.navigatetodeliveryinformation();
	}
	//@Test
	public void Verify_navigating_to_privacypolicy_by_clicking_on_link_provided_on_the_Register_Account_page()
	{
		registerpage=homepage.navigatetoRegister();
		registerpage.navigatetodeliveryinformation();
	}
	
	@Test(priority=11)
	public void verifyregisteringccount_when_yes_option_is_selected_in_newsletter()
	{
		registerpage.selctingyesoptioninnewsletter(dataprop.getProperty("firstname"),
				dataprop.getProperty("lastname"),  utilities.generateEmailWithTimeStamp(),
				dataprop.getProperty("telephone"), dataprop.getProperty("password"));
		Assert.assertEquals(AccountSucesspage.account_created_sucess_message(), dataprop.getProperty("accountcreatedsucessmessage"));
		AccountSucesspage.clickonmyaccountdropmenu();
		List<WebElement> ele=driver.findElements(By.xpath("//ul[@class=\"dropdown-menu dropdown-menu-right\"]/li"));
		for(int i=0;i<ele.size();i++)
		{
			if(ele.get(i).getText().equalsIgnoreCase("logout"))
			{
				ele.get(i).click();
				
			}
		}
	}
	@Test(priority=12)
	public void Verify_Registring_anAccountby_filling_Password_field_and_not_filling_Password_Confirm_field()

	{
		
		registerpage.enterpasswordwithoutfollowingpasswordcomplexitystandards(dataprop.getProperty("firstname"),
				dataprop.getProperty("lastname"),  utilities.generateEmailWithTimeStamp(),
				dataprop.getProperty("telephone"), "1234");
		Assert.assertEquals(dataprop.getProperty("passwordwarning"), registerpage.displayofinvalidpasswordwarning());
	}
	@Test(priority=13)
	public void verifypagetitle()
	{
		
		
		Assert.assertEquals(dataprop.getProperty("registerpagetitle"), driver.getTitle());
	}
	@Test(priority=14)
	public void verifypageurl()
	{
		registerpage=homepage.navigatetoRegister();
		Assert.assertEquals(dataprop.getProperty("registerpageurl"), driver.getCurrentUrl());
	}
	//@Test
		public void verify_navigatingto_loginpage_from_sidecolumnoptions_in_registerpage()
		{
			homepage = new homepage(driver);
			registerpage=homepage.navigatetoRegister();
			Loginpage=registerpage.clickonloginpagelinkinrightcolumnoptions();
			
		}
		//@Test
		public void verify_navigatingto_logipage_from_loginlink_in_registerpage()
		{
			homepage = new homepage(driver);
			registerpage=homepage.navigatetoRegister();
			Loginpage=registerpage.clickonloginlink();
			
		}
	
	
	
	
	
}