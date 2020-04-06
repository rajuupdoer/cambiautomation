package com.cambi.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.cambi.selenium.framework.BasePage;

public class SettingsPage extends BasePage {

	public SettingsPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}

	
	@FindBy(xpath = "//android.widget.CheckedTextView[@text='Settings']")
	public WebElement settingsPageTitle;
	
	@FindBy(xpath = "//android.widget.Switch[@text='On']")
	public WebElement onBttn;
	
	
	
	public void verifySettingsPageTilte() {
		Assert.assertTrue(isElementPresent(settingsPageTitle), "Settings page is not appearing");
		clickOn(settingsPageTitle);
		
	}
	
	public void verifyLocationBasednotification() {
		Assert.assertTrue(isElementPresent(onBttn), "The  'Location-based Notifications' switch button should not be OFF/ON as it was before closing the application.");
		clickOn(onBttn);
		
	}
	


}
