package com.cambi.selenium.framework;

import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.sql.Connection;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.Point;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.Augmenter;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import org.testng.Reporter;
import java.sql.ResultSet;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidKeyCode;


public abstract class BasePage {
	private static final Logger logger = LoggerFactory.getLogger(BasePage.class);

	public static WebDriver driver;

	protected String title;
	protected static final int DEFAULT_WAIT_4_ELEMENT = 30;
	protected static final int DEFAULT_WAIT_4_PAGE = 30;
	protected static final int DEFAULT_WAIT_MAXTIME = 40;
	protected static WebDriverWait ajaxWait;
	protected long timeout = 30;
	protected long longTimeout = 1000;

	/*
	 * @Inject
	 * 
	 * @Named("framework.implicitTimeout") protected long timeout;
	 */

	public BasePage(WebDriver driver) {
		this.driver = driver;
	}
	
	/*
	 * Get current date
	 */
	public String getCurrentDate(String format) {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern(format);  
		   LocalDateTime now = LocalDateTime.now(); 
		   String date= dtf.format(now);
		   System.out.println("Today date is-----" +date);
		return date;  
	}
	
	public int getOnlyDay() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");  
		   LocalDateTime now = LocalDateTime.now(); 
		   String date= dtf.format(now);
		   String d = date.substring(Math.max(date.length() - 2, 0));
		   int onlyDay = Integer.parseInt(d);	
		   System.out.println("Today date is-----" +onlyDay);
		return onlyDay;  
	}
	
	/*
	 * Click action performed and then wait
	 */
	public void waitAndClick(WebElement element) {
		logger.info("Wait and Click");
		waitForElement(element);
		element.click();
	}

	public void clickOn(WebElement element) {
		logger.info("click");
		element.click();
	}
	
	public void clickOn(MobileElement element) {
		logger.info("click");
		element.click();
	}

	/*
	 * Click on element by webelement
	 */
	public void javascriptButtonClick(WebElement webElement) {
		//waitForElement(webElement);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", webElement);
	}

	/*
	 * Click on element by string locator
	 */
	public void waitAndClick(String locator) {
		this.WaitForElementPresent(locator, 30);
		Assert.assertTrue(isElementPresent(locator), "Element Locator :" + locator + " Not found");
		WebElement el = getDriver().findElement(ByLocator(locator));
		el.click();
	}
	
	public void clickOnElement(WebElement el) {
		this.waitForElement(el);
		el.click();
	}

	/*
	 * Click on element by string locator
	 */
	public void clickOn(String locator) {
		WebElement el = getDriver().findElement(ByLocator(locator));
		el.click();
	}

	public String returnTitle() {
		return title;
	}

	/*
	 * Scroll page down 250 pixel
	 */
	public void scrollDown() {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0,250)");
	}
	
	
	public void scrollDownTillElement(WebElement element) throws InterruptedException {
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
		Thread.sleep(500); 
	}
	

	/*
	 * Scroll page down pixel
	 * 
	 * @Param pixel pixel to scroll down
	 */
	public void scrollDown(String pixel) {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(0," + pixel + ")", "");
	}

	/*
	 * Scroll page up 250 pixel
	 */
	public void scrollUp() {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(250, 0)", "");
	}

	/*
	 * Scroll page up pixel
	 * 
	 * @Param pixel pixel to scroll down
	 */
	public void scrollUp(String pixel) {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollBy(" + pixel + ", 0)", "");
	}

	private void setImplicitWait(int timeInSec) {
		logger.info("setImplicitWait, timeInSec={}", timeInSec);
		driver.manage().timeouts().implicitlyWait(timeInSec, TimeUnit.SECONDS);
	}

	private void resetImplicitWait() {
		logger.info("resetImplicitWait");
		driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
	}

	public void waitFor(ExpectedCondition<Boolean> expectedCondition) {
		setImplicitWait(0);
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		wait.until(expectedCondition);
		resetImplicitWait();
	}

	public void inputText(WebElement element, String text) {
		logger.info("inputText, text={}", text);
		element.clear();
		element.sendKeys(text);
	}
	
	public void waitForLongTimeElement(WebElement element) {
		logger.info("waitForElement");
		WebDriverWait wait = new WebDriverWait(driver, longTimeout);
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public void waitForElement(WebElement element) {
		logger.info("waitForElement");
	
				try {
						
					
					WebDriverWait wait = new WebDriverWait(driver, timeout);
			//		try {
			//			Thread.sleep(3000);
			//		} catch (InterruptedException e) {
			//			// TODO Auto-generated catch block
			//			e.printStackTrace();
			//		}
					wait.until(ExpectedConditions.elementToBeClickable(element));
				}
				catch(Exception e) {
					//Thread.sleep(2000);
					try {
						goBack();
						WebDriverWait wait = new WebDriverWait(driver, timeout);
						wait.until(ExpectedConditions.elementToBeClickable(element));
					}
						catch(Exception e1) {
						WebElement nobttn = driver.findElement(By.xpath("//android.widget.Button[@text='NO']"));
						if(isElementPresent(nobttn)) {
							nobttn.click();
						}
						WebDriverWait wait = new WebDriverWait(driver, timeout);
						wait.until(ExpectedConditions.elementToBeClickable(element));
					}
				}
				//Assert.assertTrue(isElementPresent(element).equals(true));

				
				
	}

	public boolean _waitForJStoLoad() {
		// wait for jQuery to load
		ExpectedCondition<Boolean> jQueryLoad = new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				try {
					return ((Long) ((JavascriptExecutor) driver).executeScript("return jQuery.active") == 0);
				} catch (Exception e) {
					return true;
				}
			}
		};

		// wait for JavaScript to load
		ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				Object rsltJs = ((JavascriptExecutor) driver).executeScript("return document.readyState");
				if (rsltJs == null) {
					rsltJs = "";
				}
				return rsltJs.toString().equals("complete") || rsltJs.toString().equals("loaded");
			}
		};

		WebDriverWait wait = new WebDriverWait(driver, 30);
		boolean waitDone = wait.until(jQueryLoad) && wait.until(jsLoad);
		return waitDone;
	}

	// Handle locator type
	public By ByLocator(String locator) {
		By result = null;
		if (locator.startsWith("//")) {
			result = By.xpath(locator);
		} else if (locator.startsWith("css=")) {
			result = By.cssSelector(locator.replace("css=", ""));
		} else if (locator.startsWith("#")) {
			result = By.id(locator.replace("#", ""));
		} else if (locator.startsWith("name=")) {
			result = By.name(locator.replace("name=", ""));
		} else if (locator.startsWith("link=")) {
			result = By.linkText(locator.replace("link=", ""));
		} else if (locator.startsWith("(//")) {
			result = By.xpath(locator);
		} else {
			result = By.className(locator);
		}
		return result;
	}

	public static String generateRandomString(int lettersNum) {
		String finalString = "";

		int numberOfLetters = 25;
		long randomNumber;
		for (int i = 0; i < lettersNum; i++) {
			char letter = 97;
			randomNumber = Math.round(Math.random() * numberOfLetters);
			letter += randomNumber;
			finalString += String.valueOf(letter);
		}
		return finalString;
	}
	
	public String randomNumber() {

		Random r = new Random();
		List<Integer> id = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
		int x = r.nextInt(9999);
		while (id.contains(x))
		x = r.nextInt(9999);
		id.add(x);
		}
		String rId = String.format("%04d", id.get(0));
		return rId;
		}

	
	public WebDriver getDriver() {
		return driver;
	}

	public WebElement findElement(By by) {
		if (driver instanceof ChromeDriver || driver instanceof InternetExplorerDriver) {
			try {
				Thread.sleep(3000);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		WebElement foundElement = null;
		for (int milis = 0; milis < 3000; milis = milis + 200) {
			try {
				foundElement = driver.findElement(by);
				return foundElement;
			} catch (Exception e) {
				// Utils.hardWaitMilliSeconds(200);
			}
		}
		return null;
	}

	public void assertByPageTitle() {
		try {
			if (driver instanceof ChromeDriver || driver instanceof InternetExplorerDriver
					|| driver instanceof FirefoxDriver) {
				Thread.sleep(3000);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		Assert.assertTrue(returnTitle().equals(driver.getTitle()));
	}

	public List<String> findAllLinksOnPage() {
		List<String> links = new ArrayList<String>();
		List<WebElement> linkElements = driver.findElements(By.tagName("a"));
		for (WebElement each : linkElements) {
			String link = each.getAttribute("href");
			if (link == null || link.contains("mailto") || link.contains("javascript")) {
				continue;
			}
			links.add(link);
		}
		return links;
	}

	public boolean isResponseForLinkTwoHundredOrThreeOTwo(String link) {
		int code = 0;
		Reporter.log("Link: " + link);
		try {
			URL url = new URL(link);
			HttpURLConnection connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("GET");
			code = connection.getResponseCode();
			Reporter.log("Code: " + code);
		} catch (Exception e) {
			Reporter.log(e.toString());
			return false;
		}
		if (link.contains("pager") || code == 403) {
			return true;
		}
		return code == 200 || code == 302;
	}

	public void setWaitTime(WebDriver driver, int waitTime) {
		driver.manage().timeouts().implicitlyWait(waitTime, TimeUnit.SECONDS);
	}

	public void setWaitTimeToZero(WebDriver driver) {
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
	}

	public void customizableCondition(WebDriver driver, int waitTime, final Boolean condition) {
		// setWaitTimeToZero(driver);
		new WebDriverWait(driver, waitTime).until(new ExpectedCondition<Boolean>() {

			public Boolean apply(WebDriver driver) {
				return condition;
			}
		});
		// setWaitTime(driver, DEFAULT_WAIT_4_ELEMENT);
	}

	public WebElement waitForElementClickable(WebElement webElement, int timeOutInSeconds) {
		WebElement element;
		try {
			// setWaitTimeToZero(driver);
			WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
			element = wait.until(ExpectedConditions.elementToBeClickable(webElement));

			// setWaitTime(driver, DEFAULT_WAIT_4_ELEMENT);
			return element;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public WebElement waitForElementPresent(final By by, int timeOutInSeconds) {
		WebElement element;
		try {

			// setWaitTimeToZero(driver);
			WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
			element = wait.until(ExpectedConditions.presenceOfElementLocated(by));

			// setWaitTime(driver, DEFAULT_WAIT_4_ELEMENT);
			return element;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public WebElement waitForElementPresent(WebElement webElement, int timeOutInSeconds) {
		WebElement element;
		try {
			WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
			element = wait.until(ExpectedConditions.visibilityOf(webElement));
			return element;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public boolean waitForTextPresentInElement(WebElement webElement, String text, int timeOutInSeconds) {
		boolean notVisible;
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		notVisible = wait.until(ExpectedConditions.textToBePresentInElement(webElement, text));

		return notVisible;
	}

	public boolean waitForTextPresentInElement(By by, String text, int timeOutInSeconds) {
		boolean notVisible;
		WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
		notVisible = wait.until(ExpectedConditions.textToBePresentInElementLocated(by, text));

		return notVisible;
	}

	public Boolean isElementPresent(WebElement element) {

		Boolean result = false;
		try {
			if(element.isDisplayed()){
				result = true;
			}		
		} catch (Exception ex) {
		}
		return result;
	}
	

	public Boolean isElementPresent(String locator) {
		Boolean result = false;
		try {
			getDriver().findElement(ByLocator(locator));
			result = true;
		} catch (Exception ex) {
		}
		return result;
	}

	public void WaitForElementNotPresent(String locator, int timeout) {
		for (int i = 0; i < timeout; i++) {
			if (!isElementPresent(locator)) {
				break;
			}

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public void WaitForElementPresent(String locator, int timeout) {
		for (int i = 0; i < timeout; i++) {
			if (isElementPresent(locator)) {
				break;
			}
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public int findNumberOfSpecificElementsInContainer(By container, By element) {
		WebElement mainDiv = driver.findElement(container);
		List<WebElement> divs = mainDiv.findElements(element);
		return divs.size();
	}

	public WebDriver hoverOverElementAndClick(WebElement toBeHovered, WebElement toBeClicked) {
		Actions builder = new Actions(driver);
		builder.moveToElement(toBeHovered).build().perform();
		waitForElementPresent(toBeClicked, DEFAULT_WAIT_4_ELEMENT);
		toBeClicked.click();
		waitForPageLoaded(driver);
		return driver;
	}

	/*
	 * Select element by visible text
	 * 
	 * @Param element
	 * 
	 * @Patram targetValue: visible text
	 */
	public void selectDropDownByText(WebElement element, String targetValue) {
		waitForElement(element);
		new Select(element).selectByVisibleText(targetValue);
	}

	/*
	 * Select element by Index
	 * 
	 * @Param element
	 * 
	 * @Patram index
	 */
	public void selectDropDownByIndex(WebElement element, int index) {
		waitForElement(element);
		new Select(element).selectByIndex(index);
	}

	/*
	 * Select element by value
	 * 
	 * @Param element
	 * 
	 * @Patram targetValue: value
	 */
	public void selectDropDownByValue(WebElement element, String targetValue) {
		waitForElement(element);
		new Select(element).selectByValue(targetValue);
	}

	public void waitForElementToBecomeVisible(By by, WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, DEFAULT_WAIT_4_PAGE);
		wait.until(ExpectedConditions.visibilityOfElementLocated(by));
	}

	public void waitForElementToBecomeInvisible(By by) {
		WebDriverWait wait = new WebDriverWait(driver, DEFAULT_WAIT_4_PAGE);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
	}

	public void waitForAjaxRequestsToComplete() {
		(new WebDriverWait(driver, DEFAULT_WAIT_4_PAGE)).until(new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver d) {
				JavascriptExecutor js = (JavascriptExecutor) d;
				return (Boolean) js.executeScript("return jQuery.active == 0");
			}
		});
	}

	public void waitForPageLoaded(WebDriver driver) {

		ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
			}
		};
		Wait<WebDriver> wait = new WebDriverWait(driver, 20);
		wait.until(expectation);
	}

	public boolean isElementPresent(By by) {
		try {
			driver.findElement(by);
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	public boolean isTextPresentOnPage(String text) {
		return driver.findElement(By.tagName("body")).getText().contains(text);
	}
	
//	public void waitTillTextPresent(String text) {
//		WebDriverWait wait = new WebDriverWait(driver, 15);
//		wait.until(driver.findElement(By.tagName("body")).getText().contains(text), "Time left: 7 seconds"));
//		
//	}
	
	public void waitTillTextPresent(WebDriver driver, String text) {

		ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				return driver.findElement(By.tagName("body")).getText().contains(text);
			}
		};
		Wait<WebDriver> wait = new WebDriverWait(driver, 100);
		wait.until(expectation);
	}

	public void takeRemoteWebDriverScreenShot(String fileName) {
		File screenshot = ((TakesScreenshot) new Augmenter().augment(driver)).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(screenshot, new File(fileName));
		} catch (IOException ioe) {
			ioe.printStackTrace();
		}
	}

	

	public void dragAndDrop(WebElement drag, WebElement drop) {
		Actions builder = new Actions(driver);
		Action dragAndDrop = builder.clickAndHold(drag).moveToElement(drop).release(drop).build();
		dragAndDrop.perform();
	}

	public void switchToFrame(WebElement element) {
		logger.info("Switch to Frame");
		waitForElement(element);
		driver.switchTo().frame(element);
	}

	public void switchToDefaultWindow() {
		logger.info("Switch to Default Window");
		driver.switchTo().defaultContent();
	}

	public void waitForElementToBecomeInvisible(String element) {
		WebDriverWait wait = new WebDriverWait(driver, DEFAULT_WAIT_MAXTIME);
		wait.until(ExpectedConditions.invisibilityOfElementLocated(ByLocator(element)));
	}

	public void waitForElementToBecomevisible(String element) {
		WebDriverWait wait = new WebDriverWait(driver, DEFAULT_WAIT_MAXTIME);
		wait.until(ExpectedConditions.visibilityOfElementLocated(ByLocator(element)));
	}
	public boolean isAlertPresent() {
		try {
			driver.switchTo().alert();
			return true;
		} catch (NoAlertPresentException Ex) {
			return false;
		} // catch
	}
	
	public void scrollDownToBottom() {
		JavascriptExecutor jse = (JavascriptExecutor) driver;
		jse.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	}
	
	public void scrollDownToElement(WebElement locator) {
		Point el= locator.getLocation();
		int x=el.getX();
		int y=el.getY();
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollTo("+x+","+y+")");
		
	}
	
	public void verifyDBConnection(){
		// Connection object
	      //Connection con = null;
	       // Statement object
	      Statement stmt;
	       // Constant for Database URL
	        String DB_URL = "jdbc:mysql://db-dev.hobocloud.info:13307/aurora_development";   
	       // Constant for Database Username
	      String DB_USER = "hobolink_ro";
	       // Constant for Database Password
	       String DB_PASSWORD = "Rq2sz9Chg8";
		
		try{
			
			
			
			// Make the database connection
            String dbClass = "com.mysql.jdbc.Driver";
            Class.forName(dbClass).newInstance();
            // Get connection to DB
            Connection con =  DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
            // Statement object to send the SQL statement to the Database
            stmt = con.createStatement();
            
            String query = "select a.* from aurora_development.deployments a where a.id='101517'";
            // Get the contents of userinfo table from DB
            ResultSet res = stmt.executeQuery(query);
            // Print the result untill all the records are printed
            // res.next() returns true if there is any next record else returns false
            while (res.next())
	            {
		            System.out.print(res.getString(1));
		            System.out.print("\t" + res.getString(2));
		            System.out.print("\t" + res.getString(3));
		            System.out.println("\t" + res.getString(4));
	            }
            con.close();
            
            }
            catch (Exception e)
            {
                  e.printStackTrace();
            }
				     
	}
	
	
	public void goBack() {
		//driver.pressKeyCode(AndroidKeyCode.BACK);
		driver.navigate().back();
	}
	
	public void toggleGPS() {
		((AndroidDriver) driver).toggleLocationServices();
	}
	
	public static void gpsOn() {
		sendADBCommand("settings put secure location_providers_allowed +gps");
	}
	public static void gpsOff() {
		sendADBCommand("settings put secure location_providers_allowed -gps");
	}

	
	public static void sendADBCommand(String cmd) {
		Map<String, String> params = new HashMap<String, String>();
		params.put("command", cmd);

	    ((AndroidDriver) driver).executeScript("mobile:handset:shell", params);
	}
	
	

}