package com.cambi.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import com.cambi.selenium.framework.BasePage;

public class NotificationPage extends BasePage {

	public NotificationPage(WebDriver driver) {
		super(driver);
		// TODO Auto-generated constructor stub
	}
	
	@FindBy(id = "io.cambi:id/ivNotification")
    public WebElement notificationIcon;
	
	@FindBy(xpath = "//android.widget.TextView[@text='Notifications']")
	public WebElement notificationText;
	
	@FindBy(xpath = "//android.widget.ImageButton[@content-desc='Navigate up']")
	public WebElement backB;
	
	@FindBy(xpath = "//android.widget.TextView[@text='TOTAL']")
	public WebElement totalText;
	
	@FindBy(id = "io.cambi:id/title")
    public WebElement swipeNotificationLeftSide;
	
	@FindBy(xpath = "//android.widget.LinearLayout[@index='3']")
	public WebElement delbtn;
	
	public void verifyNotificationIcon() {
		Assert.assertTrue(isElementPresent(notificationIcon), "Notification icon is not appearing");
		clickOn(notificationIcon);
		
	}
	
	public void vverifyNotificationPage() {
		Assert.assertTrue(isElementPresent(notificationText), "Notification Text icon is not appearing");
		Assert.assertTrue(isElementPresent(backB), "Notification icon is not appearing");
		Assert.assertTrue(isElementPresent(totalText), "Notification icon is not appearing");
		
	}
	
	/*public void swipeLeft() throws InterruptedException {
		int Xfirst = findElementbyXpath("").getLocation().getX();
		int Xfirstr=Xfirst + Xfirst;
		int Yfirst= findElementbyXpath("").getLocation().getY();
		driver.swipe(Xfirst + 300,Yfirst, Xfirst,Yfirst,5000);
	}
	*/


	
}