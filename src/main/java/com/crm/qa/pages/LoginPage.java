package com.crm.qa.pages;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase{


	//page factory or Object repo

	@FindBy(name = "username")
	WebElement username;

	@FindBy(name = "password")
	WebElement password;

	@FindBy(xpath = "//input[@type = \"submit\"]")
	WebElement loginbtn;

	@FindBy(xpath = "//a[contains(text(), \"Sign Up\")]")
	WebElement Signupbtn;

	@FindBy(xpath = "//img[@class = \"img-responsive\" and @alt = \"Free CRM Software for customer relationship management, sales and support\"]")
	WebElement CRMlogo;

	//Initializing page object
	public LoginPage()
	{
		PageFactory.initElements(driver, this);
	}

	//Feature
	public String validateLoginpage()

	{
		return driver.getTitle();
	}

	public boolean validateCRMlogo()

	{
		return CRMlogo.isDisplayed();
	}
	
	public HomePage login(String un, String ps)
	
	{
		username.sendKeys(un);
		password.sendKeys(ps);
		loginbtn.click();
		
		return new HomePage();
	}








}
