package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

import net.bytebuddy.asm.Advice.This;

//here loginPage is a child class extend testbase class
public class LoginPage extends TestBase {
	
	/*
	 * steps:1.. define all the page factories or web elements in the particular page
	 * 1. in every page of the java we have to define two things
	 * 2. one thing is we have to define object repository, means we need to defile all the webelements are present in this page 
	 * we have to define over here .. collection of all web elements called object repository, page factory we have to define of login page
	 * 
	 * steps: 2 itilise all the page factories using intitelement method
	 * 1.  now we have to intilise all these page factories , how to initilizate the elements with help of page factory
	 * 2.  i will create the constructor ,the constructor name is same as class name, inside the constructor we have one class like 
	 * 'page factory' it contains one method 'init elements' we can use that one 
	* loginpage is constructor, inside the constructor we have one class,PageFactory and one method is initElements
	* this refers the currenct class obejct all these are current class variables
	* 
	* 
	* step 3:
	* create all the required messages for the login page
	* 
	* step-4:
	* once all the steps are completed in each page then we have to create the test cases for each class.
	* 
	*/
//		PageFactory.initElements(driver,LoginPage.this);// directly we can use this keyword or we can use like this also
	 
	
//	here am wrirting page factory or object repository for login page
	
//	----step 1----
//	here am going to define all the page factories related to the login page ..page factory is nothing but we element
//	page factory we have to use one annotation that is called .. @findBy
	
	@FindBy(name="Email")
	WebElement username;
	
	
	@FindBy(xpath="//input[@id='Password']")
	WebElement password;
	
	@FindBy(xpath = "//button[contains(text(),'Log in')]")
	WebElement loginButton;
	
	@FindBy(xpath = "//h1[text()='Admin area demo']")
	WebElement logo;
	
//	---------------step 2------------------ intialise the page objects
//	intilatise all the page factories by using page factory, so we can create one constructor
	
	public LoginPage()
	{
		/*
		 * loginpage is constructor, inside the constructor we have one class,PageFactory and one method is initElements
		 * this refers the currenct class obejct all these are current class variables
		 */
//		PageFactory.initElements(driver,LoginPage.this);// directly we can use this keyword or we can use like this also
		PageFactory.initElements(driver, this);
	}
	
	
//	---------------step -3------------------  actions
//	create all the required messages for the login page
	
	public String validateLoginPageTitle()
	{
		return driver.getTitle();
		
	}
	
	
	public boolean ValidateLogo()
	{
		return logo.isDisplayed();
	}

	
	public HomePage login(String un, String pwd) // here am pasing the argumnets , becasue we can pass multiple set of data
	{
		username.clear();
		username.sendKeys(un);
		password.clear();
		password.sendKeys(pwd);
		loginButton.click();
//		after login is susscefull it will redirect to the home page , obviously home page is landing page, so login page returms the home page
		return  new HomePage();
	}
}
