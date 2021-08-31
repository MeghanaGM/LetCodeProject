package com.crm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.GeckoDriverInfo;

import com.crm.qa.utility.TestUtil;

 public class TestBase {
	/*
	 * steps-1 :for hybrid framework
	 * -----------------------------
	 * 1. we need to create the constructor for reading the proprties file
	 * 2. we have to declare two global variables like webdriver driver, properies prop
	 * 3. step 1 is reading the properties from the config.properties file 
	 * 
	 * 
	 * step-2:
	 * ---------------------------------------
	 * 1. after constructor part will done.. we have to create one intilisation method
	 *  * 1. i will read the properties of my broswer , i need to read the broswer property from config.properties
	* 2. after intilising the browsers we need to define some common pre requisites it will applicable for all pages
	* 3. in some applications some pages will take lot of time to load the application so we i have to write one genric
	*  method for both implicit and page load out time
	* 4. we have to create the generic methods in utility package we can re use those methods, inside the utility package
	* craete one class like, testUtil.. in this class we can write the methods , we can define implicit and page load out 
	* in config.properties also
	 * 
	 *  step-3:
	 *  --------------------------------------
	 *  1. all java classes extends the testbase class
	 *  2. write the web elemnts and methods in each java class ..related to the particular page
	 *  
	 *  step-4:
	 *  -------------------
	 *  /*
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
	* step 5:
	* ----------------------------------
	* 
	*/
	 
//	********************************** step 1*******************************************************
//	declare the global variables we can access the through out the program and in base class and child class also
	
	public static  WebDriver driver; //i can make it as a static beacuse we can directly access throgh class name
	public static Properties prop; // this prop can be used throughout the program inside the child classes also and test base class also
	 
//	creating the constructor
	 public TestBase() {
		 
		 try {
			 prop=new Properties(); //import properties from java util package
			 FileInputStream ip=new FileInputStream("D:\\Hybdrid Framework\\FreeCRMTest\\src\\main\\java\\com\\crm\\qa\\configuration\\config.properties"); //here we are reading the data from the properties file . so we are using file
//			 input stream it accepts a argument of config.properties file location
			 prop.load(ip);
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}
//		********************************** step 1*******************************************************
	 
//		********************************** step 2*******************************************************
//	 here am going to create one intilisation method .. 
	 public static void intilization()
	 {
		  /*
		   * 1. i will read the properties of my broswer , i need to read the broswer property from config.properties
		   * 2. after intilising the browsers we need to define some common pre requisites it will applicable for all pages
		   * 3. in some applications some pages will take lot of time to load the application so we i have to write one genric
		   *  method for both implicit and page load out time
		   * 4. we have to create the generic methods in utility package we can re use those methods, inside the utility package
		   * craete one class like, testUtil.. in this class we can write the methods , we can define implicit and page load out 
		   * in config.properties also
		   */
		String browserName= prop.getProperty("browser");// here am reading the browesr from property file
		if(browserName.equals("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "D:\\Hybdrid Framework\\FreeCRMTest\\Drivers\\chromedriver.exe");
			driver=new ChromeDriver();
		}else if(browserName.equals(""))
		{
			System.setProperty("webdriver.gecko.driver", "");
			driver=new FirefoxDriver();
		}
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICITLY_WAIT,TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS); //in some applications some pages will take lot of time to 
//		load the application so we i have to write one genric method for both implicit and page load out time
		
//		i have to to the  url from the properties files.. by using property refrence and getProperty method
		
		driver.get(prop.getProperty("url"));
			
	 }
//		********************************** step 2*******************************************************

}
