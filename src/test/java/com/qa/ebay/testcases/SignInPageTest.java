package com.qa.ebay.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.ebay.pages.HomePage;
import com.qa.ebay.pages.SignInPage;
import com.qa.ebay.testbase.TestBase;

public class SignInPageTest extends TestBase {
	
	SignInPage lp;
	HomePage hp =new HomePage();
	
	
	public SignInPageTest() throws IOException {
		super();
		
	}





	@BeforeMethod
	public void setUp() throws IOException {
		intialization();
		 lp = new SignInPage();
		}
	
	@AfterMethod
	public void tearDown() {
		
		driver.quit();
	}
	@Test(priority=1)
	public void validateImgPresentTest() {
		boolean img = lp.imgPresent();
		Assert.assertTrue(img, "img is not diasplayed");
		
	}
	
	@Test(priority=2)
	public void validatesingIn() throws IOException {
	 lp.signIn(prop.getProperty("email1"), prop.getProperty("password1"));
     Assert.assertEquals(driver.getCurrentUrl(),prop.getProperty("expectedUrl"));
		
	}
	
 
}
