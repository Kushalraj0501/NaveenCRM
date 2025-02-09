package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;
import com.crm.qa.util.TestUtil;

public class HomePage extends TestBase{

	TestUtil testutil;
	
	
	@FindBy(xpath = "/html/body/table[1]/tbody/tr[1]/td/table/tbody/tr/td[1]")
	WebElement usernamealabel;
	
	@FindBy(xpath = "//a[contains(text(),'Contacts')]")
	WebElement contactlink;
	
	@FindBy(xpath = "//a[contains(text(),'New Contact')]")
	WebElement NewContact;
	
	@FindBy(xpath = "//a[contains(text(), \"Deals\")]")
	WebElement Dealslink;
	
	@FindBy(xpath = "//a[contains(text(), \"Tasks\")]")
	WebElement Tasklink;
	
	public HomePage()
	
	{
		PageFactory.initElements(driver, this);
	}
	
	public String verifyHomePageTitle()
	
	{
		return driver.getTitle();
	}
	
	public boolean verifyUser()
	
	{
		
		return usernamealabel.isDisplayed();
	}
	
	public ContactsPage clickContact()
	
	{
		
		contactlink.click();
		return new ContactsPage();
	}
	
	public DealsPage clickDeals()
	
	{
		Dealslink.click();
		return new DealsPage();
	}
	
	
public TasksPage clickTask()
	
	{
	Tasklink.click();
		return new TasksPage();
	}

public void clickNewcontact()
{
	
	
	Actions action = new Actions(driver);
	action.moveToElement(contactlink).build().perform();
	NewContact.click();
	
}
	
}
