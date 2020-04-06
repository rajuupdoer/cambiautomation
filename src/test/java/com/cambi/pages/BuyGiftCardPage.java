package com.cambi.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.cambi.selenium.framework.BasePage;

public class BuyGiftCardPage extends BasePage{

	public BuyGiftCardPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(xpath = "//android.widget.Button[@text='Buy Gift Card']")
	public WebElement tapOnGiftCard;
	
	@FindBy(xpath = "//android.widget.RadioButton[@text='$100']")
	public WebElement tapOn$100;
	
	@FindBy(xpath = "//android.widget.Button[@text='Buy']")
	public WebElement tapOnBuy;
	
	
	public void tapOnBuyGiftCard()  {
		clickOn(tapOnGiftCard);
		clickOn(tapOn$100);
		clickOn(tapOnBuy);
		
	}

}
