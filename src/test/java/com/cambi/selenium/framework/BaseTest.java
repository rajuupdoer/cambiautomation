package com.cambi.selenium.framework;
import org.testng.AssertJUnit;
import static org.testng.Assert.assertEquals;

import java.io.BufferedReader;
import java.io.File;
//import org.junit.*;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Calendar;
import java.util.concurrent.TimeUnit;

import org.apache.commons.exec.CommandLine;
import org.apache.commons.exec.DefaultExecutor;
import org.apache.commons.io.FileUtils;
import org.apache.poi.util.IOUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.cambi.pages.BuyGiftCardPage;
import com.cambi.pages.HamburgerMenu;
import com.cambi.pages.HomePage;
import com.cambi.pages.LoginPage;
import com.cambi.pages.LogoutPage;
import com.cambi.pages.MyCardsPage;
import com.cambi.pages.NearbyStoresPage;
import com.cambi.pages.NotificationPage;
import com.cambi.pages.PrivacyPolicyLink;
import com.cambi.pages.ProfilePage;
import com.cambi.pages.ResetPasswordPage;
import com.cambi.pages.SendGiftCardPage;
import com.cambi.pages.SettingsPage;
import com.cambi.pages.SignUpPage;
import com.cambi.pages.SignupForLoyaltyPage;
import com.cambi.pages.TermsAndConditionsLink;
import com.cambi.pages.HistoryPage;
//import com.cambi.pages.MarketStatsPage;
//import com.cambi.pages.PlaceOrderPage;
//import com.cambi.pages.VerifyChartPage;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
//import io.appium.java_client.TouchableElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;
//import io.appium.java_client.NetworkConnectionSetting;
import io.appium.java_client.android.Connection;
//import io.appium.java_client.android.AndroidDeviceActionShortcuts;
import io.appium.java_client.android.HasNetworkConnection;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.windows.WindowsDriver;
import io.appium.java_client.windows.WindowsElement;

public abstract class BaseTest {

	@SuppressWarnings("rawtypes")
	static
	WebDriver driver;
	//WindowsDriver driver1;
	private static WindowsElement CalculatorResult;
	public static ExtentReports extent;
	
	Process p;
	private static final Logger logger = LoggerFactory.getLogger(BaseTest.class);
	private static final String BREAK_LINE = "</br>";
	public static ExtentTest test;
	/*
	 * protected String userName; protected String password; protected String
	 * browserType; //private WebDriver driver; protected String applicationUrl;
	 * 
	 * // pages object initialization protected LoginPage loginPage; protected
	 * DashboardPage dashBoardPage;
	 * 
	 * enum DriverType { Firefox, IE, Chrome }
	 */

	protected LoginPage loginPage;
	protected HamburgerMenu hamburgerMenu;
	protected HomePage homePage;
	protected HistoryPage historyPage;
	protected MyCardsPage myCardsPage;
	protected NearbyStoresPage nearbyStoresPage;
	protected SettingsPage settingsPage;
	protected ProfilePage profilePage;
	protected BuyGiftCardPage buyGiftCardPage;
	protected SendGiftCardPage sendGiftCardPage;
	protected TermsAndConditionsLink termsAndConditionsLink;
	protected PrivacyPolicyLink privacyPolicyLink;
	protected LogoutPage logoutPage;
	protected SignupForLoyaltyPage signupForLoyaltyPage;
	protected SignUpPage signUpPage;
	protected NotificationPage notificationPage;
	protected ResetPasswordPage resetPasswordPage;
	protected ExcelReadWrite exceldata;
	protected String applicationUrl;
	public String phonenumber;
	public String password;
	
	/*
	 * public BaseTest(String browser) { this.browserType = browser; }
	 */

	public void appiumStart() throws IOException, InterruptedException {
		String nodePath = "C:/Program Files (x86)/nodejs/node.exe";
		// Set path of your appium.js file.
		String appiumJSPath = "C:/Program Files (x86)/Appium/node_modules/appium/bin/appium.js";
		String cmd = "\"" + nodePath + "\" \"" + appiumJSPath + "\" ";
		p = Runtime.getRuntime().exec(cmd);
		Thread.sleep(20000);
		if (p != null) {
			System.out.println("Appium server Is started now.");
		}
	}
	
	 
	/* public void startEmulator() 
    { 
	try
	        {  
	         // We are running "dir" and "ping" command on cmd 
       	        String emulatorPath = "C:\\Users\\win10\\AppData\\Local\\Android\\Sdk\\emulator";
	        	//Runtime.getRuntime().exec("cmd.exe /c start cmd.exe /k \"");
	        	//CommandLine cmdLine = CommandLine.parse("cmd /c c: && cd C:\\Users\\ss\\AppData\\Local\\Android\\Sdk\\emulator && emulator -avd Nexus_5_API_25");
	        	
	        	
//	        	DefaultExecutor executor = new DefaultExecutor();
//	        	int exitValue = executor.execute(cmdLine);
//	        	
	        	//Runtime.getRuntime().exec(cmdLine); 
	     	Runtime.getRuntime().exec("cmd.exe /c start cmd.exe /k \"");
	     	Thread.sleep(2000);
	      	Runtime.getRuntime().exec("cmd /c c: && cd C:\\Users\\win10\\AppData\\Local\\Android\\Sdk\\emulator && emulator -avd Pixel_API_28"); 
	        	
	        	
	       	Thread.sleep(50000);
	       } 
	      catch (Exception e) 
	       { 
	           System.out.println("HEY Buddy ! U r Doing Something Wrong "); 
	           e.printStackTrace(); 
	       } 
	    }
*/
	
	 public void startAppiumServer() 
	    { 
		 Runtime runtime = Runtime.getRuntime();
			try {
				runtime.exec("cmd.exe /c start cmd.exe /k \"appium -a 0.0.0.0 -p 4723 --session-override -dc \"{\"\"–full-reset\"\": \"\"true\"\"}\"\"");
				Thread.sleep(25000);
			} catch (IOException | InterruptedException e) {
				e.printStackTrace();
			}
	    } 
	 public void appiumStop() throws IOException {
		if (p != null) {
			p.destroy();
		}
		
	}
	@BeforeSuite
	public void before() {
		extent = new ExtentReports("target/surefire-reports/ExtentReport.html", true);
	//	startEmulator();
	//	startAppiumServer();
	}
	
	@SuppressWarnings("rawtypes")
	@BeforeMethod
	public void appiumSetUp() throws Exception {
		// Set the Desired Capabilities
		//appiumStart();
		Configuration propertyReader= new Configuration();
		String environment = propertyReader.readApplicationFile("env");
		
		//startEmulator();
		startAppiumServer(); 
		
		
		
		
		switch(environment) {
			case "Android":
				String apppath= propertyReader.readApplicationFile("apkfilepath");
				String devicename =propertyReader.readApplicationFile("DeviceName");
				String envName =propertyReader.readApplicationFile("platformName");
				String udid =propertyReader.readApplicationFile("UDID");
				String version =propertyReader.readApplicationFile("platformVersion");
				
				File app = new File(apppath);
				DesiredCapabilities capabilities = new DesiredCapabilities();
				capabilities.setCapability("platformName", "Android");
				capabilities.setCapability("deviceName", devicename);
				capabilities.setCapability("udid", udid);
				capabilities.setCapability("platformVersion", version);
				
				capabilities.setCapability("app", app.getAbsolutePath());
				capabilities.setCapability("autoGrantPermissions", true);
				
		
				capabilities.setCapability("appPackage", "io.cambi");
				capabilities.setCapability("appWaitActivity", "io.cambi.activities.*");
				

				
			
				

				driver = new AndroidDriver<MobileElement>(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
				
				 
				break;
				
			case "IOS":
				String iosapppath= propertyReader.readApplicationFile("apkfilepath");
				File iosapp = new File(iosapppath);
                capabilities = new DesiredCapabilities();
                capabilities.setCapability("platformName", "ios");
                capabilities.setCapability("deviceName", "=iPhone 5s");
                capabilities.setCapability("app", iosapp.getAbsolutePath());
                driver = new IOSDriver(new URL("http://0.0.0.0:4723/wd/hub"), capabilities);
                break;
                
			case "UWP":
				
                capabilities = new DesiredCapabilities();
               
                capabilities.setCapability("app", "ea4a2673-0ce4-4db7-8154-f38dc8a7102c_pr0kh8m2cm528!App");
                capabilities.setCapability("platformName", "Windows");
                capabilities.setCapability("deviceName", "WindowsPC");
                driver = new WindowsDriver(new URL("http://127.0.0.1:4723/"), capabilities);
                driver.manage().timeouts().implicitlyWait(8, TimeUnit.SECONDS);
                Thread.sleep(8000);
             
                break;
                
			case "chrome":
			System.setProperty("webdriver.chrome.driver",
					getPath() + "/src//test//resources//webdriver/chromedriver1.exe");
			driver = new ChromeDriver();
			driver.manage().window().maximize();

			// Delete cookies
			driver.manage().deleteAllCookies();

			// open application URL
			this.applicationUrl = Configuration.readApplicationFile("URL");
			getWebDriver().navigate().to(applicationUrl);
		}
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		Thread.sleep(4000);
		
		phonenumber= Configuration.readApplicationFile("PhoneNumber");
		password= Configuration.readApplicationFile("Password");
		loginPage = PageFactory.initElements(getWebDriver(), LoginPage.class);
		homePage = PageFactory.initElements(getWebDriver(), HomePage.class);
		hamburgerMenu = PageFactory.initElements(getWebDriver(), HamburgerMenu.class);
		historyPage = PageFactory.initElements(getWebDriver(), HistoryPage.class);
		myCardsPage = PageFactory.initElements(getWebDriver(), MyCardsPage.class);
		nearbyStoresPage = PageFactory.initElements(getWebDriver(), NearbyStoresPage.class);
		settingsPage = PageFactory.initElements(getWebDriver(), SettingsPage.class);
		profilePage = PageFactory.initElements(getWebDriver(), ProfilePage.class);
		buyGiftCardPage = PageFactory.initElements(getWebDriver(), BuyGiftCardPage.class);
		sendGiftCardPage = PageFactory.initElements(getWebDriver(), SendGiftCardPage.class);
		termsAndConditionsLink = PageFactory.initElements(getWebDriver(), TermsAndConditionsLink.class);
		privacyPolicyLink = PageFactory.initElements(getWebDriver(), PrivacyPolicyLink.class);
		logoutPage = PageFactory.initElements(getWebDriver(), LogoutPage.class);
		signupForLoyaltyPage = PageFactory.initElements(getWebDriver(), SignupForLoyaltyPage.class);
		signUpPage = PageFactory.initElements(getWebDriver(), SignUpPage.class);
		notificationPage = PageFactory.initElements(getWebDriver(), NotificationPage.class);
		resetPasswordPage = PageFactory.initElements(getWebDriver(), ResetPasswordPage.class);
		
		exceldata = PageFactory.initElements(getWebDriver(), ExcelReadWrite.class);
	}
//	@AfterMethod
//	public void getResult(ITestResult result){
//		 if(result.getStatus() == ITestResult.FAILURE){
//		 ((ExtentTest) logger).log(LogStatus.FAIL, "Test Case Failed is "+result.getName());
//		 ((ExtentTest) logger).log(LogStatus.FAIL, "Test Case Failed is "+result.getThrowable());//
//		 }else if(result.getStatus() == ITestResult.SKIP){
//		 ((ExtentTest) logger).log(LogStatus.SKIP, "Test Case Skipped is "+result.getName());
//		 }
//		 // ending test
//		 //endTest(logger) : It ends the current test and prepares to create HTML report
//		 extent.endTest((ExtentTest) logger);
//		 }
//		 @AfterTest
//		 public void endReport(){
//		 // writing everything to document
//		 //flush() - to write or update test information to your report. 
//		                extent.flush();
//		                //Call close() at the very end of your session to clear all resources. 
//		                //If any of your test ended abruptly causing any side-affects (not all logs sent to ExtentReports, information missing), this method will ensure that the test is still appended to the report with a warning message.
//		                //You should call close() only once, at the very end (in @AfterSuite for example) as it closes the underlying stream. 
//		                //Once this method is called, calling any Extent method will throw an error.
//		                //close() - To close all the operation
//		                extent.close();
//		                driver.quit();
//		    }
//	
//	
	
//	@AfterMethod
//	public void afterMainMethod(ITestResult result) throws IOException, InterruptedException {
//		if (result.getStatus() == ITestResult.FAILURE) {
//			captureScreenshot(result);
//	}
//		driver.quit();
//		extent.endTest(test);
//		extent.flush();
////		appiumStop();
//	}
	
	/*@AfterMethod
	public void afterMethod(ITestResult result) throws IOException, InterruptedException {

		driver.quit();
		extent.endTest(test);
		System.out.println("****************************************");
	}*/

 //abstract WebDriver toggleLocationServices();


	// @AfterClass
  //  public static void TearDown()
 //  {
        
 //  if (driver != null) {
	  //      	driver.quit();
	//        }
	     //   driver = null;
	 //   }
	public String readFile(String fileName) throws IOException {
	    BufferedReader br = new BufferedReader(new FileReader(fileName));
	    try {
	        StringBuilder sb = new StringBuilder();
	        String line = br.readLine();

	        while (line != null) {
	            sb.append(line);
	            sb.append("\n");
	            line = br.readLine();
	        }
	        return sb.toString();
	    } finally {
	        br.close();
	    }
	}
	
	@AfterMethod
	public void afterMainMethod(ITestResult result) throws Exception{
		if (result.getStatus() == ITestResult.FAILURE) {
			captureScreenshot(result);
			String methodname= result.getMethod().getMethodName();
			String classname= getClass().getName();
			System.out.println("CLASSNME: "+classname);
			String summary=	"ERROR IN: "+classname+ ":: "+methodname+ ":: "+result.getThrowable().getMessage().split("\\r?\\n")[0];
			System.out.println(summary);
			test.log(LogStatus.FAIL, summary);
		//	String issueDescription = "STEPS TO REPRODUCE: "+"\n" + readFile("log//testlog.txt")+ "\n"+ summary;
		//	System.out.println(issueDescription);
			
//			Jira jira = new Jira();
//			String IssueID = jira.createNewJiraIssue(summary, issueDescription);
//			System.out.println("Issue created");

			driver.quit();
			//test.log(LogStatus.FAIL, result.getThrowable().getMessage());
			extent.endTest(test);
			extent.flush();
		//	stopServer();
			//jira.addAttachment(IssueID);
		}
		else{

			driver.quit();
			//test.log(LogStatus.FAIL, result.getThrowable().getMessage());
			extent.endTest(test);
			extent.flush();
		//	stopServer();
			

		}	
	}
	
	public void stopServer() {
		Runtime runtime = Runtime.getRuntime();
		try {
			runtime.exec("taskkill /F /IM node.exe");
			runtime.exec("taskkill /F /IM cmd.exe");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	@AfterSuite
	public void tearDownSuite() {
		//reporter.endReport();
	//	driver.quit();
		stopServer();
		extent.flush();
		extent.close();
	}
	/*
	 * @AfterSuite public void tearDownSuite() { // reporter.endReport(); }
	 */

	public WebDriver getWebDriver() {
		return driver;
	}


	// Get absolute path
	public static String getPath() {
		String path = "";
		File file = new File("");
		String absolutePathOfFirstFile = file.getAbsolutePath();
		path = absolutePathOfFirstFile.replaceAll("\\\\+", "/");
		return path;
	}

	/*
	 * // Get absolute path public String getPathUpload() { String path = "";
	 * File file = new File(""); String absolutePathOfFirstFile =
	 * file.getAbsolutePath(); path = absolutePathOfFirstFile.replaceAll("/",
	 * "//"); return path; }
	 */

	/* capturing screenshot */
	public void captureScreenshot(ITestResult result) throws IOException, InterruptedException {
		try {
			String screenshotName = Utilities.getFileName(result.getName());
			File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
			String path = Utilities.getPath();
			String screen = path + "/screenshots/" + screenshotName + ".png";
			File screenshotLocation = new File(screen);
			FileUtils.copyFile(screenshot, screenshotLocation);
			Thread.sleep(2000);
			String image= test.addScreenCapture(screen);
			test.log(LogStatus.FAIL, screenshotName, image);

			Reporter.log(
					"<a href= '" + screen + "'target='_blank' ><img src='" + screen + "'>" + screenshotName + "</a>");
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
		}
	}

	public void reportLog(String message) {
		// test.log(LogStatus.INFO, message);
		message = BREAK_LINE + message;
		logger.info("Message: " + message);
		Reporter.log(message);
	}

	// Creating file name
	public String getFileName(String file) {
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal = Calendar.getInstance();
		String fileName = file + dateFormat.format(cal.getTime());
		return fileName;
	}
	
	@SuppressWarnings("rawtypes")
	public void pressDeviceBackButton() throws InterruptedException{
		
		((AndroidDriver) driver).pressKeyCode(AndroidKeyCode.BACK);
		Thread.sleep(1000);
	}	
	
	
	@SuppressWarnings("rawtypes")
	public void changeConnectionSetting(String connectionstring){
		
		switch(connectionstring){
		
		case "allconnectionEnabled":
			((AndroidDriver) driver).setConnection(Connection.ALL);
			AssertJUnit.assertEquals(Connection.ALL, ((AndroidDriver) driver).getConnection());
			break;
		
		
		case "wifianddatdisabled":			
			// turn off all (data and wi-fi)
			((AndroidDriver) driver).setConnection(Connection.NONE);
			AssertJUnit.assertEquals(Connection.NONE, ((AndroidDriver) driver).getConnection());
			break;
		
		case "airplanemodeOn":
			// turn on airplane
			((AndroidDriver) driver).setConnection(Connection.AIRPLANE);
			AssertJUnit.assertEquals(Connection.AIRPLANE, ((AndroidDriver) driver).getConnection());
			break;
		
		case "turnonData":
			// turn on data
			((AndroidDriver) driver).setConnection(Connection.DATA);
			AssertJUnit.assertEquals(Connection.DATA, ((AndroidDriver) driver).getConnection());
			break;
			
		case "turnonwifi":
			// tunr on wi-fi
			((AndroidDriver) driver).setConnection(Connection.WIFI);		
			AssertJUnit.assertEquals(Connection.WIFI, ((AndroidDriver) driver).getConnection());
			break;
	

		}
	}
	
//	public void toggleGPS(String strGPSEnabled, String strAutomationUser, String strLocation) {
//		
//		((AndroidDriver) driver).toggleLocationServices();
//		
//		
//		
		
//		Configuration propertyReader= new Configuration();
//		
//		if(strGPSEnabled.equals("True"))
//		{
//		try{Runtime.getRuntime().exec("/Users/"+strAutomationUser+"/Library/Android/sdk/platform-tools//adb shell settings put secure location_providers_allowed +network");}
//		catch(Exception e){}
//		try{Runtime.getRuntime().exec("/Users/"+strAutomationUser+"/Library/Android/sdk/platform-tools//adb shell settings put secure location_providers_allowed +gps");}
//		catch(Exception e){}
//		try{
//			Runtime.getRuntime().exec("/Users/"+strAutomationUser+"/Library/Android/sdk/platform-tools//adb -s "+propertyReader.readApplicationFile("DeviceName")+" emu geo fix "+strLocation);
//		}
//		catch(Exception e){}
//		try {Thread.sleep(2000);}
//		catch (Exception e) {
//			
//		}
//		}
//		else{
//		try{Runtime.getRuntime().exec("/Users/"+strAutomationUser+"/Library/Android/sdk/platform-tools//adb shell settings put secure location_providers_allowed -network");}
//		catch(Exception e){}
//		try{Runtime.getRuntime().exec("/Users/"+strAutomationUser+"/Library/Android/sdk/platform-tools//adb shell settings put secure location_providers_allowed -gps");}
//		catch(Exception e){}
//		}
	

}
