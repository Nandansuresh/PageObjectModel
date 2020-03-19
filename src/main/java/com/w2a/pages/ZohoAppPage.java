package com.w2a.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.w2a.base.Page;
import com.w2a.pages.crm.CRMHomePage;

public class ZohoAppPage extends Page {
	
	
//	public void goToCRM() {
//		
//		driver.findElement(By.xpath("//span[@class='_logo-crm _logo-x96 zod-app-logo']")).click();
//		
//	}

	
	public CRMHomePage goToCRM() {
		
		driver.findElement(By.xpath("//span[@class='_logo-crm _logo-x96 zod-app-logo']")).click();
		
		return new CRMHomePage();
	}
}
