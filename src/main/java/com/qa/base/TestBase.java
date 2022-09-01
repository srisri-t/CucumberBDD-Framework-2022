package com.qa.base;

import com.qa.util.TestUtil;
import com.qa.util.WebEventListener;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.UnexpectedAlertBehaviour;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.io.*;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;


/**
 * Test Base file is for Driver methods maintenance such are web driver of chrome, firefox, safari.
 ************************** 		Do not change anything in this file			 **************************
 **/


public class TestBase {
	
	public static WebDriver driver;
	public static Properties prop;
	public  static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;
	
		public TestBase(){
		try {
			prop = new Properties();
			FileInputStream ip = new FileInputStream(System.getProperty("user.dir")+ "/src/test/resources/config/config.properties");
			prop.load(ip);
		} catch (IOException e) {
			e.printStackTrace();
		}

		}
	/** This Method is used to set up browser
	 * with implicit wait
	 * Just we must Edit the browser name in config.properties to select browser **/
	public static void initialization()
	{
		String browserName = prop.getProperty("browser");

		switch (browserName) {
			case "chrome":
				WebDriverManager.chromedriver().setup();
				//To handle location popup and alerts
				DesiredCapabilities caps = new DesiredCapabilities();
				ChromeOptions options = new ChromeOptions();
				caps.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.ACCEPT);
				Map<String, Object> prefs = new HashMap<String, Object>();
				prefs.put("profile.default_content_setting_values.notifications", 1);
				prefs.put("profile.default_content_settings.popups", 0);
				prefs.put("download.default_directory", System.getProperty("user.dir") + "\\Framework_Downloads");
				prefs.put("safebrowsing.enabled", "true");
				options.addArguments("--start-maximized");
				caps.setCapability(ChromeOptions.CAPABILITY, options);
				driver = new ChromeDriver(options);

				break;
			case "firefox":
				WebDriverManager.firefoxdriver().setup();
				driver = new FirefoxDriver();
				break;
			case "safari":
				driver = new SafariDriver();
				break;
			default:
				System.out.println("Please pass the correct browser value: " + browserName);
				break;
		}
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICIT_WAIT, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
		
	}

//	After the execution the browser close
	public void closeBrowser() throws InterruptedException {
		Thread.sleep(5000);
		driver.quit();
	}
	
	
}
