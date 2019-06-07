package com.qa.ebay.testcases;

import java.io.IOException;
import java.util.List;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.ebay.pages.HomePage;
import com.qa.ebay.pages.SignInPage;
import com.qa.ebay.testbase.TestBase;

public class HomePageTest extends TestBase{
	SignInPage lp;
	HomePage hp;
	public HomePageTest() throws IOException {
		super();
		
	}
	
	@BeforeMethod
	public void setUp() throws IOException {
		intialization();
		 lp = new SignInPage();
		 lp.signIn(prop.getProperty("email1"), prop.getProperty("password1"));
	     hp = new HomePage();
		
	}
	
 
	@AfterMethod
	public void tearDown() {
		driver.quit();
		
		
	}
	@Test(priority=1)
	public void dropDownTest() throws InterruptedException {
		List expected = hp.listDrpDwn();
		Assert.assertTrue(expected.equals(hp.actualList), "Both list are not in same order");
		System.out.println(expected.size());
		
		}
	
	@Test(priority=2)
	public void titleTest() throws InterruptedException { 
		hp.validateTitle();
		Thread.sleep(2000);
		Assert.assertEquals(driver.getTitle(), prop.getProperty("RegistrationTitle"));
	}
	

}
