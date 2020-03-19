package com.w2a.rough;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import com.w2a.base.Page;
import com.w2a.pages.HomePage;
import com.w2a.pages.LoginPage;
import com.w2a.pages.ZohoAppPage;
import com.w2a.pages.crm.accounts.AccountsPage;
import com.w2a.pages.crm.accounts.CreateAccountPage;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LoginTest1 {

	public static void main(String[] args) {
		
		//WebDriverManager.chromedriver().setup();
//		System.setProperty("webdriver.chrome.driver", 
//				System.getProperty("user.dir")+"\\src\\test\\resources\\executables\\chromedriver.exe");
		//WebDriver driver=new ChromeDriver();
		//driver.get("https://www.zoho.com");
		//driver.manage().window().maximize();
		//driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		
	/*	HomePage home= new HomePage();
		home.goToLogin();
		//home.goToSignUp();
		LoginPage login=new LoginPage();
		login.doLogin("nandansuresh1994@gmail.com", "Nn77714311!@#");
		
		ZohoAppPage app= new ZohoAppPage();
		app.goToCRM();
		
		Page.menu.gotoAccounts();
		AccountsPage account=new AccountsPage();
		account.goToCreateAccounts();
		CreateAccountPage cap= new CreateAccountPage();
		cap.createAccount("Nandan");  */
		
		
		HomePage home= new HomePage();
		LoginPage lp=home.goToLogin();
		ZohoAppPage app=lp.doLogin("nandansuresh1994@gmail.com", "Nn77714311!@#");
		app.goToCRM();		
		AccountsPage account=Page.menu.gotoAccounts();
		CreateAccountPage cap= account.goToCreateAccounts();
		cap.createAccount("Nandan");
		
	}

}
