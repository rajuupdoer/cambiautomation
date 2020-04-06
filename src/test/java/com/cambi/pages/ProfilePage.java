package com.cambi.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.cambi.selenium.framework.BasePage;


public class ProfilePage extends BasePage {

	public ProfilePage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(xpath = "//android.widget.CheckedTextView[@text='Profile']")
	public WebElement ProfilePageTitle;
	
	@FindBy(xpath = "//android.widget.ImageButton[@content-desc='Navigate up']")
	public WebElement backArrrowBttn;
	
	@FindBy(xpath = "//android.widget.TextView[@text='Your Info']")
	public WebElement yourInfo;
	
	@FindBy(id = "io.cambi:id/text_username")
	public WebElement userNameField;
	
	@FindBy(id = "io.cambi:id/text_mobile_number")
	public WebElement mobileNumberField;
	
	@FindBy(id = "io.cambi:id/text_address")
	public WebElement addressField;
	
	@FindBy(id = "io.cambi:id/text_city_state_zip")
	public WebElement stateZipField;
	
	@FindBy(xpath = "//android.widget.TextView[@text='Security']")
	public WebElement security;
	
	@FindBy(xpath = "//android.widget.Button[@text='Change Password']")
	public WebElement changePasswordBttn;
	
	@FindBy(xpath = "//android.widget.Button[@text='Edit']")
	public WebElement editBttn;
	
	@FindBy(xpath = "//android.widget.Button[@text='Cancel']")
	public WebElement cancelBttn;
	
	@FindBy(xpath = "//android.widget.Button[@text='Update']")
	public WebElement updateBttn;
	
	@FindBy(id = "io.cambi:id/input_firstname")
	public WebElement fNameField;
	
	@FindBy(id = "io.cambi:id/input_lastname")
	public WebElement lNameField;
	
	@FindBy(id = "io.cambi:id/input_editProfileAdd1")
	public WebElement add1Field;
	
	@FindBy(id = "io.cambi:id/input_editProfileAdd2")
	public WebElement add2Field;
	
	@FindBy(id = "io.cambi:id/input_editProfileZip")
	public WebElement zipField;
	
	@FindBy(id = "io.cambi:id/input_editProfileCity")
	public WebElement cityField;
	
	@FindBy(id = "io.cambi:id/input_editProfileState")
	public WebElement stateField;
	
	@FindBy(id = "io.cambi:id/currentPassword")
	public WebElement currentPassField;
	
	@FindBy(id = "io.cambi:id/newPassword")
	public WebElement newPassField;
	
	@FindBy(id = "io.cambi:id/confirmPassword")
	public WebElement confirmPassField;
	
	@FindBy(xpath = "//android.widget.ImageButton[@content-desc='Show password']")
	public WebElement showPassBttn;
	
	@FindBy(xpath = "//android.widget.Button[@text='Change Password']")
	public WebElement changePasswBttn;
	
	@FindBy(xpath = "//android.widget.ImageButton[@index='12']")
	public WebElement showPassbttn;
	
	@FindBy(xpath = "//android.widget.ImageButton[@index='14']")
	public WebElement showPassBttns;
	
	public void verifyProfilePageTilte() {
		Assert.assertTrue(isElementPresent(ProfilePageTitle), "Profile page is not appearing");
		clickOn(ProfilePageTitle);
	
	}
	
	
	public void verifyElementPresent() {
		Assert.assertTrue(isElementPresent(yourInfo), "Your info is not appearing");
		Assert.assertTrue(isElementPresent(userNameField), "User Name field is not appearing");
		Assert.assertTrue(isElementPresent(addressField), "Address field is not appearing");
		Assert.assertTrue(isElementPresent(stateZipField), "State Zip code field is not appearing");
		Assert.assertTrue(isElementPresent(security), "Security is not appearing");
		Assert.assertTrue(isElementPresent(changePasswordBttn), "Change Password button is not appearing");
		Assert.assertTrue(isElementPresent(editBttn), "Edit button is not appearing");
		Assert.assertTrue(isElementPresent(backArrrowBttn), "Back Arrow button is not appearing");
		clickOn(backArrrowBttn);
	
	}
	
	public void tapOnEditBttn() {
		Assert.assertTrue(isElementPresent(editBttn), "Edit button is not appearing");
		clickOn(editBttn);
	
	}
	
	public void verifyEditProfileField() {
		Assert.assertTrue(isElementPresent(yourInfo), "Your info is not appearing");
		Assert.assertTrue(isElementPresent(cancelBttn), "Cancel button is not appearing");
		Assert.assertTrue(isElementPresent(updateBttn), "Update button is not appearing");
		Assert.assertTrue(isElementPresent(fNameField), "Fname field is not appearing");
		Assert.assertTrue(isElementPresent(lNameField), "Lname is not appearing");
		Assert.assertTrue(isElementPresent(add1Field), "Add1 field is not appearing");
		Assert.assertTrue(isElementPresent(add2Field), "Add2 field is not appearing");
		Assert.assertTrue(isElementPresent(zipField), "Zip code field is not appearing");
		Assert.assertTrue(isElementPresent(cityField), "City field is not appearing");
		Assert.assertTrue(isElementPresent(stateField), "State field is not appearing");
		
	}
	
	public void verifyTapOnChangePassword() {
		Assert.assertTrue(isElementPresent(changePasswordBttn), "Change Password button is not appearing");
		clickOn(changePasswordBttn);
		
	
	}
	
	public void verifyChangePasswordField() {
		Assert.assertTrue(isElementPresent(currentPassField), "Current Password field is not appearing");
		Assert.assertTrue(isElementPresent(newPassField), "New Password field is not appearing");
		Assert.assertTrue(isElementPresent(confirmPassField), "Confirm Password field is not appearing");
		Assert.assertTrue(isElementPresent(showPassBttn), "Show Password button is not appearing");
		//Assert.assertTrue(isElementPresent(showPassBttn2), "Show Password button is not appearing");
		//Assert.assertTrue(isElementPresent(showPassBttn3), "Show Password button is not appearing");
	
	}
	
	public void enterUpdatedValue() {
		String fname = "Raju" + randomNumber();
		fNameField.sendKeys(fname);
		String lname = "Kumar" + randomNumber();
		lNameField.sendKeys(lname);
		String add1 = "A43" + randomNumber();
		add1Field.sendKeys(add1);
		String add2 = "iThum Tower B" + randomNumber();
		add2Field.sendKeys(add2);
		String zip = "10051" + randomNumber();
		zipField.sendKeys(zip);
		String city = "Tacoma" + randomNumber();
		cityField.sendKeys(city);
		String state = "Washington" + randomNumber();
		stateField.sendKeys(state);
		
	}
	
	/*public void enterUpdatedValues(String fname) {
		String randomNumber= fNameField.getText();
		Assert.assertTrue(isElementPresent(fNameField), "First Name is not Change");
		Assert.assertTrue(fname.contentEquals(randomNumber));
		
	}*/
	
	public void clickOnCancelBttn() {
		clickOn(cancelBttn);
	}

	public void clickOnUpdateBttn() {
		clickOn(updateBttn);
	}
	
	public void enterUpdatePasswordfield() {
		currentPassField.sendKeys("12345678");
		clickOn(showPassBttn);
		newPassField.sendKeys("123456789");
		confirmPassField.sendKeys("123456789");
	}
		
		
	}
	
	
	
	
	