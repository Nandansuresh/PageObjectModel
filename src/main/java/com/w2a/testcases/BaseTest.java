package com.w2a.testcases;

import com.w2a.base.Page;

public class BaseTest {
	
	public void teardown() {
		
		Page.quit();
	}

}
