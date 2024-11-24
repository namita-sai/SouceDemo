package saucePOMDesign;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductPage 
{
	//----------Initialization------
	public ProductPage (WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	//-----------Declaration---------
	
	@FindBy(xpath="//select[contains(@class,'prod')]")
	private WebElement prodDrpDwn;
	
	@FindBy(xpath="//div[@class='inventory_item_description' and .//div[contains(text(),'Back')]]//button")
	private WebElement firstProd;
	
	@FindBy(xpath="//div[@class='inventory_item_description' and .//div[contains(text(),'Onesie')]]//button")
	private WebElement secondProduct;
	
	//----------Usage------------
	
	public WebElement getDropDownList()
	{
		return prodDrpDwn;
	}
	
	public WebElement clickOnFirstProduct()
	{
		 return firstProd;
	}
	
	public WebElement clickOnSecondProduct()
	{
		return secondProduct;
	}	
	
	
}
