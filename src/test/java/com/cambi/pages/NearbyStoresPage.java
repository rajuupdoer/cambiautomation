package com.cambi.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.cambi.selenium.framework.BasePage;

public class NearbyStoresPage extends BasePage {

	public NearbyStoresPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(xpath = "//android.widget.CheckedTextView[@text='Nearby Stores']")
	public WebElement nearByStoresPageTitle;
	
	@FindBy(xpath = "//android.widget.ImageButton[@content-desc='Navigate up']")
	public WebElement backArrowbtn;
	
	@FindBy(xpath = "//android.widget.TextView[@content-desc='Search']")
	public WebElement searchIconbtn;
	
	@FindBy(id = "io.cambi:id/search_src_text")
	public WebElement searchTextbox;
	
	@FindBy(xpath = "//android.widget.TextView[@text='Bawarchi Biryani Point']")
	public WebElement storeResult;
	
	@FindBy(xpath = "//android.widget.ImageView[@content-desc='Clear query']")
	public WebElement clearQuerybttn;
	
	@FindBy(id = "io.cambi:id/stores_recycler_view")
	public WebElement storeList;
	
	public void verifyNearByStoresPageTilte() 
	{
		Assert.assertTrue(isElementPresent(nearByStoresPageTitle), "Near By store page is not appearing");
		clickOn(nearByStoresPageTitle);
	
	}
	
	public void verifySearchNearByStore() 
	{
		Assert.assertTrue(isElementPresent(searchIconbtn), "Search button is not appear");
		Assert.assertTrue(isElementPresent(backArrowbtn), "Back Arrow button is not appear");
		clickOn(searchIconbtn);
	
	}
	
	public void searchStore(String entervalue) {
		waitForElement(searchTextbox);
		searchTextbox.sendKeys(entervalue);
	}
	
	public void verifyStoreResult() 
	{
		Assert.assertTrue(isElementPresent(storeResult), "Store result is not found");
		clickOn(storeResult);
	
	}
	
	public void verifytapOnCrossBtn() 
	{
		Assert.assertTrue(isElementPresent(clearQuerybttn), "Search store should appear");
		clickOn(clearQuerybttn);
	
	}
	
	public void verifyAllListStore() 
	{
		Assert.assertTrue(isElementPresent(storeList), "Searched store should disappear and all list of stores should not be showing.");
		clickOn(storeList);
	
	}

}
