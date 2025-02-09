package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;

public class ContactsPage extends TestBase {

	@FindBy(xpath = "//td[contains(text(), 'Contacts')]")
	@CacheLookup 
	WebElement visiblecontact;
	
	@FindBy(name = "title")
	WebElement title;
	
	@FindBy(id = "first_name")
	WebElement firstname;
	
	@FindBy(id = "surname")
	WebElement sirname;
	
	@FindBy(id = "company_position")
	WebElement company;
	
	@FindBy(xpath = "//*[@id=\"contactForm\"]/table/tbody/tr[1]/td/input[2]")
	WebElement save;

	public ContactsPage()
	{
		PageFactory.initElements(driver, this);


	}
	
	public boolean verifyContactPage()
	{
		return visiblecontact.isDisplayed();
	}
	
	public void createNewcontact(String titlee, String fname, String lname, String companyn)
	
	{
		Select select = new Select(title);
		select.selectByVisibleText(titlee);
		
		firstname.sendKeys(fname);
		sirname.sendKeys(lname);
		company.sendKeys(companyn);
		save.click();
	}

}
