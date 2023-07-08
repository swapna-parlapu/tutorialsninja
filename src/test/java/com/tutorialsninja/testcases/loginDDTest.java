package com.tutorialsninja.testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.tutorialninja.base.basetest;
import com.tutorialninja.utilities.utilities;
import com.tutorialsninja.pages.*;

public class loginDDTest extends basetest{
	Loginpage Loginpage;
	My_Account My_Account;
	homepage homepage;
	basetest basetest;
	logoutpage logoutpage;
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

	@Test(priority = 1, dataProvider = "invalidcrendencialsupplier")
		public void verify_login_with_invalid_credentials(String email, String password) {
			
			Loginpage.enter_invalid_crendencials(email, password);
			Assert.assertEquals(dataprop.getProperty("emailpasswordnotmatchingwarning"),
					Loginpage.retrive_emailpassword_not_matching_warning());
		}

		@DataProvider(name = "invalidcrendencialsupplier")
		public Object[][] supplydata() {
			Object[][] data = utilities.testdatafromexcel("sheet1");
			return data;

		}

		@Test(priority = 2, dataProvider = "validcrendentialsupplier")
		public void verify_login_with_validsetof_crendentials(String email, String password) {
			
			My_Account=Loginpage.enter_valid_login_credencials(email, password);
			Assert.assertEquals(dataprop.getProperty("myaccountpagetitle"),
					driver.getTitle());
			logoutpage=My_Account.clickonLogout();
			logoutpage.clickoncontinuebutton();
			
		}

		@DataProvider(name = "validcrendentialsupplier")
		public Object[][] supplyvaliddata() {
			Object[][] data = utilities.validtestdatafromexcel("loginvalidcredentials");
			return data;

		}

}
