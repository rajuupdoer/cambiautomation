package com.cambi.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.Reporter;

import com.cambi.selenium.framework.BasePage;

import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;

public class LoginPage extends BasePage {


	public LoginPage(WebDriver driver) {
		super(driver);
	}
	

	@FindBy(id = "io.cambi:id/input_username")
    public WebElement phoneNumber;
 
	@FindBy(id = "io.cambi:id/input_password")
	public WebElement passwordFiled;
	
	@FindBy(id = "io.cambi:id/text_input_password_toggle")
	public WebElement eyeBttn;
	
	@FindBy(id = "io.cambi:id/btn_login")
	public WebElement loginBttn;
	
	@FindBy(id = "io.cambi:id/input_username")
	public WebElement phoneTxt;
	
	@FindBy(xpath = "//android.widget.EditText[@text='Password']")
	public WebElement passwordTxt;
	
	@FindBy(xpath = "//android.widget.ImageButton[@content-desc='Navigate up']")
	public WebElement tapMenu;
	
	@FindBy(xpath = "//io.cambi:id/design_menu_item_text[@text='Nearby Stores']")
	public WebElement nearbyStores;
	
	
	
	public void loginAsClient(String phonenumber, String password) throws InterruptedException {
		
		Thread.sleep(10000);
		waitForElement(phoneTxt);
		phoneTxt.sendKeys(phonenumber);
		passwordTxt.sendKeys(password);	
		clickOn(eyeBttn);
		waitForElement(loginBttn);
		loginBttn.click();
	} 
	
	/*public void loginAsClient(String phonenumber, String password) throws InterruptedException
	{
		if (isElementPresent(passwordTxt)){
			inputText(passwordTxt, password);
			goBack();
			clickOn(eyeBttn);
		}
		else {
			inputText(phoneTxt, phonenumber);
			inputText(passwordFiled, password);
			goBack();
			clickOn(eyeBttn);
			if(isElementPresent(loginBttn)) {
				goBack();
				clickOn(loginBttn);
								
			}
		}
	}*/
	
	
	
	
	public void clickOnEyeBttn() {
		clickOn(eyeBttn);
	}
	
	public void clickOnMenubttn() throws InterruptedException 
	{
		waitForElement(tapMenu);
		tapMenu.click();
		Thread.sleep(3000);
	}
	
	
	public void verifyAndclickOnNearbyStores() 
	{
		Assert.assertTrue(isElementPresent(nearbyStores), "Element is not present on the page");
		clickOn(nearbyStores);
	}
	
	public void enterPhoneNumber(String entervalue) {
		waitForElement(phoneTxt);
		phoneTxt.sendKeys(entervalue);
	}
	
	public void enterPassword(String entervalue) {
		waitForElement(passwordTxt);
		passwordTxt.sendKeys(entervalue);
	}
	
	public void clickOnLoginBttn() {
		clickOn(loginBttn);
	}
	
}
