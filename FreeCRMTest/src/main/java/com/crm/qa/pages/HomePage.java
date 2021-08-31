package com.crm.qa.pages;

import org.openqa.selenium.Alert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

//here homePage is a child class extend testbase class
public class HomePage extends TestBase {
	
	/*
	 * login page is susccesfully done we are going to deals with the
	 * home pae ..this is the page libary for the home page
	 * if any links we click it will redirect to the landing page while we need
	 * to specify the landing page object
	 */
	
//	write the page factory for the home page			
	@FindBy(xpath = "//a[@id='nopSideBarPusher']")
	WebElement hmaberugButton;
	
	@FindBy(xpath = "//i[@class='nav-icon far fa-user']")
	WebElement contactIcon;
	
	@FindBy(xpath = "//a[@href='/Admin/Customer/List']")
	WebElement customers;
	
	
	public HomePage()
	{
		PageFactory.initElements(driver, this);
	}
	
	
	public Alert HandleAlert()
	{
		return driver.switchTo().alert();
	}
	
	public String VerifyHomePageTitle()
	{
		return driver.getTitle();
	}
	
		public void hmaberugButtonClick()
		{
			hmaberugButton.click();
		}
		
	public void contactIconClick()
	{
		contactIcon.click();
	}
	
	public CustomersPage customersLinkClick()
	{
		 customers.click();
		 return new CustomersPage();
	}

	
	
}
