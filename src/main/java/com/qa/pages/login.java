package com.qa.pages;

//import org.apache.http.auth.UsernamePasswordCredentials;

import com.qa.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;


public class login extends TestBase{
		
	//Initializing the Page Objects:
	public login(){
		PageFactory.initElements(driver, this);
	}
	
	//Actions:
	//Signing() refers to sign in to the Salesforce login page with valid credentials
	public void signing()
	{
        driver.findElement(By.xpath("//input[@id='username']")).sendKeys("srisri@gmail.com");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Sherwin@123");
        driver.findElement(By.xpath("//input[@id='Login']")).click();

	}

}
