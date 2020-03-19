package com.w2a.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.w2a.base.Page;

public class LoginPage extends Page{
	
	
//	public void doLogin(String username, String password) {
//		
//		//driver.switchTo().frame("siqiframe");
//		driver.findElement(By.id("login_id")).sendKeys(username);
//		driver.findElement(By.id("nextbtn")).click();
//		driver.findElement(By.id("password")).sendKeys(password);
//		driver.findElement(By.xpath("//form[@id='login']//button[@id='nextbtn']")).click();   
//	}

	
public ZohoAppPage doLogin(String username, String password) {
		
	
		type("email_id",username);
		click("next_id");
		type("password_id",password);
		click("lgnbtn_xpath");   
		
		return  new ZohoAppPage();
	}

}
