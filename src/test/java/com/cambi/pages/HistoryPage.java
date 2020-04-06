package com.cambi.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.cambi.selenium.framework.BasePage;
import com.graphbuilder.curve.Point;

import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;

public class HistoryPage extends BasePage{

	public HistoryPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(xpath = "//android.widget.TextView[@text='Transactions']")
	public WebElement transactionsTital;
	
	@FindBy(id = "io.cambi:id/toolbar_title")
    public WebElement transactionsPage;
	
	@FindBy(id = "io.cambi:id/timeStamp")
    public WebElement timeStamp;
	
	@FindBy(id = "io.cambi:id/merchantName")
    public WebElement merchantName;
	
	@FindBy(id = "io.cambi:id/amount")
    public WebElement ammount;
	
	@FindBy(xpath = "//android.widget.TextView[@text='1 Pts']")
	public WebElement demo;
	
	@FindBy(xpath = "//android.widget.TextView[@text='$50.00']")
	public WebElement demo2;
	
	
	public void verifyTransactionsPage() {
		Assert.assertTrue(isElementPresent(transactionsTital), "Transactions Tital is not appearing");
		Assert.assertTrue(isElementPresent(transactionsPage), "Transactions page is not appearing");
		clickOn(transactionsTital);
		clickOn(transactionsPage);
	
	}
	
	public void verifyTransactionsHistory() {
		Assert.assertTrue(isElementPresent(timeStamp), "Time Stamp is not appearing");
		Assert.assertTrue(isElementPresent(merchantName), "Merchant Name is not appearing");
		Assert.assertTrue(isElementPresent(ammount), "Ammount is not appearing");
	
	}

	public void scrollPage() throws InterruptedException {
		waitForElement(demo);
	
		
//		WebElement element = wd.findElement(By.id(“searchInputField”));
//		element.sendKeys(“S”);
		int x = demo.getLocation().getX();
		int y = demo2.getLocation().getY();

		System.out.println("X value: “+x+” Y value: "+y);
		Thread.sleep(2000);

		TouchAction action = new TouchAction((PerformsTouchActions) driver).tap(x+60, y+260).release();
		action.perform();

		//If need to enter few more data in to text field, again send it by using sendKeys method and perform the action
		//element.sendKeys(“S”);
		Thread.sleep(2000);
		action.perform();
	}
}
