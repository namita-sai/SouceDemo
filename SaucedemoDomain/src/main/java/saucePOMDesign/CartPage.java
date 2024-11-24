package saucePOMDesign;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartPage
{
	
	//-----------Initialization-------
	public CartPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	//----------Declaration--------	
	@FindBy(xpath="//span[contains(@class,'shopping')]")
	private WebElement cartNum;	
	
	@FindBy(xpath="//div[@class='cart_item_label' and .//div[contains(text(),'Back')]]")
	private WebElement firstProd;
	
	@FindBy(xpath="//div[@class='cart_item_label' and .//div[contains(text(),'Onesie')]]")
	private WebElement secondProd;
	
	//----------Usage---------------	
	public WebElement getCartElemnt()
	{
		return cartNum;
	}
	
	public String getFirstProdDetails()
	{
		return firstProd.getText();
	}
	public String getSecondProdDetails()
	{
		return secondProd.getText();
	}
}
