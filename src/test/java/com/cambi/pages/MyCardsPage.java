package com.cambi.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.cambi.selenium.framework.BasePage;

public class MyCardsPage extends BasePage {

	public MyCardsPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(xpath = "//android.widget.TextView[@text='My Cards']")
	public WebElement myCardsPageTitle;
	
	@FindBy(xpath = "//android.widget.ImageButton[@content-desc='Navigate up']")
	public WebElement backBtn;
	
	@FindBy(xpath = "//android.widget.TextView[@content-desc='Search']")
	public WebElement searchBtn;
	
	@FindBy(xpath = "//android.widget.TextView[@text='Click on a card to see Transactions']")
	public WebElement clickOnCard;
	
	@FindBy(id = "io.cambi:id/card_layout")
    public WebElement cardLayout;
	
	@FindBy(id = "io.cambi:id/search_src_text")
    public WebElement enterStoreName;
	
	@FindBy(xpath = "//android.widget.TextView[@text='Siva Cafe']")
	public WebElement sivaCafe;
	
	@FindBy(id = "io.cambi:id/account_label")
    public WebElement accountLabel;
	
	@FindBy(id = "io.cambi:id/expiry_label")
    public WebElement expiryLabel;
	
	@FindBy(id = "io.cambi:id/account_number")
    public WebElement accountNumber;
	

	@FindBy(id = "io.cambi:id/expiry_date")
    public WebElement expiryDate;
	

	@FindBy(id = "io.cambi:id/merchantName")
    public WebElement merchantName;
	
	@FindBy(id = "io.cambi:id/timeStamp")
    public WebElement timeStamp;
	
	@FindBy(id = "io.cambi:id/iconValue")
    public WebElement iconValue;
	
	@FindBy(id = "io.cambi:id/amount")
    public WebElement ammount;
	
	public void verifymyCardsPageTilte() {
		Assert.assertTrue(isElementPresent(myCardsPageTitle), "my cards page is not appearing");
		Assert.assertTrue(isElementPresent(backBtn), "Back button is not appearing");
		Assert.assertTrue(isElementPresent(searchBtn), "Search button is not appearing");
		Assert.assertTrue(isElementPresent(clickOnCard), "Click on a card to see Transactions is not appearing");
		Assert.assertTrue(isElementPresent(cardLayout), "Card Layout is not appearing");
	
	}
	
	public void tapOnbackBttn() {
		clickOn(backBtn);
	
	}
	
	
	public void tapOnSearchBttn() {
		clickOn(searchBtn);
	
	}
	
	public void enterStoreName(String entervalue) {
		waitForElement(enterStoreName);
		enterStoreName.sendKeys(entervalue);
		Assert.assertTrue(isElementPresent(sivaCafe), "Siva Cafe is not appearing");
	}
	
	public void tapOnCard() {
		clickOn(cardLayout);
	
	}
	
	public void verifymyCardDetails() {
		Assert.assertTrue(isElementPresent(accountLabel), "Account Label is not appearing");
		Assert.assertTrue(isElementPresent(expiryLabel), "Expiry Label is not appearing");
		Assert.assertTrue(isElementPresent(accountNumber), "Account Number is not appearing");
		Assert.assertTrue(isElementPresent(expiryDate), "Expiry Date is not appearing");
		Assert.assertTrue(isElementPresent(merchantName), "Merchant is not appearing");
		Assert.assertTrue(isElementPresent(timeStamp), "Time Stamp is not appearing");
		Assert.assertTrue(isElementPresent(iconValue), "Icon Value is not appearing");
		Assert.assertTrue(isElementPresent(ammount), "Ammount is not appearing");
	
	}


}
