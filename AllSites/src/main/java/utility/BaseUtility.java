package utility;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import base.Base;

public class BaseUtility extends Base {

	public static void selectContentFromSearchBox(String xPath,String value)
	{
		List<WebElement> searchItems=driver.findElements(By.xpath(xPath));
		for(WebElement item:searchItems )
		{
			if(item.getText().contains(value))
			{
				item.click();
				break;
			}
		}
	}
}
