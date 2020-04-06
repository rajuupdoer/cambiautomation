package com.cambi.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.cambi.selenium.framework.BasePage;

public class SendGiftCardPage extends BasePage {

	public SendGiftCardPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(xpath = "//android.widget.Button[@text='Send']")
	public WebElement sendBttn;
	
	@FindBy(xpath = "//android.widget.EditText[@text='Mobile number']")
	public WebElement enterNumber;
	
	@FindBy(id = "android:id/button1")
    public WebElement sendBtn;
	
	@FindBy(xpath = "//android.widget.RadioButton[@text='$75']")
	public WebElement tapOn$75;
	
	@FindBy(xpath = "//android.widget.Button[@text='Buy Gift Card']")
	public WebElement buyGiftcardbttn;
	
	public void tapOnSendGiftCard()  {
		clickOn(buyGiftcardbttn);
		clickOn(tapOn$75);
		clickOn(sendBttn);
		
		}
	
	public void enterMobileNumber(String entervalue) {
		waitForElement(enterNumber);
		enterNumber.sendKeys(entervalue);
	}
	
	public void tapOnSendBttn()  {
		clickOn(sendBtn);
		
		}
}









