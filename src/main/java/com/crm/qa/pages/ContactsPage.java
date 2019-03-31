package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;
import com.crm.qa.util.Utility;

public class ContactsPage extends TestBase{

	@FindBy(xpath="//td[contains(text(),'Contacts')]")
	WebElement contactsLabel;
	
	@FindBy(xpath="//a[@title='New Contact']")
	WebElement newContact;
	
	@FindBy(name="title")
	WebElement titleDropDown;
	
	@FindBy(name="first_name")
	WebElement firstName;
	
	@FindBy(name="surname")
	WebElement lastName;
	
	@FindBy(name="client_lookup")
	WebElement company;
	
	@FindBy(xpath="//input[@value='Load From Company']/following-sibling::input[@value='Save']")
	WebElement saveBttn;
	
	public ContactsPage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean contactsLabelIsDisplayed() {
		return contactsLabel.isDisplayed();
	}
	
	public void selectName(String uname) {
		
		driver.findElement(By.xpath("//td/a[contains(text(),'"+uname+"')]"
				+ "/../preceding-sibling::td/input")).click();
	}
	
	public boolean createNewContact(String title, String fname, String lname, String comp) {
		
		Actions act = new Actions(driver);
		act.moveToElement(contactsLabel).build().perform();
		
		newContact.click();
		Select titleSelect = new Select(titleDropDown);
		titleSelect.selectByValue(title);
		firstName.sendKeys(fname);
		lastName.sendKeys(lname);
		company.sendKeys(comp);
		saveBttn.click();
		
		Utility.switchToFrame("mainpanel");
		contactsLabel.click();
		
		return driver.findElement(By.xpath("//form[@id='vContactsForm']"
				+ "//a[contains(text(),'"+fname+" "+lname+"')]")).isDisplayed();
		
	}
	
}
