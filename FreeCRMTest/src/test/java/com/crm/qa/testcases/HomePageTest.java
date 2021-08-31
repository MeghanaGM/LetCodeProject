package com.crm.qa.testcases;

import org.openqa.selenium.Alert;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.CustomersPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class HomePageTest  extends TestBase{
	LoginPage login;
	HomePage homePage;
	CustomersPage customersPage;
	public HomePageTest()
	{
		super();
	}

	@BeforeMethod
	public void setUp()
	{
		intilization();
		login=new LoginPage();
		homePage=login.login(prop.getProperty("username"),prop.getProperty("password"));	
	}
	
//	@Test
//	public void HandleAlertTest()
//	{
//		Alert alert=homePage.HandleAlert();
//		 alert.accept();
//	}
//	
	@Test(priority = 1)
	public void VerifyHomePageTitleTest()
	{
		String title=homePage.VerifyHomePageTitle();
		Assert.assertEquals(title, "Dashboard / nopCommerce administration","home page title is not matched");
	}
	
	@Test(priority = 2)
	public void hmaberugButtonClickTest()
	{
		homePage.hmaberugButtonClick();
	}
	
	@Test(enabled = false)
	public void contactIconClickTest() throws InterruptedException
	{
		homePage.contactIconClick();
		Thread.sleep(5000);
	}
	
	@Test(enabled = false)
	public void customerLinkClickTest()
	{
		customersPage=homePage.customersLinkClick();
		
	}
	
	
	@AfterMethod
	public void tearDown()
	{
		driver.quit();
	}
}
