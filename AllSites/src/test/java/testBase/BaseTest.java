package testBase;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import base.Base;

public class BaseTest extends Base{
	
	@BeforeClass
	public void intilise() throws Exception
	{
		launch();
	}
	
	@AfterClass
	public void tearDown()
	{
		driver.quit();
	}

}
