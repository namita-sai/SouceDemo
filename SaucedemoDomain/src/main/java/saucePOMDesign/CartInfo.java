package saucePOMDesign;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CartInfo 
{
	//-------------Initialization----------
	public CartInfo(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	//-------------Decalartion--------------
	@FindBy(xpath="(//div[contains(@class,'value')])[1]")
	private WebElement paymentInfo;
	
	@FindBy(xpath="(//div[contains(@class,'value')])[2]")
	private WebElement shipingInfo;
	
	@FindBy(xpath="//div[contains(@class,'_total')]")
	private WebElement totalPrice;
	
	@FindBy(xpath="//button[contains(@id,'finish')]")
	private WebElement finishBtn;
	
	@FindBy(xpath="//div[contains(@class,'text')]")
	private WebElement dispathInfo;
	
	@FindBy(xpath="//button[text()='Open Menu']")
	private WebElement closeMenu;
	
	@FindBy(xpath="//a[text()='Logout']")
	private WebElement logOutBtn;
	
	
	//------------Usage----------------------
	public String getPaymentInformation()
	{
		return paymentInfo.getText();
	}
	
	public String getShippingInfo()
	{		
		return shipingInfo.getText();
	}
	
	public String getTotalPrice()
	{
		return totalPrice.getText();
	}
	
	public void clickOnFinishBtn()
	{
		finishBtn.click();
	}
	
	public String getDispatchInfo()
	{
		return dispathInfo.getText();
	}	
	
	public void clickOnCloseMenu()
	{
		closeMenu.click();
	}
	
	public void clickOnLogOutBtn()
	{
		logOutBtn.click();
	}
}
