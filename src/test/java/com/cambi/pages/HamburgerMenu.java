package com.cambi.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import com.cambi.selenium.framework.BasePage;

public class HamburgerMenu extends BasePage {

	public HamburgerMenu(WebDriver driver) {
		super(driver);
	}

	@FindBy(xpath = "//android.widget.ImageButton[@content-desc='Navigate up']")
	public WebElement tapHamburgerMenu;

	@FindBy(xpath = "//android.widget.CheckedTextView[@text='History']")
	public WebElement tapOnHistory;

	@FindBy(xpath = "//android.widget.CheckedTextView[@text='My Cards']")
	public WebElement myCardsTab;

	@FindBy(xpath = "//android.widget.CheckedTextView[@text='Nearby Stores']")
	public WebElement nearByStoresTab;

	@FindBy(xpath = "//android.widget.CheckedTextView[@text='Settings']")
	public WebElement settingsTab;

	@FindBy(xpath = "//android.widget.CheckedTextView[@text='Profile']")
	public WebElement profileTab;

	@FindBy(xpath = "//android.widget.CheckedTextView[@text='Logout']")
	public WebElement logoutTab;

	@FindBy(id = "io.cambi:id/terms_conditions")
	public WebElement termsConditionlink;

	@FindBy(id = "io.cambi:id/privacy_policy")
	public WebElement privacyPolicylink;

	@FindBy(id = "io.cambi:id/customer_support_email")
	public WebElement supportEmaillink;
	
	public void verifyAndTapOnProfileTab() {
		clickOn(tapHamburgerMenu);
		clickOn(profileTab);
	}
	
	public void verifyAndTapOnSettingsTab() {
		clickOn(tapHamburgerMenu);
		clickOn(settingsTab);
	}

	
	public void verifyAndTapOnNearByStoresTab() {
		clickOn(tapHamburgerMenu);
		clickOn(nearByStoresTab);
	}


	public void tapOnHamburgerMenu() throws InterruptedException {
		waitForElement(tapHamburgerMenu);
		tapHamburgerMenu.click();
	}

	public void verifyAndTapOnHistoryTab() throws InterruptedException {
		waitForElement(tapHamburgerMenu);
		clickOn(tapHamburgerMenu);
		clickOn(tapOnHistory);

	}

	public void verifyAndTapOnMyCardsTab() {
		clickOn(tapHamburgerMenu);
		clickOn(myCardsTab);

	}

	public void clickToGoBack() {
		goBack();
	}

}
