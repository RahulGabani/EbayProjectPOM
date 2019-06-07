package com.qa.ebay.testcases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.ebay.pages.HomePage;
import com.qa.ebay.pages.SignInPage;
import com.qa.ebay.testbase.TestBase;

public class RegistrationTest extends TestBase{
	HomePage hp;
	SignInPage lp;

  
	
public RegistrationTest() throws IOException {
		super();
		
	}
@BeforeMethod

public void setUp() throws IOException, InterruptedException {
	
	intialization();
	 lp = new SignInPage();
	 lp.signIn(prop.getProperty("email1"), prop.getProperty("password1"));
     hp = new HomePage();
     hp.validateTitle();
}

@AfterMethod

public void tearDown() {
	driver.quit();
	
}

@Test(priority=1)
	
	public void regBtnTest() {
		
		boolean btn=hp.regBtnDsbl();
		Assert.assertTrue(btn, "Registration button is not disable");
		
		
	}
	
	@Test(priority=2)

	public void vadidateRegTest() {
		boolean enbl = hp.registration(prop.getProperty("firstname"), prop.getProperty("lastname"), prop.getProperty("email"), prop.getProperty("password"));
		Assert.assertTrue(enbl, "Button is Not Enable");
	}
	
}
