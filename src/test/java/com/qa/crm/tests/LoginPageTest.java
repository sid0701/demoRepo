package com.qa.crm.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class LoginPageTest extends TestBase{

	LoginPage lp;
	
	@BeforeMethod
	public void setup() {
		initialization();
		lp = new LoginPage();
	}
	
	@Test
	public void verifyLoginPageTitle() {
		String actualTitle = lp.returnPageTitle();
		Assert.assertTrue(actualTitle.contains("CRMPRO"));
	}
	
	@Test
	public void verifyCRMLogo() {
		Assert.assertTrue(lp.crmLogoDisplayed(),"CRM Logo not displayed");
	}
	
	@Test
	public void login() {
		HomePage hp = lp.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
}
