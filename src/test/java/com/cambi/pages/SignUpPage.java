package com.cambi.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.cambi.selenium.framework.BasePage;

public class SignUpPage extends BasePage {

	public SignUpPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(xpath = "//android.widget.TextView[@text='Sign Up']")
	public WebElement signUpBttn;
	
	@FindBy(xpath = "//android.widget.ImageButton[@content-desc='Navigate up']")
	public WebElement backBtn;
	
	
	@FindBy(xpath = "//android.widget.EditText[@text='Phone Number']")
	public WebElement enterPhoneNumber;
	
	@FindBy(xpath = "//android.widget.TextView[@text='By signing up, you accept our terms and conditions']")
	public WebElement tapTermsandConditions;
	
	@FindBy(xpath = "//android.widget.Button[@text='OK']")
	public WebElement okBtn;
	
	@FindBy(xpath = "//android.widget.Button[@text='Send Verification Token']")
	public WebElement sendVerification;
	
	@FindBy(xpath = "//android.widget.TextView[@text='Resend Token']")
	public WebElement resendToken;
	
	@FindBy(xpath = "//android.widget.EditText[@text='Enter Token']")
	public WebElement enterToken;
	
	@FindBy(xpath = "//android.widget.Button[@text='Verify Token']")
	public WebElement verifyTokenBttn;
	
	@FindBy(xpath = "//android.widget.EditText[@text='Password']")
	public WebElement enterPass;
	
	@FindBy(xpath = "//android.widget.EditText[@text='Confirm Password']")
	public WebElement enterConfirmPass;
	
	@FindBy(xpath = "//android.widget.Button[@text='Continue Sign Up']")
	public WebElement continueSignUpBtn;
	
	
	public void verifySignUpBttn() {
		Assert.assertTrue(isElementPresent(signUpBttn), "SignUp button is not appearing");
		clickOn(signUpBttn);
		
	}
	
	public void backBttn() {
		Assert.assertTrue(isElementPresent(backBtn), "Back button is not appearing");
		clickOn(backBtn);
	
	}
	
	public void enterphoneNumber() {
		String phoneNumber = "8282828282" + randomNumber();
		enterPhoneNumber.sendKeys(phoneNumber);
		
		
	}
	
	public void tapOnTermsandConditions() {
		Assert.assertTrue(isElementPresent(tapTermsandConditions), "Terms and Condition is not appearing");
		clickOn(tapTermsandConditions);
	
	}
	
	public void tapOnOKBttn() {
		Assert.assertTrue(isElementPresent(okBtn), "OK button is not appearing");
		clickOn(okBtn);
	}
	
	public void sendVerificationToken() {
		Assert.assertTrue(isElementPresent(sendVerification), "Send Verification button is not appearing");
		clickOn(sendVerification);
	
	}
	
	public void reSendToken() {
		Assert.assertTrue(isElementPresent(resendToken), "Resend Token button is not appearing");
		clickOn(resendToken);
	
	}
	
	public void enterTokenTextfield() {
		enterToken.sendKeys("0000000");
		clickOn(enterToken);
		
	}
	
	public void verifyToken() {
		Assert.assertTrue(isElementPresent(verifyTokenBttn), "Verify Token button is not appearing");
		clickOn(verifyTokenBttn);
	
	}
	
	public void enterPasswordfield() {
		enterPass.sendKeys("123456789");
		enterConfirmPass.sendKeys("123456789");
	
	}
	
	public void continueSignUpBttn() {
		Assert.assertTrue(isElementPresent(continueSignUpBtn), "Continue Sign Up button is not appearing");
		clickOn(continueSignUpBtn);
	
	}
	
	public void enterpass(String entervalue) {
		waitForElement(enterPass);
		enterPass.sendKeys(entervalue);
		waitForElement(enterConfirmPass);
		enterConfirmPass.sendKeys(entervalue);
	}
	
	public void enterPass(String entervalue) {
		waitForElement(enterPass);
		enterPass.sendKeys(entervalue);
	}
	
	public void enterConnfirmpass(String entervalue) {
		waitForElement(enterConfirmPass);
		enterConfirmPass.sendKeys(entervalue);
	}
	
	
}