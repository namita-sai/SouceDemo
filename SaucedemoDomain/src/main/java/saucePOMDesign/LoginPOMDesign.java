package saucePOMDesign;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;

public class LoginPOMDesign 
{
	//-------------Initialization------
	
	public LoginPOMDesign (WebDriver driver)
	{
		PageFactory.initElements(driver,this);		
	}
	
	//-------------Decalartion--------
	
	@FindBy(xpath="//input[contains(@id,'user')]")
	private WebElement userName;
	
	@FindBy(xpath="//input[contains(@id,'password')]")
	private WebElement pass;
	
	@FindBy(xpath="//input[contains(@id,'login')]")
	private WebElement loginBtn;
	
	//-------------Usage--------------
	
	public void enterUserName(String uname)
	{
		userName.sendKeys(uname);
	}

	public void enterPassword(String passwrd)
	{
		pass.sendKeys(passwrd);
	}
	
	public void clickOnLoginBtn()
	{
		loginBtn.click();
	}
	
}
