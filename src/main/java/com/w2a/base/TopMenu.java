package com.w2a.base;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.w2a.pages.crm.accounts.AccountsPage;

public class TopMenu {
	
	
	WebDriver driver;
	
	public TopMenu(WebDriver driver) {
		
		this.driver=driver;
	}
	
	public void gotoHome() {
		
	}

	public void gotoLeads() {
		
	}
	
	public void gotoContacts() {
		
	}
	
//	public void gotoAccounts() {
//		
//		driver.findElement(By.xpath("//div[@data-value='Accounts']")).click();
//		
//	}
	
	public AccountsPage gotoAccounts() {
		
		driver.findElement(By.xpath("//div[@data-value='Accounts']")).click();
		
		return new AccountsPage();
	}
	
	public void signOut() {
		
	}
}
