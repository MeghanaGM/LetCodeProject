package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

import sun.util.logging.resources.logging;

// all test classes also extends the testbase class

public class LoginPageTest extends TestBase {
	
	/* here we write the test cases for login page by using test ng
	 * all the test claasses are also extends the testbase class
	 * steps:
	 * 1. first we create the loginpagetest constructor, because we need to 
	 * call the parent class constructor,
	 * 2.we have to create the object for the loginpage class, becasue we have 
	 * to write the test cases for loginpage so
	 * 
	 */
//	creating object for login class , if we declare here we can access through out the program
	 static LoginPage log;
	 
//	 login page returns home page means after login it will landing to the home page
	 HomePage homePage;
	
//	creating the loginPageTest constructor to call the super class constructor
	public LoginPageTest()
	{
		super();
	}
	
//	here we intilise our basic stuffs , means if we call the testbase class itilisation process will excuted
	
	@BeforeMethod
	public void setUp()
	{
		/*
		 * call the intilisation method
		 * create object for loginpage class
		 */
		intilization();
		log=new LoginPage();	// create always object in before method 
	}

	
	
	@Test(priority = 1)
	public void validateLoginPageTitleTest()
	{
		String actulTitle=log.validateLoginPageTitle();
		Assert.assertEquals(actulTitle, "Your store. Login", "title is matched test case is passed");
	}
	
	@Test(priority = 2)
	public void ValidateLogoTest()
	{
		boolean logo=log.ValidateLogo();
		Assert.assertTrue(logo);
	}
	
	@Test(priority = 3)
	public void loginTest() throws InterruptedException
	{
		homePage=log.login(prop.getProperty("username"),prop.getProperty("password")); //it will return the home page so here define the home page
		Thread.sleep(3000);
	}
	
	
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
}
