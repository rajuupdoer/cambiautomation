package com.cambi.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.cambi.selenium.framework.BasePage;


public class ResetPasswordPage extends BasePage {

	public ResetPasswordPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(xpath = "//android.widget.TextView[@text='Reset Password']")
	public WebElement resetPasswordBtten;
	
	@FindBy(xpath = "//android.widget.EditText[@text='Phone Number']")
	public WebElement phoneNumberField;
	
	@FindBy(xpath = "//android.widget.Button[@text='Verify Mobile Number']")
	public WebElement verifyMobileNumber;
	
	public void resetPassword() {
		Assert.assertTrue(isElementPresent(resetPasswordBtten), "Reset Password is not appearing");
		clickOn(resetPasswordBtten);
	
	}
	public void enterPhoneNumber() {
		phoneNumberField.sendKeys("12345678");
		
	}
	
	public void verifyPhoneNumber() {
		Assert.assertTrue(isElementPresent(verifyMobileNumber), "Phone Number is not appearing");
		clickOn(verifyMobileNumber);
	
	}
	
}