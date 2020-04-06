package com.cambi.testscript;

import org.testng.annotations.Test;
import org.testng.annotations.Listeners;
import com.cambi.selenium.framework.BaseTest;
import com.relevantcodes.extentreports.LogStatus;
import io.appium.java_client.service.local.AppiumDriverLocalService;


@Listeners({ ScreenshotUtility.class })
public class SignUpTest extends BaseTest {

	AppiumDriverLocalService service;

	/*
	 * This script file contains the sample test which include Below scenarios:
	 * Installing the Cambi A with apk file Open the app. Verify login scenarios
	 * by existing user.
	 */
	@Test // (enabled = false)
	public void SignUp() throws Exception {
		
		test = extent.startTest("TC_01: To verify the app launch & SignUp Flow");
		reportLog("To verify the app launch & SignUp Flow");

		test.log(LogStatus.INFO, "Verify SignUp page");
		signUpPage.verifySignUpBttn();

		test.log(LogStatus.INFO, "Back Arrow button");
		signUpPage.backBttn();
		
		test.log(LogStatus.INFO, "Click on Signup");
		signUpPage.verifySignUpBttn();
		
		test.log(LogStatus.INFO, "Enter Phone Number");
		signUpPage.enterphoneNumber();
		
		test.log(LogStatus.INFO, "Click on Terms and Conditions");
		signUpPage.tapOnTermsandConditions();
		
		test.log(LogStatus.INFO, "Click on OK button");
		signUpPage.tapOnOKBttn();
		
		test.log(LogStatus.INFO, "Click on Send Verification");
		signUpPage.sendVerificationToken();
		
		test.log(LogStatus.INFO, "Click On Resend Token");
		signUpPage.reSendToken();
		
		test.log(LogStatus.INFO, "Enter Token");
		signUpPage.enterTokenTextfield();
		
		test.log(LogStatus.INFO, "Back Arrow button");
		signUpPage.backBttn();
		
		test.log(LogStatus.INFO, "Click on Signup");
		signUpPage.verifySignUpBttn();
		
		test.log(LogStatus.INFO, "Enter Phone Number");
		signUpPage.enterphoneNumber();
		
		test.log(LogStatus.INFO, "Click on Send Verification");
		signUpPage.sendVerificationToken();
		
		test.log(LogStatus.INFO, "Enter Token");
		signUpPage.enterTokenTextfield();
		
		test.log(LogStatus.INFO, "Click on Verify Token");
		signUpPage.verifyToken();
		
		test.log(LogStatus.INFO, "Enter Password");
		signUpPage.enterPasswordfield();
		
		test.log(LogStatus.INFO, "Click on Continue SignUp");
		signUpPage.continueSignUpBttn();
		
		



		
		test.log(LogStatus.PASS, "TC_01: To verify the app launch & Login Flow");
	}
	
	@Test // (enabled = false)
	public void verifyMinimumCharacter() throws Exception {
		
		test = extent.startTest("TC_01: To Verify minimum character for the \"Password\" text field");
		reportLog("To Verify minimum character for the \"Password\" text field");

		test.log(LogStatus.INFO, "Verify SignUp page");
		signUpPage.verifySignUpBttn();

		test.log(LogStatus.INFO, "Enter Phone Number");
		signUpPage.enterphoneNumber();
		
		test.log(LogStatus.INFO, "Click on Send Verification");
		signUpPage.sendVerificationToken();
		
		test.log(LogStatus.INFO, "Enter Token");
		signUpPage.enterTokenTextfield();
		
		test.log(LogStatus.INFO, "Click on Verify Token");
		signUpPage.verifyToken();
		
		test.log(LogStatus.INFO, "Enter Password");
		signUpPage.enterpass("123456");
		
		test.log(LogStatus.INFO, "Click on Continue SignUp");
		signUpPage.continueSignUpBttn();
		
		
		test.log(LogStatus.PASS, "TC_01: To Verify minimum character for the \"Password\" text field");
	}
	
	@Test // (enabled = false)
	public void verifyDifferentTextCharacter() throws Exception {
		
		test = extent.startTest("TC_01: To Verify minimum character for the \"Password\" text field");
		reportLog("To Verify minimum character for the \"Password\" text field");

		test.log(LogStatus.INFO, "Verify SignUp page");
		signUpPage.verifySignUpBttn();

		test.log(LogStatus.INFO, "Enter Phone Number");
		signUpPage.enterphoneNumber();
		
		test.log(LogStatus.INFO, "Click on Send Verification");
		signUpPage.sendVerificationToken();
		
		test.log(LogStatus.INFO, "Enter Token");
		signUpPage.enterTokenTextfield();
		
		test.log(LogStatus.INFO, "Click on Verify Token");
		signUpPage.verifyToken();
		
		test.log(LogStatus.INFO, "Enter Password");
		signUpPage.enterPass("123456");
		
		test.log(LogStatus.INFO, "Enter Password");
		signUpPage.enterConnfirmpass("12345678");
		
		test.log(LogStatus.INFO, "Click on Continue SignUp");
		signUpPage.continueSignUpBttn();
		
		
		test.log(LogStatus.PASS, "TC_01: To Verify minimum character for the \"Password\" text field");
	}
}