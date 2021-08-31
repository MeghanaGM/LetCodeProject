package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import base.Base;
import utility.BaseUtility;

public class GoogleHomePage extends Base {

	@FindBy(xpath = "//input[@title='Search']")
	WebElement searchBox;
	
	String searchBoxItems="searchBoxItems";
	

	public GoogleHomePage() {
		PageFactory.initElements(driver, this);
	}

	public void searchBoxSendValue(String itemName) {
		searchBox.sendKeys(itemName);
		BaseUtility.selectContentFromSearchBox(searchBoxItems, itemName);
		

	}
}
