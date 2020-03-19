package com.w2a.testcases;

import java.util.Hashtable;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.w2a.base.Page;
import com.w2a.pages.ZohoAppPage;
import com.w2a.pages.crm.accounts.AccountsPage;
import com.w2a.pages.crm.accounts.CreateAccountPage;
import com.w2a.utilities.TestUtils;

public class CreateAccountTest {
	
	@Test(dataProviderClass=TestUtils.class, dataProvider="dp")
	public void createaccounttest(Hashtable<String,String> data) {
		
		ZohoAppPage zp=new ZohoAppPage();
		zp.goToCRM();
		AccountsPage account=Page.menu.gotoAccounts();
		CreateAccountPage cap=account.goToCreateAccounts();
		cap.createAccount(data.get("accountname"));
		//Assert.fail("fail the test case to check the screenshot");
	}
	

}
