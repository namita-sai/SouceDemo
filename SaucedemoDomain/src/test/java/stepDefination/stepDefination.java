package stepDefination;

import org.apache.log4j.*;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import io.cucumber.java.*;
import io.cucumber.java.en.*;
import saucePOMDesign.*;
import sauceUtil.*;
import testBase.*;

public class stepDefination extends testBase
{
	public Logger logger;
	public testBase testB;
	public GetDataExcel data;
	public LoginPOMDesign login;
	public UtilAll util;
	public ProductPage prod;
	public CartPage cart;
	public CheckOutsPage check;
	public CartInfo info;
	
	String actual="";
	String excepcted="";
	
	@Before
	public void startUp()
	{
		testBase.initialization();
		data=new GetDataExcel();
		login=new LoginPOMDesign(driver);
		util=new UtilAll();
		prod=new ProductPage(driver);
		cart=new CartPage(driver);
		check=new CheckOutsPage(driver);
		info=new CartInfo (driver);
		
		logger=Logger.getLogger("Luma Domain.");
		PropertyConfigurator.configure("Log4jfile.properties");
		
		logger.info("------------ ::  Execution Start  :: ------------");
		
	}
	@Given("User is on Login page")
	public void user_is_on_login_page() 
	{
		driver.get("https://www.saucedemo.com/");
		logger.info("Open Loggin Page.");		
	}

	@When("User enter valid username and password")
	public void user_enter_valid_username_and_password()
	{
		String username = data.getDataFromExcel("Login", 1, 0);	
		String passWord = data.getDataFromExcel("Login", 1, 1);
		
		
		login.enterUserName(username);
		logger.info("Enter UserName"+username);
		
		login.enterPassword(passWord);
		logger.info("Enter Password"+passWord);	
				
	}

	@When("click on login button")
	public void click_on_login_button() 
	{
		login.clickOnLoginBtn();
	}	
	
	@Given("User is on product page")
	public void user_is_on_product_page()
	{
		util.screenShot("ProductData");	
		
		driver.get(driver.getCurrentUrl());
		logger.info("User is on product page.");
	    
	}

	@Given("user select price from low to high")
	public void user_select_price_from_low_to_high() 
	{
		Select s=new Select(prod.getDropDownList());
		s.selectByValue("lohi");
		
		logger.info("Select price from low to high");
		util.screenShot("LowToHigh");			   
	}	
	
	
	@When("user select two items")
	public void user_select_two_items() 
	{		
		WebElement firstProd = prod.clickOnFirstProduct();
		WebElement secondProd = prod.clickOnSecondProduct();
	    firstProd.click();	    
	    logger.info("First product selected.");
	    
	    util.scrollDown(200);
	    logger.info("Scroll Down");
	    
	    secondProd.click();
	    logger.info("Second product selected.");
	    
	    util.screenShot("AddProd");
	}

	@Then("number of products added")
	public void number_of_products_added() 
	{
		
	    actual=cart.getCartElemnt().getText();
	    excepcted="2";
	    
	    Assert.assertEquals(actual, excepcted);
	    
	    logger.info("Cart number asseriotn passed.");
	}
	
	@Given("User is on cart page and checkouts product")
	public void user_is_on_cart_page_and_checkouts_product() 
	{
		cart.getCartElemnt().click();
		driver.get(driver.getCurrentUrl());		
		logger.info("User is on cart page.");	
		
		boolean val = cart.getFirstProdDetails().contains("Backpack");
		Assert.assertEquals(true, val);
		logger.info("First Product successfully aded.");
		
		boolean val2 = cart.getSecondProdDetails().contains("Onesie");
		Assert.assertEquals(true, val2);
		logger.info("Second Product successfully aded.");
		
		check.clickOnChekOutsBtn();
	    driver.get(driver.getCurrentUrl());
	    
	    logger.info("User is on CheckOuts Page");
	}

	

	@When("user enter all valid information detais")
	public void user_enter_all_valid_information_detais()
	{
		String fname=data.getDataFromExcel("Information", 0, 0);
		String lname=data.getDataFromExcel("Information", 1, 0);
		String postCode=data.getDataFromExcel("Information", 2, 0);
		
		check.enterFirstName(fname);
		logger.info("Enter First Name");
		
		check.enterLastName(lname);
		logger.info("Enter Last Name");
		
		check.enterPostalCodeName(postCode);
		logger.info("Enter Pstal Code Name");		
		
		util.screenShot("Info");	    
	}

	@When("click on continue button")
	public void click_on_continue_button() 
	{
		check.clickOnContinueBtn();
		logger.info("Click on continue button.");			
	}

	@Then("user is on detailed information page")
	public void user_is_on_detailed_information_page() 
	{
	   util.scrollDown(200);
	   
	   actual=info.getPaymentInformation();
	   excepcted="SauceCard #31337";	   
	   Assert.assertEquals(actual, excepcted);
	   logger.info("Payment info Assertion passed.");
	   
	   actual=info.getShippingInfo();
	   excepcted="Free Pony Express Delivery!";
	   Assert.assertEquals(actual, excepcted);
	   logger.info("Payment info Assertion passed.");
	   
	   actual=info.getTotalPrice();
	   excepcted="Total: $41.02";
	   Assert.assertEquals(actual, excepcted);
	   logger.info("Payment info Assertion passed.");
	   
	}
	
	@Then("check all information is correct click on finish")
	public void check_all_information_is_correct_click_on_finish() 
	{
		info.clickOnFinishBtn();
		logger.info("Click on Finish Button");
	}

	@Then("verify order is placed successfully and logout.")
	public void verify_order_is_placed_successfully_and_logout()
	{
		driver.get(driver.getCurrentUrl());
		actual=info.getDispatchInfo();
		excepcted="Your order has been dispatched, and will arrive just as fast as the pony can get there!";
 		
		Assert.assertEquals(actual, excepcted);
		logger.info("Dispatch info Assertion passed.");
		
		util.scrollUp(-200);
		logger.info("Scrolled UP.");
		
		info.clickOnCloseMenu();
		logger.info("Close Menu Clicked.");
		
		info.clickOnLogOutBtn();
		logger.info("Logout Clicked.");
	}


	@After
	public void tearDown()
	{
		testBase.quiteDriver();
		
		logger.info("------------ ::  Done  :: ------------");
		
	}


}
