package com.w2a.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.Reporter;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.w2a.utilities.ExcelReader;
import com.w2a.utilities.ExtentManager;
import com.w2a.utilities.TestUtils;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Page {
	
	public static WebDriver driver;
	public static Properties config = new Properties();
	public static Properties OR = new Properties();
	public static FileInputStream fis;
	public static Logger log = Logger.getLogger("devpinoyLogger");
	public static ExcelReader excel = new ExcelReader(System.getProperty("user.dir") + "\\src\\test\\resources\\com\\w2a\\excel\\testdata1.xlsx");
	public static WebDriverWait wait;
    
	public ExtentReports rep = ExtentManager.getInstance();
	public static ExtentTest test;
	
	public static TopMenu menu; 
	
	public static String browser;
	
	
	public Page() {  
		
		if(driver==null) {
			
			try {
				fis = new FileInputStream(
						System.getProperty("user.dir") + "\\src\\test\\resources\\com\\w2a\\properties\\Config.properties");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				config.load(fis);
				log.debug("Config file loaded");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			try {
				fis = new FileInputStream(
						System.getProperty("user.dir") + "\\src\\test\\resources\\com\\w2a\\properties\\OR.properties");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				OR.load(fis);
				log.debug("OR file loaded");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			//jenkins Browser filter configuaration
			
			if(System.getenv("browser") != null && !System.getenv("browser").isEmpty()) {
				
				browser=System.getenv("browser");
			}else {
				
				browser=config.getProperty("browser");
			}
			
			config.setProperty("browser", browser);
			
			if (config.getProperty("browser").equals("firefox")) {
				System.setProperty("Webdriver.gecko.driver",
						System.getProperty("user.dir") + "\\src\\test\\resources\\executables\\geckodriver.exe");
				driver = new FirefoxDriver();
			} else if (config.getProperty("browser").equals("chrome")) {
				System.setProperty("Webdriver.chrome.driver",
						System.getProperty("user.dir") + "\\src\\test\\resources\\executables\\chromedriver.exe");
//				WebDriverManager.chromedriver().setup();
				driver = new ChromeDriver();
				log.debug("Chrome Browser Initialised");
				 Map<String, Object> prefs= new HashMap<String, Object>();
				    prefs.put("profile.default_content_setting_values.notifications", 2);
				    prefs.put("credentials_enable_service", false);
				    prefs.put("profile.password_manager_enabled", false);
				    ChromeOptions options= new ChromeOptions();
				    options.setExperimentalOption("prefs", prefs);
				    options.addArguments("--disable-extentions");
				    options.addArguments("--disable-infobars");
			} else if (config.getProperty("browser").equals("ie")) {
				System.setProperty("Webdriver.ie.driver",
						System.getProperty("user.dir") + "\\src\\test\\resources\\executables\\IEDriverServer.exe");
				driver = new InternetExplorerDriver();
			}
			   
			driver.get(config.getProperty("testsiteurl"));
			log.debug("Navigated to the site: " + config.getProperty("testsiteurl"));
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Integer.parseInt(config.getProperty("implicit.wait")),
					TimeUnit.SECONDS);
			wait = new WebDriverWait(driver, 5);
			menu=new TopMenu(driver);
		}
	}
	
	public static void quit() {
		
		driver.quit();
	}
	
static WebElement  dropdown;
	
	public static void select(String locator, String value)
	{
		if(locator.endsWith("_css")) {
			dropdown=driver.findElement(By.cssSelector(OR.getProperty(locator)));
		}else if(locator.endsWith("_xpath")) {
			dropdown=driver.findElement(By.xpath(OR.getProperty(locator)));
		}else if(locator.endsWith("_id")) {
			dropdown=driver.findElement(By.id(OR.getProperty(locator)));
		}
		Select select=new Select(dropdown);
		select.selectByVisibleText(value);
		
		test.log(LogStatus.INFO, "Selecting from dropdown:"+ locator+"value as:"+ value);
	}
	

	public boolean isElementPresent(By by) {
		try {

			driver.findElement(by);
			log.debug("It entered Try block of isElementPresent");
			return true;

		} catch (NoSuchElementException e) {
			log.debug("It entered Catch block of isElementPresent");
			return false;
		}

	}

	public static void click(String locator)
	{
		if(locator.endsWith("_css")) {
			driver.findElement(By.cssSelector(OR.getProperty(locator))).click();
		}else if(locator.endsWith("_xpath")) {
			driver.findElement(By.xpath(OR.getProperty(locator))).click();
		}else if(locator.endsWith("_id")) {
			driver.findElement(By.id(OR.getProperty(locator))).click();
		}
		
		test.log(LogStatus.INFO, "clicking on:"+ locator);
	}
	
	public static void type(String locator, String value)
	{
		if(locator.endsWith("_css")) {
			driver.findElement(By.cssSelector(OR.getProperty(locator))).sendKeys(value);
		}else if(locator.endsWith("_xpath")) {
			driver.findElement(By.xpath(OR.getProperty(locator))).sendKeys(value);
		}else if(locator.endsWith("_id")) {
			driver.findElement(By.id(OR.getProperty(locator))).sendKeys(value);
		}
		
		test.log(LogStatus.INFO, "Typing in:"+ locator+"entered value as"+ value);
	}
	
	public static void verifyEquals(String expected, String Actual) throws IOException
	{
		try {
			
			Assert.assertEquals(expected, Actual);
			
		}catch(Throwable t) {
			
			TestUtils.CaptureScreenshot();
			//ReportNG
			System.setProperty("org.uncommons.reportng.escape-output", "false");
			Reporter.log("<br>"+"Verification failure:"+ t.getMessage()+"<br>");
			Reporter.log("<a target=\"_blank\"href=\"+TestUtils.ScreenshotName+\"><img src="+TestUtils.ScreenshotName+"  height=200 width=200></img></a>");
			Reporter.log("<br>");
			Reporter.log("<br>");
			
			//Extent Report
			test.log(LogStatus.FAIL, "Verification failed with exception :"+ t.getMessage());
			test.log(LogStatus.FAIL, test.addScreenCapture(TestUtils.ScreenshotName));
		}
		
	}
}


