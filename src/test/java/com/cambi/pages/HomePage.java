package com.cambi.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.cambi.selenium.framework.BasePage;

public class HomePage extends BasePage {

	public HomePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(id = "io.cambi:id/toolbar_title")
    public WebElement homePageTitle;

	@FindBy(id = "io.cambi:id/ivNotification")
    public WebElement notificationIcon;
	
	@FindBy(className = "android.widget.ImageView")
    public WebElement mapIcon;
	
	@FindBy(id = "io.cambi:id/find_stores_button")
    public WebElement findStoreNearMeBttn;
	
	@FindBy(xpath = "//android.widget.ImageButton[@content-desc='Navigate up']")
	public WebElement threeDotMenu;
	
	
	public void verifyHomePageTitle() {
		Assert.assertTrue(isElementPresent(homePageTitle), "Home page title is not appearing");
		Assert.assertTrue(isElementPresent(notificationIcon), "Notification Bell icon is not appearing");
		Assert.assertTrue(isElementPresent(mapIcon), "GPS icon is not appearing");
		Assert.assertTrue(isElementPresent(findStoreNearMeBttn), "Find Store Near Me button is not appearing");
		Assert.assertTrue(isElementPresent(threeDotMenu), "Hamburger button is not appearing");
		
	}
	
	public void verifyNotificationIcon() {
		Assert.assertTrue(isElementPresent(notificationIcon), "Notification icon is not appearing");
		
	}
	
	public void verifyFindStoreNearMeBttn() {
		Assert.assertTrue(isElementPresent(findStoreNearMeBttn), "Find store near me button is not appearing");
		
	}
	
	public void verifyThreeDotMenu() {
		Assert.assertTrue(isElementPresent(threeDotMenu), "Three dot menu is not appearing");
		
	}

}
