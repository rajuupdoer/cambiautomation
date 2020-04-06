package com.cambi.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.cambi.selenium.framework.BasePage;

public class LogoutPage extends BasePage {

	public LogoutPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(xpath = "//android.widget.CheckedTextView[@text='Logout']")
	public WebElement logoutBttn;
	
	
	public void logout() {
		Assert.assertTrue(isElementPresent(logoutBttn), "Logout button is not appearing");
		clickOn(logoutBttn);
	
	}
	
	
}