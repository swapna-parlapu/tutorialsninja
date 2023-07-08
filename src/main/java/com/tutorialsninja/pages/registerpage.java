package com.tutorialsninja.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.tutorialsninja.pages.My_Account;
import com.tutorialsninja.pages.homepage;
import com.tutorialninja.utilities.utilities;

public class registerpage extends basepage {
	AccountSucesspage AccountSucesspage;
	My_Account my_account;
	homepage homepage;
	Aboutuspage Aboutuspage;
	deliveryinformationpage deliveryinformationpage;
	privacypolicypage privacypolicypage;
	termsandconditionspage termsandconditionspage;

	@FindBy(xpath = "//input[@placeholder=\"First Name\"]")
	private WebElement firstnametextbox;
	@FindBy(xpath = "//input[@placeholder='Last Name' and @name='lastname']")
	private WebElement lastnametextbox;
	@FindBy(xpath = "//input[@placeholder='Telephone' and @name='telephone']")
	private WebElement telephonetextbox;
	@FindBy(xpath = "//input[@placeholder=\"Password\" and @name='password']")
	private WebElement passwordtextbox;
	@FindBy(xpath = "//input[@placeholder='E-Mail' and @name='email']")
	private WebElement emailtextbox;
	@FindBy(xpath = "//input[@placeholder=\"Password Confirm\" and @name='confirm']")
	private WebElement passwordconfirmtextbox;
	@FindBy(xpath = "//label[text()='No']")
	private WebElement newsletternooption;
	@FindBy(xpath = "//label[text()='Yes']")
	private WebElement newsletterYesoption;
	@FindBy(xpath = "//input[@name='agree']")
	private WebElement privacypolicy;
	@FindBy(xpath = "//input[@type='submit']")
	private WebElement submitbutton;
	
	@FindBy(xpath = "//div[text()='First Name must be between 1 and 32 characters!']")
	private WebElement Firstnamewarning;
	@FindBy(xpath = "//div[text()='Last Name must be between 1 and 32 characters!']")
	private WebElement Lastnamewarning;
	@FindBy(xpath = "//div[text()='E-Mail Address does not appear to be valid!']")
	private WebElement Emailwarning;
	@FindBy(xpath = "//div[text()='Telephone must be between 3 and 32 characters!']")
	private WebElement Telephonewarning;
	@FindBy(xpath = "//div[text()='Password must be between 4 and 20 characters!']")
	private WebElement Passwordwarning;
	@FindBy(xpath = "//div[text()='Password confirmation does not match password!']")
	private WebElement confirmpasswordwarning;
	@FindBy(xpath = "//*[@id=\"account-register\"]/div[1]")
	private WebElement privacypolicywarning;
	//footer options
	@FindBy(xpath = "/html/body/footer/div/div/div[1]/ul/li[1]/a")
	private WebElement Aboutus;
	@FindBy(xpath = "/html/body/footer/div/div/div[1]/ul/li[2]/a")
	private WebElement deliveryInformation;
	@FindBy(xpath = "/html/body/footer/div/div/div[1]/ul/li[3]/a")
	private WebElement footerprivacypolicy;
	@FindBy(xpath = "/html/body/footer/div/div/div[1]/ul/li[4]/a")
	private WebElement TermsandConditions;
	@FindBy(xpath = "/html/body/footer/div/div/div[2]/ul/li[1]/a")
	private WebElement Contactus ;
	@FindBy(xpath = "/html/body/footer/div/div/div[2]/ul/li[2]/a")
	private WebElement returnsfooter;
	@FindBy(xpath = "/html/body/footer/div/div/div[2]/ul/li[3]/a")
	private WebElement sitemap;
	@FindBy(xpath = "/html/body/footer/div/div/div[3]/ul/li[1]/a")
	private WebElement Brands;
	@FindBy(xpath = "/html/body/footer/div/div/div[3]/ul/li[2]/a")
	private WebElement GiftCertificate;
	@FindBy(xpath = "/html/body/footer/div/div/div[3]/ul/li[3]/a")
	private WebElement Affiliate;
	@FindBy(xpath = "/html/body/footer/div/div/div[3]/ul/li[4]/a")
	private WebElement specials;
	@FindBy(xpath = "/html/body/footer/div/div/div[4]/ul/li[1]/a")
	private WebElement myaccount;
	@FindBy(xpath = "/html/body/footer/div/div/div[4]/ul/li[2]/a")
	private WebElement orderHistory;
	@FindBy(xpath = "/html/body/footer/div/div/div[4]/ul/li[3]/a")
	private WebElement Wishlistfooter;
	@FindBy(xpath = "/html/body/footer/div/div/div[4]/ul/li[4]/a")
	private WebElement newsletterfooter;
	
	//right column options
	@FindBy(xpath="//*[@id=\"column-right\"]/div/a[1]")
	private WebElement login;
	@FindBy(xpath="//*[@id=\"column-right\"]/div/a[2]")
	private WebElement register;
	@FindBy(xpath="//*[@id=\"column-right\"]/div/a[3]")
	private WebElement forgetpassword;
	@FindBy(xpath="//*[@id=\"column-right\"]/div/a[4]")
	private WebElement Myaccount;
	@FindBy(xpath="//*[@id=\"column-right\"]/div/a[5]")
	private WebElement Addressbook;
	@FindBy(xpath="//*[@id=\"column-right\"]/div/a[6]")
	private WebElement Wishlist;
	@FindBy(xpath="//*[@id=\"column-right\"]/div/a[7]")
	private WebElement Orderhistory;
	@FindBy(xpath="//*[@id=\"column-right\"]/div/a[8]")
	private WebElement Downloads;
	@FindBy(xpath="//*[@id=\"column-right\"]/div/a[9]")
	private WebElement Recurringpayments;
	@FindBy(xpath="//*[@id=\"column-right\"]/div/a[10]")
	private WebElement rewardpoints;
	@FindBy(xpath="//*[@id=\"column-right\"]/div/a[11]")
	private WebElement returns;
	@FindBy(xpath="//*[@id=\"column-right\"]/div/a[12]")
	private WebElement transactions;
	@FindBy(xpath="//*[@id=\"column-right\"]/div/a[13]")
	private WebElement newsletter;
	@FindBy(xpath="//*[@id=\"column-right\"]/div/a[1]")
	private WebElement loginpagelinkinrightcolumnoptions;
	@FindBy(xpath="//*[@id=\"content\"]/p/a")
	private WebElement loginlink;
	
	
	
	
public registerpage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	public registerpage navigatetoregister() {
		homepage = new homepage(driver);
		homepage.navigatetoRegister();
		return new registerpage(driver);
	}

	public AccountSucesspage register_an_account_by_providing_all_feilds(String firstname, String lastname,
			String email, String telephone, String password) {
		firstnametextbox.clear();
		firstnametextbox.sendKeys(firstname);
		lastnametextbox.clear();
		lastnametextbox.sendKeys(lastname);
		emailtextbox.clear();
		emailtextbox.sendKeys(email);
		telephonetextbox.clear();
		telephonetextbox.sendKeys(telephone);
		passwordtextbox.clear();
		passwordtextbox.sendKeys(password);
		passwordconfirmtextbox.clear();
		passwordconfirmtextbox.sendKeys(password);
		newsletternooption.click();
		privacypolicy.click();
		submitbutton.click();
		return new AccountSucesspage(driver);
	}

	public AccountSucesspage register_an_account_by_providing_only_manadtaory_fields(String firstname, String lastname,
			String email, String telephone, String password) {
		firstnametextbox.clear();
		firstnametextbox.sendKeys(firstname);
		lastnametextbox.clear();
		lastnametextbox.sendKeys(lastname);
		emailtextbox.clear();
		emailtextbox.sendKeys(email);
		telephonetextbox.clear();
		telephonetextbox.sendKeys(telephone);
		passwordtextbox.clear();
		passwordtextbox.sendKeys(password);
		passwordconfirmtextbox.clear();
		passwordconfirmtextbox.sendKeys(password);
		privacypolicy.click();
		submitbutton.click();
		return new AccountSucesspage(driver);
	}

	public Boolean displaystatusofwarning(String firstnamewarning, String lastnamewarning, String emailwarning,
			String telephonewarning, String passwordwarning) {
		return (Firstnamewarning.getText().contains(firstnamewarning)
				&& Lastnamewarning.getText().contains(lastnamewarning) && Emailwarning.getText().contains(emailwarning)
				&& Passwordwarning.getText().contains(passwordwarning));

	}

	public void verify_enter_existed_account_details(String firstname, String lastname, String email, String telephone,
			String password) {
		firstnametextbox.clear();
		firstnametextbox.sendKeys(firstname);
		lastnametextbox.clear();
		lastnametextbox.sendKeys(lastname);
		emailtextbox.clear();
		emailtextbox.sendKeys(email);
		telephonetextbox.clear();
		telephonetextbox.sendKeys(telephone);
		passwordtextbox.clear();
		passwordtextbox.sendKeys(password);
		passwordconfirmtextbox.clear();
		passwordconfirmtextbox.sendKeys(password);
		newsletternooption.click();
		privacypolicy.click();
		submitbutton.click();

	}

	

	public void clickonsubmitbutton() {
		submitbutton.click();
	}

	public void enteringinvalidemailaddress(String firstname, String lastname, String invalidemail, String telephone,
			String password) {
		firstnametextbox.clear();
		firstnametextbox.sendKeys(firstname);
		lastnametextbox.clear();
		lastnametextbox.sendKeys(lastname);
		emailtextbox.sendKeys(invalidemail);
		telephonetextbox.sendKeys(telephone);
		passwordtextbox.sendKeys(password);
		passwordconfirmtextbox.sendKeys(password);
		newsletternooption.click();
		privacypolicy.click();
		submitbutton.click();
	}

	public String displayofwarningwhenuenterinvalidemailaddress() {
		return Emailwarning.getText();

	}

	public void enterdifferentpasswordinbothpasswordandconfirmpassword(String firstname, String lastname,
			String invalidemail, String telephone, String password, String diffrentpassword) {
		firstnametextbox.sendKeys(firstname);
		lastnametextbox.sendKeys(lastname);
		emailtextbox.sendKeys(invalidemail);
		telephonetextbox.sendKeys(telephone);
		passwordtextbox.sendKeys(password);
		passwordconfirmtextbox.sendKeys(diffrentpassword);
		newsletternooption.click();
		privacypolicy.click();
		submitbutton.click();

	}

	public String displayofwarningwhenuenterdfferentpasswordinbothpasswordandconfrmpasswordfields() {
		return confirmpasswordwarning.getText();

	}
	public void enterinvalidphonenumber(String firstname, String lastname,
			String email, String invalidtelephone, String password, String diffrentpassword)
	{
		firstnametextbox.sendKeys(firstname);
		lastnametextbox.sendKeys(lastname);
		emailtextbox.sendKeys(email);
		telephonetextbox.sendKeys(invalidtelephone);
		passwordtextbox.sendKeys(password);
		passwordconfirmtextbox.sendKeys(diffrentpassword);
		newsletternooption.click();
		privacypolicy.click();
		submitbutton.click();
		
	}
	public String displayoftelephonewarning()
	{
		utilities.getwebdriverwait(driver, Telephonewarning);
		return  Telephonewarning.getText() ;
		
	}
	public AccountSucesspage usingkeyboardkeys(String firstname, String lastname, String email, String telephone,
			String password)
	{
		Actions act=new Actions(driver);
		firstnametextbox.sendKeys(firstname);
		act.sendKeys(Keys.TAB).build().perform();
		lastnametextbox.sendKeys(lastname);
		act.sendKeys(Keys.TAB).build().perform();

		emailtextbox.sendKeys(email);
		act.sendKeys(Keys.TAB).build().perform();

		telephonetextbox.sendKeys(telephone);
		act.sendKeys(Keys.TAB).build().perform();

		passwordtextbox.sendKeys(password);
		act.sendKeys(Keys.TAB).build().perform();

		passwordconfirmtextbox.sendKeys(password);
		act.sendKeys(Keys.TAB).build().perform();

		act.sendKeys(Keys.TAB).build().perform();
		act.sendKeys(Keys.TAB).build().perform();


		act.sendKeys(Keys.ENTER).build().perform();

		act.sendKeys(Keys.TAB).build().perform();
		act.sendKeys(Keys.ENTER).build().perform();

		return new AccountSucesspage(driver);

	}
	public Boolean verify_placeholederText(String firsnamepalcehoder,String lastnameplaceholeder,String emailplaceholder,String telephonaplaceholder,String passwordplaceholder,String confirmpasswordpalceholder) {
		System.out.println(firstnametextbox.getAttribute("value"));
	
		return (firstnametextbox.getAttribute("value").contains(firsnamepalcehoder)&& lastnametextbox.getAttribute("value").contains(lastnameplaceholeder)&&emailtextbox .getAttribute("value").contains(emailplaceholder)&&
				telephonetextbox.getAttribute("value").contains("telephonaplaceholder")&& passwordtextbox.getAttribute("value").contains(passwordplaceholder)&&passwordconfirmtextbox.getAttribute("value").contains(confirmpasswordpalceholder));
		
	}
	public void enterpasswordwithoutfollowingpasswordcomplexitystandards(String firstname, String lastname,
			String validemail, String telephone, String invalidpassword)
	{
		firstnametextbox.sendKeys(firstname);
		lastnametextbox.sendKeys(lastname);
		emailtextbox.sendKeys(validemail);
		telephonetextbox.sendKeys(telephone);
		passwordtextbox.sendKeys(invalidpassword);
		passwordconfirmtextbox.sendKeys(invalidpassword);
		newsletternooption.click();
		privacypolicy.click();
		submitbutton.click();
	}
	public String displayofinvalidpasswordwarning()
	{
		return Passwordwarning.getText();
		
	}
	public boolean privacypolicyselectedornot()
	{
		return privacypolicy.isSelected();
		}
	public void  privacypolicyisnotselected(String firstname, String lastname,
			String validemail, String telephone, String password)
	{
		firstnametextbox.sendKeys(firstname);
		lastnametextbox.sendKeys(lastname);
		emailtextbox.sendKeys(validemail);
		telephonetextbox.sendKeys(telephone);
		passwordtextbox.sendKeys(password);
		passwordconfirmtextbox.sendKeys(password);
		newsletternooption.click();
		
		submitbutton.click();

	}
	public String displayofprivacypolicywarning()
	{
		return privacypolicywarning.getText();
		
	}
	public Aboutuspage navigatetoaboutuspage()
	{
		Aboutus.click();
		return Aboutuspage;
	}
	public deliveryinformationpage navigatetodeliveryinformation()
	{
		deliveryInformation.click();
		return deliveryinformationpage;
		
	}
	public privacypolicypage navigatetoPrivacyPolicy()
	{
		footerprivacypolicy.click();
		return privacypolicypage;
	}
	public termsandconditionspage  navigatetotermsandconditions()
	{
		 TermsandConditions.click();
		return termsandconditionspage; 
		}
	public void selctingyesoptioninnewsletter(String firstname, String lastname, String email, String telephone,
				String password) {
			firstnametextbox.sendKeys(firstname);
			lastnametextbox.sendKeys(lastname);
			emailtextbox.sendKeys(email);
			telephonetextbox.sendKeys(telephone);
			passwordtextbox.sendKeys(password);
			passwordconfirmtextbox.sendKeys(password);
			newsletterYesoption.click();
			privacypolicy.click();
			submitbutton.click();
		}
	public void notfillingpasswordconfirmfeild(String firstname, String lastname, String email, String telephone,
			String password)
	{
		firstnametextbox.sendKeys(firstname);
		lastnametextbox.sendKeys(lastname);
		emailtextbox.sendKeys(email);
		telephonetextbox.sendKeys(telephone);
		passwordtextbox.sendKeys(password);
		
		newsletterYesoption.click();
		privacypolicy.click();
		submitbutton.click();
		}
	public String getpagetitle()
	{

		return driver.getTitle();
		 
	}
	public String getpageurl()
	{
		return driver.getCurrentUrl();
		
	}
	public Loginpage clickonloginpagelinkinrightcolumnoptions()
	{
		loginpagelinkinrightcolumnoptions.click();
		return new Loginpage(driver);
	}
	public Loginpage clickonloginlink()
	{
		loginlink.click();
		return new Loginpage(driver);
	}
	public void clickonmyaccountdropmenu()
	{
		myAccountDropMenu.click();
	}
	

	
}