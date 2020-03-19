package com.w2a.pages.crm.accounts;

import org.openqa.selenium.By;
import org.openqa.selenium.By.ByCssSelector;

import com.w2a.base.Page;

public class CreateAccountPage extends Page{
	
	
	public void createAccount(String accountName) {
		
		driver.findElement(By.cssSelector("#Crm_Accounts_ACCOUNTNAME")).sendKeys(accountName);
		
	}

}
