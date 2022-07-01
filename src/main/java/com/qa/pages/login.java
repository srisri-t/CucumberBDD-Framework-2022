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
	public String validateLoginPageTitle(){
		return driver.getTitle();
	}
	
	//Signin() referes to sign into the Salesforce login page with valid credentials
	public void signin()
	{
        driver.findElement(By.xpath("//input[@id='username']")).sendKeys("srisrikairos@gmail.com");
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("Sherwin@123");
        driver.findElement(By.xpath("//input[@id='Login']")).click();

	}

	//logout() referes to log out from the Salesforce account
	public void logout() throws InterruptedException {
		Thread.sleep(5000);
//		driver.switchTo().alert().accept();
		driver.findElement(By.xpath("//header/div[2]/span[1]/div[2]/ul[1]/li[9]/span[1]/button[1]/div[1]/span[1]/div[1]/span[1]")).click();
		driver.findElement(By.xpath("//a[contains(text(),'Log Out')]")).click();
	}

	
}
