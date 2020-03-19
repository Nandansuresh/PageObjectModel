package com.w2a.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.w2a.base.Page;

public class HomePage extends Page{
	
	public void goToSignUp() {
		
		driver.findElement(By.cssSelector("a[class='zh-signup']")).click();
	}
	
    public void goToSupport() {
		
    	driver.findElement(By.cssSelector("a[class='zh-support']"));
	}
	
//    public void goToLogin() {
//		
//    	driver.findElement(By.cssSelector("a[class='zh-login']")).click();
//  	}
    
    public LoginPage goToLogin() {
		
    	click("loginlink_css");
    	
    	return new LoginPage();
  	}
    
    public void goToCustomer() {
		
    	driver.findElement(By.cssSelector("a[class='zh-customers']"));
  	}
    
    public void goToLearnMore() {
    	
    	driver.findElement(By.xpath("(//a[@class='learn-more'])[1]"));
		
  	}
    
}


