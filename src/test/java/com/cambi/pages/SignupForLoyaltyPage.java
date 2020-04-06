package com.cambi.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.cambi.selenium.framework.BasePage;

public class SignupForLoyaltyPage extends BasePage {

	public SignupForLoyaltyPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(xpath = "//android.widget.Button[@text='Signup For Loyalty']")
	public WebElement signupForLoyaltyBttn;
	
	@FindBy(xpath = "//android.widget.Button[@text='Subscribe']")
	public WebElement subscribeBttn;
	
	@FindBy(id = "io.cambi:id/arrow")
    public WebElement arrowBttn;
	
	public void tapOnSignupForLoyalty() {
		Assert.assertTrue(isElementPresent(signupForLoyaltyBttn), "Signup For Loyalty button is not appearing");
		Assert.assertTrue(isElementPresent(subscribeBttn), "Subscribe button is not appearing");
		clickOn(signupForLoyaltyBttn);
		clickOn(subscribeBttn);
	
	}	
	
	public void tapOnArrowBttn() {
		Assert.assertTrue(isElementPresent(arrowBttn), "Arrow button is not appearing");
		clickOn(arrowBttn);
	
	}	
	
	public void verifySignupForLoyaltyBttn() {
		Assert.assertTrue(isElementPresent(signupForLoyaltyBttn), "Signup For LoyaltyBttn button is not disabled");
	
	}	
}