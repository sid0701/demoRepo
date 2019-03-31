package com.crm.qa.pages;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase{

	@FindBy(name="username")
	WebElement uname;
	
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//input[@value='Login']")
	WebElement loginBttn;
	
	@FindBy(xpath="//img[@src='https://classic.crmpro.com/img/logo@2x.png']")
	WebElement crmLogo;
	
	public LoginPage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean crmLogoDisplayed() {
		return crmLogo.isDisplayed();
	}
	
	public String returnPageTitle() {
		return driver.getTitle();
	}
	
	public HomePage login(String username, String pass) {
		
		uname.sendKeys(username);
		try {
		Thread.sleep(1000);
		}
		catch(InterruptedException e) {
			e.printStackTrace();
		}
		password.sendKeys(pass);
		try {
			Thread.sleep(1000);
		}
		catch(InterruptedException e) {
			e.printStackTrace();
		}
		loginBttn.click();
		
		return new HomePage();
	}
	
}
