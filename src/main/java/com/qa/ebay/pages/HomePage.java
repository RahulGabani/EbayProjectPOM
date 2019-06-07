package com.qa.ebay.pages;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.qa.ebay.testbase.TestBase;

public class HomePage extends TestBase{

	public List actualList;
	
	@FindBy(xpath="//a[text()='Registration']")
	WebElement reg;
	
	@FindBy(id="firstname")
	WebElement firstName;
	
	@FindBy(id="lastname")
	WebElement lastName;
	
	@FindBy(id="email")
	WebElement emailId;
	
	@FindBy(id="PASSWORD")
	WebElement pass;
	
	@FindBy(xpath="//button[@disabled='disabled']")
	WebElement disRegBtn;
	
	@FindBy(xpath="//button[text()='Register']")
	WebElement regBtn;
	
	@FindBy(xpath="//div[@id=\"gh-cat-box\"]")
	WebElement drp;
	@FindBy(id ="gh-cat")
	WebElement drop;
	
	public HomePage() throws IOException {
		PageFactory.initElements(driver, this);
	}
public List listDrpDwn() throws InterruptedException {
	drp.click();
	Thread.sleep(2000);
	//List<WebElement> list = driver.findElements(By.xpath("//select[@id='gh-cat']/option"));
	Select dropDown = new Select(drop);
	List<WebElement> list = dropDown.getOptions()	;
	actualList = new ArrayList();
	
	for(int i=0; i<list.size(); i++) {
		String data = list.get(i).getText();
		actualList.add(data);
	}
	
	System.out.println(actualList.size());
	List sorted = new ArrayList();
	sorted.addAll(actualList);
	
	Collections.sort(sorted);
	System.out.println(sorted.size());
	return sorted;
	
	
		
	}


	
	public RegistrationPage validateTitle() throws InterruptedException {
		JavascriptExecutor jse = (JavascriptExecutor)driver;
		jse.executeScript("arguments[0].scrollIntoView(true)", reg);
		Thread.sleep(3000);
		reg.click();
		Thread.sleep(2000);
		return new RegistrationPage();
		
	}
	
	public boolean regBtnDsbl() {
		
		return disRegBtn.isDisplayed();
	}
	
	public boolean registration(String s1, String s2, String s3, String s4) {
		firstName.sendKeys(s1);
		lastName.sendKeys(s2);
		emailId.sendKeys(s3);
		pass.sendKeys(s4);
		
		if(regBtn.isDisplayed()) {
			regBtn.click();
			System.out.println("all information entered is correct and registration successful");
		}
		else {
			System.out.println("something is missing in information, ReEnter");
		}
		return regBtn.isEnabled();
	}
	
}
