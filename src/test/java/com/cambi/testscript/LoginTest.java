package com.cambi.testscript;

import org.testng.annotations.Test;
import org.testng.annotations.Listeners;
import com.cambi.selenium.framework.BaseTest;
import com.relevantcodes.extentreports.LogStatus;
import io.appium.java_client.service.local.AppiumDriverLocalService;


@Listeners({ ScreenshotUtility.class })
public class LoginTest extends BaseTest {

	AppiumDriverLocalService service;

	/*
	 * This script file contains the sample test which include Below scenarios:
	 * Installing the Cambi A with apk file Open the app. Verify login scenarios
	 * by existing user.
	 */
	@Test // (enabled = false)
	public void LoginByPhoneNumber() throws Exception {

		test = extent.startTest("TC_18: To verify and validate whether alignment of the login page and input fields are in proper manner");
		reportLog("To verify and validate whether alignment of the login page and input fields are in proper manner");

		test.log(LogStatus.INFO, "Enter phone number and password");
		loginPage.loginAsClient(phonenumber, password);
		
		test.log(LogStatus.INFO, "Verify home page title");
		homePage.verifyHomePageTitle();

		test.log(LogStatus.PASS, "TC_18: To verify and validate whether alignment of the login page and input fields are in proper manner");
	}
	
	@Test // (enabled = false)
	public void LoginWithInvalidPhoneNumber() throws Exception {

		test = extent.startTest("TC_19: To Verify login with invalid phone number and with valid password");
		reportLog("To Verify login with invalid phone number and with valid password");
		
		test.log(LogStatus.INFO, "Enter phone number and password");
		loginPage.enterPhoneNumber("949484");
		
		test.log(LogStatus.INFO, "Enter phone number and password");
		loginPage.enterPassword("123456789");
		
		test.log(LogStatus.INFO, "Verify home page title");
		loginPage.clickOnLoginBttn();

		test.log(LogStatus.PASS, "TC_19: To Verify login with invalid phone number and with valid password");
	}
	
	@Test // (enabled = false)
	public void verifyInvalidNumberResetPassword() throws Exception {

		test = extent.startTest("TC_22: To Verify invalid phone number for Reset Password functionality");
		reportLog("To Verify invalid phone number for Reset Password functionality");
		
		test.log(LogStatus.INFO, "Click on Reset Password");
		resetPasswordPage.resetPassword();
		
		test.log(LogStatus.INFO, "Enter phone number and password");
		resetPasswordPage.enterPhoneNumber();
		
		test.log(LogStatus.INFO, "Click on Verify Number");
		resetPasswordPage.verifyPhoneNumber();

		test.log(LogStatus.PASS, "TC_22: To Verify invalid phone number for Reset Password functionality");
	}
	
	
	@Test(enabled = true, priority = 1) //retryAnalyzer = com.cambi.selenium.framework.RetryAnalyzer.class)
	public void verifyHomePageAndElements() throws Exception {

		test = extent.startTest("TC_26: To Verify tap on the Hamburger menu");
		reportLog("To Verify application just after login to the Cambi application");
		
		test.log(LogStatus.INFO, "Enter phone number and password and do Login");
		loginPage.loginAsClient(phonenumber, password);
		
		
		test.log(LogStatus.INFO, "Verify home page title");
		homePage.verifyHomePageTitle();
		
		test.log(LogStatus.INFO, "Verify Notification icon on home page");
		homePage.verifyNotificationIcon();
		
		test.log(LogStatus.INFO, "Verify Find store near me button on home page");
		homePage.verifyFindStoreNearMeBttn();
		
		test.log(LogStatus.INFO, "Verify Three dot menu button on home page");
		homePage.verifyThreeDotMenu();
		
		test.log(LogStatus.INFO, "Verify and tap on history tab and verify transactions page");
		hamburgerMenu.verifyAndTapOnHistoryTab();
		historyPage.verifyTransactionsPage();
		hamburgerMenu.clickToGoBack();
			
		test.log(LogStatus.INFO, "Verify and tap on My Cards tab and verify My cards page");
		hamburgerMenu.verifyAndTapOnMyCardsTab();
		myCardsPage.verifymyCardsPageTilte();
		hamburgerMenu.clickToGoBack();
		
	    test.log(LogStatus.INFO, "Verify and tap on Nearby stores tab and verify Nearby stores page");
		hamburgerMenu.verifyAndTapOnNearByStoresTab();
		nearbyStoresPage.verifyNearByStoresPageTilte();
		hamburgerMenu.clickToGoBack();
				
		test.log(LogStatus.INFO, "Verify and tap on settings tab and verify settings page");
		hamburgerMenu.verifyAndTapOnSettingsTab();
		settingsPage.verifySettingsPageTilte();
		hamburgerMenu.clickToGoBack();
		
		test.log(LogStatus.INFO, "Verify and tap on profile tab and verify profile page");
		hamburgerMenu.verifyAndTapOnProfileTab();
		profilePage.verifyProfilePageTilte();
		hamburgerMenu.clickToGoBack();


		test.log(LogStatus.PASS, "TC_26: To Verify tap on the Hamburger menu");
	}
	
	
	@Test // (enabled = false)
	public void verifyStoreSearchFeature() throws Exception {

		test = extent.startTest("TC_27: To verify the Store search feature");
		reportLog("To verify the Store search feature");

		test.log(LogStatus.INFO, "Enter phone number and password and do Login");
		loginPage.loginAsClient(phonenumber, password);
		
		test.log(LogStatus.INFO, "Verify home page title");
		homePage.verifyHomePageTitle();
		
		
		test.log(LogStatus.INFO, "Click on Login");
		hamburgerMenu.tapOnHamburgerMenu();
		
		test.log(LogStatus.INFO, "Tap on NearBy store");
		nearbyStoresPage.verifyNearByStoresPageTilte();
		
		test.log(LogStatus.INFO, "Search NearBy store");
		nearbyStoresPage.verifySearchNearByStore();
		
		test.log(LogStatus.INFO, "Enter NearBy store Name");
		nearbyStoresPage.searchStore("Bawarchi Biryani Point");
		
		test.log(LogStatus.INFO, "Verify Store Result");
		nearbyStoresPage.verifyStoreResult();
		
		test.log(LogStatus.INFO, "Searched store should disappear");
		nearbyStoresPage.verifytapOnCrossBtn();
		
		test.log(LogStatus.INFO, "All list of stores should be showing");
		nearbyStoresPage.verifyAllListStore();


		test.log(LogStatus.PASS, "TC_27: To verify the Store search feature");
		
		
		
	}
	
	@Test // (enabled = false)
	public void buyGiftCard() throws Exception {

		test = extent.startTest("TC_32: To Verify buy gift card functionality");
		reportLog("To Verify buy gift card functionality");

		test.log(LogStatus.INFO, "Enter phone number and password and do Login");
		loginPage.loginAsClient(phonenumber, password);
		
		test.log(LogStatus.INFO, "Verify home page title");
		homePage.verifyHomePageTitle();
		
		
		test.log(LogStatus.INFO, "Click on Login");
		hamburgerMenu.tapOnHamburgerMenu();
		
		test.log(LogStatus.INFO, "Tap on NearBy store");
		nearbyStoresPage.verifyNearByStoresPageTilte();
		
		test.log(LogStatus.INFO, "Search NearBy store");
		nearbyStoresPage.verifySearchNearByStore();
		
		test.log(LogStatus.INFO, "Enter NearBy store Name");
		nearbyStoresPage.searchStore("Bawarchi Biryani Point");
		
		test.log(LogStatus.INFO, "Tap on buy Gift Card");
		buyGiftCardPage.tapOnBuyGiftCard();
		
		

		test.log(LogStatus.PASS, "TC_32: To Verify buy gift card functionality");
		
		
		
	}
	
	@Test // (enabled = false)
	public void sendGiftCard() throws Exception {

		test = extent.startTest("TC_34: To Verify send gift card functionality");
		reportLog("To Verify send gift card functionality");

		test.log(LogStatus.INFO, "Enter phone number and password and do Login");
		loginPage.loginAsClient(phonenumber, password);
		
		test.log(LogStatus.INFO, "Verify home page title");
		homePage.verifyHomePageTitle();
		
		
		test.log(LogStatus.INFO, "Click on Login");
		hamburgerMenu.tapOnHamburgerMenu();
		
		test.log(LogStatus.INFO, "Tap on NearBy store");
		nearbyStoresPage.verifyNearByStoresPageTilte();
		
		test.log(LogStatus.INFO, "Search NearBy store");
		nearbyStoresPage.verifySearchNearByStore();
		
		test.log(LogStatus.INFO, "Enter NearBy store Name");
		nearbyStoresPage.searchStore("Bawarchi Biryani Point");
		
		test.log(LogStatus.INFO, "Tap on Send Gift Card");
		sendGiftCardPage.tapOnSendGiftCard();
		
		test.log(LogStatus.INFO, "Enter Mobile Number");
		sendGiftCardPage.enterMobileNumber("8299003613");
		
		test.log(LogStatus.INFO, "Tap on Send button");
		sendGiftCardPage.tapOnSendBttn();
		
		
		test.log(LogStatus.PASS, "TC_34: Verify send gift card functionality");
		
		
		
	}

	@Test // (enabled = false)
	public void settings() throws Exception {

		test = extent.startTest("TC_43: To Verify 'Location-based Notifications' switch button when it is OFF/ON");
		reportLog("To Verify 'Location-based Notifications' switch button when it is OFF/ON");

		test.log(LogStatus.INFO, "Enter phone number and password and do Login");
		loginPage.loginAsClient(phonenumber, password);
		
		test.log(LogStatus.INFO, "Verify home page title");
		homePage.verifyHomePageTitle();
		
		test.log(LogStatus.INFO, "Click on Login");
		hamburgerMenu.tapOnHamburgerMenu();
		
		test.log(LogStatus.INFO, "Click on Settings");
		settingsPage.verifySettingsPageTilte();
		
		test.log(LogStatus.INFO, "Click on Locataion based Notification");
		settingsPage.verifyLocationBasednotification();
		
	
		test.log(LogStatus.PASS, "TC_43: To Verify 'Location-based Notifications' switch button when it is OFF/ON");
		
		
		
	}
	
	@Test // (enabled = false)
	public void verifyprofilepage() throws Exception {

		test = extent.startTest("TC_44: To Verify Profile page");
		reportLog("To Verify Profile page");

		test.log(LogStatus.INFO, "Enter phone number and password and do Login");
		loginPage.loginAsClient(phonenumber, password);
		
		test.log(LogStatus.INFO, "Click on Hamburger Menu");
		hamburgerMenu.tapOnHamburgerMenu();
		
		test.log(LogStatus.INFO, "Click on Profile");
		profilePage.verifyProfilePageTilte();
		
		test.log(LogStatus.INFO, "Verify Element Present in Profile page");
		profilePage.verifyElementPresent();
		
		test.log(LogStatus.INFO, "Click on Hamburger Menu");
		hamburgerMenu.tapOnHamburgerMenu();
		
		test.log(LogStatus.INFO, "Click on Profile");
		profilePage.verifyProfilePageTilte();
		profilePage.verifyElementPresent();
		
		test.log(LogStatus.PASS, "TC_44: To Verify Profile page");
		
		
		
	}
	
	@Test // (enabled = false)
	public void verifyEditProfileElements() throws Exception {

		test = extent.startTest("TC_45: To Verify edit profile elements");
		reportLog("To Verify edit profile elements");

		test.log(LogStatus.INFO, "Enter phone number and password and do Login");
		loginPage.loginAsClient(phonenumber, password);
		
		test.log(LogStatus.INFO, "Click on Hamburger Menu");
		hamburgerMenu.tapOnHamburgerMenu();
		
		test.log(LogStatus.INFO, "Click on Profile");
		profilePage.verifyProfilePageTilte();
		
		test.log(LogStatus.INFO, "Click on Profile");
		profilePage.tapOnEditBttn();
		
		test.log(LogStatus.INFO, "Click on Edit Profile");
		profilePage.verifyEditProfileField();
		
		test.log(LogStatus.INFO, "Click on Change Password");
		profilePage.verifyTapOnChangePassword();
		
		test.log(LogStatus.INFO, "Click on Profile");
		profilePage.verifyChangePasswordField();
		
	
		test.log(LogStatus.PASS, "TC_45: To Verify edit profile elements");
		
		
		
	}
	
	@Test // (enabled = false)
	public void editProfileFunctionality() throws Exception {

		test = extent.startTest("TC_46: To Verify edit profile functionality");
		reportLog("To Verify edit profile functionality");

		test.log(LogStatus.INFO, "Enter phone number and password and do Login");
		loginPage.loginAsClient(phonenumber, password);
		
		test.log(LogStatus.INFO, "Click on Hamburger Menu");
		hamburgerMenu.tapOnHamburgerMenu();
		
		test.log(LogStatus.INFO, "Click on Profile");
		profilePage.verifyProfilePageTilte();
		
		test.log(LogStatus.INFO, "Click on Profile");
		profilePage.tapOnEditBttn();
		
		test.log(LogStatus.INFO, "Enter Update Value");
		profilePage.enterUpdatedValue();
		
		test.log(LogStatus.INFO, "Click on Cancel");
		profilePage.clickOnCancelBttn();
		
		test.log(LogStatus.INFO, "Click on Profile");
		profilePage.tapOnEditBttn();
		
		test.log(LogStatus.INFO, "Enter Update Value");
		profilePage.enterUpdatedValue();
		
		test.log(LogStatus.INFO, "Click on update");
		profilePage.clickOnUpdateBttn();
		
		
		
	
		test.log(LogStatus.PASS, "TC_46: Verify edit profile functionality");
		
		
		
	}
	
	@Test // (enabled = false)
	public void changePasswordFunctionality() throws Exception {

		test = extent.startTest("TC_47: To Verify Change Password functionality on Profile page");
		reportLog("Verify Change Password functionality on Profile page");

		test.log(LogStatus.INFO, "Enter phone number and password and do Login");
		loginPage.loginAsClient(phonenumber, password);
		
		test.log(LogStatus.INFO, "Click on Hamburger Menu");
		hamburgerMenu.tapOnHamburgerMenu();
		
		test.log(LogStatus.INFO, "Click on Profile");
		profilePage.verifyProfilePageTilte();
		
		test.log(LogStatus.INFO, "Click on Change Password");
		profilePage.verifyTapOnChangePassword();
		
		test.log(LogStatus.INFO, "Enter Update Password Field");
		profilePage.enterUpdatePasswordfield();
		
		test.log(LogStatus.INFO, "Click on Cancel");
		profilePage.clickOnCancelBttn();
		
		test.log(LogStatus.INFO, "Click on Change Password");
		profilePage.verifyTapOnChangePassword();
		
		test.log(LogStatus.INFO, "Enter Update Password");
		profilePage.enterUpdatePasswordfield();
		
		test.log(LogStatus.INFO, "Click on update");
		profilePage.clickOnUpdateBttn();
		
		
		test.log(LogStatus.PASS, "TC_47: To Verify Change Password functionality on Profile page");
		
		
		
	}
	
	@Test // (enabled = false)
	public void verifyTermsAndCondition() throws Exception {

		test = extent.startTest("TC_48: To Verify \"Terms and Condition\" link working");
		reportLog("To Verify \"Terms and Condition\" link working");

		test.log(LogStatus.INFO, "Enter phone number and password and do Login");
		loginPage.loginAsClient(phonenumber, password);
		
		test.log(LogStatus.INFO, "Click on Hamburger Menu");
		hamburgerMenu.tapOnHamburgerMenu();
		
		test.log(LogStatus.INFO, "Click on Terms And Conditions Link");
		termsAndConditionsLink.tapOnTermsAndConditions();
		
		test.log(LogStatus.INFO, "Open Terms And Conditions Link page");
		termsAndConditionsLink.termsAndCondtionsPage();
		
		test.log(LogStatus.PASS, "TC_48: To Verify \"Terms and Condition\" link working");
		
		
		
	}
	
	@Test // (enabled = false)
	public void verifyPrivacyPolicy() throws Exception {

		test = extent.startTest("TC_49: To Verify \"Privacy Policy\" link working");
		reportLog("To Verify \"Privacy Policy\" link working");

		test.log(LogStatus.INFO, "Enter phone number and password and do Login");
		loginPage.loginAsClient(phonenumber, password);
		
		test.log(LogStatus.INFO, "Click on Hamburger Menu");
		hamburgerMenu.tapOnHamburgerMenu();
		
		test.log(LogStatus.INFO, "Click on Privacy Policy Link");
		privacyPolicyLink.tapOnPrivacyPolicy();
		
		test.log(LogStatus.INFO, "Open Privacy Policy Link page");
		privacyPolicyLink.privacypolicyPage();
		
		test.log(LogStatus.PASS, "TC_49: Verify \"Privacy Policy\" link working");
		
		
		
	}
	
	@Test // (enabled = false)
	public void verifyLogOut() throws Exception {

		test = extent.startTest("TC_50: To Verify Log Out is working");
		reportLog("To Verify Log Out is working");

		test.log(LogStatus.INFO, "Enter phone number and password and do Login");
		loginPage.loginAsClient(phonenumber, password);
		
		test.log(LogStatus.INFO, "Click on Hamburger Menu");
		hamburgerMenu.tapOnHamburgerMenu();
		
		test.log(LogStatus.INFO, "Click on Logout button");
		logoutPage.logout();
		
		
		test.log(LogStatus.PASS, "TC_50: To Verify Log Out is working");
		
		
		
	}
	
	@Test // (enabled = false)
	public void verifySignupForLoyalty() throws Exception {

		test = extent.startTest("TC_51: To Verify Signup for Loyalty functionality");
		reportLog("Verify Signup for Loyalty functionality");

		test.log(LogStatus.INFO, "Enter phone number and password and do Login");
		loginPage.loginAsClient(phonenumber, password);
		
		test.log(LogStatus.INFO, "Click on Hamburger Menu");
		hamburgerMenu.tapOnHamburgerMenu();
		
		test.log(LogStatus.INFO, "Tap on NearBy store");
		nearbyStoresPage.verifyNearByStoresPageTilte();
		
		test.log(LogStatus.INFO, "Search NearBy store");
		nearbyStoresPage.verifySearchNearByStore();
		
		test.log(LogStatus.INFO, "Enter NearBy store Name");
		nearbyStoresPage.searchStore("Siva Cafe");
		
		test.log(LogStatus.INFO, "Click on Signup For Loyalty");
		signupForLoyaltyPage.tapOnSignupForLoyalty();
		
		test.log(LogStatus.INFO, "Click on Arrow");
		signupForLoyaltyPage.tapOnArrowBttn();
		
		test.log(LogStatus.PASS, "TC_51: Verify Signup for Loyalty functionality");
		
		
		
	}
	
	@Test // (enabled = false)
	public void verifyStoreAlreadyRegisteredForLoyaltyProgram() throws Exception {

		test = extent.startTest("TC_53: To Verify store already registered for loyalty program");
		reportLog("To Verify store already registered for loyalty program");

		test.log(LogStatus.INFO, "Enter phone number and password and do Login");
		loginPage.loginAsClient(phonenumber, password);
		
		test.log(LogStatus.INFO, "Click on Hamburger Menu");
		hamburgerMenu.tapOnHamburgerMenu();
		
		test.log(LogStatus.INFO, "Tap on NearBy store");
		nearbyStoresPage.verifyNearByStoresPageTilte();
		
		test.log(LogStatus.INFO, "Search NearBy store");
		nearbyStoresPage.verifySearchNearByStore();
		
		test.log(LogStatus.INFO, "Enter NearBy store Name");
		nearbyStoresPage.searchStore("Siva Cafe");
		
		test.log(LogStatus.INFO, "Signup For Loyalty button should be disabled");
		signupForLoyaltyPage.verifySignupForLoyaltyBttn();
		
		
		test.log(LogStatus.PASS, "TC_53: To Verify store already registered for loyalty program");
		
		
		
	}
	
	@Test // (enabled = false)
	public void verifyHistoryPage() throws Exception {

		test = extent.startTest("TC_56: To Verify History option under hamburger menu");
		reportLog("To Verify History option under hamburger menu");

		test.log(LogStatus.INFO, "Enter phone number and password and do Login");
		loginPage.loginAsClient(phonenumber, password);
		
		test.log(LogStatus.INFO, "Verify home page title");
		homePage.verifyHomePageTitle();
		
		test.log(LogStatus.INFO, "Click on History");
		hamburgerMenu.verifyAndTapOnHistoryTab();
		
		test.log(LogStatus.INFO, "Verify Transactions Page");
		historyPage.verifyTransactionsPage();
		
		test.log(LogStatus.PASS, "TC_44: To Verify History option under hamburger menu");
		
		
		
	}
	
	@Test // (enabled = false)
	public void verifyHistoryFunctionality() throws Exception {

		test = extent.startTest("TC_57: To Verify History functionality");
		reportLog("To Verify History functionality");

		test.log(LogStatus.INFO, "Enter phone number and password and do Login");
		loginPage.loginAsClient(phonenumber, password);
		
		test.log(LogStatus.INFO, "Click on History");
		hamburgerMenu.verifyAndTapOnHistoryTab();
		
		
		
		test.log(LogStatus.PASS, "TC_44: To Verify History functionality");
		
		
		
	}
	
	@Test // (enabled = false)
	public void verifyTransactionsHistory() throws Exception {

		test = extent.startTest("TC_58: To Verify transactions history with date and points");
		reportLog("To Verify transactions history with date and points");

		test.log(LogStatus.INFO, "Enter phone number and password and do Login");
		loginPage.loginAsClient(phonenumber, password);
		
		test.log(LogStatus.INFO, "Click on History");
		hamburgerMenu.verifyAndTapOnHistoryTab();
		
		test.log(LogStatus.INFO, "Verify Transactions Page");
		historyPage.verifyTransactionsPage();
		
		test.log(LogStatus.INFO, "Verify transactions history with date and points");
		historyPage.verifyTransactionsHistory();
		
		test.log(LogStatus.PASS, "TC_58: To Verify transactions history with date and points");
		
		
		
	}
	
	@Test // (enabled = false)
	public void pageScrollFunctionalityy() throws Exception {

		test = extent.startTest("TC_59: To Verify transactions history page scroll functionality");
		reportLog("To Verify transactions history page scroll functionality");

		test.log(LogStatus.INFO, "Enter phone number and password and do Login");
		loginPage.loginAsClient(phonenumber, password);
		
		test.log(LogStatus.INFO, "Click on History");
		hamburgerMenu.verifyAndTapOnHistoryTab();
		
		test.log(LogStatus.INFO, "Verify Transactions Page");
		historyPage.verifyTransactionsPage();
		
		test.log(LogStatus.INFO, "Verify Transactions History");
		historyPage.verifyTransactionsHistory();
		
		test.log(LogStatus.INFO, "Click on HamburgerMenu");
		historyPage.scrollPage();
		
		test.log(LogStatus.PASS, "TC_48: To Verify transactions history page scroll functionality");
		
		
		
	}
	
	@Test // (enabled = false)
	public void verifyNotificationicon() throws Exception {

		test = extent.startTest("TC_60: To Verify notification icon on home screen");
		reportLog("To Verify notification icon on home screen");

		test.log(LogStatus.INFO, "Enter phone number and password and do Login");
		loginPage.loginAsClient(phonenumber, password);
		
		test.log(LogStatus.INFO, "Verify Notification icon present in home page");
		homePage.verifyNotificationIcon();
		
		test.log(LogStatus.PASS, "TC_60: To Verify notification icon on home screen");
		
		
		
	}
	
	@Test // (enabled = false)
	public void verifyTapOnNotificationicon() throws Exception {

		test = extent.startTest("TC_61: To Verify tap on the Notification icon on home screen");
		reportLog("To Verify tap on the Notification icon on home screen, ");

		test.log(LogStatus.INFO, "Enter phone number and password and do Login");
		loginPage.loginAsClient(phonenumber, password);
		
		test.log(LogStatus.INFO, "Verify Notification icon");
		notificationPage.verifyNotificationIcon();
		
		test.log(LogStatus.INFO, "Verify Notification Page");
		notificationPage.vverifyNotificationPage();
		
		
		
		test.log(LogStatus.PASS, "TC_61: To Verify tap on the Notification icon on home screen");
		
		
		
	}
	
	@Test // (enabled = false)
	public void verifyMyCardPage() throws Exception {

		test = extent.startTest("TC_66: To Verify My Card page");
		reportLog("To Verify My Card page, ");

		test.log(LogStatus.INFO, "Enter phone number and password and do Login");
		loginPage.loginAsClient(phonenumber, password);
		
		test.log(LogStatus.INFO, "Click on Hamburger Menu");
		hamburgerMenu.tapOnHamburgerMenu();
		
		test.log(LogStatus.INFO, "Click on My Card");
		hamburgerMenu.verifyAndTapOnMyCardsTab();
		
		
		test.log(LogStatus.INFO, "Verify My Card Page");
		myCardsPage.verifymyCardsPageTilte();
		
		
		
		test.log(LogStatus.PASS, "TC_66: To Verify My Card page");
		
		
		
	}
	
	@Test // (enabled = false)
	public void verifyBackMyCardPage() throws Exception {

		test = extent.startTest("TC_67: To Verify Back button and search functionality on My Cards page");
		reportLog("To Verify Back button and search functionality on My Cards page");

		test.log(LogStatus.INFO, "Enter phone number and password and do Login");
		loginPage.loginAsClient(phonenumber, password);
		
		test.log(LogStatus.INFO, "Click on Hamburger Menu");
		hamburgerMenu.tapOnHamburgerMenu();
		
		test.log(LogStatus.INFO, "Click on My Card");
		hamburgerMenu.verifyAndTapOnMyCardsTab();
		
		test.log(LogStatus.INFO, "Click on Back button");
		myCardsPage.tapOnbackBttn();
		
		test.log(LogStatus.INFO, "Click on Hamburger Menu");
		hamburgerMenu.tapOnHamburgerMenu();
		
		test.log(LogStatus.INFO, "Click on My Card");
		hamburgerMenu.verifyAndTapOnMyCardsTab();
		
		test.log(LogStatus.INFO, "Click on Search icon button");
		myCardsPage.tapOnSearchBttn();
		
		test.log(LogStatus.INFO, "Enter Store Name");
		myCardsPage.enterStoreName("Siva Cafe");
		
		test.log(LogStatus.PASS, "TC_67: To Verify Back button and search functionality on My Cards page");
		
		
		
	}
	
	@Test // (enabled = false)
	public void verifyScrollFunctionality() throws Exception {

		test = extent.startTest("TC_68: To Verify scroll functionality on My Cards page");
		reportLog("To Verify scroll functionality on My Cards page, ");

		test.log(LogStatus.INFO, "Enter phone number and password and do Login");
		loginPage.loginAsClient(phonenumber, password);
		
		test.log(LogStatus.INFO, "Click on Hamburger Menu");
		hamburgerMenu.tapOnHamburgerMenu();
		
		test.log(LogStatus.INFO, "Click on My Card");
		hamburgerMenu.verifyAndTapOnMyCardsTab();
		
		
		
		test.log(LogStatus.PASS, "TC_68: To Verify scroll functionality on My Cards page");
		
		
		
	}
	
	@Test // (enabled = false)
	public void verifyCardDetailsBox() throws Exception {

		test = extent.startTest("TC_70: To Verify cards details box");
		reportLog("To Verify cards details box");

		test.log(LogStatus.INFO, "Enter phone number and password and do Login");
		loginPage.loginAsClient(phonenumber, password);
		
		test.log(LogStatus.INFO, "Click on Hamburger Menu");
		hamburgerMenu.tapOnHamburgerMenu();
		
		test.log(LogStatus.INFO, "Click on My Card");
		hamburgerMenu.verifyAndTapOnMyCardsTab();
		
		test.log(LogStatus.INFO, "Click on Card");
		myCardsPage.tapOnCard();
		
		test.log(LogStatus.INFO, "Verify cards details box");
		myCardsPage.verifymyCardDetails();
		
		
		
		test.log(LogStatus.PASS, "TC_70: To Verify cards details box");
		
		
		
	}


	
	
	


}