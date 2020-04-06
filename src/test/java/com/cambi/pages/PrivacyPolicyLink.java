package com.cambi.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.cambi.selenium.framework.BasePage;

public class PrivacyPolicyLink extends BasePage {

	public PrivacyPolicyLink(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(xpath = "//android.widget.TextView[@text='Privacy Policy']")
	public WebElement privacyPolicylink;
	
	@FindBy(id = "io.cambi:id/terms")
	public WebElement privacyPolicyPage;
	
	@FindBy(xpath = "//android.widget.Button[@text='OK']")
	public WebElement okBttn;
	
	public void tapOnPrivacyPolicy() {
		Assert.assertTrue(isElementPresent(privacyPolicylink), "Privacy Policy Link is not appearing");
		clickOn(privacyPolicylink);
	
	}
	
	public void privacypolicyPage() {
		Assert.assertTrue(isElementPresent(privacyPolicyPage), "Privacy Policy page is not appearing");
		Assert.assertTrue(isElementPresent(okBttn), "Ok button is not appearing");
		clickOn(privacyPolicyPage);
		clickOn(okBttn);
	
	}
	
}
