package com.qa.crm.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;

public class HomePageTests extends TestBase{

	LoginPage lp;
	HomePage hp;
	
	@BeforeMethod
	public void setup() {
		initialization();
		lp = new LoginPage();
		hp = lp.login(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	@Test
	public void verifyUserLabel() {
		Assert.assertTrue(hp.returnUserLabel("Siddharth Gupta"));
	}
	
	@Test
	public void verifyHomePageTitle() {
		Assert.assertEquals(hp.returnHomePageTitle(), "CRMPRO", "Title not matched");
	}
	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
	
}
