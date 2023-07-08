package com.tutorialsninja.testcases;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.tutorialninja.base.basetest;
import com.tutorialsninja.pages.*;

public class LoginTestForNoOfUnsucessfulloginattempts extends basetest {
	Loginpage Loginpage;
	basetest basetest;
	homepage homepage;

	@BeforeClass
	public void openbrowser_and_enter_url() {
		basetest = new basetest();
		basetest.openbrowser_and_enter_url(prop.getProperty("browsername"), prop.getProperty("url"));
		homepage = new homepage(driver);
		Loginpage = homepage.navigatetologin();
	}
	
	@Test(invocationCount=5,priority=6)
		public void verifynoofunsucessloginattempts()
		{
		

			Loginpage.enter_invalid_crendencials(dataprop.getProperty("invalidemailidinloginpage"), dataprop.getProperty("invalidpassword"));
			Assert.assertEquals(dataprop.getProperty("emailpasswordnotmatchingwarning"),
					Loginpage.retrive_emailpassword_not_matching_warning());
		}
		@Test(priority=13,dependsOnMethods="verifynoofunsucessloginattempts")
		public void verifywarningmessageafter5unsucessfullloginattempts()
		{
			Loginpage.enter_invalid_crendencials(dataprop.getProperty("invalidemailidinloginpage"), dataprop.getProperty("invalidpassword"));
			Assert.assertEquals(dataprop.getProperty("warningmessageafter5unsucessfullloginattempts"), Loginpage.retriverwarningmessageafter5unsucessfullloginattempts());

		}

}
