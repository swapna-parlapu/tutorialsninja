package com.tutorialsninja.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.tutorialninja.utilities.utilities;

public class Productcomparepage extends basepage{
	
	@FindBy(xpath="//*[@id=\"content\"]/p")
	private WebElement warningmessagewhennoproductsareadded;
	@FindBy(xpath="//*[@id=\"content\"]/div/div/a")
	private WebElement continuebutton;
	
	
	@FindBy(xpath="//*[@id=\"product-compare\"]/div[1]/a[2]")
	private WebElement shopping_cart;
	@FindBy(xpath="//*[@id=\"product-compare\"]/div[1]")
	private WebElement productremovedsucessmessage;
	@FindBy(xpath="//i[@class=\"fa fa-home\"]")
	private WebElement linktohome;
	
	public Productcomparepage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	public void verifythesameproductisaddedornot(String productname)
	{
		driver.findElement(By.xpath("//table/tbody//strong[text()='"+productname+"']"));
		}
	public String getwarningmessagewhennoproductsareadded()
	{
		utilities.getwebdriverwait(driver,warningmessagewhennoproductsareadded );
		return warningmessagewhennoproductsareadded.getText();
	}
	public int verifywhenproductsareadded()
	{
		List<WebElement> ele=driver.findElements(By.xpath("//*[@id=\"content\"]/table/tbody[1]/tr[1]/td"));
		return ele.size();
	}
	public Boolean verifywhenfifthproductwasadded(String secondproduct,String fifthproduct)
	{
		List<WebElement> ele=driver.findElements(By.xpath("//table//tbody[1]//tr[1]/td"));
		System.out.println(ele.get(1).getText());
		return((ele.get(1).getText().equals(secondproduct)&&ele.get(4).getText().equals(fifthproduct)));
}
	public void clickonaddtocart(String productname)
	{
		
		WebElement addtocart=driver.findElement(By.xpath("//strong[text()='"+productname+"']/ancestor::tbody/following-sibling::tbody[3]/tr/td/input[@value=\"Add to Cart\"]"));
		utilities.getwebdriverwait(driver, addtocart);
		addtocart.click();
	}
	public void clickonremove(String productname)
	{
		WebElement removebutton=driver.findElement(By.xpath("//strong[text()='"+productname+"']/ancestor::tbody/following-sibling::tbody[3]/tr/td/a[text()=\"Remove\"]"));
		utilities.getwebdriverwait(driver, removebutton);
		removebutton.click();
	}

	public Boolean verifyaddtocartsucessmessage(String productname)
	{
		return driver.findElement(By.xpath("//*[@id=\"product-compare\"]/div[1]")).getText().contains(productname);

		
		}
	public String productremovedsucessmessage()
	{
		return productremovedsucessmessage.getText();
		
	}
	public homepage clickoncontinuebutton()
	{
		continuebutton.click();
		return new homepage(driver);
	}
	public homepage clickonlinktohome()
	{
		utilities.getjavascriptexceutor(driver).executeScript("arguments[0].click();",linktohome);
		
		return new homepage(driver);
	}
	public void enterproductnameinsearchbox(String productname)
	{
		searchbox.sendKeys(productname);
	}
	public Searchpage clickonsearchbutton()
	{
		searchbutton.click();
		return new Searchpage(driver);
	}
		
	

}
