package com.w2a.rough;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class practice {

	public static void main(String[] args) {
		
		WebDriverManager.chromedriver().setup();
		WebDriver driver=new ChromeDriver();
		driver.get("https://www.zoho.com");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
		driver.findElement(By.cssSelector("a[class='zh-login']")).click();
		driver.findElement(By.id("login_id")).sendKeys("nandansuresh1994@gmail.com");
		driver.findElement(By.id("nextbtn")).click();
		driver.findElement(By.id("password")).sendKeys("Nn77714311!@#");
		driver.findElement(By.xpath("//form[@id='login']//button[@id='nextbtn']")).click();
				
	}

}
