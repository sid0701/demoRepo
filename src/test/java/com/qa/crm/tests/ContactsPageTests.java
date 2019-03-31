package com.qa.crm.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.ContactsPage;
import com.crm.qa.pages.HomePage;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.Utility;

public class ContactsPageTests extends TestBase{

	LoginPage lp;
	HomePage hp;
	ContactsPage cp;
	
	@BeforeMethod
	public void setup() {
		initialization();
		
		lp = new LoginPage();
		hp = lp.login(prop.getProperty("username"), prop.getProperty("password"));
		cp = hp.clickOnContacts();
	}
	
	@Ignore
	@Test
	public void verifyContactsLabel() {
		Assert.assertTrue(cp.contactsLabelIsDisplayed());
	}
	
	@Ignore
	@Test
	public void verifyNameClicked() {
		cp.selectName("Dinkar Gupta");
	}
	
	@Test(dataProvider="getData")
	public void verifyNewContactCreated(String title, String fname, String lname, String company) {
		Assert.assertTrue(cp.createNewContact(title, fname, lname, company)); 
	}
	
	@DataProvider(name="getData")
	public Object[][] provideData() {
		Utility util = new Utility("D:\\Selenium\\Workspace\\FirstMavenProject\\src\\main\\java\\com\\crm\\qa\\testdata\\TestData.xlsx"
				,"Contacts");
		int noOfRows = util.returnRowCount();
		
		Object[][] data = new Object[noOfRows][4];
		
		for(int i=0;i<noOfRows;i++) {
			data[i][0] = util.readExcelData(i+1,0);
			data[i][1] = util.readExcelData(i+1,1);
			data[i][2] = util.readExcelData(i+1,2);
			data[i][3] = util.readExcelData(i+1,3);
		}
		return data;
	}
	
	
	@AfterMethod
	public void teardown() {
		driver.quit();
	}
}
