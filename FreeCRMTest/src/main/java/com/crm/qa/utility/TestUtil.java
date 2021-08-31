package com.crm.qa.utility;

import com.crm.qa.base.TestBase;

public class TestUtil extends TestBase {
	
	/*  --------implicit wait and page load out time generic method------
	 * here am going to define two static variables one for 
	 * 1. page load time out
	 * 2. implicit wait , beacuse we are not ready to hardcode the values
	 * infuture it will take lot of time to load the page so we can come here and change the values easily
	 */
	public static long IMPLICITLY_WAIT=10;
	public static long PAGE_LOAD_TIMEOUT=20;

	
	public void switchToFarme()
	{
		driver.switchTo().frame("");
		thread.sleep(2000);
		
	}
}
