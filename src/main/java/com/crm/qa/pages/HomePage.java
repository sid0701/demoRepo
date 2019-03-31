package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;
import com.crm.qa.util.Utility;

public class HomePage extends TestBase{

	@FindBy(xpath="//a[contains(text(),'Contacts')]")
	WebElement contactsLink;
	
	@FindBy(xpath="//a[contains(text(),'Deals')]")
	WebElement dealsLink;
	
	@FindBy(xpath="//a[contains(text(),'Tasks')]")
	WebElement tasksLink;
	
	public HomePage() {
		PageFactory.initElements(driver, this);
	}
	
	public boolean returnUserLabel(String userLabel) {
		
		Utility.switchToFrame("mainpanel");
		return driver.findElement(By.xpath("//td[contains(text(),'User: "+userLabel+"')]")).isDisplayed();
	}
	
	public String returnHomePageTitle() {
		return driver.getTitle();
	}
	
	public ContactsPage clickOnContacts() {
		Utility.switchToFrame("mainpanel");
		contactsLink.click();
		
		return new ContactsPage();
	}
	
	public DealsPage clickOnDeals() {
		Utility.switchToFrame("mainpanel");
		dealsLink.click();
		
		return new DealsPage();
	}
	
	public TasksPage clickOnTasks() {
		Utility.switchToFrame("mainpanel");
		tasksLink.click();
		
		return new TasksPage();
	}
	
}
