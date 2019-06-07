package com.qa.ebay.testbase;

import java.io.FileInputStream;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestBase {

	public static WebDriver driver ;
	public static  Properties prop;
	
	
	public  TestBase() throws IOException  {
		
		
			FileInputStream ip = new FileInputStream("C:\\HomePractice\\EbayProject\\src"
					+ "\\main\\java\\com\\qa\\ebay\\testdata\\config.properties");
			prop = new Properties();
			
			prop.load(ip);
		
	}
	
	public static void intialization() {
		String browser = prop.getProperty("browser");
		
		if(browser.equals("firefox")) {
			System.setProperty("webdriver.gecko.driver","C:/SeleniumJars/geckodriver.exe");
			 driver = new FirefoxDriver();
			
		}
		else if(browser.equals("Chrome")) {
			
			System.setProperty("webdriver.chrome.driver","C:/SeleniumJars/chromedriver.exe");
			 driver= new ChromeDriver();
		}
		else {
			System.setProperty("webdriver.chrome.driver","C:/SeleniumJars/chromedriver.exe");
			 driver= new ChromeDriver();
		}
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		driver.get(prop.getProperty("url"));
		}
	
	
}
