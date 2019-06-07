package com.qa.ebay.pages;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.qa.ebay.testbase.TestBase;

public class SignInPage extends TestBase{


	
	@FindBy(id="userid")
	WebElement username;
	
	@FindBy(id="pass")
	WebElement password;
	
	@FindBy(xpath="//button[@id='sgnBt']")
	WebElement signin;
	
	@FindBy(xpath="//img[@id='gh-logo']")
	WebElement img;
	

	public SignInPage() throws IOException {
		PageFactory.initElements(driver, this);
		//this keyword is refered to current class objects (all findby elements) to driver
	
		}
	
	public boolean imgPresent() {
		 return img.isDisplayed();
		
	}
	
	public HomePage signIn(String s1, String s2) throws IOException {
		username.sendKeys(s1);
		password.sendKeys(s2);
		signin.click();
		return new HomePage() ;
		
		
	}
	
	

}
