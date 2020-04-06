package com.cambi.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.cambi.selenium.framework.BasePage;

public class TermsAndConditionsLink extends BasePage {

	public TermsAndConditionsLink(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(xpath = "//android.widget.TextView[@text='Terms and Conditions']")
	public WebElement termsAndCondtionlink;
	
	@FindBy(id = "io.cambi:id/terms")
	public WebElement termsAndCondtionPage;
	
	@FindBy(xpath = "//android.widget.Button[@text='OK']")
	public WebElement okBttn;
	
	
	public void tapOnTermsAndConditions() {
		Assert.assertTrue(isElementPresent(termsAndCondtionlink), "Terms And Conditions is not appearing");
		clickOn(termsAndCondtionlink);
	
	}
	
	public void termsAndCondtionsPage() {
		Assert.assertTrue(isElementPresent(termsAndCondtionPage), "Terms And Conditions page is not appearing");
		Assert.assertTrue(isElementPresent(okBttn), "Ok button is not appearing");
		clickOn(termsAndCondtionPage);
		clickOn(okBttn);
	
	}
	
	
}